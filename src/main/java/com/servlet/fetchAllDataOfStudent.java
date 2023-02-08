package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Student;

@WebServlet("/displayAll1")
public class fetchAllDataOfStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Reshma");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Query q = em.createQuery("select s from Student s");
		List<Student> s = q.getResultList();
		HttpSession hs = req.getSession();
		hs.setAttribute("AllStudentDeatails", s);

		RequestDispatcher rd = req.getRequestDispatcher("displayStudent.jsp");
		rd.include(req, resp);
		

	}

}
