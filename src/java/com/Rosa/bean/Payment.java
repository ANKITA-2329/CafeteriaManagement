package com.Rosa.bean;

import java.sql.Date;

public class Payment {
    private int payment_id;
    private String payment_mode;
    private Double payment_amount;
    private String payment_status;
    private String payment_details;
    private Date payment_date;
    private int order_id;

    public Payment(int payment_id, String payment_mode, Double payment_amount, String payment_status, String payment_details, Date payment_date, int order_id) {
        this.payment_id = payment_id;
        this.payment_mode = payment_mode;
        this.payment_amount = payment_amount;
        this.payment_status = payment_status;
        this.payment_details = payment_details;
        this.payment_date = payment_date;
        this.order_id = order_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public Double getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(Double payment_amount) {
        this.payment_amount = payment_amount;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getPayment_details() {
        return payment_details;
    }

    public void setPayment_details(String payment_details) {
        this.payment_details = payment_details;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public Payment()
    {
        
    }

    public Payment(String payment_mode, int order_id, Double payment_amount) {
        this.payment_mode = payment_mode;
        this.payment_amount = payment_amount;
        this.order_id = order_id;
    }

    public Payment(int order_id, String payment_mode, Double payment_amount, int payment_id) {
        this.payment_id = payment_id;
        this.payment_mode = payment_mode;
        this.payment_amount = payment_amount;
        this.order_id = order_id;
    }
    
}
