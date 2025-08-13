<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String,String> map = (Map<String,String>) request.getAttribute("map");
	
	String msg = map.get("msg");
	String imginfo = map.get("imginfo");
%>
<%= msg %>
<% 
	if(imginfo == null && imginfo.isEmpty()) {
		out.print("<a href='/sedu/clientexam/lottoForm3.html'>로또 응모3</a> ");
	} else {
%>
		<img src="<%= imginfo%>">
<%
	} 
%>		
</body>
</html>