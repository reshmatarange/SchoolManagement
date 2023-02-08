package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import javax.servlet.http.HttpSession;

import com.mysql.cj.Query;

import entity.Student;

@WebServlet("/idStudent1")
public class idDisplayStudent extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Reshma");
		EntityManager em=emf.createEntityManager();
		
		
		javax.persistence.Query q=em.createQuery("select p from Student  p where p.id=?1 ");
		q.setParameter(1, id1);
		List<Student> s=q.getResultList();
		
	//Student s=em.find(Student.class, id1);
	if(s.size()>0)
	{
	HttpSession hs=req.getSession();
	hs.setAttribute("Studentdata", s);
	RequestDispatcher rd=req.getRequestDispatcher("displayIdStudent.jsp");
	rd.include(req, resp);
	}
	else
	{
		PrintWriter pw=resp.getWriter();
		pw.write("this id not present your Student list");
		RequestDispatcher rd=req.getRequestDispatcher("idStudent.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
	
	}

}
