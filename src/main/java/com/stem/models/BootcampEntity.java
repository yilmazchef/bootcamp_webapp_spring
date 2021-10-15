package com.stem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "bootcamp_events")
@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class BootcampEntity {

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

    public BootcampEntity withId(Integer id) {
        this.id = id;
        return this;
    }

    public BootcampEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    public BootcampEntity withDescription(String description) {
        this.description = description;
        return this;
    }

    public BootcampEntity withEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public BootcampEntity withEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    public BootcampEntity withImageUrl(byte[] imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}