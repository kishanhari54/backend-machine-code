package com.harshet.hotelManagement.DTO;

import com.harshet.hotelManagement.Models.RoomBookingDetails;
import com.harshet.hotelManagement.Models.RoomBookings;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class responseBooking {
    String bookingId;
    Date bookingStartDate;
    Date bookingEndDate;

    public static responseBooking from(RoomBookings details){
        responseBooking detail = new responseBooking();
            detail.setBookingId(details.getId().toString());
            detail.setBookingEndDate(details.getBookingEndDate());
            detail.setBookingStartDate(details.getBookingStartDate());
        return detail;
    }
    public static List<responseBooking> from(List<RoomBookings> details){
        List<responseBooking> detail = new ArrayList<>();
            details.stream().forEach( item -> detail.add( responseBooking.from(item)));
        return detail;
    }
}
