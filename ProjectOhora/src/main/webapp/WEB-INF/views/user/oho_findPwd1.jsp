<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ page
trimDirectiveWhitespaces="true" %> <% String contextPath =
request.getContextPath(); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>오호라 팀 프로젝트</title>
    <link
      rel="shortcut icon"
      type="image/x-icon"
      href="http://localhost/jspPro/images/SiSt.ico"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="google" content="notranslate" />
    <link
      href="https://fonts.googleapis.com/css?family=Libre+Baskerville&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="container"></div>
    <span class="title">PASSWORD FIND</span>
    <span class="description">
      가입하신 회원 유형에 따라 비밀번호 찾기가 가능합니다.
    </span>
    <form
      class="form-container"
      id="findPwForm"
      action="/findPwd2.htm"
      method="post"
    >
      <div class="label-container">
        <span class="label-text">회원유형</span>
      </div>
      <select class="dropdown-select" name="membership_type">
        <option value="개인회원">개인회원</option>
        <option value="개인사업자 회원">개인사업자 회원</option>
        <option value="법인사업자 회원">법인사업자 회원</option>
        <option value="외국인 회원">외국인 회원</option>
      </select>

      <div class="radio-group">
        <input
          type="radio"
          id="email"
          name="contact_method"
          value="email"
          checked="checked"
        />
        <label for="email" class="radio-label">이메일</label>
        <input type="radio" id="phone" name="contact_method" value="phone" />
        <label for="phone" class="radio-label">휴대폰번호</label>
      </div>

      <div class="label-container" style="top: 95px">
        <span class="label-text">아이디</span>
      </div>
      <input
        type="text"
        class="input-field"
        style="top: 95px"
        name="userLoginId"
        value="check"
      />

      <div class="label-container" style="top: 135px">
        <span class="label-text">이름</span>
      </div>
      <input
        type="text"
        class="input-field"
        style="top: 135px"
        name="userName"
        value="일지매"
      />

      <div class="label-container" id="findByEmail" style="top: 175px">
        <span class="label-text">이메일로 찾기</span>
      </div>
      <input
        type="text"
        class="input-field"
        id="emailInput"
        style="top: 175px"
        name="userEmail"
        value="check@naver.com"
      />

      <div
        class="label-container"
        id="findByPhone"
        style="top: 175px; display: none"
      >
        <span class="label-text">휴대폰번호로 찾기</span>
      </div>
      <input
        type="text"
        class="input-field"
        id="phoneInput"
        style="top: 175px; display: none"
        name="userTel"
        value="010-4321-4321"
      />

      <div class="button-container" id="findBtn">
        <button type="submit" class="button-text">확인</button>
      </div>

      <input
        type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"
      />
    </form>

    <script>
      document.getElementById("email").addEventListener("change", function () {
        if (this.checked) {
          // 이메일 선택 시 이메일 관련 항목 보이기
          document.getElementById("findByEmail").style.display = "block";
          document.getElementById("emailInput").style.display = "block";

          // 휴대폰 번호 관련 항목 숨기기
          document.getElementById("findByPhone").style.display = "none";
          document.getElementById("phoneInput").style.display = "none";

          // 이메일 필드에 값이 있으면 유지하고, 전화번호 입력 필드는 초기화
          document.getElementById("phoneInput").value = "";
        }
      });

      document.getElementById("phone").addEventListener("change", function () {
        if (this.checked) {
          // 휴대폰 번호 선택 시 휴대폰 관련 항목 보이기
          document.getElementById("findByEmail").style.display = "none";
          document.getElementById("emailInput").style.display = "none";

          // 이메일 관련 항목 숨기기
          document.getElementById("findByPhone").style.display = "block";
          document.getElementById("phoneInput").style.display = "block";

          // 이메일 필드에 값이 있으면 초기화
          document.getElementById("emailInput").value = "";
        }
      });

      // 폼 제출 시 사용하지 않는 입력값 초기화
      document
        .getElementById("findPwForm")
        .addEventListener("submit", function (event) {
          const emailSelected = document.getElementById("email").checked;

          // 이메일 선택 시 휴대폰 번호 입력값 초기화
          if (emailSelected) {
            document.getElementById("phoneInput").value = ""; // 휴대폰 입력값 초기화
          } else {
            // 휴대폰 선택 시 이메일 입력값 초기화
            document.getElementById("emailInput").value = ""; // 이메일 입력값 초기화
          }
        });
    </script>

    <script>
      //이메일 체크 함수
      function checkEmail(email) {
        // 정규 표현식을 사용하여 이메일 형식 검사
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailPattern.test(email);
      }

      //폰 체크 함수
      function checkPhone(phone) {
        // 정규 표현식을 사용하여 폰 (010-xxxx-xxxx) 형식 검사
        const phonePattern = /^010-\d{4}-\d{4}$/;
        return phonePattern.test(phone);
      }
    </script>

    <script>
      // 확인 버튼
      $("#findBtn").on("click", function (event) {
        // alert("test");

        // 기본 제출 방지
        event.preventDefault();

        let check = true;

        if ($("#email").is(":checked")) {
          $("#emailInput").prop("disabled", false); // 이메일 입력 필드를 활성화

          // 이메일 유효성 검사
          let emailVal = $("#emailInput").val();
          if (!checkEmail(emailVal)) {
            alert("이메일 항목이 이메일 형식이 아닙니다.");
            check = false;
          } // if
        } else if ($("#phone").is(":checked")) {
          $("#phoneInput").prop("disabled", false); // 전화 입력 필드를 활성화

          // 폰 유효성 검사
          let phoneVal = $("#phoneInput").val();
          if (!checkPhone(phoneVal)) {
            alert("휴대전화 항목이 휴대전화 형식이 아닙니다.");
            check = false;
          } // if
        } // else if

        // 폼을 제출
        if (check) {
          $("#findPwForm").submit();
        } // if
      });
    </script>

    <!-- 비밀번호 못 찾을 시 alert 창 띄우기 -->
    <script>
      $(document).ready(function () {
        if ("${param.fail}" === "true") {
          alert("입력하신 정보로 가입 된 회원은 존재하지 않습니다.");
        }
      });
    </script>
  </body>
</html>
