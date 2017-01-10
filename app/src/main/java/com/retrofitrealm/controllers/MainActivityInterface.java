package com.retrofitrealm.controllers;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Phil on 10/01/2017.
 */

public interface MainActivityInterface {
    void loadImagesFragment(String tvValue);
    void goBack();
    void printOut(String name, Object value);
    Realm getRealmInstance();
    RealmConfiguration getRealmConfig();
}
