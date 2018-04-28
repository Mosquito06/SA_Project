<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		$.ajax({
			url: contextPath + "/send?name=${clientName}",
			type: "get",
			dataType: "text",
			success : function(result){
				console.log(result);
			}
		})
		
		$("#completeContainer img").click(function(){
			location.href = "${pageContext.request.contextPath}/";
		})
	})
</script>
<section id="completeSection">
	<div id="completeContainer">
			<div id="completeMainText">
				주문이 완료되었습니다.
			</div>
			<div id="comleteSubText">
				${login.name }님의 주문이 성공적으로 접수되었습니다.<br>
				주문 내역은 마이페이지에서 확인하실 수 있습니다.
			</div>
			<img src="${pageContext.request.contextPath }/resources/img/order/orderCompleteBtn.jpg">
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>