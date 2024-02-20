package com.example.leboncoin;

public class AdModel {
    private String title;
    private String address;
    private String image;
    boolean isDrawable;

    public AdModel(String title, String address, String image, boolean isDrawable) {
        this.title = title;
        this.address = address;
        this.image = image;
        this.isDrawable = isDrawable;
    }
    public String getTitle(){
        return title;
    }

    public String getAddress () { return address;}

    public String getImage() {
        return image;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
