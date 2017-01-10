package com.retrofitrealm.database;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Phil on 10/01/2017.
 */

public class Links extends RealmObject{
    @SerializedName("self")
    String self;
    @SerializedName("html")
    String html;
    @SerializedName("download")
    String download;
    @SerializedName("download_location")
    String download_location;

    public void setSelf(String self) {
        this.self = self;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public void setDownload_location(String download_location) {
        this.download_location = download_location;
    }

    public String getSelf() {
        return self;
    }

    public String getHtml() {
        return html;
    }

    public String getDownload() {
        return download;
    }

    public String getDownload_location() {
        return download_location;
    }
}
