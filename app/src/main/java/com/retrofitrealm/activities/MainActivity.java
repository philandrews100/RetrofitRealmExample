package com.retrofitrealm.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.retrofitrealm.R;
import com.retrofitrealm.assets.AppUtils;
import com.retrofitrealm.controllers.MainActivityInterface;
import com.retrofitrealm.database.Photo;
import com.retrofitrealm.fragments.ImagesFragment;
import com.retrofitrealm.fragments.assets.BaseFragment;
import com.retrofitrealm.networking.NetworkApiController;
import com.retrofitrealm.networking.controllers.NetworkController;
import com.retrofitrealm.networking.controllers.NetworkListener;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements MainActivityInterface, AppUtils, NetworkController {

    private boolean DEVELOPER = true;
    private FragmentManager fragManager;
    private FragmentTransaction fragTransaction;
    private NetworkApiController networkApiController;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRealm();
        setupNetworkApiController();
        setupFragmentManager();
        loadImagesFragment("This is a fragment");
    }

    @Override
    public void loadImagesFragment(String tvValue) {
        switchFragment(ImagesFragment.newInstance(tvValue), IMAGES_FRAGMENT);
    }

    @Override
    public void getAllPhotos(NetworkListener<List<Photo>> networkListener) {
        networkApiController.getAllPhotos(networkListener);
    }

    @Override
    public void goBack() {
        onBackPressed();
    }

    @Override
    public void printOut(String name, Object value) {
        if(DEVELOPER)
            System.out.println(name + " >>> " + String.valueOf(value));
    }

    @Override
    public Realm getRealmInstance() {
        return realm;
    }

    @Override
    public RealmConfiguration getRealmConfig() {
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(getResources().getString(R.string.app_name) + ".realm")
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build();
        return config;
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            // Network is present and connected
            isAvailable = true;
        }
        return isAvailable;
    }

    @Override
    public void onBackPressed() {
        if (this.fragManager.getBackStackEntryCount() != 1) {
            fragManager.popBackStack();
            if (this.fragManager.getBackStackEntryCount() == 0) {
                super.onBackPressed();
            }
        } else {
            finish();
        }

    }

    private void switchFragment(BaseFragment fragment, String fragmentName) {
        this.fragTransaction = getBaseFragmentManager().beginTransaction();
        this.fragTransaction.replace(R.id.flMainContainer, fragment, fragmentName);
        this.fragTransaction.addToBackStack(fragmentName);
        this.fragTransaction.commit();
    }

    private FragmentManager getBaseFragmentManager() {
        if (null == this.fragManager) {
            throw new IllegalStateException(MainActivity.class.getSimpleName() +
                    " is not initialized, call setupFragmentManager(...) first");
        }
        return this.fragManager;
    }

    private void setupFragmentManager() {
        fragManager = getFragmentManager();
    }

    private void setupNetworkApiController() {
        networkApiController = new NetworkApiController(getResources().getString(R.string.mainUrl),
                getResources().getString(R.string.applicationId),
                getResources().getString(R.string.defaultPerPage));
    }

    private void setupRealm() {
        realm = Realm.getInstance(getRealmConfig());
    }
}
