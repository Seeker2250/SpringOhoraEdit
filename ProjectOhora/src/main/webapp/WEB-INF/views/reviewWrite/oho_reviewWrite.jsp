<%@page import="java.util.Date"%>
<%@page import="kr.ohora.www.domain.review.ReviewRating"%>
<%@page import="java.util.List"%>
<%@page import="kr.ohora.www.domain.product.ProductDTO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
<style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f9f9f9;
      margin: 0;
      padding: 0;
      display: flex;
	  min-height: 100vh;
    }
    .review-form-container {
      width: 100%;
      max-width: 600px;
      background: #fff;
      padding: 20px;
      margin-left: 20px;
      border-radius: 8px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .review-form-container h2 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }
    .review-form-container textarea {
      width: 100%; /* 가로 100% */
      max-width: 500px; /* 최대 너비 제한 */
      height: 200px;
      margin: 0 auto; /* 가로 중앙 정렬 */
      display: block; /* 중앙 정렬을 위해 block으로 변경 */
      
      border: 1px solid #ccc;
      border-radius: 4px;
      resize: none;
      font-size: 14px;
    }
    .review-form-container input[type="file"] {
      display: block;
      margin: 15px auto;
    }
    .review-form-container input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    .review-form-container input[type="submit"]:hover {
      background-color: #45a049;
    }
    .hidden-input {
      display: none;
    }
  </style>
    <style>
     /* 전체를 중앙에 정렬 */
          .rating {
            display: flex;
            justify-content: center;
            align-items: center;

        }
        .rating {
            display: inline-block;
            direction: rtl; /* 오른쪽에서 왼쪽으로 방향 지정 */
        }
        .rating input[type="radio"] {
            display: none; /* 라디오 버튼 숨기기 */
        }
        .rating label {
            font-size: 3rem; /* 별 크기 */
            color: #ccc; /* 기본 회색 */
            cursor: pointer;
            transition: color 0.3s ease; /* 색상 전환 애니메이션 */
        }
        /* 클릭된 별과 그 왼쪽 별을 금색으로 */
        .rating input[type="radio"]:checked ~ label {
            color: gold;
        }

        /* 마우스 오버 시 해당 별과 왼쪽 별들을 금색으로 */
        .rating label:hover,
        .rating label:hover ~ label {
            color: gold;
        }

        /* 선택된 별과 그 왼쪽 별을 금색으로 */
        .rating input[type="radio"]:checked + label,
        .rating input[type="radio"]:checked ~ label {
            color: gold;
        }
    </style>
</head>
<body>
<% Date writeDate = new Date(); %>
  <div class="review-form-container">
    <h2>리뷰 작성</h2>
    <form id="reviewWrite" action="/reviewPopWrite.htm?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
      <textarea name="revContent" placeholder="리뷰 내용을 입력하세요(최대 200자)" maxlength="200"></textarea>
      <input id="attach" type="file" name="attach" multiple="multiple" accept="image/*">
    <p id="error-message" style="color: red; font-size:10px"></p>
    
      <input type="hidden" name="opdtId" value="${opdtId}" class="hidden-input">
      <input type="hidden" name="ordPk" value="${ordPk}" class="hidden-input">
      <input type="hidden" name="ordPk" value="${pdtId}" class="hidden-input">
      <input id="isPhoto" type="hidden" name="revIsphoto" value="" class="hidden-input">
      <input id="userId" type="hidden" name="userId" value="<sec:authentication property="principal.user.userId"/> " class="hidden-input">
      <%-- <input id="revWritedate" type="hidden" name="revWritedate" value="<%=writeDate %>" class="hidden-input"> --%>
 
       <div class="rating">
            <input type="radio" id="star5" name="revRating" value="5">
            <label for="star5">★</label>
            <input type="radio" id="star4" name="revRating" value="4">
            <label for="star4">★</label>
            <input type="radio" id="star3" name="revRating" value="3">
            <label for="star3">★</label>
            <input type="radio" id="star2" name="revRating" value="2">
            <label for="star2">★</label>
            <input type="radio" id="star1" name="revRating" value="1" checked="checked">
            <label for="star1">★</label>

       <input id="submitRV" type="submit" value="리뷰 등록">
        </div>
    </form>
  </div>
</body>

<script type="text/javascript">
document.getElementById('submitRV').addEventListener('click', function (event) {
    const fileInput = document.getElementById('attach');
    const maxFiles = 5; // 최대 파일 개수
    const errorMessage = document.getElementById('error-message');

    if (fileInput.files.length > maxFiles) {
        event.preventDefault(); // 폼 전송 차단
        errorMessage.textContent = `파일은 최대 \${maxFiles}개까지 업로드할 수 있습니다.`;
        fileInput.value = ""; // 선택 초기화
    } else {
        errorMessage.textContent = ""; // 에러 메시지 초기화
        
        if (fileInput.files.length>0) {
        	document.getElementById('isPhoto').value="Y"
        	document.getElementById('reviewWrite').submit();
		} else {
        // 폼 제출
        document.getElementById('isPhoto').value="N"
        document.getElementById('reviewWrite').submit();
		}//else
    
    }//else
});
</script>

</html>
</html>
