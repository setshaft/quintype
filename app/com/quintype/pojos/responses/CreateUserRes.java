package com.quintype.pojos.responses;

import models.User;

public class CreateUserRes {
    public User user;

    @Override
    public String toString() {
        return "CreateUserRes [user=" + user + "]";
    }
}
