package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "job_type")
public class JobType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ib")
    private Integer ib;
    @Size(max = 45)
    @Column(name = "job_type")
    private String jobType;
    @OneToMany(mappedBy = "jobTypeId")
    @JsonIgnore
    private Collection<JobPost> jobPostCollection;

    public Collection<JobPost> getJobPostCollection() {
        return jobPostCollection;
    }

    public void setJobPostCollection(Collection<JobPost> jobPostCollection) {
        this.jobPostCollection = jobPostCollection;
    }

    public void setIb(Integer ib) {
        this.ib = ib;
    }

    public Integer getIb() {
        return ib;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobType() {
        return jobType;
    }

    @Override
    public String toString() {
        return "JobType{" +
                "ib=" + ib + '\'' +
                "jobType=" + jobType + '\'' +
                '}';
    }
}
