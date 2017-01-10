package com.retrofitrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.retrofitrealm.R;
import com.retrofitrealm.adapters.PhotosAdapter;
import com.retrofitrealm.database.Photo;
import com.retrofitrealm.fragments.assets.BaseFragment;
import com.retrofitrealm.networking.controllers.NetworkListener;

import java.util.List;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Phil on 10/01/2017.
 */

public class ImagesFragment extends BaseFragment {

    private static String TV_VALUE = "tvValue";

    @BindView(R.id.rvPhotos)
    RecyclerView rvPhotos;

    public static BaseFragment newInstance(String tvValue) {
        ImagesFragment imagesFragment = new ImagesFragment();
        Bundle arg0 = new Bundle();
        arg0.putString(TV_VALUE, tvValue);
        imagesFragment.setArguments(arg0);
        return imagesFragment;
    }

    @Override
    public int getLayout() {
        return R.layout.images_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setupRecyclerView();
        loadData();
        return view;
    }

    private void setupRecyclerView() {
        rvPhotos.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mainActivityInterface.getParentContext());
        rvPhotos.setLayoutManager(mLayoutManager);
    }

    private void loadData() {
        if(mainActivityInterface.isNetworkAvailable()) {
            networkController.getAllPhotos(new NetworkListener<List<Photo>>() {
                @Override
                public void onResponse(Call<List<Photo>> call, final Response<List<Photo>> response) {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.insertOrUpdate(response.body());
                            loadIntoRecyclerview(realm.where(Photo.class).findAll());
                        }

                    });
                }

                @Override
                public void onFailure(Call<List<Photo>> call, Throwable t) {
                    t.printStackTrace();
                    loadFromDatabase();
                }
            });
        } else {
            loadFromDatabase();
        }
    }

    private void loadFromDatabase() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Photo> photoResults = realm.where(Photo.class).findAll();
                if(photoResults.size() != 0) {
                    loadIntoRecyclerview(photoResults);
                } else {
                    Toast.makeText(mainActivityInterface.getParentContext(), "No data in database", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loadIntoRecyclerview(RealmResults<Photo> photoRealmResults) {
        mainActivityInterface.printOut("Realm Results", photoRealmResults.size());
        PhotosAdapter photosAdapter = new PhotosAdapter(photoRealmResults, mainActivityInterface.getParentContext());
        rvPhotos.setAdapter(photosAdapter);
    }
}
