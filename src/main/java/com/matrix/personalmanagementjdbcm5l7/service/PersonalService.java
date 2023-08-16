package com.matrix.personalmanagementjdbcm5l7.service;

import com.matrix.personalmanagementjdbcm5l7.model.Person;
import com.matrix.personalmanagementjdbcm5l7.utilty.DbConnection;
import com.matrix.personalmanagementjdbcm5l7.utilty.IQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface PersonalService {
    String selectPersonById(int id);

     List<Person> selectAll();

    boolean setPerson(Person person);

     boolean updatePerson(Person person);
     boolean deletePerson(int id);

}
