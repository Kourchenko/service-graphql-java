package com.kourchenko.graphql.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Education implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column
    private String degree;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "education", cascade = CascadeType.ALL)
    private List<School> schoolList;


    public Resume getResume() {
        return this.resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<School> getSchoolList() {
        List<School> schoolList = new ArrayList<>(this.schoolList);
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }
}
