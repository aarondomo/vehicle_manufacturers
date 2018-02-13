package com.aarondomo.vehiclemakersapi.remote;


import com.aarondomo.vehiclemakersapi.model.Results;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VehiclesAPI {

    @GET("api/vehicles/getallmanufacturers")
    Observable<Results> getResults(@Query("format") String format);
}
