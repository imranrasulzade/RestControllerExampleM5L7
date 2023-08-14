package com.matrix.personalmanagementjdbcm5l7.utilty;

import com.matrix.personalmanagementjdbcm5l7.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfig {

    @Bean("person")
    public Person getPerson(){
        Person person = new Person();
        return person;
    }
}
