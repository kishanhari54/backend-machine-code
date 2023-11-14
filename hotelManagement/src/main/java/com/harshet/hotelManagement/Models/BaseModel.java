package com.harshet.hotelManagement.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
