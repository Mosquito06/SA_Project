$(function(){
		// 첫 화면 가격 계산 함수 호출
		getTotalPrice()
	
		//수량 input 이벤트 처리
		$(".cartOptionDiv input").keyup(function(){
			var target = $(this).parent().attr("data-target");
			var pattern = /^[0-9]+$/;
			var value = $(this).val();
			var check = pattern.test(value);
			
			if(!check){
				$(this).val("");
				$(this).val("1");
			}
			
			getPrice($(this), value, target);
			getTotalPrice();
			
		})
		
		// 수량 선택 버튼 이벤트
		$(".cartCountMinusBtn").click(function(){
			var target = $(this).parent().attr("data-target");
			var input = $(this).parent().find("input");
			var value = Number(input.val());
			
			if(value > 1){
				value -= 1;
				input.val(value);
			}
			
			getPrice($(this), value, target);
			getTotalPrice();
		})
		
		$(".cartCountPlusBtn").click(function(){
			var target = $(this).parent().attr("data-target");
			var input = $(this).parent().find("input");
			var value = Number(input.val());
			if(value >= 0){
				value += 1;
				input.val(value);
			}
			
			value = input.val();
			
			getPrice($(this), value, target);
			getTotalPrice();
		})
		
		// 장바구니 삭제 버튼 이벤트
		$(".cartVisibleDelBtn").click(function(){
			var target = $(this).attr("data-target");
			$(this).next().trigger("click");
			$("#cartDelModalConfirm").attr("data-target", target);
		})
				
		
		$("#cartDelModalConfirm").click(function(){
			var target = $(this).attr("data-target");
			location.href = contextPath + "/delBasket?basketNum=" + target;
		})
	})
	
	// 총 가격 get 함수
	function getTotalPrice(){
		var span = $(".orderPrice");
		var totalPrice = 0;
		
		for(var i = 0; i < span.length; i++){
			var price = Number($(span[i]).attr("data-totalPrice"));
			totalPrice += price;
		}
		
		$(".rightTd").eq(0).html(numberWithCommas(totalPrice) + " 원");
		$(".rightTd").eq(4).html(numberWithCommas(totalPrice) + " 원");
	}
	
	// 가격 get 함수
	function getPrice(tag, amount, target){
		var span = tag.parents(".cartText").next().find(".orderPrice");
		var price = span.attr("data-basicPrice");
		var totalPrice = price * amount;
		var sendData = {orderAmount : amount, orderPrice : totalPrice};

		$.ajax({
			url : contextPath + "/basket/" + target,
			type : "put",
			headers : {"Content-Type" : "application/json"},
			data : JSON.stringify(sendData),
			dataType : "text",
			success: function(result){
				console.log(result);
			}
		})
		
		
		span.attr("data-totalPrice", totalPrice);
		span.html(numberWithCommas(totalPrice) + " 원");
	}
		
	// 원 단위 콤마 함수
	function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}