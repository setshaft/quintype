package com.quintype.pojos.requests;

import com.quintype.pojos.CartesianPoints;

public class EndRideReq {

    public String          userId;
    public String          rideId;
    public CartesianPoints endLocation;

    @Override
    public String toString() {
        return "EndRideReq [userId=" + userId + ", rideId=" + rideId + ", endLocation="
                + endLocation + "]";
    }
}
