package com.nav.serialization;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Created by naveen on 3/14/2016.
 */
public class Employee implements Serializable{

    private static final long serialVersionUID = -1;
    private String name;
    private String dept;
    private String empNo;

    public Employee() {
    }

    public Employee(String name, String dept, String empNo) {
        this.name = name;
        this.dept = dept;
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("dept", dept)
                .add("empNo", empNo)
                .toString();
    }
}
