package com.lehoangglam.workscout.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "job_post_activity")
public class JobPostActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JobPostActivityPK jobPostActivityPK;
    @Column(name = "apply_date")
    private Date applyDate;
    @Column(name = "is_save")
    private Integer isSave;
    @JoinColumn(name = "job_post_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private JobPost jobPost;
    @JoinColumn(name = "user_account_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private UserAccount userAccount;

    public JobPostActivity() {
    }

    public JobPostActivity(JobPostActivityPK jobPostActivityPK) {
        this.jobPostActivityPK = jobPostActivityPK;
    }

    public JobPostActivity(int jobPostId, int userAccountId) {
        this.jobPostActivityPK = new JobPostActivityPK(jobPostId, userAccountId);
    }

    public JobPostActivityPK getJobPostActivityPK() {
        return jobPostActivityPK;
    }

    public void setJobPostActivityPK(JobPostActivityPK jobPostActivityPK) {
        this.jobPostActivityPK = jobPostActivityPK;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getIsSave() {
        return isSave;
    }

    public void setIsSave(Integer isSave) {
        this.isSave = isSave;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobPostActivityPK != null ? jobPostActivityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobPostActivity)) {
            return false;
        }
        JobPostActivity other = (JobPostActivity) object;
        if ((this.jobPostActivityPK == null && other.jobPostActivityPK != null) || (this.jobPostActivityPK != null && !this.jobPostActivityPK.equals(other.jobPostActivityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojo.JobPostActivity[ jobPostActivityPK=" + jobPostActivityPK + " ]";
    }

}
