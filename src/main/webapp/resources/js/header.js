$(function(){
	$("#searchBtn").css("padding", "9 12");
	
	// 로그인 처리
	$("#loginModal img:eq(1)").click(function(){
		var userId = $("#loginId").val();
		var userPw = $("#loginPw").val();
		
		if(userId == "" || userPw == ""){
			alert("공백이 존재합니다.");
			return;
		}
		
		var sendData = {id : userId, pw : userPw};

		$.ajax({
			url : contextPath + "/loginCheck",
			type : "POST",
			headers : {"Content-Type" : "application/json"},
			data : JSON.stringify(sendData),
			dataType : "text",
			success : function(result){
				if(result == "not exist"){
					alert("가입되지 않는 ID입니다.");
				}else if(result == "pw error"){
					alert("패스워드가 일치하지 않습니다.");
				}else if(result == "correct"){
					$("#loginForm").submit();
				}
			}
		})
	})
	
	// nav 버튼 처리
	$("#cartBtn").click(function(){
		if(login == "" || login == null){
			$("#navLoginAtag").trigger("click");
			return;
		}
		
		location.href = contextPath + "/basket";
	})
	
	$("#logoBtn").click(function(){
		location.href = "/saproject/";
	})
	
	$("#navText").click(function(){
		location.href = "/saproject/";
	})
	
	$("#loginNameA").click(function(){
		var css = $("#loginMenu").css("display");
		if(css == "none"){
			$("#loginMenu").css("display", "block");
		}else{
			$("#loginMenu").css("display", "none");
		}
		
	})
	
	$("#pcCartBtn").click(function(e){
		e.preventDefault();
		if(login == "" || login == null){
			$("#navLoginAtag").trigger("click");
			return;
		}
		
		location.href = contextPath + "/basket";
		
	})
	
	
	// 메뉴 hover 처리
	var target = null;
	
	$("#secondNavSecondDiv li").hover(function(){
		target = $(this).attr("data-hover");
		$("nav[class~=" + target + "]").css("display", "block");
	}, function(){
		$("nav[class~=" + target + "]").css("display", "none");
	})
	
	$("nav[class*=category]").mouseover(function(){
		$("nav[class~=" + target + "]").css("display", "block");
	})
	
	$("nav[class*=category]").mouseout(function(){
		$("nav[class~=" + target + "]").css("display", "none");
	})
	
	
})