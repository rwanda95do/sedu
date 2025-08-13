<%@page import="model.CountDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>서블릿이 전달한 객체(session)-스크립트</h2>
<%
	// Servlet이 HttpServletRequest 객체를 이용해 jsp에 전달
	CountDTO dto = (CountDTO)session.getAttribute("objsession");
	if(dto != null) {
%>		
		추출된 값 : <%=  dto.getNumber() %> <br>
<%
	}else {
		out.print("추출된 객체가 없슈!!!");
	}
%> 
<hr>
<h2>서블릿이 전달한 객체(session)-스크립트</h2>
추출된 값 : ${ objsession.number}<br>
추출된 값 : ${ sessionScope.objsession.number}

</body>
</html>