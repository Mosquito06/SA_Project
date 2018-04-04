<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>EasyBuy</title>
<jsp:include page="../include/header.jsp"/>

<section>
	<div id="topBannerContainer">
		<div id="topBannerDiv">
			<img src="${pageContext.request.contextPath }/resources/img/main/main_banner_1.jpg">
		</div>
		<div class="topBannerText">
			EasyBuy의 최고 인기 상품을 만나보세요.
			<div>
				<a href="#">자세히 보기</a>
			</div>
		</div>
	</div>
	
	<div id="bottomBannerContainer">
		<div id="bottomBannerDiv">
			<img src="${pageContext.request.contextPath }/resources/img/main/main_banner_2.jpg">
		</div>
		<div class="bottomBannerText">
			농장에서 직접 수확한 다양한 상품을 만나보세요.
			<div>
				<a href="#">자세히 보기</a>
			</div>
		</div>
	</div>




</section>

<jsp:include page="../include/footer.jsp"/>
