package com.aarondomo.vehiclemakersapi.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aarondomo.vehiclemakersapi.R;
import com.aarondomo.vehiclemakersapi.model.Maker;

import java.util.List;


public class ManufacturerAdapter extends RecyclerView.Adapter<ManufacturerAdapter.ManufacturerViewHolder> {

    private List<Maker> makerList;

    public ManufacturerAdapter(List<Maker> makerList) {
        this.makerList = makerList;
    }

    @Override
    public ManufacturerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view  = layoutInflater.inflate(R.layout.manufacturer_data, parent, false);

        return new ManufacturerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ManufacturerViewHolder holder, int position) {
        Maker maker = makerList.get(position);

        if(maker != null
                && maker.getCountry() != null
                && maker.getMfrCommonName() != null
                && maker.getMfrID() != null){
            holder.country.setText(maker.getCountry());
            holder.name.setText(maker.getMfrCommonName());
            holder.manufacturerId.setText(maker.getMfrID().toString());
        }

    }


    @Override
    public int getItemCount() {
        return makerList != null? makerList.size() : 0;
    }

    public class ManufacturerViewHolder extends RecyclerView.ViewHolder{

        private TextView country;
        private TextView name;
        private TextView manufacturerId;

        public ManufacturerViewHolder(View itemView) {

            super(itemView);

            country = (TextView) itemView.findViewById(R.id.country);
            name = (TextView) itemView.findViewById(R.id.name);
            manufacturerId = (TextView) itemView.findViewById(R.id.manufacturer_id);

        }
    }
}
