package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "user_account")
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "password")
    private String password;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Size(max = 10)
    @Column(name = "gender")
    private String gender;
    @Size(max = 10)
    @Column(name = "contact_number")
    private String contactNumber;
    @Size(max = 100)
    @Column(name = "user_image")
    private String userImage;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Column(name = "is_comfirm")
    private Integer isComfirm;
    @Size(max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 200)
    @Column(name = "about_me")
    private String aboutMe;
    @Size(max = 200)
    @Column(name = "cv")
    private String cv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccount")
    private Collection<JobPostActivity> jobPostActivityCollection;
    @OneToMany(mappedBy = "userId")
    @JsonIgnore
    private Collection<Street> streetCollection;
    @OneToMany(mappedBy = "userId")
    @JsonIgnore
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "userAccountId")
    @JsonIgnore
    private Collection<Company> companyCollection;
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    @ManyToOne
    private UserType userTypeId;

    public Collection<JobPostActivity> getJobPostActivityCollection() {
        return jobPostActivityCollection;
    }

    public void setJobPostActivityCollection(Collection<JobPostActivity> jobPostActivityCollection) {
        this.jobPostActivityCollection = jobPostActivityCollection;
    }

    public Collection<Street> getStreetCollection() {
        return streetCollection;
    }

    public void setStreetCollection(Collection<Street> streetCollection) {
        this.streetCollection = streetCollection;
    }

    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public Collection<Company> getCompanyCollection() {
        return companyCollection;
    }

    public void setCompanyCollection(Collection<Company> companyCollection) {
        this.companyCollection = companyCollection;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }

    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setComfirm(Integer comfirm) {
        this.isComfirm = comfirm;
    }

    public Integer isComfirm() {
        return isComfirm;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getCv() {
        return cv;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id + '\'' +
                "email=" + email + '\'' +
                "password=" + password + '\'' +
                "dateOfBirth=" + dateOfBirth + '\'' +
                "gender=" + gender + '\'' +
                "contactNumber=" + contactNumber + '\'' +
                "userImage=" + userImage + '\'' +
                "registrationDate=" + registrationDate + '\'' +
                "username=" + username + '\'' +
                "userTypeId=" + userTypeId + '\'' +
                "comfirm=" + isComfirm + '\'' +
                "firstName=" + firstName + '\'' +
                "lastName=" + lastName + '\'' +
                "aboutMe=" + aboutMe + '\'' +
                "cv=" + cv + '\'' +
                '}';
    }
}
