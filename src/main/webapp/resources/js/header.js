$(function(){
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
	
	$("#cartBtn").click(function(){
		
	})
	
	$("#logoBtn").click(function(){
		location.href = "/saproject/";
	})
	
	$("#navText").click(function(){
		
	})
})