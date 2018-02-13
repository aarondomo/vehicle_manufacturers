package com.aarondomo.vehiclemakersapi.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aarondomo.vehiclemakersapi.R;
import com.aarondomo.vehiclemakersapi.di.DaggerMainComponent;
import com.aarondomo.vehiclemakersapi.di.MainModule;
import com.aarondomo.vehiclemakersapi.model.Maker;
import com.aarondomo.vehiclemakersapi.presenter.MainActivityPresenter;
import com.aarondomo.vehiclemakersapi.ui.adapter.ManufacturerAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    @Inject
    MainActivityPresenter presenter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_manufacturer);

        setUpDagger();

        presenter.attachView(this);

        presenter.loadData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    private void setUpDagger(){
        DaggerMainComponent.builder()
                .mainModule(new MainModule())
                .build()
                .inject(this);
    }

    @Override
    public void displayData(List<Maker> makerList) {

        ManufacturerAdapter manufacturerAdapter = new ManufacturerAdapter(makerList);

        recyclerView.setAdapter(manufacturerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        manufacturerAdapter.notifyDataSetChanged();

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
