package com.aarondomo.vehiclemakersapi.utils;

import com.aarondomo.vehiclemakersapi.model.Maker;

import java.util.Comparator;



public class SortById implements Comparator<Maker> {

    @Override
    public int compare(Maker maker, Maker t1) {
        return maker.getMfrID() - t1.getMfrID();
    }


}
