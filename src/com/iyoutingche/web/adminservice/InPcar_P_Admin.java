package com.iyoutingche.web.adminservice;

import com.iyoutingche.web.adminmodel.Pcar_Admin_P;

public interface InPcar_P_Admin {
	public boolean AddPcar_pAdmin(Pcar_Admin_P padmin);  //添加停车场管理员信息
	public boolean DelPcar_pAdmin(String admin_p_id);  //通过管理员id删除信息
	public Pcar_Admin_P FindById(String admin_p_id);  //通过id查找该管理员
	public boolean ModifyById(String adminid,String admin_name,String admin_sex
			,String admin_email,String admin_phone,String admin_p_bank);	//修改管理员信息
}
