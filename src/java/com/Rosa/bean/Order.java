package com.Rosa.bean;

import java.sql.Date;

public class Order {
    private int order_id;
    private String order_details;
    private int subTotal;
    private double gst;
    private double cgst;
    private double grandTotal;
    private Date date;
    private int c_id;
    private int emp_id;
    private String order_type;
    private String order_status;

    public Order(int order_id, String order_status) {
        this.order_id = order_id;
        this.order_status = order_status;
    }

    public Order(int order_id) {
        this.order_id = order_id;
    }

    public Order(String order_details, int subTotal, double gst, double cgst, double grandTotal, Date date, int emp_id, String order_type) {
        this.order_details = order_details;
        this.subTotal = subTotal;
        this.gst = gst;
        this.cgst = cgst;
        this.grandTotal = grandTotal;
        this.date = date;
        this.emp_id = emp_id;
        this.order_type = order_type;
    }

    public Order(int order_id, String order_details, int subTotal, double gst, double cgst, double grandTotal, Date date, int c_id, int emp_id, String order_type, String order_status) {
        this.order_id = order_id;
        this.order_details = order_details;
        this.subTotal = subTotal;
        this.gst = gst;
        this.cgst = cgst;
        this.grandTotal = grandTotal;
        this.date = date;
        this.c_id = c_id;
        this.emp_id = emp_id;
        this.order_type = order_type;
        this.order_status = order_status;
    }

    public Order(int order_id, String order_details, int subTotal, double gst, double cgst, double grandTotal, Date date, int c_id, int emp_id) {
        this.order_id = order_id;
        this.order_details = order_details;
        this.subTotal = subTotal;
        this.gst = gst;
        this.cgst = cgst;
        this.grandTotal = grandTotal;
        this.date = date;
        this.c_id = c_id;
        this.emp_id = emp_id;
    }

    public Order(int order_id, String order_details, String order_status, String order_type,Date date) {
        this.order_id = order_id;
        this.order_details = order_details;
        this.date = date;
        this.order_type = order_type;
        this.order_status = order_status;
    }

    public Order(String order_details, String order_type, String order_status, Date date) {
        this.order_details = order_details;
        this.date = date;
        this.order_type = order_type;
        this.order_status = order_status;
    }

    public Order(String order_details, int subTotal, double gst, double cgst, double grandTotal, Date date, int c_id, int emp_id) {
        this.order_details = order_details;
        this.subTotal = subTotal;
        this.gst = gst;
        this.cgst = cgst;
        this.grandTotal = grandTotal;
        this.date = date;
        this.c_id = c_id;
        this.emp_id = emp_id;
    }

    public Order(String order_details, int subTotal, double gst, double cgst, double grandTotal, Date date, int c_id) {
        this.order_details = order_details;
        this.subTotal = subTotal;
        this.gst = gst;
        this.cgst = cgst;
        this.grandTotal = grandTotal;
        this.date = date;
        this.c_id= c_id;
    }

    public Order() {
        
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_details() {
        return order_details;
    }

    public void setOrder_details(String order_details) {
        this.order_details = order_details;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getCgst() {
        return cgst;
    }

    public void setCgst(double cgst) {
        this.cgst = cgst;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    
    
}
