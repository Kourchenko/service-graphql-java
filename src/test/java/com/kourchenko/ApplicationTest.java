package com.kourchenko;

import com.kourchenko.graphql.dao.Person;
import org.springframework.beans.BeanUtils;

public class ApplicationTest {

    public static void main(String[] args) {

        Person person = new Person();
        person.setId(1);
        person.setName("EXISTING");
        person.setEmailAddress("EXISTING");
        person.setPhoneNumber("EXISTING");

        Person existingPerson = new Person();
        person.setName("UPDATED");
        person.setEmailAddress("UPDATED");

        BeanUtils.copyProperties(person, existingPerson);

        person.getName();
    }

}
