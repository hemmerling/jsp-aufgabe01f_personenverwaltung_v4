/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01f_personenverwaltung_v4.model.business;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hemmerling.aufgabe01f_personenverwaltung_v4.model.persistence.Person;

/**
 *
 * @author rhemmerling
 */
public class PersonSetAction implements Action {

    // Parameter
    private static final String VORNAME = "vorname";
    private static final String NACHNAME = "nachname";
    private static final String CREATEPAGE = "create.jsp";
    private static final String ID = "id";

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter(ID);
        String vorname = request.getParameter(VORNAME);
        String nachname = request.getParameter(NACHNAME);
        if ((idString != null)
                & (vorname != null && !vorname.trim().isEmpty())
                & (nachname != null && !nachname.trim().isEmpty())) {
            int id = Integer.valueOf(idString);
            Person person = new Person(vorname, nachname);
            PersonService personService = PersonService.getInstance(); // Singleton
            personService.set(id, person);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(CREATEPAGE);
        requestDispatcher.forward(request, response);
    }
}
