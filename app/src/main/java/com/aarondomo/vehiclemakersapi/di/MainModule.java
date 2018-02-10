package com.aarondomo.vehiclemakersapi.di;

import android.content.Context;

import com.aarondomo.vehiclemakersapi.presenter.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private Context context;

    public MainModule() {
    }

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    public MainActivityPresenter getPresenter(){
        return new MainActivityPresenter();
    }
}
