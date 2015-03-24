package com.iyoutingche.web.adminservice;

import com.iyoutingche.web.adminmodel.Pcar_Admin;
import com.iyoutingche.web.depotservice.InPcar_Depot;
import com.iyoutingche.web.spaceservice.InPcarSpace;

public interface InPcarAdmin{
	public boolean PcarAdminAdd(Pcar_Admin admin); //添加管理员
//	public boolean PcarAdminModify(String adminid); //修改管理员信息
	public boolean adminCheckLogin(String email,String password); //管理员登录验证
	public boolean CheckRegister(String email); //验证是否重复注册该邮箱
}
