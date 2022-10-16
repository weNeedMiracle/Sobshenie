import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws MessagingException, IOException {
        Properties p = new Properties();
        p.load(Main.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session ms = Session.getDefaultInstance(p);
        MimeMessage m = new MimeMessage(ms);
        m.setFrom(new InternetAddress());
        m.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress("")));
        m.setSubject("123");
        m.setText("321");

        Transport t = ms.getTransport();
        t.connect( "", "");
        t.sendMessage(m, m.getAllRecipients());
        t.close();
    }
}
