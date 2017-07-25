/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe01f_personenverwaltung_v4.model.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rhemmerling
 */
public interface Action {
    public abstract void execute(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException;
}
