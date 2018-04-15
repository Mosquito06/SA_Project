$(function(){
	getOrderPrice();
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