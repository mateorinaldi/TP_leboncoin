package com.example.leboncoin;

public class AdModel {
    private String title;
    private String address;
    private String image;
    boolean isDrawable;
    private String mail;
    private String numero_de_telephone;
    private String description;

    public AdModel(String title, String address, String image, boolean isDrawable, String mail, String numero_de_telephone, String description) {
        this.title = title;
        this.address = address;
        this.image = image;
        this.isDrawable = isDrawable;
        this.mail = mail;
        this.numero_de_telephone = numero_de_telephone;
        this.description = description;
    }
    public String getTitle(){
        return title;
    }

    public String getAddress () { return address;}

    public String getImage() {
        return image;
    }

    public String getMail() { return mail;}

    public String getDescription() { return description;}

    public String getNumero_de_telephone() {return numero_de_telephone;}

    public void setTitle(String title){
        this.title = title;
    }
}
