package com.harshet.hotelManagement.Services;

import com.harshet.hotelManagement.DTO.requestUser;
import com.harshet.hotelManagement.DTO.responseUser;
import com.harshet.hotelManagement.Enum.UserType;
import com.harshet.hotelManagement.Models.Users;
import com.harshet.hotelManagement.Repository.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class usersService {
    UsersRepo userRepo;
    public usersService(UsersRepo repo){
        userRepo = repo;
    }

    public responseUser createUser(requestUser userInfo){
        Users user = new Users();
        user.setName(userInfo.getName());
        user.setType(UserType.values()[userInfo.getType()] );
        user.setAddress(userInfo.getAddress());
        user.setAadharNumber(userInfo.getAadharNumber());
           return responseUser.from(userRepo.save(user));
    }
    public responseUser getUserById(String  userId) {
        Optional<Users> user = userRepo.findById(UUID.fromString(userId));
        if (user.isEmpty()) {
            return null;
        }return responseUser.from(user.get());
    }
}
