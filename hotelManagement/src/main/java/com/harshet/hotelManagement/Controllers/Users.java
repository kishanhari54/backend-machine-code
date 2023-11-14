package com.harshet.hotelManagement.Controllers;

import com.harshet.hotelManagement.DTO.requestUser;
import com.harshet.hotelManagement.DTO.responseUser;
import com.harshet.hotelManagement.Services.usersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class Users {
    usersService userService;
    public Users(usersService service)
    {
        userService = service;
    }
    @GetMapping("{id}")
    public responseUser getuserbyId(@PathVariable String id){

        return this.userService.getUserById(id);
    }

    @PostMapping
    public responseUser createUser(@RequestBody requestUser user){

        return this.userService.createUser(user);
    }
}
