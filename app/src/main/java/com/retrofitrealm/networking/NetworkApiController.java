package com.retrofitrealm.networking;

import com.retrofitrealm.database.Photo;
import com.retrofitrealm.networking.clients.ApiClient;
import com.retrofitrealm.networking.controllers.NetworkController;
import com.retrofitrealm.networking.controllers.NetworkListener;
import com.retrofitrealm.networking.controllers.RetrofitController;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Phil on 10/01/2017.
 */

public class NetworkApiController implements NetworkController {

    private RetrofitController retrofitController;
    private String clientId;
    private String perPage;

    public NetworkApiController(String baseUrl, String clientId, String perPage) {
        ApiClient apiClient = new ApiClient(baseUrl);
        Retrofit retrofitClient = apiClient.getApiRetrofit();
        retrofitController = retrofitClient.create(RetrofitController.class);
        this.clientId = clientId;
        this.perPage = perPage;
    }

    @Override
    public void getAllPhotos(final NetworkListener<List<Photo>> networkListener) {
        Call<List<Photo>> networkGetAllPhotos = retrofitController.getAllPhotos(this.clientId, this.perPage);
        networkGetAllPhotos.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                networkListener.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                networkListener.onFailure(call, t);
            }
        });
    }
}
