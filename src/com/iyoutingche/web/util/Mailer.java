package com.iyoutingche.web.util;

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mailer {
	/** javamail session对象. */
	protected Session session;
	/** 发信地址 */
	protected String from;
	/** 信的标题 */
	protected String subject;
	/** 存放字符串形式的收信地址 */
	protected ArrayList toList = new ArrayList();
	/** 抄送地址 */
	protected ArrayList ccList = new ArrayList();
	/** 暗送地址 */
	protected ArrayList bccList = new ArrayList();
	/** 信的文本内容 */
	protected String body;
	/** SMTP服务器地址 */
	protected String mailHost;
	/** 是否在控制台打印信息 */
	protected boolean verbose = true;

	/** Get from */
	public String getFrom() {
		return from;
	}

	public void setFrom(String fm) {
		from = fm;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subj) {
		subject = subj;
	}

	public ArrayList getToList() {
		return toList;
	}

	public void setToList(ArrayList to) {
		toList = to;
	}

	public void setToList(String s) {
		toList = tokenize(s);
	}

	public void addTo(String to) {
		toList.add(to);
	}

	public ArrayList getCcList() {
		return ccList;
	}

	public void setCcList(ArrayList cc) {
		ccList = cc;
	}

	public void setCcList(String s) {
		ccList = tokenize(s);
	}

	public void addCc(String cc) {
		ccList.add(cc);
	}

	public ArrayList getBccList() {
		return bccList;
	}

	public void setBccList(ArrayList bcc) {
		bccList = bcc;
	}

	public void setBccList(String s) {
		bccList = tokenize(s);
	}

	public void addBcc(String bcc) {
		bccList.add(bcc);
	}

	public String getBody() {
		return body;
	}

	public void setBody(String text) {
		body = text;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean v) {
		verbose = v;
	}

	public boolean isComplete() { //
		if (from == null || from.length() == 0) {
			System.err.println("doSend: no FROM");
			return false;
		}
		if (subject == null || subject.length() == 0) {
			System.err.println("doSend: no SUBJECT");
			return false;
		}
		if (toList.size() == 0) {
			System.err.println("doSend: no recipients");
			return false;
		}
		if (body == null || body.length() == 0) {
			System.err.println("doSend: no body");
			return false;
		}
		if (mailHost == null || mailHost.length() == 0) {
			System.err.println("doSend: no server host");
			return false;
		}
		return true;
	}

	public void setServer(String s) {
		mailHost = s;
	}

	/** Send the message. */
	public synchronized void doSend() throws MessagingException {
		if (!isComplete())
			throw new IllegalArgumentException(
					"doSend called before message was complete");
		Properties props = new Properties();
		props.put("mail.smtp.host", mailHost);
		props.put("mail.smtp.auth", "true");// 指定是否需要SMTP验证
		// Create the Session object
		if (session == null) {
			session = Session.getDefaultInstance(props, null);
			if (verbose)
				session.setDebug(true); // Verbose!
		}
		// create a message
		final Message mesg = new MimeMessage(session);
		InternetAddress[] addresses;
		// TO Address list
		addresses = new InternetAddress[toList.size()];
		for (int i = 0; i < addresses.length; i++)
			addresses[i] = new InternetAddress((String) toList.get(i));
		mesg.setRecipients(Message.RecipientType.TO, addresses);
		// From Address
		mesg.setFrom(new InternetAddress(from));
		// CC Address list
		addresses = new InternetAddress[ccList.size()];
		for (int i = 0; i < addresses.length; i++)
			addresses[i] = new InternetAddress((String) ccList.get(i));
		mesg.setRecipients(Message.RecipientType.CC, addresses);
		// BCC Address list
		addresses = new InternetAddress[bccList.size()];
		for (int i = 0; i < addresses.length; i++)
			addresses[i] = new InternetAddress((String) bccList.get(i));
		mesg.setRecipients(Message.RecipientType.BCC, addresses);
		// The Subject
		mesg.setSubject(subject); // 此处是标题，可以提取数据库填入的内容。
		// Now the message body.
		mesg.setText(body);
		Transport transport = session.getTransport("smtp");
		transport.connect(mailHost, "15239751075", "li1314li");
		transport.sendMessage(mesg, mesg.getAllRecipients());
	}

	protected ArrayList tokenize(String s) {
		ArrayList al = new ArrayList();
		StringTokenizer tf = new StringTokenizer(s, ",");
		// For each word found in the line
		while (tf.hasMoreTokens()) {
			// trim blanks, and add to list.
			al.add(tf.nextToken().trim());
		}
		return al;
	}

	public void sendMail(String UUID, String Md5, String stu_email) {
		Mailer mailer = new Mailer();
		mailer.setServer("smtp.163.com");
		mailer.setFrom("15239751075@163.com");
		mailer.addTo(stu_email);
		mailer.setSubject("i优停车官网");
		String m = "点击激活";
		mailer.setBody("点击激活验证"
				+ // 设置路径
				"http://192.168.51.222:8080/iyoutingche/mailVerifySer?uuid=" + UUID
				+ "&md5=" + Md5 + "");
		/*mailer.setBody("点击激活验证"
				+ // 设置路径
				"http://localhost:8080/iyoutingche/mailVerifySer?uuid=" + UUID
				+ "&md5=" + Md5 + "");*/

		try {
			mailer.doSend();
		} catch (MessagingException e) {
		}
	}
}
