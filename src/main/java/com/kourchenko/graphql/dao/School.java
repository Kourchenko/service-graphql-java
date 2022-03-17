package com.kourchenko.graphql.dao;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class School implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "education_id", nullable = false)
    private Education education;

    @Column
    private String name;

    @Column
    private String address;

    public Education getEducation() {
        return this.education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
