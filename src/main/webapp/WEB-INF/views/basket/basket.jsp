<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<section>
	<div id="cartContainer">
		<div id="cartLeftDiv" class="table-responsive">
			<figure>
				<figcaption>
					장바구니<span>(${basketList.size() })</span>
				</figcaption>
				<table>
					<c:forEach var="basket" items="${basketList }">
						<tr class="cartProduct"> 
							<c:choose>
								<c:when test="${basket.boardNum.files.size() > 0 }">
									<td class="cartImg">
							 			<img src="${pageContext.request.contextPath }/resources/upload${basket.boardNum.files.get(0).filePath}">
							 		</td>
								</c:when>
								<c:otherwise>
									<td class="cartImg">
										<img src="${pageContext.request.contextPath }/resources/img/board/basicImg.jpg">
									</td>
								</c:otherwise>
							</c:choose>

					 		<td class="cartText">
					 			<span class="cartProductName">
						 			<a href="${pageContext.request.contextPath }/read?sectionNum=${basket.boardNum.sectionNum.sectionNum}&boardNum=${basket.boardNum.boardNum}&readCheck=true">
						 				${basket.boardNum.boardTitle }
						 			</a>
					 			</span>
					 			<div class="cartOptionDiv" data-target="${basket.basketNum }">
					 				<input type="text" value="${basket.orderAmount }">
					 				<button class="cartCountMinusBtn">-</button>
					 				<button class="cartCountPlusBtn">+</button>
					 			</div>
					 			
					 		</td> 
					 		<td class="cartPrice">
					 			<span class="orderPrice" data-basicPrice="${basket.boardNum.boardPrice }" data-totalPrice="${basket.orderPrice }"><fmt:formatNumber value="${basket.orderPrice }" currencyCode="KRW"/> 원</span>
					 		</td>
					 		<td class="cartDelBtn">
					 			<button class="cartVisibleDelBtn" data-target="${basket.basketNum }" type="button">X</button>
					 			<button style="display:none" type="button" data-toggle="modal" data-target="#cartDelModal">X</button>
					 		</td>
					 	</tr>					
					</c:forEach>
				</table>
			</figure>
		</div>
		<div id="cartRightDiv" class="table-responsive">
			<figure>
				<figcaption>
					ORDER SUMMARY
				</figcaption>
				<table>
				 	<tr>
				 		<td class="leftTd">상품금액</td>
				 		<td class="rightTd">0 원</td>
				 	</tr>
				 	<tr>
				 		<td class="leftTd">예상배송비</td>
				 		<td class="rightTd">0 원</td>
				 	</tr>
				 	<tr>
				 		<td class="leftTd">상품할인금액</td>
				 		<td class="rightTd colorText">0 원</td>
				 	</tr>
				 	<tr>
				 		<td class="leftTd">주문할인금액</td>
				 		<td class="rightTd colorText">0 원</td>
				 	</tr>
				 	<tr id="totalPay">
				 		<td class="leftTd">총 결제 예정 금액</td>
				 		<td class="rightTd colorText">0 원</td>
				 	</tr>
				 	<tr>
				 		<td colspan="2">
				 			<button id="cartOrderBtn">주문하기</button>
				 		</td>
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

<div id="cartDelModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">삭제하시겠습니까?</h5>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn" data-dismiss="modal">취소</button>
        <button type="button" class="btn" data-dismiss="modal" id="cartDelModalConfirm">확인</button>
      </div>
    </div>

  </div>
</div>

<jsp:include page="../include/footer.jsp"/>