<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String contextPath = request.getContextPath();
	String userID = (String) session.getAttribute("userID");
	System.out.print("change " + userID);
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
<link href="https://fonts.googleapis.com/css?family=Libre+Baskerville&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<style>
.cancel-button-container {
    width: 500px;
    height: 50px;
    position: absolute;
    top: 262px;  /* 비밀번호 변경 버튼 바로 아래 */
    background-color: #fff;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
}

.cancel-button {
    background-color: transparent;
    border: none;
    color: rgba(0, 0, 0, 1);
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 18px;
    cursor: pointer;
}
.container {
	overflow: hidden;
	width: 1920px;
	height: 670px;
	position: absolute;
}

.title {
	color: rgba(0, 0, 0, 1);
	width: 138.04px;
	height: 37px;
	position: absolute;
	left: 811.84px;
	top: 130px;
	font-family: 'Libre Baskerville', serif;
	text-align: center;
	font-size: 30px;
	white-space: nowrap;
	font-weight: bold;
}

.description {
	color: rgba(119, 119, 119, 1);
	width: 496.52px;
	height: 35px;
	position: absolute;
	left: 711.84px;
	top: 205px;
	font-family: 'Noto Sans KR', sans-serif;
	text-align: center;
	font-size: 12px;
	line-height: 1.5;
}

.form-container {
	width: 500px;
	height: auto;
	position: absolute;
	left: 710px;
	top: 261px;
}

.label-container {
	background-color: rgba(241, 241, 241, 1);
	width: 160px;
	height: 34px;
	position: absolute;
	top: 10px;
	display: flex;
	align-items: center;
	padding-left: 10px;
}

.label-text {
	color: rgba(0, 0, 0, 1);
	font-family: 'Noto Sans KR', sans-serif;
	text-align: left;
	font-size: 12px;
	line-height: 1.5;
}

.input-field {
	width: 330px;
	height: 34px; 
	position: absolute;
	left: 170px;
	border: 1px solid rgba(221, 221, 221, 1);
	padding: 0 10px;
	font-size: 12px;
	font-family: 'Noto Sans KR', sans-serif;
	box-sizing: border-box; 
}

.button-container {
	width: 500px;
	height: 60px;
	position: absolute;
	top: 200px;
	background-color: rgba(0, 0, 0, 1);
	border: 1px solid rgba(0, 0, 0, 1);
	display: flex;
	align-items: center;
	justify-content: center;
}

.button-container button {
	background-color: transparent;
	border: none;
	color: rgba(255, 255, 255, 1);
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 18px;
	cursor: pointer;
}

#changeBtn {
	cursor: pointer;
}

#failBtn {
	cursor: pointer;
}
</style>

</head>
<body>

<div class="container"></div>
<span class="title">PASSWORD FIND</span> 
<span class="description">
    비밀번호 재설정
</span>

<form  class="form-container" id="changePwForm" action="<%= contextPath %>/login/changepasswd.do" method="post">
    <!-- 아이디 입력란 (읽기 전용) -->
    <div class="label-container">
        <span class="label-text">아이디</span>
    </div>
    
    <input type="text" class="input-field" style="top: 10px;" name="user_id" value="<%= userID %>" readonly>

    <%-- <input type="text" class="input-field" style="top: 10px;" name="user_id" value="${user_id}" readonly> --%>

    <!-- 새 비밀번호 입력란 -->
    <div class="label-container" style="top: 55px;">
        <span class="label-text">새 비밀번호</span>
    </div>
    <input type="password" class="input-field" style="top: 55px;" id="newPasswd" name="new_password" placeholder="새 비밀번호를 입력하세요">

    <!-- 비밀번호 안내 메시지 -->
    <div class="label-text" style="position: absolute; top: 95px; left: 170px; font-size: 10px;">
        (영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자)
    </div>

    <!-- 새 비밀번호 확인 입력란 -->
    <div class="label-container" style="top: 115px;">
        <span class="label-text">새 비밀번호 확인</span>
    </div>
    <input type="password" class="input-field" style="top: 115px;" id="confirmNewPasswd" name="confirm_password" placeholder="새 비밀번호를 확인하세요">

    <!-- 버튼 영역 -->
    <div class="button-container" id="changeBtn">
        <button type="submit" class="button-text" onclick="">비밀번호 변경</button>
    </div>
    <div class="cancel-button-container" id="failBtn">
    <button type="button" class="cancel-button" onclick="">취소</button>
</div>
</form>

<!-- 비밀번호 유효성 검사 함수 -->
<script>
	function validatePassword(password) {
	    // 길이 체크
	    if (password.length < 8 || password.length > 16) {
	        // alert("비밀번호는 8자에서 16자 사이여야 합니다.");
	        return false;
	    }
	
	    // 정규표현식 정의
	    const hasUpperCase = /[A-Z]/.test(password); // 대문자
	    const hasLowerCase = /[a-z]/.test(password); // 소문자
	    const hasNumber = /[0-9]/.test(password); // 숫자
	    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password); // 특수문자
	
	    // 조건 검사: 4가지 중 2가지 이상 포함해야 함
	    const validConditions = [hasUpperCase, hasLowerCase, hasNumber, hasSpecialChar].filter(Boolean).length;
	
	    if (validConditions < 2) {
	        // alert("비밀번호는 영문 대소문자, 숫자, 특수문자 중 2가지 이상 조합이어야 합니다.");
	        return false;
	    }
	
	    // 모든 조건을 만족하는 경우
	    return true;
	}
</script>

<!-- 확인 버튼 -->
<script>
	$("#changeBtn").on("click", function(event){
		event.preventDefault();
		
		let newPasswdVal = $("#newPasswd").val();
		
		// 첫 번째 조건을 먼저 확인하고, 해당하지 않으면 함수 종료
		if (!validatePassword(newPasswdVal)) {
			alert("비밀번호 입력 조건을 다시 한번 확인해주세요.");
			return; // 조건이 맞지 않으면 이후 코드 실행하지 않음
		}
		
		// 두 번째 조건 확인
		if ($("#confirmNewPasswd").val() !== newPasswdVal) {
			alert("새 비밀번호 확인이 정확하지 않습니다. 다시 입력해주세요.");
			return; // 조건이 맞지 않으면 함수 종료
		}
		
		// 모든 조건을 만족하는 경우 폼 제출
		$("#changePwForm").submit();
	});
</script>

<!-- 취소 버튼 -->
<script>
	$("#failBtn").on("click", function(){
		location.href = "<%= contextPath %>/product/main.do";
	});
</script>

</body>
</html>