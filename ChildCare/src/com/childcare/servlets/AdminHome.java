package com.childcare.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<h1>Admin Home</h1>");
		out.print(" <a href='AddBabyNameForm' class='btn btn-primary' role='button'>Add Baby Name</a> ");
		out.print(" <a href='ViewBabyName' class='btn btn-primary' role='button'>View Baby Names</a> ");
		out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
				
		request.getRequestDispatcher("footer.html").include(request, response);
		
	}

}
