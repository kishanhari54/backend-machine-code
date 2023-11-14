package com.harshet.hotelManagement.Models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
public class AddressBaseModel {

    private String houseNumber;

    private String streetName;

    private String City;
    private String zipCode;
}
