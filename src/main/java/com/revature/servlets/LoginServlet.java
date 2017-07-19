package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.BankUser;
import com.revature.service.AppService;

@WebServlet("login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
//		super.doPost(req, resp);
		System.out.println("LoginServlet - POST ");
		
		// Create a BankUser and populate with info given client-side
		BankUser clientUser = new BankUser();
		
		// Pull the username and password by the name attribute in the HTML file
		clientUser.setUsername(req.getParameter("username"));
		clientUser.setPassword(req.getParameter("password"));
		
		// Valid the credentials entered by user against record in DB
									// validateUser returns record if match
									// else returns null if no match
//		clientUser = new AppService().validateUser(clientUser);
		
//		System.out.println(clientUser.getUsername() + ' ' + clientUser.getPassword());
		
		//Null check of clientUser
//		if(clientUser != null){
		
		System.out.println(clientUser.getUsername() + ' ' + clientUser.getPassword());
		
		if(clientUser.getUsername().equals("sam") && clientUser.getPassword().equals("123")){
			
			HttpSession session = req.getSession();
			session.setAttribute("user", clientUser);
			System.out.println("Success!");
			
			req.getRequestDispatcher("app.html").forward(req, resp);
		}else{
			System.out.println("Failure");
			resp.sendRedirect("login.html");
		}
	}
}
