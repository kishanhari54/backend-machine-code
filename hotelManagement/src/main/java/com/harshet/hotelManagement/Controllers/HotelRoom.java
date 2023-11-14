package com.harshet.hotelManagement.Controllers;

import com.harshet.hotelManagement.DTO.requestHotelRoom;
import com.harshet.hotelManagement.DTO.responseHotelRoom;
import com.harshet.hotelManagement.Services.HotelRoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelRooms")
public class HotelRoom {
        HotelRoomService hotelRoomService;

        public HotelRoom( HotelRoomService service){
            hotelRoomService = service;
        }
    @GetMapping("{id}")
    public List<responseHotelRoom> getRoomsByHotelId(@PathVariable String id){
        return hotelRoomService.getAllRoomsByHotelId(id);
    }

    @PostMapping
    public responseHotelRoom createRoom(@RequestBody requestHotelRoom Room){
        return hotelRoomService.createRoom(Room);
    }

}
