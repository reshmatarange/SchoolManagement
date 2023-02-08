<%@page import="entity.Teacher"%>
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
<style>
body{
background-color: mintcream;
}
fieldset{

display: inline-block;
border-bottom-width: 1px;
			border-bottom-color: black;
			border-bottom-style: solid;
			border-right-width: 2px;
			border-right-color: black;
			border-right-style: solid;
			height: 122px;
			width: 345px;
		
			box-shadow: 2px 3px 5px gray;
				background-color: lavender;
				font-size: 20px;
				align: center;
}
.t{
cursor: pointer;
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
	Teacher t = em.find(Teacher.class, id1);
	%>
	<% if(t!=null) {%>
	<form action="updateTeacher" method="post">
		<fieldset>
			<table cellpading="20px" cellspacing="0" >
				<tr>
				
					<td>id:</td>
					<td><input type="text" value="<%=t.getId()%>" name="id"></td>
				</tr>
				<tr>
					<td>name:</td>
					<td><input type="text" value="<%=t.getName()%>" name="name"></td>
				</tr>


				<tr>
					<td>salary:</td>
					<td><input type="text" value="<%=t.getSalary()%>"
						name="salary"></td>
				</tr>

				<tr>
					<td>subject:</td>
					<td><input type="text" value="<%=t.getSubject()%>"
						name="subject"></td>
				</tr>
				<tr>
					<td><input type="Submit" class="t"></td>
					<td><input type="Reset" class="t"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<%} %>
	<%   if(t==null) { %>
	<form action="">
	<fieldset>
	<h4>Invalide Id</h4>
	<a href="Updateteacher.html"> go to back </a>
	</fieldset>
	</form>
	<%} %>
	

</body>
</html>