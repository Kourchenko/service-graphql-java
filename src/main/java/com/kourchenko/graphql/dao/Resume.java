package com.kourchenko.graphql.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Resume implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "id")
    private Person person;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Education> educationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Experience> experienceList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resume", cascade = CascadeType.ALL)
    private List<Project> projectList;

    @Column
    private Date createdDate;

    @Column
    private Date updatedDate;

    public int getId() {
        return this.id;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Experience> getExperienceList() {
        List<Experience> experienceList = new ArrayList<>(this.experienceList);
        return experienceList;
    }

    public void setExperienceSet(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectSet(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getFormattedCreatedDate() {
        return this.createdDate.toString();
    }

    public String getFormattedUpdatedDate() {
        return this.updatedDate.toString();
    }
}
