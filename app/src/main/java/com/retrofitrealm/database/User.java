package com.retrofitrealm.database;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Phil on 10/01/2017.
 */

public class User extends RealmObject {
    @SerializedName("id")
    String id;
    @SerializedName("username")
    String username;
    @SerializedName("name")
    String name;
    @SerializedName("first_name")
    String first_name;
    @SerializedName("last_name")
    String last_name;
    @SerializedName("portfolio_url")
    String portfolio_url;
    @SerializedName("bio")
    String bio;
    @SerializedName("location")
    String location;
    @SerializedName("total_likes")
    int total_likes;
    @SerializedName("total_photos")
    int total_photos;
    @SerializedName("total_collections")
    int total_collections;
    @SerializedName("profile_image")
    ProfileImage profile_image;
    @SerializedName("links")
    UserLinks links;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPortfolio_url(String portfolio_url) {
        this.portfolio_url = portfolio_url;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTotal_likes(int total_likes) {
        this.total_likes = total_likes;
    }

    public void setTotal_photos(int total_photos) {
        this.total_photos = total_photos;
    }

    public void setTotal_collections(int total_collections) {
        this.total_collections = total_collections;
    }

    public void setProfile_image(ProfileImage profile_image) {
        this.profile_image = profile_image;
    }

    public void setLinks(UserLinks links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPortfolio_url() {
        return portfolio_url;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public int getTotal_likes() {
        return total_likes;
    }

    public int getTotal_photos() {
        return total_photos;
    }

    public int getTotal_collections() {
        return total_collections;
    }

    public ProfileImage getProfile_image() {
        return profile_image;
    }

    public UserLinks getLinks() {
        return links;
    }

}
