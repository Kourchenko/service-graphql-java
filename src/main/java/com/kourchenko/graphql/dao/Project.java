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

@Data
@Entity
public class Project implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String roleTitle;

    public Resume getResume() {
        return this.resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleTitle() {
        return this.roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public Project merge(Project project) {
        if (project != null) {
            String _name = project.getName();
            _name = StringUtils.defaultIfBlank(_name, name);

            String _description = project.getDescription();
            _description = StringUtils.defaultIfBlank(_description, description);

            String _roleTitle = project.getRoleTitle();
            _roleTitle = StringUtils.defaultIfBlank(_roleTitle, roleTitle);

            setName(_name);
            setDescription(_description);
            setRoleTitle(_roleTitle);
        }

        return this;
    }
}
