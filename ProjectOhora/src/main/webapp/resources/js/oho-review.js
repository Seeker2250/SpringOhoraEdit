 //추천순 최신순.. 클릭이벤트
$(".way-list").on("click" , function() {
    //alert("as")
    $(this).siblings().removeClass("way-selected")
    $(this).addClass("way-selected")
	let pdtId = $(this).attr("data-pdt-id")
	let link ="";
	if ( $(this).hasClass("recommend")  ) {
		link = `/review.htm?pdt_id=${pdtId}&sort=recommend`;
	} else if ( $(this).hasClass("new")) {
		link = `/review.htm?pdt_id=${pdtId}&sort=new`;
	} else {
		link = `/review.htm?pdt_id=${pdtId}&sort=rating`;
	}
	
	
	location.href = link;
	
});

// 포토 영상 우선보기 버튼 이벤트(체크표시)
$(".toggleBtn-wrapper").on("click" , function() {
   //alert("as")
	let pdtId = $(this).attr("data-pdt-id")
    if ( $(this).children().hasClass("toggle_button_component__icon-on")) { // 체크되어있을 때
        //$(this).children().removeClass("toggle_button_component__icon-on")
		link  = `/review.htm?pdt_id=${pdtId}&sort=recommend&phototoggle=off`;

    }else{ // 체크 안되어 있을 때 ( 누르면 체크 걸림)
		link  = `/review.htm?pdt_id=${pdtId}&sort=photo&phototoggle=on`;
        //$(this).children().addClass("toggle_button_component__icon-on")
    }
	location.href = link;
	

});



//리뷰가 없다면 없다고 띄움

$(document).ready(function(){


    // let rv_ul = document.getElementsByClassName("prd-Rv-ul");
    // let rv_li = document.getElementsByClassName("prd-Rv-li");

    if ( $(".prd-Rv-ul .prd-Rv-li").length > 0  ) {
        //alert("자식 li 있다");
        $(".prd-no-rv-container").css("display", "none")
    } else {
        $(".prd-no-rv-container").css("display", "block")
    }

});


//댓글창 폴드
$(document).on("click", ".rv-comment-link-wrap", function() {
    let revId = $(this).attr('data-rev-id');
	console.log("revId");
console.log("_csrf.HeaderName:", csrfHeaderName);
console.log("_csrf.token:", csrfToken );
    $.ajax({
        url: "/ajax/reviewcommentList/" + revId + ".ajax",
         dataType: "json",
        type: "GET",
        cache: false,
    
        success: function(data, textStatus, jqXHR) {
            $("#cmt-ul" + revId).empty();

            $(data).each(function(index, comments) {
                let deleteButton = '';
                
                if (comments.userId === userId ) {
                    deleteButton = `
                        <a class="comment_v2__edit_link js-comment-edit-dropdown-link" >
                            <div class="comment_v2__edit_link_text">삭제</div>
                        </a>
                  ` ;
                }

                $("#cmt-ul" + revId).append(`
                    <li class="comment-content" data-comment-id ="${comments.cmtId}" data-rev-id ="${comments.revId}">
                        <div class="comment-author">
                            ${comments.userName}
                        </div>
                        <div class="comment-msg">
                            ${comments.cmtContent}
                        </div>
                        ${deleteButton}
                    </li>
                `);
            });
        },
        error: function() {
            alert("댓글 폴드 에러~~~ ");
        }
    });

    if ($(this).closest(".lc-like-wrap").siblings(".comments-container").hasClass("cmtOn")) { 
        setTimeout(() => $(this).closest(".lc-like-wrap").siblings(".comments-container").removeClass("cmtOn").addClass("cmtOff"), 300);
    } else {
        setTimeout(() => $(this).closest(".lc-like-wrap").siblings(".comments-container").removeClass("cmtOff").addClass("cmtOn"), 300);
    }
});



//댓글 취소, 입력 버튼 띄우기 ( 댓글 텍스트 에어리어 포커스)
$(document).ready(function() {
    // textarea에 입력이 시작될 때
    $(document).on('click','.comment-textarea', function() {
        // 현재 textarea를 기준으로 부모 요소를 찾아서 버튼들을 보여줌
        var $commentBox = $(this).closest('.comment-write-box');
        $commentBox.next('.write-comment-btn-wrap').show();
    });

    // 취소 버튼 클릭 시
    $(document).on('click', '.cancelWriting', function() {
        var $commentBox = $(this).closest('.write-comment-btn-wrap').prev('.comment-write-box');
        // textarea 비우기
        $commentBox.find('.comment-textarea').val('');
        // 버튼 숨기기
        $(this).closest('.write-comment-btn-wrap').hide();
    });
});



//댓글 입력하면 등록 버튼 활성화
$(document).on('input','.comment-textarea', function() {
    var $textarea = $(this);
    var $submitButton = $textarea.closest('.comment-write-form').find('.submitComment');

    // 텍스트 영역의 값이 비어 있는지 확인
    if ($textarea.val().trim() === '') {
        // 비어 있을 경우 클래스 추가
        $submitButton.addClass('disBtn');
    } else {
        // 비어 있지 않을 경우 클래스 제거
        $submitButton.removeClass('disBtn');
    }
});



 

//댓글 서브밋
$(document).on('submit', '.comment-write-form', function(e) {
    e.preventDefault(); // 기본 폼 제출 방지
	// alert("등록하시겠습니까?")
    var $form = $(this);
    var textarea = $form.find('textarea.comment-textarea');
    var commentText = textarea.val().trim();
	let comment = textarea.val();
	
    // 입력값 있을 때 AJAX 
    if (commentText !== '') {
        $.ajax({
            url: "/ajax/reviewcommentWriteAndcntUp.ajax", 
            type:"POST",
            data: {
                comment: comment
                 , userId: $form.find('.trackingId').val() // userId 가져오기
                 , revId: $form.find('.trackingrevId').val() // rev_id 가져오기
                 , _csrf: $form.find('input[name="_csrf"]').val(),
            },
			cache:false ,
            success: function ( data,  textStatus, jqXHR ){
						
				console.log("댓글 등록 ajax 200");
				
				  var revId2 = $form.find('.trackingrevId').val();
				console.log("함수 넘어간 revId = " + revId2);
				

           		 baroComment(revId2); 
					
				 	}, //success
            error: function() {
                // 요청 실패 시 처리할 내용
                console.error('댓글 등록에 실패하였습니다.', error);
            }
        });
    } else {
        alert('댓글을 입력해 주세요.'); // 빈 댓글 입력 방지
    }
});


function baroComment(revId) {
	console.log("바로 "+revId);
	 $.ajax({
					 url:"/ajax/reviewcommentCntUpView/" + revId + ".ajax" , 
					 dataType:"json",
					 type:"GET",
					 cache:false ,
					 success: function ( data,  textStatus, jqXHR ){

					$("#cmt-ul" + revId).empty();
						
					$(data).each( function(index, comments) {
						
				  let deleteButton = '';
        
	                if (comments.userId === userId) {
	                    deleteButton = `
	                        <a class="comment_v2__edit_link js-comment-edit-dropdown-link" >
	                            <div class="comment_v2__edit_link_text">삭제</div>
	                        </a>`;
	                }


            		  $("#cmt-ul" + revId).append(`<li class="comment-content" data-comment-id ="${comments.cmtId}" data-rev-id="${comments.revId}" >
                                                        <div class="comment-author">
                                                            ${comments.userName}
                                                        </div>
                                                        <div class="comment-msg">
                                                           ${comments.cmtContent}
                                                        </div>
  														${deleteButton}
                                                    </li>` )
            		  })
					//댓글 갯수 바로 반영
					let cnt = $("#cmtCnt"+revId);
					let cntnum = parseInt( cnt.text() );
					console.log(cntnum);
					cntnum += 1;
					console.log("1더하면 " + cntnum);
					cnt.text(cntnum);
					
					//입력창 비우기
					$("#cmt-writeArea" + revId).val("");
					
				 	}, //success
					 error:function (){
						 alert("댓글 바로 폴드 에러~~~ ");
					 }
				
		});//ajax
}




//댓글 입력 권한 검사
$(document).on("keydown", ".comment-textarea", function(e) {
    trackuserId = $(".trackingId").val().trim();
	console.log(userId)
   //  null   "null"
	if ( trackuserId != "null" && trackuserId !="NaN" && trackuserId !=0) { // userId가 null이 아니다
	   console.log( e.keyCode )
        if (e.keyCode === 13) {
            console.log("서브밋");
			$(".comment-write-form").submit();
        }
    } else { // userId가 null이거나 비어있는 경우
        alert("로그인이 필요합니다.");
    }
});

//댓글 삭제
$(document).on("click", ".comment_v2__edit_link.js-comment-edit-dropdown-link", function(event) {
    event.preventDefault();
    
    let commentId = $(this).closest(".comment-content").data("comment-id");
    let revId = $(this).closest(".comment-content").data("rev-id");
    console.log("댓글 ID:", commentId); // 확인용 출력
    console.log("리뷰 ID:", revId); // 확인용 출력
    if (confirm("댓글을 삭제하시겠습니까?")) {
        $.ajax({
            url: "/ajax/reviewcommentDelete.ajax",
            type: "GET",
            data: {
                          cmt_id: commentId
						, revId : revId 
					 },	
		   dataType:"json",
            success: function(result, status, xhr) {
				console.log("이게 돌아온 결과값입니다"+result)
                if (result) {
					 baroComment2(result); 
                } else if(result==0) {
                    alert("댓글 삭제에 실패했습니다. 다시 시도해 주세요.");
                }
            },
            error: function() {
                alert("댓글 삭제 중 오류가 발생했습니다.");
            }
        });
    }
});


function baroComment2(revId) {
	 $.ajax({
					 url:"/ajax/reviewcommentCntUpView/" + revId + ".ajax" , 
					 dataType:"json",
					 type:"GET",
					 cache:false ,
					 success: function ( data,  textStatus, jqXHR ){

					$("#cmt-ul" + revId).empty();
						
					$(data).each( function(index, comments) {
						
				  let deleteButton = '';
        
	                if (comments.userId === userId) {
	                    deleteButton = `
	                        <a class="comment_v2__edit_link js-comment-edit-dropdown-link" >
	                            <div class="comment_v2__edit_link_text">삭제</div>
	                        </a>`;
	                }


            		  $("#cmt-ul" + revId).append(`<li class="comment-content" data-comment-id ="${comments.cmtId}" data-rev-id="${comments.revId}" >
                                                        <div class="comment-author">
                                                            ${comments.userName}
                                                        </div>
                                                        <div class="comment-msg">
                                                           ${comments.cmtContent}
                                                        </div>
  														${deleteButton}
                                                    </li>` )
            		  })
					//댓글 갯수 바로 반영
					let cnt = $("#cmtCnt"+revId);
					let cntnum = parseInt( cnt.text() );
					console.log(cntnum);
					cntnum -= 1;
					//console.log("1더하면 " + cntnum);
					cnt.text(cntnum);
					
					//입력창 비우기
					$("#cmt-writeArea" + revId).val("");
					
				 	}, //success
					 error:function (){
						 alert("댓글에러~~~ ");
					 }
				
		});//ajax
}

// 최다 득점한 별점 그래프 기둥 검정색
$(document).ready(function() {
    let maxScore = 0; // 최대 점수 저장
    let maxLi = null; // 최대 점수 가진 li 

    $(".score-count").each(function() {
        let score = parseInt($(this).text());

        if (score > maxScore) {
            maxScore = score;
            maxLi = $(this).closest("li"); // 해당 .score-count의 부모 li 요소 저장
        }
    });

    // 가장 큰 점수를 가진 li의 자식 .score-graph에 'highest' 클래스 추가
    if (maxLi) {
        maxLi.find(".score-graph").addClass("highest");
    }
});






//더보기 ajax
$(".infinite-scroll-btn-wrap").on("click" , function() {
		let currentRevPage = parseInt($(this).attr('data-currPage'));
		let pdtId = $(this).attr('data-pdtId');
		let sort = $(this).attr('data-sort');
		console.log("지금 보낸 요청 pdtId: " + pdtId + "currPage: " + currentRevPage + "sort: " +sort  );
		//alert(pdtId + sort)
		
  $.ajax({
					 url:"/ajax/reviewMore.ajax" , 
					 dataType:"json",
					 type:"GET",
					 data: { pdtId : pdtId,
							sort : sort,  
							currentRevPage : currentRevPage	
								 },
					 cache:false ,
					 success: function(data, textStatus, jqXHR) {
		currpageUp();
		
		//		alert(data.allRevCnt);
		//      alert( typeof(data.allRevCnt));
		
		
        let reviewLi = ''; // 루프 전에 초기화

        
        data.reviews.forEach(function(reviews) {
            reviewLi += `<li class="prd-Rv-li">` +
                `<div class="prd-Rv-lcontent">` +
                    `<div class="lcontent-container">` +
                        `<div class="lc-tag-wrap">`;

            if (reviews.newImg) {
                reviewLi += `<span class="rv-badge">NEW</span>`;
            }

            if (reviews.revIsrecommend === 'Y') {
                reviewLi += `<span class="rv-badge">오호라 추천 리뷰</span>`;
            }

            reviewLi += `</div>` +
                        `<div class="lc-score-wrap">` +
                            `<div class="score-box">` +
                                `<div class="score-star-box">`;

            for (let i = 1; i <= 5; i++) {
                if (i <= reviews.revRating) {
                    // 꽉찬 별
                    reviewLi += `<div class="score-star-full">
                                    <img src="../resources/images/fullStar.svg" alt="꽉별">
                                    <img src="../resources/images/emptyStar.svg" alt="빈별">
                                 </div>`;
                } else {
                    // 빈 별
                    reviewLi += `<div class="score-star-empty">
                                    <img src="../resources/images/fullStar.svg" alt="꽉별">
                                    <img src="../resources/images/emptyStar.svg" alt="빈별">
                                 </div>`;
                }
            }

            reviewLi += `<span>별점: ${reviews.revRating} 점</span>` +
                        `</div><div>`;

            switch (reviews.revRating) {
                case 1: reviewLi += '별로예요'; break;
                case 2: reviewLi += '그냥 그래요'; break;
                case 3: reviewLi += '보통이에요'; break;
                case 4: reviewLi += '맘에 들어요'; break;
                case 5: reviewLi += '아주 좋아요'; break;
                default: reviewLi += 'XXXX';
            }

            reviewLi += `</div></div></div>` +
                        `<div class="lc-content-wrap">
                            <div class="lc-content-box">
                                <div class="content-ment-box">
                                    <div class="content-ment">
                                        ${reviews.revContent}
                                    </div>
                                </div>
                            </div>
                        </div>` +
                        `<div class="lc-image-wrap">
                            <div class="lc-image-box">
                                <ul class="lc-image-list">`;

            reviews.revMediaList.forEach(photo => {
                reviewLi += `<li>
                                <a href="#">
                                    <div class="lc-image">
                                        <img src="../reviewMedia/${photo.filesystemname}" alt="리뷰사진">
                                    </div>
                                </a>
                            </li>`;
            });

            reviewLi += `</ul></div></div>` +
                        `<div class="manager-review">`;

            if (reviews.revIsrecommend === 'Y') {
                reviewLi += `이 리뷰는 오호라 관리자가 등록한 리뷰입니다.`;
            }

            reviewLi += `</div>
                <div class="lc-like-wrap">
                    <div class="like-box">
                        <a class="rv-like">
                            <span class="review_like_text">도움돼요</span>
                            <span class="review_like-score">${reviews.revGoodCount}</span>
                        </a>
                        <a class="rv-unlike">
                            <span class="review_unlike_text">도움안돼요</span>
                            <span class="review_unlike_score">${reviews.revBadCount}</span>
                        </a>
                    </div>
                    <div class="rv-comment-link-wrap" id="rv-li${reviews.revId}" data-rev-id="${reviews.revId}">
                        <a class="rv-comment-link">
                            <span class="review_list_v2__comments_text">댓글</span>
                            <span class="review_list_v2__comments_count js-comments-count" id="cmtCnt${reviews.revId}">${reviews.revCommentCount}</span>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 8 8" class="review_list_v2__small_arrow_icon" style= "width:10px">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M.667 2.333L4 5.667l3.333-3.334"></path>
                            </svg>
                        </a>
                    </div>
                </div>
                <div class="comments-container cmtOff">
                    <div class="comments-wrap">
                        <ul class="comments-box" id="cmt-ul${reviews.revId}">
                        </ul>
                        <div class="write-comment-wrap">
                            <form class="comment-write-form">
                                <div class="comment-write-box">
                                    <textarea id="cmt-writeArea${reviews.revId}" name="comment" class="comment-textarea" placeholder="댓글을 작성해 주세요" rows="1" autocomplete="off"></textarea>
                                    <input type="hidden" class="trackingId" value="${userId}"/>
                                    <input type="hidden" class="trackingrevId" value="${reviews.revId}">
                                </div>
                                <div class="write-comment-btn-wrap" style="display: none">
                                    <span class="writeBtn-box">
                                        <button type="button" class="cancelWriting">취소</button>
                                        <button type="submit" class="submitComment disBtn" id="submitWriting${reviews.revId}">등록</button>
                                    </span>
                                </div>
                                 <input type="hidden" name="_csrf" value="${csrfToken}">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="prd-Rv-Rcontent">
            <div class="rv-nameMsg">
                <b>${reviews.userName}</b>님의 리뷰입니다
            </div>
        </div>
        </li>`;
        });
					
			 $(".prd-Rv-ul").append(reviewLi)//append
		
		// 전체 페이지 계산

		 let allPage = Math.ceil( (data.allRevCnt)/2  );
		
		 $(".infinite-scroll-btn-wrap").attr('data-allPage', allPage);
		
		 	}, //success
			 error:function (){
				 alert("더보기에러~~~ ");
			 },

				
		});//ajax
		
		let currentRevPage2 = parseInt( $(".infinite-scroll-btn-wrap").attr('data-currPage' ) ) ;
		let allPage =  parseInt( $(".infinite-scroll-btn-wrap").attr('data-allPage') );
		//alert("이제 현재페이지는 = " +currentRevPage)
		//alert("여기서 올페이지 " +  allPage)
		if( currentRevPage2 >= allPage ) {
			//alert("다봤다")
			$(".infinite-scroll-btn-wrap").css("display", "none");
			$(".infinite-scroll-noMore").css("display", "block");
			
		}
		
		
	
}); // click



// 현재 페이지 올리기 함수
function currpageUp() {
	let currentRevPage = parseInt($(".infinite-scroll-btn-wrap").attr('data-currPage'));
        
	$(".infinite-scroll-btn-wrap").attr('data-currPage' ,currentRevPage+1 )
}



// 댓글보기, 좋아요 등 잡다한 호버

$(document).on({
    mouseenter: function() {
        $(this).css("color", "#14161a");
        $(this).find("svg").css("stroke", "#14161a");
    },
    mouseleave: function() {
        $(this).css("color", "#707680");
        $(this).find("svg").css("stroke", "#707680");
    }
}, ".rv-like");

$(document).on({
    mouseenter: function() {
        $(this).css("color", "#14161a");
        $(this).find("svg").css("stroke", "#14161a");
    },
    mouseleave: function() {
        $(this).css("color", "#707680");
        $(this).find("svg").css("stroke", "#707680");
    }
}, ".rv-unlike");

$(document).on({
    mouseenter: function() {
        $(this).css("color", "#14161a");
        $(this).find("svg").css("stroke", "#14161a");
    },
    mouseleave: function() {
        $(this).css("color", "#707680");
        $(this).find("svg").css("stroke", "#707680");
    }
}, ".rv-comment-link");
