package com.aaron.dao;

import java.util.List;

import com.aaron.entity.Orders;
import com.aaron.entity.User;

public interface OrdersCustomMapper {
	
	public List<Orders>findOrdersUserResultMap();
	
	public List<Orders>findOrdersAndOrderDetailResultMap();
	
	public List<User> findUserAndItemsResultMap();

}
