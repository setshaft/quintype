package com.quintype.managers;

import java.util.List;

import models.User;

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

public class UserManager {
//  CRUD MODEL
    public static CreateUserRes createUser(CreateUserReq createUserReq) {
        User user = new User(createUserReq.location, createUserReq.preference);
        User.create(user);
        CreateUserRes response = new CreateUserRes();
        response.user = user;
        return response;
    }

    public static GetUserRes getUser(GetUserReq getUserReq) {
        User user = User.getUser(getUserReq.userId);
        GetUserRes response = new GetUserRes();
        response.user = user;
        return response;
    }

    public static GetUsersRes getUsers(GetUsersReq getUsersReq) {
        List<User> users = User.all();
        GetUsersRes response = new GetUsersRes();
        response.users = users;
        return response;
    }

    public static UpdateUserRes updateUser(UpdateUserReq updateUserReq) {
        User user = User.update(updateUserReq.userId, updateUserReq.location, updateUserReq.preference);
        UpdateUserRes response = new UpdateUserRes();
        response.user = user;
        return response;
    }

    public static DeleteUserRes deleteUser(DeleteUserReq deleteUserReq) {
        User user = User.delete(deleteUserReq.userId);
        DeleteUserRes response = new DeleteUserRes();
        response.user = user;
        return response;
    }
//  CRUD MODEL END
}
