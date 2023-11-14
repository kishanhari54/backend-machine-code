package com.harshet.hotelManagement.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelsGroup extends BaseModel{

    @Column
    private String Name;

    @OneToMany(mappedBy = "hotelGroup" ,fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE)
    private List<Hotels> hotels = new ArrayList<>();
}
