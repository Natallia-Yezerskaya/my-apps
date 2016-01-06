package com.test.lesson18.network;

import android.util.Log;

import com.test.lesson18.HttpLoggingInterceptor;
import com.test.lesson18.OttoProvider;
import com.test.lesson18.events.CurrencyResponse;
import com.test.lesson18.network.api.ICurrencyApi;


import org.json.JSONObject;


import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by USER on 06.01.2016.
 */
public class ServiceHelper {
    private static ServiceHelper ourInstance = new ServiceHelper();
    private Retrofit mRetrofit;

    public static ServiceHelper getInstance() {
        return ourInstance;
    }

    private ServiceHelper() {
    }

    private Retrofit getRetrofit(){
        if (mRetrofit!=null) return mRetrofit;

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.interceptors().add(new HttpLoggingInterceptor());

       // httpClient.



       mRetrofit = new Retrofit.Builder().baseUrl("http://api.fixer.io/").addConverterFactory(GsonConverterFactory.create()).build();

        return mRetrofit;
    }

    public void retriveCurrency(){

        ICurrencyApi api = getRetrofit().create(ICurrencyApi.class);
        Call<JSONObject> call = api.getCurrency();

        //call.execute(); //
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Response<JSONObject> response) {

                JSONObject body = response.body();
                if (response.isSuccess()&&body!=null){
                    Log.d("onResponse","IS SUCCESS "+ body.toString());
                    CurrencyResponse responseOtto = new CurrencyResponse();
                    OttoProvider.getBus().post(responseOtto);
                }
                else {
                    Log.d("onResponse","IS NOT SUCCESS ");
                    CurrencyResponse responseOtto = new CurrencyResponse();
                    responseOtto.setError(true);
                    OttoProvider.getBus().post(responseOtto);
                }


            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d("ServiceHelper","onFailure");
                CurrencyResponse response = new CurrencyResponse();
                response.setError(true);
                OttoProvider.getBus().post(response);
            }
        });


        CurrencyResponse response = new CurrencyResponse();
        response.setError(true);
        OttoProvider.getBus().post(response);

    }
}
