package com.aaron.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.aaron.dao.EmpDao;
import com.aaron.dao.OrdersCustomMapper;
import com.aaron.entity.Emp;
import com.aaron.entity.Orders;
import com.aaron.entity.User;
import com.aaron.util.DBUtil;

import junit.framework.TestCase;

public class TestMultiQuery extends TestCase{
	
	public void oneToOneQuery(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		OrdersCustomMapper dao = session.getMapper(OrdersCustomMapper.class);
		List<Orders> list = dao.findOrdersUserResultMap();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	
	public void oneToManyQuery(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		OrdersCustomMapper dao = session.getMapper(OrdersCustomMapper.class);
		List<Orders> list = dao.findOrdersAndOrderDetailResultMap();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	
	public void oneManyManyQuery(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		OrdersCustomMapper dao = session.getMapper(OrdersCustomMapper.class);
		List<User> list = dao.findUserAndItemsResultMap();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
//多条件查询
	public void multiConditionQuery(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List<Emp> list = dao.selectEmpByParam(null, null);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	
//更新
	public void update(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		Emp emp = new Emp();
		emp.setEmpNo(2);
		emp.setEmpName("Jack");
		emp.setEmpSal(5000.0);;
		dao.updateEmp(emp);
		session.commit();
	}
	
	public void addBulkEmp(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List list = new ArrayList<Emp>();
		Emp emp1 = new Emp(55, "soldier1", 12.0);
		Emp emp2 = new Emp(56, "soldier2", 12.0);
		Emp emp3 = new Emp(57, "soldier3", 12.0);
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		int n = dao.addBulkEmp(list);
		session.commit();
		System.out.println(n);
	}
	
//批量删除
	public void deleteBulkEmp(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		int n = dao.deleteBulkEmp(list);
		session.commit();
		System.out.println(n);
	}
	
//分页
	public void paging(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		Map map = new HashMap();
		map.put("first", 5);
		map.put("size", 5);
		List<Emp> list = dao.paging(map);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

}
