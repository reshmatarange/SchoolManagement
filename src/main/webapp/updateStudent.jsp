<%@page import="entity.Student"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.a{
cursor: pointer;
background-color: cadetblue;
}
fieldset{
display: inline-block;
background-color: deepskyblue ;
box-shadow: black;
}
</style>
</head>
<body align="center">
	<%
	String id = request.getParameter("id");
	int id1 = Integer.parseInt(id);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Reshma");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Student s = em.find(Student.class, id1);
	%>
	<% if(s!=null) {%>
	<form action="updateStudent" method="post">
		<fieldset>
			<h4>Upadate details of Student..</h4>
			<table>
				<tr>
					<td>Update Id:</td>
					<td><input type=" text" value="<%=s.getId()%>" name="id"></td>
				</tr>

				<tr>
					<td>Update Name:</td>

					<td><input type=" text" value="<%=s.getName()%>" name="name"></td>
				</tr>
				<tr>
					<td>Update Stream:</td>
					<td><input type=" text" value="<%=s.getStream()%>"
						name="stream"></td>
				</tr>
				<tr>
					<td>Update fees:</td>
					
					<td><input type=" text" value="<%=s.getFees()%>" name="fees"></td>
				</tr>
				<tr>
					<td><input type="Submit" class="a"></td>
					<td><input type="Reset" class="a"></td>
				</tr>
			</table>
		</fieldset>


	</form>
	<%} %>
	<%if(s==null) {%>
	<form action="">
	<fieldset>
	<h4>Invalide Id</h4>
	<a href="Updatestudent.html"> go to back click Here </a>
	</fieldset>
	</form>
	<%} %>

</body>
</html>