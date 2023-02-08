<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
body{
background-color: aquamarine;
}
#div1{
 border-bottom-width: 1px;
			border-bottom-color: black;
			border-bottom-style: solid;
			border-right-width: 2px;
			border-right-color: black;
			border-right-style: solid;
			height: 122px;
			width: 345px;
		
			box-shadow: 2px 3px 5px gray;
				background-image: radial-gradient(lightslategray ,pink);
				font-size: 20px;
				align: center;
		
			}
</style>
</head>
<body>
<% Teacher t=(Teacher)session.getAttribute("Teacherdata"); %>

<h1 align="center" style="text-decoration: underline; font-size: 40px">Teacher details by id</h1>
<table cellpadding="20px" cellspacing="0"  border="5" id="div1" align="center">
<tr>
<th>id</th>
<th>name</th>
<th>salary</th>
<th>subject</th>
</tr>


<tr>
<td><%=t.getId() %></td>
<td><%=t.getName() %></td>
<td><%=t.getSalary() %></td>
<td><%= t.getSubject() %></td>
</tr>

</table>


</body>
</html>