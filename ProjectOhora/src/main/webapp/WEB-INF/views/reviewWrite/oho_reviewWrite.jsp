<%@page import="kr.ohora.www.domain.review.ReviewRating"%>
<%@page import="java.util.List"%>
<%@page import="kr.ohora.www.domain.product.ProductDTO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>



<%
    String pdtId = request.getParameter("pdt_id");
    
    String path = request.getContextPath();
    
    String photoToggle = request.getParameter("phototoggle");
%>
<%
String sortType = request.getParameter("sort");
if (sortType == null) {
    sortType = "recommend";
}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오호라 팀 프로젝트</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<script src="/projectOhora/resources/cdn-main/example.js"></script>
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/oho-review.css">
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
<script type="text/javascript">
   // 전역 변수로 설정
   var userId = 
	   <sec:authorize access="isAnonymous()">
   null
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.user.userId"/> 
	</sec:authorize>;
	
    const csrfHeaderName = "${_csrf.headerName}";
    const csrfToken = "${_csrf.token}";
</script>
</head>

<body>


<div style="text-align: center">리뷰작성</div>

<form action="" method="post" enctype="multipart/form-data">
    <div  style="text-align: center;"><textarea name="rvContent" rows="30" cols="80" style="resize: none;"></textarea></div>
     <div><input type="file" name="attach" multiple="multiple"></div>
    
<!--     <div><input type="file" name="attach"></div>
    <div><input type="file" name="attach"></div>
    <div><input type="file" name="attach"></div>
    <div><input type="file" name="attach"></div>
    <div><input type="file" name="attach"></div>
 -->    
 	<div><input type="submit"></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">      
    <input type="hidden" name="ordNo" value="${ordNo}">      
  </form>

<script src="<%= path %>/resources/js/oho-review.js"></script>
    <!-- 콘텐츠 -->

    <!-- 아래 필수 리뷰는 아니고-->

  </body>
</html>
