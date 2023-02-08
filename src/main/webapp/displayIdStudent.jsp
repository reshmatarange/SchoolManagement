<%@page import="java.util.List"%>
<%@page import="entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
#s{
 border-bottom-width: 1px;
			border-bottom-color: black;
			border-bottom-style: solid;
			border-right-width: 2px;
			border-right-color: black;
			border-right-style: solid;
			height: 122px;
			width: 345px;
		
			box-shadow: 2px 3px 5px gray;
				background-image: radial-gradient(lightslategray ,pink,lightred);
				font-size: 20px;
				text-align: center;
				font-weight: 700px;
		
			}
</style>
</head>
<body>
<h1 align="center" style="text-decoration: underline; font-weight: bolder"> Student details by  id</h1>

<% List<Student> s=(List)session.getAttribute("Studentdata");%>
<table cellpadding=2px align="center" border="5" cellspacing="0" id="s">
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