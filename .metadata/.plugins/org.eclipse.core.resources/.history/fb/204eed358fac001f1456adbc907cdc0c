<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
Integer userId = (Integer) session.getAttribute("userId");
Integer productCount = (Integer) session.getAttribute("productCount");

// 값 확인
System.out.println("header userId : " + userId);
System.out.println("header productCount : " + productCount);

String contextPath = request.getContextPath();

   // 세션에서 로그인 상태 확인
boolean isLoggedIn = (session.getAttribute("userId") != null);
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
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/header.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
  <link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"
    />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>

</head>
<div class="SP_topBanner" style="display: block">
      <div class="SP_layoutMin">
        <div class="SP_topBn_inr"></div>

        <div class="xans-element- xans-layout xans-layout-statelogoff">
          <div
            class="slide_banner_top slick-initialized slick-slider"
            id="sltop_ban"
          >
            <div class="slick-list draggable">
              <div
                class="slick-track"
                style="
                  opacity: 1;
                  width: 1200px;
                  transform: translate3d(0px, 0px, 0px);
                "
              >
                <div
                  class="slick-slide slick-current slick-active"
                  data-slick-index="0"
                  aria-hidden="false"
                  style="width: 1200px"
                  tabindex="0"
                >
                  <a
                    href="<%= contextPath %>/ohora.do?event=eventnew"
                    tabindex="0"
                    style="display: block"
                    ><img
                      src="https://ohora.kr/optimize/images/pc/common/PC_header_lamp2.webp"
                      style="width: 100%; display: block"
                  /></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 회원 -->
    </div>

    <div id="fix_position" class="modify ham_modify">
      <div id="SMS_fixed_wrap" class="SMS_fixed_wrap">
        <div class="SP_top_wrap">
          <div class="layout_Top">
            <div
              class="xans-element- xans-layout xans-layout-statelogoff SP_gnb_inr"
            >
            <!-- 갱신함 / 경로는 아직 안넣음 -->
            <%
               if ( userId == null ) {
            %>
                 <a href="<%= contextPath %>/ohora.do?join=signup"><span class="title">회원가입</span></a>|
                 <a href="<%= contextPath %>/ohora.do?login=gologin" class="log"><span class="title">로그인</span></a>
            <%      
               } else if  ( userId == 1001 ) {
            %>
                <a href="<%= contextPath %>/admin/product.do"><span class="title">관리자페이지</span></a>|
                <a href="<%=contextPath %>/logout/logout.do" class="log"><span class="title">로그아웃</span></a>
            <%
               } else {
            %>
                <a href="<%= contextPath %>/mypage/mypage.do?user_id=<%= userId %>"><span class="title">마이페이지</span></a>|
                <a href="<%=contextPath %>/logout/logout.do" class="log"><span class="title">로그아웃</span></a>
              <%
               } 
            %>
            </div>
          </div>
        </div>
        <div class="SMS_fixed_inner">
          <div class="xans-element- xans-layout xans-layout-logotop fixed_logo">
            <a
              href="<%= contextPath %>/product/main.do"
              style="display: block; text-align: center; margin-top: 30px"
            >
              <img
                src="https://ohora.kr/web/upload/logo/ohora_BI_logotype_w.png"
               
              />
            </a>
          </div>

          <!-- 헤더 주메뉴 -->
          <div class="gnb_menu_container">
            <ul class="gnb_menu_wrap menu_1ul">
              <li class="eng_font menu_1li submenu">
                <a href="/projectOhora/product/list.do?sort=new" style="color:black !important;">new</a>
              </li>
              <li class="eng_font menu_1li submenu">
                <a href="/projectOhora/product/list.do?sort=sales" style="color:black !important;">best</a>
              </li>

              <li class="eng_font">
                <a href="/projectOhora/product/list.do" style="color:black !important;">product</a>

                <!-- 마우스 오버 시 나오는 영역(product) -->
                <ul class="menu_2ul">
                  <li>
                    <a href="/projectOhora/product/list.do?catno=1&currentPage=1"
                      ><span>네일</span></a
                    >
                  </li>
                  <li>
                    <a href="/projectOhora/product/list.do?catno=2&currentPage=1"
                      ><span>페디</span></a
                    >
                  </li>
                  <li>
                    <a href="/projectOhora/product/list.do?catno=1&currentPage=1"
                      ><span>커스텀</span></a
                    >
                  </li>
                  <li>
                    <a href="/projectOhora/product/list.do?catno=3&currentPage=1"
                      ><span>케어 &amp; 툴</span></a
                    >
                  </li>
                </ul>
                <!-- //마우스 오버 시 나오는 영역(product) -->
              </li>

              <li class="eng_font menu_1li submenu">
                <a href="/projectOhora/product/list.do?sort=outlet" style="color:black !important;" onclick="checkLogin(event)">outlet</a>
              </li>
              <li class="eng_font"><a href="<%= contextPath %>/ohora.do?event=event" style="color:black !important;">event</a></li>
              <li class="eng_font">
                <a href="<%= contextPath %>/ohora.do?howto=howto" style="color:black !important;">how to</a>
              </li>
            </ul>
          </div>
          <!-- //헤더 주메뉴 -->

          <div class="icon_wrap">
            <div class="small_icon search_fixed_btn"></div>
            <div
              class="xans-element- xans-layout xans-layout-orderbasketcount small_icon m_cart common_cart"
            >
              <!-- 고정 값 0 을 어떻게 동적으로 바꾸는가 -->
              <c:choose>
             <c:when test="${userId != null}">
                 <form action="<%=contextPath %>/cart/useriscart.do" method="post" id="CartForm">
                     <a href="#" id="goCart">
                         <b class="count EC-Layout-Basket-count">${productCount}</b>
                     </a>
                 </form>
             </c:when>
             <c:otherwise>
                 <form action="<%=contextPath %>/cart/nousercart.do" method="post" id="CartForm">
                     <a href="#" id="goCart">
                         <b class="count EC-Layout-Basket-count" >0</b>
                     </a>
                 </form>
             </c:otherwise>
         </c:choose>
            </div>
            <div class="small_icon m_menu"><a class="SMS_menu"></a></div>
          </div>
        </div>
      </div>
    <!-- 검색 -->
    <div class="hd_search_container" style="overflow: hidden; display: none">
      <div class="SP_search_wrap">
        <div class="SP_utilListSearch_inner">
          <form
            id="searchBarForm"
            name=""
            action="/projectOhora/product/list.do"
            method="get"
            target="_self"
            enctype="multipart/form-data"
          >
            <input id="banner_action" name="banner_action" value="" type="hidden" />
            <div class="xans-element- xans-layout xans-layout-searchheader">
          
              <fieldset>
                <legend style="display: none">검색</legend>
                <input
                  id="keyword"
                  name="keyword"
                  fw-filter=""
                  fw-label="검색어"
                  fw-msg=""
                  class="inputTypeText"
                  placeholder=""
                  onkeyup="SEARCH_HASHTAG.getHashtag($(this)); "
                  autocomplete="off"
                  onmousedown="SEARCH_BANNER.clickSearchForm(this)"
                  value=""
                  type="text"
                /><button
                  type="button"
                  class="SP_srh_submit_btn"
                  onclick="SEARCH_BANNER.submitSearchBanner(this); return false;"
                >
                  <span class="SP_cm_icon SP_black_search_icon"></span>
                </button>
              </fieldset>
            </div>
          </form>
        </div>
    
        <!--------------- 검색 키워드 --------------->
        <div class="SP_utilListKeyword_inner">
          <ul>
            <li><a href="/projectOhora/product/list.do?sort=outlet">#OUTLET 입장하기</a></li>
            <li><a href="/projectOhora/product/list.do">#BEST 디자인 추천</a></li>
            <li><a href="a href="<%= contextPath %>/ohora.do?event=event6">#첫구매 젤램프 증정</a></li>
          </ul>
        </div>
        <!--------------- 검색 키워드 --------------->
      </div>
    </div>

    <!-- 더보기 -->
    <div class="hd_cate_container" style="overflow: hidden; display: none">
      <div class="SP_category_wrap" style="margin-top: 172px;">
        <div class="inner">
      
          <div class="cate_wrap first">
   

            <div class="big_txt">
              <a class="eng_font big_" href="/projectOhora/product/list.do?sort=new">
                <span>new</span>
              </a>
              <a class="" href="/projectOhora/product/list.do?sort=new">
                <span></span>
              </a>
              <a class="" href="/projectOhora/product/list.do?sort=new">
                <span></span>
              </a>
            </div>
            <div class="big_txt" style="margin-top:50px">
              <a class="eng_font big_" href="/projectOhora/product/list.do?sort=sales">
                <span>best</span>
              </a>
              <a href="/projectOhora/product/list.do?catno=1&currentPage=1">
                <span>네일</span>
              </a>
              <a href="/projectOhora/product/list.do?catno=2&currentPage=1">
                <span>페디</span>
              </a>
            </div>
          </div>
          <div class="cate_wrap first">
            <div class="big_txt">
              <a class="eng_font big_" href="/projectOhora/product/list.do?catno=1&currentPage=1">
                <span>nail</span>
              </a>
              <a class="" href="/projectOhora/product/list.do?catno=1&currentPage=1">
                <span>젤스트립</span>
              </a>
            </div>
            <div class="big_txt" style="margin-top:80px">
              <a class="eng_font big_" href="/projectOhora/product/list.do?catno=2&currentPage=1">
                <span>pedi</span>
              </a>
              <a class="" href="/projectOhora/product/list.do?catno=2&currentPage=1">
                <span>젤스트립</span>
              </a>
            </div>
          </div>

          <div class="cate_wrap first">
            <div class="big_txt">
              <a class="eng_font big_" href="/projectOhora/product/list.do?sort=outlet">
                <span>outlet</span>
              </a>
            </div>
            <div class="big_txt">
              <span></span>

              <span></span>

              <span></span>
            </div>

            <div class="big_txt" style="margin-top:105px">
              <a class="eng_font big_" href="/projectOhora/product/list.do">
                <span>custom</span>
              </a>
            </div>
            <div class="big_txt" style="margin-top:38px">
              <a class="eng_font big_" href="/projectOhora/product/list.do?catno=3&currentPage=1">
                <span>care &amp; tool</span>
              </a>
            </div>
          </div>

          <!--------- 첫번째 줄 메뉴(신제품 출시 관련 수정 영역) --------->
          <style>
          
          </style>

          <!------- 두번째 줄 메뉴 ------>
          <div class="cate_wrap second">
  
            <div class="big_txt" style="margin-left: 35px; margin-bottom: 42px;">
              <a class="big_ eng_font" href="<%= contextPath %>/ohora.do?event=event">
                <span>event</span>
              </a>
            </div>

            <div class="big_txt" style="margin-left: 35px;  margin-bottom: 42px;">
              <a
                class="big_ eng_font"
                href="#none"
              >
                <span>review</span>
              </a>
            </div>
            <div class="big_txt" style="margin-left: 35px;">
              <a class="big_ eng_font" href="<%= contextPath %>/ohora.do?about=about">
                <span style="margin-top: 10px;">brand</span>
              </a>
              <a class="" href="<%= contextPath %>/ohora.do?about=about">
                <span>about</span>
              </a>
              <a class="" href="<%= contextPath %>/ohora.do?membership=membership">
                <span>membership</span>
              </a>
              <a class="" href="<%= contextPath %>/ohora.do?magazine=magazine">
                <span>magazine</span>
              </a>
              <a class="" href="#empty">
                <span>collaboration</span>
              </a>
            </div>
          </div>
          <!------ 두번째 줄 메뉴 ------>
          <!------ 세번째 줄 메뉴 ------>
          <div class="cate_wrap crew">
  <!--오호라 크루 추천-->
  <div
    class="common_reco_section recommend_crew slider-container slider-container-initialized slider-container-horizontal load-complete"
     style="margin-left: 100px"
  >
    <h3>오호라 크루 추천</h3>
    <div
      df-banner-code="common-recommend"
      class="recommend_banner_wrap slider-wrapper df-bannermanager df-bannermanager-common-recommend"
      style="width: 260px; height: 231px"
    >
      <div
        df-banner-clone=""
        class="SP_eventBn_li slider-slide slider-slide-prev"
      >
        <a href="#empty"
          ><div class="imgBox">
            <img
              src="https://ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/94fad6d6474acf635b9c771591480a7c.png"
              alt="페이코 상시 12% 할인"
            />
          </div>
          <div class="txtBox">페이코 상시 12% 할인</div></a
        >
      </div>
    </div>
    <!-- 스와이퍼 스크롤 -->
    <div class="slider-scrollbar">
      <div
        class="slider-scrollbar-drag"
        style="transition-duration: 0ms; transform: translate3d(0px, 0px, 0px); width: 80px;"
      ></div>
    </div>
    <span
      class="slider-notification"
      aria-live="assertive"
      aria-atomic="true"
    ></span>
  </div>
  <!--// 오호라 크루 추천-->
  <div class="third_cate" style="margin-left: 108px; margin-top: 65px;">
    <a href="https://oe9lp.channel.io/home"><span style="font-size:13px ; color:black !important;" >CS Center &nbsp;|</span></a>
    <a href="<%= contextPath %>/ohora.do?notice=notice"><span style="font-size:13px ; color:black !important;"> &nbsp; Notice &nbsp;|</span></a>
    <a href="<%= contextPath %>/ohora.do?FAQ=FAQ"><span style="font-size:13px ; color:black !important;"> &nbsp; FAQ &nbsp;|</span></a>
    <a href="<%= contextPath %>/ohora.do?howto=howto"><span style="font-size:13px ; color:black !important;"> &nbsp; How to</span></a>
  </div>
</div>
          
        </div>
      </div>
    </div>


  </div> <!-- sticky 적용을 위한 태그-->

  
 
  <!-- 슬라이더 초기화 코드 -->
   <!-- 슬라이더 초기화 코드 -->
    <script>
      $(document).ready(function () {
        $(".slide_banner_top").slick({
          infinite: true,
          speed: 300,
          slidesToShow: 1,
          dots: false,
          arrows: false,
          autoplay: true,
          autoplaySpeed: 3000,
          swipe: true,
          pauseOnHover: false,
        });
      });
    </script>
    
    <script>
      $("#goCart").on("click", function(event){
         // alert("test");
         event.preventDefault();
         $("#CartForm").submit();
      });
   </script>

    <script>
      $(document).ready(function() {
        const searchContainer = $('.hd_search_container');
        const cateContainer = $('.hd_cate_container');

        searchContainer.hide();
        cateContainer.hide();

        // 검색 버튼 클릭 시
        $('.small_icon.search_fixed_btn').on('click', function() {
          if (!searchContainer.is(':visible')) {
            cateContainer.stop(true, true).fadeOut(300, function() {
              searchContainer.stop(true, true).slideDown(500).animate({ opacity: 1 }, { duration: 10 });
              $('#keyword').focus();
            });
          } else {
            searchContainer.stop(true, true).slideUp(500).animate({ opacity: 0 }, { duration: 10 });
          }
        });

        // 더보기 버튼 클릭 시
        $('.SMS_menu').on('click', function() {
          if (!cateContainer.is(':visible')) {
            searchContainer.stop(true, true).fadeOut(300, function() {
              cateContainer.stop(true, true).slideDown(500).animate({ opacity: 1 }, { duration: 10 });
              $('#keyword').focus();
            });
          } else {
            cateContainer.stop(true, true).slideUp(500).animate({ opacity: 0 }, { duration: 10 });
          }
        });
      });
    </script>
    
     <script>
      function checkLogin(event) {
          // 로그인 여부 확인
          if (!isLoggedIn) {
              // 로그인되지 않은 경우 경고창 표시 및 링크 이동 막기
              event.preventDefault(); // 기본 링크 이동 동작 취소
              alert("회원만 접근 가능합니다.");
          }
          // 로그인된 경우 링크 이동 (기본 동작)
      }
   </script>
    
    <script type="text/javascript">
    // JavaScript 변수에 로그인 상태 전달
    var isLoggedIn = <%= isLoggedIn %>;
</script>


  
<script>
//비회원 전용 장바구니 카운트 관리자
const NonMemberCartManager = {
    lastCookieValue: null,

    // 쿠키값 가져오기
    getBasketCookie() {
        const cookie = document.cookie
            .split('; ')
            .find(row => row.startsWith('basketItems='));
        return cookie ? cookie.split('=')[1] : null;
    },

    // 카운트 업데이트
    updateCount() {
        try {
            const cookieValue = this.getBasketCookie();
            if (cookieValue) {
                const basketItems = JSON.parse(decodeURIComponent(cookieValue));
                if (Array.isArray(basketItems)) {
                    const countElement = document.querySelector('.EC-Layout-Basket-count');
                    if (countElement) {
                        countElement.textContent = basketItems.length;
                    }
                }
            }
        } catch (error) {
            console.error('장바구니 쿠키 처리 오류:', error);
        }
    },

    // 쿠키 변경 확인 및 업데이트
    checkAndUpdate() {
        const currentCookie = this.getBasketCookie();
        if (currentCookie !== this.lastCookieValue) {
            this.lastCookieValue = currentCookie;
            this.updateCount();
        }
    },

    // 모니터링 시작
    startMonitoring() {
        // 초기값 설정
        this.lastCookieValue = this.getBasketCookie();
        this.updateCount();

        // 주기적으로 쿠키 변경 확인
        setInterval(() => {
            this.checkAndUpdate();
        }, 100);
    }
};

// 페이지 로드 시 비회원인 경우에만 모니터링 시작
document.addEventListener('DOMContentLoaded', function() {
    const userId = "<%= userId %>";
    
    // 비회원일 때만 쿠키 기반 카운트 모니터링 실행
    if (userId === "null" || userId === "") {
        NonMemberCartManager.startMonitoring();
    }
});

// 장바구니 담기 버튼 클릭 시 비회원인 경우에만 즉시 업데이트 트리거
document.querySelector('.SP_cartBtn')?.addEventListener('click', function() {
    const userId = "<%= userId %>";
    if (userId === "null" || userId === "") {
        setTimeout(() => {
            NonMemberCartManager.checkAndUpdate();
        }, 100);
    }
});
</script>

  </body>
</html>