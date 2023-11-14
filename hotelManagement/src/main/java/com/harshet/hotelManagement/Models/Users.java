package com.harshet.hotelManagement.Models;

import com.harshet.hotelManagement.Enum.UserType;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Users extends  BaseModel{
    String name;
    String aadharNumber;
    String Address;
    UserType type;
}
