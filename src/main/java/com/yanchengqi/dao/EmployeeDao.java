package com.yanchengqi.dao;

import com.yanchengqi.pojo.Department;
import com.yanchengqi.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    public static Map<Integer, Employee> employees=null;
//    创建了部门表
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer,Employee>();
        employees.put(1001,new Employee(1001,"AA","123@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","123@qq.com",1,new Department(101,"教学部")));
        employees.put(1003,new Employee(1003,"CC","123@qq.com",0,new Department(101,"教学部")));
        employees.put(1004,new Employee(1001,"DD","123@qq.com",1,new Department(101,"教学部")));
        employees.put(1005,new Employee(1001,"EE","123@qq.com",0,new Department(101,"教学部")));
    }
//    增加一个员工
//    private static Integer initID =1006;
//    public void save(Employee employee){
//        if(employee.getId()==null){
//            employee.setId(initID++);
//        }
//        employee.setDepartment(departmentDao.getDepartmentByID(employee.getDepartment().getID()));
//        employees.put(employee.getId(),employee);
//
//    }
//
    private static Integer initID = 1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initID++);
        }
        employee.setDepartment(departmentDao.getDepartmentByID(employee.getDepartment().getID()));
        employees.put(employee.getId(),employee);
    }
//    返回全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
//    通过id查询员工
    public Employee getEmployeeByID(Integer id){
        return employees.get(id);
    }
//    删除员工
    public void deleteEmployeeByID(Integer id){
        employees.remove(id);
    }
 }
