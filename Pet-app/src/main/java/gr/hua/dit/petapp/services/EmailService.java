package gr.hua.dit.petapp.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import gr.hua.dit.petapp.repositories.EmailRepository;
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
    public void sendVisitRequestEmail(String citizenName, String shelterEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(shelterEmail); // Email καταφυγίου
        message.setSubject("Αίτημα Επίσκεψης από Πολίτη");

        // Προκαθορισμένο μήνυμα
        String text = "Ο πολίτης " + citizenName + " εκφράζει ενδιαφέρον για επίσκεψη στο χώρο σας. " +
                "\nΠαρακαλώ επικοινωνήστε μαζί του για να κανονιστεί η επίσκεψη.\n" +
                "\nΜε εκτίμηση,\nΗ Ομάδα PetApp";

        message.setText(text);
        mailSender.send(message);
    }
}
