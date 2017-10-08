package com.quintype.pojos.requests;

import com.quintype.enums.Color;
import com.quintype.pojos.CartesianPoints;

public class UpdateUserReq {

    public CartesianPoints location;
    public Color           preference;
    public String          userId;
    @Override
    public String toString() {
        return "UpdateUserReq [location=" + location + ", preference=" + preference + ", userId="
                + userId + "]";
    }
}
