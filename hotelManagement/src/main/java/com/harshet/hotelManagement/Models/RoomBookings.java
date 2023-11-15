package com.harshet.hotelManagement.Models;

import com.harshet.hotelManagement.Enum.BookingStatus;
import com.harshet.hotelManagement.Enum.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class RoomBookings extends BaseModel{

    /*
    private int noOfDeluxeRooms;
    private int noOfStandardRooms;
    private BookingStatus status;
    private PaymentStatus paymentStatus;*/
    private Date bookingStartDate;
    private Date bookingEndDate;
    @OneToOne()
    private Users User;

   @ManyToOne()
    private Hotels hotel_booking;

    @OneToMany(mappedBy = "bookingId",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<RoomBookingDetails> bookingDetails = new ArrayList<>();
}
