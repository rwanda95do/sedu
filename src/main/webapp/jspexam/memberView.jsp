<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView</title>
</head>
<body>
<h1>회원 정보</h1>
<hr>
<%
	MemberDTO dto = (MemberDTO) request.getAttribute("member");
%>
<ul>
 <li>회원 이름 : <%= dto.getName() %></li>
 <li>회원 계정 : <%= dto.getId() %></li>
 <li>회원 암호 : <%= dto.getPassword() %></li>
 <li>회원 전화번호 : <%= dto.getPhone() %></li>
</ul>

<br>

<ul>
 <li>회원 이름 : ${ member.name}</li>
 <li>회원 계정 : ${ member.id}</li>
 <li>회원 암호 : ${ member.password }</li>
 <li>회원 전화번호 : ${ member.phone}</li>
</ul>

</body>
</html>