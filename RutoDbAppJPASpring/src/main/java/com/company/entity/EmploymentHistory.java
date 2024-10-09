package com.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "employment_history")
public class EmploymentHistory {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "begin_date", nullable = false)
    private java.sql.Date beginDate;

    @Column(name = "end_date")
    private java.sql.Date endDate;

    @Lob
    @Column(name = "job_description", nullable = false)
    private String jobDescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    public EmploymentHistory(Integer id, String header, java.sql.Date beginDate, String jobDescription) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.jobDescription = jobDescription;
    }

    public EmploymentHistory(Integer id, String header, java.sql.Date beginDate, java.sql.Date endDate, String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.userId = user;
    }

    public EmploymentHistory(Integer id) {
        this.id = id;
    }

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id, String header, Date beginDate, Date endDate, String jobDescription, User user) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public java.sql.Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(java.sql.Date beginDate) {
        this.beginDate = beginDate;
    }

    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User getUserid() {
        return userId;
    }

    public void setUserid(User userid) {
        this.userId = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmploymentHistory that = (EmploymentHistory) o;
        return Objects.equals(id, that.id) && Objects.equals(header, that.header) && Objects.equals(beginDate, that.beginDate) && Objects.equals(endDate, that.endDate) && Objects.equals(jobDescription, that.jobDescription) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, header, beginDate, endDate, jobDescription, userId);
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDescription='" + jobDescription + '\'' +
                ", userid=" + userId +
                '}';
    }
}