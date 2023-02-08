package com.servlet;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;

import entity.Teacher;

@WebServlet("/teacher1")
public class fechAllDetailsofTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Reshma");
	EntityManager em=emf.createEntityManager();
	Query q=em.createQuery("select t from Teacher t");
	List<Teacher> t=q.getResultList();
	HttpSession hs=req.getSession();
	hs.setAttribute("teacherdetails", t);
	RequestDispatcher rd=req.getRequestDispatcher("displayTeacherDetails.jsp");
	rd.include(req, resp);
		
	}

}
