/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hemmerling.aufgabe01e_personenverwaltung_v3.model.persistence.Person;

/**
 *
 * @author rhemmerling
 */
public class PersonDeleteAction implements Action {

    // Parameter
    private static final String ID = "id";
    private static final String VIEWPAGE = "view.jsp";

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
        String id = request.getParameter(ID);
        try {
            int index = Integer.parseInt(id);
            PersonService personService = PersonService.getInstance(); // Singleton
            personService.remove(index);
        } catch (NumberFormatException nfe) {
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(VIEWPAGE);
        requestDispatcher.forward(request, response);
    }
}
