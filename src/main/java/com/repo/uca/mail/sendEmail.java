package com.repo.uca.mail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class sendEmail {

    public static String sendMail(Mail classCorreo) {

        Session mailSession = null;
        final String usuario = classCorreo.getFrom();
        final String pass = classCorreo.getPsswd();
        Properties propiedades = new Properties();

        String[] dominio = usuario.split("@");
        System.out.println(dominio[1]);

        if (dominio[1].equals("hotmail.com")) {
            propiedades.put("mail.smtp.ssl.trust", "smtp.live.com ");
            propiedades.put("mail.smtp.host", "smtp.live.com");
        } else if (dominio[1].equals("gmail.com")) {
            propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            propiedades.put("mail.smtp.host", "smtp.gmail.com");
        } else if (dominio[1].equals("yahoo.com")) {
            propiedades.put("mail.smtp.ssl.trust", "smtp.mail.yahoo.com");
            propiedades.put("mail.smtp.host", "smtp.mail.yahoo.com");
        }

        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.debug", "true");
        propiedades.put("mail.smtp.port", 25);
        propiedades.put("mail.smtp.socketFactory.port", 25);
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.transport.protocol", "smtp");

        mailSession = Session.getInstance(propiedades, new javax.mail.Authenticator() 
        {
            //SMTPAuthentication, que es la clase que se encarga de proporcionar el nombre de usuario y clave de acceso al servidor SMTP.     
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(usuario, pass);
            }
        });

        try 
        {
            Transport transport = mailSession.getTransport();
            MimeMessage message = new MimeMessage(mailSession);

            message.setSubject(classCorreo.getAsunto());
            message.setFrom(new InternetAddress(classCorreo.getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(classCorreo.getTo()));
            message.setContent(classCorreo.getMensaje(), "text/html");

            transport.connect();
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();

            return "1";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "0";
        }
    }
}
