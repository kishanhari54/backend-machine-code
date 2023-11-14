package com.harshet.hotelManagement.Models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.harshet.hotelManagement.Controllers.HotelGroup;
import com.harshet.hotelManagement.DTO.requestHotels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotels extends BaseModel{

    @Column
    private String Name;

    @Column
    private String Address;

    @ManyToOne()
    @JoinColumn(name = "hotelGroupId")
    private HotelsGroup hotelGroup;

    @OneToMany(mappedBy = "hotel",cascade = {CascadeType.REMOVE})
    private List<HotelRoom> rooms;

    /*public static Hotels from(requestHotels hotl){
        Hotels hotelResponse = new Hotels();
        hotelResponse.setName(hotl.getName());
        hotelResponse.setAddress(hotl.getAddress());
        hotelResponse.setHotelGroup(hotl.getHotelGroupId());
        return hotelResponse;
    }*/
}
