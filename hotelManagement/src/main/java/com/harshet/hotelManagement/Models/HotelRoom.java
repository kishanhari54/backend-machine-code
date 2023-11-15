package com.harshet.hotelManagement.Models;

import com.harshet.hotelManagement.Enum.HotelRoomTypes;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class HotelRoom extends  BaseModel{

    @Column(name = "roomNumber")
    private String roomNumber;

    @Column(name="type")
    private HotelRoomTypes roomType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hotel_id")
    private Hotels hotel;

    @OneToMany(mappedBy = "roomBooked")
    private List<RoomBookingDetails> roomBooked;

}
