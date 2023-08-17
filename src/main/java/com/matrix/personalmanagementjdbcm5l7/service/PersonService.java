package com.matrix.personalmanagementjdbcm5l7.service;

import com.matrix.personalmanagementjdbcm5l7.model.Person;
import com.matrix.personalmanagementjdbcm5l7.utilty.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService implements PersonalService{
    public String selectPersonById(int id){
        return PersonRepository.selectPersonById(id);
    }

    public List<Person> selectAll(){
        return PersonRepository.selectAll();
    }

    public boolean setPerson(Person person){
        return PersonRepository.setPerson(person);
    }

    public boolean updatePerson(Person person){
        return PersonRepository.updatePerson(person);
    }

    public boolean deletePerson(int id){
        return PersonRepository.deletePerson(id);
    }
}
