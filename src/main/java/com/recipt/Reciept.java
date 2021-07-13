package com.recipt;

import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class Reciept {

      static MyFrame f = new MyFrame();
      static ImageIcon signature = new ImageIcon("C:/RecieptCreator Data Storage/Signature.jpg");
      static Label rec = new Label("Reciept No. " + OpPage.reciept_num.getText());
      static int i = 0;

      WindowListener wl = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                  System.exit(0);
            }
      };

      Reciept() {

            // Fonts:
            Font pricefont = new Font("Serif", Font.BOLD, 16);
            Font bigFont = new Font("David", Font.BOLD, 13);

            // Decoration Labels:
            Label dec1 = new Label("--------------------------------------------------");
            dec1.setBounds(50, 125, 200, 20);
            Label dec2 = new Label("--------------------------------------------------");
            dec2.setBounds(50, 175, 200, 20);
            Label dec3 = new Label(
                        "----------------------------------------------------------------------------------------------------------------");
            dec3.setBounds(50, 250, 380, 10);
            Label dec4 = new Label(
                        "----------------------------------------------------------------------------------------------------------------");
            dec4.setBounds(50, 410, 380, 10);

            // Customer Name Disp Config:
            Label name = new Label("Customer Name:");
            name.setBounds(50, 100, 120, 40);
            name.setFont(bigFont);
            Label cn = new Label(MainMenu.text1.getText());
            cn.setBounds(180, 100, 100, 40);

            // Business Number Disp Config:
            Label bus_num = new Label("Business Number:");
            bus_num.setBounds(50, 150, 120, 20);
            bus_num.setFont(bigFont);
            Label bn = new Label(OpPage.business_num.getText());
            bn.setBounds(170, 150, 100, 20);

            // Service Details Disp Config:
            Label service = new Label("Details:");
            service.setBounds(50, 270, 200, 10);
            service.setFont(bigFont);
            Label dets1 = new Label();
            dets1.setBounds(50, 290, 200, 30);
            if (Details.c1.getState() == true) {
                  dets1.setText(Details.c1.getLabel());
            }
            Label dets2 = new Label();
            dets2.setBounds(50, 310, 200, 30);
            if (Details.c2.getState() == true) {
                  dets2.setText(Details.c2.getLabel());
            }
            Label dets3 = new Label();
            dets3.setBounds(50, 330, 200, 30);
            if (Details.c3.getState() == true) {
                  dets3.setText(Details.c3.getLabel());
            }
            Label dets4 = new Label();
            dets4.setBounds(50, 350, 200, 30);
            if (Details.c4.getState() == true) {
                  dets4.setText(Details.c4.getLabel());
            }
            Label dets5 = new Label();
            dets5.setBounds(50, 370, 200, 30);
            if (Details.c5.getState() == true) {
                  dets5.setText(Details.c5.getLabel());
            }

            // Service Qty. Disp Config:
            Label qty = new Label("Qty.");
            qty.setBounds(345, 260, 100, 30);
            qty.setFont(bigFont);
            Label qty1 = new Label("| " + Details.t1.getText() + " |");
            qty1.setBounds(350, 290, 100, 30);
            Label qty2 = new Label("| " + Details.t2.getText() + " |");
            qty2.setBounds(350, 310, 100, 30);
            Label qty3 = new Label("| " + Details.t3.getText() + " |");
            qty3.setBounds(350, 330, 100, 30);
            Label qty4 = new Label("| " + Details.t4.getText() + " |");
            qty4.setBounds(350, 350, 100, 30);
            Label qty5 = new Label("| " + Details.t5.getText() + " |");
            qty5.setBounds(350, 370, 100, 30);

            // Payment Method Disp Config:
            Label payment = new Label("Payment Method:");
            payment.setBounds(50, 200, 200, 40);
            payment.setFont(bigFont);
            Label pay_method = new Label(Details.cc.getItem(Details.cc.getSelectedIndex()));
            pay_method.setBounds(170, 200, 150, 40);

            // Price Disp Config:
            Label price_Label = new Label("Price:");
            price_Label.setBounds(280, 430, 200, 40);
            price_Label.setFont(MainMenu.smallFont);
            Label p = new Label(Details.priceField.getText() + " " + OpPage.currency.getText());
            p.setBounds(330, 430, 200, 40);
            p.setFont(pricefont);

            // Date & Signatue Configuration:
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime now = LocalDateTime.now();
            Label time = new Label(dtf.format(now));
            time.setBounds(330, 80, 200, 20);
            time.setFont(MainMenu.smallFont);
            Label sig = new Label("Signature:");
            sig.setBounds(50, 435, 80, 20);
            sig.setFont(bigFont);

            // Reciept Number Config:
            rec.setFont(bigFont);
            rec.setBounds(345, 200, 200, 40);

            i = Integer.parseInt(OpPage.reciept_num.getText());
            i++;
            OpLabConfig.ldkWriter(MainMenu.rn, String.valueOf(i), OpPage.reciept_num);
            i--;

            // Frame Configuration:
            f.setTitle("Reciept");
            f.setLocation(0, 0);
            f.setSize(500, 500);
            f.addWindowListener(wl);
            f.add(rec);
            f.add(dets1);
            f.add(pay_method);
            f.add(time);
            f.add(sig);
            f.add(p);
            f.add(bus_num);
            f.add(bn);
            f.add(dec1);
            f.add(dec2);
            f.add(dec3);
            f.add(dec4);
            f.add(dets1);
            f.add(dets2);
            f.add(dets3);
            f.add(dets4);
            f.add(dets5);
            f.add(qty);
            f.add(qty1);
            f.add(qty2);
            f.add(qty3);
            f.add(qty4);
            f.add(qty5);
            f.add(name);
            f.add(cn);
            f.add(service);
            f.add(payment);
            f.add(price_Label);
            f.setAlwaysOnTop(true);
            f.setLayout(null);
            f.setVisible(true);
      }

      public static void takeScreenShot() throws AWTException, IOException {
            Robot awt_robot = new Robot();
            BufferedImage Reciept = awt_robot.createScreenCapture(new Rectangle(10, 20, 470, 470));
            ImageIO.write(Reciept, "PNG", new File(MainMenu.rcds, "Reciept" + String.valueOf(i) + ".png"));
      }

      static class MyFrame extends Frame {
            @Override
            public void paint(Graphics g) {
                  g.drawImage(signature.getImage(), 125, 430, this);
            }
      }
}