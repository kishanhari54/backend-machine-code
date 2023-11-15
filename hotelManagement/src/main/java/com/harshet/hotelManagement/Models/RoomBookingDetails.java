package com.harshet.hotelManagement.Models;

import com.harshet.hotelManagement.Enum.BookingStatus;
import com.harshet.hotelManagement.Enum.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class RoomBookingDetails extends BaseModel{
    private Date bookingStartDate;
    private Date bookingEndDate;
    //private int noOfDeluxeRooms;
    //private int noOfStandardRooms;
    private BookingStatus status;
    private PaymentStatus paymentStatus;

    @ManyToOne()
    @JoinColumn(name = "roomId")
    private HotelRoom roomBooked;

    @ManyToOne()
    @JoinColumn(name = "booking_Id")
    private RoomBookings bookingId;
}
