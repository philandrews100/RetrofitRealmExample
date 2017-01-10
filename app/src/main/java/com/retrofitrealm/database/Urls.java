package com.retrofitrealm.database;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Phil on 10/01/2017.
 */

public class Urls extends RealmObject{
    @SerializedName("raw")
    String raw;
    @SerializedName("full")
    String full;
    @SerializedName("regular")
    String regular;
    @SerializedName("small")
    String small;
    @SerializedName("thumb")
    String thumb;

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getRaw() {
        return raw;
    }

    public String getFull() {
        return full;
    }

    public String getRegular() {
        return regular;
    }

    public String getSmall() {
        return small;
    }


    public String getThumb() {
        return thumb;
    }
}
