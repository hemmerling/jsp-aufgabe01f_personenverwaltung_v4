/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01f_personenverwaltung_v4.model.persistence;

import java.util.Objects;

/**
 *
 * @author rhemmerling
 */
public class Person {
    
    private String vorname = "";
    private String nachname = "";

    public Person ( String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;        
    }
    
    public String getVorname() {
        return this.vorname;
    }
    
    public String getNachname() {
        return this.nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.vorname);
        hash = 97 * hash + Objects.hashCode(this.nachname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.vorname, other.vorname)) {
            return false;
        }
        if (!Objects.equals(this.nachname, other.nachname)) {
            return false;
        }
        return true;
    }
  
}
