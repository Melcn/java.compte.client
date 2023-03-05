<%@page import="Model.Clicli"%>
<%@page import="java.util.ArrayList" %>
<%@ page import = "DAO.ClicliDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link href="../style.css" rel="stylesheet" type="text/css">
	<title>Insert title here</title>
	</head>
	<body>
		<%
	ArrayList<Clicli> ar = (ArrayList)request.getAttribute("array");
	//out.print(request.getAttribute("compte"));
	
	for (Clicli c : ar) {
		out.print(c);

	}
	%>
	
	</body>
</html>