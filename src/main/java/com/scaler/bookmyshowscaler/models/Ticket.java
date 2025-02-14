package com.scaler.bookmyshowscaler.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseClass {

    private double amount;

    @ManyToOne
    private Show show;

    @OneToMany(mappedBy = "ShowSeat")
    private List<ShowSeat> showSeats;

    @ManyToMany
    private List<Payment> payments;

    private Date bookingTime;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}
