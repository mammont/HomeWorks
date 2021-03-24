package Level1.HomeWork8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {
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
                else {
                    result = 0;
                }
                break;
            case "/=":
                if (variable != 0) result /= variable;
                else result = 0;
                break;
            case "X^Y":
                result = Math.pow(result, variable);
                break;
            case "X^Y=":
                result = Math.pow(result, variable);
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
                if (operator.equals("") && in.getText().equals("0")) in.setText("-");
                else {
                    operator = "-";
                    result = Double.parseDouble(in.getText());
                    in.setText("0");
                }
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
            case "X^2":
                operator = "";
                result = Double.parseDouble(in.getText()) * Double.parseDouble(in.getText());
                in.setText(String.valueOf(result));
                System.out.println("Во вторую степень");
                break;
            case "X^Y":
                operator = "X^Y";
                result = Double.parseDouble(in.getText());
                in.setText("0");
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
