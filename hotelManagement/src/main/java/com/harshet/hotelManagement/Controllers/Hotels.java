package com.harshet.hotelManagement.Controllers;

import com.harshet.hotelManagement.DTO.requestHotels;
import com.harshet.hotelManagement.DTO.responseHotels;
import com.harshet.hotelManagement.Services.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class Hotels {


    HotelsService hotelsService;

    public Hotels( HotelsService hotelsService){
        this.hotelsService = hotelsService;
    }

    @GetMapping("{groupId}")
    public List<responseHotels> getAllHotelsByGroupId(@PathVariable String groupId){
         return hotelsService.getAllHotelsByGroupId( groupId);
    }

    @PostMapping
    public responseHotels createHotelByGroupId(@RequestBody requestHotels hotel){
        return hotelsService.createHotelByGroupId(hotel);
    }
}
