<%@page import="ohora.domain.MyPageDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    // 상태별 카운트를 계산하기 위한 변수 초기화
    int countPrepareProduction = 0;
    int countPrepareDelivery = 0;
    int countShippedBegin = 0;
    int countShippedComplete = 0;

    // request에서 orderList를 가져옴
    ArrayList<MyPageDTO> myPageOrderList = (ArrayList<MyPageDTO>) request.getAttribute("myPageOrderList");

    // 상태별 카운트 계산
    if (myPageOrderList != null) {
        for (MyPageDTO order : myPageOrderList) {
            String status = order.getOpdt_state();  // opdt_state 필드 값을 기준으로 상태 가져오기
            if ("상품준비중".equals(status)) {
                countPrepareProduction++;
            } else if ("배송준비중".equals(status)) {
                countPrepareDelivery++;
            } else if ("배송중".equals(status)) {
                countShippedBegin++;
            } else if ("배송완료".equals(status)) {
                countShippedComplete++;
            }
        }
    }
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
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/oho_myPage.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<%@include file="header.jsp" %>
<body>

    <div id="main-container">

        <div id="contents">

            <div id="myPage-wrap">

                <div class="subSection">
                    <h2 class="subTitle">
                        <span>MY PAGE</span>
                    </h2>
                </div>
            
                

                <div class="profile-container">
                	<c:choose>
        			<c:when test="${not empty myPageList}">
        			<!-- myPageList의 첫 번째 요소에 접근 -->
            		<c:set var="myPageItem" value="${myPageList[0]}" />
                    <div class="member-info-wrap">

                        <div class="member-info"> 
                        <!-- 얘가 SP_Message임 -->
                            
                            <div class="info-msg">
                            
                                <div class="member-radius">
                                    <div class="radius-box" id="radiusBox">
                                        <canvas id="doughnut1" width="170" height="170" ></canvas>
                                       
                                        <!-- 원 그리는 스크립트 -->
                                        <script>
                                            // 1. canvas 엘리먼트 취득
                                            const canvas = document.getElementById('doughnut1');
                                            
                                            // 2. 2d모드의 그리기 객체 취득
                                            const ctx = canvas.getContext("2d");
                                
                                            // 3. path 그리기 시작 설정
                                            ctx.beginPath();
                                
                                            // 4. 외곽선
                                            ctx.lineWidth = 1.5; // 선 굵기 설정 (5픽셀)
                                            ctx.strokeStyle = "gray"; // 외곽선 색상 설정
                                
                                            // 5. 원 모양 설정
                                            // 중심 (85, 85), 반지름 85, 시작 각도 0, 끝 각도 2*Math.PI (완전한 원)
                                            ctx.arc(85, 85, 80, 0, 2 * Math.PI);
                                
                                            // 6. 내부 채우기 및 외곽선 그리기

                                            ctx.stroke();
                                        </script>
                                    </div>
                                </div>


                                <div class="infoMegBox_wrap">
                                    <p class="ment">
                                        <strong><span><span class="member-name">${myPageItem.user_name}</span></span></strong>님 반갑습니다.
                                    </p>
                                    <p class="grade">회원님의 등급은 
                                        <strong class="group">[
                                            <span class="groupName-wrap" id="groupName">
                                                <span class="group_name">${myPageItem.mem_name}</span>
                                            </span>]
                                        </strong>입니다. 
                                    </p>
                                    <p class="gradeValue" id="toNextGrade">다음 등급까지 
                                        <span id="changePrd" class="toNext-won">
                                            <span class="toNext-value">0
                                        </span>원
                                        </span> 남았습니다.
                                    </p>

                                    <p class="order_total">
                                        <span class="order_total_value">0</span>
                                    </p>
                                    <div class="user-UtilLink">
                                        <a href="">등급 혜택보기</a>
                                        <a href="">후기쓰러가기</a>
                                        <a href="">1:1문의하기</a>
                                    </div>
                                </div>


                            </div>   
                        </div>

                        <div class="order_info_wrap">
                            <div class="point_coupon-wrap">
                                <ul class="point_coupon">
                                    <li>
                                        <div class="pnc_displayTable">
                                            <div class="pnc_displayTableInr">
                                                <div class="myOrderInfoTitle">my point</div>
                                                <div class="myOrderInfoCont">
                                                    <a href="" class="pointCount" style="">${myPageItem.user_point}</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="pnc_displayTable">
                                            <div class="pnc_displayTableInr">
                                                <div class="myOrderInfoTitle">my coupon</div>
                                                <div class="myOrderInfoCont">
                                                    <a href="" style="">0</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- 오더 인포 랩 -->

                    </div>
                    </c:when>
    				</c:choose>
                </div>

                <div class="orderList-layout">
                    <div class="subSection">
                        <div class="ol-title-wrap">
                            <h3>order list</h3>
                            <div class="ol-moreBtn">
                                <a href="">+더보기</a>
                            </div>
                        </div>

                        <div class="orderState_wrap">
                            <ul>
                                <li>
                                    <a href="">
                                        <span>상품준비중</span>
                                        <span class="count">
                                            <span id="orderstate_prepare_production_count"><%= countPrepareProduction %></span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span>배송준비중</span>
                                        <span class="count">
                                            <span id="orderstate_prepare_delivery_count"><%= countPrepareDelivery %></span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span>배송중</span>
                                        <span class="count">
                                            <span id="xans_myshop_orderstate_shppied_begin_count"><%= countShippedBegin %></span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span>배송완료</span>
                                        <span class="count">
                                            <span id="xans_myshop_orderstate_shppied_complate_count"><%= countShippedComplete %></span>
                                        </span>
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <div class="order-history-wrap">
                            <table class="ordhistory-table">

                                <colgroup>
                                    <col width="170px">
                                    <col width="auto">
                                    <col width="200px">
                                    <col width="200px">
                                    <col width="180px">
                                </colgroup>

                                <thead>
                                    <tr>
                                    <th scope="col" class="number">주문일자</th>
                                    <th scope="col" class="thumb">상품정보</th>
                                    <th scope="col" class="product">상품금액</th>
                                    <th scope="col" class="product">결제금액</th>
                                    <th scope="col" class="quantity">주문상세</th>
                                    </tr>
                                </thead>

                                <tbody>
                                   <c:set var="previousDate" value="" />
		                           <c:set var="previousOrderId" value="" />
		                           <c:forEach var="orderDetail" items="${myPageOrderDetail}">
		                               <!-- 주문 번호가 변경되면 구분선 추가 -->
		                               <c:if test="${previousOrderId != orderDetail.ord_pk}">
		                                   <!-- 공백 행 또는 구분 행 추가 -->
		                                   <tr>
		                                       <td colspan="5" style="height: 1px; border-bottom: 2px solid #ccc;"></td>
		                                   </tr>
		                                   <c:set var="previousOrderId" value="${orderDetail.ord_pk}" />
		                               </c:if>
		                           
		                               <tr class="table-record">
		                                   <!-- 날짜 처리 -->
		                                   <td class="number center">
		                                       <c:choose>
		                                           <c:when test="${previousDate != orderDetail.ord_orderdate}">
		                                               <fmt:formatDate value="${orderDetail.ord_orderdate}" pattern="yyyy-MM-dd" />
		                                               <c:set var="previousDate" value="${orderDetail.ord_orderdate}" />
		                                           </c:when>
		                                           <c:otherwise>
		                                               <!-- 날짜가 이전과 같으면 빈 셀로 둡니다 -->
		                                           </c:otherwise>
		                                       </c:choose>
		                                   </td>
		                           
		                                   <td class="subject alignLeft">
		                                       <a href="">${orderDetail.opdt_name}</a>
		                                   </td>
		                           
		                                   <td class="price center">${orderDetail.opdt_amount}</td>
		                           
		                                   <td class="totalprice">0</td>
		                           
		                                   <td class="center number">
		                                       <a href="<%= contextPath %>/mypage/orderdetail.do?ord_pk=${orderDetail.ord_pk}&opdt_name=${orderDetail.opdt_name}&opdt_id=${orderDetail.opdt_id}" class="ordhistory-linkView">자세히보기</a>
		                                   </td>
		                               </tr>
		                           </c:forEach>

                                    <!-- <tr class="table-record">
                                        <td rowspan="3" class="number center ">2024.08.27</td>

                                        <td class="subject alignLeft">
                                            <a href="">P 글리터 샤워 페디</a>
                                        </td>
                                                            
                                        <td class="price center">12,800</td>
                                                            
                                        <td class="totalprice">0</td>
                                                            
                                        <td rowspan="3" class="center number ">
                                            <a href="" class="ordhistory-linkView">자세히보기</a>
                                        </td>
                                    </tr>
                                    <tr class="table-record">
                                        <td class="number center displayNone">2024.08.27</td>
                                        같은 날짜로 묶이는 애들은 디스플레이논 클래스가 주어짐

                                        <td class="subject alignLeft">
                                            <a href="">N 젤리 피치 네일</a>
                                        </td>

                                        <td class="price center">33,600</td>

                                        <td class="totalprice">0</td>
                                        
                                        <td class="center number">
                                            <a href="" class="ordhistory-linkView displayNone">자세히보기</a>
                                            얘도
                                        </td>                    
                                    </tr>
                                    <tr class="table-record">
                                        <td class="number center displayNone">2024.08.27</td>

                                        <td class="subject alignLeft">
                                            <a href="">N 졸라 피치 네일</a>
                                        </td>

                                        <td class="price center">13,600</td>

                                        <td class="totalprice">0</td>
                                        
                                        <td class="center number">
                                            <a href="" class="ordhistory-linkView displayNone">자세히보기</a>
                                        </td>                    
                                    </tr> -->
                                </tbody>
                                <!-- 주문 내역 없을 경우? -->
                                <tbody class="noOrder displayNone">
                                    <!-- 주문 내역이 있어서 displayNone? -->
                                    <tr>
                                        <td colspan="7" class="empty">주문 내역이 없습니다</td>
                                    </tr>
                                </tbody>

                            </table>

                        </div>

                    </div>

                    <div class="myShopMenu-layout">
                        <div class="myShopMenu-list">
                            <ul>
                                <!-- li 마다 after로 > 모양있음 -->
                                <li><a href="">주문내역</a></li>
                                <li><a href="<%=contextPath %>/member/modify.do?userId=<%=userId%>">회원정보</a></li>
                                <li><a href="<%=contextPath %>/address/addressselect.do">배송주소록</a></li>
                                <li><a href="">이용약관</a></li>
                            </ul>
                        </div>

                        <div class="myShopMenu-list">
                            <ul>
                                <li>
                                    <a href="">쿠폰내역<span class="">
                                        <span class="xans_myshop_main_coupon_cnt">0</span>
                                        장</span>
                                    </a>
                                </li>
                                <li class="point-history">
                                    <a href="">적립금 내역
                                        <span class="count">${myPageItem.user_point} 원</span>
                                    </a>
                                </li>
                                                
                                <li class="caty">
                                    <a href="">장바구니
                                        <span class=""><%= productCount != null ? productCount : 0 %> 개</span>
                                    </a>
                                </li>
                                                
                                <li>
                                    <a href="">게시글 관리</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>
                <!-- 오더 레이아웃 픽스 -->




            </div>
            <!-- 마이페이지 랩 -->
        </div>
        <!-- 컨텐츠 -->

    </div>
    <!-- 메인 컨테이너 -->

</body>
<%@include file="footer.jsp" %>
</html>