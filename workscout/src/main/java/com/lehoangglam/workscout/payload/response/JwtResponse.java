package com.lehoangglam.workscout.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lehoangglam.workscout.entities.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

public class JwtResponse {

    private String token;
    private String tokenType = "Hoanglam";

    private Integer id;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private String contactNumber;
    private String userImage;
    private Date registrationDate;
    private String username;
    private Integer isComfirm;
    private String firstName;
    private String lastName;
    private String aboutMe;
    private String cv;
    private List<String> types;

    public JwtResponse(String accessToken, Integer id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.types = roles;
    }


    public JwtResponse(String token, Integer id, String email, Date dateOfBirth, String gender,
                       String contactNumber, String userImage, Date registrationDate,
                       String username, Integer isComfirm, String firstName, String lastName,
                       String aboutMe, String cv, List<String> types) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.userImage = userImage;
        this.registrationDate = registrationDate;
        this.username = username;
        this.isComfirm = isComfirm;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aboutMe = aboutMe;
        this.cv = cv;
        this.types = types;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIsComfirm() {
        return isComfirm;
    }

    public void setIsComfirm(Integer isComfirm) {
        this.isComfirm = isComfirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
