$(function(){
		
	// 댓글 Collapse 처리
	$("#reviewCollapseSpan").click(function(){
		getReples(1);
		var status = $(this).html();
		if(status == "+"){
			$("#reviewAddTag").slideDown(500, function(){
				$("#reviewContent ul").slideDown(1000, function(){
					$("#reviewPaging ul").slideDown(500);
				});
			});
									
			$(this).html("-");
		}else{
			$("#reviewPaging ul").slideUp(500, function(){
				$("#reviewContent ul").slideUp(1000);
				$("#reviewAddTag").slideUp(500);
			});

			$(this).html("+");
		}
	})
	
	// 댓글 페이징 클릭 시 처리
	$("#reviewPaging").on("click", "li a", function(e){
		e.preventDefault();
		var page = $(this).attr("href");
		getReples(page);
		
	})
	
	// Handlebars 날짜 포맷 및 함수 획득
	Handlebars.registerHelper("setDate", function(date){
		var dateObj = new Date(date);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		month = month < 10? "0" + month: month;
			
		return year + "." + month + "." + date;
	})
	
	var templateFunc = Handlebars.compile($("#template").html());
	
	// Handlebars 수정 및 삭제 버튼 획득
	Handlebars.registerHelper("if", function(replyId, option){
		if(replyId == loginId){
			return option.fn(this);
		}else{
			return "";
		}
	})
	
	// 댓글 삭제 처리
	$(document).on("click", ".reviewDelete", function(){
		var check = confirm("정말로 삭제하시겠습니까?");
		if(check){
			var target = $(this).attr("data-del");
			$.ajax({
				url : contextPath + "/deleteReview/" + Number(target),
				type : "delete",
				dataType: "text",
				success : function(result){
					alert("삭제되었습니다.");
					getReples(1);
				}
			})
		}
	})
	
	// 댓글 화면으로 get
	$(document).on("click", ".reviewUpdate", function(){
		var target = $(this).attr("data-href");
		location.href = target;	
	})
	
	// 게시물 삭제 버튼 이벤트
	$("#boardDeleteBtn").click(function(){
		var check = confirm("정말로 삭제하시겠습니까?");
		
		if(check){
			var target = $(this).attr("data-del");
			location.href = target;
		}	
	})
	
	
	
	// 댓글 획득 ajax
	function getReples(page){
		
		$.ajax({
			url : contextPath + "/read/" + boardNum + "/" + page,
			type : "get",
			dataType : "json",
			success : function(result){
				console.log(result);
				$("#reviewContent ul").empty();
				$("#totalCountSpan").text(result.pageMaker.totalCount);
				$("#reviewContent ul").html(templateFunc(result.reples));
				getPaging(result.pageMaker);
			}
			
		})
		
	}
	
	// 댓글 페이징 처리 함수
	function getPaging(pageMaker){
		$("#reviewPaging ul").empty();
		var str = "";
		
		if(pageMaker.prev){
			str += "<li><a href='" + pageMaker.startPage -1 + "'> << </a></li>"
		}
		
		for(var i = pageMaker.startPage; i <= pageMaker.endPage; i++){
			if(pageMaker.cri.page == i){
				str += "<li class='active'><a href='" + i + "'>"+ i +"</a></li>"
			}else{
				str += "<li><a href='" + i + "'>"+ i +"</a></li>"
			}
		}
				
		if(pageMaker.next){
			str += "<li><a href='" + pageMaker.endPage + 1 + "'> >> </a></li>"
		}
		
		$("#reviewPaging ul").html(str);
	}
	
	$('[data-toggle="popover"]').popover(); 
	
})






