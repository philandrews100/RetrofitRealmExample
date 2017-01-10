package com.retrofitrealm;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Phil on 10/01/2017.
 */

public class RetrofitRealmApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
