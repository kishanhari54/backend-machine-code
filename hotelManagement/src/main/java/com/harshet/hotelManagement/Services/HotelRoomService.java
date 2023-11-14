package com.harshet.hotelManagement.Services;

import com.harshet.hotelManagement.DTO.requestHotelRoom;
import com.harshet.hotelManagement.DTO.responseHotelRoom;
import com.harshet.hotelManagement.Enum.HotelRoomTypes;
import com.harshet.hotelManagement.Models.HotelRoom;
import com.harshet.hotelManagement.Models.Hotels;
import com.harshet.hotelManagement.Repository.HotelsRepo;
import com.harshet.hotelManagement.Repository.HotelsRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelRoomService {

    @Autowired
    HotelsRoomRepo roomsRepo;

    HotelsRepo hotelsRepo;
    public HotelRoomService( HotelsRepo repo){
            hotelsRepo  = repo;
    }
    public responseHotelRoom createRoom(requestHotelRoom roomInfo){
        HotelRoom room = new HotelRoom();
        room.setRoomType(HotelRoomTypes.values()[roomInfo.getType()]);
        room.setRoomNumber(roomInfo.getRoomNumber());

        Optional<Hotels> hotel =  hotelsRepo.findById(UUID.fromString(roomInfo.getHotelId()));
        if(hotel.isEmpty()){
            // Throw Exception
        }
        room.setHotel(hotel.get());
        return responseHotelRoom.from(roomsRepo.save(room));
    }

    public List<responseHotelRoom> getAllRoomsByHotelId(String id){
           Optional<List<HotelRoom>> rooms = roomsRepo.findAllByHotel_Id(UUID.fromString(id));
           if(rooms.isEmpty()) {
               return null;
           }
        return responseHotelRoom.from(rooms.get());
    }
}
