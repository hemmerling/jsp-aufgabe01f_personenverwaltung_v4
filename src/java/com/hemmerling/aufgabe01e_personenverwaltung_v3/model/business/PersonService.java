/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business;

import com.hemmerling.aufgabe01e_personenverwaltung_v3.model.persistence.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class PersonService {
    
    /* static */ List<String[]> persons;
    private static PersonService instance = null;

    protected PersonService(){
        // Exists only to defeat instantiation.
    }
    
    public static PersonService getInstance() {
        if ( instance == null) {
            instance = new PersonService();
        }
        return instance;
    }    
    
    public List<String[]> get(){
        if (persons == null) {
            persons = new ArrayList<String[]>();
        }
        return persons;
    }
    
    public void add(Person person){
        persons.add(new String[]{person.getVorname(), person.getNachname()});
    }
    
    public void set(int id, Person person){
        persons.set(id, new String[]{person.getVorname(), person.getNachname()});
    }

    public void remove(int id){
        persons.remove(id);
    }

}
