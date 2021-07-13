package com.recipt;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

final class OpLabConfig {

    final Frame f = new Frame();
    public static TextField change_name = new TextField();
    public static int change_index = 0;
    static Label l = new Label();

    OpLabConfig() {

        change_name.setBounds(50, 60, 300, 20);
        Button ok = new Button("Ok");
        ok.setBounds(150, 90, 100, 30);
        l.setBounds(50, 35, 300, 20);
        ActionListener ok_listener = new ActionListener() {

            public void actionPerformed(ActionEvent a) {

                if (change_index == 1) {
                    if (change_name.getText().equals("")) {
                        ldkWriter(MainMenu.bn, "213955578", OpPage.business_num);
                    } else {
                        ldkWriter(MainMenu.bn, change_name.getText(), OpPage.business_num);
                    }
                } else if (change_index == 2) {
                    if (change_name.getText().equals("")) {
                        ldkWriter(MainMenu.rn, "0", OpPage.reciept_num);
                    } else {
                        ldkWriter(MainMenu.rn, change_name.getText(), OpPage.reciept_num);
                    }
                } else if (change_index == 3) {
                    if (change_name.getText().equals("")) {
                        ldkWriter(MainMenu.cy, "NIS", OpPage.currency);
                    } else {
                        ldkWriter(MainMenu.cy, change_name.getText(), OpPage.currency);
                    }
                }
                f.dispose();
                change_index = 0;
            }
        };
        ok.addActionListener(ok_listener);
        f.setSize(400, 150);
        f.add(ok);
        f.add(l);
        f.add(change_name);
        f.setLayout(null);
        f.setVisible(true);

    }

    /**
     * A Method that writes a message in a File, and changes the given label into
     * the new message
     * 
     * @param path    The file to write into
     * @param message the message to write
     * @param ui      the label to change
     */
    public static void ldkWriter(File path, String message, Label ui) {
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(path);
            myWriter.write(message);
            myWriter.close();
            ui.setText(message);
        } catch (IOException e) {
            System.out.println("Error Writing To File " + path);
            e.printStackTrace();
        }
        change_name.setText("");
    }
}
