package com.retrofitrealm.database;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Phil on 10/01/2017.
 */

public class ProfileImage extends RealmObject{
    @SerializedName("small")
    String small;
    @SerializedName("medium")
    String medium;
    @SerializedName("large")
    String large;

    public void setSmall(String small) {
        this.small = small;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }
}