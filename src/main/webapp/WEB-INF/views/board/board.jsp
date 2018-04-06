<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		
	})

</script>
<section id="boardSection">
	<div id="boardContainer">
		<div id="boardLeftNav">
			<c:if test="${typeInfo != null }">
				<ul>
					<li>${typeInfo.categoryName }</li>
					<li>${typeInfo.divisionName }
						<ul>
							<c:if test="${leftSection != null }">
								<c:forEach var="section" items="${leftSection }">
									<li><a href="${pageContext.request.contextPath }/board?sectionNum=${section.sectionNum}" ${section.sectionNum == sectionNum? 'class=selectMenu' : '' }>
									${section.sectionName }</a></li>
								</c:forEach>
							</c:if>
						</ul>
					</li>
				</ul>
			</c:if>
		</div>
		<div id="boardContent">
			<c:if test="${typeInfo.bannerFile != null }">
				<img src="${pageContext.request.contextPath }/resources/img/board/${typeInfo.bannerFile}">
			</c:if>
			<div id="ContentTopText">
				<c:if test="${typeInfo.sectionName != null }">
					${typeInfo.sectionName} <span>(게시물 갯수)</span>
					<button type="button" class="btn btn-default">등록하기</button>
				</c:if>
			</div>
			<div id="ContentBottomDiv">
				<ul>
					<c:forEach begin="1" end="30">
						<li class="boardLi">
							<div class="boardTop">
								<a href="#"><img src="${pageContext.request.contextPath }/resources/img/sample.JPG"></a>
							</div>
							<div class="boardBottom">
								<div class="boardCountDiv">
									<span class="totlaCount">총 주문수량 : 0</span>
									<span class="viewCount">조회수 : 0</span>
								</div>
								<div class="boardTextDiv">
									<span class="boardInputDate">등록날짜 : <%-- <fmt:formatDate value="2018-04-06 14:06:31" pattern="yyyy-MM-dd"/> --%> 2018-04-06 </span><br>
									<span class="boardTitle">제목 : 게시물 테스트 중</span><br>
									<span class="boardWriter">김동환(skykim10908)</span>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div id="ContentPagingDiv">
			
			</div>
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>