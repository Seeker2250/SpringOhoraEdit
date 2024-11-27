<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오호라 팀 프로젝트</title>
<link rel="shortcut icon" type="image/x-icon" href="../resources/images/favicon.ico">
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/ordercheck_nolog.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="google" content="notranslate">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
.xans-board-readpackage-8 .SP_cm_btn.SP_btn_gray_bd {
	display: inline-block !important;
}
</style>
</head>
<%@include file="header.jsp" %>
<body>
	 <div id="container">
      <div id="contents">
        <div id="SMS_login_warp" class="login_container SP_layoutFix">
          <form
            id="historyNoLoginForm"
            name
            action="/exec/front/MyShop/OrderHistoryLogin/"
            method="POST"
            target="_self"
            enctype="multipart/form-data"
            data-gtm-form-interact-id="1"
          >
            <div
              id
              class="xans-element- xans-myshop xans-myshop-orderhistorynologin"
            >
              <div class="guestBnrArea">
                <div class="titleArea">
                  <p>
                    회원가입 후 첫 구매시, <br /><strong
                      >오호라 젤 램프를 선물</strong
                    >로 드립니다.
                  </p>
                  <p>(18,000원 상당)</p>
                </div>
              </div>

              <fieldset>
                <div class="formBox">
                  <div class="form no_login">
                    <div>
                      <span>주문자 명</span>
                      <input
                        id="order_name"
                        name="order_name"
                        fw-filter="isFill"
                        fw-label="주문자명"
                        fw-msg=""
                        class="inputTypeText"
                        placeholder=""
                        value=""
                        type="text"
                      />
                    </div>
                    <div>
                      <span>주문번호(하이픈(-)포함)</span>
                      <input
                        id="order_id"
                        name="order_id"
                        maxlength="18"
                        fw-filter="isOrderid&amp;isFill"
                        fw-label="주문번호"
                        fw-msg=""
                        value=""
                        type="text"
                        placeholder=""
                        title="주문번호"
                        data-gtm-form-interact-field-id="2"
                      />
                    </div>
                    <div>
                      <span>비회원 주문 패스워드</span>
                      <input
                        id="order_password"
                        name="order_password"
                        fw-filter="isFill"
                        fw-label="비회원주문 비밀번호"
                        fw-msg=""
                        value=""
                        type="password"
                        placeholder=""
                        data-gtm-form-interact-field-id="3"
                      />
                    </div>
                  </div>
                  <div class="btnArea type1">
                    <button
                      type="button"
                      class="btnSubmit SMSnomem_order_btnBuyTD wh"
                      onclick="$('#historyNoLoginForm').submit();"
                    >
                      조회하기
                    </button>
                  </div>
                  <div class="btnJoin btnArea type1">
                    <a
                      href="<%= contextPath %>/ohora.do?signUpfast=signUpfast"
                      class="btnEm SMSjoin_btnTD wh"
                      >회원가입 후 혜택받기</a
                    >
                  </div>
                  <div class="help">
                    <p>비회원인 경우, 주문번호로만 주문조회가 가능합니다.</p>
                  </div>
                </div>
              </fieldset>
            </div>
          </form>
        </div>
      </div>
    </div>
</body>
</html>