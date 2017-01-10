package com.retrofitrealm.networking.controllers;

import com.retrofitrealm.database.Photo;

import java.util.List;

/**
 * Created by Phil on 10/01/2017.
 */

public interface NetworkController {
    void getAllPhotos(NetworkListener<List<Photo>> networkListener);
}
