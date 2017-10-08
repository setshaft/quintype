package com.quintype.pojos.requests;

import com.quintype.enums.Color;
import com.quintype.pojos.CartesianPoints;

public class CreateUserReq {

    public CartesianPoints location;
    public Color           preference;

    @Override
    public String toString() {
        return "CreateUserReq [location=" + location + ", preference=" + preference + "]";
    }
}
