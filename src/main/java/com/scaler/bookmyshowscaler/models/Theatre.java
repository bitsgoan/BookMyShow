package com.scaler.bookmyshowscaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Theatre  extends BaseClass {
    private String name;
    private String city;
    private String company;

    @OneToMany
    private List<Auditorium> auditoriums;
}
