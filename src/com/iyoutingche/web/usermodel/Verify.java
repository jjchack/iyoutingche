package com.iyoutingche.web.usermodel;

public class Verify {
	private String stu_name;
	private String stu_nameMd5;    //自动生成的验证码数据
	private String randMd5;			 //自动生成的验证码数据
	
	public Verify(){
		
	}
	public Verify(String stu_name,String stu_nameMd5,String randMd5){
		this.randMd5 = randMd5;
		this.stu_nameMd5 = stu_nameMd5;
		this.stu_name  = stu_name;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stuName) {
		stu_name = stuName;
	}
	public String getStu_nameMd5() {
		return stu_nameMd5;
	}
	public void setStu_nameMd5(String stuNameMd5) {
		stu_nameMd5 = stuNameMd5;
	}
	public String getRandMd5() {
		return randMd5;
	}
	public void setRandMd5(String randMd5) {
		this.randMd5 = randMd5;
	}
	
	
}
