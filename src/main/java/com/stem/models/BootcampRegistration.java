package com.stem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "bootcamp_registrations")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class BootcampRegistration {

    @JoinColumn
    @ManyToOne
    private Child child;

    @JoinColumn
    @ManyToOne
    private BootcampEvent bootcamp;

}