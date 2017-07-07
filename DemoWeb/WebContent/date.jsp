<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Server Date</title>
</head>
<body>

<h1>Served at date: <%= new Date() %></h1>
<% int count = 0; 
	out.println("Count is" + count);
%>
<h2>Visitor count: <%= count++ %></h2>
</body>
</html>