package com.example.ecommercemarto.Domain;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class LocationDomain implements Serializable {


    private int Id;
    private String loc;



    public LocationDomain(int id, String loc) {
        Id = id;
        this.loc = loc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public LocationDomain() {
    }
}
