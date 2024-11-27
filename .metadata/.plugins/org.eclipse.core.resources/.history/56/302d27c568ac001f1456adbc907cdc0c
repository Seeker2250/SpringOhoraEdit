<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String contextPath = request.getContextPath();
	// String findUserID = (String) session.getAttribute("findUserID");
	String findUserID = request.getParameter("findUserID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오호라 팀 프로젝트</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/showUserID.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>

<style>
		    .container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100vw;
    height: 100vh;
    position: relative;
    overflow: hidden;
}

.title {
    color: rgba(0, 0, 0, 1);
    font-family: 'Libre Baskerville', serif;
    text-align: center;
    font-size: 30px;
    margin-bottom: 20px;
}

.description {
    color: rgba(119, 119, 119, 1);
    font-family: 'Noto Sans KR', sans-serif;
    text-align: center;
    font-size: 12px;
    line-height: 1.5;
    margin-bottom: 30px;
    max-width: 600px;
}

.button-container {
    width: 200px;
    height: 60px;
    background-color: rgba(0, 0, 0, 1);
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
}

.button-container button {
    background-color: transparent;
    border: none;
    color: rgba(255, 255, 255, 1);
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 18px;
    cursor: pointer;
}
    </style>
</head>
<body>
    <div class="container">
        <div class="title">아이디 찾기 완료</div>      
			        <div class="description">
			         <c:if test="${not empty findUserID}">
                     회원님의 아이디는 : ${findUserID} 입니다.
                    </c:if>
			        </div>			              
        <div class="button-container">
            <button onclick="location.href='${pageContext.request.contextPath}/ohora/login.jsp'">로그인 하러 가기</button>
        </div>
    </div>
</body>
</html>