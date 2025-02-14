package com.scaler.bookmyshowscaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseClass {
    private String name;

    @ManyToOne
    private SeatType seatType;

    private int row;
    private int col;
}
