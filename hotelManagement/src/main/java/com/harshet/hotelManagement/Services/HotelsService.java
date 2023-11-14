package com.harshet.hotelManagement.Services;


import com.harshet.hotelManagement.DTO.requestHotels;
import com.harshet.hotelManagement.DTO.responseHotels;
import com.harshet.hotelManagement.Models.Hotels;
import com.harshet.hotelManagement.Models.HotelsGroup;
import com.harshet.hotelManagement.Repository.HotelGroupRepo;
import com.harshet.hotelManagement.Repository.HotelsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelsService {

    @Autowired
    private HotelsRepo hotelsRepo;

    @Autowired
    private HotelGroupRepo groupRepo;

    public List<responseHotels> getAllHotelsByGroupId(String groupId){

        Optional<List<Hotels>> hotel =  this.hotelsRepo.findAllByHotelGroup_Id(UUID.fromString(groupId));
        if(hotel.isEmpty()){ return null;};
        return responseHotels.from(hotel.get());
    }
    public responseHotels createHotelByGroupId(requestHotels hotel){
        Hotels hotelsInfo = new Hotels();
        hotelsInfo.setName(hotel.getName());
        hotelsInfo.setAddress(hotel.getAddress());
        Optional<HotelsGroup> group = groupRepo.findById(UUID.fromString(hotel.getHotelGroupId()));
        if(group.isPresent())hotelsInfo.setHotelGroup( group.get());

        return responseHotels.from(hotelsRepo.save(hotelsInfo));
    }

}
