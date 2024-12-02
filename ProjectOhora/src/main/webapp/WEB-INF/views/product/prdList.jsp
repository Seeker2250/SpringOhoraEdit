<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<% String contextPath = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Object catenoObj = request.getAttribute("cateno");
int categoryno= 0;
if (catenoObj != null) {
    try {
        categoryno = Integer.parseInt(catenoObj.toString());
        //out.print("카테고리넘버: " + categoryno);
    } catch (NumberFormatException e) {
       categoryno= 0;
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


<link  rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script type="text/javascript">
   window.hasProductCountSession = ${not empty sessionScope.productCount};
</script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
 
</style>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" /> <!-- 스프링 추가 -->
</head>
<body>

   <div id="first-wrap">
      <div id="cate-layout">
         <div id="cate-wrap">
            <div id="cate_name">
               <ul>

               <li>
                   <c:choose>
                      <c:when test="${empty param.sort}">
                           전체상품
                       </c:when>
                       <c:when test="${param.sort == 'sales'}">
                           베스트
                       </c:when>
                       <c:when test="${param.sort == 'new'}">
                           신상품
                       </c:when>
                         <c:when test="${param.sort == 'outlet'}">
                           아울렛
                       </c:when>
                       <c:otherwise>
                           ${param.sort}
                       </c:otherwise>
                   </c:choose>
               </li>

               </ul>
            </div>
			
            <div id="cate_list">

            <c:choose>
               <c:when test="${empty param.sort }">
               <ul class="menu_ul2">
                   <li class="${categoryNumber ==0 ? 'selected-menu-2' :''} " id="selected-menu-all" onclick="moveToCategory(0)">
                       <a href="#">ALL</a>
                   </li>
                   <li id="selected-menu-nail" class="${categoryNumber ==1 ? 'selected-menu-2' :''}">
                       <a href="#" onclick="moveToCategory(1)">네일</a>
                   </li>
                   <li id="selected-menu-pedi" class="${categoryNumber ==2 ? 'selected-menu-2' :''}">
                       <a href="#" onclick="moveToCategory(2)">페디</a>
                   </li>
                   <li id="selected-menu-care-tools" class="${categoryNumber ==3 ? 'selected-menu-2' :''}">
                       <a href="#" onclick="moveToCategory(3)">케어&amp;툴</a>
                   </li>
               </ul>
               </c:when>
            </c:choose>         
               <ul class="menu_3ul" style="display:none">
                  <li class="selected-menu-3 selected submenu"><a href="#">ALL</a></li>
                  <li class="selected-menu-3"><a href="#">케어&amp;툴</a></li>
                  <li class="selected-menu-3"><a href="#">커스텀</a></li>
               </ul>

               </div>
               
               
               <script>
               function moveToCategory(catno) {
                   // 원하는 URL로 이동
                   window.location.href = '/projectOhora/product/list.do?catno=' + catno + '&currentPage=1';
               }
               
               function moveToNewBestOulet() {
                  
               }
               </script>
               
               


            </div>
         </div>
      </div>


      <script>
         // 모든 메뉴 항목을 선택합니다
         var menuItems = document.querySelectorAll("#cate_list ul li");

         // 각 메뉴 항목에 대해 클릭 이벤트를 추가합니다
         menuItems.forEach(function(item) {
            item.addEventListener("click", function(e) {
               e.preventDefault();

               // 기존 selected-menu 클래스를 제거합니다
               document.querySelector(".selected-menu-2").classList
                     .remove("selected-menu-2");

               // 클릭된 항목에 selected-menu 클래스를 추가합니다
               this.classList.add("selected-menu-2");

               // 상단의 카테고리 이름을 업데이트합니다
               document.querySelector("#cate_name ul li").innerText = document.querySelector(".selected-menu-1").innerText;
            });
         });
      </script>

   </div>
   </div>
   <div id="mainImg_layout">
      <div id="banner-image-wrap">
      
            <c:set var="imageUrl" value="" />
      <c:choose>
          <c:when test="${categoryNumber == 0}">
              <c:set var="imageUrl" value="https://ohora.kr/web/upload/category/shop1_44_top_859039.jpg" />
          </c:when>
          <c:when test="${categoryNumber == 1}">
              <c:set var="imageUrl" value="https://ohora.kr/web/upload/category/shop1_160_top_598357.jpg" />
          </c:when>
          <c:when test="${categoryNumber == 2}">
              <c:set var="imageUrl" value="https://ohora.kr/web/upload/category/shop1_161_top_980439.jpg" />
          </c:when>
          <c:when test="${categoryNumber == 3}">
              <c:set var="imageUrl" value="https://ohora.kr/web/upload/category/shop1_49_top_586553.jpg" />
          </c:when>
      </c:choose>
      
      <img src="${imageUrl}" alt="메인이미지" />
         
      </div>
   </div>
   </div>
   <!--위 div-->

   <div id="second-wrap">
      <div id="second-wrap-layout">
         <div id="sort-menu-wrap">
            <div id="sort-type-wrap">
               <div id="select-sort-wrap">
                  <span class="selected-type">정렬방식</span>
                  <ul class="sort_type_list" style="display: none;">
                     <li class="sort-way"><a href="#" onclick="sortByNew()">신상품</a></li>
                     <li class="sort-way"><a href="#" onclick="sortBySales()">인기상품</a></li>
                     <li class="sort-way"><a href="#" onclick="sortByViewcount()">조회수</a></li>
                  </ul>
                  <script>
                     document
                           .querySelector(".selected-type")
                           .addEventListener(
                                 "click",
                                 function() {
                                    let st = document
                                          .querySelector(".sort_type_list");
                                    if (st.style.display == "none") {
                                       st.style.display = "block";
                                    } else {
                                       st.style.display = "none"
                                    }
                                 });
                  </script>
                  
                  <script>
                  function updateSortParameter(newSort) {
                      const currentUrl = new URL(window.location.href);
                      currentUrl.searchParams.set('sort', newSort); // 기존의 'sort'를 새로 설정
                      window.location.href = currentUrl.toString();  // 새 URL로 이동
                  }

                  // 조회수 정렬
                  function sortByViewcount() {
                      updateSortParameter('viewcount');
                  }

                  // 신상품 정렬
                  function sortByNew() {
                      updateSortParameter('new');
                  }

                  // 인기상품(판매량) 정렬
                  function sortBySales() {
                      updateSortParameter('sales');
                  }
                  </script>
               
               </div>

               <button type="button" id="my-design">내가 원하는 디자인 찾기</button>
            </div>
         </div>
         
         <div id="custom-filter-wrap">
            <div class="swiper-container" id="custom-filter">
               <ul class="swiper-wrapper">

                  <li class="swiper-slide"><a href="">젤네일팁 <input
                        type="checkbox" name="filter" id="custom-filter-젤네일팁" /> <label
                        for="custom-filter-젤네일팁"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">숏 <input
                        type="checkbox" name="filter" id="custom-filter-숏" /> <label
                        for="custom-filter-숏"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">미디엄 <input
                        type="checkbox" name="filter" id="custom-filter-미디엄" /> <label
                        for="custom-filter-미디엄"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">롱 <input
                        type="checkbox" name="filter" id="custom-filter-롱" /> <label
                        for="custom-filter-롱"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">데일리 <input
                        type="checkbox" name="filter" id="custom-filter-데일리" /> <label
                        for="custom-filter-데일리"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">풀컬러 <input
                        type="checkbox" name="filter" id="custom-filter-풀컬러" /> <label
                        for="custom-filter-풀컬러"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">웨딩 <input
                        type="checkbox" name="filter" id="custom-filter-웨딩" /> <label
                        for="custom-filter-웨딩"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">시럽 <input
                        type="checkbox" name="filter" id="custom-filter-시럽" /> <label
                        for="custom-filter-시럽"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">파츠 <input
                        type="checkbox" name="filter" id="custom-filter-파츠" /> <label
                        for="custom-filter-파츠"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">무채색 <input
                        type="checkbox" name="filter" id="custom-filter-무채색" /> <label
                        for="custom-filter-무채색"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">키치 <input
                        type="checkbox" name="filter" id="custom-filter-키치" /> <label
                        for="custom-filter-키치"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">드로잉 <input
                        type="checkbox" name="filter" id="custom-filter-드로잉" /> <label
                        for="custom-filter-드로잉"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">마블 <input
                        type="checkbox" name="filter" id="custom-filter-마블" /> <label
                        for="custom-filter-마블"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">자개 <input
                        type="checkbox" name="filter" id="custom-filter-자개" /> <label
                        for="custom-filter-자개"></label>
                  </a></li>
                  <li class="swiper-slide"><a href="">글리터 <input
                        type="checkbox" name="filter" id="custom-filter-글리터" /> <label
                        for="custom-filter-글리터"></label>
                  </a></li>
               </ul>
            </div>
            <div id="swiper-button-prev"></div>
            <div id="swiper-button-next"></div>

            <script>
               // Swiper 초기화
               const swiper = new Swiper(".swiper-container", {
                  slidesPerView : 'auto', // 여러 슬라이드가 한 화면에 보이도록 설정
                  spaceBetween : 8, // 슬라이드 간격
                  navigation : {
                     nextEl : "#swiper-button-next",
                     prevEl : "#swiper-button-prev",
                  },
               });
            </script>
            
               <script>
                  document.querySelectorAll('.swiper-slide a').forEach(link => {
                      link.style.pointerEvents = 'auto'; // 초기화 시 활성화
   
                      link.addEventListener('click', function(event) {
                          event.preventDefault();
   
                          // 체크박스 토글
                          const checkbox = link.querySelector('input[type="checkbox"]');
                          checkbox.checked = !checkbox.checked; // 체크박스 상태 토글
   
                          // 색상 토글
                          if (link.style.backgroundColor === 'black') {
                              link.style.backgroundColor = '';
                              link.style.color = '';
                          } else {
                              link.style.backgroundColor = 'black';
                              link.style.color = 'white';
                          }
                      });
                  });
               </script>

         </div>
         

         <div id="item-list-wrap">
             <div id="item-list">
                 <ul id="item-list-ul">
                     
                     <c:choose>
                         
                         <c:when test="${ empty list }">
                             <li>No Data</li>
                         </c:when>
                         
                         <c:otherwise>
                             <c:forEach items="${ list }" var="pdt" varStatus="status">
                                 <li id="itembox${status.index + 1}" class="item-wrap">
                                     <div class="item-container">
                                         <dl>
                                             
                                             <a href="/projectOhora/product/view.do?product_id=${pdt.pdtId}" class="item-viewlink"></a>
                                             
                                             
                                             <div class="item-image">
                                                 <img src="${pdt.pdtImgUrl}" alt="${pdt.pdtName}" width="800" height="800" />
                                                 <img src="${pdt.pdtImgUrl2}" alt="${pdt.pdtName}" width="800" height="800" />
                                             </div>
                                             
                                             
                                             <div class="item-info">
                                                 <!-- 상품 이름 -->
                                                 <dd class="name-container">
                                                     <p class="item-name">${pdt.pdtName}</p>
                                                 </dd>
                                                 
                                                 
                                                 <dd class="price-container">
                                                     <c:choose>
                                                         <c:when test="${pdt.pdtDiscountRate != 0}">
                                                             <p class="dcRate">${pdt.pdtDiscountRate}%</p>
                                                             <p class="sale-price">
                                                                 <fmt:formatNumber value="${pdt.pdtDiscountAmount}" type="number" pattern="#,##0" />
                                                             </p>
                                                             <p class="normal-price">
                                                                 <fmt:formatNumber value="${pdt.pdtAmount}" type="number" pattern="#,##0" />
                                                             </p>
                                                         </c:when>
                                                         <c:otherwise>
                                                             <p class="dcRate"></p>
                                                             <p class="sale-price">
                                                                 <fmt:formatNumber value="${pdt.pdtAmount}" type="number" pattern="#,##0" />
                                                             </p>
                                                             <p class="normal-price"></p>
                                                         </c:otherwise>
                                                     </c:choose>
                                                 </dd>
                                                 
                                                 
                                                 <div class="review-container">
                                                     <p class="rvCount-wrap">
                                                         <span class="rvCount">${pdt.pdtReviewCount}</span>
                                                     </p>
                                                 </div>
                                                 
                                                 
                                                     <sec:authorize access="isAnonymous()">
                                                 		<div class="cart-in">
										            		<img src="../image/btn_list_cart.gif" data-pdt_id="${pdt.pdtId}" alt="Add to cart" onclick="addToCart(this);" />
                                                 		</div>
										            </sec:authorize>
										            <sec:authorize access="isAuthenticated()">
										            	<div class="cart-in">
										            	<img src="../image/btn_list_cart.gif" data-pdt_id="${pdt.pdtId}" alt="Add to cart" onclick="userCartAdd(this);" />
										            	</div>
										            </sec:authorize>
                                             </div>
                                         </dl>
                                     </div>
                                 </li>
                             </c:forEach>
                         </c:otherwise>
                     </c:choose>
                 </ul>
             </div>
         </div>

         
            
            
            
            <div id="page-container">
				    
				        <!-- 첫 페이지 링크 -->
				        <a href="javascript:goToPage(${pageMaker.realStartPage})" class="first">first</a>
				        
				        <!-- 이전 페이지 링크 -->
				        <c:if test="${pageMaker.criteria.pageNum > 1}">
				            <a href="javascript:goToPage(${pageMaker.criteria.pageNum - 1})" class="prev">prev</a>
				        </c:if>
				        
				        <!-- 페이지 번호 링크 -->
				        <ol>
				            <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
				                <c:choose>
				                    <c:when test="${num eq pageMaker.criteria.pageNum}">
				                        <li class="on"><a href="#" class="this">${num}</a></li>
				                    </c:when>
				                    <c:otherwise>
				                        <li>
				                            <a href="javascript:goToPage(${num})" class="">${num}</a>
				                        </li>
				                    </c:otherwise>
				                </c:choose>
				            </c:forEach>
				        </ol>
				        
				        <!-- 다음 페이지 링크 -->
				        <c:if test="${pageMaker.criteria.pageNum < pageMaker.realEndPage}">
				            <a href="javascript:goToPage(${pageMaker.criteria.pageNum + 1})" class="next">next</a>
				        </c:if>
				        
				        <!-- 마지막 페이지 링크 -->
				        <a href="javascript:goToPage(${pageMaker.realEndPage})" class="last">last</a>
				        
				        
				    
				</div>

				<form id="actionForm" method="get">
				  	<input type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum}">
				    <input type="hidden" name="categoryNumber" value="${categoryNumber}">
				    <c:if test="${param.keyword != null}">
				        <input type="hidden" name="keyword" value="${param.keyword}">
				    </c:if>
				    <c:if test="${param.sort != null}">
				        <input type="hidden" name="sort" value="${param.sort}">
				    </c:if>
				  </form>
            
            <script type="text/javascript">
            function goToPage(pageNum) {
                const form = document.getElementById('actionForm');

                // 현재 URL 경로 가져오기
                const currentPath = window.location.pathname;

                // action 설정: 현재 URL에 따라 변경
                if (currentPath.includes("/prdList.htm")) {
                    form.action = "/prdList.htm";
                } else if (currentPath.includes("/outlet.htm")) {
                    form.action = "/outlet.htm";
                } else {
                    form.action = "/defaultAction.htm"; // 기본 설정 (필요 시)
                }

                // 페이지 번호 설정
                form.pageNum.value = pageNum;

                // 폼 제출
                form.submit();
            }
            </script>
            
            
            
<%--             
<c:if test="${pvo == null}">
    <p>pvo is null</p>
</c:if>
<c:if test="${pvo != null}">
    <p>pvo is not null</p>
    <p>Current Page: ${pvo.currentPage}</p>
    <p>Start Page: ${pvo.start}</p>
    <p>End Page: ${pvo.end}</p>
</c:if> 
--%>

            



            <!-- <div id="page-container">
               <a href="" class="first">first</a> <a href="" class="prev">prev</a>
               <ol>
                  <li class="on"><a href="#" class="this">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">4</a></li>
                  <li><a href="#">5</a></li>
                  <li><a href="#">6</a></li>
                  <li><a href="#">7</a></li>
                  <li><a href="#">8</a></li>
                  <li><a href="#">9</a></li>
                  <li><a href="#">10</a></li>
               </ol>
               <a href="" class="next">next</a> <a href="" class="last">last</a>
            </div> -->
            
            
            

            <script>
               var pageLinks = document
                     .querySelectorAll("#page-container ol li a");
               var pageItems = document
                     .querySelectorAll("#page-container ol li");

               pageLinks.forEach(function(link) {
                  link.addEventListener("click", function(e) {
                     /* e.preventDefault(); */

                     // 모든 li에서 on 클래스 제거
                     pageItems.forEach(function(item) {
                        item.classList.remove("on");
                     });

                     // 모든 a 태그에서 this 클래스 제거
                     pageLinks.forEach(function(pageLink) {
                        pageLink.classList.remove("this");
                     });

                     // 클릭된 링크에 this 클래스 추가
                     this.classList.add("this");

                     // 클릭된 링크의 부모 li에 on 클래스 추가
                     this.parentElement.classList.add("on");
                  });
               });
            </script>

         </div>
      </div>
   </div>
   <!--아래 div-->





   <div id="third-wrap";>
      <form class="side-filter-main" action="" method="get">
         <div id="searchArea" ; style="height: 919px; display: none;">
            <h1 id="side-title">
               내가 원하는 디자인 찾기 <span> <img src="../resources/images/close_icon.png"
                  alt="" />
               </span>
            </h1>

            <script>
               document
                     .querySelector("#my-design")
                     .addEventListener(
                           "click",
                           function() {
                              document.querySelector("#searchArea").style.display = "block";
                           })

               document
                     .querySelector("#side-title span")
                     .addEventListener(
                           "click",
                           function() {
                              document.querySelector("#searchArea").style.display = "none";
                           })
            </script>

            <div class="side-filter">
               <div class="filterTitle">
                  <h2 class="side-filter-title">카테고리</h2>

                  <div class="side-check-type">
                     <ul class="side-type-list">
                        <li class="side-type"><input type="checkbox"
                           class="side-type-check" id="side-check-네일" /> <label
                           for="side-check-네일">네일</label></li>
                     </ul>
                  </div>
               </div>
            </div>

            <div class="side-filter">
               <div class="filterTitle">
                  <h2 class="side-filter-title">라인업</h2>
               </div>
               <div class="side-check-type">
                  <ul class="side-type-list">
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-라인업" /> <label
                        for="side-check-라인업">아트</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-라인업" /> <label
                        for="side-check-라인업">풀컬러</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-라인업" /> <label
                        for="side-check-라인업">파츠</label></li>
                  </ul>
               </div>
            </div>

            <div class="side-filter">
               <div class="filterTitle">
                  <h2 class="side-filter-title">디자인</h2>
               </div>
               <div class="side-check-type">
                  <ul class="side-type-list">
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">시럽</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">자개</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">그라데이션</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">글리터</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">프렌치</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">시스루</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">체크</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">마블</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">패턴</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">드로잉</label></li>
                  </ul>
               </div>
            </div>

            <div class="side-filter">
               <div class="filterTitle">
                  <h2 class="side-filter-title">컬러</h2>
               </div>
               <div class="side-check-type-color">
                  <ul class="side-type-list-color">
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-코랄핑크" value="코랄핑크" /> <label
                        for="side-check-코랄핑크">코랄핑크</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-블루네이비" value="블루네이비" />
                        <label for="side-check-블루네이비">블루네이비</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-누드베이지" value="누드베이지" />
                        <label for="side-check-누드베이지">누드베이지</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-레드버건디" value="레드버건디" />
                        <label for="side-check-레드버건디">레드버건디</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-화이트" value="화이트" /> <label
                        for="side-check-화이트">화이트</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-골드" value="골드" /> <label
                        for="side-check-골드">골드</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-그린" value="그린" /> <label
                        for="side-check-그린">그린</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-옐로우" value="옐로우" /> <label
                        for="side-check-옐로우">옐로우</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-퍼플" value="퍼플" /> <label
                        for="side-check-퍼플">퍼플</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-블랙" value="블랙" /> <label
                        for="side-check-블랙">블랙</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-브라운" value="브라운" /> <label
                        for="side-check-브라운">브라운</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-실버그레이" value="실버그레이" />
                        <label for="side-check-실버그레이">실버그레이</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-네온" value="네온" /> <label
                        for="side-check-네온">네온</label></li>
                     <li class="side-type-color"><input type="checkbox"
                        class="side-type-check" id="side-check-오렌지" value="오렌지" /> <label
                        for="side-check-오렌지">오렌지</label></li>
                  </ul>
               </div>
            </div>

            <div class="side-filter">
               <div class="filterTitle">
                  <h2 class="side-filter-title">해시태그</h2>
               </div>
               <div class="side-check-type">
                  <ul class="side-type-list">
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">0531</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">2020연말컬렉션</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">FW신상컬렉션</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">event1</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">event3</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">n차재입고</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">가을</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">가을네일</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">갈색</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">검정</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">겨울</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">꽃</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">네이비</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">노란색</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">노랑</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">누드</label></li>
                     <li class="side-type"><input type="checkbox"
                        class="side-type-check" id="side-check-디자인" /> <label
                        for="side-check-디자인">데일리</label></li>
                  </ul>
               </div>
            </div>

            <div id="side-filter-search">
               <button type="button" id="side-reset">
                  초기화 <span></span>
               </button>
               <button type="button" id="side-search">검색하기</button>
            </div>
         </div>
         
         <script>
            document.querySelectorAll('.side-type').forEach(item => {
                item.addEventListener('click', function(event) {
                    event.preventDefault(); // 클릭 이벤트의 기본 동작 방지
                    
                    const checkbox = this.querySelector('.side-type-check');
                    checkbox.checked = !checkbox.checked; // 체크박스의 상태를 토글
                    if (checkbox.checked) {
                        // 체크되었을 때 라벨에 스타일 추가
                        this.querySelector('label').style.border = '1px solid black';
                        this.querySelector('label').style.backgroundColor = ''; // 배경색 변경
                    } else {
                        // 체크 해제되었을 때 라벨 스타일 원래대로
                        this.querySelector('label').style.border = '1px solid #E6E6E6';
                        this.querySelector('label').style.backgroundColor = ''; // 배경색 초기화
                    }
                });
            });

         </script>
         
      </form>
      <!--나만의 디자인 찾기-->
   </div>
</body>

<!-- 장바구니 버튼 ajax 처리 -->
<script>
function userCartAdd(element) {
    const productId = $(element).data("pdt_id");

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

<script type="text/javascript">
const CookieUtil = {
	    setCookie: function (name, value, days = 14) {
	        let expires = "";
	        if (days) {
	            const date = new Date();
	            date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
	            expires = "; expires=" + date.toUTCString();
	        }
	        document.cookie = name + "=" + value + expires + "; path=/";
	    },
	    getCookie: function (name) {
	        const nameEQ = name + "=";
	        const ca = document.cookie.split(";");
	        for (let i = 0; i < ca.length; i++) {
	            let c = ca[i].trim();
	            if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length);
	        }
	        return null;
	    }
	};

	function getCartItems() {
	    const basketItems = CookieUtil.getCookie("basketItems") || "";
	    return basketItems
	        .split("/")
	        .filter(Boolean)
	        .map(item => {
	            const [pdtId, quantity] = item.split(":");
	            return { pdtId: parseInt(pdtId), quantity: parseInt(quantity) };
	        });
	}

	function addToCart(pdtId) {
	    let basketItems = getCartItems();
	    const existingItem = basketItems.find(item => item.pdtId === pdtId);
	    if (existingItem) {
	        const userConfirmed = confirm("같은 상품이 존재합니다. 추가하시겠습니까?");
	        if (!userConfirmed) return;
	        existingItem.quantity += 1;
	    } else {
	        basketItems.push({ pdtId: pdtId, quantity: 1 });
	    }
	    // cartString 생성 부분 수정
	    const cartString = basketItems.map(item => item.pdtId + ":" + item.quantity).join("/");
	    // 콘솔로 값 확인
	    console.log("저장되는 cartString:", cartString);
	    CookieUtil.setCookie("basketItems", cartString, 14);
	    alert("장바구니에 상품이 추가되었습니다.");
	    updateCartCount();
	}

	function updateCartCount() {
	    const basketItems = getCartItems();
	    const cartCount = basketItems.length;
	    $(".count.EC-Layout-Basket-count").text(cartCount);
	}

	$(document).ready(function () {
		//<sec:authentication property="principal.user.userId" />
		alert("asdff");
		let userId = <sec:authentication property="principal.user.userId" />;
	    	updateCartCount();
	    	$(document).on("click", ".cart-in img", function () {
	        	const pdtId = $(this).data("pdtid");
	        	addToCart(pdtId);
	    	});
		
	});
	</script>

</html>