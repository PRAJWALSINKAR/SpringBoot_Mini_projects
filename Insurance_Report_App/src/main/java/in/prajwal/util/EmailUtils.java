package in.prajwal.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String Subject,String body,String to,File f) {
		
		try {
			// Create a new email object.
			MimeMessage mimemsg = mailSender.createMimeMessage();
			//You want to send a multipart email (i.e., text + attachments).
			MimeMessageHelper helper = new MimeMessageHelper(mimemsg , true);
			helper.setSubject(Subject);
			helper.setText(body, true);
			helper.setTo(to);
			helper.addAttachment("Plans-Info",f);
			mailSender.send(mimemsg);
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
}
