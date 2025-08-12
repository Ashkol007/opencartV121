package utilities;

import java.util.Properties;


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;


public class EmailVerification {
	
	public static void gmailInboxVerification() {
		String host = "imap.gmail.com";
	    String username = "ashitoshkole007@gmail.com"; // Your Gmail address
	    String appPassword = "dokc yhnr bbnd lbbb"; // Generated App password

	    Properties props = new Properties();
	    props.put("mail.store.protocol" , "imaps");
	    props.put("mail.imaps.host", host);
	    props.put("mail.imaps.port", "993");
	    props.put("mail.imaps.ssl.enable", "true");

	    try {
	        Session session = Session.getInstance(props);
	        Store store = session.getStore("imaps");
	        store.connect(host, username, appPassword);

	        Folder inbox = store.getFolder("INBOX");
	        inbox.open(Folder.READ_ONLY);

	        Message[] messages = inbox.getMessages();
	        
	        Boolean found = false;

	        for (int i = messages.length - 1; i < messages.length; i++) { // Last 5 emails
	            Message message = messages[i];
	            String subject = message.getSubject();
	            String from = ((InternetAddress) message.getFrom()[0]).getAddress();
	            String body = message.getContent().toString();
                 
	            
	            if(message.getSubject().contains("amazon.in: Password recovery")) {
	            	found = true;
	            	System.out.println("From: " + from);
	                System.out.println("Subject: " + subject);
	                System.out.println("Body: " + body);
	                System.out.println("----------------------------------");
	                break;
	            }
	        }
	        
	        if(!found) {
	        	System.out.println("No confirmation email found!!! ");
	        }

	        inbox.close(false);
	        store.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
}
