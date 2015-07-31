package com.bematech.material.models;

/**
 * Created by c1401895 on 31/07/2015.
 */
public class CardModel {

    private int id;
    private String category;
    private String title;
    private String imageUrl;


    public CardModel() {
    }

    public CardModel(int id, String category, String title, String imageUrl) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
