package com.example.valentincloup.dijoncentervc.Model;

import java.security.spec.PSSParameterSpec;

/**
 * Created by Valentin CLOUP on 08/09/2017.
 */

public class Position
{
    private float lat;
    private float lon;

    public Position() {}

    public Position(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
