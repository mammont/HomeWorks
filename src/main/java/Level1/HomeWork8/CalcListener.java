package Level1.HomeWork8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {
    private final JTextField in;
    public double result = 0;
    public double variable = 0;
    public String operator = "";
    public boolean resetField = false;

    public CalcListener(JTextField in) {
        this.in = in;
    }

    public Double calculate(double result, double variable, String operator) {
        switch (operator){
            case "+":
                result += variable;
                break;
            case "+=":
                result += variable;
                break;
            case "-":
                result -= variable;
                break;
            case "-=":
                result -= variable;
                break;
            case "*":
                result *= variable;
                break;
            case "*=":
                result *= variable;
                break;
            case "/":
                if (variable != 0) result /= variable;
                else result = 0;
                break;
            case "/=":
                if (variable != 0) result /= variable;
                else result = 0;
                break;
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText());
        switch (btn.getText()) {
            case "+":
                operator = "+";
                result = Double.parseDouble(in.getText());
                System.out.println("Сложение");
                in.setText("0");
                break;
            case "-":
                operator = "-";
                result = Double.parseDouble(in.getText());
                in.setText("0");
                System.out.println("Вычитание");
                break;
            case "*":
                operator = "*";
                result = Double.parseDouble(in.getText());
                in.setText("0");
                System.out.println("Умножение");
                break;
            case "/":
                operator = "/";
                result = Double.parseDouble(in.getText());
                in.setText("0");
                System.out.println("Деление");
                break;
            case "=":
                if (operator.contains("=")) {
                    result = calculate(result, variable, operator);
                    in.setText(String.valueOf(result));
                }
                else {
                    variable = Double.parseDouble(in.getText());
                    System.out.println("========");
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
