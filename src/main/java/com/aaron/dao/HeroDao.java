package com.aaron.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaron.entity.Hero;

public interface HeroDao {
	
	//增加
	int insert(Hero hero);
	
	//查所有
	List<Hero> getList();
	
	Hero getById(int id);
	
	int deleteById(int id);
	
	int deleteByMutil(Map param);
	
	int updateById(int id);
	
	List getEmp();
	
	List getEmpLike(String name);
	
	List getDate(Date date);

}
