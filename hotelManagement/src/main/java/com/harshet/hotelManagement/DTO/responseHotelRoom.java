package com.harshet.hotelManagement.DTO;

import com.harshet.hotelManagement.Enum.HotelRoomTypes;
import com.harshet.hotelManagement.Models.HotelRoom;
import com.harshet.hotelManagement.Models.HotelsGroup;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class responseHotelRoom {
        String id;
        String roomNumber;
        HotelRoomTypes type;
        String hotelId;
 public static responseHotelRoom from(HotelRoom room){
     responseHotelRoom roomInfo = new responseHotelRoom();
     roomInfo.setHotelId(room.getHotel().getId().toString());
     roomInfo.setId(room.getId().toString());
     roomInfo.setType(room.getRoomType());
     roomInfo.setRoomNumber(room.getRoomNumber());
     return roomInfo;
 }

    public static List<responseHotelRoom> from(List<HotelRoom> rooms) {
        List<responseHotelRoom> roomsResponse = new ArrayList<>();
        for (HotelRoom room : rooms) {
            roomsResponse.add(responseHotelRoom.from(room));
        }
        return roomsResponse;
    }
}
