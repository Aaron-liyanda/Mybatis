package com.aaron.test;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.aaron.dao.impl.HeroDaoImpl;
import com.aaron.entity.Hero;
import com.aaron.util.DBUtil;

import junit.framework.TestCase;

public class TestMybatis extends TestCase{
	
	public void getList(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		HeroDaoImpl impl = new HeroDaoImpl();
		impl.setSf(sf);
		List<Hero> list = impl.getList();
		System.out.println(list);
		
	}
	
	public void getHeroById(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		HeroDaoImpl impl = new HeroDaoImpl();
		impl.setSf(sf);
		Hero hero = impl.getById(55);
		System.out.println(hero);
		
	}
	
	public void insert(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		HeroDaoImpl impl = new HeroDaoImpl();
		impl.setSf(sf);
		Hero hero = new Hero();
		hero.setId(334);
		hero.setName("adsss");
		hero.setNickname("aaaaa");
		hero.setFirst("asas");		//无法提交  
		int i = impl.insert(hero);
		System.out.println(i);
		
	}
	
	public void deleteByid(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		HeroDaoImpl impl = new HeroDaoImpl();
		impl.setSf(sf);
		impl.deleteById(334);
	}
	
	public void deleteByMutil(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		HeroDaoImpl impl = new HeroDaoImpl();
		impl.setSf(sf);
		HashMap map = new HashMap();
		map.put("id", 143);
		map.put("name", "444");
		int n = impl.deleteByMutil(map);
		System.out.println(n);
		
	}
	
	//多表查询
	public void mutilTableQuery(){
		SqlSessionFactory sf = DBUtil.getSessionFactor();
		HeroDaoImpl impl = new HeroDaoImpl();
		impl.setSf(sf);
		List<Map> list = impl.getEmp();
		for (Map map : list) {
			System.out.println(map.get("empName")+"--"+map.get("empSal")+ "--"+map.get("name"));
		}
		System.out.println(list);
	}
	
	//模糊查询
		public void vagueQuery(){
			SqlSessionFactory sf = DBUtil.getSessionFactor();
			HeroDaoImpl impl = new HeroDaoImpl();
			impl.setSf(sf);
			List<Map> list = impl.getEmpLike("%"+"a"+"%");
			System.out.println(list);
		}

//日期查询
		public void dateQuery(){
			SqlSessionFactory sf = DBUtil.getSessionFactor();
			HeroDaoImpl impl = new HeroDaoImpl();
			impl.setSf(sf);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			
//			List<Map> list = impl.getDate(date);
//			System.out.println(list);
		}

}
