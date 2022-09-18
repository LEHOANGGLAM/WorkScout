package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "location")
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @OneToMany(mappedBy = "cityId")
    @JsonIgnore
    private Collection<Street> streetCollection;

    public Collection<Street> getStreetCollection() {
        return streetCollection;
    }

    public void setStreetCollection(Collection<Street> streetCollection) {
        this.streetCollection = streetCollection;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id + '\'' +
                "city=" + city + '\'' +
                '}';
    }
}
