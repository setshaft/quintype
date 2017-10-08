package com.quintype.pojos.requests;

import com.quintype.enums.Color;
import com.quintype.pojos.CartesianPoints;

public class CreateCarReq {

    public CartesianPoints location;
    public Color color;
    public String ownerName;
    public boolean isAvailable;

    @Override
    public String toString() {
        return "CreateCarReq [location=" + location + ", color=" + color + ", ownerName="
                + ownerName + ", isAvailable=" + isAvailable + "]";
    }

}
