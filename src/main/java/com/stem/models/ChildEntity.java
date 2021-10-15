package com.stem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "children")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "adult_id", nullable = false)
    private AdultEntity adult;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public ChildEntity withId(Integer id) {
        this.id = id;
        return this;
    }

    public ChildEntity withAdult(AdultEntity adult) {
        this.adult = adult;
        return this;
    }

    public ChildEntity withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ChildEntity withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ChildEntity withUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public ChildEntity withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}