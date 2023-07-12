package com.example.songlist;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Songs implements Serializable {
    private int id;
    private String title;
    private String singers;
    private int years;
    private int stars;

    public Songs(int id, String title, String singers, int year, int stars) {
        this.id = id;
        this.title =title;
        this.singers = singers;
        this.years = year;
        this.stars=stars;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSingers() { return singers; }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public int getYear() { return years; }

    public void setYears(int years) {
        this.years = years;
    }

    public int getStars() { return stars; }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @NonNull
    @Override
    public String toString() {
        return "\nTitle: " + title + "\nSingers: " + singers + "\nYears: " + years + "\nStars: " + stars;
    }

}
