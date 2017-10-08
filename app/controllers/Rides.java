package controllers;

import com.quintype.managers.RideManager;
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

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Rides extends Controller {

    public static Result createRide() {
        Form<CreateRideReq> createRideForm = Form.form(CreateRideReq.class).bindFromRequest();
        if (createRideForm.hasErrors()) {
            return ok("missing parameters");
        }
        CreateRideReq createRideReq = createRideForm.get();
        CreateRideRes createRideRes = RideManager.createRide(createRideReq);
        return ok(createRideRes.toString());
    }

    public static Result getRide() {
        Form<GetRideReq> getRideForm = Form.form(GetRideReq.class).bindFromRequest();
        if (getRideForm.hasErrors()) {
            return ok("missing parameters");
        }
        GetRideReq getRideReq = getRideForm.get();
        GetRideRes getRideRes = RideManager.getRide(getRideReq);
        return ok(getRideRes.toString());
    }

    public static Result getRides() {
        Form<GetRidesReq> getRidesForm = Form.form(GetRidesReq.class).bindFromRequest();
        if (getRidesForm.hasErrors()) {
            return ok("missing parameters");
        }
        GetRidesReq getRidesReq = getRidesForm.get();
        GetRidesRes getRidesRes = RideManager.getRides(getRidesReq);
        return ok(getRidesRes.toString());
    }

    public static Result updateRide() {
        Form<UpdateRideReq> updateRideForm = Form.form(UpdateRideReq.class).bindFromRequest();
        if (updateRideForm.hasErrors()) {
            return ok("missing parameters");
        }
        UpdateRideReq updateRideReq = updateRideForm.get();
        UpdateRideRes updateRideRes = RideManager.updateRide(updateRideReq);
        return ok(updateRideRes.toString());
    }

    public static Result deleteRide() {
        Form<DeleteRideReq> deleteRideForm = Form.form(DeleteRideReq.class).bindFromRequest();
        if (deleteRideForm.hasErrors()) {
            return ok("missing parameters");
        }
        DeleteRideReq deleteRideReq = deleteRideForm.get();
        DeleteRideRes deleteRideRes = RideManager.deleteRide(deleteRideReq);
        return ok(deleteRideRes.toString());
    }

    public static Result endRide() {
        Form<EndRideReq> endRideForm = Form.form(EndRideReq.class).bindFromRequest();
        if (endRideForm.hasErrors()) {
            return ok("missing parameters");
        }
        EndRideReq endRideReq = endRideForm.get();
        EndRideRes endRideRes = RideManager.endRide(endRideReq);
        return ok(endRideRes.toString());
    }

}
