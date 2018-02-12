package com.aarondomo.vehiclemakersapi.remote;


import com.aarondomo.vehiclemakersapi.model.Results;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VehiclesAPI {

    @GET("api/vehicles/getallmanufacturers")
    Single<Results> getResults(@Query("format") String format);
}
