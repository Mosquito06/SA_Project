$(function(){
		//수량 input 이벤트 처리
		$(".cartOptionDiv input").keyup(function(){
			var pattern = /^[1-9]+$/;
			var value = $(this).val();
			var check = pattern.test(value);
			
			if(!check){
				$(this).val("");
				$(this).val("1");
			}
			
			getPrice($(this), value);
			
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
		})
	})
	
	function getPrice(button, amount){
		var span = button.parents(".cartText").next().find(".orderPrice");
		var price = span.attr("data-price");
		var totalPrice = price * amount;
		
		span.html(numberWithCommas(totalPrice) + " 원");
	}
	
	function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}