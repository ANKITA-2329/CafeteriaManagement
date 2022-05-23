package com.Rosa.bean;

public class Employee {
    private int emp_id;
    private String emp_name;
    private String emp_emailid;
    private String workplace;
    private Long mobile_no;
    private String password;

    public Employee() {
    }

    public Employee(String emp_name, String emp_emailid, String workplace, Long mobile_no) {
        this.emp_name = emp_name;
        this.emp_emailid = emp_emailid;
        this.workplace = workplace;
        this.mobile_no = mobile_no;
    }

    public Employee(int emp_id, String emp_name, String emp_emailid, String workplace, Long mobile_no) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_emailid = emp_emailid;
        this.workplace = workplace;
        this.mobile_no = mobile_no;
    }

    public Employee(int emp_id, String emp_name, String emp_emailid, String workplace, Long mobile_no, String password) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_emailid = emp_emailid;
        this.workplace = workplace;
        this.mobile_no = mobile_no;
        this.password = password;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_emailid() {
        return emp_emailid;
    }

    public void setEmp_emailid(String emp_emailid) {
        this.emp_emailid = emp_emailid;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
