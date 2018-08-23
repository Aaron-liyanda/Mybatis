package com.aaron.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.aaron.dao.EmpDao;
import com.aaron.entity.Dept;
import com.aaron.entity.Emp;
import com.aaron.util.DBUtil;

import junit.framework.TestCase;

public class TestSuperior extends TestCase{
	
	public void getList(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List list = dao.getList();
		System.out.println(list);
	}
	
	public void getDateList(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		
//		List<Emp> list = dao.selectEmpByStringDate("2018-08-15");   //都可以查出来  string date
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse("2018-08-15");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Emp> list = dao.selectEmpByDate(date);
		
		System.out.println(list);
	}
	
	//多表查询
	public void mutilQuery(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List userList = dao.userList();
		System.out.println(userList);
	}
	
	//多对一查询
	public void queryEmpById(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List userList = dao.getEmpById(5);
		System.out.println(userList);
	}
	
	//一对多查询
	public void queryDeptById(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List userList = dao.getDeptById(2);
		System.out.println(userList);
	}
	
//多对多查询
	public void queryMulti(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List<Dept> userList = dao.getMultiList();
		for (Dept dept : userList) {
			System.out.println(dept);
		}
			System.out.println(userList);
		}
		
//别名查询
	public void aliasList(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		SqlSession session = sf.openSession();
		
		EmpDao dao = session.getMapper(EmpDao.class);
		List<Emp> userList = dao.getAliasList(2);
		for (Emp emp : userList) {
			System.out.println(emp);
		}
		System.out.println(userList);
	}

}
