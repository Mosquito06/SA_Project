<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
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
						<li><a href="#">주문 배송</a></li>
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
		
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>