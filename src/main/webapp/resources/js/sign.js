$(function(){
		$("#signFormDiv input[class='form-control']").each(function(i, obj){
			$(obj).keyup(function(){
				checkPattern($(this), i);
			})
		})
		
		$("#signFormDiv img").click(function(){
			var checkEmpty = false;
			var checkFalse = false;
			
			$("div.checkMessage").each(function(i, obj){
				var visible = $(obj).css("display");
				
				if(visible == "block"){
					$(obj).prev().find("input").focus();
					checkFalse = true;
					return false;
				} 	
			})
			
			if(checkFalse){
				return;
			}
			
			$("#signFormDiv input[class='form-control']").each(function(i, obj){
				var value = $(obj).val();
				if(value == "" || value.length == 0){
					$(obj).parent().next().css("display", "block").text("필수 입력 항목입니다.");
					$(obj).focus();
					checkEmpty = true;
					return false;
				}
			})
						
			
			if(checkEmpty){
				return;
			}else{
				var id = $("#signFormDiv input[class='form-control']:eq(0)").val();	
				
				$.ajax({
					url : contextPath + "/checkId",
					type: "get",
					data : {id : id},
					dataType : "text",
					success: function(result){
						if(result == "exist"){
							alert("이미 존재하는 이메일 입니다.");
							return;
						}
						
						$("#signForm").submit(); 
					}
				})
				
			}
		
		})
	
	})
	
	// 회원가입 예외 처리 함수
	function checkPattern(input, index){
		var value = input.val();
		var pattern = null;
		var message = "";
		
		if(value == "" || value.length == 0){
			input.parent().next().css("display", "block").text("필수 입력 항목입니다.");
			return;
		}
		
		if(index == 0){
			pattern = /^\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
			message = "이메일 형식으로 입력해주세요."
		}else if(index == 1){
			pattern = /(?=.*[!@#$%^&*()-_~])(?=.*[0-9])(?=.*[a-zA-Z]).{8,16}/;
			message = "영문/숫자/특수문자 조합 8~16자 조합으로 입력해주세요."
		}else if(index == 2){
			
			var getPw = input.parent().prev().prev().find("input").val();
			if(getPw != value){
				input.parent().next().css("display", "block").text("입력값이 일치하지 않습니다.");
			}else{
				input.parent().next().css("display", "none").text("필수 입력 항목입니다.");
			}
			return;
		}else if(index == 3){
			pattern = /^[a-zA-Z가-힣]{2,10}$/;
			message = "성명을 정확히 입력해주세요.";
		}else if(index == 4){
			pattern = /^[0-9]{11,12}$/;
			var containCheck = /[ㄱ-ㅎ가-힣a-zA-Z~!`@#$%^&*()_-]+/;
			
			if(containCheck.test(value)){
				message = "숫자만 입력 가능합니다.";
			}else{
				message = "";
			}
		}
			
		var check = pattern.test(value);
		
		if(!check){
			input.parent().next().css("display", "block").text(message);
		}else{
			input.parent().next().css("display", "none").text("필수 입력 항목입니다.");
		}
	}