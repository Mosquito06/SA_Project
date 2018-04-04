<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer>
	<div id="footerFirstDiv">
		<div>
			<div class="table-responsive"> 
				<table class="table">
				   <tbody>
				      <tr>
				      	<c:choose>
				      		<c:when test="${login == null }">
				      			<th><a data-toggle="modal" data-target="#loginModal">로그인</a></th>
				      		</c:when>
				      		<c:otherwise>
				      			<th><a href="${pageContext.request.contextPath }/loginOut">로그아웃</a></th>
				      		</c:otherwise>
				      	</c:choose>
				        <th>고객센터</th>
				        <th>SOCIAL</th>
				      </tr>
				      <tr>
				      	<c:choose>
				      		<c:when test="${login == null }">
				      			<th><a href="${pageContext.request.contextPath }/sign">회원가입</a></th>
				      		</c:when>
				      		<c:otherwise>
				      			<th></th>
				      		</c:otherwise>
				      	</c:choose>
				        <td><a href="#">주문배송조회</a></td>
				        <td></td>
				      </tr>
				      <tr>
				        <td></td>
				        <td><a href="#">1:1 이메일 문의</a></td>
				        <td></td>
				      </tr>
				      <tr>
				        <td></td>
				        <td><a href="#">이용약관</a></td>
				        <td></td>
				      </tr>
				   </tbody>
			  	</table>
			</div>
		</div>
	</div>
	<div id="footerSecondDiv">
		<div>
			<div class="table-responsive"> 
				<table class="table">
				   <tbody>
				      <tr>
				        <td>
				        	(유)EasyBuy 대표 김동환 서울시 강남구 테헤란로 152 (역삼동, 강남파이낸스센터 31층)
							통신판매업신고번호 20xx-대구-0xxxx 등록번호 220-xx-xxxxxx 사업자정보확인
							개인정보관리책임자 김동환 정보보호최고책임자 김동환 고객센터 전화문의 010-3634-0396
							FAX 02-xxxx-xxxx E-mail skykim10908@naver.com 
				        </td>
				        <td>
				        	안전거래를 위해 현금 등으로 결제 시 저희 쇼핑몰에서 가입한 
							KG 이니시스의 구매안전 서비스 (채무지급보증)를 이용하실 수 있습니다.
				        </td>
				      </tr>
				   </tbody>
			  	</table>
			</div>
		</div>
	</div>
	
	<div id="phoneText">
        	(유)EasyBuy 대표 김동환 서울시 강남구 테헤란로 152 (역삼동, 강남파이낸스센터 31층)
			통신판매업신고번호 20xx-대구-0xxxx 등록번호 220-xx-xxxxxx 사업자정보확인
			개인정보관리책임자 김동환 정보보호최고책임자 김동환 고객센터 전화문의 010-3634-0396
			FAX 02-xxxx-xxxx E-mail skykim10908@naver.com 
	</div>
</footer>
</body>
</html>