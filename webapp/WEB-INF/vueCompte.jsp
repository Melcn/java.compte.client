<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="Model.compte"%>
<%@ page import="DAO.compteDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
	ArrayList<compte> tableau = (ArrayList)request.getAttribute("tableau");
	//out.print(request.getAttribute("compte"));
	
	for (compte compte : tableau) {
		out.print(compte);

	}
	%>

</body>
</html>