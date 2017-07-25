/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01e_personenverwaltung_v3.controller;

import com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonSetAction;
import com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.Action;
import com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonSaveAction;
import com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonDeleteAction;
import com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String CREATE = "create";
    private static final String VIEW = "view";
    private static final String DELETE = "delete";
    private static final String UPDATE = "update";
    private static final String SET = "set";

    private static final String STARTPAGE = "index.jsp";
    private static final String CREATEPAGE = "create.jsp";
    private static final String VIEWPAGE = "view.jsp";

    private static final String PERSONS = "persons";

    private static Properties actionMap = new Properties();

    static {
        // "actionName", FQN = "Fully Qualified Name"
        actionMap.setProperty(FrontController.UPDATE,
                "com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonSaveAction");
        actionMap.setProperty(FrontController.CREATE,
                "com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonSaveAction");
        actionMap.setProperty(FrontController.VIEW,
                "com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonViewAction");
        actionMap.setProperty(FrontController.DELETE,
                "com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonDeleteAction");
        actionMap.setProperty(FrontController.SET,
                "com.hemmerling.aufgabe01e_personenverwaltung_v3.model.business.PersonSetAction");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        String nextPage = STARTPAGE;
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        PersonService personService = PersonService.getInstance(); // Singleton
        Object obj = session.getAttribute(PERSONS);
        List<String[]> persons = personService.get();
        session.setAttribute(PERSONS, persons);

        String todo = request.getParameter(ACTION);

        if (todo != null && !todo.trim().isEmpty()) {
            String className = actionMap.getProperty(todo);
            Action action = (Action) Class.forName(className).newInstance();
            action.execute(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
