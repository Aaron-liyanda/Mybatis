package com.aaron.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.aaron.dao.HeroDao;
import com.aaron.entity.Hero;

public class HeroDaoImpl implements HeroDao {
	
	SqlSessionFactory sf;
	
	public SqlSessionFactory getSf() {
		return sf;
	}

	public void setSf(SqlSessionFactory sf) {
		this.sf = sf;
	}

	public int insert(Hero hero) {
		SqlSession session = sf.openSession();
		int insert = 0;
		try {
			insert = session.insert("aaron.insert", hero);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally{
			session.close();
		}
		return insert;
	}

	public List<Hero> getList() {
		SqlSession session = sf.openSession();
		List<Hero> list = session.selectList("aaron.getHeroList");
		return list;
	}

	public int deleteById(int id) {
		SqlSession session = sf.openSession();
		int delete = 0;
		try {
			delete = session.delete("aaron.delete", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally{
			session.close();
		}
		return delete;
	}

	public Hero getById(int id) {
		SqlSession session = sf.openSession();
		Hero hero = (Hero)session.selectOne("aaron.getHeroById", id);
		return hero;
	}

	public int deleteByMutil(Map param) {
		SqlSession session = sf.openSession();
		int delete = 0;
		try {
			delete = session.delete("aaron.deleteByMutil", param);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally{
			session.close();
		}
		return delete;
	}

	public int updateById(int id) {
		SqlSession session = sf.openSession();
		int update = 0;
		try {
			update = session.update("aaron.updateById", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally{
			session.close();
		}
		return update;
	}

	public List getEmp() {
		SqlSession session = sf.openSession();
		List<Map> list = session.selectList("aaron.getEmp");
		return list;
	}

	public List getEmpLike(String name) {
		SqlSession session = sf.openSession();
		List<Map> list = session.selectList("aaron.getEmpLike", name);
		return list;
	}

	public List getDate(Date date) {
		SqlSession session = sf.openSession();
		List<Map> list = session.selectList("aaron.getDate", date);
		return list;
	}


}
