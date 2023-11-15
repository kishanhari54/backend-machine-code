package com.harshet.hotelManagement.Controllers;

import com.harshet.hotelManagement.DTO.requestBooking;
import com.harshet.hotelManagement.DTO.responseBooking;
import com.harshet.hotelManagement.Services.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking")
public class RoomBooking {
    BookingService bookingService;
        public RoomBooking(BookingService bookingService){
            this.bookingService = bookingService;
        }
    @PostMapping
    public responseBooking makeBooking(@RequestBody requestBooking bookingInfo){
        return  this.bookingService.createBooking(bookingInfo);
    }

    @GetMapping("/{bookingId}")
    public responseBooking getBookingInfo(@PathVariable String bookingId){
        return this.bookingService.getBookingInfo(bookingId);
    }



    @GetMapping("all/ByUser/{userId}")
    public void getAllBookingsOfUser(@PathVariable String userId){

    }
}
