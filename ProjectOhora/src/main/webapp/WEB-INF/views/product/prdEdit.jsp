<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ page import="kr.ohora.www.domain.product.ProductDTO" %>
<%@ page import="kr.ohora.www.domain.product.OptionDTO" %>
<%
    // productId를 사용해 DB에서 해당 상품 정보를 조회하여 화면에 출력하는 코드 작성
    String productId = request.getParameter("productId");
    
    // product 객체를 명시적으로 선언하고 가져오기
    ProductDTO product = (ProductDTO) request.getAttribute("product"); 
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
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/prdDetailView.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
 <script type="text/javascript">
    window.hasProductCountSession = ${not empty sessionScope.userId};
</script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
<%-- <%@include file="header.jsp" %> --%>
</head>
<body>

<form action="/prdEdit.htm?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
    <input type="hidden" id="pdtId" name="pdtId" value="${product.pdtId}">

    <table border="1" style="border-collapse: collapse; width: 50%; margin: auto;">
        <thead>
            <tr>
                <th colspan="2" style="text-align: center; padding: 10px; background-color: #f2f2f2;">상품 수정</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td style="padding: 10px; text-align: right;">상품명:</td>
                <td style="padding: 10px;">
                    <input type="text" id="pdtName" name="pdtName" required style="width: 50%;" value="${product.pdtName}">
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">판매량:</td>
                <td style="padding: 10px;">
                    <input type="text" id="pdtSalesCount" disabled="disabled" style="width: 50%;" value="${product.pdtSalesCount}">
                    <input type="hidden" name="pdtSalesCount" value="${product.pdtSalesCount}">
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">리뷰수:</td>
                <td style="padding: 10px;">
                    <input type="text" id="pdtReviewCount" disabled="disabled" style="width: 50%;" value="${product.pdtReviewCount}">
                    <input type="hidden" name="pdtReviewCount" value="${product.pdtReviewCount}">
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">조회수:</td>
                <td style="padding: 10px;">
                    <input type="text" id="pdtViewcount" disabled="disabled" style="width: 50%;" value="${product.pdtViewcount}">
                    <input type="hidden" name="pdtViewcount" value="${product.pdtViewcount}">
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">메인 카테고리 ID:</td>
                <td style="padding: 10px;">
                    <select id="catId" name="catId">
                        <option value="1" <c:if test="${product.catId == 1}">selected</c:if>>네일</option>
                        <option value="2" <c:if test="${product.catId == 2}">selected</c:if>>페디</option>
                        <option value="3" <c:if test="${product.catId == 3}">selected</c:if>>케어앤툴</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">상품 가격:</td>
                <td style="padding: 10px;">
                    <input type="number" id="pdtAmount" name="pdtAmount" style="width: 50%;" value="${product.pdtAmount}">원
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">할인율:</td>
                <td style="padding: 10px;">
                    <input type="number" id="pdtDiscountRate" name="pdtDiscountRate" style="width: 50%;" value="${product.pdtDiscountRate}">%
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">재고량:</td>
                <td style="padding: 10px;">
                    <input type="number" id="pdtCount" name="pdtCount" style="width: 50%;" value="${product.pdtCount}">
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">이미지1 업로드:</td>
                <td style="padding: 10px;">
                    <p>현재 이미지:</p>
                    <img src="/resources/images/product_image/${product.pdtImgUrl}" alt="이미지1" style="max-width: 100%; height: auto; margin-bottom: 10px;"><br>
                    <input type="file" id="file1" name="file1" style="width: 50%;">
                    <input type="hidden" name="existingFile1" value="${product.pdtImgUrl}">
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">이미지2 업로드:</td>
                <td style="padding: 10px;">
                    <p>현재 이미지:</p>
                    <img src="/resources/images/product_image/${product.pdtImgUrl2}" alt="이미지2" style="max-width: 100%; height: auto; margin-bottom: 10px;"><br>
                    <input type="file" id="file2" name="file2" style="width: 50%;">
                    <input type="hidden" name="existingFile2" value="${product.pdtImgUrl2}">
                </td>
            </tr>
            <tr>
                <td style="padding: 10px; text-align: right;">상품 설명:</td>
                <td style="padding: 10px;">
                    <textarea id="pdtDescription" name="pdtDescription" style="width: 50%; height: 100px;"><c:choose><c:when test="${not empty product.pdtDescription}">${product.pdtDescription}</c:when><c:otherwise>상품 설명이 없습니다</c:otherwise></c:choose></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding: 10px;">
                    <button type="submit" style="padding: 10px 20px; border: 1px solid black; background-color: #ddd">상품 수정</button>
                </td>
            </tr>
        </tbody>
    </table>
</form>




</body>
   
</html>
