<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	border: 2px solid blue;
	border-radius: 20px;
	background: linear-gradient(to right, skyblue, white);
}

</style>
</head>
<body>
<%
	ArrayList<ProductDTO> list = (ArrayList<ProductDTO>) session.getAttribute("product");
	if(list != null ){
		
%>
		<div>
			<h1>선택한 상품 리스트</h1>
			<%
				for(ProductDTO dto : list) {
					
			%>
				<ul>
					<li><%= dto.getProductName() %> 상품<%= dto.getCount() %>개</li>
				</ul>
			<%
				}
			%>

			<a href="/sedu/basket">상품 비우기</a><br>
			<a href="/sedu/htmlexam/productlog.html">상품 선택하기</a>
		</div>
<% 
	} else {		
%>
		<div>
			<h1>선택한 상품이 없어요</h1>
			<a href="/sedu/htmlexam/productlog.html">상품 선택하기</a>
		</div>
<%
	}
%>
</body>
</html>