package com.retrofitrealm.database;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Phil on 10/01/2017.
 */

public class UserLinks extends RealmObject{
    @SerializedName("self")
    String self;
    @SerializedName("html")
    String html;
    @SerializedName("photos")
    String photos;
    @SerializedName("likes")
    String likes;
    @SerializedName("portfolio")
    String portfolio;
    @SerializedName("following")
    String following;
    @SerializedName("followers")
    String followers;

    public void setSelf(String self) {
        this.self = self;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getSelf() {
        return self;
    }

    public String getHtml() {
        return html;
    }

    public String getPhotos() {
        return photos;
    }

    public String getLikes() {
        return likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public String getFollowing() {
        return following;
    }

    public String getFollowers() {
        return followers;
    }
}