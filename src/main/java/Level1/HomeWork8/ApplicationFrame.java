package Level1.HomeWork8;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {


    public ApplicationFrame() {
        setTitle("Calculator v1.0");
        setBounds(50, 50, 400, 500);
        setResizable(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        setLayout(new BorderLayout());

        JPanel top = createTop();
        add(top, BorderLayout.NORTH);

        Component component = top.getComponent(0);
        add(createBottom((JTextField) component), BorderLayout.CENTER);

        setVisible(true);
    }

    public JPanel createBottom(JTextField in) {
        JPanel bottom = new JPanel();

        bottom.setLayout(new GridLayout(5, 4));

        ButtonListener buttonListener = new ButtonListener(in);

        CalcListener calcListener = new CalcListener(in);

        for (int i = 7; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            bottom.add(btn);
        }
        JButton division = new JButton("/");
        division.addActionListener(calcListener);
        bottom.add(division);

        for (int i = 4; i <= 6; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            bottom.add(btn);
        }
        JButton multiplication = new JButton("*");
        multiplication.addActionListener(calcListener);
        bottom.add(multiplication);

        for (int i = 1; i <= 3; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            bottom.add(btn);
        }
        JButton minus = new JButton("-");
        minus.addActionListener(calcListener);
        bottom.add(minus);

        JButton point = new JButton(".");
        point.addActionListener(buttonListener);
        bottom.add(point);

        JButton btn = new JButton("0");
        btn.addActionListener(buttonListener);
        bottom.add(btn);


        JButton calc = new JButton("=");
        calc.addActionListener(calcListener);
        bottom.add(calc);

        JButton plus = new JButton("+");
        plus.addActionListener(calcListener);
        bottom.add(plus);

        JButton xPower2 = new JButton("X^2");
        xPower2.addActionListener(calcListener);
        bottom.add(xPower2);

        JButton xPowerY = new JButton("X^Y");
        xPowerY.addActionListener(calcListener);
        bottom.add(xPowerY);

        JButton sqrt = new JButton("SQRT(x)");
        sqrt.addActionListener(calcListener);
        bottom.add(sqrt);

        JButton clear = new JButton("C");
        clear.addActionListener(calcListener);
        bottom.add(clear);



        return bottom;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        JTextField in = new JTextField();
        in.setFont(new Font("Dialog", Font.PLAIN, 24));
        in.setHorizontalAlignment(JTextField.RIGHT);


        in.setEditable(false);


        top.add(in, BorderLayout.NORTH);
        in.setText("0");
        return top;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = menuBar.add(new JMenu("File"));
        JMenu menu1 = menuBar.add(new JMenu("Edit"));
        JMenu menu2 = menuBar.add(new JMenu("Help"));
        //menu.add(new JMenuItem("Power Safe Mode"));

        JMenuItem exit = menu.add(new JMenuItem("Exit"));

        JMenuItem copy = menu1.add(new JMenuItem("Copy"));
        JMenuItem paste = menu1.add(new JMenuItem("Paste"));

        JMenuItem about = menu2.add(new JMenuItem("About..."));
        exit.addActionListener(new ExitButtonListener());

        return menuBar;
    }
}
