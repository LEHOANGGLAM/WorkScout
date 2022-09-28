package com.lehoangglam.workscout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "user_type")
public class UserType implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "user_type_name")
    private String userTypeName;
    @OneToMany(mappedBy = "userTypeId")
    @JsonIgnore
    private Collection<UserAccount> userAccountCollection;
    @OneToMany(mappedBy = "userTypeId")
    @JsonIgnore
    private Collection<Category> categoryCollection;

    public Collection<UserAccount> getUserAccountCollection() {
        return userAccountCollection;
    }

    public void setUserAccountCollection(Collection<UserAccount> userAccountCollection) {
        this.userAccountCollection = userAccountCollection;
    }

    public Collection<Category> getCategoryCollection() {
        return categoryCollection;
    }

    public void setCategoryCollection(Collection<Category> categoryCollection) {
        this.categoryCollection = categoryCollection;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id + '\'' +
                "userTypeName=" + userTypeName + '\'' +
                '}';
    }

    @Override
    public String getAuthority() {
        return userTypeName;
    }
}
