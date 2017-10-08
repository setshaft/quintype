package com.quintype.pojos.requests;

import com.quintype.pojos.CartesianPoints;

public class CreateRideReq {

    public long            timestarted;
    public CartesianPoints startLocation;
    public String          carId;
    public String          userId;

    @Override
    public String toString() {
        return "CreateRideReq [timestarted=" + timestarted + ", startLocation=" + startLocation
                + ", carId=" + carId + ", userId=" + userId + "]";
    }

}
