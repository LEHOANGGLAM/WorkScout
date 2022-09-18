package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;


@Entity
@Table(name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "company_name")
    private String companyName;
    @Size(max = 1000)
    @Column(name = "profile_description")
    private String profileDescription;
    @Column(name = "created_date")
    private Date createdDate;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @Size(max = 200)
    @Column(name = "company_website")
    private String companyWebsite;
    @Size(max = 45)
    @Column(name = "company_email")
    private String companyEmail;
    @Size(max = 45)
    @Column(name = "cover_image")
    private String coverImage;
    @Size(max = 2000)
    @Column(name = "aboutCompany")
    private String aboutCompany;
    @Size(max = 45)
    @Column(name = "company_size")
    private String companySize;
    @Column(name = "is_comfirm")
    private Integer isComfirm;

    @OneToMany(mappedBy = "companyId")
    @JsonIgnore
    private Collection<Street> streetCollection;

    @OneToMany(mappedBy = "companyId")
    @JsonIgnore
    private Collection<JobPost> jobPostCollection;

    @OneToMany(mappedBy = "companyId")
    @JsonIgnore
    private Collection<Comment> commentCollection;
    @JoinColumn(name = "business_type_id", referencedColumnName = "id")
    @ManyToOne
    private BusinessType businessTypeId;
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    @ManyToOne
    private UserAccount userAccountId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setBusinessTypeId(BusinessType businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public BusinessType getBusinessTypeId() {
        return businessTypeId;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setUserAccountId(UserAccount userAccountId) {
        this.userAccountId = userAccountId;
    }

    public UserAccount getUserAccountId() {
        return userAccountId;
    }

    public void setAboutCompany(String aboutCompany) {
        this.aboutCompany = aboutCompany;
    }

    public String getAboutCompany() {
        return aboutCompany;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setComfirm(Integer comfirm) {
        this.isComfirm = comfirm;
    }

    public Integer isComfirm() {
        return isComfirm;
    }

    public Collection<Street> getStreetCollection() {
        return streetCollection;
    }

    public void setStreetCollection(Collection<Street> streetCollection) {
        this.streetCollection = streetCollection;
    }

    public Collection<JobPost> getJobPostCollection() {
        return jobPostCollection;
    }

    public void setJobPostCollection(Collection<JobPost> jobPostCollection) {
        this.jobPostCollection = jobPostCollection;
    }

    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id + '\'' +
                "companyName=" + companyName + '\'' +
                "profileDescription=" + profileDescription + '\'' +
                "businessTypeId=" + businessTypeId + '\'' +
                "createdDate=" + createdDate + '\'' +
                "image=" + image + '\'' +
                "companyWebsite=" + companyWebsite + '\'' +
                "companyEmail=" + companyEmail + '\'' +
                "coverImage=" + coverImage + '\'' +
                "userAccountId=" + userAccountId + '\'' +
                "aboutCompany=" + aboutCompany + '\'' +
                "companySize=" + companySize + '\'' +
                "comfirm=" + isComfirm + '\'' +
                '}';
    }
}
