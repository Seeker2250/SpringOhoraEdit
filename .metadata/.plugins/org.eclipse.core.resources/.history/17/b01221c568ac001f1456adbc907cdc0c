<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="ohora.domain.ProductDTO" %>
<%@ page import="ohora.domain.OptionDTO" %>
<%
    // productId를 사용해 DB에서 해당 상품 정보를 조회하여 화면에 출력하는 코드 작성
    String productId = request.getParameter("pdt_id");
    
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
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/prd_detail_view.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
 <script type="text/javascript">
    window.hasProductCountSession = ${not empty sessionScope.userId};
</script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
<%@include file="header.jsp" %>
</head>
<body>
<button id="btnTotalAmountUpdate" style="display: none;">수량실시간변경</button>



<!------------------------------ 상품 상세 영역 -------------------------------->
<div class="SP_prdDtail_wrap renew_prdDetail">
    <!------------------------------ 레이아웃 -------------------------------->
    <div class="SP_layoutFix">
      <!------------------------------ product_detail 모듈 -------------------------------->
      <div class="xans-element- xans-product xans-product-detail"><!--
            $coupon_download_page = /coupon/coupon_productdetail.html
            -->

  <!------------------------------ SP_detailArea_wrap -------------------------------->
  <div class="SP_detailThumbnail_wrap">
    <!-- 큰 이미지 -->
    <div class="SP_thumbnail">
        <img id="mainImage" src="${product.pdt_img_url }" alt="${product.pdt_name }" class="BigImage">
    </div>

    <!-- 작은 이미지 목록 -->
    <div class="SP_listImg">
        <ul>
            <li><img src="${product.pdt_img_url }" alt="Thumb 1" onmouseover="changeImage('${product.pdt_img_url }')"></li>
            <li><img src="${product.pdt_img_url2 }" alt="Thumb 2" onmouseover="changeImage('${product.pdt_img_url2 }')"></li>
            <!-- <li><img src="https://www.ohora.kr/web/product/extra/small/202410/20ea938442221e7f2d275a865172a656.jpg" alt="Thumb 3" onmouseover="changeImage('image/prd_image/마롱네일4.jpg')"></li>
            <li><img src="https://www.ohora.kr/web/product/extra/small/202410/7ad8d1c56f1046c160fa9395f443c187.jpg" alt="Thumb 4" onmouseover="changeImage('image/prd_image/마롱네일1.jpg')"></li> -->
        </ul>
    </div>
</div>

<script>
    // 큰 이미지를 변경하는 function
    function changeImage(imageSrc) {
        document.getElementById('mainImage').src = imageSrc;
    }
</script>


    <!------------------------------ //상품 이미지 영역 -------------------------------->
          <!------------------------------ 상품 정보 영역 -------------------------------->
          <div class="SP_detailPrdOpt_wrap" style="opacity: 1;">
            <!------------------------------ 상품 정보 영역 inner -------------------------------->
            <div class="SP_detailPrdOpt_inr">
              
                        <div class="color displaynone">
                        <div module="product_Colorchip">
                        <span class="chips" style="background-color:"></span>
                        <span class="chips" style="background-color:"></span>
                        </div>
                        </div>
                        

              <!-------------------------- 상품 정보 호출 ---------------------------->
              <div class="xans-element- xans-product xans-product-detaildesign SP_dtPrdOptionList_wrap"><!--
                            출력 갯수 지정 변수, 없으면 설정된 전체가 나옵니다.
                            count = 10
                            -->
  <ul class="SP_prdListItemInfo" style="display: block;">
	  <li class="display_상품명 xans-record- SP_dfList_prdName">
	  <span class="title" style=""><!--<span style="">상품명</span>--></span><span class="SP_detail_content" style=""><span style="">${product.pdt_name}</span></span>
	  </li><li class="xans-record- review_count"><span class="SP_detail_content">리뷰 ${product.pdt_review_count}</span></li>
	                  <!-- <li class="display_영문상품명 xans-record- SP_dfList_engName" style="display: list-item;">
	  <span class="title" style=""><span style="">영문상품명</span>></span><span class="SP_detail_content" style=""><span style="">N Cooing Nails</span></span>
	  </li> -->
		
	  <li class="display_가격 xans-record- SP_dfList_price strike" style="display: list-item;">
	  <span class="title" style="">가격</span><span class="SP_detail_content" style=""><span style=""><strong id="span_product_price_text" style="text-decoration: line-through;">${product.pdt_amount}</strong><input id="product_price" name="product_price" value="" type="hidden" style=""></span><span class="salesPrice">${product.pdt_discount_amount}</span><span class="dcPercent">${product.pdt_discount_rate}%</span></span>
	  </li>
	  
	<% if (product.hasOptions()) { %>
	    <!-- 옵션 선택 드롭다운 출력 -->
	    <span class="option">옵션 선택 : </span> <select class="option_select" id="productOptionSelect">
	        <option value="" selected>옵션을 선택해주세요</option>
	        <option value="" disabled>------------------</option>
	        <% for (OptionDTO option : product.getOptions()) { %>
	            <option value="<%= option.getOpt_id() %>" data-option-name="<%= option.getOpt_name() %>" data-option-price="<%= option.getOpt_amount() %>">
	                <%= option.getOpt_name() %>
	            </option>
	        <% } %>
	    </select>
	<% } else { %>
	    <!-- 수량 선택 출력 -->
	    <div>
	        <label><p style="display: inline-block; padding-right: 90px">수량:</p></label>
	        <button type="button" onclick="decrementQuantity()" class="main_option_down" style="padding: 5px 10px; border: 1px solid  #ddd" >-</button>
	        <input type="text" value="1" id="option_main_quantity" product-id = ${product.pdt_id}>
	        <button type="button" onclick="incrementQuantity()" class="main_option_up" style="padding: 5px 10px; border: 1px solid  #ddd">+</button>
	    </div>
	<% } %>
	
	  <script>
	
    

    // 수량 감소 기능
    function decrementQuantity() {
        var quantityInput = document.getElementById("option_main_quantity");
        var currentValue = parseInt(quantityInput.value);

        if (currentValue > 1) {
            quantityInput.value = currentValue - 1;
            
        } else {
            alert("최소 주문수량은 1개 입니다");
        }
        calculateMainProductTotalPrice();
        $("#btnTotalAmountUpdate").click();
        lastPriceFunc();
        
    }

    // 수량 증가 기능
    function incrementQuantity() {
        var quantityInput = document.getElementById("option_main_quantity");
        var currentValue = parseInt(quantityInput.value);

        quantityInput.value = currentValue + 1;
        calculateMainProductTotalPrice();
        $("#btnTotalAmountUpdate").click();
        lastPriceFunc();
        
    }

</script>
	
	<script>
	// 옵션 선택 시 동적으로 상품 추가
	//document.getElementById("productOptionSelect").addEventListener("change", function() {
		$(".option_select").on("change", function () {
			
	    var selectedOption = this.options[this.selectedIndex];

	    // 선택된 옵션의 ID, 이름, 가격을 가져옴 + 메인 상품 이름
	    var productId = selectedOption.value;
	    var optionName = selectedOption.getAttribute("data-option-name");
	    var productName = "${product.pdt_name}"; // 상품명 가져오기
	    var productAmount = Number("${product.pdt_amount}");

	    // 값이 없을 경우 처리하지 않음
	    if (!productId) return;

	    // 이미 추가된 상품인지 확인
	    if ($(".add_product[data-option-add-index='" + productId + "']").length > 0) {
	        alert("해당 옵션이 이미 추가되었습니다.");
	        return;
	    }

	    // 가격 형식 변환
	    var formattedPrice = productAmount.toLocaleString();

	    // 동적으로 회색 영역에 추가할 상품 HTML 템플릿
	    var additionalProductHtml = `
				    <div class="add_product" data-option-add-index="\${productId}">
				        <div class="product">
				            <p>\${productName}<br> - <span style="display: inline;">\${optionName}</span></p>
				        </div>
				        <!-- 수량 선택 요소를 상품 설명 아래로 이동 -->
				        <div class="quantity">
				            <a href="javascript:void(0);" id="selectedDown" class="down eAddProductQuantityDownClass" data-target="option_add_box\${productId}_down">-</a>
				            <input type="text" id="option_add_box\${productId}_quantity" name="quantity_opt[]" class="quantity_opt eAddProductQuantityClass" value="1" product-id="\${productId}" readonly>
				            <a href="javascript:void(0);" id="selectedUp" class="up eAddProductQuantityUpClass" data-target="option_add_box\${productId}_up">+</a>
				        </div>
				        <div class="right">
				            <span id="option_add_box\${productId}_price">
				                <input type="hidden" class="add_product_option_box_price" value="\${productAmount}" product-id="\${productId}">
				                <span class="ec-front-product-item-price" product-id="\${productId}">\${formattedPrice}</span>원
				            </span>
				        </div>
				        <div class="delete" onclick="removeProduct(\${productId})">
				            ×
				        </div>
				    </div>
				`;
        
	    // 회색 영역에 추가 상품 삽입
	    $("#additional-product-list").append(additionalProductHtml);
	    $("#btnTotalAmountUpdate").click();
	    lastPriceFunc();
		})
	
	
	

	
	// 선택 상품 삭제function
	function removeProduct(productId) {
    $(".add_product[data-option-add-index='" + productId + "']").remove();
	}
	</script>
	  
		
	  <!-- <li class="xans-record- SP_dfList_quantity" style="display: list-item;">
	  			<span class="title" style="">수량</span><span class="SP_detail_content">
	  			<a href="#none" class="down"></a><input id="quantity_clone" value="1" type="text" readonly=""><a href="#none" class="up"></a></span>
	  		</li> -->
	  <li class="xans-record- SP_dfList_mileageInfo" style="display: list-item;"></li> 
  </ul>
  
 
  
  
  

  <!-- <span class="title" style=""><span style="">할인판매가</span></span><span class="SP_detail_content" style=""><span style=""><span style=""><span id="span_product_price_sale" style="">12,580 </span></span></span></span> -->
  
  <!-- <li class="display_배송비 xans-record- SP_dfList_deliveryInfo" style="display: list-item;">
  <span class="title" style=""><span style="">배송비</span></span><span class="SP_detail_content" style=""><span style=""><span class="delv_price_B" style=""><input id="delivery_cost_prepaid" name="delivery_cost_prepaid" value="P" type="hidden" style=""><strong>3,000</strong> (50,000 이상 구매 시 무료)</span></span></span>
  </li> -->
                
  <div class="share_btn">
    <span class="kakaoShare" style=""><img src="https://cdn-icons-png.flaticon.com/512/1828/1828960.png"></span>
  </div>
  
</div> 
              <!-------------------------- //상품 정보 호출 ---------------------------->
  
              <!-------------------------------------- 수량 ---------------------------------->
              <div class="SP_dtQuantity_wrap">
                </div>
              <!-------------------------------------- 수량 ---------------------------------->
              <!------------------------- 개인결제창 네이버 마일리지 적립 사용 ------------------------------>
              <!-- <p class="displaynone">
                <img src="//img.echosting.cafe24.com/skin/base_ko_KR/product/txt_naver.gif" alt="개인결제창을 통한 결제 시 네이버 마일리지 적립 및 사용이 가능합니다.">
              &nbsp;</p> -->
              <!------------------------- //개인결제창 네이버 마일리지 적립 사용 ------------------------------>
              <!------------------------- 옵션 출력 ------------------------------>
              
              <!------------------------- //옵션 출력 ------------------------------>
  
  
              <!-- 추가구성상품 -->
             <!--  <div class="xans-element- xans-product xans-product-addproduct SP_productAddSet_wrap view open"> -->
<%--     <div class="SP_prdAddSet_title">
        <h3>추가구성상품</h3>
        <a href="javascript:void(0);" class="SP_js_toggle_btn SP_prdAddSetToggle"></a>
    </div>
    <ul class="SP_prdAddSetList_wrap">
        <c:forEach var="product" items="${additionalProducts}">
            <li data-prd-num="${product.pdt_id}" class="xans-record-">
                <div class="SP_addSetInfo">
                    <div class="SP_addSetThumb">
                        <a href="/product/${product.pdt_name}/${product.pdt_id}/">
                            <img src="${product.pdt_img_url}" alt="${product.pdt_name}" id="ec-add-product-composed-product-${product.pdt_id}">
                        </a>
                    </div>
                    <div class="SP_prdAddSetList">
                        <ul>
                            <li class="SP_addSetList_tt">
                                <div class="SP_prdAddSet_cont SP_prdAddSet_prdtt">${product.pdt_name}</div>
                            </li>
                            <li class="desc">${product.pdt_description}</li>
                            <li class="add_prd_price">
                                <div class="SP_prdAddSet_cont SP_prdAddSet_price">
                                    <span>${product.pdt_amount}</span>원
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div class="btn add-opt-click"><a href="#none">추가</a></div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
	 --%>			 
				 <div class="xans-element- xans-product xans-product-addproduct SP_productAddSet_wrap view open">
    <div class="SP_prdAddSet_title">
        <h3>추가구성상품</h3>
        <a href="javascript:void(0);" class="SP_js_toggle_btn SP_prdAddSetToggle"></a>
    </div>
    <ul class="SP_prdAddSetList_wrap" style="display: block;"></ul> <!-- 추가 구성 상품이 여기에 동적으로 삽입될 것입니다 -->
</div>

<script>
$(document).ready(function () {
    var productId = "${product.pdt_id}"; // JSP에서 렌더링된 pdt_id 값
    $("#btnTotalAmountUpdate").click();

    // AJAX로 추가 구성 상품을 가져오는 코드
    $.ajax({
        url: "/projectOhora/product/extraProducts.ajax",
        dataType: "json",
        type: "GET",
        data: { "product_id": productId },
        cache: false,
        success: function (data) {
            var $productList = $(".SP_prdAddSetList_wrap");

            $productList.empty(); // 기존 항목 초기화

            data.forEach(function(product) {
                var imageUrl = product.pdt_img_url !== "null" ? product.pdt_img_url : "../resources/images/prd_img/마롱네일1.jpg"; // 기본 이미지 설정
                var formattedAmount = product.pdt_amount ? Number(product.pdt_amount).toLocaleString() : "0";

                var productHtml = `
                    <li data-prd-num="\${product.pdt_id}" class="xans-record-">
                        <div class="SP_addSetInfo">
                            <div class="SP_addSetThumb">
                                <a href="/product/\${product.pdt_name}/\${product.pdt_id}/">
                                    <img src="\${imageUrl}" alt="\${product.pdt_name}" id="ec-add-product-composed-product-\${product.pdt_id}">
                                </a>
                            </div>
                            <div class="SP_prdAddSetList">
                                <ul style="padding-left: 10px;">
                                    <li class="SP_addSetList_tt">
                                        <div class="SP_prdAddSet_cont SP_prdAddSet_prdtt">\${product.pdt_name}</div>
                                    </li>
                                    <li class="desc">\${product.pdt_description}</li>
                                    <li class="add_prd_price">
                                        <div class="SP_prdAddSet_cont SP_prdAddSet_price">
                                            <span>\${formattedAmount}</span>원
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="btn add-opt-click">
                                <a href="javascript:void(0);" class="add-product-btn" data-id="\${product.pdt_id}" data-name="\${product.pdt_name}" data-price="\${formattedAmount}" onclick="lastPriceFunc();">추가</a>
                            </div>
                        </div>
                    </li>
                `;
                $productList.append(productHtml);
            });

            // `추가` 버튼 클릭 이벤트 핸들러
            $(document).on('click', ".btn.add-opt-click a", function() {
                var productId = $(this).data("id");
                var productName = $(this).data("name");
                var productPrice = $(this).data("price");
                
                
             // 쉼표 제거 후 숫자 변환
                var formattedPrice = Number(String(productPrice).replace(/,/g, "")) || 0;

             // 콘솔에 데이터 확인
                console.log("Product ID:", productId);
                console.log("Product Name:", productName);
                console.log("Product Price:", productPrice);

             	// 회색 영역에 해당 상품이 이미 추가되었는지 확인
                if ($(".add_product[data-option-add-index='" + productId + "']").length > 0) {
                    alert("해당 옵션이 이미 추가되었습니다.");
                    return; // 중복된 경우 추가하지 않음
                }

                // 동적으로 회색 영역에 추가할 상품 HTML 템플릿
                var additionalProductHtml = `
				    <div class="add_product" data-option-add-index="\${productId}">
				        <div class="product">
				            <p>\${productName}<br> - <span style="display: inline;">\${productName}</span></p>
				        </div>
				        <div class="quantity">
				            <a href="javascript:void(0);" id="selectedDown" class="down eAddProductQuantityDownClass" data-target="option_add_box\${productId}_down">-</a>
				            <input type="text" id="option_add_box\${productId}_quantity" name="quantity_opt[]" class="quantity_opt eAddProductQuantityClass" value="1" product-id="\${productId}" readonly>
				            <a href="javascript:void(0);" id="selectedUp" class="up eAddProductQuantityUpClass" data-target="option_add_box\${productId}_up">+</a>
				        </div>
				        <div class="right">
				            <span id="option_add_box\${productId}_price">
				                <input type="hidden" class="add_product_option_box_price" value="\${productPrice}" product-id="\${productId}">
				                <span class="ec-front-product-item-price" product-id="\${productId}">\${formattedPrice.toLocaleString()}</span>원
				            </span>
				        </div>
				        <div class="delete" onclick="removeProduct(\${productId})">
				            ×
				        </div>
				    </div>
				`;

                // 회색 영역에 추가구성상품 삽입
                $("#additional-product-list").append(additionalProductHtml);
                $("#btnTotalAmountUpdate").click();
                lastPriceFunc();
            });   
        },
        error: function () {
            alert("추가 구성 상품을 불러오는 중 오류가 발생했습니다.");
        }
    });
});

// 선택된 상품 삭제 함수
function removeProduct(productId) {
    $("tr[data-option-add-index='" + productId + "']").remove();
}
</script>



<table class="add_products" style="width: 100%">
    <tbody id="additional-product-list"></tbody>
</table>


<script>				 
    // 추가 구성상품 토글 function
	document.querySelector(".SP_prdAddSetToggle").onclick = function() {
	    var element = document.querySelector(".SP_prdAddSetList_wrap");
	    if (element.style.display === "none" || element.style.display === "") {
	        element.style.display = "block";  // 보이게 설정
	    } else {
	        element.style.display = "none";   // 숨기기
	    }
	};

	// 선택상품 삭제 function
	$(document).on("click", ".delete", function() {
	    $(this).closest(".add_product").remove();
	    $("#btnTotalAmountUpdate").click();
	    lastPriceFunc();
	});
	
	// 특정 class로 input값 가져오기 (배열로 반환)
	var quantityInputs = document.querySelectorAll(".quantity_opt");

	quantityInputs.forEach(function(input) {
	    console.log("input 총 갯수" + input.value); // 각 input의 값을 출력
	});
  </script>
  
  


  
              <!----------------------------------- 선택 상품 출력 영역 ----------------------------------->
              <div id="totalProducts" class="SP_totalProducts">
                <table border="0" summary="">
  </table>
  </div>
              <!----------------------------------- //선택 상품 출력 영역 ----------------------------------->
              <!----------------------------------- 최종 금액 ----------------------------------->
			  


              <div id="totalPrice" class="SP_totalPrice">
				    총 상품금액 (개수) : <span class="total SP_totalPriceNum"><strong><em id="totalAmount">0원</em></strong> <em id="totalQuantity">(0개)</em></span>
				</div>			
				

<script>
//추가상품 기능
//수량 증가 및 감소 기능
	$(document).on("click", "#selectedDown", function () {
		
	    const nextElement = $(this).next();
	    let value = parseInt(nextElement.val(), 10); // 값 가져오기 및 숫자로 변환
	    //console.log("값 확인 : " + value); // 값 확인용
	    
	    if(value > 1){
	    	value = value - 1;
	    	nextElement.val(value); // 증가된 값을 다시 설정
	    }else{
	    	alert("최소 주문수량은 1개입니다.");
	    }
	    
	 	// 현재 클릭된 버튼의 상품 정보를 가져옴
	    let productContainer = $(this).closest(".add_product"); // 상품 전체 컨테이너를 기준으로 접근
	    let optionProductPrice = parseInt(productContainer.find("input[type='hidden'].add_product_option_box_price").val().replace(/,/g, "")) || 0;;
	    let optionAmount = parseInt(productContainer.find("input[type='text'][name='quantity_opt[]']").val().replace(/,/g, "")) || 0;;

	    // 총 가격 계산
	    let totalOptionProductPrice = optionProductPrice * optionAmount;

	    // 현재 상품의 가격 업데이트
	    productContainer.find(".ec-front-product-item-price").text(totalOptionProductPrice.toLocaleString());
	    
	    $("#btnTotalAmountUpdate").click();
	    lastPriceFunc();
	    
	});
	
	
	$(document).on("click", "#selectedUp", function () {
		
		const prevElement = $(this).prev();
		let value = parseInt(prevElement.val(),10);
		//console.log("값 확인 : " + value); // 값 확인용
		if(value >= 1){
			value = value + 1;
			prevElement.val(value);
		}
		
		// 현재 클릭된 버튼의 상품 정보를 가져옴
	    let productContainer = $(this).closest(".add_product"); // 상품 전체 컨테이너를 기준으로 접근
	    let optionProductPrice = parseInt(productContainer.find("input[type='hidden'].add_product_option_box_price").val().replace(/,/g, "")) || 0;;
	    let optionAmount = parseInt(productContainer.find("input[type='text'][name='quantity_opt[]']").val().replace(/,/g, "")) || 0;;

	    // 총 가격 계산
	    let totalOptionProductPrice = optionProductPrice * optionAmount;

	    // 현재 상품의 가격 업데이트
	    productContainer.find(".ec-front-product-item-price").text(totalOptionProductPrice.toLocaleString());
	    
	    $("#btnTotalAmountUpdate").click();
	    lastPriceFunc();
	    
	});
	
	
	
	
	
	let allOptionsTotalPrice = 0; // 전역 변수로 초기화

	// 메인 상품 금액 변경
	let mainProductPrice = 0; // 메인 상품 1개 값
	let mainProductQuantity = 0; // 메인 상품 수량
	let totalMainProductPrice = 0; // 메인 상품 총 금액
	let safeMainProductQuantity; // null 체크한 메인 상품 수량

	// 메인 상품 정보 가져오기
	
	
	function calculateMainProductTotalPrice() {
		mainProductPrice = 0;
		mainProductQuantity = 0; 
		totalMainProductPrice = 0;
		
		mainProductPrice = parseInt($(".salesPrice").text().replace(/,/g, '')) || 0;
		//mainProductQuantity = parseInt($("#option_main_quantity").val().replace(/,/g, '')) || 0;
		safeMainProductQuantity = $("#option_main_quantity").val() ? parseInt($("#option_main_quantity").val().replace(/,/g, '')) : 0;
		
		totalMainProductPrice = safeMainProductQuantity * mainProductPrice;
	}
	
	

	// 추가 상품 금액 변경
	let optionProductPrice = 0; // 옵션 상품 각각의 금액
	let optionAmount = 0; // 옵션 상품 각각의 수량
	let totalOptionProductPrice = 0; // 옵션 상품 각각의 총 금액 (금액 x 수량)
	let safeOptionProductPrice; // null 체크한 옵션 상품 각각의 금액

	// 추가 상품 가격 가져오기
	//optionProductPrice = parseInt($("input[type='hidden'].add_product_option_box_price").val().replace(/,/g, '')) || 0;
	optionAmount = parseInt($("input[type='text'][name='quantity_opt[]']").val()) || 0;
	totalOptionProductPrice = safeOptionProductPrice * optionAmount;
	safeOptionProductPrice = $("input[type='hidden'].add_product_option_box_price").val() ? parseInt($("input[type='hidden'].add_product_option_box_price").val().replace(/,/g, '')) : 0;

	
	
	// 추가 상품의 총 금액을 표시
	$(".ec-front-product-item-price").text(totalOptionProductPrice.toLocaleString());

	// 모든 선택된 추가 상품의 총 가격의 합을 계산하는 함수
	function calculateAllOptionsTotalPrice() {
	    allOptionsTotalPrice = 0; // 초기화하여 이전 값 누적 방지
	    $(".ec-front-product-item-price").each(function() {
	        allOptionsTotalPrice += parseInt($(this).text().replace(/,/g, '')) || 0;
	    });
	}
	
	

	// 전체 합산 금액 계산 함수
	function lastPriceFunc() {
	    
		// 메인 상품 총 가격 
		calculateMainProductTotalPrice();
	    // 모든 옵션 가격 합을 다시 계산
	    calculateAllOptionsTotalPrice();

	    // 전체 합산 금액 계산
	    let lastPrice = totalMainProductPrice + allOptionsTotalPrice;

	    // 결과를 표시
	    $("#totalAmount").text(lastPrice.toLocaleString() + "원");

	    console.log("메인 상품 총 금액:", totalMainProductPrice);
	    console.log("옵션 상품 총 금액 합:", allOptionsTotalPrice);
	    console.log("최종 총 금액:", lastPrice);
	    
	}

	// 문서 로드 시 초기 계산 실행
	$(document).ready(function() {
    	lastPriceFunc();
	});


</script>











              <!----------------------------------- //최종 금액 ----------------------------------->
              <!----------------------------------- SP_detailBuyBn_wrap ----------------------------------->
                          <!----------------------------------- //SP_detailBuyBn_wrap ----------------------------------->
              <!-- 상세페이지 배너 -->
              <!--<img src="/web/_event/0427_event8ver3/PC_detail_app.jpg"/>-->
              <!--<a href="/product/list.html?cate_no=120"><img src="/web/_event/0427_event8ver3/PC_detail_app6.jpg"/></a>-->
              <!----------------------------------- 액션 버튼 영역 ----------------------------------->
				<div class="action_btn_wrap">
					<div class="xans-element- xans-product xans-product-action "
						style="width: 100%;">
						<div class="SP_totalPrdOrderBtn_wrap">
							<!-- //바로 구매 버튼 -->
							<a href="#none" class="SP_cm_btn SP_btn_black_bg SP_buyBtn "><span
								id="btnBuy">바로 구매</span></a>
							<!-- //바로 구매 버튼 -->
							<!-- 장바구니 버튼 -->
							<c:choose>
                        <c:when test="${userId != null}">
                           <a href="#none" class="SP_cm_btn SP_cartBtn " id="addCartBtn"
                           onclick="addtoCart();">장바구니 담기</a>
                        </c:when>
                        <c:otherwise>
                           <a href="#none" class="SP_cm_btn SP_cartBtn ">장바구니 담기</a>                        
                           <!-- //장바구니 버튼 -->
                        </c:otherwise>
                        </c:choose>
							<!-- //장바구니 버튼 -->
						</div>
						<div id="appPaymentButtonBox"
							style="margin: 20px auto 0; display: inline-flex; flex-wrap: wrap; gap: 10px;">
							<div id="kakao-checkout-button"></div>
						</div>
					</div>

				</div>

				<!----------------------------------- //액션 버튼 영역 ----------------------------------->
  <script>
  /* 바로구매 버튼 클릭 시 */
  $(document).on('click', 'a.SP_cm_btn.SP_btn_black_bg.SP_buyBtn', function(event) {
    event.preventDefault(); // 기본 링크 동작을 막음
    
    if ($("#option_main_quantity").length > 0) {
    	const mainValue = $("#option_main_quantity").val();
    	const mainProductId = $("#option_main_quantity").attr('product-id');
    	
    	console.log(mainValue, mainProductId);
    	
    	let queryParams = `pdtId=\${mainProductId}&pdtCount=\${mainValue}`;
    	
    	const values = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).val();
        }).get();
        
        const productIds = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).attr('product-id');
        }).get();
        
        productIds.forEach((id, index) => {
            const value = values[index];
            if (queryParams.length > 0) {
                queryParams += "&"; // 각 파라미터를 연결하기 위한 구분자
            }
            queryParams += `pdtId=\${encodeURIComponent(id)}&pdtCount=\${encodeURIComponent(value)}`;
        });
        console.log(queryParams);
         
     	// 동적으로 href 속성 설정
        const fullUrl = `/projectOhora/product/orderpage.do?\${queryParams}`;
        $(this).attr('href', fullUrl);

        // 기본 링크 동작을 막았기 때문에 원래 동작을 실행시켜 주기
        window.location.href = fullUrl;
        
    } else {
    	const values = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).val();
        }).get();
        
        const productIds = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).attr('product-id');
        }).get();
        
        console.log(productIds, values);
        
        
        // 파라미터 형식으로 이어붙이기
        let queryParams = "";

        productIds.forEach((id, index) => {
            const value = values[index];
            if (queryParams.length > 0) {
                queryParams += "&"; // 각 파라미터를 연결하기 위한 구분자
            }
            queryParams += `pdtId=\${encodeURIComponent(id)}&pdtCount=\${encodeURIComponent(value)}`;
        });
        console.log(queryParams);

        
        // 동적으로 href 속성 설정
        const fullUrl = `/projectOhora/product/orderpage.do?\${queryParams}`;
        $(this).attr('href', fullUrl);

        // 기본 링크 동작을 막았기 때문에 원래 동작을 실행시켜 주기
        window.location.href = fullUrl;
        
    }
    
    

    
 	
});


  </script>
  

              </div>
              <!------------------------- 배송 정보 / 오늘 도착 팝업------------------------------>
              <div class="deliver_con">
						<table>
							<tbody class="delvtype">
								<tr class="">
									<th scope="row">기본배송</th>
									<td class="delv_price">
										<div>기본 3,000원 (5만원 이상 구매 시 무료)</div>
										<div>제주 및 특수 도서 산간 지역 3,000원 추가</div>
									</td>
								</tr>
							</tbody>
						</table>
			  </div>
 
              </div>
              <!------------------------- //배송 정보 / 오늘 도착 팝업------------------------------>
            </div>

        </div>
  <!------------------------------ //SP_detailArea_wrap -------------------------------->



  </div>
      <!------------------------------ //product_detail 모듈 -------------------------------->
    </div>


      </div>
      <!------------------------------ //쿠폰 다운로드 -------------------------------->
    </div>
    <!------------------------------ //레이아웃 -------------------------------->
    <!------------------------------ SP_detailRelationPrd_wrap -------------------------------->
    <!------------------------------ 레이아웃 -------------------------------->
    <div class="SP_detailLayout" style="max-width: 1050px; margin: 0 auto;">
      <!------------------------------ product_additional -------------------------------->
      <div class="xans-element- xans-product xans-product-additional "><!------------------------------ 리뷰 -------------------------------->
      <div id="prdReview" class="ec-base-tab grid5">
          <!-------------------- 탭 영역 ------------------------->
          <ul class="SP_detailPrdTab_wrap">
      <li class="selected">
              <a href="#prdReview">리뷰 <b class="Brev crema-product-reviews-count crema-applied" data-product-code="2101" data-format="({{{count}}})" data-install-method="hardcoded" data-observed-install="false" data-applied-widgets="[&quot;.crema-product-reviews-count&quot;]">(${product.pdt_review_count})</b></a>
            </li>
            <li><a href="#prdDetail">상세정보</a></li>
            <!--li><a href="#recmdPrdWiget" class="best_design">추천디자인</a></li-->
            <li><a href="#prdQnA">쇼핑안내</a></li>
            <!--li><a href="#prdFAQ">FAQ</a></li-->
          </ul>
      <!-------------------- //탭 영역 ------------------------->
      <div class="SP_detailContainer">
            <div class="SP_detailContants">
              <div class="SP_detailBoard_wrap">
                <!-- <div class="review_img"><img src="/web/upload/review/reviewPlus_2.png"></div> -->
                <!-- cre.ma / 리스트 위젯 / 스크립트를 수정할 경우 연락주세요 (support@cre.ma) -->
                <style>
                  #prdReview .nodata {
                    display: none;
                  }
                </style>
    
      <div class="SP_dtailReveiwBoard_wrap">
          <div class="RV_wrap" style="margin-top: 32px; margin-bottom: 32px; ">
          	<div class="RV_box">
          	
          	<iframe src="<%=contextPath %>/review/reviewlist.do?pdt_id=${product.pdt_id}" style="    display: block; visibility: visible; height: 1407px; width: 100%; iframe::-webkit-scrollbar{ }"  >
          	</iframe>
          	
          	</div>
          </div>
      </div>
      </div>
                <div class="SP_tableBtn_wrap crema-hide crema-applied" data-install-method="hardcoded" data-observed-install="false" data-applied-widgets="[&quot;.crema-hide, .crema-review-hide&quot;]" style="display: none;">
                  <div class="SP_tableBtnAlign_right">
                    <a href="/board/product/list.html?board_no=4" class="SP_cm_btn SP_btn_black_w2_bd">모두보기</a>
                    <!-- <a href="/board/product/write.html?board_no=4&product_no=2101&cate_no=121&display_group=1" class="SP_cm_btn SP_btn_blue_bg">글쓰기</a> -->
                  </div>
                </div>
                
              </div>
            </div>
          </div>
        </div>
      <!------------------------------ //리뷰 -------------------------------->
      <!------------------------------ 상품 상세 정보 -------------------------------->
      <!-------------------- 탭 영역 ------------------------->
      <ul class="SP_detailPrdTab_wrap">
        <li>
    <a href="#prdReview">리뷰 <b class="Brev crema-product-reviews-count crema-applied" data-product-code="2101" data-format="({{{count}}})" data-install-method="hardcoded" data-observed-install="false" data-applied-widgets="[&quot;.crema-product-reviews-count&quot;]">(${product.pdt_review_count})</b></a>
        </li>
        <li class="selected"><a href="#prdDetail">상세정보</a></li>
        <!--li><a href="#recmdPrdWiget" class="best_design">추천디자인</a></li-->
        <li><a href="#prdQnA">쇼핑안내</a></li>
        <!--li><a href="#prdFAQ">FAQ</a></li-->
      </ul>
      <!-------------------- //탭 영역 ------------------------->
    
      
          <!-- 여기에 상품 설명 이미지 -->
          <div id="prdDetail" class="ec-base-tab grid5">
          	<div id="prdDetailinner" class="ec-base-tab grid6">
          		<img loading="lazy" src="https://www.ohora.kr/smartpc/_img/common/_detail/notice_final.jpg">
          		<img loading="lazy" src="https://www.ohora.kr/optimize/images/pc/detail/nail_Info.webp">
          	</div>
          </div>
      
            
              <!------------------------------ //상품 상세 정보 -------------------------------->
              <!--함께 많이 구매한 디자인, 크루 추천 영역 리뷰 하단으로 이동--->
              
              
              
              <!------------------------------------ 함께 많이 구매한 디자인 -------------------------------------->

			<div class="designBuyingWith">
				<div class="textArea">
					<h3>
						<strong>함께 많이 구매한 디자인</strong>
					</h3>
				</div>

				<div class="common_list_box">
					<div class="swiper-container swiper mySwiper">
						<ul class="items-swiper-wrapper2 swiper-wrapper">


						</ul>

						<div class="swiper-scrollbar"></div>

					</div>
					<!-- 스와이퍼 컨테이너 -->

				</div>


			</div>


			<script type="text/javascript">
                const monthlyProductList = [
                    <c:forEach var="product" items="${productList}" varStatus="status">
                        <c:if test="${status.index >= 20 && status.index < 8}">
            {
                id: ${product.pdt_id},
                name: "${product.pdt_name}",
                normalPrice: ${product.pdt_amount},
                salePrice: ${product.pdt_discount_amount},
                discount: ${product.pdt_discount_rate},
                imgUrl: "${product.pdt_img_url}",
                imgUrl2: "${product.pdt_img_url2}",
                reviewCount: ${product.pdt_review_count}
            }<c:if test="${status.index < 7}">,</c:if>
                        </c:if>
                    </c:forEach>
                ];
                console.log("Monthly Product List:", monthlyProductList);
            
                function createMonthlyProductItem(product) {
                    return `
                        <li id="item\${product.id}" class="item-swiper-slide swiper-slide">
            <div class="container-complete" data-prd-num="\${product.id}">
                <dl>
                    <a href="/projectOhora/product/view.do?product_id=\${product.id}" class="viewlink"></a>
                    <div class="base-img">
                        <div class="thumb">
                            <img loading="lazy" alt="" class="thumb_img" width="800" height="800" src="\${product.imgUrl}">
                        </div>
                        <span class="soldout-img" style="display: none">
                            <a href="/projectOhora/product/view.do?product_id=\${product.id}">
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
                                    <p class="rv_count_wrap"><span class="rv_count_value">\${product.reviewCount}</span></p>
                                </div>
                            </div>
                        </div>
                        <div class="into_cart">
                            <img class="cart_icon" src="https://img.echosting.cafe24.com/design/skin/admin/ko_KR/btn_list_cart.gif" alt="카트 아이콘" onclick="addToCart(\${product.id})">
                        </div>
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
            </script>
            
              <!------------------------------------  //함께 많이 구매한 디자인 -------------------------------------->
              <!---------------------------------------- 오호라 크루 추천 ------------------------------------------->
            	<div class="prdDetail_crew not_slide">
            		<!--오호라 크루 추천-->
            		<div class="common_reco_section recommend_crew swiper-container">
            			<h3>오호라 크루 추천</h3>
            			<div df-banner-code="common-recommend"
            				class="recommend_banner_wrap swiper-wrapper df-bannermanager df-bannermanager-common-recommend">
            				<div df-banner-clone="" class="SP_eventBn_li swiper-slide">
            					<a
            						href="https://events.payco.com/web/share.nhn?evntPageNm=75c7Pl3&amp;pubCode=PUBSTJUOE9"><div
            							class="imgBox">
            							<img
            								src="	https://www.ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/94fad6d6474acf635b9c771591480a7c.png"
            								alt="페이코 상시 12% 할인">
            						</div>
            						<div class="txtBox">페이코 상시 12% 할인</div></a>
            				</div>
            				<div df-banner-clone="" class="SP_eventBn_li swiper-slide">
            					<a
            						href="https://play.google.com/store/apps/details?id=com.cafe24.ec.plusohora2019"><div
            							class="imgBox">
            							<img
            								src="https://www.ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/4cd90f97beaaeddde49bbad02da10bc5.webp"
            								alt="앱 다운 시 무료배송">
            						</div>
            						<div class="txtBox">앱 다운 시 무료배송</div></a>
            				</div>
            				<div df-banner-clone="" class="SP_eventBn_li swiper-slide">
            					<a href="https://www.ohora.kr/event/event6.html">
            					<div class="imgBox">
            							<img
            								src="https://www.ohora.kr/web/upload/appfiles/ZaReJam3QiELznoZeGGkMG/0b48933209882b54093f40d23cb23246.webp"
            								alt="신규회원 젤램프 증정">
            					</div>
            						<div class="txtBox">신규회원 젤램프 증정</div>
            				</div>
            			</div>
            			<!-- Add Pagination -->
            			<div class="swiper-scrollbar"></div>
            		</div>
            	</div>
            						<!--// 오호라 크루 추천-->
              <!--------------------------------------// 오호라 크루 추천 ------------------------------------------->
              <!-------------------- 탭 영역 ------------------------->
              <ul class="SP_detailPrdTab_wrap">
                <li>
                  <a href="#prdReview">리뷰 <b class="Brev crema-product-reviews-count crema-applied" data-product-code="2101" data-format="({{{count}}})" data-install-method="hardcoded" data-observed-install="false" data-applied-widgets="[&quot;.crema-product-reviews-count&quot;]">(${product.pdt_review_count})</b></a>
                </li>
                <li><a href="#prdDetail">상세정보</a></li>
                <li class="selected"><a href="#prdQnA">쇼핑안내</a></li>
              </ul>       
              <!-------------------- //탭 영역 ------------------------->
              <div id=prdQnA class="SP_detailContainer">
                          <div class="SP_detailContants">
            <div class="SP_detailBoard_wrap">
              <h3 class="infoTit">배송안내</h3>
              <!--
                            <table class="infoTbl">
                                <colgroup>
                                    <col width="215px"/>
                                    <col width="*"/>
                                </colgroup>
                                <tr>
                                    <th>배송방법</th>
                                    <td>CJ대한통운(1588-1255) , 한진택배(1588-0011)</td>
                                </tr>
                                <tr>
                                    <th>배송지역</th>
                                    <td>전국</td>
                                </tr>
                                <tr>
                                    <th>배송비</th>
                                    <td>3,000원 (5만원 이상 구매 시 무료배송)<br/>
                                        * 제주 및 특수 도서 산간 지역은 별도 추가 운임 발생</td>
                                </tr>
                                <tr>
                                    <th>배송기간</th>
                                    <td>
                                        <b>* 출고일로부터 평균 2~3일 정도 소요됩니다. (주말/공휴일 제외)</b><br/>
                                        <b>* 상품 출고 시 송장 번호가 알림톡 또는 SMS로 발송됩니다.</b><br/>
                                        <b>* 모든 배송은 지역 택배사 사정과 천재지변으로 지연될 수 있습니다.</b><br/>
                                        <b>* 배송 폭주, 입고지연, 품절 등으로 인한 미출고 시 별도 안내 드립니다.</b>										
                                    </td>
                                </tr>
                                <tr>
                                    <th>주의사항</th>
                                    <td><b>* 주문 내역의 교환/취소/주소지 변경을 원하실 경우 고객센터로 연락 바랍니다.</b><br/>
                                        <b>* 주문 취소를 희망하는 경우 MY PAGE -> 주문 상세정보에서 직접 가능합니다.</b><br/>
                                        (상품 준비 중인 상태에서만 가능하며, 배송 준비 중/배송 중 상태에서는 추가 배송비가 부가될 수 있습니다.)</td>
                                </tr>
                                <tr>
                                    <th>고객센터</th>
                                    <td>1566-0554 / 카카오톡 플러스친구 @ohora <br/>
                                운영시간 : 365일 09:00 - 18:00 (점심시간 11:50 - 13:00)
                                </tr>
                            </table>
                            -->
              <table class="infoTbl">
              <colgroup>
              <col width="215px">
              <col width="*">
              </colgroup>
              <tbody><tr>
              <th>배송방법</th>
                  <td>
              <b> 기본 배송 : 롯데택배(1588-2121) </b><br>
              </td>
                </tr>
              <tr>
              <th>배송지역</th>
                  <td>
              <b> 기본 배송 : 전국</b><br>
              </td>
                </tr>
              <tr>
              <th>배송비</th>
                  <td>
                    <b> 기본 배송 : 3,000원 (5만원 이상 구매 시 무료배송)</b><br>
                    * 제주 및 특수 도서 산간 지역은 3,000원의 별도 추가 운임비 발생<br>
              </td>
                </tr>
              <tr>
              <th>배송기간</th>
                  <td>
                    <b>[기본 배송]</b><br><b>* 평일 오후 2시 결제 완료 시 당일 출고됩니다. (주말/공휴일 제외)</b><br><b>* 상품 출고 시 송장 번호가 알림톡 또는 SMS로 발송됩니다.</b><br><b>* 모든 배송은 지역 택배사 사정과 천재지변으로 지연될 수 있습니다.</b><br><b>* 배송 폭주, 입고지연, 품절 등으로 인한 미출고 시 별도 안내 드립니다.</b> <br>
              </td>
                </tr>
              <tr>
              <th>주의사항</th>
                  <td>
                    <b>* 주문 내역의 교환/취소/주소지 변경을 원하실 경우 고객센터로 연락 바랍니다.</b><br><b>* 주문 취소를 희망하는 경우 MY PAGE -&gt; 주문 상세정보에서 직접 접수 가능합니다.</b><br>
                    (배송준비중 상태의 주문 건을 취소 접수할 경우, 출고 상황에 따라 취소가 거부될 수 있습니다.)<br>
              </td>
                </tr>
              <tr>
              <th>고객센터</th>
                  <td>
                    카카오톡 상담 (@ohora), 게시판 상담 (1:1 문의하기) <br>
                    운영시간 : 평일 09:00 - 18:00 (Lunch 12:30 - 13:30) <br>
              </td>
                </tr>
              </tbody></table>
              <br>
              <br>
            
              <h3 class="infoTit">교환/반품 안내</h3>
              <table class="infoTbl">
              <colgroup>
              <col width="215px">
              <col width="*">
              </colgroup>
              <tbody><tr>
              <th>교환/반품 신청기준</th>
                  <td>
                    <b>&lt;교환/반품 신청이 가능한 경우&gt;</b><br>
                    * 단순 변심으로 인한 교환 및 반품은 <b>제품 수령 후 주말 및 공휴일 포함 7일 이내</b>에 가능합니다. (배송비 고객부담)<br>
                    * 상품 불량으로 인한 교환 및 반품은 상품 공급일로부터 3개월 이내에 가능합니다. (기간엄수)<br>
                    (단, 상품 불량의 경우, 고객센터를 통한 불량 검수 후 정상 처리 여부가 결정됩니다.)<br>
                    * 옵션 오선택으로 인한 반품 및 교환 시에는 추가 배송비가 발생할 수 있습니다.<br>
                    * 상품 불량으로 인한 반품 및 교환을 원하시는 경우, 카톡 플러스친구 상담으로 접수 부탁드립니다.<br>
                    (불량 여부 확인 및 제품 품질 개선을 위하여 내용물 사진 등 제품에 대한 상세한 정보를 준비 부탁드립니다.)<br><br><b>&lt;교환/반품이 불가능한 경우&gt;</b><br>
                    * 소비자의 귀책 사유에 의한 상품 훼손(개봉) 및 사용에 의해 상품 가치가 현저히 감소한 경우 교환 및 반품이 불가합니다.<br>
                    * 교환 및 반품으로 인해 사은품 혜택 기준에 미달되었을 경우, 사은품도 함께 보내주셔야 정상적으로 처리 가능합니다.<br>
              </td>
                </tr>
              <tr>
              <th>교환/반품 배송비</th>
                  <td>제품 하자가 아닌 단순 변심에 의한 경우 배송비를 제외한 나머지 금액만 환불 처리됩니다.</td>
                </tr>
              <tr>
              <th>교환/반품 접수방법</th>
                  <td>
                    * 교환 및 반품 접수 문의는 고객센터로 연락 부탁드립니다.<br>
                    * 제품 수거는 교환 및 반품 신청 접수 후 오호라에서 순차 처리합니다.
                  </td>
                </tr>
              <tr>
              <th>주의사항</th>
                  <td>* 교환 및 반품 신청 시 신청 가능 기간을 엄수해주세요.</td>
                </tr>
              <tr>
              <th>고객센터</th>
                  <td>
                    카카오톡 상담 (@ohora), 게시판 상담 (1:1 문의하기) <br>
                    운영시간 : 평일 09:00 - 18:00 (Lunch 12:30 - 13:30) <br>
              </td>
                </tr>
              </tbody></table>
              					</div>
                         </div> 
                          
                        </div><!-- 여기까지 배송이랑 QnA -->
      <!------------------------------ //prdQnA --------------------------------->
    
        </div> <!-- <div id="prdDetail" class="ec-base-tab grid5">까지 -->
        <!------------------------------ //SP_detailRelationPrd_wrap -------------------------------->
      </div>
 


	<script>

	$("#btnTotalAmountUpdate").on("click", function inputUpdate() {
		
		let totalCountSum = 0;
	
		$("input[id^='option_']").each(function() {
		    // 각 input 요소의 value 값을 숫자로 변환하여 누적 합산
		    totalCountSum += parseFloat($(this).val()) || 0; // NaN 방지를 위해 기본값 0 사용
		});
	
		$("#totalQuantity").text("(" + totalCountSum + "개)");
		console.log("총 input 갯수 : " + totalCountSum); // 모든 값의 합계가 출력됩니다.
	
	})
	
	
	$(document).on("input", "input[id^='option_']", function () {
    let totalCountSum = 0;
    
    $("input[id^='option_']").each(function() {
        // 각 input 요소의 value 값을 숫자로 변환하여 누적 합산
        totalCountSum += parseFloat($(this).val()) || 0; // NaN 방지를 위해 기본값 0 사용
    });

    $("#totalQuantity").text("(" + totalCountSum + "개)");
    console.log("총 input 갯수 : " + totalCountSum); // 모든 값의 합계가 출력됩니다.
});

</script>

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
  
  <script>
// 장바구니 버튼
$("#addCartBtn").on("click", function(){
   
   event.preventDefault(); // 기본 링크 동작을 막음
    
    if ($("#option_main_quantity").length > 0) {
       const mainValue = $("#option_main_quantity").val();
       const mainProductId = $("#option_main_quantity").attr('product-id');
       
       console.log(mainValue, mainProductId);
       
       let queryParams = `pdtId=\${mainProductId}&pdtCount=\${mainValue}`;
       
       const values = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).val();
        }).get();
        
        const productIds = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).attr('product-id');
        }).get();
        
        productIds.forEach((id, index) => {
            const value = values[index];
            if (queryParams.length > 0) {
                queryParams += "&"; // 각 파라미터를 연결하기 위한 구분자
            }
            queryParams += `pdtId=\${encodeURIComponent(id)}&pdtCount=\${encodeURIComponent(value)}`;
        });
        console.log(queryParams);
         
        // 동적으로 href 속성 설정
        const fullUrl = `/projectOhora/product/addcartbtn.do?\${queryParams}`;
        $(this).attr('href', fullUrl);

        // 기본 링크 동작을 막았기 때문에 원래 동작을 실행시켜 주기
        window.location.href = fullUrl;
        
    } else {
       const values = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).val();
        }).get();
        
        const productIds = $("input[type='text'][name='quantity_opt[]']").map(function() {
            return $(this).attr('product-id');
        }).get();
        
        console.log(productIds, values);
        
        
        // 파라미터 형식으로 이어붙이기
        let queryParams = "";

        productIds.forEach((id, index) => {
            const value = values[index];
            if (queryParams.length > 0) {
                queryParams += "&"; // 각 파라미터를 연결하기 위한 구분자
            }
            queryParams += `pdtId=\${encodeURIComponent(id)}&pdtCount=\${encodeURIComponent(value)}`;
        });
        console.log(queryParams);

        
        // 동적으로 href 속성 설정
        const fullUrl = `/projectOhora/product/addcartbtn.do?\${queryParams}`;
        $(this).attr('href', fullUrl);

        // 기본 링크 동작을 막았기 때문에 원래 동작을 실행시켜 주기
        window.location.href = fullUrl;
        
    }
   
});
</script>
<script src="/projectOhora/resources/js/oho_main.js"></script>

<script>
// 쿠키 설정 함수
function setCookie(name, value, days) {
    let expires = '';
    if (days) {
        const date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        expires = '; expires=' + date.toUTCString();
    }
    document.cookie = name + '=' + encodeURIComponent(value) + expires + '; path=/';
}

// 쿠키 가져오기 함수
function getCookie(name) {
    const nameEQ = name + '=';
    const ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) === 0) return decodeURIComponent(c.substring(nameEQ.length, c.length));
    }
    return null;
}

$(document).ready(function() {
    $(".SP_cartBtn").on("click", function() {
        if (window.hasProductCountSession) {
            return;
        }
        
        // 장바구니에 담을 상품들을 저장할 배열
        let cartItems = [];
        
        // 메인 상품이 있는 경우 처리
        const mainQuantityInput = document.getElementById("option_main_quantity");
        if (mainQuantityInput) {
            cartItems.push({
                id: mainQuantityInput.getAttribute('product-id'),
                quantity: parseInt(mainQuantityInput.value)
            });
        }
        
        // 추가 상품들 처리
        const additionalProducts = document.querySelectorAll(".quantity_opt");
        additionalProducts.forEach(product => {
            cartItems.push({
                id: product.getAttribute('product-id'),
                quantity: parseInt(product.value)
            });
        });
        
        // 기존 장바구니 쿠키 확인
        let existingCart = getCookie('basketItems');
        let updatedCart = [];
        
        if (existingCart) {
            try {
                updatedCart = JSON.parse(existingCart);
                
                // 새로운 아이템들을 기존 장바구니에 추가/업데이트
                cartItems.forEach(newItem => {
                    const existingItemIndex = updatedCart.findIndex(item => item.id === newItem.id);
                    
                    if (existingItemIndex !== -1) {
                        // 기존 상품이 있으면 수량 증가
                        updatedCart[existingItemIndex].quantity += newItem.quantity;
                    } else {
                        // 새로운 상품이면 추가
                        updatedCart.push(newItem);
                    }
                });
            } catch (e) {
                console.error('장바구니 쿠키 파싱 오류:', e);
                updatedCart = cartItems;
            }
        } else {
            updatedCart = cartItems;
        }
        
        // 쿠키에 장바구니 저장 (24시간 유효)
        setCookie('basketItems', JSON.stringify(updatedCart), 1);
        
        // 장바구니 카운트 업데이트 (header.jsp의 함수 호출)
        if (typeof updateCartCountFromCookie === 'function') {
            updateCartCountFromCookie();
        }
        
        alert('상품이 장바구니에 담겼습니다.');
    });
    
    // 초기 계산 실행
    lastPriceFunc();
});
</script>


</body>
   
</html>
