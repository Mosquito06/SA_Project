<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				</c:if>
			</div>
			<div id="ContentBottomDiv">
				<ul>
					<c:forEach begin="1" end="30">
						<li class="boardLi">
						
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