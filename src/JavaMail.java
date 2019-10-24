import javax.mail.MessagingException;

public class JavaMail {
    public static void main(String[] args) throws MessagingException {
        MailUtil.sendMail("email@gmail.com");
    }
}
