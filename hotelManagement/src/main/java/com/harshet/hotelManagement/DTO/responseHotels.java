package com.harshet.hotelManagement.DTO;

import com.harshet.hotelManagement.Models.Hotels;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class responseHotels {
    private String id;
    private String name;
    private String address;

    private String hotelGroupId;

    public static responseHotels  from(Hotels hotel){
        responseHotels hotelResponse = new responseHotels();
        hotelResponse.setName(hotel.getName());
        hotelResponse.setAddress(hotel.getAddress());
        hotelResponse.setHotelGroupId(hotel.getHotelGroup().getId().toString());
        hotelResponse.setId(hotel.getId().toString());
        return hotelResponse;
    }
    public static List<responseHotels> from(List<Hotels> hotel){
        List<responseHotels> hotelResponse = new ArrayList<>();
            for(Hotels hot:hotel){
                hotelResponse.add( responseHotels.from(hot));
            }
        return hotelResponse;
    }
}
