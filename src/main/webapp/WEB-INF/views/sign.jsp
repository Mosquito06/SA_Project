<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>EasyBuy</title>
<jsp:include page="include/header.jsp"/>
<section>
	<div id="signContainer">
		<div id="signMainText">
			회원가입
		</div>
		<div id="signFormDiv">
			<form action="/action_page.php">
			  <div class="form-group">
			    <input type="text" class="form-control" id="email" placeholder="mosquito@com">
			  </div>
			  <div class="checkMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="password" class="form-control" id="signPw" placeholder="영문 + 숫자 + 특수문자 조합 8 ~ 16자리 이내">
			  </div>
			  <div class="checkMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="password" class="form-control" id="confirmPw" placeholder="패스워드를 다시 입력해 주세요.">
			  </div>
			  <div class="checkMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control" id="name" placeholder="이름을 입력해주세요.">
			  </div>
			  <div class="checkMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control" id="phone" placeholder="휴대폰 번호 '-'표 없이 입력해주세요.">
			  </div>
			  <div class="checkMessage">
			  	필수 입력 항목입니다.
			  </div>
				
			   <div class="table-responsive">          
				<figure>
						<figcaption>개인정보 수집,이용동의</figcaption>
						<table class="table">
							<thead>
								<tr>
									<th>일시</th>
									<th>수집항목</th>
									<th>수집목적</th>
									<th>보유기간</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>가입시</td>
									<td>아이디, 이메일, 비밀번호, 이름, 전화번호</td>
									<td>회원식별 및 연락</td>
									<td>회원 아이디를 제외한 정보는 탈퇴 즉시 삭제 됨</td>
								</tr>
								<tr>
									<td>거래발생시(추가)</td>
									<td>성별, 주소, 결제수단정보, 수령인, 연락처</td>
									<td>결제 및 배송, 불만 처리시 본인확인</td>
									<td>전상법 등 관련 법률에 의한 보관기간</td>
								</tr>
							</tbody>
						</table>
						<figcaption>※ 약관 및 개인정보 취급방침은 홈페이지 하단에 전문이 게재되어 있습니다.</figcaption>
					</figure>
				</div>
				
				<div id="signFormBottomText">
					약관 및 개인정보 수집·이용동의 내용을<br>
					 확인하고, 동의합니다.
				</div>
				
			  <img src="${pageContext.request.contextPath }/resources/img/sign/signBtn.jpg">
			</form>
		</div>
	</div>
</section>

<jsp:include page="include/footer.jsp"/>