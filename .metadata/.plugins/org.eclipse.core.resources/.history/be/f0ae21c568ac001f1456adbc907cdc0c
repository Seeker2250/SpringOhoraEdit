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
<link rel="stylesheet" href="/projectOhora/resources/cdn-main/oho_memInfo.css">

<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<%@include file="header.jsp" %>
<body>
    <div id="container">
        <div id="contents">

            <div class="subSection">
                <h2 class="subTitle">
                    <span>member modify</span>
                </h2>
            </div>

            <div id="member-edit-cont">
                <div class="mem-edit-layout">
                    <form action="${pageContext.request.contextPath}/member/modifyDone.do" method="post" id="editForm" name="editForm"  onsubmit="combinePhoneNumber();">
                        <!-- form 상단에 엄청난 인풋들이 히든으로 숨겨져 있으나 용도를 알 수 없음(아마 암호화 관련?). 생략 -->


                        <div class="member-edit-wrap">
                         <!-- 멤버 에딧 랩 == xans-element- xans-member xans-member-edit -->

                            <div class="edit-table-wrap">

                                <div class="edit-table-top-wrap">
                                    <div class="table-title">기본정보</div>
                                    <div class="pilsu-wrap">
                                        <span class="th-required" style="font-size: 16px;">*</span>
                                        <span class="required">필수입력사항</span>
                                    </div>
                                </div>

                                <div class="memeber-info-container">

                                    <table>
                                        <colgroup>
                                            <col style="width:200px;">
                                            <col style="width:auto;">
                                        </colgroup>

                                        <tbody>
                                            <tr>
                                                <th scope="row">
                                                    <!-- 행으로 보는 표라는 뜻 -->
                                                    <span class="th-title">아이디</span>
                                                    <span class="th-required">*</span>
                                                </th>
                                                <td>
                                                    <input type="text" readonly="readonly" id="member-id" name="member-id" value="${user.user_login_id}">
                                                
                                                    <span class="SP_stxt">(영문소문자/숫자, 4~16자)</span>
                                                </td>
                                            </tr>
                                            
                                            <tr>
                                                <th scope="row">
                                                    <span class="th-title">비밀번호</span>
                                                    <span class="th-required">*</span>
                                                </th>
                                                <td>
                                                    <input type="password"  id="passwd" name="passwd" maxlength="16" value="">
                                                    <div class="pw-guideBox-wrap">
                                                        <div class="pw-guideBox">
                                                            <div class="pw-guide-content">
                                                                <div class="pw-guide-tit">※ 비밀번호 입력 조건</div>
                                                                <div class="pw-guide-list">
                                                                    - 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자<br>
                                                                    - 입력 가능 특수문자 <br>&nbsp;&nbsp;&nbsp;  ~ ` ! @ # $ % ^ ( ) * _ - = { } [ ] | ; : &lt; &gt; , . ? /<br>
                                                                    - 공백 입력 불가능<br>
                                                                    - 연속된 문자, 숫자 사용 불가능<br>
                                                                    - 동일한 문자, 숫자를 반복해서 사용 불가능<br>
                                                                    - 아이디 포함 불가능               
                                                                    <!-- 입력 창에 포커스가면 튀어나옴 -->
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="pw-guide2">
                                                        (영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8자~16자)
                                                    </div>
                                                </td>
                                            </tr>

                                            <tr>
                                               <th scope="row">
                                                <span class="th-title">비밀번호 확인</span>
                                                <span class="th-required">*</span>
                                               </th> 
                                               <td>
                                                    <input type="password" id="passwd-confirm" name="passwd-confirm" maxlength="16" value="">
                                                    <span id="pwConfirmMsg" class=""></span>
                                                    <!-- 이 span은 비밀번호 확인 다르게 입력하면 class에 error 추가되면서 글 튀어나옴 -->
                                               </td>
                                            </tr>

                                            <tr>
                                                <th scope="row">
                                                    <span class="th-title">이름</span>
                                                    <span class="th-required">*</span>
                                                </th>
                                                <td>
                                                    <input type="text" id="name" name="name" maxlength="30" readonly="readonly" value="${user.user_name}">
                                                </td>
                                            </tr>

                                            <tr>
                                                <th scope="row">
                                                    <span class="th-title">휴대전화</span>
                                                    <span class="th-required">*</span>
                                                </th>
                                                <td>
                                                    <div id="mobile-input">
                                                        <select id="mobile1" name="mobile[]">
                                                            <option value="010">010</option>
                                                            <option value="011">011</option>
                                                            <option value="016">016</option>
                                                            <option value="017">017</option>
                                                            <option value="018">018</option>
                                                            <option value="019">019</option>
                                                        </select>
                                                         - 
                                                        <input id="mobile2" name="mobile[]" maxlength="4"  value="" type="text">
                                                         - 
                                                        <input id="mobile3" name="mobile[]" maxlength="4" value="" type="text">
                                                        <button type="button" id="btn-verify-mobile" onclick="alert('간편인증 온클릭')">간편인증</button>
                                                        <input type="hidden" id="user_tel" value="" name="user_tel">
                                                    </div>
                                                    <div class="must-write">
                                                        <!-- 간편인증 누르면 튀어나와서 인증번호 쓰라는 칸인데 일단 패스 -->
                                                         <!-- 만약 구현할거면 class=must-write 찾아서 구현.. -->
                                                    </div>
                                                </td>
                                                
                                                <script>
												    // 서버에서 받아온 휴대전화 번호 
												    var user_tel = "${user.user_tel}";
												
												    var telParts = user_tel.split("-");
												    
												    document.getElementById("mobile1").value = telParts[0];
												    document.getElementById("mobile2").value = telParts[1];					
												    document.getElementById("mobile3").value = telParts[2];
												</script>
												
												<script>
												function combinePhoneNumber() {
												    // Get values from the individual phone number parts
												    const part1 = document.getElementById("mobile1").value;
												    const part2 = document.getElementById("mobile2").value;
												    const part3 = document.getElementById("mobile3").value;
												    
												    // Combine them and store in the hidden input
												    document.getElementById("user_tel").value = part1 + "-" + part2 + "-" + part3;
												}
												</script>
                                            </tr>

                                            <tr>
                                                <th scope="row">
                                                    <span class="th-title">SMS 수신여부</span>
                                                    <span class="th-required">*</span>
                                                </th>
                                                <td class="SP_RadioBox">
                                                    <input id="is_sms0" name="is_sms" value="T" type="radio">
                                                    <label for="is_sms0">수신함</label>
                                                    <input id="is_sms1" name="is_sms" value="F" type="radio" checked="checked">
                                                    <label for="is_sms1">수신안함</label>
                                                    <p class="SP_stxt SP_pdTop5">쇼핑몰에서 제공하는 유익한 이벤트 소식을 SMS로 받으실 수 있습니다.</p>
                                                </td>
                                            </tr>

                                            <tr>
                                                <th scope="row">
                                                    <span class="th-title">이메일</span>
                                                    <span class="th-required">*</span>
                                                </th>
                                                <td>
                                                    <input type="text" id="email1" name="email1" value="${user.user_email}">
                                                    <span id="emailMsg" class=""></span>
                                                    <!-- 얘도 형식 어긋나면 error 클래스 추가되면서 옆에 튀어나옴 -->
                                                    <!-- 공백 시에는 이메일을 입력해 주세요. 라고 나옴 -->
                                                    <!-- 중복 시에는  이미 사용중인 이메일입니다. 다른 이메일로 다시 시도해 주세요. 라고 나옴 -->
                                                </td>
                                            </tr>

                                            <tr>
                                                <th scope="row">
                                                    <span class="th-title">이메일 수신여부</span>
                                                    <span class="th-required">*</span>
                                                </th>

                                                <td class="SP_RadioBox">
                                                    <input id="is_news_mail0" name="is_news_mail" value="T" type="radio">
                                                    <label for="is_news_mail0">수신함</label>
                                                    <input id="is_news_mail1" name="is_news_mail" value="F" type="radio" checked="checked">
                                                    <label for="is_news_mail1">수신안함</label>
                                                    <p class="SP_stxt SP_pdTop5">쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으실 수 있습니다.</p>
                                                </td>

                                            </tr>
                                        </tbody>
                                        
                                    </table>
                                </div>

                            </div>


                            <div class="edit-table-wrap">

                                <div class="edit-table-top-wrap">
                                    <div class="table-title">추가정보</div>
                                </div>
                                <div class="additional-info-wrap">
                                    <table class="additional-table">
                                        <colgroup>
                                            <col style="width:150px;">
                                            <col style="width:auto;">
                                        </colgroup>

                                        <tbody>
                                            <tr>
                                                <th scope="row">
                                                    <span class="th-title">생년월일</span>
                                                    <span class="th-required displayNone">*</span>
                                                </th>
                                               <td>
											    <input id="birth_year" name="birth_year" class="inputTypeText" maxlength="4" 
											           value="" type="text">
											    년
											    <input id="birth_month" name="birth_month" class="inputTypeText" maxlength="2" 
											           value="" type="text">
											    월
											    <input id="birth_day" name="birth_day" class="inputTypeText" maxlength="2" 
											           value="" type="text">
											    일
											</td>
                                        </tbody>
                                        <script>
										    // 서버에서 전달받은 user_birth 값을 JavaScript로 전달
										    var user_birth = "${user.user_birth}";  // 서버에서 받아온 값
										    var birthParts = user_birth.split("-");  // '-'를 기준으로 분리
										
										    // 분리된 값을 각각 연, 월, 일 입력 필드에 할당
										    document.getElementById("birth_year").value = birthParts[0];  // 연도
										    document.getElementById("birth_month").value = birthParts[1];  // 월
										    document.getElementById("birth_day").value = birthParts[2];    // 일
										</script>
                                    </table>

                                </div>
                            </div>
                            <!-- 추가 정보 테이블 (생일) -->

                            <div>
                                <h3>개인정보 처리 위탁 동의(선택)</h3>
                                <div class="info-use-agree-wrap">
                                    <div class="info-use-content">
                                        <div class="view-privacy-optional">아래 내용의 동의 여부는 회원가입에 영향을 미치지 않습니다. 단, 동의 거부시 서비스 이용에 제한이 있을 수 있습니다.<br>
                                            <br>
                                            - 위탁받는 자(수탁업체) : (주)데이터라이즈<br>
                                            <br>
                                            - 위탁업무의 내용:<br>
                                            목적 - 사용자 행태 기반의 맞춤형 정보 제공. SMS, 카카오톡 채널 및 E-mail 등의 메시지 발송에 필요한 정보. 이벤트 전달 및 분석리포트 업무.<br>
                                            항목 - [일반] 이름, 아이디, 휴대폰번호, 이메일 주소<br>
                                            보유기간 - 계약종료시까지<br>
                                        </div>
                                    </div>
                                    <p class="check">
                                        <span>개인정보 처리 위탁에 동의하십니까?</span>
                                        <input type="checkbox" id="infoUse-agree" name="infoUse-agree">
                                        <label for="infoUse-agree"></label>
                                    </p>
                                </div>
                            </div>

                            <div class="SP_submitBtn_wrap">
                                <div class="SP_submitBtn_left">
                                    <a href="<%=contextPath %>/mypage/mypage.do?userId=<%=userId%>" class="cnclBtn">취소</a>
                                    
                                    <a href="" class="memDelBtn" onclick="">회원탈퇴</a>
                                </div>
                                <div class="SP_submitBtn_right">
                                    <!-- <a href="javascript:void(0);" class="modifyBtn" onclick="document.getElementById('editForm').submit();">회원정보수정</a> -->
                                    <button class="modifyBtn" type="submit" style="border: 1px solid; #ddd; padding: 15px 30px;">회원정보수정&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&gt;</button>
                                </div>
                            </div>
						

                        
                        </div>
                        <!-- 멤버 에딧 랩 끝 -->


                    </form>
					
						
						
                </div>
            </div>
        

        </div>    
        <!-- 전체 contents 끝 -->

    </div>
    <!-- 전체 container 끝 -->
</body>
<%@include file="footer.jsp" %>
<script src="../resources/js/oho_memInfo.js"></script>
</html>