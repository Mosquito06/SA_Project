<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	var boardNum = ${board.boardNum};
	var loginId = "${login.id}";
</script>
<script id="template" type="text/x-handlebars-template">
	{{#each.}}
		<li class="reviewLi">
			{{#if replyId}}
				<span class="label label-warning reviewUpdate" 
					data-href="${pageContext.request.contextPath }/updateReview${pageMaker.makeQuery(cri.page) }
					&boardNum=${boardNum}&sectionNum=${sectionNum}&replyNum={{replyNum}}">수정
				</span>
				<span class="label label-danger reviewDelete" data-del="{{replyNum }}">삭제</span>
			{{/if}}
			<span class="reviewTitle">{{replyTitle}}</span>
			<span class="reviewWriterAndDate">{{replyWriter}} - {{setDate replyTime}}</span>
			<span class="reviewContent">{{replyContent }}</span>
		</li>
	{{/each}}
</script>
<section>
	<div id="readContainer">
		<div id="readLeftDiv">
			<c:choose>
				<c:when test="${board.files.size() > 0 }">
					<c:choose>
						<c:when test="${board.files.size() == 6 }">
							<c:forEach var="img" items="${board.files }">
								<img src="${pageContext.request.contextPath }/resources/upload${img.filePath}">
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="img" items="${board.files }">
								<img src="${pageContext.request.contextPath }/resources/upload${img.filePath}">
							</c:forEach>
							<c:forEach begin="1" end="${6 - board.files.size() }">
								<img src="${pageContext.request.contextPath }/resources/img/board/basicImg(435).png">
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:forEach begin="1" end="6">
						<img src="${pageContext.request.contextPath }/resources/img/board/basicImg(435).png">
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="readRightDiv">
			<div id="readTitle">
				${board.boardTitle }<br>
				<span data-price="${board.boardPrice}"><fmt:formatNumber value="${board.boardPrice}" currencyCode="KRW" /> 원</span>
			</div>
			<div id="readseller">
				<strong>판매자</strong><br>
				<span>이름: ${board.clientNum.name }</span><br>
				<span>주소: ${board.clientNum.address }</span><br>
				<span>전화번호: ${board.clientNum.phone }</span><br>
			</div>
			<div id="readContent">
				<strong>제품 소개</strong><br>
				${boardContent.boardContent }
			</div>
			<div id="readCountDiv">
				<strong>수량</strong><br> 
				<input type="text" value="1" id="readCountInput">
				<button id="readCountMinusBtn">
					-
				</button>
				<button id="readCountPlusBtn">
					+
				</button>
			</div>
			<div id="readBtnDiv">
				<button id="addBtn">장바구니</button>
				<button type="button" id="cartSuccessModalBtn" data-toggle="modal" style="display:none" data-target="#cartSuccessModal"></button>
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
					<strong>REVIEWS(<span id="totalCountSpan">${pageMaker.totalCount }</span>)</strong>
					<span id="reviewCollapseSpan"> + </span>
					<a href="${pageContext.request.contextPath }/addReview${pageMaker.makeQuery(cri.page) }&boardNum=${boardNum}&sectionNum=${sectionNum}" id="reviewAddTag">리뷰 작성하기</a>
					<ul>

					</ul>
				</div>
				<div id="reviewPaging">
					<ul class="pagination">

					</ul>
				</div>
			</div>
			<c:if test="${board.clientNum.id == login.id }">
				<div id="DelAndUpBtnDiv">
					<strong>수정 / 삭제</strong><br>
					<button id="boardUpdateBtn" data-up="${pageContext.request.contextPath }/update${pageMaker.makeQuery(cri.page) }
					&boardNum=${boardNum}&sectionNum=${sectionNum}&readCheck=false">수정</button>
					<button id="boardDeleteBtn" data-del="${pageContext.request.contextPath }/del?boardNum=${boardNum}&sectionNum=${sectionNum}">삭제</button>
				</div>
			</c:if>
		</div>
		
	</div>
</section>

<div id="cartSuccessModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">상품이 추가되었습니다. 장바구니로 이동하시겠습니까??</h5>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn" data-dismiss="modal">취소</button>
        <button type="button" class="btn cartMoveConfirmBtn" data-dismiss="modal">확인</button>
      </div>
    </div>

  </div>
</div>
<jsp:include page="../include/footer.jsp"/>



