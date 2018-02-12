package com.aarondomo.vehiclemakersapi.presenter;


import com.aarondomo.vehiclemakersapi.model.Maker;
import com.aarondomo.vehiclemakersapi.model.Results;
import com.aarondomo.vehiclemakersapi.remote.RemoteDataSource;
import com.aarondomo.vehiclemakersapi.remote.VehiclesAPI;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter {

    private static final String REQUEST_FORMAT = "json";
    private static final String ERROR_MESSAGE = "upps! something went wrong";

    private static final String TAG = MainActivityPresenter.class.getName();

    private View view;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

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

        compositeDisposable.add((Disposable) service.getResults(REQUEST_FORMAT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Results, List<Maker>>() {
                    @Override
                    public List<Maker> apply(Results results) throws Exception {
                        return results.getMakers();
                    }
                })
                .subscribe(new Consumer<List<Maker>>() {
                    @Override
                    public void accept(List<Maker> makers) throws Exception {
                        view.displayData(makers);
                    }
                })
        );

    }

}
