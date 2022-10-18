import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailSSL {

    public static void main(String[] args) {
        final String fromEmail = "";
        final String password = "";
        final String toEmail = "";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mail.ru"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        Random rd = new Random();
        int parol = rd.nextInt(99999)+600000;
        EmailUn.sendEmail(session, toEmail,"Parol", String.valueOf(parol));
    }

}
