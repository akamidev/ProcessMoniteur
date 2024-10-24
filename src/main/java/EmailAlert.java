import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailAlert {

    public static void sendEmail(String processName, long memoryUsed) {
        String to = "akamimehdi.dev@gmail.com";  // choisir votre Adresse email du destinataire
        String from = "midoaka7@gmail.com";  // choisir votre Adresse email de l'expéditeur
        String host = "smtp--gmail.com";  // choisir le bon Serveur SMTP de Gmail

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "7"); // choisir votre le bon Port pour TLS
        properties.setProperty("mail.smtp.auth", "true"); // Authentification requise
        properties.put("mail.smtp.starttls.enable", "true"); // Active TLS

        String username = "akamimehdi.dev@gmail.com";  // Votre adresse email
        String password = "your-password";  // choisir  Votre mot de passe generer avec votre compte gmail

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Alerte: Processus mémoire élevée");
            message.setText("Le processus " + processName + " utilise " + memoryUsed / (1024 * 1024) + " MB de mémoire.");

            Transport.send(message);
            System.out.println("Email envoyé avec succès.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
