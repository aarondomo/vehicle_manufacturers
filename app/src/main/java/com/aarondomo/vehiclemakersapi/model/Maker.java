package com.aarondomo.vehiclemakersapi.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Maker {

    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Mfr_CommonName")
    @Expose
    private String mfrCommonName;
    @SerializedName("Mfr_ID")
    @Expose
    private Integer mfrID;
    @SerializedName("Mfr_Name")
    @Expose
    private String mfrName;
    @SerializedName("VehicleTypes")
    @Expose
    private List<VehicleType> vehicleTypes = null;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMfrCommonName() {
        return mfrCommonName;
    }

    public void setMfrCommonName(String mfrCommonName) {
        this.mfrCommonName = mfrCommonName;
    }

    public Integer getMfrID() {
        return mfrID;
    }

    public void setMfrID(Integer mfrID) {
        this.mfrID = mfrID;
    }

    public String getMfrName() {
        return mfrName;
    }

    public void setMfrName(String mfrName) {
        this.mfrName = mfrName;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

}
