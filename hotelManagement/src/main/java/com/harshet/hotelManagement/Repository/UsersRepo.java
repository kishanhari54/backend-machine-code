package com.harshet.hotelManagement.Repository;

import com.harshet.hotelManagement.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepo extends JpaRepository<Users, UUID> {

}
