package com.nanwu.hometown.mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import com.nanwu.hometown.Common;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class SendMail {

	private static final String SMTP_HOST_NAME = "smtp.163.com";
	private static final int SMTP_HOST_PORT = 465;
	private static final String SMTP_AUTH_USER = "524133723";
	private static final String SMTP_AUTH_PWD = "318821wan";

	public static void send() throws Exception {
        System.setProperty("file.encoding","UTF-8");
        System.setProperty("client.encoding","UTF-8");
        
		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", SMTP_HOST_NAME);

		Session mailSession = Session.getDefaultInstance(props);
		Transport transport = mailSession.getTransport();

		MimeMessage message = new MimeMessage(mailSession);
		Date now = Calendar.getInstance().getTime();
		message.setSubject("数据备份 in " + Common.strToDate(now,"yyyy-MM-dd hh:mm:ss"));
		message.setHeader("Content-Type", "text/plain; charset=UTF-8");
		
		// Create the message part 
        BodyPart messageBodyPart = new MimeBodyPart();

        // Fill the message
        messageBodyPart.setText("数据已经添送，请查收！");
        
        // Create a multipar message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource("backup.zip");
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("backup.zip");
        multipart.addBodyPart(messageBodyPart);
        
        message.setContent(multipart,"text/plain; charset=UTF-8");
        
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(SMTP_AUTH_USER + "@163.com"));
		message.setFrom(new InternetAddress(SMTP_AUTH_USER + "@163.com"));

		transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}
}