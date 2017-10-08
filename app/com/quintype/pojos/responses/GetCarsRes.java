package com.quintype.pojos.responses;

import java.util.List;

import models.Car;

public class GetCarsRes {

    public List<Car> cars;

    @Override
    public String toString() {
        return "GetCarsRes [cars=" + cars + "]";
    }

}
