package com.harshet.hotelManagement.Controllers;

import com.harshet.hotelManagement.DTO.createhotelGroup;
import com.harshet.hotelManagement.DTO.responseHotelGroup;
import com.harshet.hotelManagement.Models.HotelsGroup;
import com.harshet.hotelManagement.Services.HotelGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelGroup")
public class HotelGroup {

    @Autowired
    private HotelGroupService hotelGroupService;
    @GetMapping("/all")
    public List<responseHotelGroup> getHotels(){
        return this.hotelGroupService.getAllHotelGroup();
    }

    @PostMapping
    public responseHotelGroup createNewHotel(@RequestBody createhotelGroup hotel){
        return this.hotelGroupService.addHotelGroup(hotel);
    }
}
