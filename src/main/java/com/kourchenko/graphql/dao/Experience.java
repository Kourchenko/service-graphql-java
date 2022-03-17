package com.kourchenko.graphql.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Experience implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Resume getResume() {
        return this.resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Boolean getIsCurrentRole() {
        return this.isCurrentRole;
    }

    public void setIsCurrentRole(Boolean isCurrentRole) {
        this.isCurrentRole = isCurrentRole;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoleTitle() {
        return this.roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getTools() {
        return this.tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
