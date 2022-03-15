package com.kourchenko.graphql.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class WorkExperience implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column
    private Boolean isCurrentRole;

    @Column
    private String companyName;

    @Column
    private String roleTitle;

    @Column
    private String tools;

    @Column
    private String skills;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public void setIsCurrentRole(Boolean isCurrentRole) {
        this.isCurrentRole = isCurrentRole;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
