package com.quintype.pojos.requests;

import com.quintype.enums.Color;
import com.quintype.pojos.CartesianPoints;

public class RequestCarReq {
    public CartesianPoints userLocation;
    public Color           preference;
    public String          userId;
    @Override
    public String toString() {
        return "RequestCarReq [userLocation=" + userLocation + ", preference=" + preference
                + ", userId=" + userId + "]";
    }
}
