package com.lehoangglam.workscout.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "parent_cate_id")
    private Integer parentCateId;
    @Size(max = 5000)
    @Column(name = "content")
    private String content;
    @Column(name = "active")
    private Integer active;
    @Size(max = 45)
    @Column(name = "link_cate")
    private String linkCate;
    @OneToMany(mappedBy = "cateId")
    private Collection<New> newCollection;
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    @ManyToOne
    private UserType userTypeId;

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getParentCateId() {
        return parentCateId;
    }

    public void setParentCateId(Integer parentCateId) {
        this.parentCateId = parentCateId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getLinkCate() {
        return linkCate;
    }

    public void setLinkCate(String linkCate) {
        this.linkCate = linkCate;
    }

    @XmlTransient
    public Collection<New> getNewCollection() {
        return newCollection;
    }

    public void setNew1Collection(Collection<New> new1Collection) {
        this.newCollection = newCollection;
    }

    public UserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UserType userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojo.Category[ id=" + id + " ]";
    }

}
