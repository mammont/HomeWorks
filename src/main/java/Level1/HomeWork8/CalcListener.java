package Level1.HomeWork8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener extends Clear implements ActionListener {
    private final JTextField in;
    private double result = 0;
    private double variable = 0;
    private String operator = "";

    public CalcListener(JTextField in) {
        this.in = in;
    }

    private Double calculate(double result, double variable, String operator) {
        switch (operator){
            case "+":
            case "+=":
                result += variable;
                break;
            case "-":
            case "-=":
                result -= variable;
                break;
            case "*":
            case "*=":
                result *= variable;
                break;
            case "/":
            case "/=":
                if (variable != 0) result /= variable;
                else result = 0;
                break;
            case "X^Y":
            case "X^Y=":
                result = Math.pow(result, variable);
                break;
        }
        return result;
    }

    private void action(String btn){
        if (in.getText().equals("-")){
            in.setText("0");
        }
        if (!operator.equals("")) {
            variable = Double.parseDouble(in.getText());
            result = calculate(result, variable, operator);
            in.setText(String.valueOf(result));
        }
        else {
            result = Double.parseDouble(in.getText());
        }
        Clear.clear = true;
        operator = btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText());

        switch (btn.getText()) {
            case "+":
            case "*":
            case "/":
                action(btn.getText());
                break;
            case "-":
                if (operator.equals("") & in.getText().equals("0") | operator.contains("*") | operator.contains("/") |
                operator.contains("X^Y")) {
                    in.setText("-");
                    Clear.clear = false;
                }
                else {
                    action(btn.getText());
                    break;
                }
                break;
            case "X^2":
                operator = "";
                result = Math.pow(Double.parseDouble(in.getText()), 2);
                in.setText(String.valueOf(result));
                System.out.println("Во вторую степень");
                break;
            case "X^Y":
                operator = "X^Y";
                result = Double.parseDouble(in.getText());
                Clear.clear = true;
                System.out.println("X в степень Y");
                break;
            case "SQRT(x)":
                operator = "";
                result = Double.parseDouble(in.getText());
                if (result < 0) in.setText("0");
                else {
                    result = Math.sqrt(result);
                    in.setText(String.valueOf(result));
                    System.out.println("Извлечение квадратного корня");
                }
                break;
            case "=":
                if (operator.contains("=")) {
                    result = calculate(result, variable, operator);
                    in.setText(String.valueOf(result));
                }
                else {
                    variable = Double.parseDouble(in.getText());
                    result = calculate(result, variable, operator);
                    in.setText(String.valueOf(result));
                    operator = operator + "=";
                }
                System.out.println(operator);
                System.out.println(result);
                break;
            case "C":
                result = 0;
                variable = 0;
                operator = "";
                in.setText("0");
                break;
        }
    }
}
