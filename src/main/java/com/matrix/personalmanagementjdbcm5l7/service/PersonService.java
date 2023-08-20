package com.matrix.personalmanagementjdbcm5l7.service;

import com.matrix.personalmanagementjdbcm5l7.model.Person;
import com.matrix.personalmanagementjdbcm5l7.utilty.DbConnection;
import com.matrix.personalmanagementjdbcm5l7.utilty.IQuery;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonalService{
    public String selectPersonById(int id){
        Person person = new Person();
        try{
            DbConnection.connect();
            PreparedStatement ps = DbConnection.CONNECTION.prepareStatement(IQuery.selectByIdQuery);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                person.setAll(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6));
            }
            rs.close();
            ps.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            DbConnection.disconnect();
        }
        return person.toString();
    }

    public List<Person> selectAll(){
        List<Person> persons = new ArrayList<>();
        try{
            DbConnection.connect();
            ResultSet rs = DbConnection.CONNECTION.createStatement().executeQuery(IQuery.selectAllQuery);
            while (rs.next()){
                Person person = new Person();
                person.setId(rs.getInt(1));
                person.setName(rs.getString(2));
                person.setSurname(rs.getString(3));
                person.setPhone(rs.getString(4));
                person.setAddress(rs.getString(5));
                person.setStatus(rs.getInt(6));

                persons.add(person);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            DbConnection.disconnect();
        }
        return persons;
    }

    public boolean setPerson(Person person){
        try{
            DbConnection.connect();
            PreparedStatement ps = DbConnection.CONNECTION.prepareStatement(IQuery.insertQuery);
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getAddress());
            ps.setInt(5, person.getStatus());

            int row = ps.executeUpdate();
            if(!(row > 0))
                return false;
            ps.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            DbConnection.disconnect();
        }
        return true;
    }

    public boolean updatePerson(Person person){
        try{
            DbConnection.connect();
            PreparedStatement ps = DbConnection.CONNECTION.prepareStatement(IQuery.updateQuery);
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getAddress());
            ps.setInt(5, person.getStatus());
            ps.setInt(6, person.getId());

            int row = ps.executeUpdate();
            if(!(row > 0))
                return false;
            ps.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            DbConnection.disconnect();
        }
        return true;
    }

    public boolean deletePerson(int id){
        try{
            DbConnection.connect();
            PreparedStatement ps = DbConnection.CONNECTION.prepareStatement(IQuery.deleteQuery);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            if(!(row > 0))
                return false;

            ps.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            DbConnection.disconnect();
        }
        return true;
    }
}
