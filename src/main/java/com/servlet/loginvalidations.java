package com.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import entity.Principal;
@WebServlet("/loginvalidation")
public class loginvalidations  extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Reshma");
	EntityManager em=emf.createEntityManager();
	
	Query q=em.createQuery("select p from Principal p where p.email=?1 and p.password=?2");
	q.setParameter(1, email);
	q.setParameter(2, password);
	List<Principal> p1=q.getResultList();
	if(p1.size()>0)
	{
		/*
		 * PrintWriter pw=resp.getWriter();
		 * pw.write("                   account seccessfully");
		 */
		RequestDispatcher rd=req.getRequestDispatcher("StudentTeacher.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
	else
	{
		PrintWriter pw=resp.getWriter();
		pw.write("invalid credential");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
	}
	
}
	

}
