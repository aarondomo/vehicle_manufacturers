package com.aarondomo.vehiclemakersapi.di;

import com.aarondomo.vehiclemakersapi.ui.MainActivity;

import dagger.Component;


@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
