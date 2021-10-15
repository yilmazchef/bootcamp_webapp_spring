package com.stem.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "users", indexes = {
        @Index(name = "phone", columnList = "phone"),
        @Index(name = "email", columnList = "email", unique = true)
})
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false, length = 14)
    private String phone;

    @Column(name = "pass_code")
    private String passCode;

    public UserEntity withId(Integer id) {
        this.id = id;
        return this;
    }

    public UserEntity withRole(RoleEntity role) {
        this.role = role;
        return this;
    }

    public UserEntity withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserEntity withPassCode(String passCode) {
        this.passCode = passCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity user = (UserEntity) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}