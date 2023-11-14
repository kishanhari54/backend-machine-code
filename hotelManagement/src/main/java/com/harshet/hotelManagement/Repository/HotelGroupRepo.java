package com.harshet.hotelManagement.Repository;

import com.harshet.hotelManagement.Models.HotelsGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelGroupRepo  extends JpaRepository<HotelsGroup, UUID> {
}
