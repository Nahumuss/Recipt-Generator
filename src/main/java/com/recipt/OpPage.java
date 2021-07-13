package com.recipt;

import java.awt.event.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpPage extends MainMenu {

    static Button change1 = new Button("Change BN");
    static Button change2 = new Button("Change RN");
    static Button change3 = new Button("Change CY");
    static Label bus = new Label("Business Number:");
    static Label rec = new Label("Reciept Number:");
    static Label cur = new Label("Currency:");
    static Label business_num = new Label();
    static Label reciept_num = new Label();
    static Label currency = new Label();
    static Label email = new Label("Email Addr.");

    OpPage() throws FileNotFoundException {

        Scanner bus_Scanner = new Scanner(bn);
        Scanner rec_Scanner = new Scanner(rn);
        Scanner cy_Scanner = new Scanner(cy);
        business_num.setText(bus_Scanner.nextLine());
        reciept_num.setText(rec_Scanner.nextLine());
        currency.setText(cy_Scanner.nextLine());
        bus_Scanner.close();
        rec_Scanner.close();
        cy_Scanner.close();

        // Labels:
        title.setBounds(50, 50, 150, 20);
        title.setFont(bigFont);
        bus.setBounds(50, 100, 125, 20);
        bus.setFont(bigFont);
        rec.setBounds(50, 150, 125, 20);
        rec.setFont(bigFont);
        cur.setBounds(50, 200, 80, 20);
        cur.setFont(bigFont);
        business_num.setBounds(180, 100, 200, 20);
        reciept_num.setBounds(180, 150, 200, 20);
        currency.setBounds(130, 200, 200, 20);
        email.setBounds(100, 300, 80, 20);
        email.setFont(bigFont);

        // TextFields:
        text1.setBounds(200, 50, 100, 20);
        text2.setBounds(200, 300, 100, 20);

        // Buttons:
        change1.setBounds(400, 100, 80, 20);
        change2.setBounds(400, 150, 80, 20);
        change3.setBounds(400, 200, 80, 20);

        // Action Listeners:
        ActionListener change_listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(change1.getLabel())) {
                    OpLabConfig.change_index = 1;
                    OpLabConfig.l.setText("Input Business Number");
                    new OpLabConfig();
                } else if (e.getActionCommand().equals(change2.getLabel())) {
                    OpLabConfig.change_index = 2;
                    OpLabConfig.l.setText("Input New Reciept Number");
                    new OpLabConfig();
                } else if (e.getActionCommand().equals(change3.getLabel())) {
                    OpLabConfig.change_index = 3;
                    OpLabConfig.l.setText("Input Currency");
                    new OpLabConfig();
                }
            }
        };

        // Adding Action Listeners:
        change1.addActionListener(change_listener);
        change2.addActionListener(change_listener);
        change3.addActionListener(change_listener);

        // Frame Configuration:
        f.setBounds(500, 200, 500, 500);
        f.setTitle("Welcome to Receipt Creator!");
        OpPage.text2.setText("");
        f.add(title);
        f.add(bus);
        f.add(business_num);
        f.add(rec);
        f.add(reciept_num);
        f.add(cur);
        f.add(currency);
        f.add(text1);
        f.add(change1);
        f.add(change2);
        f.add(change3);
        f.add(email);
        f.add(text2);
        f.remove(c1);
        f.remove(c2);
        f.remove(c3);
        f.remove(c4);
        f.remove(c5);
        f.remove(EndMenu.scrnsht);
        f.remove(EndMenu.another_rec);
        f.setLayout(null);
        f.setVisible(true);
    }
}
