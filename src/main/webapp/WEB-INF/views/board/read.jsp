<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section>
	<div id="readContainer">
		<div id="readLeftDiv">
			<c:forEach begin="1" end="6">
				<img src="${pageContext.request.contextPath }/resources/img/sam.jpg">
			</c:forEach>
		</div>
		
		<div id="readRightDiv">
			<div id="readTitle">
				${board.boardTitle }
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
			
			</div>
			<div id="AsTextDiv">
			
			</div>
			<div id="warningDiv">
			
			</div>
			<div id="reviewDiv">
			
			</div>
		</div>
		
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>



