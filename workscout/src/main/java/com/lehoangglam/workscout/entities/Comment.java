package com.lehoangglam.workscout.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "content")
    private String content;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "rating")
    private Integer rating;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne
    private Company companyId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private UserAccount userId;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setUserId(UserAccount userId) {
        this.userId = userId;
    }

    public UserAccount getUserId() {
        return userId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id + '\'' +
                "userId=" + userId + '\'' +
                "companyId=" + companyId + '\'' +
                "content=" + content + '\'' +
                "createdDate=" + createdDate + '\'' +
                "rating=" + rating + '\'' +
                '}';
    }
}
