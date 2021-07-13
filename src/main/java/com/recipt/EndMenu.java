package com.recipt;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EndMenu extends MainMenu {

    // Buttons:
    static Button scrnsht = new Button("Get the Reciept");
    static Button another_rec = new Button("Generate Next");
    static Button send_rec = new Button("Send Reciept");

    EndMenu() {

        scrnsht.setBounds(50, 100, 350, 70);
        another_rec.setBounds(50, 190, 350, 70);
        send_rec.setBounds(50, 280, 350, 70);

        // ActionListeners:
        ActionListener scrnshtListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Reciept.f.setBounds(0, 0, 500, 500);
                try {
                    Reciept.takeScreenShot();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        };

        ActionListener another_Listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Reciept.f.dispose();
                f.dispose();
                try {
                    MainMenu.submit.setLabel("Continue");
                    MainMenu.submit_index = 0;
                    MainMenu.text1.setText("");
                    Details.c1.setState(false);
                    Details.c2.setState(false);
                    Details.c3.setState(false);
                    Details.c4.setState(false);
                    Details.c5.setState(false);
                    Details.t1.setText("");
                    Details.t2.setText("");
                    Details.t3.setText("");
                    Details.t4.setText("");
                    Details.t5.setText("");
                    Details.priceField.setText("");
                    new OpPage();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        };

        ActionListener send_mail = new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                try {
                    Reciept.takeScreenShot();
                } catch (AWTException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                MailMan m = new MailMan();
                m.sendMail(text2.getText(), "Reciept From Buisness: " + "Liad Or", "This is an auto generated reciept. If there are any errors please contact the business as soon as possible");
            }

        };

        another_rec.addActionListener(another_Listener);
        send_rec.addActionListener(send_mail);
        f.add(send_rec);
        f.add(another_rec);
        f.remove(text1);
        f.remove(title);
        f.remove(Details.title2);
        f.remove(Details.service_other);
        f.remove(Details.service_remove);
        f.remove(Details.cc);
        f.remove(c1);
        f.remove(c2);
        f.remove(c3);
        f.remove(c4);
        f.remove(c5);
        f.remove(t1);
        f.remove(t2);
        f.remove(t3);
        f.remove(t4);
        f.remove(t5);
        f.remove(Details.pmethod);
        f.remove(Details.priceField);
        f.remove(Details.pricetitle);
        // f.remove(Details.choice_add);
        f.add(scrnsht);
        scrnsht.addActionListener(scrnshtListener);
        submit.setLabel("Exit");
    }
}
