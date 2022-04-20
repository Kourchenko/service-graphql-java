package com.kourchenko.graphql.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;
import java.util.Date;

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
    private String schoolName;

    @Column
    private String schoolAddress;

    @Column
    private Date schoolStartDate;

    @Column
    private Date schoolEndDate;

    @Column
    private Float gpa;

    @Column
    private String degreeTitle;

    @Column
    private String degreeDescription;


    public int getId() {
        return this.id;
    }

    public Resume getResume() {
        return this.resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return this.schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public Date getSchoolStartDate() {
        return this.schoolStartDate;
    }

    public void setSchoolStartDate(Date schoolStartDate) {
        this.schoolStartDate = schoolStartDate;
    }

    public Date getSchoolEndDate() {
        return this.schoolEndDate;
    }

    public void setSchoolEndDate(Date schoolEndDate) {
        this.schoolEndDate = schoolEndDate;
    }

    public Float getGPA() {
        return this.gpa;
    }

    public void setGPA(Float gpa) {
        this.gpa = gpa;
    }

    public String getDegreeTitle() {
        return this.degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public String getDegreeDescription() {
        return this.degreeDescription;
    }

    public void setDegreeDescription(String degreeDescription) {
        this.degreeDescription = degreeDescription;
    }

    public Education merge(Education education) {
        if (education != null) {
            String _schoolName = education.getSchoolName();
            _schoolName = StringUtils.defaultIfBlank(_schoolName, schoolName);

            String _schoolAddress = education.getSchoolAddress();
            _schoolAddress = StringUtils.defaultIfBlank(_schoolAddress, schoolAddress);

            Date _schoolStartDate = education.getSchoolStartDate();
            _schoolStartDate = _schoolStartDate != null ? _schoolStartDate : schoolStartDate;

            Date _schoolEndDate = education.getSchoolEndDate();
            _schoolEndDate = _schoolEndDate != null ? _schoolEndDate : schoolEndDate;

            Float _gpa = education.getGPA();
            _gpa = _gpa != null ? _gpa : gpa;

            String _degreeTitle = education.getDegreeTitle();
            _degreeTitle = StringUtils.defaultIfBlank(_degreeTitle, degreeTitle);

            String _degreeDescription = education.getDegreeDescription();
            _degreeDescription = StringUtils.defaultIfBlank(_degreeDescription, degreeDescription);

            setSchoolName(_schoolName);
            setSchoolAddress(_schoolAddress);
            setSchoolStartDate(_schoolStartDate);
            setSchoolEndDate(_schoolEndDate);
            setGPA(_gpa);
            setDegreeTitle(_degreeTitle);
            setDegreeDescription(_degreeDescription);
        }

        return this;
    }
}
