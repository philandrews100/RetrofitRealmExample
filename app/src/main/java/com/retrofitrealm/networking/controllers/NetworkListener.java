package com.retrofitrealm.networking.controllers;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Phil on 10/01/2017.
 */

public interface NetworkListener<A> {
    void onResponse(Call<A> call, Response<A> response);
    void onFailure(Call<A> call, Throwable t);
}
