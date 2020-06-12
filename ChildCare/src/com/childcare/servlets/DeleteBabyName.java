package com.childcare.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.childcare.dao.BabyDao;
@WebServlet("/DeleteBabyName")
public class DeleteBabyName extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		BabyDao.delete(id);
		
		response.sendRedirect("ViewBabyName");
		
	}


}
