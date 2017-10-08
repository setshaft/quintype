package controllers;

import com.quintype.managers.UserManager;
import com.quintype.pojos.requests.CreateUserReq;
import com.quintype.pojos.requests.DeleteUserReq;
import com.quintype.pojos.requests.GetUserReq;
import com.quintype.pojos.requests.GetUsersReq;
import com.quintype.pojos.requests.UpdateUserReq;
import com.quintype.pojos.responses.CreateUserRes;
import com.quintype.pojos.responses.DeleteUserRes;
import com.quintype.pojos.responses.GetUserRes;
import com.quintype.pojos.responses.GetUsersRes;
import com.quintype.pojos.responses.UpdateUserRes;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Users extends Controller {

    public static Result createUser() {
        Form<CreateUserReq> createUserForm = Form.form(CreateUserReq.class).bindFromRequest();
        if (createUserForm.hasErrors()) {
            return ok("missing parameters");
        }
        CreateUserReq createUserReq = createUserForm.get();
        CreateUserRes createUserRes = UserManager.createUser(createUserReq);
        return ok(createUserRes.toString());
    }

    public static Result getUser() {
        Form<GetUserReq> getUserForm = Form.form(GetUserReq.class).bindFromRequest();
        if (getUserForm.hasErrors()) {
            return ok("missing parameters");
        }
        GetUserReq getUserReq = getUserForm.get();
        GetUserRes getUserRes = UserManager.getUser(getUserReq);
        return ok(getUserRes.toString());
    }

    public static Result getUsers() {
        Form<GetUsersReq> getUsersForm = Form.form(GetUsersReq.class).bindFromRequest();
        if (getUsersForm.hasErrors()) {
            return ok("missing parameters");
        }
        GetUsersReq getUsersReq = getUsersForm.get();
        GetUsersRes getUsersRes = UserManager.getUsers(getUsersReq);
        return ok(getUsersRes.toString());
    }

    public static Result updateUser() {
        Form<UpdateUserReq> updateUserForm = Form.form(UpdateUserReq.class).bindFromRequest();
        if (updateUserForm.hasErrors()) {
            return ok("missing parameters");
        }
        UpdateUserReq updateUserReq = updateUserForm.get();
        UpdateUserRes updateUserRes = UserManager.updateUser(updateUserReq);
        return ok(updateUserRes.toString());
    }

    public static Result deleteUser() {
        Form<DeleteUserReq> deleteUserForm = Form.form(DeleteUserReq.class).bindFromRequest();
        if (deleteUserForm.hasErrors()) {
            return ok("missing parameters");
        }
        DeleteUserReq deleteUserReq = deleteUserForm.get();
        DeleteUserRes deleteUserRes = UserManager.deleteUser(deleteUserReq);
        return ok(deleteUserRes.toString());
    }
}
