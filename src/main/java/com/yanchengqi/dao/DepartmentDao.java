package com.yanchengqi.dao;

import com.yanchengqi.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门Dao
@Repository
public class DepartmentDao {
//    模拟初始化数据库
    private static Map<Integer, Department> departments=null;
    static {
        departments=new HashMap<Integer,Department>();
//        创建一个表，下面初始化
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"教学部2"));
        departments.put(103,new Department(103,"教学部2"));
        departments.put(104,new Department(104,"教学部3"));
        departments.put(105,new Department(105,"教学部4"));
    }
//    获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }
//    通过id得到部门
    public Department getDepartmentByID(Integer id){
        return departments.get(id);
    }
//
}
