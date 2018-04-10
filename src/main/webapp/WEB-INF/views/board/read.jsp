<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	var boardNum = ${board.boardNum};

</script>
<section>
	<div id="readContainer">
		<div id="readLeftDiv">
			<c:forEach begin="1" end="6">
				<img src="${pageContext.request.contextPath }/resources/img/sam.jpg">
			</c:forEach>
		</div>
		
		<div id="readRightDiv">
			<div id="readTitle">
				${board.boardTitle }<br>
				<span><fmt:formatNumber value="${board.boardPrice}" currencyCode="KRW" /> 원</span>
			</div>
			<div id="readseller">
				<strong>판매자</strong><br>
				<span>이름: ${board.clientNum.name }</span><br>
				<span>주소: ${board.clientNum.address }</span><br>
				<span>전화번호: ${board.clientNum.phone }</span><br>
			</div>
			<div id="readContent">
				<strong>제품 소개</strong><br>  
			</div>
			<div id="readCountDiv">
				<strong>수량</strong><br> 
				<input type="text" value="1">
				<button>
					-
				</button>
				<button>
					+
				</button>
			</div>
			<div id="readBtnDiv">
				<button id="addBtn">장바구니</button>
				<button id="buyBtn">구매하기</button>
			</div>
			<div id="AsTextDiv">
				<strong>배송 / 반품 / AS</strong><br>
				<ul>
					<li>
						배송지역: 전국 (일부 지역 제외)
					</li>
					<li>
						배송비: 상품의 구매금액에 상관없이 모든 상품이 무료배송 됩니다.
					</li>
					<li>
						배송기간: 결제 후 3일 이내, 발송완료 등록 및 발송완료 문자 메시지를 받으신 후 고객님께 배달완료 되기까지 1~2일정도 소요됩니다.<br>
						(토요일, 공휴일 제외) 택배사 또는 고객사정(고객님 연락이 되지 않을 경우)으로 인해 배송이 지연되는 경우가 있으니 해당 택배사로 전화문의를 하시면 배송상태를 확인 하실 수 있습니다.
					</li>
					<li>
						유의사항: 고객님의 단순 변심으로 인한 반품의 경우에도 EasyBuy에서 배송비를 부담합니다.
						단, EasyBuy에서 지정된 택배사가 아닌 타 택배사 이용 시 고객님께 요금 부담이 발생됩니다.
					</li>
				</ul>
			</div>
			<div id="warningDiv">
				<strong>유의사항</strong><br>
				<span>유의 사항 없습니다.</span>
			</div>
			<div id="reviewConteinerDiv">
				<div id="reviewContent">
					<strong>REVIEWS(${pageMaker.totalCount })</strong> 
					<span id="reviewCollapseSpan"> + </span>
					<ul>
						<c:choose>
							<c:when test="${reples.size() > 0 }">
								<c:forEach var="reply" items="${reples }">
									<li class="reviewLi">
										<span class="reviewTitle">${reply.replyTitle }</span>
										<span class="reviewWriterAndDate">${reply.replyWriter } - <fmt:formatDate value="${reply.replyTime }" pattern="yyyy.MM.dd"/></span>
										<span class="reviewContent">${reply.replyContent }</span>
									</li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<div id="reviewPaging">
					<ul class="pagination">
						<c:if test="${pageMager.prev }">
							<li><a href="#">Prev</a></li>
						</c:if>
						<c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
							<li ${pageMaker.cri.page == page? 'class=active' : "" }><a href="${page }">${page }</a></li>
						</c:forEach>
						<c:if test="${pageMager.next }">
							<li><a href="#">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>



