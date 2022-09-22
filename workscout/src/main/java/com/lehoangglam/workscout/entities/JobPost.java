package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "job_post")
public class JobPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Size(max = 2500)
    @Column(name = "job_description")
    private String jobDescription;
    @Size(max = 2500)
    @Column(name = "job_requirement")
    private String jobRequirement;
    @Column(name = "is_active")
    private Integer active;
    @Column(name = "job_min_salary")
    private Integer jobMinSalary;
    @Column(name = "job_max_salary")
    private Integer jobMaxSalary;
    @Column(name = "year_exper_require")
    private Integer yearExperRequire;
    @Size(max = 45)
    @Column(name = "job_nature")
    private String jobNature;
    @Column(name = "vacancy")
    private Integer vacancy;
    @Size(max = 2500)
    @Column(name = "individual_right")
    private String individualRight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobPost")
    @JsonIgnore
    private Collection<JobPostActivity> jobPostActivityCollection;

    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Company companyId;

    @JoinColumn(name = "job_cate_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    private JobCategory jobCateId;
    @JoinColumn(name = "job_type_id", referencedColumnName = "ib")
    @ManyToOne

    private JobType jobTypeId;
    @JoinColumn(name = "job_street_id", referencedColumnName = "id")
    @ManyToOne
    private Street jobStreetId;

    public Collection<JobPostActivity> getJobPostActivityCollection() {
        return jobPostActivityCollection;
    }

    public void setJobPostActivityCollection(Collection<JobPostActivity> jobPostActivityCollection) {
        this.jobPostActivityCollection = jobPostActivityCollection;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setJobCateId(JobCategory jobCateId) {
        this.jobCateId = jobCateId;
    }

    public JobCategory getJobCateId() {
        return jobCateId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setJobStreetId(Street jobStreetId) {
        this.jobStreetId = jobStreetId;
    }

    public Street getJobStreetId() {
        return jobStreetId;
    }

    public void setJobTypeId(JobType jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public JobType getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobRequirement(String jobRequirement) {
        this.jobRequirement = jobRequirement;
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer isActive() {
        return active;
    }

    public void setJobMinSalary(Integer jobMinSalary) {
        this.jobMinSalary = jobMinSalary;
    }

    public Integer getJobMinSalary() {
        return jobMinSalary;
    }

    public void setJobMaxSalary(Integer jobMaxSalary) {
        this.jobMaxSalary = jobMaxSalary;
    }

    public Integer getJobMaxSalary() {
        return jobMaxSalary;
    }

    public void setYearExperRequire(Integer yearExperRequire) {
        this.yearExperRequire = yearExperRequire;
    }

    public Integer getYearExperRequire() {
        return yearExperRequire;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setVacancy(Integer vacancy) {
        this.vacancy = vacancy;
    }

    public Integer getVacancy() {
        return vacancy;
    }

    public void setIndividualRight(String individualRight) {
        this.individualRight = individualRight;
    }

    public String getIndividualRight() {
        return individualRight;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "id=" + id + '\'' +
                "jobCateId=" + jobCateId + '\'' +
                "companyId=" + companyId + '\'' +
                "jobStreetId=" + jobStreetId + '\'' +
                "jobTypeId=" + jobTypeId + '\'' +
                "jobTitle=" + jobTitle + '\'' +
                "createdDate=" + createdDate + '\'' +
                "expirationDate=" + expirationDate + '\'' +
                "jobDescription=" + jobDescription + '\'' +
                "jobRequirement=" + jobRequirement + '\'' +
                "active=" + active + '\'' +
                "jobMinSalary=" + jobMinSalary + '\'' +
                "jobMaxSalary=" + jobMaxSalary + '\'' +
                "yearExperRequire=" + yearExperRequire + '\'' +
                "jobNature=" + jobNature + '\'' +
                "vacancy=" + vacancy + '\'' +
                "individualRight=" + individualRight + '\'' +
                '}';
    }
}
