package com.example.songlist;

import androidx.annotation.NonNull;

public class Songs {
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

    public String getSingers() { return singers; }

    public int getYear() { return years; }

    public int getStars() { return stars; }

    @NonNull
    @Override
    public String toString() {
        return id + "\n" + title + "\n" + singers + "\n" + years + "\n" + stars;
    }

}
