<%@page import="Model.Coco"%>
<%@page import="java.util.ArrayList" %>
<%@ page import = "DAO.cocoDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	ArrayList<Coco> ar = (ArrayList)request.getAttribute("array");
	//out.print(request.getAttribute("compte"));
	
	for (Coco c : ar) {
		out.print(c);

	}
	%>
</body>
</html>