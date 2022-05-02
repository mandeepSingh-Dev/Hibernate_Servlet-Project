<%@page import="java.util.List"%>
<%@page import="Entity.Files" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<div align="center">
<table border="1">

<thead>
<th><strong>Image</strong></th>
<th><strong>Label</strong></th>
<th><strong>Caption</strong></th>
<th><strong>Username</strong></th>
<th><strong>Rollnumber</strong></th>
<th><strong>course</strong></th>
</thead>


<%
  List<Files> filees = ( List<Files> )request.getAttribute("DbList");
String path = "c:/images/"; 
for(Files file : filees)
   {
	 String filename = file.getFileName();
	 int id = file.getId();
	
     out.print("<tr>");
	 out.print("<td> <img src="+path+filename+" width=50 height=50> </td>");
	 out.print("<td text=center> "+file.getLabel()+"</td>");
	 out.print("<td>"+file.getCaption()+"</td>");
	 out.print("<td>"+file.getUsername()+"</td>");
	 out.print("<td>"+file.getRollnumber()+"</td>");
	 out.print("<td>"+file.getCourse()+"</td>");
	 
	 
out.print("<td><a href="+request.getContextPath()+"/MyServlet?page=updatePage&fileID="+id+ "  > Update Info </a> </td>");

	 out.print("</tr>");
   }
%>
</table>
</div>

</body>
</html>