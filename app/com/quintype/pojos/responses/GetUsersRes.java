package com.quintype.pojos.responses;

import java.util.List;

import models.User;

public class GetUsersRes {

    public List<User> users;

    @Override
    public String toString() {
        return "GetUsersRes [users=" + users + "]";
    }

}
