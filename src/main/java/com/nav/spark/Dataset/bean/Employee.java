package com.nav.spark.Dataset.bean;

import java.io.Serializable;

/**
 * Created by Neo on 3/27/2017.
 */
public class Employee implements Serializable{
    private String name;
    private String company;
    private String dept;
    private Long empId;

    public Employee() {
    }

    public Employee(String name, String company, String dept, Long empId) {
        this.name = name;
        this.company = company;
        this.dept = dept;
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", dept='").append(dept).append('\'');
        sb.append(", empId=").append(empId);
        sb.append('}');
        return sb.toString();
    }
}
