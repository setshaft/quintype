package models;

import java.util.List;

import play.modules.mongodb.jackson.MongoDB;
import net.vz.mongodb.jackson.JacksonDBCollection;

import com.quintype.enums.Color;
import com.quintype.enums.RecordState;
import com.quintype.pojos.CartesianPoints;

public class User extends AbstractQuintypeModel {
    public CartesianPoints                           location;
    public Color                                     preference;

    private static JacksonDBCollection<User, String> user = MongoDB.getCollection("users",
                                                                  User.class, String.class);

    public User() {
        super();
    }

    public User(CartesianPoints location, Color preference) {
        super();
        this.location = location;
        this.preference = preference;
    }

    public static User getUser(String id){
        User user = User.user.findOneById(id);
        return user;
    }

    public static List<User> all() {
        return User.user.find().toArray();
    }

    public static void create(User user) {
        User.user.save(user);
    }

    public static void create(CartesianPoints location, Color preference) {
        create(new User(location, preference));
    }

    public static User delete(String id) {
        User user = User.user.findOneById(id);
        if (user != null) {
            user.recordState = RecordState.DELETED;
            User.user.save(user);
        }
        return user;
    }

    public static User update(String id, CartesianPoints location, Color preference){
        User user = User.user.findOneById(id);
        user.location = location;
        user.preference = preference;
        User.user.save(user);
        return user;
    }

    public static void removeAll() {
        User.user.drop();
    }

    @Override
    public String toString() {
        return "User [location=" + location + ", preference=" + preference + ", id=" + id
                + ", recordState=" + recordState + "]";
    }
}
