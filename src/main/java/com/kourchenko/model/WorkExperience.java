package com.kourchenko.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity

@Data
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String companyName;

    private String roleTitle;

    private String companyCity;

    private String companyState;

    private String startDate;

    private String endDate;

    private Boolean isCurrentRole;
}