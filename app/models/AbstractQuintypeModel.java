package models;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;

import com.quintype.enums.RecordState;

public class AbstractQuintypeModel {

    @Id
    @ObjectId
    public String      id;
    public RecordState recordState;

    public AbstractQuintypeModel() {
        super();
    }

    public AbstractQuintypeModel(String id, RecordState recordState) {
        super();
        this.id = id;
        this.recordState = recordState;
    }
}
