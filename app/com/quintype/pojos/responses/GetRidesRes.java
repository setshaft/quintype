package com.quintype.pojos.responses;

import java.util.List;

import models.Ride;

public class GetRidesRes {

    public List<Ride> rides;

    @Override
    public String toString() {
        return "GetRidesRes [rides=" + rides + "]";
    }

}
