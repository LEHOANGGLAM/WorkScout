package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "street")
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "street_name")
    private String streetName;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Company companyId;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Location cityId;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private UserAccount userId;

    @OneToMany(mappedBy = "jobStreetId")
    @JsonIgnore
    private Collection<JobPost> jobPostCollection;

    public Collection<JobPost> getJobPostCollection() {
        return jobPostCollection;
    }

    public void setJobPostCollection(Collection<JobPost> jobPostCollection) {
        this.jobPostCollection = jobPostCollection;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCityId(Location cityId) {
        this.cityId = cityId;
    }

    public Location getCityId() {
        return cityId;
    }

    public void setUserId(UserAccount userId) {
        this.userId = userId;
    }

    public UserAccount getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id + '\'' +
                "streetName=" + streetName + '\'' +
                "companyId=" + companyId + '\'' +
                "cityId=" + cityId + '\'' +
                "userId=" + userId + '\'' +
                '}';
    }
}
