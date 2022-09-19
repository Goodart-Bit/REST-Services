package com.mycompany.myproject.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juand
 */

@XmlRootElement (name="Person")
@XmlType (propOrder = {"id","fullName","age", "salary"})
public class Person {
    private int id;
    private String fullName;
    private int age;
    private int salary;
    
    public Person(){
    }
    
    @XmlElement
    public int getId() {
        return id;
    }
    
    @XmlElement
    public int getSalary(){
        return salary;
    }
    
    public void setSalary(int minSalary){
        salary = minSalary * age / 3;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

