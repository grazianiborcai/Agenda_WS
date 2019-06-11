package br.com.gda.common;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class EmailSender {	
	private String hostname;
	private String port;
	private String sender;
	private String password;
	private String recipient;
	private String subject;
	private String body;
	private Message emailMessage;
	
	
	public EmailSender setHostname(String param) {
		hostname = param;
		return this;
	}
	
	
	
	public EmailSender setPort(String param) {
		port = param;
		return this;
	}
	
	
	
	public EmailSender setSender(String param) {
		sender = param;
		return this;
	}
	
	
	
	public EmailSender setSenderPassword(String param) {
		password = param;
		return this;
	}
	
	
	
	public EmailSender setSenderRecipient(String param) {
		recipient = param;
		return this;
	}
	
	
	
	public EmailSender setSenderSubject(String param) {
		subject = param;
		return this;
	}
	
	
	
	public EmailSender setSenderBody(String param) {
		body = param;
		return this;
	}
	
	
	
	public EmailSender build() {
		checkAttr();		
		emailMessage = tryToBuild();
		return this;
	}
	
	
	
	public Message tryToBuild() {
		try {		
			Properties prop = buildProperty(hostname, port);
			Session session = buildSession(prop, sender, password);		
			return buildMessage(session, sender, recipient, body, subject);
			
		
		} catch (AddressException e) {
			logException(e);
			throw new IllegalStateException(e);			
		} catch (MessagingException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private Properties buildProperty(String host, String hostPort) {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", hostPort);
		prop.put("mail.smtp.ssl.trust", host);
		
		return prop;
	}
	
	
	
	private Session buildSession(Properties prop, String username, String psw) {
		return Session.getInstance(prop, new Authenticator() {		    
			@Override protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, psw);
		    }
		});
	}
	
	
	
	private Message buildMessage(Session session, String senderAddr, String recipientAddr, String msg, String msgSubject) throws AddressException, MessagingException {
		Message message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(senderAddr));
		message.setRecipients(
		  Message.RecipientType.TO, InternetAddress.parse(recipientAddr));
		message.setSubject(msgSubject);
		 
		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, "text/html");
		 
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		 
		message.setContent(multipart);		
		return message;
	}
	
	
	
	public void send() {
		checkState(emailMessage);		
		tryToSend();
	}
	
	
	
	private void tryToSend() {		
		try {
			Transport.send(emailMessage);
			
		} catch (MessagingException e) {
			logException(e);
			throw new IllegalStateException(e);	
		}
	}
	
	
	
	private void checkState(Message message) {
		if (message == null) {
			logException(new IllegalStateException(SystemMessage.BUILD_REQUIRED));
			throw new NullPointerException(SystemMessage.BUILD_REQUIRED);
		}		
	}
	
	
	
	private void checkAttr() {
		if (hostname == null) {
			logException(new NullPointerException("hostname" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("hostname" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (port == null) {
			logException(new NullPointerException("port" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("port" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (sender == null) {
			logException(new NullPointerException("sender" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("sender" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (password == null) {
			logException(new NullPointerException("password" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("password" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (recipient == null) {
			logException(new NullPointerException("recipient" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recipient" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (body == null) {
			logException(new NullPointerException("body" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("body" + SystemMessage.NULL_ARGUMENT);
		}
		
		
		if (subject == null) {
			logException(new NullPointerException("subject" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("subject" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
