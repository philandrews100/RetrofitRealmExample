package com.retrofitrealm.database;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Phil on 10/01/2017.
 */

public class Photo extends RealmObject {
    @SerializedName("id")
    String id;
    @SerializedName("created_at")
    String created_at;
    @SerializedName("width")
    int width;
    @SerializedName("height")
    int height;
    @SerializedName("color")
    String color;
    @SerializedName("likes")
    int likes;
    @SerializedName("liked_by_user")
    boolean liked_by_user;
    @SerializedName("user")
    User user;
    @SerializedName("urls")
    Urls urls;
    @SerializedName("links")
    Links links;

    public void setId(String id) {
        this.id = id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public int getLikes() {
        return likes;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public User getUser() {
        return user;
    }


    public Urls getUrls() {
        return urls;
    }

    public Links getLinks() {
        return links;
    }

}
