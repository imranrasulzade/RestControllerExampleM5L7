package com.matrix.personalmanagementjdbcm5l7.controller;

import com.matrix.personalmanagementjdbcm5l7.service.PersonalService;
import com.matrix.personalmanagementjdbcm5l7.model.Person;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonController {

    private final PersonalService personalService;

    public PersonController(PersonalService personalService){
        this.personalService = personalService;
    }

    @GetMapping("/select")
    public String selectPersonById(@RequestParam(name = "id") int id){
       return personalService.selectPersonById(id);
    }

    @GetMapping("/selectAll")
    public List<Person> selectAll(){
        return personalService.selectAll();
    }

    @PostMapping("/")
    public String setPerson(@RequestBody Person person){
        if(personalService.setPerson(person))
            return "1 row successfully ADDED ✅";
        else
            return "Unsuccessfully adding process!!!";
    }

    @PutMapping("/")
    public String updatePerson(@RequestBody Person person){
        if(personalService.updatePerson(person))
            return "1 row successfully UPDATED ✅";
        else
            return "Unsuccessfully updating process!!!";
    }

    @DeleteMapping("/delete")
    public String deletePerson(@RequestBody Person person){
        if(personalService.deletePerson(person.getId()))
            return "1 row DELETED successfully ✅";
        else
            return "Unsuccessfully deleting process!!!";
    }
}
