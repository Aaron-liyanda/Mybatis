package com.aaron.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.aaron.entity.Emp;

public interface EmpDao {
	
	//没有实现类
	List getList();
	
	public List<Emp> selectEmpByDate(Date hireDate);
	
    public List<Emp> selectEmpByStringDate(String hireDate);
    
    List userList();

    //多对一
    List getEmpById(int id);
    
    //一对多
    List getDeptById(int id);
    
    //多对多
    List getMultiList();
    
    //别名
    List getAliasList(int id);
    
    //多条件查询     必须加注释 @param  目的是让java字符和mysql字段匹配
    List<Emp> selectEmpByParam(@Param("empName")String empName, @Param("empSal")Double empSal);
    
    
    //更新
    void updateEmp(Emp emp);
    
    //批量增加
    int addBulkEmp(List<Emp> list);
    
    //批量删除
    int deleteBulkEmp(List<Integer> list);
    
    List<Emp> paging(Map map); 
}
