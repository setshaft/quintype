package models;

import java.util.List;

import play.modules.mongodb.jackson.MongoDB;
import net.vz.mongodb.jackson.JacksonDBCollection;

import com.quintype.enums.RecordState;
import com.quintype.pojos.CartesianPoints;

public class Ride extends AbstractQuintypeModel {
    public long                                      timestarted;
    public long                                      timeended;
    public CartesianPoints                           startLocation;
    public CartesianPoints                           endLocation;
    public int                                       cost;
    public String                                    carId;
    public String                                    userId;

    private static JacksonDBCollection<Ride, String> ride = MongoDB.getCollection("rides",
                                                                  Ride.class, String.class);

    public Ride() {
        super();
    }

    public Ride(long timestarted, long timeended, CartesianPoints startLocation,
            CartesianPoints endLocation, int cost, String carId, String userId) {
        super();
        this.timestarted = timestarted;
        this.timeended = timeended;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.cost = cost;
        this.carId = carId;
        this.userId = userId;
    }

    public static Ride getRide(String rideId) {
        Ride ride = Ride.ride.findOneById(rideId);
        return ride;
    }

    public static List<Ride> all() {
        return Ride.getRide().find().toArray();
    }

    public static void create(Ride ride) {
        Ride.getRide().save(ride);
    }

    public static void create(long timestarted, long timeended, CartesianPoints startLocation,
            CartesianPoints endLocation, int cost, String carId, String userId) {
        create(new Ride(timestarted, 0L, startLocation, null, 0, carId, userId));
    }

    public static Ride delete(String id) {
        Ride ride = Ride.getRide().findOneById(id);
        if (ride != null) {
            ride.recordState = RecordState.DELETED;
            Ride.getRide().save(ride);
        }
        return ride;
    }

    public static Ride update(String rideId, long timestarted, long timeended,
            CartesianPoints startLocation, CartesianPoints endLocation, int cost, String carId,
            String userId) {
        Ride ride = Ride.getRide().findOneById(rideId);
        ride.timestarted = timestarted;
        ride.timeended = timeended;
        ride.startLocation = startLocation;
        ride.endLocation = endLocation;
        ride.cost = cost;
        ride.carId = carId;
        ride.userId = userId;
        Ride.getRide().save(ride);
        return ride;
    }

    public static void removeAll() {
        Ride.getRide().drop();
    }

    @Override
    public String toString() {
        return "Ride [timestarted=" + timestarted + ", timeended=" + timeended + ", startLocation="
                + startLocation + ", endLocation=" + endLocation + ", cost=" + cost + ", carId="
                + carId + ", userId=" + userId + ", id=" + id + ", recordState=" + recordState
                + "]";
    }

    public static JacksonDBCollection<Ride, String> getRide() {
        return ride;
    }

    public static void setRide(JacksonDBCollection<Ride, String> ride) {
        Ride.ride = ride;
    }

}
