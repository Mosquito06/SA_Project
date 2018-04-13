<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		$("#continueBtn").click(function(){
			location.href = contextPath;
		})
	})
</script>
<section>
	<div id="basketContainer">
		<div id="basketMainText">
			장바구니<span>(0)</span>
		</div>
		<div id="basketContentDiv">
			<span class="glyphicon glyphicon-shopping-cart" id="cartSpan"></span>
			<div id="emptyBasketText">
				장바구니에 담긴 상품이 없습니다.
			</div>
			<button id="continueBtn">계속 쇼핑하기</button>
		</div>
	
	
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>