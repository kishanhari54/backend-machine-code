package com.harshet.hotelManagement.Services;


import com.harshet.hotelManagement.Controllers.HotelGroup;
import com.harshet.hotelManagement.DTO.createhotelGroup;
import com.harshet.hotelManagement.DTO.responseHotelGroup;
import com.harshet.hotelManagement.Models.HotelsGroup;
import com.harshet.hotelManagement.Repository.HotelGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
public class HotelGroupService {
    @Autowired
    private HotelGroupRepo hotelGroupRepo;
    public HotelGroupService(){}


    public responseHotelGroup addHotelGroup(createhotelGroup group){

        HotelsGroup groups = new HotelsGroup();
        groups.setName(group.getName());
        return responseHotelGroup.from(hotelGroupRepo.save(groups));

    }

    public List<responseHotelGroup> getAllHotelGroup(){
        return  responseHotelGroup.from(this.hotelGroupRepo.findAll());
    }
    public responseHotelGroup getHotelGroupById(String groupId){
        Optional<HotelsGroup> group = this.hotelGroupRepo.findById(UUID.fromString(groupId));
        if(group.isEmpty()) return null;
        return  responseHotelGroup.from(group.get());
    }



}
