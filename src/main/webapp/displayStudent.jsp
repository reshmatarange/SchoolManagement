<%@page import="entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#tab1{
background-image: linear-gradient(120deg,white,pink,white);
box-shadow:2px 3px 4px gray;
border-color: black;
 
}
</style>
</head>
<body>
<h1 align="center" style="text-decoration: underline; font-size: 40px; text-shadow: 1px 1px ligthpink">Students All Details</h1>
<% List<Student> s=(List)session.getAttribute("AllStudentDeatails") ;%>
<table  align="center" cellpadding="20" border="5"  cellspacing="0"  id="tab1">
<th>id</th>
<th>name</th>
<th>stream</th>
<th>fees</th>
<%for(Student s1:s){ %>
<tr>
<td><%=s1.getId() %></td>
<td><%=s1.getName() %></td>
<td><%=s1.getStream() %></td>
<td><%=s1.getFees() %></td>
</tr>
<%} %>

</table>


</body>
</html>