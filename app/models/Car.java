package models;

import java.util.List;

import net.vz.mongodb.jackson.JacksonDBCollection;
import play.modules.mongodb.jackson.MongoDB;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.quintype.enums.Color;
import com.quintype.enums.RecordState;
import com.quintype.pojos.CartesianPoints;

public class Car extends AbstractQuintypeModel {

    public CartesianPoints                          location;
    public Color                                    color;
    public String                                   ownerName;
    public boolean                                  isAvailable;

    private static JacksonDBCollection<Car, String> car = MongoDB.getCollection("cars", Car.class,
                                                                String.class);

    public Car() {
        super();
    }

    public Car(CartesianPoints location, Color color, String ownerName, boolean isAvailable) {
        super();
        this.location = location;
        this.color = color;
        this.ownerName = ownerName;
        this.isAvailable = isAvailable;
    }

    public static Car getCar(String carId) {
        Car car = Car.car.findOneById(carId);
        return car;
    }

    public static List<Car> all() {

        DBObject query = new BasicDBObject();
        query.put("isAvailable",true);
        return Car.getCar().find(query).toArray();
    }

    public static void create(Car car) {
        Car.getCar().save(car);
    }

    public static void create(CartesianPoints location, Color color, String ownerName) {
        create(new Car(location, color, ownerName, true));
    }

    public static Car delete(String id) {
        Car car = Car.getCar().findOneById(id);
        if (car != null) {
            car.recordState = RecordState.DELETED;
            Car.getCar().save(car);
        }
        return car;
    }

    public static Car update(String carId, CartesianPoints location, Color color, String ownerName,
            boolean isAvailable) {
        Car car = Car.getCar().findOneById(carId);
        car.location = location;
        car.color = color;
        car.ownerName = ownerName;
        car.isAvailable = isAvailable;
        return car;
    }

    public static void removeAll() {
        Car.getCar().drop();
    }

    @Override
    public String toString() {
        return "Car [location=" + location + ", color=" + color + ", ownerName=" + ownerName
                + ", isAvaialable=" + isAvailable + ", id=" + id + ", recordState=" + recordState
                + "]";
    }

    public static JacksonDBCollection<Car, String> getCar() {
        return car;
    }

    public static void setCar(JacksonDBCollection<Car, String> car) {
        Car.car = car;
    }

}
