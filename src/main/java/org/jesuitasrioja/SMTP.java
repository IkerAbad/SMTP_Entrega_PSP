package org.jesuitasrioja;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SMTP {
    public static void main(String[] args) {
        // Los datos de la cuenta se leen de variables de entorno para no dejar credenciales en el código:
        // SMTP_USER (cuenta de Gmail), SMTP_PASS (clave de aplicación) y SMTP_TO (destinatario).
        String remitente = System.getenv("SMTP_USER");
        String clave = System.getenv("SMTP_PASS");
        String destinatario = System.getenv("SMTP_TO");
        if (remitente == null || clave == null || destinatario == null) {
            System.err.println("Faltan las variables de entorno SMTP_USER, SMTP_PASS o SMTP_TO.");
            System.exit(1);
        }

        String asunto = "Correo de prueba SMTP";
        String cuerpo = "Esta es una prueba de correo para la entrega de la asignatura de PSP." +
                "\n\n\tIker Abad";

        enviarConGMail(remitente, clave, destinatario, asunto, cuerpo);
    }

    private static void enviarConGMail(String remitente, String clave, String destinatario, String asunto, String cuerpo) {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
}
