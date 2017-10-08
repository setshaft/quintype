package com.quintype.pojos.requests;

import com.quintype.pojos.CartesianPoints;

public class UpdateRideReq {

    public long            timestarted;
    public long            timeended;
    public CartesianPoints startLocation;
    public CartesianPoints endLocation;
    public int             cost;
    public String          carId;
    public String          rideId;
    public String          userId;
    @Override
    public String toString() {
        return "UpdateRideReq [timestarted=" + timestarted + ", timeended=" + timeended
                + ", startLocation=" + startLocation + ", endLocation=" + endLocation + ", cost="
                + cost + ", carId=" + carId + ", rideId=" + rideId + ", userId=" + userId + "]";
    }
}
