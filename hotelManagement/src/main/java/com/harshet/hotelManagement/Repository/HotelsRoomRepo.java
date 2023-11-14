package com.harshet.hotelManagement.Repository;

import com.harshet.hotelManagement.Models.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HotelsRoomRepo  extends JpaRepository<HotelRoom, UUID> {
    Optional<List<HotelRoom>> findAllByHotel_Id(UUID id);
}
