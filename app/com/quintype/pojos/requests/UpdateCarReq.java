package com.quintype.pojos.requests;

import com.quintype.enums.Color;
import com.quintype.pojos.CartesianPoints;

public class UpdateCarReq {

    public String carId;
    public CartesianPoints location;
    public Color color;
    public String ownerName;
    public boolean isAvailable;

    @Override
    public String toString() {
        return "UpdateCarReq [carId=" + carId + ", location=" + location + ", color=" + color
                + ", ownerName=" + ownerName + ", isAvailable=" + isAvailable + "]";
    }


}
