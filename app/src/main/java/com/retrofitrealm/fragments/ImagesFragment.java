package com.retrofitrealm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.retrofitrealm.R;
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

    @BindView(R.id.tvTitle)
    TextView tvTitle;

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
        tvTitle.setText(getArguments().getString(TV_VALUE));
        loadData();
        return view;
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
                            loadIntoRecyclerView();
                        }

                    });
                }

                @Override
                public void onFailure(Call<List<Photo>> call, Throwable t) {
                    t.printStackTrace();
                    loadIntoRecyclerView();
                }
            });
        } else {
            loadIntoRecyclerView();
        }
    }

    private void loadIntoRecyclerView() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Photo> photoResults = realm.where(Photo.class).findAll();
            }
        });
    }
}
