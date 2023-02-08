package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Teacher;

@WebServlet("/displayIdteacher1")
public class iddisplayteacher  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Reshma");
		EntityManager em=emf.createEntityManager();
		String id=req.getParameter("id");
		int id1=Integer.parseInt(id);
		Teacher t=em.find(Teacher.class, id1);
		if(t!=null)
		{
		HttpSession hs=req.getSession();
		hs.setAttribute("Teacherdata", t);
		RequestDispatcher rd=req.getRequestDispatcher("displayIdteacher.jsp");
		rd.forward(req, resp);
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("you enter invalid id ");
			
			RequestDispatcher rd=req.getRequestDispatcher("id.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
			
		}
	}

}
