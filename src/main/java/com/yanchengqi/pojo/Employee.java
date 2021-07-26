package com.yanchengqi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

//员工表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastname;
    private String email;
    private Integer gendeer;
    private Department department;
    private Date brith;

    public Employee(Integer id, String lastname, String email, Integer gendeer, Department department) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gendeer = gendeer;
        this.department = department;
        this.brith = new Date();
    }
}
