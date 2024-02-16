package com.example.leboncoin;

public class AdModel {
    private String title;
    private String address;
    private int image;

    public AdModel(String title,String address,int image){
        this.title=title;
        this.address=address;
        this.image=image;
    }
    public String getTitle(){
        return title;
    }

    public String getAddress () { return address;}

    public int getImage() {
        return image;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
