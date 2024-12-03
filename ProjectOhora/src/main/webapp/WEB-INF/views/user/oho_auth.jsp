<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오호라</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/jspPro/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate">
<style>
@import url('https://fonts.googleapis.com/css?family=Libre+Baskerville:400,700|Noto+Sans+KR:300,400,500,700&display=swap');

html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, input, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video, fieldset {
    margin: 0;
    padding: 0;
    border: 0;
    vertical-align: baseline;
    outline: 0;
    white-space: nowrap;
}

* {
    box-sizing: border-box;
}

div {
    display: block;
    unicode-bidi: isolate;
}

body, h1, h2, h3, h4, h5, h6, table, pre, xmp, plaintext, listing, input, textarea, select, button, a {
    font-family: inherit;
    line-height: normal;
}

body, html, :lang(ko) {
    font-family: 'Noto Sans KR', sans-serif;
}

* {
    letter-spacing: 0px;
}

canvas {
    overflow-clip-margin: content-box;
    overflow: clip;

}

strong {
    font-weight: 500;
}

span, a {
    font-family: inherit;
    color: inherit;
    font-size: inherit;
}

a {
    text-decoration: none;
}

ul, li, ol, dl, dt, dd {
    list-style: none;
}

table {
    width: 100%;
    border: 0;
    border-spacing: 0;
    border-collapse: collapse;
}

table {
    border-collapse: collapse;
    border-spacing: 0;
}


/* 공용부 끝 */

#main-container{
    border: none;

}

#contents{

    min-height: 670px;

}

#myPage-wrap{

}

.subSection{
    padding: 60px 0 30px;

}

.subTitle{
    padding: 5px 0;
    text-align: center;
    font-size: 30px;
}

.subTitle > span {
    min-width: 100%;
    font-size: 28px;
    letter-spacing: -2px !important;

    display: inline-block;
    position: relative;
    text-transform: lowercase;

    font-family: 'Libre Baskerville', 'Noto Sans KR', sans-serif !important;

}

.profile-container{
    margin-top: 8px;
    color: #fff;
    background: #111;

}

.member-info-wrap{
    width: 1200px;
    margin: 0 auto 10px;
    padding: 66px 0 77px;
    position: relative;

}

.member-info{
    width: 600px;
    display: inline-block;
}

.info-msg{
    display: flex;
    font-size: 0;
}

.member-radius{
    position: relative;
    display: inline-block;
    margin-right: 60px;
}

.radius-box{

}

#member1 {
    position: absolute;
    left: 0;
    top: 0;
}


.infoMegBox_wrap{
    display: inline-block;
    vertical-align: top;
}

.ment {
    font-size: 26px;
    line-height: 1;
    padding-bottom: 12px;
    font-weight: 300;
}

.member-name{

}

.grade {
    font-size: 20px;
    margin-bottom: 30px;
    font-weight: 300;
    line-height: 1;
}

.group{

}

.gradeValue{
    font-size: 14px;
    color: #aaa;

}

.toNext-won{

}

.order_total{

}

.order_total_value{

}

.user-UtilLink{
    font-size: 0;
    margin-top: 45px;
    white-space: nowrap;

}

.user-UtilLink >a:first-child {
    padding-left: 0;
}

.user-UtilLink >a{
    position: relative;
    font-size: 15px;
    color: #fff;
    background: none;
    height: unset;
    line-height: unset;
    text-align: left;
    width: initial;
    padding-right: 60px;
    vertical-align: bottom;
    display: inline-block;
}

.user-UtilLink >a::after{
    content: '';
    display: inline-block;
    width: 9px;
    height: 13px;
    background: url(https://ohora.kr/smartpc/_img/icon/arrow_more_wh.png) no-repeat center center;
    object-fit: contain;
    background-size: 90%;
    position: absolute;
    top: 51%;
    transform: translateY(-50%);
    left: auto;
    right: 40px;
    bottom: auto;


}



.order_info_wrap{
    display: inline-block;
    float: right;
    margin-top: 40px;


}

.point_coupon-wrap{
    overflow: hidden;
}

.point_coupon{
    font-size: 0;

}

.point_coupon > li:first-child  {
    margin-left: 0;
}

.point_coupon > li{
    display: inline-block;
    vertical-align: top;
    width: auto;
    box-sizing: border-box;
    text-align: center;
    margin-left: 90px;

}

.pnc_displayTable{
    display: table;
    width: 100%;
    height: 100%;
}

.pnc_displayTableInr{
    display: table-cell;
    width: 100%;
    height: 100%;
    vertical-align: middle;
}

.myOrderInfoTitle{
    font-size: 16px;
    display: inline-block;
    padding: 7px 3px;
    border-bottom: 1px solid #fff;
    font-weight: 300;
}

.myOrderInfoCont{

}

.myOrderInfoCont > a {
    display: inline-block;

    vertical-align: top;
    font-size: 30px;
    font-weight: 900;
    color: #fff;
    line-height: 1;
    padding: 25px 0 15px;

}

/*  */

.orderList-layout{
    width: 1050px;
    margin: 0 auto;

}

.subSection{
    padding: 60px 0 30px;

}

.ol-title-wrap{

}

.ol-title-wrap > h3 {
    font-size: 20px;
    margin-bottom: 0;

    font-family: 'Libre Baskerville', 'Noto Sans KR', sans-serif !important;

    color: #000;
    font-weight: bold;
    display: inline-block;
}

.ol-moreBtn{
    display: inline-block;
    float: right;


}

.ol-moreBtn > a{
    font-size: 15px;
    color: #000;
    position: relative;
    top: 5px;
}

.orderState_wrap {
    margin: 55px 0 77px;
    text-align: center;

}

.orderState_wrap > ul {
    font-size: 0;
}

.orderState_wrap > ul >li:first-child  {
    margin-left: 0;

}

.orderState_wrap > ul >li:first-child::after{
    display: none;

}

.orderState_wrap > ul >li {
    margin-left: 110px;

    display: inline-block;
    width: 180px;
    height: 180px;
    position: relative;
    background: #000;
}

.orderState_wrap > ul >li::after{
    left: -38%;

    content: '';
    display: inline-block;
    width: 25px;
    height: 40px;
    background: url(https://ohora.kr/smartpc/_img/icon/swp_right_arrow.png) no-repeat center center;
    background-size: 90%;
    position: absolute;
    top: 50%;
    transform: translate(0, -50%);
}

.orderState_wrap > ul >li > a{
    display: block;
    width: 100%;
    height: 100%;
    color: #fff;
    padding: 45px 0;
    font-size: 18px;
}

.orderState_wrap > ul >li > a > span {

}

.orderState_wrap > ul >li > a > .count{
    display: block;
    font-size: 40px;
    color: #fff;
    font-weight: 900;
    line-height: 1;
}


.orderState_wrap > ul >li > a > .count > span{
    margin-top: 25px;

    display: block;
    font-size: 40px;
    color: #fff;
    font-weight: 900;
    line-height: 1;
}

/*  */

.order-history-wrap {

}

.ordhistory-table{
    width: 100%;

    border: 0;
    border-spacing: 0;
    border-collapse: collapse;

    line-height: normal;
}

thead > tr > th {
    height: 47px;
    font-size: 18px;

    font-weight: 500;

    vertical-align: middle;

    color: #111;
    background: #eeeeee;
}
 
tbody > .table-record > td {
    height: 75px;
    text-align: center;
    padding-left: 0;

    vertical-align: middle;
    font-size: 15px;
    color: #000;
    border-top: 1px solid #eeeeee;
    border-bottom: 1px solid #eeeeee;
}

tbody > .table-record > td.center {
    text-align: center;
}

.displayNone {
    display: none !important;
}

/*  */

.myShopMenu-layout{
    width: 1050px;
    font-size: 0;
    padding: 40px 0 100px;
    margin: 0 auto;

}

.myShopMenu-list:first-child{
    margin-left: 0;

}

.myShopMenu-list {
    display: inline-block;
    width: calc(50% - 10px);
    margin-left: 20px;
    border-top: 2px solid #000;

}

.myShopMenu-list > ul {
    font-size: 0;

}

.myShopMenu-list > ul > li {
    display: block;
    line-height: unset;
    padding: 0;
    text-align: left;
    background: none;
    color: #000;
}

.myShopMenu-list > ul > li > a{
    border-bottom: 1px solid #eee;
    padding: 30px 75px 30px 50px;
    font-size: 18px;
    font-weight: 500;
    color: #000;
    display: block;
    position: relative;


}

.myShopMenu-list > ul > li > a::after {
    content: '';
    display: inline-block;
    width: 15px;
    height: 25px;
    position: absolute;
    top: 50%;
    bottom: auto;
    left: auto;
    right: 20px;
    transform: translateY(-50%);
    background: url(https://ohora.kr/smartpc/_img/icon/swp_right_arrow.png) no-repeat center center;
    background-size: 80%;
}

.myShopMenu-list > ul > li > a > span {
    color: #7f2929;
    font-size: 15px;
    float: right;

}

 span.material-symbols-outlined{
    vertical-align: text-bottom;
 } 
 
 
</style>
</head>
<body>

    <div id="main-container">

        <div id="contents">

            <div id="myPage-wrap">

                <div class="subSection">
                    <h2 class="subTitle">
                        <span>관리자 페이지</span>
                    </h2>
                </div>
            
                

                <div class="profile-container">
                    <div class="member-info-wrap">

                        <div class="member-info"> 
                        <!-- 얘가 SP_Message임 -->
                            
                            <div class="info-msg">
                            
                                <div class="member-radius">
                                  <div class="radius-box" id="radiusBox">
								    <canvas id="doughnut1" width="170" height="170" ></canvas>
								    <script>
		
								        const canvas = document.getElementById('doughnut1');
								       
								        const ctx = canvas.getContext("2d");
								
								        const centerX = 85;
								        const centerY = 85;
								        const outerRadius = 70; // 바깥쪽 면의 반지름
								        const innerRadius = 35; // 안쪽 면의 반지름
								

								        ctx.beginPath();
								        ctx.strokeStyle = "gray";
								        ctx.lineWidth = 1.5;

								        for (let i = 0; i < 16; i++) {
								            const angle = (i * Math.PI) / 8; // 각 꼭짓점의 각도 (16등분)
								            const x = centerX + outerRadius * Math.cos(angle);
								            const y = centerY + outerRadius * Math.sin(angle);
								            if (i === 0) ctx.moveTo(x, y);
								            else ctx.lineTo(x, y);
								        }
								        ctx.closePath();
								        ctx.stroke();
								
		
								        ctx.beginPath();
								        for (let i = 0; i < 8; i++) {
								            const angle = (i * Math.PI) / 4; // 각 꼭짓점의 각도 (8등분)
								            const x = centerX + innerRadius * Math.cos(angle);
								            const y = centerY + innerRadius * Math.sin(angle);
								            if (i === 0) ctx.moveTo(x, y);
								            else ctx.lineTo(x, y);
								        }
								        ctx.closePath();
								        ctx.stroke();
		
								        for (let i = 0; i < 16; i++) {
								            const outerAngle = (i * Math.PI) / 8;
								            const innerAngle = ((i % 8) * Math.PI) / 4;
								            const outerX = centerX + outerRadius * Math.cos(outerAngle);
								            const outerY = centerY + outerRadius * Math.sin(outerAngle);
								            const innerX = centerX + innerRadius * Math.cos(innerAngle);
								            const innerY = centerY + innerRadius * Math.sin(innerAngle);
								            ctx.beginPath();
								            ctx.moveTo(outerX, outerY);
								            ctx.lineTo(innerX, innerY);
								            ctx.stroke();
								        }
								    </script>
								</div>

                                </div>


                                <div class="infoMegBox_wrap">
                                    <p class="ment">
                                        <strong><span><span class="member-name"><sec:authentication property="principal.user.userName" /></span></span></strong>님 반갑습니다.
                                    </p>
                                    <p class="grade">관리자님의 등급은 
                                        <strong class="group">[
                                            <span class="groupName-wrap" id="groupName">
                                                <span class="group_name"><sec:authentication property="principal.user.authList[0].authName" /></span>
                                            </span>]
                                        </strong>입니다. 
                                    </p>
                                    <p class="gradeValue" id="toNextGrade">해당 페이지는
                                        <span id="changePrd" class="toNext-won">
                                            <span class="toNext-value"> 관리자 전용 
                                        </span> 페이지
                                        </span> 입니다.
                                    </p>

                                    <p class="order_total">
                                        <span class="order_total_value">0</span>
                                    </p>
                                    <div class="user-UtilLink">
                                        <a href="#empty">게시글 관리</a>
                                        <a href="#empty">리뷰 관리</a>
                                        <a href="#empty">댓글 관리</a>
                                    </div>
                                </div>


                            </div>   
                        </div>

                        <!-- 오더 인포 랩 -->

                    </div>
                </div>

                <div class="orderList-layout">
                 	<div class="subSection">

                    </div>
                
                    <div class="myShopMenu-layout">
                        <div class="myShopMenu-list">
                            <ul>
                                <!-- li 마다 after로 > 모양있음 -->
                                <li><a href="<%= contextPath %>/prdAdd.htm">관리자 상품 등록</a></li>
                               
                            </ul>
                        </div>

                        
                        <div class="myShopMenu-list">
                            <ul>
                               <!-- li 마다 after로 > 모양있음 -->
                                <li><a href="<%= contextPath %>/prdManageList.htm">관리자 상품 관리(수정, 삭제)</a></li>
                                
                            </ul>
                        </div> 
                     
                    </div>

                </div>
                <!-- 오더 레이아웃 픽스 -->




            </div>
            <!-- 마이페이지 랩 -->
        </div>
        <!-- 컨텐츠 -->

    </div>
    <!-- 메인 컨테이너 -->

</body>

</html>