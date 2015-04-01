package com.iyoutingche.web.depotservice;

import java.util.List;

import com.iyoutingche.web.depotmodel.Pcar_Depot;

public interface InPcar_Depot {
	public List<Pcar_Depot> FindByProvince(String province);  //通过省查询停车场。
	public List<Pcar_Depot> FindByCity(String city);  //通过市查询停车场。
	public List<Pcar_Depot> FindByRegion(String region);  //通过区查询停车场
	public List<Pcar_Depot> FindByKeywords(String keys);		//通过关键字查询停车场
	public Pcar_Depot FindByCode(String depot_code); 			//通过二维码查找停车场中的数据
	
	public boolean AddDepot(Pcar_Depot depot);   //添加停车场
	public boolean ModifyDepot(Pcar_Depot depot);  //修改停车场
	public boolean DelDepot(String depot_code);		//删除停车场
	public boolean ModifyDepotImg(String depot_code,String depot_img); //通过二维码修改停车场的图片
}
