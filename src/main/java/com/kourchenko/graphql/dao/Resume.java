package com.kourchenko.graphql.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Date createdDate;

    @Column
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "id")
    private Person person;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "resume", cascade = CascadeType.ALL)
    private List<WorkExperience> workExperienceList;

    public int getId() {
        return id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public String getFormattedCreatedDate() {
        return this.createdDate.toString();
    }

    public String getFormattedUpdatedDate() {
        return this.updatedDate.toString();
    }
}
