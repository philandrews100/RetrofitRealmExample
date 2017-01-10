package com.retrofitrealm.fragments.assets;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.retrofitrealm.assets.AppUtils;
import com.retrofitrealm.controllers.MainActivityInterface;
import com.retrofitrealm.networking.controllers.NetworkController;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;

/**
 * Created by Phil on 10/01/2017.
 */

public abstract class BaseFragment extends Fragment implements AppUtils {

    private Unbinder baseUnbinder;

    public Realm realm;
    public MainActivityInterface mainActivityInterface;
    public NetworkController networkController;

    public abstract int getLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        baseUnbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != baseUnbinder)
            baseUnbinder.unbind();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivityInterface = (MainActivityInterface) context;
        networkController = (NetworkController) context;
        setupRealm();
    }

    private void setupRealm() {
        realm = mainActivityInterface.getRealmInstance() != null ?
                mainActivityInterface.getRealmInstance()
                : Realm.getInstance(mainActivityInterface.getRealmConfig());
    }
}
