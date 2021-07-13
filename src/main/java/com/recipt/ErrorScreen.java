package com.recipt;

import java.awt.*;
import java.awt.event.*;

final public class ErrorScreen implements ActionListener {

    Frame f = new Frame("Error!");

    ErrorScreen(String error) {
        // Fonts:
        Font bigFont = new Font("Serif", Font.BOLD, 16);

        //Labels:
        Label err = new Label(error);
        err.setBounds(50, 60, 350, 20);
        err.setFont(bigFont);

        //Buttons:
        Button ok = new Button("Ok");
        ok.setBounds(150, 90, 100, 30);
        ok.addActionListener(this);

        //Frame Configuration:
        f.setSize(400, 150);
        f.add(err);
        f.add(ok);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        f.dispose();
    }
}
