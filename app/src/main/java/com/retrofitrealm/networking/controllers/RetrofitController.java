package com.retrofitrealm.networking.controllers;

import com.retrofitrealm.database.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Phil on 10/01/2017.
 */

public interface RetrofitController {
    @GET("photos/")
    Call<List<Photo>> getAllPhotos(@Query("client_id") String clientId, @Query("per_page") String perPage);
}
