import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class MailUtil {
    static void sendMail(String recipient) throws MessagingException {
        System.out.println("Preparing to send Mail.............");
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "email@gmail.com";
        String password = "password";
    
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        Message message = prepareMessage(session, myAccountEmail, recipient);
        if (message != null) {
            Transport.send(message);
            System.out.println("Message Sent Successfully.........");
        } else
            System.out.println("Message Sent Failed!!!!!!!!!!!!!!!");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("My First Email from Java App");
            message.setText("Sample Text");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
