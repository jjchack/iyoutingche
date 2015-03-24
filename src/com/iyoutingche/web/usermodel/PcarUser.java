package com.iyoutingche.web.usermodel;

public class PcarUser {
	private String user_id;	//用uuid来实现
	private String user_name;
	private String user_sex;
	private String user_password;
	private String user_email;
	private String user_phone;
	private String user_img;
	private String user_number;	//车牌号
	
	
	//无参的构造方法
	public PcarUser(){
		
	}
	public PcarUser(String userName, String userSex, String userEmail,
			String userPhone, String userImg, String userNumber) {
		super();
		user_name = userName;
		user_sex = userSex;
		user_email = userEmail;
		user_phone = userPhone;
		user_img = userImg;
		user_number = userNumber;
	}

	//有参的构造方法（constractor）
	public PcarUser(String userId, String userName, String userSex,
			String userPassword, String userEmail, String userPhone,
			String userImg, String userNumber) {
		super();
		user_id = userId;
		user_name = userName;
		user_sex = userSex;
		user_password = userPassword;
		user_email = userEmail;
		user_phone = userPhone;
		user_img = userImg;
		user_number = userNumber;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String userSex) {
		user_sex = userSex;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String userPassword) {
		user_password = userPassword;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String userEmail) {
		user_email = userEmail;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String userPhone) {
		user_phone = userPhone;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String userImg) {
		user_img = userImg;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String userNumber) {
		user_number = userNumber;
	}
}
