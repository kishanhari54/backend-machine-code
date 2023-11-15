package com.harshet.hotelManagement.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class requestBooking {

    Date startDate;
    Date endDate;
    int noOfDeluxeRooms;
    int noOfStandardRooms;
    String userId;
    String hotelId;

}
