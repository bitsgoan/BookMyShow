package com.scaler.bookmyshowscaler.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Auditorium  extends BaseClass {
    private String name;

    @OneToMany
    private List<Show> shows;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    @OneToMany
    private List<Seat> seats;
}
