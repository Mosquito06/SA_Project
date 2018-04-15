<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section>
	<div id="orderContainer">
		<div id="orderLeftDiv" class="table-responsive">
			<figure>
				<figcaption>
					주문 / 결제
				</figcaption>
				<form action="" method="post" id="orderForm">
					<table>
						<tr id="orderClientInfo">
							<td>
								<div class="orderInfo">
									<span>주문고객</span>
									<div class="form-group">
								    	<label for="email">아이디</label>
								    	<input type="text" class="form-control" value="${login.id }" id="orderId" placeholder="아이디">
								  	</div>
								  	<div class="form-group">
								    	<label for="email">연락처</label>
								    	<input type="text" class="form-control" value="${login.phone }" id="orderPhone" placeholder="-없이 입력">
								  	</div>
								</div>
							</td>
						</tr>
						<tr id="orderRecipientInfo">
							<td>
								<div class="orderInfo">
									<span>배송지 정보</span>
									<div class="form-group">
								    	<label for="email">받으시는분</label> 
								    	<input type="text" class="form-control" id="recipientId" placeholder="이름">
								  	</div>
								  	<div class="form-group">
								    	<label for="email">연락처</label>
								    	<input type="text" class="form-control" id="recipientPhone" placeholder="-없이 입력">
								  	</div>
								  	<div class="form-group">
								    	<label for="email">배송정보</label>
								    	<input type="text" class="form-control" id="recipientAddress" placeholder="예) 경산시 정평동">
								  	</div>
								</div>
							</td>
						</tr>
						<tr id="orderPayInfo">
							<td>
								<div class="orderInfo">
									<span>결제 수단 선택</span>
									<span class="payment">신용카드</span>
									<span class="payment">실시간 계좌 이체</span>
									<span class="orderPayText">
										주문한 상품은 영업일 3일(공휴일/주말제외)이내에 받아보실 수 있습니다.<br>
										상품준비에 에러사항이 있거나, 발송지연이 불가피한 경우 고객께 안내연락을 드립니다.									
									</span>
									<div class="checkbox orderPayCheckBox">
									  <label><input type="checkbox" value="">위 주문의 상품, 가격, 할인, 배송정보에 동의합니다.</label>
									</div>
									<button id="finalOrderBtn">36,000 원 결제하기</button>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</figure>
		</div>
		<div id="orderRightDiv" class="table-responsive">
			<figure>
				<figcaption>
					ORDER SUMMARY
				</figcaption>
				<table>
					<c:choose>
						<c:when test="${basketList != null }">
							<c:forEach var="basket" items="${basketList }">
								<tr class="orderProduct">
									<c:choose>
										<c:when test="${basket.boardNum.files.size() > 0 }">
											<td class="leftProductImg">
									 			<img src="${pageContext.request.contextPath }/resources/upload${basket.boardNum.files.get(0).filePath}">
									 		</td>
										</c:when>
										<c:otherwise>
											<td class="leftProductImg">
												<img src="${pageContext.request.contextPath }/resources/img/board/basicImg.jpg">
											</td>
										</c:otherwise>
									</c:choose>
							 		<td class="rigthProductInfo">
							 			${basket.boardNum.boardTitle }<br> 
							 			<span class="finalOrderPrice" data-basicPrice="${basket.boardNum.boardPrice }" data-totalPrice="${basket.orderPrice}">
							 				<fmt:formatNumber value="${basket.boardNum.boardPrice }" currencyCode="KRW" /> 원</span><br>
							 			${basket.orderAmount } 개
							 		</td>
							 	</tr>	
							</c:forEach>	
						</c:when> 
						<c:otherwise>
							<tr class="orderProduct">
						 		<c:choose>
									<c:when test="${board.files.size() > 0 }">
										<td class="leftProductImg">
								 			<img src="${pageContext.request.contextPath }/resources/upload${board.files.get(0).filePath}">
								 		</td>
									</c:when>
									<c:otherwise>
										<td class="leftProductImg">
											<img src="${pageContext.request.contextPath }/resources/img/board/basicImg.jpg">
										</td>
									</c:otherwise>
								</c:choose>
						 		<td class="rigthProductInfo">
						 			${board.boardTitle }<br> 
						 			<span class="finalOrderPrice" data-basicPrice="${board.boardPrice }" data-totalPrice="${board.boardPrice * amount}">
						 				<fmt:formatNumber value="${board.boardPrice }" currencyCode="KRW" /> 원</span><br>
						 			${amount } 개
						 		</td>
						 	</tr>
						</c:otherwise>
					</c:choose>
					<tr>
				 		<td class="orderLeftTd">상품금액</td>
				 		<td class="orderRightTd"></td>
				 	</tr> 
				 	<tr>
				 		<td class="orderLeftTd">배송비</td>
				 		<td class="orderRightTd">0 원</td>
				 	</tr>
				 	<tr>
				 		<td class="orderLeftTd">상품할인금액</td>
				 		<td class="orderRightTd colorText">0 원</td>
				 	</tr>
				 	<tr>
				 		<td class="orderLeftTd">주문할인금액</td>
				 		<td class="orderRightTd colorText">0 원</td>
				 	</tr>
				 	<tr id="orderTotalPay">
				 		<td class="orderLeftTd">총 결제 예정 금액</td>
				 		<td class="orderRightTd colorText"></td>
				 	</tr>
				 	<tr id="summaryText">
				 		<td colspan="2">
				 			전 상품 무료배송 입니다.<br>
							장기간 장바구니에 보관하신 상품은 시간이 지남에 따라 가격과 혜택이 변동 될 수 있으며, 최대 30일동안 보관됩니다.
				 		</td>
				 	</tr>
				</table>
			</figure>
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>