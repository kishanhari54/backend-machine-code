package com.harshet.hotelManagement.DTO;

import com.harshet.hotelManagement.Enum.UserType;
import com.harshet.hotelManagement.Models.Users;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class responseUser {
    String name;
    String address;
    String aadharNumber;
    UserType type;
    String id;

    public static responseUser from(Users users){
        responseUser us = new responseUser();
        us.setName(users.getName());
        us.setId(users.getId().toString());
        us.setAddress(users.getAddress());
        us.setAadharNumber(users.getAadharNumber());
        us.setType(users.getType());
        return us;
    }
    public static List<responseUser> from(List<Users> users){
        List<responseUser> us = new ArrayList<>();
        for(Users uss : users){
            us.add( responseUser.from(uss));
        }
        return us;
    }
}



