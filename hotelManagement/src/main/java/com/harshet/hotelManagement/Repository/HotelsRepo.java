package com.harshet.hotelManagement.Repository;

import com.harshet.hotelManagement.Models.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HotelsRepo extends JpaRepository<Hotels, UUID> {

    Optional<List<Hotels>> findAllByHotelGroup_Id(UUID id);
}
