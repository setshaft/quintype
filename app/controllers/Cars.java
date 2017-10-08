package controllers;

import com.quintype.managers.CarManager;
import com.quintype.pojos.requests.CreateCarReq;
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

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Cars extends Controller {

    public static Result createCar() {
        Form<CreateCarReq> createCarForm = Form.form(CreateCarReq.class).bindFromRequest();
        if (createCarForm.hasErrors()) {
            return ok("missing parameters");
        }
        CreateCarReq createCarReq = createCarForm.get();
        CreateCarRes createCarRes = CarManager.createCar(createCarReq);
        return ok(createCarRes.toString());
    }

    public static Result getCar() {
        Form<GetCarReq> getCarForm = Form.form(GetCarReq.class).bindFromRequest();
        if (getCarForm.hasErrors()) {
            return ok("missing parameters");
        }
        GetCarReq getCarReq = getCarForm.get();
        GetCarRes getCarRes = CarManager.getCar(getCarReq);
        return ok(getCarRes.toString());
    }

    public static Result getCars() {
        Form<GetCarsReq> getCarsForm = Form.form(GetCarsReq.class).bindFromRequest();
        if (getCarsForm.hasErrors()) {
            return ok("missing parameters");
        }
        GetCarsReq getCarsReq = getCarsForm.get();
        GetCarsRes getCarsRes = CarManager.getCars(getCarsReq);
        return ok(getCarsRes.toString());
    }

    public static Result updateCar() {
        Form<UpdateCarReq> updateCarForm = Form.form(UpdateCarReq.class).bindFromRequest();
        if (updateCarForm.hasErrors()) {
            return ok("missing parameters");
        }
        UpdateCarReq updateCarReq = updateCarForm.get();
        UpdateCarRes updateCarRes = CarManager.updateCar(updateCarReq);
        return ok(updateCarRes.toString());
    }

    public static Result deleteCar() {
        Form<DeleteCarReq> deleteCarForm = Form.form(DeleteCarReq.class).bindFromRequest();
        if (deleteCarForm.hasErrors()) {
            return ok("missing parameters");
        }
        DeleteCarReq deleteCarReq = deleteCarForm.get();
        DeleteCarRes deleteCarRes = CarManager.deleteCar(deleteCarReq);
        return ok(deleteCarRes.toString());
    }

    public static Result requestCar() {
        Form<RequestCarReq> requestCarForm = Form.form(RequestCarReq.class).bindFromRequest();
        if (requestCarForm.hasErrors()) {
            return ok("missing parameters");
        }
        RequestCarReq requestCarReq = requestCarForm.get();
        RequestCarRes requestCarRes = CarManager.requestCar(requestCarReq);
        return ok(requestCarRes.toString());
    }

}
