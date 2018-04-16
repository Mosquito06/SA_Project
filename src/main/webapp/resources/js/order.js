$(function(){
	getOrderPrice();
	
	$(".orderCheck").each(function(i, obj){
		$(obj).keyup(function(){
			orderCheckPattern($(this), i);
		})
	})
	
	$("#finalOrderBtn").click(function(e){
		e.preventDefault();
		
		var checkEmpty = false;		
		var checkCss = false;
		
		$(".orderCheck").each(function(i, obj){
			var borderColor = $(obj).css("border-color");
			
			if(borderColor == "rgb(255, 0, 0)"){
				$(obj).focus();
				checkCss = true;
				return false;
			} 
		})
		
		if(checkCss){
			return;
		}
		
		$(".orderCheck").each(function(i, obj){
			var emptyCheck = isOrderEmptyCheck($(obj));
			if(emptyCheck){
				checkEmpty = true;
				$(obj).focus();
				return false;
			}
		})
		
		if(checkEmpty){
			return;
		}
		
		var checked = $(".orderPayCheckBox input").prop("checked");
		
		if(!checked){
			alert("상품, 가격, 할인, 배송정보 동의란을 체크해주세요.");
			return;
		}
		
		$("#orderForm").submit();
		
	})
	
})

	// 총 가격 get 함수
	function getOrderPrice(){
		var span = $(".finalOrderPrice");
		var totalPrice = 0;
		
		for(var i = 0; i < span.length; i++){
			var price = Number($(span[i]).attr("data-totalPrice"));
			totalPrice += price;
		}
		
		$(".orderRightTd").eq(0).html(numberWithCommas(totalPrice) + " 원");
		$(".orderRightTd").eq(4).html(numberWithCommas(totalPrice) + " 원");
		$("#finalOrderBtn").html(numberWithCommas(totalPrice) + " 원 결제하기");
		
	}

	function orderCheckPattern(input, index){
		var value = input.val();
		var pattern = null;
		var meessage = "";
		var emptyCheck = isOrderEmptyCheck(input);
		
		if(emptyCheck){
			return;
		}
		
		if(index == 0){
			pattern = /^\w{5,12}@[a-z]{2,10}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
			message = "이메일 형식으로 입력해주세요."
		}else if(index == 1 || index == 3){
			pattern = /^[0-9]+$/;
			var containCheck = /[ㄱ-ㅎ가-힣a-zA-Z~!`@#$%^&*()_-]+/;
			
			if(containCheck.test(value)){
				message = "숫자만 입력 가능합니다.";
			}else{
				message = "";
			}
		}		
		
		var check = pattern.test(value);
		
		if(!check){
			input.attr("placeholder", message).addClass("inputColor");
			input.css("border-color", "#FF0000").css("box-shadow", "inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6)"); 
		}else{
			input.removeClass("inputColor");
			input.css("border-color", "").css("box-shadow", ""); 
		}
	}
	
	function isOrderEmptyCheck(input){
		var value = input.val();
		
		if(value == "" || value.length == 0){
			input.attr("placeholder", "필수 입력 항목입니다.").addClass("inputColor");
			input.css("border-color", "#FF0000").css("box-shadow", "inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(255, 0, 0, 0.6)"); 
			return true;
		}else{
			input.removeClass("inputColor");
			input.css("border-color", "").css("box-shadow", ""); 
			return false;
		}
	}