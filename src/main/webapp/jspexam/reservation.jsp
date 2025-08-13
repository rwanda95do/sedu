<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<h1><%= request.getParameter("name") %>님의 예약 내용</h1>
<hr>
<ol>
	<li>선택한 룸 : <%= request.getParameter("room") %> </li>
	<li>추가 요청 사항 :
	 <%
	 	String[] inquir = request.getParameterValues("inquir");
	 	for(int i=0; i<inquir.length; i++){
	 		if(i==inquir.length-1){
		 		out.print(inquir[i] );
	 		}else {
	 			out.print(inquir[i] + ", ");	
	 		}
	 	}
	 %>
	 </li>
	<li>예약 날짜 : 
	<% 
		LocalDate localDate = LocalDate.parse(request.getParameter("date"));
		String date = String.format("%d년 %02d월 %02d일",
				localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
		out.print(date);
	%> 
	</li>
</ol>
</body>
</html>