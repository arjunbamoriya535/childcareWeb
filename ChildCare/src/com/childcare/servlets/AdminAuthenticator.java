package com.childcare.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.childcare.dao.BabyDao;
@WebServlet("/AdminAuthenticator")
public class AdminAuthenticator extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");  
        PrintWriter out = response.getWriter(); 
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		/*
		 * if(name.equals("admin")&&password.equals("admin123")){ HttpSession
		 * session=request.getSession(); session.setAttribute("adminlogin","true");
		 * request.getRequestDispatcher("AdminHome").forward(request, response); }else{
		 * request.getRequestDispatcher("AdminError").forward(request, response); }
		 */
		   HttpSession session = request.getSession(false);
	        if(session!=null)
	        session.setAttribute("name", name);

	        if(BabyDao.validate(name, password)){  
	        	HttpSession session1=request.getSession(); session1.setAttribute("adminlogin","true");
	        	request.getRequestDispatcher("AdminHome").forward(request, response);
	        }  
	        else{  
	           /// out.print("<p style=\"color:red\">Sorry username or password error</p>");  
	            request.getRequestDispatcher("AdminError").forward(request, response); 
	           // rd.include(request,response);  
	        }  

	}

}
