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

@WebServlet("/deleteTeacher")
public class deleteteachers extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Reshma");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		Teacher t=em.find(Teacher.class, id1);
		if(t!=null)
		{
		et.begin();
		em.remove(t);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("delete successfully");
		RequestDispatcher rd=req.getRequestDispatcher("teachermenu.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("invalid id ");
			RequestDispatcher rd=req.getRequestDispatcher("Deleteteacher.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		}
		
		
	}

}
