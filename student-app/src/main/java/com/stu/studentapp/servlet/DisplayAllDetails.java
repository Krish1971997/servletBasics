package com.stu.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.studentapp.dao.StudentDatabaseOperations;
import com.stu.studentapp.dto.Student;

public class DisplayAllDetails extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		StudentDatabaseOperations operation=new StudentDatabaseOperations();
		ArrayList<Student> allstudenets=operation.getAllStudents();
		
		RequestDispatcher dispatch=req.getRequestDispatcher("Login-Menu.html");
		dispatch.include(req, resp);
		/*
		 * out.print("<hr>\r\n" + "<br>\r\n" + "<ul>\r\n" +
		 * "<li><a  href=\"DisplayAlldetails\">Display all details</a><br><br></li>\r\n"
		 * + "<li><a  href=\"search-student\">Search by ID</a><br><br></li>\r\n" +
		 * "<li><a  href=\"\">Update student</a><br><br></li>\r\n" +
		 * "<li><a  href=\"\">Delete student</a><br><br></li>\r\n" +
		 * "<li><a  href=\"\">Display based on marks</a><br><br></li>\r\n" +
		 * "<li><a  href=\"\">Logout</a><br><br></li>\r\n" + "</ul>");
		 */
		
		String table="<table border='1' style='width:100%'>"
				+ "<tr>"
				+ "<th style='width:10%'>ID</th>"
				+ "<th style='width:30%'>Name</>"
				+ "<th style='width:10%'>Marks</>"
				+ "<th style='width:35%'>Email</>"
				+ "<th style='width:35%'>Date</>"
				+ "</tr>" 
				+ "</table>";
		out.print(table);
		for (Student s1 : allstudenets) {
			String table_detail="<table border='1' style='width:100%'>"
					+ "<tr>"
					+ "<th style='width:10%'>"+s1.getId()+"</th>"
					+ "<th style='width:30%'>"+s1.getName()+"</>"
					+ "<th style='width:10%'>"+s1.getMarks()+"</>"
					+ "<th style='width:35%'>"+s1.getEmailId()+"</>"
					+ "<th style='width:35%'>"+s1.getDate()+"</>"
					+ "</tr>" 
					+ "</table>";
			out.print(table_detail);
		}
		
	
	}
}
