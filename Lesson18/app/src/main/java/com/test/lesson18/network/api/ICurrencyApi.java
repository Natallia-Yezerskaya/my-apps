package com.test.lesson18.network.api;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by USER on 06.01.2016.
 */
public interface ICurrencyApi {

    @GET("latest")
    Call<JSONObject> getCurrency();

}
