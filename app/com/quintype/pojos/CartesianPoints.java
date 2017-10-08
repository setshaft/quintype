package com.quintype.pojos;

public class CartesianPoints {
    public double longitude;
    public double latitude;

    public CartesianPoints() {
        super();
    }

    public CartesianPoints(double longitude, double latitude) {
        super();
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "CartesianPoints [longitude=" + longitude + ", latitude=" + latitude + "]";
    }
}
