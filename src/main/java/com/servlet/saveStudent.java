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

import entity.Student;

@WebServlet("/addStudent")
public class saveStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String fees=req.getParameter("fees");
		int id1=Integer.parseInt(id);
		int fees1=Integer.parseInt(fees);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Reshma");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Student s=new Student();
		s.setId(id1);
		s.setName(name);
		s.setStream(stream);
		s.setFees(fees1);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Add Student data Successfully...");
		
		RequestDispatcher rd=req.getRequestDispatcher("Studentsmenu.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
		
		
		
		
		
		
	}

}

