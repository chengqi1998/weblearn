package com.yanchengqi.controller;

import com.yanchengqi.dao.DepartmentDao;
import com.yanchengqi.dao.EmployeeDao;
import com.yanchengqi.pojo.Department;
import com.yanchengqi.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpolyeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        final Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
//        需要获得部门的信息
        final Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("------->"+employee);
        employeeDao.save(employee);
//        跳转到遍历员工界面
        return "redirect:/emps";
    }
//    跳转到员工修改界面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
//        查出原来的数据
        Employee employee=employeeDao.getEmployeeByID(id);
        model.addAttribute("msg",employee);
//传回部门信息
        final Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "update";
    }
//    修改的员工信息回存
    @PostMapping("updateEmp")
    public String updateEmp(Employee employee){
        System.out.println("修改后的员工"+employee);
        employeeDao.save(employee);
        return  "redirect:/emps";
    }
//    删除操作
    @GetMapping("/delemp/{id}")
    public String delEmp(@PathVariable("id")Integer id){
        employeeDao.deleteEmployeeByID(id);
        return "redirect:/emps";
    }
}
