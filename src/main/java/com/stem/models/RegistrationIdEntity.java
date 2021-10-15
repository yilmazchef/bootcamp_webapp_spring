package com.stem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class RegistrationIdEntity implements Serializable {

    private static final long serialVersionUID = 7580751745009533881L;

    @Column(name = "child_id", nullable = false)
    @ToString.Include
    private Integer childId;

    @ToString.Include
    @Column(name = "bootcamp_id", nullable = false)
    private Integer bootcampId;

    public RegistrationIdEntity withChildId(Integer childId) {
        this.childId = childId;
        return this;
    }

    public RegistrationIdEntity withBootcampId(Integer bootcampId) {
        this.bootcampId = bootcampId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bootcampId, childId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RegistrationIdEntity entity = (RegistrationIdEntity) o;
        return Objects.equals(this.bootcampId, entity.bootcampId) &&
                Objects.equals(this.childId, entity.childId);
    }
}