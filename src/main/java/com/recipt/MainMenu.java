package com.recipt;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MainMenu {

    final static Frame f = new Frame();

    // Files:
    final static File rcds = new File("C:\\RecieptCreator Data Storage");
    final static File bn = new File(rcds, "BuisnessNumber.ldk");
    final public static File rn = new File(rcds, "RecieptNumber.ldk");
    final public static File cy = new File(rcds, "Currency.ldk");
    final public static File details = new File(rcds, "details.ldk");

    // Chcekboxs:
    public static Checkbox c1 = new Checkbox();
    public static Checkbox c2 = new Checkbox();
    public static Checkbox c3 = new Checkbox();
    public static Checkbox c4 = new Checkbox();
    public static Checkbox c5 = new Checkbox();

    // Fonts:
    public static Font bigFont = new Font("Serif", Font.BOLD, 16);
    public static Font smallFont = new Font("David", 0, 13);

    // Labels:
    static Label title = new Label("Reciept For:");

    // TextFields:
    static TextField text1 = new TextField();
    static TextField text2 = new TextField();
    public static TextField t1 = new TextField();
    public static TextField t2 = new TextField();
    public static TextField t3 = new TextField();
    public static TextField t4 = new TextField();
    public static TextField t5 = new TextField();

    static int submit_index;

    // Buttons:
    static Button submit = new Button("Continue");

    MainMenu() {

        // TextFields:
        text1.setBounds(200, 100, 100, 20);

        // Buttons:
        submit.setBounds(50, 400, 100, 30);

        // WindowListeners:
        WindowListener wndwclose = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        // Adding WindowListeners:
        f.addWindowListener(wndwclose);

        // Frame Configuration:
        f.add(submit);
        f.setTitle("MainMenu");
    }

    static ActionListener submit_Listener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (submit_index == 0) {
                Reciept.rec.setText("Reciept No. " + OpPage.reciept_num.getText());
                new Details();
                submit_index++;
            } else if (submit_index == 1) {
                new EndMenu();
                new Reciept();
                submit_index++;
            } else if (submit_index == 2) {
                System.exit(0);
            }
        }

    };

    public static void main(String[] args) throws IOException {

        System.err.println("Creating Files");
        if (rcds.mkdir()) {
            System.err.println("Created Main Folder");
        } else
            System.out.println("Folder already Exists");
        if (bn.createNewFile()) {
            System.err.println("Created business number storage");
        } else
            System.out.println("File already Exists");
        if (rn.createNewFile()) {
            System.err.println("Created reciept number storage");
        } else
            System.out.println("File already Exists");
        if (cy.createNewFile()) {
            System.err.println("Created currency storage");
        } else
            System.out.println("File already Exists");
        if (details.createNewFile()) {
            System.out.println("Created details storage");
        } else
            System.out.println("File already Exists");

        // Choices:
        Details.cc.setBounds(300, 280, 100, 75);
        Details.cc.add("-----");
        Details.cc.add("Bank Deposit");
        Details.cc.add("Check");
        Details.cc.add("Cash");

        // Adding ActionListeners:
        submit.addActionListener(submit_Listener);
        new OpPage();
    }
}
