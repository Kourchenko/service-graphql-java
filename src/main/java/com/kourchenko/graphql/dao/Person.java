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
public class Person implements Serializable {

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
    private String emailAddress;

    @Column
    private String phoneNumber;

    public Resume getResume() {
        return this.resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person merge(Person person) {
        if (person != null) {
            String _name = person.getName();
            _name = StringUtils.defaultIfBlank(_name, name);

            String _emailAddress = person.getEmailAddress();
            _emailAddress = StringUtils.defaultIfBlank(_emailAddress, emailAddress);

            String _phoneNumber = person.getPhoneNumber();
            _phoneNumber = StringUtils.defaultIfBlank(_phoneNumber, phoneNumber);

            setName(_name);
            setEmailAddress(_emailAddress);
            setPhoneNumber(_phoneNumber);
        }

        return this;
    }
}
