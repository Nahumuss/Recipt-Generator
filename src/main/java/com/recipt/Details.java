package com.recipt;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Details extends MainMenu {

    private static String data = "";

    // Buttons:
    static Button service_other = new Button("Add Other");
    static Button service_remove = new Button("Remove Boxes");
    //static Button choice_add = new Button("Add Other");

    // Labels:
    static Label title2 = new Label("Quantity:");
    static Label pricetitle = new Label("Price:");
    static Label pmethod = new Label("Payment Method:");

    // TextFields:
    static TextField priceField = new TextField();

    // Choices:
    static Choice cc = new Choice();

    public Details() {

        // Labels:
        title2.setBounds(300, 50, 150, 20);
        title2.setFont(bigFont);
        pricetitle.setBounds(300, 350, 150, 30);
        pricetitle.setFont(bigFont);
        pmethod.setBounds(300, 240, 150, 30);
        pmethod.setFont(bigFont);

        // Checkbox Bounds:
        c1.setBounds(50, 100, 100, 20);
        c2.setBounds(50, 130, 100, 20);
        c3.setBounds(50, 160, 100, 20);
        c4.setBounds(50, 190, 100, 20);
        c5.setBounds(50, 220, 100, 20);

        // TextField Bound:
        priceField.setBounds(300, 400, 100, 25);
        t1.setBounds(300, 100, 100, 20);
        t2.setBounds(300, 130, 100, 20);
        t3.setBounds(300, 160, 100, 20);
        t4.setBounds(300, 190, 100, 20);
        t5.setBounds(300, 220, 100, 20);

        // Buttons:
        title.setText("Details:");
        service_other.setBounds(50, 270, 100, 30);
        service_remove.setBounds(50, 310, 100, 30);
        //choice_add.setBounds(300, 310, 100, 30);

        // ActionListeners:
        ActionListener addanother_Listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    if (detailCounter(OpPage.details).length >= 6) {
                        new ErrorScreen("Cannot Make More than 5 Checkboxes");
                    } else {
                        new AddDetails();
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        };
        ActionListener removeanother_Listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    Details.clearCheckboxs();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };

        ItemListener c_Listener = new ItemListener() {
            public void itemStateChanged(ItemEvent i) {
                if (i.getItem().equals(c1.getLabel())) {
                    if (c1.getState()) {
                        f.add(t1);
                    } else {
                        f.remove(t1);
                    }
                } else if (i.getItem().equals(c2.getLabel())) {
                    if (c2.getState()) {
                        f.add(t2);
                    } else {
                        f.remove(t2);
                    }
                } else if (i.getItem().equals(c3.getLabel())) {
                    if (c3.getState()) {
                        f.add(t3);
                    } else {
                        f.remove(t3);
                    }
                } else if (i.getItem().equals(c4.getLabel())) {
                    if (c4.getState()) {
                        f.add(t4);
                    } else {
                        f.remove(t4);
                    }
                } else if (i.getItem().equals(c5.getLabel())) {
                    if (c5.getState()) {
                        f.add(t5);
                    } else {
                        f.remove(t5);
                    }
                }
            }
        };

        // Adding ActionListeners:
        c1.addItemListener(c_Listener);
        c2.addItemListener(c_Listener);
        c3.addItemListener(c_Listener);
        c4.addItemListener(c_Listener);
        c5.addItemListener(c_Listener);
        service_other.addActionListener(addanother_Listener);
        service_remove.addActionListener(removeanother_Listener);

        // Frame Configuration:
        try {
            checkboxConfig(detailCounter(details));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        f.add(priceField);
        f.add(title2);
        f.add(pricetitle);
        f.add(cc);
        f.add(pmethod);
        f.add(service_other);
        f.add(service_remove);
        //f.add(choice_add);
        f.add(title);
        f.remove(OpPage.change1);
        f.remove(OpPage.change2);
        f.remove(OpPage.change3);
        f.remove(OpPage.bus);
        f.remove(OpPage.rec);
        f.remove(OpPage.cur);
        f.remove(OpPage.business_num);
        f.remove(OpPage.reciept_num);
        f.remove(OpPage.currency);
        f.remove(text1);
        f.remove(text2);
        f.remove(OpPage.email);
        submit.setLabel("Generate");
    }

    /**
     * 
     * @param storage A File in which the details are Located at
     * @return An array of Strings containing the data from the file, seperated by
     *         "\n"
     * @throws FileNotFoundException
     */
    public static String[] detailCounter(File storage) throws FileNotFoundException {
        Scanner detailScanner = new Scanner(storage);
        data = "";
        while (detailScanner.hasNext()) {
            detailScanner.useDelimiter("\n");
            data = data + "\n" + detailScanner.next();
        }
        detailScanner.close();
        String[] dataStorage = data.split("\n");
        return dataStorage;
    }

    /**
     * Deletes all checkboxes(Can program defaults if wanted)
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void clearCheckboxs() throws IOException {
        FileWriter clearer = new FileWriter(OpPage.details);
        clearer.write("");
        clearer.close();
        String[] s = new String[] { "", "", "", "", "", "" };
        checkboxConfig(s);
        MainMenu.f.remove(MainMenu.c1);
        MainMenu.f.remove(MainMenu.c2);
        MainMenu.f.remove(MainMenu.c3);
        MainMenu.f.remove(MainMenu.c4);
        MainMenu.f.remove(MainMenu.c5);
    }

    /**
     * 
     * @param dataStorage A String Array That Contains The Data to be Added to
     *                    Chekboxes c1 - c5.
     */
    public static void checkboxConfig(String[] dataStorage) {
        for (int i = 0; i < dataStorage.length; i++) {
            if (i == 1) {
                MainMenu.c1.setLabel(dataStorage[i]);
                MainMenu.f.add(MainMenu.c1);
            }
            if (i == 2) {
                MainMenu.c2.setLabel(dataStorage[i]);
                MainMenu.f.add(MainMenu.c2);
            }
            if (i == 3) {
                MainMenu.c3.setLabel(dataStorage[i]);
                MainMenu.f.add(MainMenu.c3);
            }
            if (i == 4) {
                MainMenu.c4.setLabel(dataStorage[i]);
                MainMenu.f.add(MainMenu.c4);
            }
            if (i == 5) {
                MainMenu.c5.setLabel(dataStorage[i]);
                MainMenu.f.add(MainMenu.c5);
            }
        }
    }

    /**
     * A Method to Check if the given string is already found at the given array of
     * strings
     * 
     * @param data    The String arry to be checked
     * @param message The messege to search for
     * @return true if the message is found at the given arry, false otherwise
     */
    public static boolean duplicateChecker(String[] data, String message) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(message)) {
                return true;
            }
        }
        return false;
    }
}
