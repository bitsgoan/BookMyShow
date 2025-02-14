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
public class Show  extends BaseClass {
    private String name;

    @ManyToOne
    private Auditorium auditorium;

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
