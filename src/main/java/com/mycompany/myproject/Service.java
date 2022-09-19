package com.mycompany.myproject;

import com.mycompany.myproject.entity.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juand
 */
@Path("service")
public class Service {

    private static final Map<Integer, Person> PERSONS = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderful " + id);
            person.setAge(new Random().nextInt(40) + 1);
            int minSalary = new Random().nextInt(2000) + 1;
            person.setSalary(minSalary);
            PERSONS.put(id, person);
        }
    }

    @GET
    @Path("/getAllPersonsInXml")
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Person> getAllPersonsInXml() {
        return new ArrayList<>(PERSONS.values());
    }
    
    @POST
    @Path("/addPersonInJSON")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person addPersonInJSON(Person person){
        System.out.println(person.getId());
        PERSONS.put(person.getId(), person);
        return person;
    }

    @GET
    @Path("/getAvgSalaryFromPersonsInXml")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAvgSalaryFromPersonsInXml() {
        String avgSalary = Float.toString( (float)salarySum() / PERSONS.size());
        return "The average salary is $" + avgSalary;
    }

    @GET
    @Path("/getSalarySumFromPersonsInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public int getSalarySumFromPersonsInJSON() {
        return salarySum();
    }

    private int salarySum() {
        int sum = 0;
        for (Person person : PERSONS.values()) {
            sum += person.getSalary();
        }
        return sum;
    }
}
