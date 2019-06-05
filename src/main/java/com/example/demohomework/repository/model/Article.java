package com.example.demohomework.repository.model;

import javax.validation.constraints.NotEmpty;

public class Article {
    @NotEmpty
    String aurthor;
    @NotEmpty
    String title;

    String description;
    String thumnail;
    int id;

    public Article() {
    }

    public Article(String aurthor, String title, String description, String thumnail, int id) {
        this.aurthor = aurthor;
        this.title = title;
        this.description = description;
        this.thumnail = thumnail;
        this.id = id;
    }


    public String getAurthor() {
        return aurthor;
    }

    public void setAurthor(String aurthor) {
        this.aurthor = aurthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return title+id+description;
    }
}
