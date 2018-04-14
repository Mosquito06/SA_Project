$(function(){
		// 첫 화면 가격 계산 함수 호출
		getTotalPrice()
	
		//수량 input 이벤트 처리
		$(".cartOptionDiv input").keyup(function(){
			var pattern = /^[0-9]+$/;
			var value = $(this).val();
			var check = pattern.test(value);
			
			if(!check){
				$(this).val("");
				$(this).val("1");
			}
			
			getPrice($(this), value);
			getTotalPrice();
			
		})
		
		// 수량 선택 버튼 이벤트
		$(".cartCountMinusBtn").click(function(){
			var input = $(this).parent().find("input");
			var value = Number(input.val());
			
			if(value > 1){
				value -= 1;
				input.val(value);
			}
			
			getPrice($(this), value);
			getTotalPrice();
		})
		
		$(".cartCountPlusBtn").click(function(){
			var input = $(this).parent().find("input");
			var value = Number(input.val());
			if(value >= 0){
				value += 1;
				input.val(value);
			}
			
			value = input.val();
			
			getPrice($(this), value);
			getTotalPrice();
		})
	})
	
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
	function getPrice(tag, amount){
		var span = tag.parents(".cartText").next().find(".orderPrice");
		var price = span.attr("data-basicPrice");
		var totalPrice = price * amount;
		
		span.attr("data-totalPrice", totalPrice);
		span.html(numberWithCommas(totalPrice) + " 원");
	}
	
	// 원 단위 콤마 함수
	function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}