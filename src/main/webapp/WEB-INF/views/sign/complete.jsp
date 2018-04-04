<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		$("#completeContainer img").click(function(){
			location.href = "${pageContext.request.contextPath}/";
		})
	})
</script>
<section id="completeSection">
	<div id="completeContainer">
			<div id="completeMainText">
				회원가입이 완료되었습니다.
			</div>
			<div id="comleteSubText">
				회원가입이 성공적으로 완료되었습니다.<br>
				EasyBuy의 다양한 서비스를 이용해보세요.
			</div>
			<img src="${pageContext.request.contextPath }/resources/img/sign/completeBtn.jpg">
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>