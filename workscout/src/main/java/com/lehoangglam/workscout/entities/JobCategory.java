package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "job_category")
public class JobCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "job_category")
    private String jobCategory;
    @OneToMany(mappedBy = "jobCateId")
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

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    @Override
    public String toString() {
        return "JobCategory{" +
                "id=" + id + '\'' +
                "jobCategory=" + jobCategory + '\'' +
                '}';
    }
}
