<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		$("#mypageLeftDiv li a").click(function(e){
			var index = $("#mypageLeftDiv li a").index(this);		
			if(index == 0){
				location.href = contextPath + "/mypage";
			}else{
				e.preventDefault();
				alert("준비 중입니다.");
			}
		})
	})

</script>
<section id="mypageSection">
	<div id="mypageContainer">
		<div id="mypageLeftDiv">
			<ul>
				<li>
					MY PAGE
				</li>
				<li id="menuName">
					${login.name }님 안녕하세요.
				</li>
				<li>
					<span class="leftSpan">쇼핑정보</span>
					<ul>
						<li><a href="#" class="selectOrderMenu">주문 배송</a></li>
						<li><a href="#">취소 / 반품</a></li>
						<li><a href="#">반품 현황</a></li>
					</ul>
				</li>
				<li>
					<span class="leftSpan">나의정보</span>
					<ul>
						<li><a href="#">배송지 관리</a></li>
						<li><a href="#">회원정보 관리</a></li>
						<li><a href="#">비밀번호 변경</a></li>
						<li><a href="#">회원탈퇴</a></li>
					</ul>
				</li>
				<li>
					<span class="leftSpan">고객센터</span>
					<ul>
						<li><a href="#">1:1 E-mail 문의</a></li>
					</ul>
				</li>
				
			</ul>
			
			
		</div>
		<div id="mypageContentDiv">
			<figure>
				<figcaption>
					주문배송 / 배송현황 
				</figcaption>
				<table>
					<c:choose>
						<c:when test="${orders.size() > 0 }">
							<c:forEach var="order" items="${orders }">
								<tr class="mypageOrderInfo">
									<td>
										<table>
											<tr>
												<td colspan="4">
													<div>
														<span class="mypageBoldText">받으시는 분</span> ${order.orderRecipient } 고객님 | ${order.recipientPhone }
													</div>
													<div>
														<span class="mypageBoldText">주문날짜</span> <fmt:formatDate value="${order.orderDate }" pattern="yyyy-MM-dd"/>
													</div>
												</td>
											</tr>
											<tr> 
												<td colspan="4">
													<span class="mypageBoldText">주소</span> ${order.recipientAddress }
												</td>
											</tr>
											<tr>
												<th>
													상품
												</th>
												<th>
													수량
												</th>
												<th>
													주문금액
												</th>
												<th>
													배송정보
												</th>
											</tr>
											<tr>
												<td class="mypageOrderImgTd">
													<c:choose>
														<c:when test="${order.boardNum.files.size() > 0}">
															<img src="${pageContext.request.contextPath }/resources/upload${order.boardNum.files.get(0).filePath}">
														</c:when>
														<c:otherwise>
															<img src="${pageContext.request.contextPath }/resources/img/board/basicImg.jpg">
														</c:otherwise>
													</c:choose>
													<a href="${pageContext.request.contextPath }/read?sectionNum=${order.boardNum.sectionNum.sectionNum}&boardNum=${order.boardNum.boardNum}&readCheck=true">
										 				${order.boardNum.boardTitle }
										 			</a>
												</td>
												<td class="mypageOrderText">
													${order.orderAmount } 개
												</td>
												<td class="mypageOrderText">
													<fmt:formatNumber value="${order.orderPrice }" currencyCode="KRW"/> 원
												</td>
												<td class="mypageOrderText">
													<c:choose>
														<c:when test="${order.orderStatus == 'READY'}">
															배송 전
														</c:when>
														<c:when test="${order.orderStatus == 'ING'}">
															배송준비
														</c:when>
														<c:when test="${order.orderStatus == 'COMPLETE'}">
															배송완료
														</c:when>
														<c:when test="${order.orderStatus == 'CANCEL'}">
															주문취소
														</c:when>
													</c:choose>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</c:forEach>
							<tr id="pagingTr">
								<td>
									<ul class="pagination">
										<c:if test="${pageMaker.prev }">
											<li><a href="${pageContext.request.contextPath }/mypage${pageMaker.makeQuery(pageMaker.startPage - 1)}">Prev</a></li>
										</c:if>
										<c:forEach var="page" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
											<li ${pageMaker.cri.page == page? 'class=active' : "" }><a href="${pageContext.request.contextPath }/mypage${pageMaker.makeQuery(page)}">${page }</a></li>
										</c:forEach>
										<c:if test="${pageMaker.next }">
											<li><a href="${pageContext.request.contextPath }/mypage${pageMaker.makeQuery(pageMaker.endPage + 1)}">Next</a></li>
										</c:if>
									</ul>
								</td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr id="emptyOrderTr">
								<td>
									현재 진행중인 주문 / 배송 상품이 없습니다.
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</figure>
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>