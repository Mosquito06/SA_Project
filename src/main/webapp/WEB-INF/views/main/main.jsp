<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>EasyBuy</title>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		$(".topBannerText a").click(function(e){
			e.preventDefault();
			
			$.ajax({
				url : contextPath + "/goMax",
				type : "get",
				dataType : "json",
				success : function(result){
					console.log(result);
					
					if(result.boardNum == 0){
						alert("인기 상품이 존재하지 않습니다.");
						location.href = "${pageContext.request.contextPath }/board?sectionNum=1";
					}else{
						location.href = "${pageContext.request.contextPath }/read?sectionNum=" + result.sectionNum + 
								"&boardNum=" + result.boardNum + "&readCheck=true";
					}
					
				}
			})
		})
	})
	
	
</script>
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
				<a href="${pageContext.request.contextPath }/board?sectionNum=1">자세히 보기</a>
			</div>
		</div>
	</div>
</section>

<jsp:include page="../include/footer.jsp"/>
