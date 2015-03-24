package com.iyoutingche.web.orderservice;

import java.util.List;

import com.iyoutingche.web.ordermodel.Pcar_Order;

public interface InPcar_Order {
	public boolean addOrder(Pcar_Order order);   //添加预约表
	public boolean delOrder(String space_code);  //通过停车位的二维码来删除预约表
	public List<Pcar_Order> FindByDepotCode(String depotCode);  // 通过停车场二维码遍历停车位预约情况。
}
