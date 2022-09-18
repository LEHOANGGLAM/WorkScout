package com.lehoangglam.workscout.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "new")
public class New implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "content")
    private String content;
    @Size(max = 45)
    @Column(name = "image")
    private String image;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    @ManyToOne
    private Category cateId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCateId(Category cateId) {
        this.cateId = cateId;
    }

    public Category getCateId() {
        return cateId;
    }

    @Override
    public String toString() {
        return "New{" +
                "id=" + id + '\'' +
                "title=" + title + '\'' +
                "content=" + content + '\'' +
                "image=" + image + '\'' +
                "description=" + description + '\'' +
                "cateId=" + cateId + '\'' +
                '}';
    }
}
