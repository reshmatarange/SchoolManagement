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

@WebServlet("/updateStudent")
public class upadateStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Reshma");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String stream = req.getParameter("stream");
		String fees = req.getParameter("fees");
		Student s=new Student();
		s.setId(Integer.parseInt(id));
		s.setName(name);
		s.setStream(stream);
		s.setFees(Integer.parseInt(fees));
		
		et.begin();
		em.merge(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Sudent data successfully Update........");
		RequestDispatcher rd=req.getRequestDispatcher("Studentsmenu.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		

	}

}
