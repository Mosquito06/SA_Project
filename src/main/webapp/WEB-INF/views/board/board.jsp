<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		var login = "${login}"; 
		
		$(".boardLi").click(function(){
			var goLocation = $(this).attr("data-location");
			location.href = goLocation;
		 })
		 
		 $("#addBtn").click(function(){  
			 if(login == "" || login == null){
					$("#navLoginAtag").trigger("click");
					return;
				}
			 
			 location.href = "${pageContext.request.contextPath }/add?sectionNum=${sectionNum}";
		 })
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
					${typeInfo.sectionName} <span>(${pageMaker.totalCount })</span>
					<button type="button" class="btn btn-default" id="addBtn">등록하기</button>
				</c:if>
			</div>
			<div id="ContentBottomDiv">
				<ul>
					<c:choose>
						<c:when test="${boards.size() > 0 }">
							<c:forEach var="item" items="${boards }">
								<li class="boardLi" data-location="${pageContext.request.contextPath }/read${pageMaker.makeQuery(pageMaker.cri.page)}&sectionNum=${sectionNum}&boardNum=${item.boardNum}">
									<div class="boardTop">
										<c:choose>
											<c:when test="${item.files.size() > 0 }">
												<img src="${pageContext.request.contextPath }/resources/img/sample.JPG">
											</c:when>
											<c:otherwise>
												<img src="${pageContext.request.contextPath }/resources/img/board/basicImg.jpg">
											</c:otherwise>
										</c:choose>
										
									</div>
									<div class="boardBottom">
										<div class="boardCountDiv">
											<span class="totlaCount">총 주문수량 : ${item.boardTotalCount }</span>
											<span class="viewCount">조회수 : ${item.boardCount }</span>
										</div>
										<div class="boardTextDiv">
											<span class="boardTitle">제목 : ${item.boardTitle }</span><br>
											<span class="boardInputDate">등록날짜 : <fmt:formatDate value="${item.boardDate }" pattern="yyyy-MM-dd"/> </span><br>
											<span class="boardPrice">가격 : <fmt:formatNumber value="${item.boardPrice }" currencyCode="KRW"/> 원</span><br>
											<span class="boardWriter">등록 : ${item.clientNum.name }</span>
										</div>
									</div>
								</li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<li class="noneContentLi">
								등록된 게시물이 존재하지 않습니다.
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div id="ContentPagingDiv">
				<ul class="pagination">
					<c:if test="${pageMaker.prev }">
						<li><a href="${pageContext.request.contextPath }/board${pageMaker.makeQuery(pageMaker.startPage - 1)}&sectionNum=${sectionNum}">Prev</a></li>
					</c:if>
					<c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						<li ${pageMaker.cri.page == page? 'class=active' : "" }><a href="${pageContext.request.contextPath }/board${pageMaker.makeQuery(page)}&sectionNum=${sectionNum}">${page }</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next }">
						<li><a href="${pageContext.request.contextPath }/board${pageMaker.makeQuery(pageMaker.endPage + 1)}&sectionNum=${sectionNum}">Next</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>