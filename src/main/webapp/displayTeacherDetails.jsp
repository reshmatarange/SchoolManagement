<%@page import="entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#tab{
background-image: linear-gradient(1200deg,white,pink,white);
box-shadow:2px 3px 4px gray;
border-color: black;
 
}
body{
background-color: lightgrey;
}
</style>
</head>
<body>
<h1 align="center" style="text-decoration: underline; text-shadow: 1.5px 1.5px gray; font-size:40px">Teachers All Details</h1>
<% List<Teacher> t=(List)session.getAttribute("teacherdetails") ;%>
<table align="center" cellpadding="20" border="5"  cellspacing="0" id="tab">
<th>id</th>
<th>name</th>
<th>salary</th>
<th>subject</th>
<% for(Teacher t1:t){%>
<tr>
<td><%=t1.getId() %></td>
<td><%=t1.getName() %></td>
<td><%=t1.getSalary() %></td>
<td><%=t1.getSubject() %></td>
</tr>
<%} %>

</table>
</body>
</html>