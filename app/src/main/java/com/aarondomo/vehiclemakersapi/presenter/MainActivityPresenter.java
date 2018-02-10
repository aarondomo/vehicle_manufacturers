package com.aarondomo.vehiclemakersapi.presenter;


import android.util.Log;

import com.aarondomo.vehiclemakersapi.model.Maker;
import com.aarondomo.vehiclemakersapi.model.Results;
import com.aarondomo.vehiclemakersapi.remote.RemoteDataSource;
import com.aarondomo.vehiclemakersapi.remote.VehiclesAPI;
import com.aarondomo.vehiclemakersapi.utils.SortById;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter {

    private static final String REQUEST_FORMAT = "json";
    private static final String ERROR_MESSAGE = "upps! something went wrong";

    private static final String TAG = MainActivityPresenter.class.getName();

    private View view;

    public interface View {
        void displayData(List<Maker> makerList);
    }

    public void attachView(MainActivityPresenter.View view){
        this.view = view;
    }

    public void dettachView(){
        this.view = null;
    }

    public void loadData(){

        RemoteDataSource remoteDataSource = new RemoteDataSource();

        VehiclesAPI service = remoteDataSource.getRemoteService();

        Call<Results> resultCall = service.getResults(REQUEST_FORMAT);

        resultCall.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {

                List<Maker> makerList = response.body().getMakers();

                Collections.sort(makerList, new SortById());

                if(makerList != null){
                    view.displayData(makerList);
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.d(TAG, ERROR_MESSAGE);
            }
        });
    }

}
