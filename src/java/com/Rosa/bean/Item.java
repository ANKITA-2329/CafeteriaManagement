package com.Rosa.bean;

public class Item {
    private int item_id;
    private String item_name;
    private String item_category;
    private String item_description;
    private int price;
    private String status;
    
    public Item()
    {
        
    }

    public Item(int item_id, String item_name, String item_category, String item_description, int price, String status) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_category = item_category;
        this.item_description = item_description;
        this.price = price;
        this.status = status;
    }
    public Item(String item_name, String item_category, String item_description, int price, String status) {
        this.item_name = item_name;
        this.item_category = item_category;
        this.item_description = item_description;
        this.price = price;
        this.status = status;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
