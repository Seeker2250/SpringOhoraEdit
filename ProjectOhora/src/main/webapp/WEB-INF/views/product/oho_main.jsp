<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kr.ohora.www.domain.product.ProductDTO" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%
    ArrayList<ProductDTO> productList = (ArrayList<ProductDTO>) request.getAttribute("productList");
    String contextPath = request.getContextPath();
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
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/oho_main.css">
 <!-- Link Swiper's CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
<script type="text/javascript">
    window.hasProductCountSession = ${not empty sessionScope.userId};
</script>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" /> <!-- 스프링 추가 -->
<%-- <%@include file="header.jsp" %> --%>
</head>
<body>

   
    <div class="main_container">
        <!-- 메인 배너 (메인 이미지 - 스와이프) 영역 -->
        <div class="mainSwipeBanner">

            <div class="mainBannerWrapper swiper mySwiper">
                   <!-- 화면에 띄워질 경우 : cloneBanner-active 클래스 추가 -->

                <div class="swiper-wrapper">
                   <div class="cloneBanner cloneBanner-active swiper-slide">
                       <a href="">
                           <img src="https://ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/cff66bbfd6b49ef154d19564381c73d0.jpg" alt="월간 베스트 오브 베스트">
                           <span class="shopNow">shop now</span>
                       </a>
                   </div>

                   <div class="cloneBanner cloneBanner-active swiper-slide">
                       <a href="">
                           <img src="https://ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/d48eebf0f5f2c9dd1c5c69708d37e872.jpg" alt="컬렉션 상시 배너">
                           <span class="shopNow" class="swiper-slide">shop now</span>
                       </a>
                   </div>

                   <div class="cloneBanner swiper-slide">
                       <a href="">
                           <img src="https://ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/4160fe76d5fd935dddb5ae90f7607d03.webp" alt="첫구매 사은품">
                           <span class="shopNow" class="swiper-slide">shop now</span>
                       </a>
                   </div>

                   <div class="cloneBanner swiper-slide">
                       <a href="">
                           <img src="https://ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/472e9fbd0e36e3d5757bc47e500fb700.webp" alt="베스트 리뷰 보상">
                           <span class="shopNow" class="swiper-slide">shop now</span>
                       </a>
                   </div>
                </div>

                <div class="swiper-pagination"></div>
            </div>
        </div>   

       <!-- 메인 배너 이미지 , 페이지네이션 끝 -->

       <div class="mainSection-new">
           <h3>
               <strong>이 달의 신상품</strong>
               <a href="" class="main-moreBtn">+ 더보기</a> 
               <!-- 더보기 누르면 list에 카테고리값 가지고 감 -->
           </h3>

           <div class="cate_tab">
               <span class="on" data-cate="121">전체</span>
               <span data-cate="123"></span>
               <span data-cate="124"></span>
           </div>

           <div class="common_list_box">
               <div class="swiper-container swiper mySwiper2">
			    <ul class="items-swiper-wrapper2 swiper-wrapper">
			        <c:forEach var="product" items="${products}" varStatus="status">
			            <c:if test="${status.index >= 0 && status.index < 7}">
			                <li id="item${product.pdtId}" class="item-swiper-slide swiper-slide">
			                    <div class="container-complete" data-prd-num="${product.pdtId}">
			                        <dl>
			                            <a href="prdDetailView.htm?productId=${product.pdtId}" class="viewlink"></a>
			                            <div class="base-img">
			                                <div class="thumb">
			                                    <img loading="lazy" alt="" class="thumb_img" width="800" height="800" src="/resources/images/product_image/${product.pdtImgUrl}">
			                                </div>
			                                <span class="soldout-img" style="display: none">
			                                    <a href="prdDetailView.htm?productId=${product.pdtId}">
			                                        <span>coming<br>soon</span>
			                                    </a>
			                                </span>
			                            </div>
			                            <div class="base-mask">
			                                <dd class="name-container">
			                                    <p class="name"><span>${product.pdtName}</span></p>
			                                </dd>
			                                <dd class="price-container">
			                                    <p class="normal-price">${product.pdtAmount}</p>
			                                    <p class="sale-price">${product.pdtDiscountAmount}</p>
			                                    <p class="discount">${product.pdtDiscountRate}%</p>
			                                </dd>
			                                <dd class="prdRegiDate">등록일</dd>
			                                <div class="prdInfoBot">
			                                    <div class="rvCount">
			                                        <div class="rvWrap">
			                                            <p class="rv_count_wrap">
			                                                <span class="rv_count_value">${product.pdtReviewCount}</span>
			                                            </p>
			                                        </div>
			                                    </div>
			                                </div>
			                                <sec:authorize access="isAnonymous()">
			                                			<div class="into_cart" data-pdt_id="${product.pdtId}">
			                                            	<img class="cart_icon" src="" alt="카트 아이콘">
			                                        	</div>
										            </sec:authorize>
										            <sec:authorize access="isAuthenticated()">
														<div class="into_cart" data-pdt_id="${product.pdtId}" onclick="userCartAdd(this);">
			                                            	<img class="cart_icon" src="" alt="카트 아이콘">
			                                        	</div>
										    </sec:authorize>
			                                <div class="only_info_dispNone">
			                                    <span style="font-size:12px;color:#555555;">#네일 #젤스트립 #핑크 #프렌치 #자석 #글리터 #골드</span>
			                                </div>
			                            </div>
			                        </dl>
			                    </div>
			                </li>
			            </c:if>
			        </c:forEach>
			    </ul>
			
			    <div class="swiper-scrollbar"></div>
			</div>

               <!-- 스와이퍼 컨테이너 -->
               <div class="swiper-button-next"></div>
               <div class="swiper-button-prev"></div>

            </div>


       </div>
       
       
           <!-- productList 데이터를 JSON 형태로 JavaScript로 전달 -->
<!-- <script type="text/javascript">
const monthlyProductList = [
    <c:forEach var="product" items="${products}" varStatus="status">
        <c:if test="${status.index >= 1 && status.index < 8}">
            {
                id: '${product.pdtId}',
                name: '<c:out value="${product.pdtName}" />',
                normalPrice: ${product.pdtAmount},
                salePrice: ${product.pdtDiscountAmount},
                discount: ${product.pdtDiscountRate},
                imgUrl: '<c:out value="${product.pdtImgUrl}" />',
                imgUrl2: '<c:out value="${product.pdtImgUrl2}" />',
                reviewCount: ${product.pdtReviewCount}
            }<c:if test="${status.index < 7}">,</c:if>
        </c:if>
    </c:forEach>
];
console.log("Monthly Product List:", monthlyProductList);

function createMonthlyProductItem(product) {
    const cartButton = window.hasProductCountSession 
	        ? `<div class="into_cart" data-pdtid="\${product.id}" onclick="addCart(this);">
	             <img class="cart_icon" src="https://img.echosting.cafe24.com/design/skin/admin/ko_KR/btn_list_cart.gif" alt="카트 아이콘">
	           </div>`
	        : `<div class="into_cart" data-pdtid="\${product.id}">
	             <img class="cart_icon" src="https://img.echosting.cafe24.com/design/skin/admin/ko_KR/btn_list_cart.gif" alt="카트 아이콘">
	           </div>`;
	
	    return `
	        <li id="item\${product.id}" class="item-swiper-slide swiper-slide">
	            <div class="container-complete" data-prd-num="\${product.id}">
	                <dl>
	                    <a href="prdDetailView.htm?productId=\${product.id}" class="viewlink"></a>
	                    <div class="base-img">
	                        <div class="thumb">
	                            <img loading="lazy" alt="" class="thumb_img" width="800" height="800" src="\${product.imgUrl}">
	                        </div>
	                        <span class="soldout-img" style="display: none">
	                            <a href="prdDetailView.htm?productId=\${product.id}">
	                                <span>coming<br>soon</span>
	                            </a>
	                        </span>
	                    </div>
	                    <div class="base-mask">
	                        <dd class="name-container">
	                            <p class="name"><span>\${product.name}</span></p>
	                        </dd>
	                        <dd class="price-container">
	                            <p class="normal-price">\${product.normalPrice.toLocaleString()}</p>
	                            <p class="sale-price">\${product.salePrice.toLocaleString()}</p>
	                            <p class="discount">\${product.discount}%</p>
	                        </dd>
	                        <dd class="prdRegiDate">등록일</dd>
	                        <div class="prdInfoBot">
	                            <div class="rvCount">
	                                <div class="rvWrap">
	                                    <p class="rv_count_wrap">
	                                        <span class="rv_count_value">\${product.reviewCount}</span>
	                                    </p>
	                                </div>
	                            </div>
	                        </div>
	                        \${cartButton}
	                        <div class="only_info_dispNone">
	                            <span style="font-size:12px;color:#555555;">#네일 #젤스트립 #핑크 #프렌치 #자석 #글리터 #골드</span>
	                        </div>
	                    </div>
	                </dl>
	            </div>
	        </li>
	    `;
	}

    function renderMonthlyProductList(productList) {
        const productContainer = document.querySelector(".items-swiper-wrapper2");
        if (!productContainer) {
            console.error("Error: .items-swiper-wrapper2 요소를 찾을 수 없습니다.");
            return;
        }
        productList.forEach(product => {
            productContainer.innerHTML += createMonthlyProductItem(product);
        });
    }

    document.addEventListener("DOMContentLoaded", function() {
        renderMonthlyProductList(monthlyProductList);
    });
</script> -->
       
       
       
       
       <!-- 이 달의 신상품 끝 -->


       <div class="mainSection-best">
           <h3>
               <strong>주간 베스트</strong>
               <a href="" class="main-moreBtn">+ 더보기</a>
           </h3>

           <div class="cate_tab">
               <span class="on" data-cate="0">전체</span>
               <span data-cate="1">네일</span>
               <span data-cate="2">페디</span>
               <span data-cate="3">케어&툴</span>
           </div>

           <div class="common_list_box2">
               <div class="swiper-container swiper mySwiper3">
			    <ul class="items-swiper-wrapper3 swiper-wrapper">
			        <c:forEach var="product" items="${weeklyBestProducts}" varStatus="status">
			        	<c:if test="${status.index >= 0 && status.index < 7}">
			            <li id="item${product.pdtId}" class="item-swiper-slide swiper-slide">
			                <div class="container-complete" data-prd-num="${product.pdtId}">
			                    <dl>
			                        <a href="prdDetailView.htm?productId=${product.pdtId}" class="viewlink"></a>
			                        <div class="base-img">
			                            <div class="thumb">
			                                <img loading="lazy" alt="" class="thumb_img" width="800" height="800" src="/resources/images/product_image/${product.pdtImgUrl}">
			                            </div>
			                            <span class="soldout-img" style="display: none">
			                                <a href="prdDetailView.htm?productId=${product.pdtId}">
			                                    <span>coming<br>soon</span>
			                                </a>
			                            </span>
			                        </div>
			                        <div class="base-mask">
			                            <dd class="name-container">
			                                <p class="name"><span>${product.pdtName}</span></p>
			                            </dd>
			                            <dd class="price-container">
			                                <p class="normal-price">${product.pdtAmount}</p>
			                                <p class="sale-price">${product.pdtDiscountAmount}</p>
			                                <p class="discount">${product.pdtDiscountRate}%</p>
			                            </dd>
			                            <div class="prdInfoBot">
			                                <div class="rvCount">
			                                    <div class="rvWrap">
			                                        <p class="rv_count_wrap">
			                                            <span class="rv_count_value">${product.pdtReviewCount}</span>
			                                        </p>
			                                    </div>
			                                </div>
			                                <div class="into_cart" data-pdtid="${product.pdtId}">
			                                    <img class="cart_icon" src="https://img.echosting.cafe24.com/design/skin/admin/ko_KR/btn_list_cart.gif" alt="카트 아이콘">
			                                </div>
			                                <div class="only_info_dispNone">
			                                    <span style="font-size:12px;color:#555555;">#네일 #젤스트립 #핑크 #프렌치 #자석 #글리터 #골드</span>
			                                </div>
			                            </div>
			                        </div>
			                    </dl>
			                </div>
			            </li>
			          </c:if>
			        </c:forEach>
			    </ul>
			    <div class="swiper-scrollbar"></div>
			</div>


                <div class="swiper-button-next2"></div>
                <div class="swiper-button-prev2"></div>
               </div>
               <!-- 스와이퍼 컨테이너 -->
   

           </div>


       </div>
       
     <script>
     $(document).ready(function () {
    	    // 카테고리 탭 클릭 이벤트
    	    $(".cate_tab span").on("click", function () {
    	        const categoryNumber = $(this).data("cate"); // 카테고리 번호
    	        $(".cate_tab span").removeClass("on");
    	        $(this).addClass("on"); // 선택된 탭 강조

    	        // AJAX 요청으로 데이터 갱신
    	        $.ajax({
    	            url: "/fetchProducts.ajax",
    	            type: "GET",
    	            data: { categoryNumber: categoryNumber },
    	            dataType: "json",
    	            success: function (data) {
    	                console.log("Fetched Data:", data); // 디버깅
    	                updateProductList(data); // 상품 리스트 갱신
    	            },
    	            error: function (xhr, status, error) {
    	                console.error("Error fetching products:", error);
    	            },
    	        });
    	    });

    	    // 상품 리스트 갱신
    	    function updateProductList(products) {
			    const $productContainer = $(".items-swiper-wrapper3");
			    if ($productContainer.length === 0) {
			        console.error("Error: .items-swiper-wrapper3 요소를 찾을 수 없습니다.");
			        return;
			    }
			
			    $productContainer.empty(); // 기존 콘텐츠 제거
			
			    // 첫 8개 데이터만 처리
			    const limitedProducts = products.slice(0, 8); // 최대 8개 가져오기
			
			    limitedProducts.forEach((product) => {
			        const productItem = `
			            <li id="item\${product.pdtId}" class="item-swiper-slide swiper-slide">
			                <div class="container-complete" data-prd-num="\${product.pdtId}">
			                    <dl>
			                        <a href="prdDetailView.htm?productId=\${product.pdtId}" class="viewlink"></a>
			                        <div class="base-img">
			                            <div class="thumb">
			                                <img loading="lazy" alt="" class="thumb_img" width="800" height="800" src="/resources/images/product_image/\${product.pdtImgUrl}">
			                            </div>
			                            <span class="soldout-img" style="display: none">
			                                <a href="prdDetailView.htm?productId=\${product.pdtId}">
			                                    <span>coming<br>soon</span>
			                                </a>
			                            </span>
			                        </div>
			                        <div class="base-mask">
			                            <dd class="name-container">
			                                <p class="name"><span>\${product.pdtName}</span></p>
			                            </dd>
			                            <dd class="price-container">
			                                <p class="normal-price">\${product.pdtAmount}</p>
			                                <p class="sale-price">\${product.pdtDiscountAmount}</p>
			                                <p class="discount">\${product.pdtDiscountRate}%</p>
			                            </dd>
			                            <div class="prdInfoBot">
			                                <div class="rvCount">
			                                    <div class="rvWrap">
			                                        <p class="rv_count_wrap">
			                                            <span class="rv_count_value">\${product.pdtReviewCount}</span>
			                                        </p>
			                                    </div>
			                                </div>
			                                <div class="into_cart" data-pdtid="\${product.pdtId}">
			                                    <img class="cart_icon" src="https://img.echosting.cafe24.com/design/skin/admin/ko_KR/btn_list_cart.gif" alt="카트 아이콘">
			                                </div>
			                                <div class="only_info_dispNone">
			                                    <span style="font-size:12px;color:#555555;">#네일 #젤스트립 #핑크 #프렌치 #자석 #글리터 #골드</span>
			                                </div>
			                            </div>
			                        </div>
			                    </dl>
			                </div>
			            </li>
			        `;
			        $productContainer.append(productItem);
			    });
			}
    	});

     </script>
     
     
       
<!-- <script type="text/javascript">
    $(document).ready(function () {
        // 초기 로드: 전체 카테고리(0) 데이터 가져오기
        fetchProducts(0);

        // 카테고리 탭 클릭 이벤트
        $(".cate_tab span").on("click", function () {
            const categoryNumber = $(this).data("cate"); // 클릭한 카테고리 번호
            $(".cate_tab span").removeClass("on");
            $(this).addClass("on"); // 선택된 탭에 강조 표시
            fetchProducts(categoryNumber); // Ajax로 데이터 가져오기
        });

        // Ajax로 데이터 가져오기
        function fetchProducts(categoryNumber) {
            $.ajax({
                url: "/fetchProducts.ajax", // 서버 URL
                type: "GET",
                data: { categoryNumber: categoryNumber }, // 파라미터 전달
                dataType: "json", // 서버에서 반환할 데이터 형식
                headers: {
                    Accept: "application/json", // 서버에 JSON 요청
                },
                success: function (data) {
                    console.log("Fetched Data:", data); // 디버깅: 받은 데이터 출력
                    const sortedData = sortAndFilter(data, 7); // 판매량순 정렬 후 상위 7개 선택
                    renderProducts(sortedData);
                },
                error: function (xhr, status, error) {
                    console.error("Error fetching products:", error); // 에러 로그
                },
            });
        }

        // 데이터 정렬 및 필터링 (판매량순)
        function sortAndFilter(products, limit) {
            return products
                .sort((a, b) => b.pdtSalesCount - a.pdtSalesCount) // 판매량순 정렬
                .slice(0, limit); // 상위 limit개만 반환
        }

        // 상품 리스트 렌더링
        function renderProducts(products) {
            const $productContainer = $(".items-swiper-wrapper3");
            if ($productContainer.length === 0) {
                console.error("Error: .items-swiper-wrapper3 요소를 찾을 수 없습니다.");
                return;
            }
            $productContainer.empty(); // 기존 콘텐츠 제거
            products.forEach((product) => {
                const cartButton = `
                    <div class="into_cart" data-pdtid="\${product.pdtId}">
                        <img class="cart_icon" src="https://img.echosting.cafe24.com/design/skin/admin/ko_KR/btn_list_cart.gif" alt="카트 아이콘">
                    </div>
                `;

                const productItem = `
                    <li id="item\${product.pdtId}" class="item-swiper-slide swiper-slide">
                        <div class="container-complete" data-prd-num="\${product.pdtId}">
                            <dl>
                                <a href="prdDetailView.htm?productId=\${product.pdtId}" class="viewlink"></a>
                                <div class="base-img">
                                    <div class="thumb">
                                        <img loading="lazy" alt="" class="thumb_img" width="800" height="800" src="\${product.pdtImgUrl}">
                                    </div>
                                    <span class="soldout-img" style="display: none">
                                        <a href="prdDetailView.htm?productId=\${product.pdtId}">
                                            <span>coming<br>soon</span>
                                        </a>
                                    </span>
                                </div>
                                <div class="base-mask">
                                    <dd class="name-container">
                                        <p class="name"><span>\${product.pdtName}</span></p>
                                    </dd>
                                    <dd class="price-container">
                                        <p class="normal-price">\${product.pdtAmount.toLocaleString()}</p>
                                        <p class="sale-price">\${product.pdtDiscountAmount.toLocaleString()}</p>
                                        <p class="discount">\${product.pdtDiscountRate}%</p>
                                    </dd>
                                    <div class="prdInfoBot">
                                        <div class="rvCount">
                                            <div class="rvWrap">
                                                <p class="rv_count_wrap">
                                                    <span class="rv_count_value">\${product.pdtReviewCount}</span>
                                                </p>
                                            </div>
                                        </div>
                                        \${cartButton}
                                        <div class="only_info_dispNone">
                                            <span style="font-size:12px;color:#555555;">#네일 #젤스트립 #핑크 #프렌치 #자석 #글리터 #골드</span>
                                        </div>
                                    </div>
                                </div>
                            </dl>
                        </div>
                    </li>
                `;
                $productContainer.append(productItem); // 상품 항목 추가
            });
        }
    });
</script> -->
       
       
       
       
       <!-- 주간 베스트 끝 -->

       <div class="find_color_container">
           <!-- 비포어로 배경색 있음 (회색) -->
           <div class="find_color_wrap">
               <h3><strong>내가 원하는 디자인 찾기</strong></h3>
          
           
               <div class="find_color_list_wrap">
                   <div class="find_color_list">
                       <span>마블</span>
                       <span>그라데이션</span>
                       <span>시럽</span>
                       <span>자개</span>
                       <span>글리터</span>
                       <span>드로잉</span>
                       <span value="custom_4=프렌치" name="search_form[option_data][]">프렌치</span>
                       <span value="custom_4=체크" name="search_form[option_data][]">체크</span>
                       <span value="custom_4=패턴" name="search_form[option_data][]">패턴</span>
                       <span value="custom_4=매트" name="search_form[option_data][]">매트</span>
                       <span value="custom_4=시스루" name="search_form[option_data][]">시스루</span>
                       <span value="custom_4=벨벳" name="search_form[option_data][]">벨벳</span>
                       
                        <!-- 인풋 히든 같은걸로 값 받아서 보내야하나? -->

                       <div class="find_color_btn">보러가기</div>
                       <!-- 온클릭 이벤트 걸린듯 -->
                   </div>
               </div>
           </div>

       </div>
       <!-- 내가 원하는 디자인 찾기 (컬러) 끝-->

       <div class="event-container swiper mySwiper4">
           <h3>
               <strong>진행 중인 이벤트</strong>
               <a class="eve_moreBtn" href="/ohora.do?event=event">+ 전체보기</a>
           </h3>

           <div class="event-banner-wrap swiper-wrapper">

               <div class="event-banner-tab swiper-slide" >
                   <a href="/ohora.do?event=event">
                       <img src="https://ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/afbf77e9c16af21313051eaae78d2902.webp" alt="이벤트 배너">
                       <span class="event_shopnow">shop now &gt;</span>
                   </a>
               </div>

               <div class="event-banner-tab swiper-slide" >
                   <a href="/ohora.do?event=event">
                       <img src="https://ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/afbf77e9c16af21313051eaae78d2902.webp" alt="이벤트 배너">
                       <span class="event_shopnow">shop now &gt;</span>
                   </a>
               </div>
               

           </div>

           <div class="event-pagination-wrap">
               <span class="event-pagination-bar event-pagination-bar-active"></span>
               <!-- span에 after 걸려있음 -->
           </div>
       </div>
       <!-- 이벤트 컨테이너 끝 -->
        
       


       <div class="main-magazine-container">
           <h3>
               <strong>오호라 매거진</strong>
               <a href="/ohora.do?magazine=magazine" class="magazine-Morebtn">+ 전체보기</a>
           </h3>

           <div class="magazine-swiper-container ">
               <div class="magazine-swiper-wrap swiper mySwiper5">
                   <ul class="magazine-swiper-ul swiper-wrapper">

                       <li class="magazine-li swiper-slide">
                           <!-- before로 선택안된 애들 꺼멓게 만들어줌 -->
                            <div class="magazine-slide-wrap">
                               <a href="" class="magazine-thumb">
                                   <img class="magazine-swiper-item" src="https://ohora.kr/file_data/ohora2019//2023/06/27/0c623df88e3d06f5ab35888159832c4f.jpg" alt="매거진 이미지">
                               </a>
                            </div>
                       </li>
                       <li class="magazine-li swiper-slide">
                           <!-- before로 선택안된 애들 꺼멓게 만들어줌 -->
                            <div class="magazine-slide-wrap">
                               <a href="" class="magazine-thumb">
                                   <img class="magazine-swiper-item " src="https://ohora.kr/file_data/ohora2019//2023/06/27/0c623df88e3d06f5ab35888159832c4f.jpg" alt="매거진 이미지">
                                   <!-- 포커스의 prev -->
                               </a>
                            </div>
                       </li>
                       <li class="magazine-li swiper-slide">
                           <!-- before로 선택안된 애들 꺼멓게 만들어줌 -->
                            <div class="magazine-slide-wrap">
                               <a href="" class="magazine-thumb">
                                   <img class="magazine-swiper-item " src="https://ohora.kr/file_data/ohora2019//2023/06/27/0c623df88e3d06f5ab35888159832c4f.jpg" alt="매거진 이미지">
                                   <!-- 포커스 -->
                               </a>
                            </div>
                       </li>
                       <li class="magazine-li swiper-slide">
                           <!-- before로 선택안된 애들 꺼멓게 만들어줌 -->
                            <div class="magazine-slide-wrap">
                               <a href="" class="magazine-thumb">
                                   <img class="magazine-swiper-item" src="https://ohora.kr/file_data/ohora2019//2023/06/27/0c623df88e3d06f5ab35888159832c4f.jpg" alt="매거진 이미지">
                                   <!-- 포커스의 next -->
                               </a>
                            </div>
                       </li>
                       <li class="magazine-li swiper-slide">
                           <!-- before로 선택안된 애들 꺼멓게 만들어줌 -->
                            <div class="magazine-slide-wrap">
                               <a href="" class="magazine-thumb">
                                   <img class="magazine-swiper-item" src="https://ohora.kr/file_data/ohora2019//2023/06/27/0c623df88e3d06f5ab35888159832c4f.jpg" alt="매거진 이미지">
                               </a>
                            </div>
                       </li>
                       <li class="magazine-li swiper-slide">
                           <!-- before로 선택안된 애들 꺼멓게 만들어줌 -->
                            <div class="magazine-slide-wrap">
                               <a href="" class="magazine-thumb">
                                   <img class="magazine-swiper-item" src="https://ohora.kr/file_data/ohora2019//2023/06/27/0c623df88e3d06f5ab35888159832c4f.jpg" alt="매거진 이미지">
                               </a>
                            </div>
                       </li>

                   </ul>
                   <div class="magazine-swiper-button-next" ></div>
                   <div class="magazine-swiper-button-prev" ></div>
               </div>

           </div>
            

       </div>
      <!-- 매거진 끝 -->

       <div class="bot_banner-container">
           <a href="/ohora.do?about=about" class="aboutOhora">
               <div class="aboutOho-wrap">
                   <h1>ohora, beyond extraordinary</h1>
                   <p>
                       나를 위한 시간,
                       <span>Time to ohora</span>
                   </p>
                   <span>자세히 보기 &gt; </span>
               </div>
           </a>
           <a href="/ohora.do?membership=membership" class="aboutMembership">
               <div class="aboutMem-wrap">
                   <h1>오호라 멤버십</h1>
                   <p>오호라 멤버십에 조인하고 혜택을 받아보세요.</p>
                   <span>자세히 보기 &gt;</span>
               </div>
           </a>

       </div>
    </div>
   <!-- 메인 전체 컨테이너 -->
  <!-- Swiper JS -->
  <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

  <!-- Initialize Swiper -->
  
  
<!--  
<script>
 	$(".aboutMembership").on("click", function (e) {
 		e.preventDefault();
		alert("선택하신 게시판은 사용할 수 없습니다.");
	})
 </script> 
 -->

<script>
    var swiper = new Swiper(".mySwiper", {
        loop:true,
      pagination: {
        el: ".swiper-pagination",
        centeredSlides: true,
        clickable: true,
        renderBullet: function (index, className) {
          return '<span class="' + className + '">' + (index + 1) + "</span>";
        },
      },
    });
</script>

<script>
    var swiper = new Swiper(".mySwiper2", {
      slidesPerView: 'auto', // 자동 너비 조절
      scrollbar: {
        el: ".swiper-scrollbar",
        hide: false,
        draggable: true, 
      },
      
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });
  </script>

<script>
    var swiper = new Swiper(".mySwiper3", {
      slidesPerView: 'auto', // 자동 너비 조절
      scrollbar: {
        el: ".swiper-scrollbar",
        hide: false,
        draggable: true, 
      },
      
      navigation: {
        nextEl: ".swiper-button-next2",
        prevEl: ".swiper-button-prev2",
      },
    });
  </script>

<script>
    var swiper = new Swiper(".mySwiper4", {
        loop:true,
    });
</script>

<script>
    var swiper = new Swiper(".mySwiper5", {
      effect: "coverflow",
      grabCursor: true,
      centeredSlides: true,
      slidesPerView: "auto",
      loop:true,
      coverflowEffect: {
        rotate: 50,
        stretch: 0,
        depth: 100,
        modifier: 1,
        slideShadows: true,
      }
    });
  </script>
  
<!-- 장바구니 버튼 ajax 처리 -->
<script>
    function userCartAdd(element) {
        const productId = $(element).data("pdt_id");
        // alert(productId);
    
        // 확인창 표시
        if (confirm("장바구니에 추가하시겠습니까?")) {
            $.ajax({
                url: "<%= contextPath %>/userCart/addCart.ajax",
                type: "POST",
                dataType: "json",
                data: {
                    pdt_id: productId
                },
                beforeSend: function(xhr) {
                    // CSRF 토큰 설정
                    xhr.setRequestHeader($('meta[name="_csrf_header"]').attr("content"), 
                                         $('meta[name="_csrf"]').attr("content"));
                },
                success: function(response) {
                    if (response.success) {
                        // 장바구니 수량 업데이트
                        $(".EC-Layout-Basket-count").text(response.newCartCount);
                        // 성공 메시지 표시
                        alert(response.message);
                    } else {
                        // 실패 메시지 표시
                        alert(response.message);
                    }
                },
                error: function() {
                    alert("요청 처리 중 오류가 발생했습니다.");
                }
            });
        } else {
            // 사용자가 취소를 선택했을 때 추가 동작이 필요하다면 여기에 작성
            console.log("장바구니 추가가 취소되었습니다.");
        }
    }
</script>

<!-- 세션 체크 -->
<!-- 
<script type="text/javascript">
    window.hasProductCountSession = ${not empty sessionScope.productCount};
</script>
 -->

<!-- 장바구니 쿠키 처리 -->
<!-- 
<script>
$(document).ready(function() {
    // 장바구니 담기 버튼 클릭
    $(document).on("click", "div.into_cart img", function (e) {
        // 세션이 있으면 기존 addCart 함수가 처리하도록 반환
        if (window.hasProductCountSession) {
            return;
        }
        
        // 세션이 없으면 기본 이벤트와 addCart 실행 중지
        e.preventDefault();
        e.stopPropagation();

        const pdtId = $(this).closest('.into_cart').data("pdtid");
        let basketItems = [];
        
        // 기존 장바구니 쿠키 확인
        const cookie = document.cookie
            .split('; ')
            .find(row => row.startsWith('basketItems='));
        if (cookie) {
            try {
                basketItems = JSON.parse(decodeURIComponent(cookie.split('=')[1]));
            } catch (e) {
                console.error("쿠키 파싱 에러:", e);
                basketItems = [];
            }
        }

        // 동일 상품 확인 (문자열로 비교)
        const existingItem = basketItems.find(item => item.id === pdtId.toString());
        if (existingItem) {
            if (confirm("장바구니에 동일한 상품이 있습니다. 수량을 추가하시겠습니까?")) {
                existingItem.quantity += 1;
                alert("상품 수량이 증가했습니다.");
            }
        } else {
            // 새 상품 추가
            basketItems.push({
                id: pdtId.toString(),
                quantity: 1
            });
            
            // 장바구니 카운트 업데이트
            const currentCount = parseInt($(".EC-Layout-Basket-count").text()) || 0;
            $(".EC-Layout-Basket-count").text(currentCount + 1);
            
            alert("장바구니에 상품이 추가되었습니다.");
        }

        // 쿠키에 저장
        document.cookie = "basketItems=" + 
            encodeURIComponent(JSON.stringify(basketItems)) + 
            "; path=/";
    });
});
</script>
 -->

<script src="../resources/js/oho_main.js"></script>

<%-- <%@include file="footer.jsp" %> --%>
</body>

</html>
