package com.harshet.hotelManagement.DTO;

import com.harshet.hotelManagement.Models.HotelsGroup;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class responseHotelGroup {
    private String ID;
    private String name;

    public  static responseHotelGroup from(HotelsGroup group){
        responseHotelGroup response = new responseHotelGroup();
        response.setID(group.getId().toString());
        response.setName(group.getName());
        return response;
    }
    public  static List<responseHotelGroup> from(List<HotelsGroup> groups){
        List<responseHotelGroup> group = new ArrayList<>();
        for(HotelsGroup groupItem: groups) {
            group.add(responseHotelGroup.from(groupItem));
        }
        return group;
    }

}
