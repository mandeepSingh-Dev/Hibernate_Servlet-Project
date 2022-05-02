<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entity.Files" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div align="center">
<% 	
    Files file = (Files)request.getAttribute("FILESobj");  
String path = "c:/images/"; 
out.print("<td> <img src="+path+file.getFileName()+" width=250 height=250> </td>");

%>
<form action=<%= request.getContextPath() %>/MyServlet?operation=updateFile  method="post" >

<table border="1" align="center">

<thead>

<th>Label</th>
<th>Caption</th>

</thead>
</br>

<tr>
<td><input type="text" name="updateLABEL"  value=<%= file.getLabel() %>></td>
<td><input type="text" name="updateCAPTION" value=<%= file.getCaption() %> ></td>
</tr>

<thead>

<th>username</th>
<th>rollnumber</th>

</thead>

<tr>
<td><input type="text" name="updateUSERNAME" value=<%= file.getUsername() %>></td>
<td><input type="text" name="updateROLLNUMBER" value=<%= file.getRollnumber() %>></td>
</tr>

</table>
</br>

<strong>Update Information</strong>
<input type="submit" name="operation1" value="update" >
</form>
</div>
</body>
</html>