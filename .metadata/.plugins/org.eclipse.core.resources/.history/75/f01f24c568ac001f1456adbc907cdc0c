<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 추가함 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>오호라 팀 프로젝트</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/iscart.css">
<script src="../resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<%@include file="header.jsp" %>
<body>
<!-- 장바구니 영역 -->
 <div id="SP_order_wrap" class="sub_container basket_container">
    <div class="SP_layoutFix">
        <!-- 타이틀 -->
         <div class="SP_subSection">
            <h2 class="SP_subTitle">
                <span class="eng_font">장바구니</span>
            </h2>
         </div>
         <!-- 타이틀 -->
          <div style="display:none;" class="xans-element- xans-order xans-order-normnormal xans-record-">
            <div class="xans-element- xans-order xans-order-list xans-record-">
                <!-- 일반 기본배송 -->
            </div>
          </div>
          <!-- 장바구니 모듈 -->
           <div class="xans-element- xans-order xans-order-basketpackage  order_page">
            <!-- 혜택 정보 -->
             <div style="display:none" class="xans-element- xans-order xans-order-dcinfo ec-base-box typeMember  ">
                <div class="SP_orderInformation_wrap">
                    <div class="information">
                        <div class="SP_contTitle">혜택정보</div>
                        <div class="description">
                            <div class="member ">
                                <p>
                                    <strong>이시훈</strong>
                                     님은, [Friend] 회원이십니다.
                                </p>
                            </div>
                            <div class="SP_orderMileage_wrap">
                                <ul class>
                                    <li>
                                        <a href="/myshop/mileage/historyList.html">
                                            가용적립금 : 
                                            <strong>0원</strong>
                                        </a>
                                    </li>
                                    <li class="displaynone">
                                        <a href="/myshop/deposits/historyList.html">
                                            예치금 : 
                                            <strong></strong>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/myshop/coupon/coupon.html">
                                            쿠폰 : 
                                            <strong>0개</strong>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="SP_optChangeGuide_wrap">
                                <ul class>
                                    <li class="txtWarn txt11">상품의 옵션 및 수량 변경은 상품상세 또는 장바구니에서 가능합니다.</li>
                                    <li class="txtWarn txt11 displaynone">할인 적용 금액은 주문서작성의 결제예정금액에서 확인 가능합니다.</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
             </div>
             <!-- // 혜택 정보 -->
              <!-- 장바구니 정보 -->
               <div class="xans-element- xans-order xans-order-tabinfo SP_order_tab displaynone ">
                <ul class="menu">
                </ul>
                <p class="right ">장바구니에 담긴 상품은 14일 동안 보관됩니다.</p>
               </div>
               <!-- // 장바구니 정보 -->
                <!-- 장바구니 상품 있을때 -->
                 <div class="xans-element- xans-order xans-order-emptyitem toggleArea eToggle selected basket_item_wrapper ">
                    <!-- 선택상품 제어 버튼 -->
                     <div class="xans-element- xans-order xans-order-selectorder ">
                        <a href="javascript:void(0)" class="mini SMScart_allsel_btnTD selected" id="product_select_all" data-status="off">
                            <div class="box">
                            	<div id="allCheck" class="checked"></div> <!-- 전체 버튼 -->
                            </div>
                            <span class="count">
                                전체 상품 (
                                <span class="all-count"><%= productCount != null ? productCount : 0 %></span>
                                )
                            </span>
                        </a>
                     </div>
                     <div class="contents chk_custom_studio order_table">
                        <!-- 일반상품 (기본배송) -->
                         <div class="xans-element- xans-order xans-order-normnormal xans-record-">
                            <!-- 주문 리스트 -->
                             <div class="xans-element- xans-order xans-order-list">
		                        <c:if test="${not empty cartList}">
		                        <c:forEach var="item" items="${cartList}">
                             	<form id="delForm" action="<%= contextPath %>/cart/delbtn.do" method="post">
                                <div class="prdInfo xans-record-">
                                    <!-- 체크박스 -->
                                     <input type="checkbox" id="basket_chk_id_0" name="basket_product_normal_type_normal">
                                     <label for="basket_chk_id_0" class="label_for_check">
                                       <div data-pdt-id="${item.pdt_id}" data-pdt-count="${item.clist_pdt_count}" data-rate="${item.pdt_discount_rate}" data-price="${item.pdt_amount}" data-quantity="${item.clist_pdt_count}" data-clist-id="${item.clist_id}" class="otherCheck checked buy_product" id="otherCheck_${item.clist_id}" value="${item.clist_select}"></div> <!-- 개인 버튼 -->
                                       <input type="hidden" name="clist_id" value="${item.clist_id}"> <!-- 추가함 -->
                                     </label>
                                      &nbsp;
                                      <!-- // 체크박스 -->
                                       <!-- 설명 -->
                                        <div class="description">
                                            <!-- 상품 이미지 -->
                                             <p class="prdImg">
                                                <a href="/product/detail.html?product_no=2104&cate_no=44">
                                                    <img loading="lazy" src="${item.pdt_img_url}" alt width="250" height="250">
                                                </a>
                                             </p>
                                             <!-- // 상품 이미지 -->
                                              <!-- 상품 설명 -->
                                               <div class="prdDesc">
                                                <!-- 상품명 -->
                                                 <strong class="prdName" title="상품명">
                                                    <a href="/product/detail.html?product_no=2104&cate_no=44">${item.pdt_name}</a>
                                                 </strong>
                                                 <!-- // 상품명 -->
                                                  <!-- 정보영역 -->
                                                   <ul class="info">
                                                    <li class="displaynone">
                                                        배송 : 
                                                        <span class>
                                                            3,000
                                                            <span class="displaynone"></span>
                                                        </span>
                                                         [조건] / 기본배송 
                                                         <span class="displaynone">(해외배송가능)</span>
                                                    </li>
                                                    <li title="적립금" class="mileage displaynone">적립금-</li>
                                                    <li class="price">
                                                        <span class="discount" title="판매가">
                                                            <strong>
                                                                <c:if test="${item.pdt_discount_rate != null}">
										                            ${item.pdt_amount}
										                        </c:if>
                                                            </strong>
                                                            <span class="displaynone"></span>
                                                        </span>
                                                        <span class title="할인판매가">
                                                            <strong>
                                                                <c:choose>
																    <c:when test="${item.pdt_discount_rate != null}">
																        <c:set var="discountedPrice" value="${item.pdt_amount * (1 - (item.pdt_discount_rate / 100))}" />
																        <fmt:formatNumber value="${discountedPrice}" type="number" maxFractionDigits="0" />
																    </c:when>
																    <c:otherwise>
																        <fmt:formatNumber value="${item.pdt_amount}" type="number" maxFractionDigits="0" />
																    </c:otherwise>
																</c:choose>
                                                            </strong>
                                                            <span class></span>
                                                        </span>
                                                        <span class="dc_percent">
                                                        <c:if test="${item.pdt_discount_rate != null}">
								                            ${item.pdt_discount_rate}%
								                        </c:if>
                                                        </span>
                                                    </li>
                                                    <li class="quantity">
                                                        <a href="<%= contextPath %>/cart/pdtcountdown.do?clist_id=${item.clist_id}" id="minusBtn">
                                                            <img class="QuantityDown" alt="down" src="/SkinImg/img/minus.svg" width="25" height="25" onclick="Basket.outQuantityShortcut('quantity_id_0', 0);">
                                                        </a>
                                                        <input id="quantity_id_0" name="quantity_name_0" size="2" value="${item.clist_pdt_count}" type="text">
                                                        <a href="<%= contextPath %>/cart/pdtcountup.do?clist_id=${item.clist_id}&pdt_id=${item.pdt_id}&opt_id=${item.opt_id}" id="plusBtn">
                                                            <img class="QuantityUp plus_Btn" alt="up" src="/SkinImg/img/plus.svg" width="25" height="25" onclick="Basket.addQuantityShortcut('quantity_id_0', 0);">
                                                        </a>
                                                    </li>
                                                   </ul>
                                                   <!-- // 정보 영역 -->
                                                    <!-- 합계 -->
                                                     <div class="prdTotal">
                                                         합계 : 
                                                         <strong></strong>
                                                         <span class="displaynone"></span>
                                                     </div>
                                                     <!-- // 합계 -->
                                               </div>
                                               <!-- // 상품 설명 -->
                                        </div>
                                        <!-- // 설명 -->
                                         <!-- 버튼 영역 -->
                                          <a href="<%= contextPath %>/cart/delbtn.do?clist_id=${item.clist_id}" onclick="delBtn();" class="btnNormal SMScart_option_del_btnTD delBtn">삭제</a>
                                          <div class="btnArea typeFull displaynone">
                                            <span class="gLeft">
                                                <a href="#none" onclick="selBasketDel('basket_chk_id_0');" class="btnNormal SMScart_option_del_btnTD">삭제</a>
                                                <a href="#none" onclick="BasketNew.moveWish(0);" class="btnNormal SMScart_option_wish_btnTD">관심상품</a>
                                            </span>
                                            <span class="gRight">
                                                <a href="#none" onclick="Basket.orderBasketItem(0);" class="btnStrong SMScart_option_buy_btnTD">주문하기</a>
                                            </span>
                                          </div>
                                          <!-- // 버튼 영역 -->
                                </div>
                                <p></p> <!-- 추가함 -->
                                </form>
	                            </c:forEach>
	                            </c:if>
                                <!-- // 참고 -->
                             </div>
                             <!-- // 주문 리스트 -->
                              <!-- 주문 요약 -->
                               <div class="totalPrice toggleArea type2 eToggle displaynone">
                                <h3 class="txtTitle title">[기본배송]</h3>
                                <div class="contents">
                                     상품구매금액 
                                     <strong></strong>
                                     <span class="displaynone">()</span>
                                     <span class="displaynone"></span>
                                      + 배송비 
                                      <strong>3,000</strong>
                                      <span class="displaynone"></span>
                                      <span class="sale ">
                                         - 상품할인금액 
                                         <strong></strong>
                                      </span>
                                       =
                                       <br>
                                        합계 : 
                                        <strong class="total"></strong>
                                        <span class="displaynone"> </span>
                                </div>
                               </div>
                               <!-- // 주문 요약 -->
                         </div>
                     </div>
                 </div>
                 <!-- 총 주문금액 영역 -->
                  <div class="xans-element- xans-order xans-order-emptyitem total_order_wrapper " style="top: 157px;">
                    <div class="total_order_inner">
                        <div class="xans-element- xans-order xans-order-totalsummary  totalSummary ">
                            <!-- 총 상품 금액 -->
                             <div class="toggleArea type1 eToggle">
                                <div class="total title item">
                                    <h3>총 상품금액</h3>
                                    <p>
                                        <strong class="prdPriceAll">
                                         
                                        </strong>
                                        <span class="refer displaynone">
                                            <span class="total_product_price_display_back"></span>
                                        </span>
                                    </p>
                                </div>
                                <div class="more contents displaynone">
                                    <ul>
                                        <li>
                                            <strong>상품금액</strong>
                                            <span>
                                                <span class="total_product_price_display_front_mobile">0</span>
                                            </span>
                                        </li>
                                        <li>
                                            <strong>부가세</strong>
                                            <span>
                                                <span class="total_product_vat_price_front_mobile">0</span>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                             </div>
                             <!-- // 총 상품 금액 -->
                              <!-- 배송비 -->
                               <div class="toggleArea type1 eToggle">
                                <div class="item total title">
                                    <h3>총 배송비</h3>
                                    <p class="delivery_price_wrap">
                                        <strong class="prdDelvAll">
                                            3,000
                                        </strong>
                                        <span class="refer displaynone">
                                            <span class="total_delv_price_back"></span>
                                        </span>
                                    </p>
                                    <div class="shippingArea displaynone">
                                        (
                                        <span></span>
                                        <div class="shippingFee">
                                            <a href="#none" class="btnNormal" id>자세히</a>
                                            ) 
                                            <div class="ec-base-tooltip" style="display: none;">
                                                <h3>배송비할인</h3>
                                                <div class="content">
                                                    <h4></h4>
                                                    <table border="1" summary>
                                                        <caption>배송비 할인 이벤트 정보</caption>
                                                        <tbody>
                                                            <tr>
                                                                <th scope="row">혜택</th>
                                                                <td>
                                                                    <strong class="txtEm"></strong>
                                                                    <p></p>
                                                                </td>
                                                            </tr>
                                                            <tr class="displaynone">
                                                                <th scope="row">기간</th>
                                                                <td>
                                                                    <strong class="txtEm"></strong>
                                                                    <p></p>
                                                                </td>
                                                            </tr>
                                                            <tr class="displaynone">
                                                                <th scope="row">대상</th>
                                                                <td></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <a href="#none" class="btnClose">
                                                    <img src="//img.echosting.cafe24.com/skin/base/common/btn_close_tip.gif" alt="닫기">
                                                </a>
                                                <span class="edge"></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="total_info_txt delv">
                                        <span class="amount"></span>
                                        원 추가 구매시 
                                        <b>
                                            무료배송
                                            <b></b>
                                        </b>
                                    </div>
                                </div>
                                <div id="SMS_freeDelv" class="displaynone">
                                    <p class="ment">
                                        <b id="needPrice">0</b>
                                         추가 주문 시, 
                                         <span id="delvPrice" class="xans-element- xans-order xans-order-totalsummary ">
                                            <span class="total_delv_price_front">3,000</span>
                                         </span>
                                         <b>무료배송</b>
                                    </p>
                                </div>
                               </div>
                               <!-- // 배송비 -->
                                <!-- 상품 할인 금액 -->
                                 <div class="toggleArea type1 eToggle ">
                                    <div class="total title item">
                                        <h3>상품할인금액</h3>
                                        <!-- 총 상품 할인 금액 -->
                                         <p class="discountAll">
                                             - 
                                             <span class="discount">
                                                <strong class="prdDiscountAll">
                                                    
                                                </strong>
                                             </span>
                                             <span class="refer displaynone"></span>
                                         </p>
                                    </div>
                                    <div class="more contents displaynone ">
                                        <ul>
                                            <li class>
                                                <strong>기간할인</strong>
                                                <span id="mBenefitPeriodSale"></span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>회원할인</strong>
                                                <span id="mBenefitMemberSale">0</span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>재구매할인</strong>
                                                <span id="mBenefitRebuySale">0</span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>대량구매할인</strong>
                                                <span id="mBenefitBulkSale">0</span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>바로가기(링콘)할인</strong>
                                                <span id="mBenefitLivelinkonSale">0</span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>어바웃pbp할인</strong>
                                                <span id></span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>신규상품할인</strong>
                                                <span id="mBenefitNewproductSale">0</span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>결제수단할인</strong>
                                                <span id></span>
                                            </li>
                                            <li class="displaynone">
                                                <strong>회원등급할인</strong>
                                                <span id="mBenefitMembergroupSale">0</span>
                                            </li>
                                        </ul>
                                    </div>
                                 </div>
                                 <!-- // 상품할인금액 -->
                                  <!-- 결제예정금액 -->
                                   <div class="toggleArea type1 eToggle order final">
                                    <div class="item total title">
                                        <h3>총 결제예정금액</h3>
                                        <p class="price_final">
                                            <strong class="prdFinalAll">
                                                
                                            </strong>
                                            <span class="refer displaynone"></span>
                                        </p>
                                        <!-- 예상 적립금 -->
                                         <div class="mileage total_info_txt">
                                            <!-- 회원 -->
                                             <div class="xans-element- xans-layout xans-layout-statelogon member ">
                                                <div class="xans-element- xans-order xans-order-dcinfo displaynone ">
                                                    <div class="group_name">Friend</div>
                                                </div>
                                                <div class="mileage_txt">
                                                    구매시 0원 
                                                    <b>적립예정</b>
                                                </div>
                                             </div>
                                             <!-- 비회원 -->
                                         </div>
                                         <!-- // 예상 적립금 -->
                                    </div>
                                   </div>
                                   <!-- // 결제예정금액 -->
                        </div>
                        <div class="xans-element- xans-order xans-order-totaloversea displaynone totalSummary ">
                            <div class="type1 eToggle">
                                <div class="total title">
                                    <h3>총 상품금액</h3>
                                    <p>
                                        <strong>
                                            <span class="total_product_price_display_front">14,800</span>
                                        </strong>
                                        <span class="refer displaynone">
                                            <span class="total_product_price_display_back"></span>
                                        </span>
                                    </p>
                                </div>
                                <div class="more contents displaynone">
                                    <ul>
                                        <li>
                                            <strong>상품금액</strong>
                                            <span>
                                                <span class="total_product_price_display_front_mobile">0</span>
                                            </span>
                                        </li>
                                        <li>
                                            <strong>부가세</strong>
                                            <span>
                                                <span class="total_product_vat_price_front_mobile">0</span>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="toggleArea type1 eToggle ">
                                <div class="total title item">
                                    <h3>총 할인금액</h3>
                                    <p>
                                        <strong>2,220</strong>
                                        <span class="refer displaynone"></span>
                                    </p>
                                </div>
                                <div class="more contents displaynone ">
                                    <ul>
                                        <li class>
                                            <strong>기간할인</strong>
                                            <span id="mBenefitPeriodSale">2,220</span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>회원할인</strong>
                                            <span id="mBenefitMemberSale">0</span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>재구매할인</strong>
                                            <span id="mBenefitRebuySale">0</span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>대량구매할인</strong>
                                            <span id="mBenefitBulkSale">0</span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>바로가기(링콘)할인</strong>
                                            <span id="mBenefitLivelinkonSale">0</span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>어바웃pbp할인</strong>
                                            <span id></span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>신규상품할인</strong>
                                            <span id="mBenefitNewproductSale">0</span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>결제수단할인</strong>
                                            <span id></span>
                                        </li>
                                        <li class="displaynone">
                                            <strong>회원등급할인</strong>
                                            <span id="mBenefitMembergroupSale">0</span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="total title">
                                <h3>총 합계</h3>
                                <p>
                                    <strong>15,580</strong>
                                    <span class="refer displaynone"></span>
                                </p>
                            </div>
                        </div>
                        <div class="xans-element- xans-order xans-order-totalorder SP_tableBtn_wrap">
                            <div class="SP_tableBtnAlign_right">
                                <div class="btn buy_btn">
                                    <a href="#none" onclick="handleBuyClick(event)" id="buyBtn" link-order="/order/orderform.html?basket_type=all_buy" link-login="/member/login.html" class="SP_cm_btn">구매하기</a>
                                </div>
                                <div class="displaynone">
                                    <a href="/" class="SP_cm_btn">계속 쇼핑하기</a>
                                    <a href="#none" onclick="Basket.orderSelectBasket(this)" link-order="/order/orderform.html?basket_type=all_buy" link-login="/member/login.html" class="SP_cm_btn ">선택상품 주문</a>
                                    <a href="#none" onclick="Basket.orderAll(this)" link-order="/order/orderform.html?basket_type=all_buy" link-login="/member/login.html" class="SP_cm_btn   ">전체 상품주문</a>
                                    <div id="appPaymentButtonBox" style="display:block; max-width:365px; margin:10px auto 0; text-align:center;"></div>
                                </div>
                                <div id="NaverChk_Button" class="naver_Wrap displaynone"></div>
                            </div>
                        </div>
                    </div>
                  </div>
                  <!-- 총 주문금액 영역 -->
           </div>
           <!-- // 장바구니 모듈 -->
            <div class="xans-element- xans-myshop xans-myshop-wishlist ec-base-table typeList displaynone xans-record-">
                <h3 class="SP_contTitle">관심상품</h3>
                <table border="1" summary class="SP_tableSt01_isThumNail">
                    <caption>관심상품 목록</caption>
                    <colgroup>
                        <col style="width:92px">
                        <col style="width:auto">
                        <col style="width:105px">
                        <col style="width:100px">
                        <col style="width:100px">
                        <col style="width:85px">
                        <col style="width:105px">
                        <col style="width:110px">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">이미지</th>
                            <th scope="col">상품정보</th>
                            <th scope="col">판매가</th>
                            <th scope="col">배송구분</th>
                            <th scope="col">배송비</th>
                            <th scope="col">합계</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                </table>
                <p class="SP_message ">관심상품 내역이 없습니다.</p>
            </div>
    </div>
    <div class="common_list_container reco_new_container">
        <div class="text_area">

        </div>
        
 </div>
 <!-- // 장바구니 영역 -->
  <div id="spm_page_type" style="display:none">sq_basket_page</div>
  <div id="spm_banner_main"></div>
  <div id="spm_cafe_basket_wrap" style="display:none" class="xans-element- xans-order xans-order-totalsummary ">
    <input type="hidden" id="sf_basket_total_price" value="14,800">
     &nbsp; 
  </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script>
var swiper = new Swiper(".swiper-container", {
    slidesPerView: 3,
    spaceBetween: 30,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    scrollbar: {
        el: ".swiper-scrollbar",
        hide: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

swiper.update();
</script>

<script>
// 수량 감소, 증가
$("#minusBtn").on("click", function() {
    let value = parseInt($("#quantity_id_0").val()) || 0; // 값을 정수로 변환합니다.
    if (value > 1) { // 1 이상일 때만 감소하도록 합니다.
        $("#quantity_id_0").val(value - 1);
    } else {
        $("#quantity_id_0").val(1); // 0 이하로 내려가지 않도록 1로 고정합니다.
    }
});

$("#plusBtn").on("click", function() {
    let value = parseInt($("#quantity_id_0").val()) || 0; // 현재 값을 정수로 변환
    $("#quantity_id_0").val(value + 1); // 1을 더한 후 다시 설정
});
</script>

<script>
// 전체 버튼 클릭 시
$("#allCheck").on("click", function() {
    const $this = $(this);

    // 전체 버튼 클래스 상태 확인
    if ($this.hasClass("checked")) {
        $this.removeClass("checked"); // 클래스 제거
        $this.css("background-color", "#eee"); // 색상 변경
        $(".otherCheck").removeClass("checked").css("background-color", "#eee"); // 상품 버튼들 색상 변경
    } else {
        $this.addClass("checked"); // 클래스 추가
        $this.css("background-color", "black"); // 색상 변경
        $(".otherCheck").addClass("checked").css("background-color", "black"); // 상품 버튼들 색상 변경
    }
    calculateTotal();
});

// 상품 체크 버튼 클릭 시
$(".otherCheck").on("click", function() {
    const $this = $(this);

    // 클래스를 확인하여 background-color를 변경
    if ($this.hasClass("checked")) {
        $this.removeClass("checked"); // 클래스 제거
        $this.css("background-color", "#eee"); // 색상 변경
    } else {
        $this.addClass("checked"); // 클래스 추가
        $this.css("background-color", "black"); // 색상 변경
    }

    // 전체 버튼 상태 업데이트
    let allSelected = true;
    $(".otherCheck").each(function() {
        if (!$(this).hasClass("checked")) {
            allSelected = false;
        }
    });

    // 전체 버튼 상태 변경
    if (allSelected) {
        $("#allCheck").addClass("checked").css("background-color", "black");
    } else {
        $("#allCheck").removeClass("checked").css("background-color", "#eee");
    }
    calculateTotal();
});
</script>

<script>
$(document).ready(function() {
    calculateTotal(); // 페이지 로드 시 총합 계산
});

//총 합계 계산 함수
function calculateTotal() {
    let totalPrice = 0;
    let totalQuantity = 0;
    let totalDiscount = 0;

    // 체크된 상품들만 선택하여 가격과 수량 더하기
    $(".otherCheck.checked").each(function() {
        const price = parseFloat($(this).data("price")); // data-price에서 가격 추출
        const quantity = parseInt($(this).data("quantity")); // data-quantity에서 수량 추출
        const discountRate = parseFloat($(this).data("rate")) / 100; // data-rate에서 할인율 추출

        if (!isNaN(price) && !isNaN(quantity)) {
            totalPrice += price * quantity; // 가격 * 수량 더하기
            totalQuantity += quantity; // 수량 더하기
            
         	// 할인 금액 계산 (상품 가격 * 할인율 * 수량)
            const discountAmount = price * discountRate * quantity;
            totalDiscount += discountAmount; // 할인 금액 더하기
        }
    });

    // 총 가격을 화면에 출력
    console.log("총 가격: " + totalPrice + "원");
    console.log("총 수량: " + totalQuantity + "개");

    // 선택된 상품들의 총합을 prdPriceAll에 출력
    $(".prdPriceAll").text(totalPrice.toLocaleString());
    
 	// 배송비 계산
    let deliveryFee = (totalPrice >= 50000) ? 0 : 3000; // 총합이 50,000원 이상이면 0, 아니면 3000원
    $(".prdDelvAll").text(deliveryFee.toLocaleString()); // 배송비 출력
    
 	// 추가 구매 금액 계산
    const additionalAmount = 50000 - totalPrice; // 50,000원에서 현재 총합을 뺀 금액
    if (additionalAmount > 0) {
        // 총합이 50,000원 미만이면 추가 금액 표시
        $(".amount").text(additionalAmount.toLocaleString()); // 추가 금액 출력
    } else {
        $(".amount").text(""); // 50,000원 이상이면 빈 문자열 출력 (안 보이게)
    }
    
    $(".prdDiscountAll").text(totalDiscount.toLocaleString());
    
 	// 할인율 적용 후 총합 계산 (배송비 포함)
    const finalTotalPrice = totalPrice - totalDiscount + deliveryFee; // 할인 금액을 빼고 배송비를 더해서 최종 가격 계산
    $(".prdFinalAll").text(finalTotalPrice.toLocaleString()); // 최종 가격 출력
}
</script>

<!-- 2024-11-07 추가함 -->
<!-- <script>
//구매 버튼 클릭 이벤트 핸들러
$("#buyBtn").on("click", function(event) {
    event.preventDefault();  // 기본 링크 동작 막기 (페이지 리로드 방지)

    var url = "/projectOhora/product/orderpage.do?";  // 기본 URL 설정
    var pdtIds = [];
    var pdtCounts = [];

    // 모든 .buy_product div 요소를 찾고, 그 안에 있는 데이터 속성 값을 가져옵니다
    const items = document.querySelectorAll('.buy_product');  // 모든 buy_product 클래스를 가진 div들 찾기

    items.forEach(function(item) {
        var pdtId = item.getAttribute('data-pdt-id');  // data-pdt-id 값
        var pdtCount = item.getAttribute('data-pdt-count');  // data-pdt-count 값

        // 값이 있을 경우 배열에 추가
        if (pdtId && pdtCount) {
            pdtIds.push("pdtId=" + encodeURIComponent(pdtId));
            pdtCounts.push("pdtCount=" + encodeURIComponent(pdtCount));
        }
    });

    // URL에 파라미터 추가
    url += pdtIds.join("&") + "&" + pdtCounts.join("&");

    // URL을 확인하기 위해 alert로 출력
    alert(url);

    // 페이지 리다이렉션
    // location.href = url;
});
</script> -->

<script>
    // 구매 버튼 클릭 이벤트 핸들러
    $("#buyBtn").on("click", function(event) {
        event.preventDefault();  // 기본 링크 동작 막기 (페이지 리로드 방지)

        var url = "/projectOhora/product/orderpage.do?";  // 기본 URL 설정
        var pdtIds = [];
        var pdtCounts = [];

        // 모든 .buy_product div 요소를 찾고, 그 안에 있는 데이터 속성 값을 가져옵니다
        const items = document.querySelectorAll('.buy_product.checked');  // checked 클래스를 가진 buy_product div들 찾기

        items.forEach(function(item) {
            var pdtId = item.getAttribute('data-pdt-id');  // data-pdt-id 값
            var pdtCount = item.getAttribute('data-pdt-count');  // data-pdt-count 값

            // 값이 있을 경우 배열에 추가
            if (pdtId && pdtCount) {
                pdtIds.push("pdtId=" + encodeURIComponent(pdtId));
                pdtCounts.push("pdtCount=" + encodeURIComponent(pdtCount));
            }
        });

        // URL에 파라미터 추가
        if (pdtIds.length > 0 && pdtCounts.length > 0) {
            url += pdtIds.join("&") + "&" + pdtCounts.join("&");
        } else {
            // 만약 체크된 항목이 없으면 경고 메시지 출력
            alert("구매할 제품을 선택해 주세요.");
            return;  // 아무런 데이터가 없다면 함수 종료
        }

        // URL을 확인하기 위해 alert로 출력
        // alert(url);

        // 페이지 리다이렉션
        location.href = url;
    });
</script>

<!-- <script>
// 전체 버튼, 상품 버튼 체크 색상 변경
let allChecked = false;

// 전체 체크 버튼 색 변경
$("#allCheck").on("click", function() {
    allChecked = !allChecked; // 전체 체크 상태 반전

    // 전체와 상품 버튼 모두 같은 색으로 변경
    if (allChecked) {
        $("#allCheck, .otherCheck").css("background-color", "black");
    } else {
        $("#allCheck, .otherCheck").css("background-color", "#eee");
    }
});

// 상품 체크 버튼
$(".otherCheck").on("click", function() {
    const isCurrentlyChecked = $(this).css("background-color") === "rgb(0, 0, 0)"; // 현재 색상이 검정인지 확인

    // 상품 버튼 색상 변경
    if (isCurrentlyChecked) {
        $(this).css("background-color", "#eee");
    } else {
        $(this).css("background-color", "black");
    }

    // 상품 버튼 중 하나라도 해제되면 전체 버튼도 해제
    let allSelected = true;
    $(".otherCheck").each(function() {
        if ($(this).css("background-color") !== "rgb(0, 0, 0)") {
            allSelected = false;
        }
    });

    // 전체 버튼 상태 업데이트
    if (allSelected) {
        allChecked = true;
        $("#allCheck").css("background-color", "black");
    } else {
        allChecked = false;
        $("#allCheck").css("background-color", "#eee");
    }
});
</script> -->

<%-- <script>
// 상품 체크 버튼
$(".otherCheck").on("click", function() {
    // 클릭한 상품 버튼의 clist_select 값 가져오기
    let clistSelect = $(this).attr("value");

    // 상품 버튼 색상 변경
    if (clistSelect === "Y") {
        $(this).css("background-color", "#eee");  // Y이면 black
        $(this).attr("value", "N");  // Y를 클릭하면 N으로 전환
    } else {
        $(this).css("background-color", "black");  // N이면 #eee
        $(this).attr("value", "Y");  // N을 클릭하면 Y로 전환
    }

    // 전체 상품 버튼의 value 값을 확인하여 전체 버튼 색상 결정
    let allChecked = true;
    $(".otherCheck").each(function() {
        if ($(this).attr("value") === "N") {
            allChecked = false;
            return false; // 하나라도 N이면 반복문 중지
        }
    });

    // 전체 버튼 색상 변경
    if (allChecked) {
        $("#allCheck").css("background-color", "black");  // 모두 Y면 검정색
    } else {
        $("#allCheck").css("background-color", "#eee");  // 하나라도 N이면 회색
    }
});

$(".otherCheck").on("click", function() {
    const clistId = $(this).data("clist-id");  // data-clist-id 속성에서 값 추출
    const isCurrentlyChecked = $(this).css("background-color") === "rgb(0, 0, 0)"; // 현재 색상이 검정인지 확인
    
    // AJAX 요청
    $.ajax({
        url: "<%= contextPath %>/cart/checkcart.ajax", // 서버에서 처리할 URL
        method: "POST",
        dataType: "json",
        data: {
            clistId: clistId,  // data-clist-id 값을 서버로 전달
            isChecked: !isCurrentlyChecked  // 현재 상태와 반대 값을 서버로 전달
        },
        success: function(response) {
            // 서버 응답 처리 (성공 시)
            console.log('상품 상태 업데이트 성공');
            // 서버 응답에 따라 UI 업데이트
        },
        error: function(xhr, status, error) {
            // 서버 응답 실패 처리
            console.error('상품 상태 업데이트 실패:', error);
        }
    });
});
</script> --%>

<!-- 삭제 버튼 -->
<!-- 
<script>
	$(document).on("click", ".delBtn", function(){
		alert("삭제하겠습니다.");
		$(this).closest("form").submit();  // 클릭된 버튼의 부모 폼을 제출
	});
</script>
 -->
<%@include file="footer.jsp" %>
</html>
