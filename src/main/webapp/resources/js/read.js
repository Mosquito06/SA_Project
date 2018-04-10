$(function(){
	
	// 댓글 Collapse 처리
	$("#reviewCollapseSpan").click(function(){
		var status = $(this).html();
		if(status == "+"){
			$("#reviewContent ul").slideDown(1000, function(){
				$("#reviewPaging ul").slideDown(500);
			});
			
			$(this).html("-");
		}else{
			$("#reviewPaging ul").slideUp(500, function(){
				$("#reviewContent ul").slideUp(1000);
			});

			$(this).html("+");
		}
	})
	
	// 댓글 페이징 클릭 시 처리
	$("#reviewPaging a").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href");
		getReples(page);
		
	})
	
})


function getReples(page){
	
	$.ajax({
		url : "${pageContext.request.contextPath}/read/" + boardNum + "/" + page,
		type : "get",
		dataType : "json",
		success : function(result){
			console.log(result);
		}
		
	})
	
}

