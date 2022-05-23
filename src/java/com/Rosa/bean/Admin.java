package com.Rosa.bean;

public class Admin {
    private int admin_id;
    private String admin_name;
    private String admin_emailid;
    private Long mobile_no;
    private String a_password;

    public Admin(int admin_id, String admin_name, String admin_emailid, Long mobile_no, String a_password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_emailid = admin_emailid;
        this.mobile_no = mobile_no;
        this.a_password = a_password;
    }

    public Admin() {
    }

    public Admin(String admin_name, Long mobile_no, String a_password) {
        this.admin_name = admin_name;
        this.mobile_no = mobile_no;
        this.a_password = a_password;
    }

    public Admin(int admin_id, String admin_name, String admin_emailid, Long mobile_no) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_emailid = admin_emailid;
        this.mobile_no = mobile_no;
    }

    

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_emailid() {
        return admin_emailid;
    }

    public void setAdmin_emailid(String admin_emailid) {
        this.admin_emailid = admin_emailid;
    }

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }
    
}
