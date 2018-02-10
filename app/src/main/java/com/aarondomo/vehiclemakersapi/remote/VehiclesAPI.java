package com.aarondomo.vehiclemakersapi.remote;


import com.aarondomo.vehiclemakersapi.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VehiclesAPI {

    @GET("api/vehicles/getallmanufacturers")
    Call<Results> getResults(@Query("format") String format);
}
