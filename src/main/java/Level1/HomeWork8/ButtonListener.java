package Level1.HomeWork8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField in;

    public ButtonListener(JTextField in) {
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        StringBuilder stringBuilder = new StringBuilder(in.getText());
        System.out.println(btn.getText());

        if (btn.getText().equals("0") && in.getText().equals("0")) {
            stringBuilder.deleteCharAt(0);
        }
        else if (in.getText().length()>=16);

        else if (!btn.getText().equals("0") && in.getText().equals("0")) {
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(btn.getText());
            in.setText(stringBuilder.toString());
        }
        else {
            stringBuilder.append(btn.getText());
            in.setText(stringBuilder.toString());
        }
    }
}
