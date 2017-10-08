package com.quintype.managers;

import java.util.List;

import models.Car;
import models.Ride;
import models.User;

import com.quintype.enums.Color;
import com.quintype.pojos.requests.CreateRideReq;
import com.quintype.pojos.requests.DeleteRideReq;
import com.quintype.pojos.requests.EndRideReq;
import com.quintype.pojos.requests.GetRideReq;
import com.quintype.pojos.requests.GetRidesReq;
import com.quintype.pojos.requests.UpdateRideReq;
import com.quintype.pojos.responses.CreateRideRes;
import com.quintype.pojos.responses.DeleteRideRes;
import com.quintype.pojos.responses.EndRideRes;
import com.quintype.pojos.responses.GetRideRes;
import com.quintype.pojos.responses.GetRidesRes;
import com.quintype.pojos.responses.UpdateRideRes;

public class RideManager {
//    CRUD MODEL
    public static CreateRideRes createRide(CreateRideReq createRideReq) {
        Ride ride = new Ride(createRideReq.timestarted, 0L, createRideReq.startLocation, null, 0,
                createRideReq.carId, createRideReq.userId);
        Ride.create(ride);
        CreateRideRes response = new CreateRideRes();
        response.ride = ride;
        return response;
    }

    public static GetRideRes getRide(GetRideReq getRideReq) {
        Ride ride = Ride.getRide(getRideReq.rideId);
        GetRideRes response = new GetRideRes();
        response.ride = ride;
        return response;
    }

    public static GetRidesRes getRides(GetRidesReq getRidesReq) {
        List<Ride> rides = Ride.all();
        GetRidesRes response = new GetRidesRes();
        response.rides = rides;
        return response;
    }

    public static UpdateRideRes updateRide(UpdateRideReq updateRideReq) {
        Ride ride = Ride.update(updateRideReq.rideId, updateRideReq.timestarted,
                updateRideReq.timeended, updateRideReq.startLocation, updateRideReq.endLocation,
                updateRideReq.cost, updateRideReq.carId, updateRideReq.userId);
        UpdateRideRes response = new UpdateRideRes();
        response.ride = ride;
        return response;
    }

    public static DeleteRideRes deleteRide(DeleteRideReq deleteRideReq) {
        Ride ride = Ride.delete(deleteRideReq.rideId);
        DeleteRideRes response = new DeleteRideRes();
        response.ride = ride;
        return response;
    }
//    CRUD MODEL END
    public static EndRideRes endRide(EndRideReq endRideReq) {
        Ride ride = Ride.getRide(endRideReq.rideId);
        EndRideRes response = new EndRideRes();
        // if ride not there return with error
        if(ride == null){
            response.cost = 0;
            response.message = "Ride not found";
        }
        //updating ride
        ride.endLocation = endRideReq.endLocation;
        ride.timeended = System.currentTimeMillis();
        // getting the difference of endtime and starttime in minutes for calculating the cost
        long difference = ride.timeended - ride.timestarted;
        long diffMinutes = difference / (60 * 1000) % 60;
        double distance = Math
                .sqrt((ride.startLocation.latitude - ride.endLocation.latitude)
                        * (ride.startLocation.latitude - ride.endLocation.latitude)
                        + (ride.startLocation.longitude - ride.endLocation.longitude)
                        * (ride.startLocation.longitude - ride.endLocation.longitude));
        int cost = (int) (diffMinutes + (distance *2));
        User user = User.getUser(ride.userId);
        // adding 5 dogecoins to the cost if the car color preference is pink
        if(user.preference.equals(Color.PINK)){
            cost += 5;
        }

        ride.cost = cost;
        Ride.getRide().save(ride);
        //updating the car location and availability after ending the ride.
        Car car = Car.getCar(ride.carId);
        car.location = endRideReq.endLocation;
        car.isAvailable = true;
        Car.getCar().save(car);
        response.cost = cost;
        response.message = "Ride Ended Successfully";
        return response;
    }

}
