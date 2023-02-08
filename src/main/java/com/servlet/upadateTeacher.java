package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Teacher;

@WebServlet("/updateTeacher")
public class upadateTeacher  extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Reshma");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	String id=req.getParameter("id");
	String name=req.getParameter("name");
	String subject=req.getParameter("subject");
	String salary=req.getParameter("salary");
	
	Teacher t=new Teacher();
	t.setId(Integer.parseInt(id));
	t.setName(name);
	t.setSubject(subject);
	t.setSalary(Double.parseDouble(salary));
	
	et.begin();
	em.merge(t);
	et.commit();
	
	
	
	PrintWriter pw=resp.getWriter();
	pw.write("upadate successfully");
	RequestDispatcher rd=req.getRequestDispatcher("teachermenu.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
	
	
	}
}


