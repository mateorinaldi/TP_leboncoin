package com.example.leboncoin;

public class DbAdModel {
    private String title;
    private String address;
    private String image;
    boolean isDrawable; //problème isDrawalable n'est pas dans la base de donnée
    private int id;
    private String description;
    private int price;
    private String category;
    private String seller;
    private int telephone;
    private String mail;
    private String is_available;

    public DbAdModel(int id, String image,boolean isDrawable, String title, String description, int price, String category, String seller, String address, int telephone, String mail, String is_available) {
        this.id = id;
        this.image=image;
        this.isDrawable = isDrawable;
        this.title=title;
        this.description=description;
        this.price=price;
        this.category=category;
        this.seller=seller;
        this.address=address;
        this.telephone=telephone;
        this.mail=mail;
        this.is_available=is_available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIs_available() {
        return is_available;
    }

    public void setIs_available(String is_available) {
        this.is_available = is_available;
    }
}
