package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("getNavbar")
public class AjaxNavbarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxNavbarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward request & response to navbar.html
		request.getRequestDispatcher("features/navbar/navbar.html").forward(request, response);
	}

}
