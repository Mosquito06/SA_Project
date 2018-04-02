<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>EasyBuy</title>
<jsp:include page="include/header.jsp"/>
<style>
/* ---------------------------------------------------
   CONTENT
----------------------------------------------------- */
	
	#topBannerDiv{
		width: 100%;
		margin-top: 120px;
	}
	
	#topBannerDiv img{
		width: 100%;
	}
	
	div[class*='BannerText']{
		text-align: center;
		color: black;
		font-size: 40px;
		font-weight: bold;
		margin: 2% 0 4% 0;
	}
	
	div[class*='BannerText'] div{
		margin-top: 1%;
	}
	
	div[class*='BannerText'] div a{
		color: black;
		font-size: 18px;
	}
	
	#bottomBannerDiv img{
		width: 100%;
	}
	
/* ---------------------------------------------------
   MEDIAQUERIES
----------------------------------------------------- */
@media screen and (max-width: 700px){
		
	#topBannerDiv{
		width: 100%;
		margin-top: 50px; 
	} 
	
	div[class*='BannerText']{
		font-size: 15px;
		font-weight: bold;
		margin: 2% 0 4% 0;
	}
	
	div[class*='BannerText'] div a{
		font-size: 12px;
	}
	
	
}

@media screen and (min-width: 767px) and (max-width: 1023px){
	div[class*='BannerText']{
		font-size: 30px;
		font-weight: bold;
		margin: 2% 0 4% 0;
	}
	
}

</style>
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

<jsp:include page="include/footer.jsp"/>
