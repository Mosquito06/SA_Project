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
	
	// Handlebars 날짜 포맷 및 함수 획득
	Handlebars.registerHelper("setDate", function(date){
		var dateObj = new Date(date);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		
		return year + "." + month + "." + date;
	})
	
	var templateFunc = Handlebars.compile($("#template").html());
	
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
						
			}
			
		})
		
	}
	
})






