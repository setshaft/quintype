package com.quintype.managers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import models.Car;
import models.User;

import com.quintype.enums.Color;
import com.quintype.pojos.requests.CreateCarReq;
import com.quintype.pojos.requests.CreateRideReq;
import com.quintype.pojos.requests.DeleteCarReq;
import com.quintype.pojos.requests.GetCarReq;
import com.quintype.pojos.requests.GetCarsReq;
import com.quintype.pojos.requests.RequestCarReq;
import com.quintype.pojos.requests.UpdateCarReq;
import com.quintype.pojos.responses.CreateCarRes;
import com.quintype.pojos.responses.DeleteCarRes;
import com.quintype.pojos.responses.GetCarRes;
import com.quintype.pojos.responses.GetCarsRes;
import com.quintype.pojos.responses.RequestCarRes;
import com.quintype.pojos.responses.UpdateCarRes;

public class CarManager {
//  CRUD MODEL
    public static CreateCarRes createCar(CreateCarReq createCarReq) {
        Car car = new Car(createCarReq.location, createCarReq.color, createCarReq.ownerName,
                createCarReq.isAvailable);
        Car.create(car);
        CreateCarRes response = new CreateCarRes();
        response.car = car;
        return response;
    }

    public static GetCarRes getCar(GetCarReq getCarReq) {
        Car car = Car.getCar(getCarReq.carId);
        GetCarRes response = new GetCarRes();
        response.car = car;
        return response;
    }

    public static GetCarsRes getCars(GetCarsReq getCarsReq) {
        List<Car> cars = Car.all();
        GetCarsRes response = new GetCarsRes();
        response.cars = cars;
        return response;
    }

    public static UpdateCarRes updateCar(UpdateCarReq updateCarReq) {
        Car car = Car.update(updateCarReq.carId, updateCarReq.location, updateCarReq.color,
                updateCarReq.ownerName, updateCarReq.isAvailable);
        UpdateCarRes response = new UpdateCarRes();
        response.car = car;
        return response;
    }

    public static DeleteCarRes deleteCar(DeleteCarReq deleteCarReq) {
        Car car = Car.delete(deleteCarReq.carId);
        DeleteCarRes response = new DeleteCarRes();
        response.car = car;
        return response;
    }
//  CRUD MODEL END

    public static RequestCarRes requestCar(RequestCarReq requestCarReq) {
        RequestCarRes response = new RequestCarRes();
        List<Car> cars = Car.all();
        //calculating distances of all cars matched the preference saving in a map with car id
        Map<String, Double> distances = new HashMap<String, Double>();
        User user = User.getUser(requestCarReq.userId);
        for (Car car : cars) {
            if(user.preference.equals(car.color) || user.preference.equals(Color.ALL)){
                double distance = Math
                        .sqrt((requestCarReq.userLocation.latitude - car.location.latitude)
                                * (requestCarReq.userLocation.latitude - car.location.latitude)
                                + (requestCarReq.userLocation.longitude - car.location.longitude)
                                * (requestCarReq.userLocation.longitude - car.location.longitude));
                distances.put(car.id, distance);
            }
        }
        //rejecting customer request
        if(distances.isEmpty()){
            response.requested = false;
            response.message = "No Cars matching your preference or No cars available at this time";
            return response;
        }
        // sorting the map according to distance
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(
                distances.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        //getting first car from sorted map
        String carId = sortedMap.keySet().iterator().next();
        Car car = Car.getCar(carId);
        // creating a ride if there is a car
        CreateRideReq createRideReq = new CreateRideReq();
        createRideReq.startLocation = requestCarReq.userLocation;
        createRideReq.timestarted = System.currentTimeMillis();
        createRideReq.userId = requestCarReq.userId;
        createRideReq.carId = car.id;
        RideManager.createRide(createRideReq);
        // updating car availability
        car.isAvailable = false;
        Car.getCar().save(car);

        response.requested = true;
        response.message = "Car requested with your preference! Enjoy Your ride.";
        return response;
    }
}
