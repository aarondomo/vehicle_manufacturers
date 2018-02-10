package com.aarondomo.vehiclemakersapi.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private static final String BASE_URL = "https://vpic.nhtsa.dot.gov/";

    public VehiclesAPI getRemoteService(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(VehiclesAPI.class);

    }


}
