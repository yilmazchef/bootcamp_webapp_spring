package com.stem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "bootcamp_events")
@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Bootcamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bootcamp_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "event_time")
    private LocalTime eventTime;

    @Column(name = "image_url")
    private byte[] imageUrl;


}