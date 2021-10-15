package com.stem.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "adults")
@Entity
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class AdultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adult_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public AdultEntity withId(Integer id) {
        this.id = id;
        return this;
    }

    public AdultEntity withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AdultEntity withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AdultEntity withUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public AdultEntity withDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdultEntity adult = (AdultEntity) o;
        return id != null && Objects.equals(id, adult.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}