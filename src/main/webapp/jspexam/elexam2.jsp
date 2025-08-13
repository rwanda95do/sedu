<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL의 Query 문자열 추출</h2>
<hr>
전달된 메시지의 존재 여부 : ${ !empty param.message }<hr>
전달된 메시지의 내용은 ${param.message} 입니다.<br>
전달된 메시지의 내용은 ${param["message"]} 입니다.<br>
전달된 메시지의 내용은 <%= request.getParameter("message") %> 입니다.<br>
</body>
</html>
<!-- parma.message : message로 전달된 값 -->
<!-- 붜리 문자열이 messae가 비어있다면 null, EL은 비워둔다 -->
