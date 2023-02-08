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

@WebServlet("/deleteStudent")
public class deleteStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Reshma");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, id1);
		if (s != null) {
			et.begin();
			em.remove(s);
			et.commit();
			PrintWriter pw = resp.getWriter();
			pw.write("Student data successfully deleted..");
			RequestDispatcher rd = req.getRequestDispatcher("Studentsmenu.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		} else {
			PrintWriter pw = resp.getWriter();
			pw.write(" Please enter correct id");
			RequestDispatcher rd = req.getRequestDispatcher("Deletestudent.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}

	}

}
