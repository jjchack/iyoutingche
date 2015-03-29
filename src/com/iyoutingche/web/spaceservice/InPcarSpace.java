package com.iyoutingche.web.spaceservice;

import java.util.List;

import com.iyoutingche.web.depotmodel.Pcar_Space;

public interface InPcarSpace {
	public List<Pcar_Space> FindByDepot(String depot_code); //查询停车场中的停车位
	public int GetAllCount(String depot);    //计算该停车场中的总共停车位数量
	public int GetPark(String depotCode);   //得到停车场中被占停车位的数量
	public int GetALLOrder(String deport);  //计算预约表中有多少车位被预约
	
	public boolean AddSpace(Pcar_Space space); //添加停车位
	public boolean DelSpace(String space_code);  //删除停车位
	public boolean ModifySpace(Pcar_Space space); //修改停车位
	public boolean AddOrder(String[] preams); //添加预约表停车位
}
