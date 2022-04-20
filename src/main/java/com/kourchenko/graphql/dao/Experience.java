package com.kourchenko.graphql.dao;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.commons.lang3.StringUtils;

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
    private String companyAddress;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String roleTitle;

    @Column
    private String roleDescription;

    @Column
    private String roleTools;

    @Column
    private String roleSkills;

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

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
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

    public String getRoleTitle() {
        return this.roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleTools() {
        return this.roleTools;
    }

    public void setRoleTools(String roleTools) {
        this.roleTools = roleTools;
    }

    public String getRoleSkills() {
        return this.roleSkills;
    }

    public void setRoleSkills(String roleSkills) {
        this.roleSkills = roleSkills;
    }

    public Experience merge(Experience experience) {
        if (experience != null) {

            Boolean _isCurrentRole = experience.getIsCurrentRole();
            _isCurrentRole = _isCurrentRole != null ? _isCurrentRole : isCurrentRole;

            String _companyName = experience.getCompanyName();
            _companyName = StringUtils.defaultIfBlank(_companyName, companyName);

            String _companyAddress = experience.getCompanyAddress();
            _companyAddress = StringUtils.defaultIfBlank(_companyAddress, companyAddress);

            Date _startDate = experience.getStartDate();
            _startDate = _startDate != null ? _startDate : startDate;

            Date _endDate = experience.getEndDate();
            _endDate = _endDate != null ? _endDate : endDate;

            String _roleTitle = experience.getRoleTitle();
            _roleTitle = StringUtils.defaultIfBlank(_roleTitle, roleTitle);

            String _roleDescription = experience.getRoleDescription();
            _roleDescription = StringUtils.defaultIfBlank(_roleDescription, roleDescription);

            String _roleTools = experience.getRoleTools();
            _roleTools = StringUtils.defaultIfBlank(_roleTools, roleTools);

            String _roleSkills = experience.getRoleSkills();
            _roleSkills = StringUtils.defaultIfBlank(_roleSkills, roleSkills);

            setIsCurrentRole(_isCurrentRole);
            setCompanyName(_companyName);
            setCompanyAddress(_companyAddress);
            setStartDate(_startDate);
            setEndDate(_endDate);
            setRoleTitle(_roleTitle);
            setRoleDescription(_roleDescription);
            setRoleTools(_roleTools);
            setRoleSkills(_roleSkills);
        }

        return this;
    }
}
