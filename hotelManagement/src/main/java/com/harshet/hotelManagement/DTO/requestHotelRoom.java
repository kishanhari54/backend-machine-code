package com.harshet.hotelManagement.DTO;

import com.harshet.hotelManagement.Enum.HotelRoomTypes;
import lombok.Data;

@Data
public class requestHotelRoom {
    String roomNumber;
    int type;
    String hotelId;
}
