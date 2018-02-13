package com.aarondomo.vehiclemakersapi.presenter;


import android.util.Log;

import com.aarondomo.vehiclemakersapi.model.Maker;
import com.aarondomo.vehiclemakersapi.model.Results;
import com.aarondomo.vehiclemakersapi.remote.VehiclesAPI;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {

    private static final String REQUEST_FORMAT = "json";
    private static final String ERROR_MSG = "upps! something went wrong";

    private static final String TAG = MainActivityPresenter.class.getName();

    private View view;

    private VehiclesAPI remoteService;

    public interface View {
        void displayData(List<Maker> makerList);
        void showError(String error);
    }

    public void attachView(MainActivityPresenter.View view){
        this.view = view;
    }

    public void dettachView(){
        this.view = null;
    }

    public MainActivityPresenter(VehiclesAPI remoteService) {
        this.remoteService = remoteService;
    }

    public void loadData(){

        Observer observer = new Observer<List<Maker>>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Maker> makers) {
                view.displayData(makers);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.toString());
                view.showError(ERROR_MSG);
            }

            @Override
            public void onComplete() {

            }
        };

        remoteService.getResults(REQUEST_FORMAT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<Results, List<Maker>>() {
                    @Override
                    public List<Maker> apply(Results results) throws Exception {
                        return results.getMakers();
                    }
                })
                .subscribe(observer);
    }



}
