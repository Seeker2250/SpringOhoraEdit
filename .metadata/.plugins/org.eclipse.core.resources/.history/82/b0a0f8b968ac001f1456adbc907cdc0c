<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오호라 팀 프로젝트</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/addr_manage.css">
<script src="http://localhost/jspPro/resources/cdn-main/example.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
      <%@include file="header.jsp" %>
 <body>
	  <div id="SP_mypage_wrap">
      <div class="SP_layoutFix">
        <div class="SP_subSection">
          <h2 class="SP_subTitle Nunito_Sans_font">
            <span class="eng_font" style="font-family: 'Libre Baskerville', 'Noto Sans KR', sans-serif !important;">배송 주소록 관리</span>
          </h2>
        </div>

        <form
          id="frmAddr"
          name="frmAddr"
          action="<%=contextPath%>/member/addressModify.do"
          method="post"
        >
          <input
            id="__address_addr1"
            name="__address_addr1"
            value=""
            type="hidden"
          />
          <input id="__city_name" name="__city_name" value="" type="hidden" />
          <input id="__state_name" name="__state_name" value="" type="hidden" />
          <input
            id="__isRuleBasedAddrForm"
            name="__isRuleBasedAddrForm"
            value=""
            type="hidden"
          />
          <input
            id="__use_foreign_country_list"
            name="__use_foreign_country_list"
            value="F"
            type="hidden"
          />
          <input
            id="__ma_rcv_contry_code"
            name="__ma_rcv_contry_code"
            value=""
            type="hidden"
          />
          <input id="__country" name="__country" value="" type="hidden" />
          <input id="__province" name="__province" value="" type="hidden" />
          <input id="__city" name="__city" value="" type="hidden" />
          <input id="__district" name="__district" value="" type="hidden" />
          <input
            id="is_display_phone"
            name="is_display_phone"
            value=""
            type="hidden"
          />
          <input
            id="is_display_mobile"
            name="is_display_mobile"
            value="T"
            type="hidden"
          />
          <input
            id="sUseCountryNumberFlag"
            name="sUseCountryNumberFlag"
            value="T"
            type="hidden"
          />
          <input
            id="16dc"
            name="16dc"
            value="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJtIjoib2hvcmEyMDE5IiwicyI6IjFjZDQ3NWU0YTQxNzc5NGZhZTE1OTE5OTk2OTc4YmI3IiwidCI6MTczMDg1MTQ3MywiciI6Ind3dy5vaG9yYS5rciJ9.gHX_wM8r7C8nZMmHPgluxwXRKHE8Ys0NbCQlm0G0N8YGOUNHD1uGbBWgHtBY5BY0H64x9vosgdClW28k6dVlCQ"
            type="hidden"
          />
          <div class="xans-element- xans-myshop xans-myshop-addrregister">
            <!--
            $return_url = /myshop/addr/list.html
          -->
            <div class="SP_chgAdressTable_wrap SP_subSection">
              <table border="1" summary="" class="SP_tableSt01_isThAndTd type2" style="border-bottom: 1px solid #eeeeee;
   				 border-top: 1px solid #eeeeee;">
                <colgroup>
                  <col style="width: 120px" />
                  <col style="width: auto" />
                </colgroup>
                <tbody>
                  <tr>
                    <th scope="row">
                      배송지명
                      <img
                        src="https://img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif"
                        alt="필수"
                      />
                    </th>
                    <td>
                      <input
                        id="ma_rcv_title"
                        name="ma_rcv_title"
                        fw-filter="isFill&amp;isMaxByte[90]"
                        fw-label="배송지명"
                        fw-msg=""
                        class="inputTypeText"
                        placeholder=""
                        value=""
                        type="text"
                      />
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">
                      성명
                      <img
                        src="https://img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif"
                        alt="필수"
                      />
                    </th>
                    <td>
                      <input
                        id="ma_rcv_name"
                        name="ma_rcv_name"
                        fw-filter="isFill&amp;isMaxByte[90]"
                        fw-label="성명"
                        fw-msg=""
                        class="ec-member-name"
                        placeholder=""
                        value=""
                        type="text"
                      />
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">
                      주소
                      <img
                        src="https://img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif"
                        alt="필수"
                      />
                    </th>
                    <td>
                      <input
                        id="address_zip1"
                        name="address_zip1"
                        fw-filter="isMin[3]&amp;isMax[8]"
                        fw-label="우편번호"
                        fw-msg=""
                        class="inputTypeText"
                        placeholder=""
                        readonly="readonly"
                        maxlength="14"
                        value=""
                        type="text"
                      />                   
                      <a
                        href="#none"
                        class="SP_cm_btn SP_btn_gray_bg"
                        onclick="postCode();"
                        id="SearchAddress"
                        style="background: #111; color: #fff;"
                        >우편번호</a
                      ><br />
                      <input
                        id="address_addr1"
                        name="address_addr1"
                        fw-filter=""
                        fw-label="주소"
                        fw-msg=""
                        class="inputTypeText"
                        placeholder=""
                        readonly="readonly"
                        value=""
                        type="text"
                      />
                      기본주소<br />
                      <input
                        id="address_addr2"
                        name="address_addr2"
                        fw-filter="isFill"
                        fw-label="주소"
                        fw-msg=""
                        class="inputTypeText"
                        placeholder=""
                        value=""
                        type="text"
                      />
                      나머지주소<span class="displaynone">(선택입력가능)</span>
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">
                      일반전화
                      <span class="displaynone"
                        ><img
                          src="https://img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif"
                          alt="필수"
                      /></span>
                    </th>
                    <td>
                      <select
                        id="ma_rcv_phone1"
                        name="ma_rcv_phone[]"
                        fw-filter="isNumber"
                        fw-label="유선전화"
                        fw-alone="N"
                        fw-msg=""
                        style=" -webkit-appearance:none; /* 크롬 화살표 없애기 */
								    -moz-appearance:none; /* 파이어폭스 화살표 없애기 */
								    appearance:none /* 화살표 없애기 */"
                      >
                        <option value="02">02</option>
                        <option value="031">031</option>
                        <option value="032">032</option>
                        <option value="033">033</option>
                        <option value="041">041</option>
                        <option value="042">042</option>
                        <option value="043">043</option>
                        <option value="044">044</option>
                        <option value="051">051</option>
                        <option value="052">052</option>
                        <option value="053">053</option>
                        <option value="054">054</option>
                        <option value="055">055</option>
                        <option value="061">061</option>
                        <option value="062">062</option>
                        <option value="063">063</option>
                        <option value="064">064</option>
                        <option value="0502">0502</option>
                        <option value="0503">0503</option>
                        <option value="0504">0504</option>
                        <option value="0505">0505</option>
                        <option value="0506">0506</option>
                        <option value="0507">0507</option>
                        <option value="070">070</option>
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="018">018</option>
                        <option value="019">019</option>
                        <option value="0508">0508</option></select
                      >-<input
                        id="ma_rcv_phone2"
                        name="ma_rcv_phone[]"
                        maxlength="4"
                        fw-filter="isNumber"
                        fw-label="유선전화"
                        fw-alone="N"
                        fw-msg=""
                        value=""
                        type="text"
                      />-<input
                        id="ma_rcv_phone3"
                        name="ma_rcv_phone[]"
                        maxlength="4"
                        fw-filter="isNumber"
                        fw-label="유선전화"
                        fw-alone="N"
                        fw-msg=""
                        value=""
                        type="text"
                      />
                    </td>
                  </tr>
                  <tr>
                    <th scope="row">
                      휴대전화
                      <span class=""
                        ><img
                          src="https://img.echosting.cafe24.com/skin/base/common/ico_required_blue.gif"
                          alt="필수"
                      /></span>
                    </th>
                    <td>
                      <select
                        id="ma_rcv_mobile_no1"
                        name="ma_rcv_mobile_no"
                        fw-filter="isNumber&amp;isFill"
                        fw-label="휴대전화"
                        fw-alone="N"
                        fw-msg=""
                          style=" -webkit-appearance:none; /* 크롬 화살표 없애기 */
								    -moz-appearance:none; /* 파이어폭스 화살표 없애기 */
								    appearance:none /* 화살표 없애기 */"
                      >
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="017">017</option>
                        <option value="018">018</option>
                        <option value="019">019</option>
                        </select>
                        -<input
                        id="ma_rcv_mobile_no2"
                        name="ma_rcv_mobile_no2"
                        maxlength="4"
                        fw-filter="isNumber&amp;isFill"
                        fw-label="휴대전화"
                        fw-alone="N"
                        fw-msg=""
                        placeholder=""
                        value=""
                        type="text"
                      />-<input
                        id="ma_rcv_mobile_no3"
                        name="ma_rcv_mobile_no3"
                        maxlength="4"
                        fw-filter="isNumber&amp;isFill"
                        fw-label="휴대전화"
                        fw-alone="N"
                        fw-msg=""
                        placeholder=""
                        value=""
                        type="text"
                      />
                    </td>
                  </tr>
                  
                </tbody>
              </table>
            </div>
            <div class="SP_tableBtn_wrap">
              <div class="SP_tableBtnAlign_right">
                <a href="javascript:void(0);"
                  class="SP_cm_btn SP_btn_gray_bd" 
                  onclick="myAddrUpdate()">등록</a>
                  
                <a href="" class="SP_cm_btn SP_btn_gray_bd">취소</a>
              </div>
            </div>
          </div>
        </form>
        <div class="SP_pageGuideText_wrap SP_subSection" style="background-color: #fff">
          <h3 class="SP_pageGuideTxt_tt">배송주소록 유의사항</h3>
          <div class="SP_pageGuideTxt_cont">
            <ol>
              <li class="item1">
                배송 주소록은 최대 10개까지 등록할 수 있으며, 별도로 등록하지
                않을 경우 최근 배송 주소록 기준으로 자동 업데이트 됩니다.
              </li>
              <li class="item2">
                자동 업데이트를 원하지 않을 경우 주소록 고정 선택을 선택하시면
                선택된 주소록은 업데이트 대상에서 제외됩니다.
              </li>
              <li class="item3">
                기본 배송지는 1개만 저장됩니다. 다른 배송지를 기본 배송지로
                설정하시면 기본 배송지가 변경됩니다.
              </li>
            </ol>
          </div>
        </div>
      </div>
    </div>
      <%@include file="footer.jsp" %>
    </body>
    <script type="text/javascript" src="/projectOhora/resources/js/addr_manage.js"></script>
</html>