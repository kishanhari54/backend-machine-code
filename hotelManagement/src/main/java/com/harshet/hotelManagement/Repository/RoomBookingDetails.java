package com.harshet.hotelManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomBookingDetails extends JpaRepository<com.harshet.hotelManagement.Models.RoomBookingDetails, UUID> {
}
