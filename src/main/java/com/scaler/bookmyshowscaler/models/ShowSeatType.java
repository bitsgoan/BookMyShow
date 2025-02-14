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
public class ShowSeatType extends BaseClass{

    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;
    private double price;
}
