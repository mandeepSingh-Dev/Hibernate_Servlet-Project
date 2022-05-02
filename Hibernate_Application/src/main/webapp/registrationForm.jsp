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

<img src= "C:/images/1.jpg"  width="200" height="267" >

<form action=<%= request.getContextPath() %>/MyServlet?operation=ADDregistrationDt method="post" enctype="multipart/form-data">
<table>
<tr><h1>Register</h1></tr>
<tr><p>Please fill in this form to create an account.</p></tr>
<tr><td><strong>Select Image</strong></td><td><input  type="file" name="image" multiple  ></td></tr>
<tr><td><strong>Label:</strong></td><td><input type="text" name="label" multiple ></td></tr>
<tr><td><strong>caption:</strong></td><td><input type="text" name="caption" multiple ></td></tr>
</br>
</br>
<tr><td><strong>Name:</strong></td><td><input type="text" name="username" multiple ></td></tr>
<tr><td><strong>Rollnumber:</strong></td><td><input type="number" name="rollnumber" multiple ></td></tr>
<tr><td><strong>Course:</strong></td><td><input type="text" name="course" multiple ></td></tr></br>
</br>

<tr><td> <input type="submit" value="Submit details" name="page1" value="submitForm"> </td></tr>


</table>

</form>

</div>

</body>
</html>