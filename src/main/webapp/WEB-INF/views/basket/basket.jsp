<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<script>
	
</script>
<section>
	<div id="cartContainer">
		<div id="cartLeftDiv" class="table-responsive">
			<figure>
				<figcaption>
					장바구니<span>(0)</span>
				</figcaption>
				<table>
				 	<tr class="cartProduct"> 
				 		<td class="cartImg">
				 			<img src="${pageContext.request.contextPath }/resources/img/sample.jpg">
				 		</td>
				 		<td class="cartText">
				 			<span class="cartProductName">나이키 에어 베이퍼맥스 플라이니트 목 2</span>
				 			<div class="cartOptionDiv">
				 				<input type="text" value="1">
				 				<button>-</button>
				 				<button>+</button>
				 			</div>
				 			
				 		</td> 
				 		<td class="cartPrice">
				 			239,000 원
				 		</td>
				 		<td class="cartDelBtn">
				 			<button type="button" data-toggle="modal" data-target="#cartDelModal">X</button>
				 		</td>
				 	</tr>
				 		
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
        <button type="button" class="btn cartDelModalConfirm" data-dismiss="modal">확인</button>
      </div>
    </div>

  </div>
</div>

<jsp:include page="../include/footer.jsp"/>