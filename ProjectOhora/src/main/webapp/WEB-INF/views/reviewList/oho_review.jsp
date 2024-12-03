<%@page import="kr.ohora.www.domain.review.ReviewRating"%>
<%@page import="java.util.List"%>
<%@page import="kr.ohora.www.domain.product.ProductDTO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%
Integer userId = (Integer) session.getAttribute("userId");
Integer pdtCount = (Integer) session.getAttribute("pdtCount"); // 스프링 수정

// 값 확인
System.out.println("header userId : " + userId);
System.out.println("header pdtCount : " + pdtCount); // 스프링 수정

String contextPath = request.getContextPath();

   // 세션에서 로그인 상태 확인
boolean isLoggedIn = (session.getAttribute("userId") != null);
%>

<%
    String pdtId = request.getParameter("pdt_id");
    
    String path = request.getContextPath();
    
    String photoToggle = request.getParameter("phototoggle");
%>
<%
String sortType = request.getParameter("sort");
if (sortType == null) {
    sortType = "recommend";
}
%>
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
</head>

<body>

    <!-- 콘텐츠 -->
<div class="rv-board-wrap">
    <div class="prd-review-content">
        <div class="prd-review-container">
            <div class="prd-review-wrap">
            <!-- js-pagination-list에 해당함 -->
                <div class="header">
                    <div>
                        <span class="hd-title">
                            <strong>REVIEW 

                            </strong>
                        </span>
                    </div>
                </div>

                <div class="star-rate-container">
                 <!-- js-renewed-products-reviews-summary -->

                    <div class="star-rate-wrap">
                        <div class="star-rate-flex">
                            <div class="star-rate-left">

                                <div class="star-rate-score-wrap">
                                    <div class="products_reviews_summary_v2__score">
                                        <span class="star-rate-icon">
                                            <!-- <div class="icon-wrap"> -->
                                                <div class="icon-box">
                                                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20" viewBox="0 0 20 20" class="crema_product_reviews_score_star_wrapper__star " style="fill: #000000">
                                                        <defs>
                                                            <path id="star-full" d="M7.157 6.698l2.165-4.59a.743.743 0 0 1 1.358 0l2.165 4.59 4.84.74c.622.096.87.895.42 1.353l-3.503 3.57.827 5.044c.106.647-.544 1.141-1.1.835l-4.328-2.382-4.329 2.382c-.556.306-1.205-.188-1.099-.835l.826-5.044-3.502-3.57c-.45-.458-.202-1.257.42-1.352l4.84-.74z"></path>
                                                        </defs>
                                                        <use xlink:href="#star-full"></use>
                                                    </svg>
                                                </div>
                                        </span>
                                        <span class="review-score" id="avgRating">
                                            ${rating.avgRating}

                                            <!-- 동적 처리 필요 -->
                                        </span>
                                    </div>
                                    <div class="like-percent-wrap">
                                        <b id="likeRate">
											
											${ (rating.count5 + rating.count4 + rating.count3)/ (rating.count2 + rating.count1 + rating.count5 + rating.count4 + rating.count3) * 100 }%
                                        	
                                        </b>
                                         <script type="text/javascript">
                                        let rating = ${ (rating.count5 + rating.count4 + rating.count3)/ (rating.count2 + rating.count1 + rating.count5 + rating.count4 + rating.count3) * 100 } ; 
                                        let roundedRating = Math.ceil(rating * 10) / 10; 
                                        $("#likeRate").text(roundedRating+"%"  )
                                        
                                              let avgRating = parseFloat("${rating.avgRating}");
                                      if (!isNaN(avgRating)) {
                                          let roundedAvgRating = Math.ceil(avgRating * 10) / 10;
                                          $("#avgRating").text(roundedAvgRating);
                                      } else {
                                          $("#avgRating").text("0"); // NaN일 경우 기본값 설정
                                      }
                                        
                                        </script>
                                        의 구매자가 이 상품을 좋아합니다.
                                    </div>
                                </div>
                            </div>
		
				
                            <div class="star-rate-right">
                                <!-- 그래프 -->
                                <ul class="score-filter-wrap">
                                    <li class="star">
                                        <div class="filter-title">아주 좋아요</div>
                                        <div class="score-graph-wrap">
                                            <div id="g1" class="score-graph"
                                             style="width: max(${ (rating.count5) / (rating.count2 + rating.count1 + rating.count5 + rating.count4 + rating.count3) * 100 }%, 12px)">
                                            </div>
                                        </div>
                                        <div class="score-count">                                           
                                           ${ rating.count5}
                                        </div>
                                    </li>
                                    <li class="star">
                                        <div class="filter-title">맘에 들어요</div>
                                        <div class="score-graph-wrap">
                                              <div id="g2" class="score-graph" style="width: max(${ (rating.count4) / (rating.count2 + rating.count1 + rating.count5 + rating.count4 + rating.count3) * 100 }%, 12px)"></div>
                                        </div>
                                        <div class="score-count">
                                              ${rating.count4}
                                        </div>
                                    </li>
                                    <li class="star">
                                        <div class="filter-title">보통이에요</div>
                                        <div class="score-graph-wrap">
                                              <div id="g3" class="score-graph" style="width: max(${ (rating.count3) / (rating.count2 + rating.count1 + rating.count5 + rating.count4 + rating.count3) * 100 }%, 12px)"></div>
                                        </div>
                                        <div class="score-count">
                                           ${rating.count3}
                                        </div>
                                    </li>
                                    <li class="star">
                                        <div class="filter-title">그냥 그래요</div>
                                        <div class="score-graph-wrap">
                                              <div id="g4" class="score-graph" style="width: max(${ (rating.count2) / (rating.count2 + rating.count1 + rating.count5 + rating.count4 + rating.count3) * 100 }%, 12px)"></div>
                                        </div>
                                        <div class="score-count">
                                                ${rating.count2}
                                        </div>
                                    </li>
                                    <li class="star">
                                        <div class="filter-title">별로예요</div>
                                        <div class="score-graph-wrap">
                                              <div id="g5" class="score-graph" style="width: max(${ (rating.count1) / (rating.count2 + rating.count1 + rating.count5 + rating.count4 + rating.count3) * 100 }%, 12px)"></div>
                                        </div>
                                        <div class="score-count">
                                               ${rating.count1}
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>    
                    </div>
                </div>

                <div class="rv-media-summary-wrap">
                    <div class="rv-media-summary">
                        <span class="summary-title">포토&동영상</span>
                        <span class="summary-media-cnt"> 
                        (
                        	${mediaCnt} 
                        )
                        
                        </span>
                        <a href="">
                            <div>
                                전체보기 >
                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 8 8" class="products_reviews_media_summary__show_all_arrow">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M.667 2.333L4 5.667l3.333-3.334"></path>
                                </svg>
                            </div>
                        </a>
                    </div>
                    <div class="prd-review-summary-contents-wrap">
                        <ul>
							<c:forEach items="${ photos}" var="photo">
                            			<li class="prd-review-summary-contents">
                                			<img src="${pageContext.request.contextPath}/reviewMedia/${photo.filesystemname}" alt="리뷰상품이미지">
										</li>
							</c:forEach>
                   	
                        </ul>
                    </div>
                </div>
                <!-- 리뷰 써머리 랩 -->

                <div class="filter-sort-menu-wrap">
                    <ul class="filter-sort-menu-ul">
                        <li class="filter-sort-menu-li">
                            <ul class="filter-way-list">
                                <!-- 선택시 selected 클래스 부여 , 글자 스타일바뀜 -->
                                 <li class="way-list recommend <%= "recommend".equals(sortType) ? "way-selected" : "" %>" data-pdt-id="<%= pdtId %>">추천순</li>
    							 <li class="way-list new <%= "new".equals(sortType) ? "way-selected" : "" %>" data-pdt-id="<%= pdtId %>">최신순</li>
    						     <li class="way-list rating <%= "rating".equals(sortType) ? "way-selected" : "" %>" data-pdt-id="<%= pdtId %>">별점순</li>
                            </ul>
                            
                        </li>

                        <li class="filter-basic-search">
                            <div class="search-input-container">
                                <input type="text" class="search-input" placeholder="리뷰 키워드 검색">
                                <a href="#">
                                    <!-- 검색 돋보기 버튼 -->
                                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="none" viewBox="0 0 18 18" class="filter_sort_basic__search_input_icon">
                                        <rect width="10.5" height="10.5" x="2.25" y="2.25" stroke-width="1.5" rx="5.25"></rect>
                                        <path stroke-width="1.5" d="M11.78 11.47L16.28 15.97"></path>
                                    </svg>
                                </a>
                            </div>
                        </li>

                        <li class="hasmedia-first" >
               
               
                                <div class="toggleBtn-wrapper" data-pdt-id="<%= pdtId %>">
                                    <!-- 비선택시 회색 버튼 -->
		
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" class="toggle_button_component__icon-<%="photo".equals(sortType) ? "on" : "off" %> toggle-check-off ">
                                        <rect width="18.5" height="18.5" x="2.75" y="2.75" stroke-width="1.5" rx="9.25"></rect>
                                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="1.5" d="M7 12l4 4 6-7"></path>
                                    </svg>
              
                                   <!--  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 16 16" class="toggle_button_component__icon toggle-check-on">
                                        <rect width="12.333" height="12.333" x="1.833" y="1.833" rx="6.167"></rect>
                                        <path stroke="#fff" stroke-linecap="round" stroke-linejoin="round" d="M4.667 8l2.666 2.667 4-4.667"></path>
                                    </svg>  -->
           

                                    <span>포토/동영상 먼저 보기</span>
                                </div>
                    
                        </li>
                    </ul>

                    <div >

                    </div>
                </div>
                <!-- 기본 정렬 방식 + 검색 끝 -->
                <div class="rv-body">

                    <div class="rv-page">
                        
                        <c:if test="${ empty list }">
                                                    <!-- 리뷰 있으면 none-->
                            <div class="prd-no-rv-container" style="display:;">
                                <div class="no-rv-layout">
                                    <div class="no-rv-msg">
                                        리뷰가 없습니다<br>
                                        <b>리뷰를 작성해 보세요!</b>
                                        
                                    </div>
                                </div>
                            </div>
                   		</c:if>
                        
                        <ul class="prd-Rv-ul">
                             <!-- li 1개 == 리뷰 1개 -->

                        <c:if test="${ not empty list }">
	 						<c:forEach items="${ list }" var="dto">
                             
                            <li class="prd-Rv-li" >
                                <div class="prd-Rv-lcontent">
                                    <div class="lcontent-container">
                                        
                                        <div class="lc-tag-wrap">
                                        	
                                        	<c:if test="${dto.newImg}">
                                            <span class="rv-badge">NEW</span>
                                            </c:if>
                                            <c:if test="${dto.revIsrecommend eq 'Y'}">
                                            <span class="rv-badge">오호라 추천 리뷰</span>
                                            </c:if>

                                        </div>

                                        <div class="lc-score-wrap">
                                            <div class="score-box">
                                                <div class="score-star-box">

                                                    <!-- 꽉별/빈별 클래스명 바꿔서 부여하면됨 -->
                                                    <c:forEach var="i" begin="1" end="5">
												        <c:choose>
												            <c:when test="${i <= dto.revRating}">
												                <img src="${pageContext.request.contextPath}/resources/images/fullStar.svg" alt="꽉별">
												            </c:when>
												            <c:otherwise>
												                <img src="${pageContext.request.contextPath}/resources/images/emptyStar.svg" alt="빈별">
												            </c:otherwise>
												        </c:choose>
												    </c:forEach>
                                                    	
                                                    <span>별점: ${dto.revRating} 점</span>                                                    

                                                </div>
                                                <div>
                                                	<c:choose>
                                                		<c:when test="${dto.revRating eq 1}">별로예요</c:when>
                                                		<c:when test="${dto.revRating eq 2 }">그냥 그래요</c:when>
                                                		<c:when test="${dto.revRating eq 3 }">보통이에요</c:when>
                                                		<c:when test="${dto.revRating eq 4 }">맘에 들어요</c:when>
                                                		<c:when test="${dto.revRating eq 5 }">아주 좋아요</c:when>
                                                		<c:otherwise>XXXX</c:otherwise>
                                                	</c:choose>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- 별점 스코어 박스 -->
                                        
                                        <div class="lc-content-wrap">
                                        <!-- review_list_v2__content_section -->
                                            <div class="lc-content-box">
                                                <div class="content-ment-box">
                                                    <div class="content-ment">
                                                        ${dto.revContent }
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="lc-image-wrap">
                                            <div class="lc-image-box">
                                                <ul class="lc-image-list">
                                                   
                                                    <c:forEach items="${photos}" var="photo">
                                                       
	               										<c:if test="${photo.revId eq dto.revId}">
                                                   			 <li>
                                                        		<a href="#">
                                                            		<div class="lc-image">
                                                                		<img src="${pageContext.request.contextPath}/reviewMedia/${photo.filesystemname}" alt="리뷰사진">
                                                            		</div>
                                                       			</a>
                                                    		</li>
														</c:if> 
                          							</c:forEach>

                                                </ul>

                                            </div>
                                        </div>
                                        
                                         <div class="manager-review">
	                                        <c:choose>
												<c:when test="${dto.revIsrecommend eq 'Y' }">
			                                       
			                                            <!-- 관리자 작성 리뷰 여부 -->
			                                            이 리뷰는 오호라 관리자가 등록한 리뷰입니다.
			                                   
												</c:when>
												<c:otherwise></c:otherwise>
											</c:choose>
										  </div>
										
                                        <div class="lc-like-wrap">

                                            <div class="like-box">

                                                <a class="rv-like">
                                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="review_like_action_v2__like_icon">
                                                    <path stroke-linecap="round" stroke-linejoin="round" d="M8.725 6.2c-.051.152-.026.32.068.45s.245.207.406.207h3.477c.061 0 .121.006.181.017.55.1.914.626.814 1.175l-.962 5.288c-.087.48-.505.83-.994.83H6.177c-.558 0-1.01-.453-1.01-1.011v-6.24c0-.241.086-.474.243-.657l3.619-4.223c.174-.202.463-.26.702-.141.21.105.312.35.237.573L8.725 6.2zM2.333 14V7.333"></path>
                                                    </svg>
                                                    <span class="review_like_text">도움돼요</span>
                                                    <span class="review_like-score" style="display:;">${dto.revGoodCount}</span>
                                                    <!-- 0일시 display none부여 -->
                                                </a>

                                                <a class="rv-unlike">
                                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="review_like_action_v2__unlike_link_icon">
                                                    <path stroke-linecap="round" stroke-linejoin="round" d="M8.725 6.2c-.051.152-.026.32.068.45s.245.207.406.207h3.477c.061 0 .121.006.181.017.55.1.914.626.814 1.175l-.962 5.288c-.087.48-.505.83-.994.83H6.177c-.558 0-1.01-.453-1.01-1.011v-6.24c0-.241.086-.474.243-.657l3.619-4.223c.174-.202.463-.26.702-.141.21.105.312.35.237.573L8.725 6.2zM2.333 14V7.333"></path>
                                                    </svg>
                                                    <span class="review_unlike_text">도움안돼요</span>
                                                    <span class="review_unlike_score" style="display:;">${dto.revBadCount}</span>
                                                </a>
                                                
                                            </div>    

                                            <div class="rv-comment-link-wrap" id="rv-li${dto.revId }" data-rev-id ="${dto.revId }">
                                                <a class="rv-comment-link">
    
                                                    <span class="review_list_v2__comments_text">댓글</span>     
                                                    <span class="review_list_v2__comments_count js-comments-count" id="cmtCnt${dto.revId }">${dto.revCommentCount}</span>
                                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 8 8" class="review_list_v2__small_arrow_icon" style= "width:10px">
                                                    <path stroke-linecap="round" stroke-linejoin="round" d="M.667 2.333L4 5.667l3.333-3.334"></path>
                                                    </svg>
                                                </a>
                                            </div>

                                        </div>
                                        <!-- 좋/싫/댓 -->

                                        <div class="comments-container cmtOff">
                                            <!-- cmtOn일때만 디스플레이// cmtOff: diplay none -->
                                            <div class="comments-wrap">
                                                <ul class="comments-box" id="cmt-ul${dto.revId }">
                                                   <!--  <li class="comment-content">
                                                        <div class="comment-author">
                                                            오호라
                                                        </div>
                                                        <div class="comment-msg">
                                                            🅞🅗🅞🅡🅐✨
                                                        </div>
                                                    </li>

                                                    <li class="comment-content">
                                                        <div class="comment-author">
                                                            우후라
                                                        </div>
                                                        <div class="comment-msg">
                                                            오호호
                                                        </div>
                                                    </li> -->
                                                </ul>
                                                
                                                <div action="/projectOhora/review/reviewcmtwrite.ajax" class="write-comment-wrap">
                                                  <form action="" class="comment-write-form">
                                                        <div class="comment-write-box">
                                                            <textarea id="cmt-writeArea${dto.revId }" name="comment" class="comment-textarea" placeholder="댓글을 작성해 주세요" rows="1" autocomplete="off"></textarea>
                                                            <input type="hidden" class="trackingId" 
                                                            value="<sec:authorize access="isAnonymous()"> </sec:authorize><sec:authorize access="isAuthenticated()"><sec:authentication property="principal.user.userId"/></sec:authorize>"/>
                                                            <input type="hidden" class="trackingrevId" value="${dto.revId}">
                                                        </div>
                                                        <div class="write-comment-btn-wrap" style="display: none">
                                                        	<span class="writeBtn-box">
                                                        		<button type="button" class="cancelWriting" >취소</button>
                                                            	<button type="submit" class="submitComment disBtn" id="submitWriting${dto.revId }">등록</button>
                                                            </span>
                                                        </div>
                                                         <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                                                 </form>
                                                </div>
                                            </div> 

                                        </div>


                                    </div>
                                </div>
                                <!-- Lcontent 끝 -->
                                 
                                 <div class="prd-Rv-Rcontent">
                                    <div class="rv-nameMsg">
                                        <c:choose>
                                        	<c:when test="${dto.revIsrecommend eq 'Y'}">
                                        		<b>
                                        		오호라 크루
                                        		</b>
                                       			 님의 리뷰입니다
                                        	</c:when>
                                        	<c:otherwise>
                                        	    <b>                                        
                                       				 ${dto.userName}
                                        		</b>
                                        			님의 리뷰입니다
                                        	</c:otherwise>
                                        </c:choose>

                                    
                                    </div>
                                    
                                 </div>
                            </li>
                        </c:forEach>
                     </c:if>

                        </ul>
                    </div>
                    <!-- page -->
                    
                </div>
                <!-- rv-body -->

                <div class="rv_footer">
                    <div class="rv-footer-wrap">
                        <div class="infinite-scroll-wrap">
                            <div class="infinite-scroll-btn-wrap" data-pdtId="<%=pdtId %>" data-sort="<%=sortType%>" data-currPage="1" data-allPage="">
                                <a href="#">더보기</a>
                            </div>
                            <div class="infinite-scroll-noMore" style="display: none;">모두 보셨습니다.</div>
                            <!-- 모두 안봤을 때는 none -->
                        </div>
                    </div>
                </div>
                

        </div>
    </div>
</div>

<script src="<%= path %>/resources/js/oho-review.js"></script>
    <!-- 콘텐츠 -->

    <!-- 아래 필수 리뷰는 아니고-->

  </body>
</html>
