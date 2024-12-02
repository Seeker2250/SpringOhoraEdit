<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">관리자 페이지</h1><br />
	<!-- 경로 넣으면 된다. -->
	<h2 align="center"><a href="<%= contextPath %>/prdList.htm">메인 페이지로 이동</a></h2> <!-- 메인 페이지로 경로 바꿔야된다. -->
	<h2 align="center"><a href="<%= contextPath %>/prdAdd.htm">상품 등록 페이지로 이동</a></h2>
	<h2 align="center"><a href="<%= contextPath %>">상품 수정 페이지로 이동</a></h2>
	<h2 align="center"><a href="<%= contextPath %>">상품 삭제 페이지로 이동</a></h2>
</body>
</html>