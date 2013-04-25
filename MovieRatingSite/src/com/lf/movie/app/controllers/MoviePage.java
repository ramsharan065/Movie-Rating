package com.lf.movie.app.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: bijay
 * Date: 4/25/13
 * Time: 9:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class MoviePage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //System.out.println("may be "+request.getRequestURL());
        //String purl = (String)request.getAttribute("javax.servlet.forward.request_uri");

        request.getRequestDispatcher("/pages/app/moviePage.jsp").forward(request, response);
    }





}
