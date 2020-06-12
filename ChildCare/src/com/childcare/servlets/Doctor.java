package com.childcare.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.childcare.bean.Baby;
import com.childcare.dao.BabyDao;

/**
 * Servlet implementation class Doctor
 */
@WebServlet("/Doctor")
public class Doctor extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Doctor</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		//request.getRequestDispatcher("navigation.html").include(request, response);
	
		
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("adminlogin")==null){
			
		}else{
			out.print(" <a href='AddBabyNameForm' class='btn btn-primary' role='button'>Add Baby Name</a> ");
			out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
		}
		
		
		
		out.println("<h1>View Child Doctors</h1>");
		List<Baby> list=BabyDao.getAllDoctorsRecords();
		out.print("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>City</th><th>Contact no</th><th>Image</th><th>Delete</th></tr>");
		for(Baby b:list){
			out.println("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getCity()+"</td><td>"+b.getPhone()+"</td><td>"+b.getImageData()+"</td>");
			
			if(session==null||session.getAttribute("adminlogin")==null){
				out.println("<td>Delete</td>");
				
			}else{
			out.println("<td><a href='DeleteBabyName?id="+b.getId()+"'>Delete</a></td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}

