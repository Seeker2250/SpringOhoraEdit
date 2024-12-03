<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/prdAdd.htm?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	<!-- <form action="" method="post" enctype="multipart/form-data"> -->
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
		
	    <table border="1" style="border-collapse: collapse; width: 50%; margin: auto;">
	        <thead>
	            <tr>
	                <th colspan="2" style="text-align: center; padding: 10px; background-color: #f2f2f2;">상품 추가</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr>
	                <td style="padding: 10px; text-align: right;">상품명:</td>
	                <td style="padding: 10px;">
	                    <input type="text" id="pdtName" name="pdtName" required style="width: 100%;">
	                </td>
	            </tr>
	            <tr>
	                <td style="padding: 10px; text-align: right;">메인 카테고리 ID:</td>
	                <td style="padding: 10px;">
	                    <select id="catId" name="catId">
	                    	<option value="" disabled selected>상품의 메인 카테고리를 선택하세요</option>
	                    	<option value="1">네일</option>
                            <option value="2">페디</option>
                            <option value="3">케어앤툴</option>
	                    </select>
	                </td>
	            </tr>
	            <tr>
	                <td style="padding: 10px; text-align: right;">상품 가격:</td>
	                <td style="padding: 10px;">
	                    <input type="number" id="pdtAmount" name="pdtAmount" style="width: 100%;">
	                </td>
	            </tr>
	            <tr>
	                <td style="padding: 10px; text-align: right;">할인율:</td>
	                <td style="padding: 10px;">
	                    <input type="number" id="pdtDiscountRate" name="pdtDiscountRate" style="width: 100%;">
	                </td>
	            </tr>
	            <tr>
	                <td style="padding: 10px; text-align: right;">재고량:</td>
	                <td style="padding: 10px;">
	                    <input type="number" id="pdtCount" name="pdtCount" style="width: 100%;">
	                </td>
	            </tr>
	            <tr>
				    <td style="padding: 10px; text-align: right;">이미지1 업로드:</td>
				    <td style="padding: 10px;">
				        <input type="file" id="file1" name="file1" style="width: 100%;">
				    </td>
				</tr>
				<tr>
				    <td style="padding: 10px; text-align: right;">이미지2 업로드:</td>
				    <td style="padding: 10px;">
				        <input type="file" id="file2" name="file2" style="width: 100%;">
				    </td>
				</tr>
	            <tr>
	                <td style="padding: 10px; text-align: right;">상품 설명:</td>
	                <td style="padding: 10px;">
	                    <textarea id="pdtDescription" name="pdtDescription" style="width: 100%; height: 100px;"></textarea>
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2" style="text-align: center; padding: 10px;">
	                    <button type="submit" style="padding: 10px 20px; border: 1px solid black; background-color: #ddd">상품 추가</button>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	    
	</form>


</body>
</html>