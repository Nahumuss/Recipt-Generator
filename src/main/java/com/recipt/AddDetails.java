package com.recipt;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

final class AddDetails implements ActionListener {

    public static Frame f2 = new Frame();
    public static TextField t1 = new TextField();

    public AddDetails() {

        // Labels:
        Label l = new Label("Input Service Details");
        l.setBounds(50, 30, 200, 20);

        // Buttons:
        Button ok = new Button("Ok");
        ok.setBounds(150, 90, 100, 30);
        ok.addActionListener(this);
        t1.setBounds(50, 60, 300, 20);

        // WindowListeners:
        WindowListener wndwclose = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f2.dispose();
            }
        };

        f2.addWindowListener(wndwclose);

        // Frame Configuration:
        f2.setSize(400, 150);
        f2.add(ok);
        f2.add(t1);
        f2.add(l);
        f2.setLayout(null);
        f2.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (Details.duplicateChecker(Details.detailCounter(MainMenu.details), t1.getText())) {
                new ErrorScreen("Error: Same Name For Two Checkboxes");
            } else {
                FileWriter detailWriter = new FileWriter(MainMenu.details, true);
                detailWriter.write(t1.getText() + "\n");
                detailWriter.close();
                Details.checkboxConfig(Details.detailCounter(MainMenu.details));
                f2.dispose();
            }
        } catch (IOException x) {
            x.printStackTrace();
        }
        t1.setText("");
    }
}
