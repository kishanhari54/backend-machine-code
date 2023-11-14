package com.harshet.hotelManagement.DTO;

import lombok.Builder;
import lombok.Data;

@Data

public class requestHotels {
    private String name;
    private String address;

    private String hotelGroupId;
}
