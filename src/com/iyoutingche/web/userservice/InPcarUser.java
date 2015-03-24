package com.iyoutingche.web.userservice;

import java.util.List;

import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.usermodel.Verify;

public interface InPcarUser {
	public boolean addUser(PcarUser user)throws Exception;   //添加用户
	public boolean modifyUser(String userName, String userSex, String userEmail,
			String userPhone, String userNumber)throws Exception; //修改用户信息
	public boolean delUser(String user_id)throws Exception;  //删除用户信息
	public List<PcarUser> findUser()throws Exception;		//查询用户信息
	public boolean FindUserByEmail(String email);			//通过email查询用户，判断该邮箱是否注册
	public boolean CheckLogin(String email,String password); //登录验证
	public PcarUser FindUsersByEmail(String email);   		//通过email查询该人信息
	public boolean ModifyEmail(String email,String userimg); //通过email修改图片路径
	public boolean ModifyPassword(String email,String password); //通过email修改用户密码
	
	public boolean delVerify(String email);		//通过用户email删除临时校验信息
	public String getVerify(String stu_nameMd5,String randMd5); //通过这两个属性得到临时校验信息
	public boolean addVerify(Verify verify); 		//添加临时校验信息
}
