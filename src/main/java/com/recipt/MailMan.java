package com.recipt;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class MailMan {

   final static String sender = "liadordonotreply@gmail.com";
   Session session = null;

   public MailMan() {
      if (session == null) {
         init();
      }
   }

   public void init() {

      Properties props = new Properties();
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.socketFactory.port", "465");
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "465");

      session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(sender, "liadbuis");
         }
      });
      if (session != null) {
         System.out.println("[OK]");
      } else {
         System.out.println("[NOK]");
      }
   }

   public void sendMail(String to, String subject, String messageText) {
      if (session == null) {
         System.exit(0);
      }
      try {
         Message message = new MimeMessage(session);
         try {
            message.setFrom(new InternetAddress("no-reply", "No Reply"));
         } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
         }

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(sender));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject(subject);

         // This mail has 2 part, the BODY and the embedded image
         MimeMultipart multipart = new MimeMultipart("related");

         // first part (the html)
         BodyPart messageBodyPart = new MimeBodyPart();
         String htmlText = "<p>" + messageText + "</p><img src=\"cid:reciept\">";
         messageBodyPart.setContent(htmlText, "text/html");
         // add it
         multipart.addBodyPart(messageBodyPart);

         // second part (the image)
         messageBodyPart = new MimeBodyPart();
         DataSource fds = new FileDataSource("C:/RecieptCreator Data Storage/Reciept" + String.valueOf(Reciept.i) + ".png");

         messageBodyPart.setDataHandler(new DataHandler(fds));
         messageBodyPart.setHeader("Reciept:", "<reciept>");

         // add image to the multipart
         multipart.addBodyPart(messageBodyPart);

         // put everything together
         message.setContent(multipart);
         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");


      } catch (MessagingException e) {
         e.printStackTrace();
         System.out.println("Not Sent...");
      }
   }
}