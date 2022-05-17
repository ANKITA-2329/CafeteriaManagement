package com.Rosa.bean;

public class Customer {
    private int c_id;
    private String c_name;
    private String c_emailid;
    private String address;
    private String pin;
    private long mobile_no;
    private String c_password;

    public Customer()
    {
    }

    public Customer(String c_name, String c_emailid, String address, String pin, long mobile_no, String c_password) {
        this.c_name = c_name;
        this.c_emailid = c_emailid;
        this.address = address;
        this.pin = pin;
        this.mobile_no = mobile_no;
        this.c_password = c_password;
    }
    
    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_emailid() {
        return c_emailid;
    }

    public void setC_emailid(String c_emailid) {
        this.c_emailid = c_emailid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }
    
}
