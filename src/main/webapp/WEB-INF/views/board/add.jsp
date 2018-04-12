<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<section>
	<div id="addContainer">
		<div id="addMainText">
			게시글 등록
		</div>
		<div id="addFormDiv">
			<form action="${pageContext.request.contextPath }/add" method="post" id="addForm" enctype="multipart/form-data">
			  <input type="hidden" name="num" value="${sectionNum }">
			  <div class="form-group">
			    <input type="text" class="form-control addCheck" value="${login.name }" id="addName" name="name" placeholder="이름을 입력하세요." readonly="readonly">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control addCheck" id="addAddress" value="${login.address }" name="address" placeholder="주소를 입력하세요.">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control addCheck"  value="${login.phone }" id="addPhone" name="phone" placeholder="휴대폰 번호 '-'표 없이 입력해주세요." readonly="readonly">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			 <div class="form-group">
			    <input type="text" class="form-control addCheck" id="addBoardTitle" name="boardTitle" placeholder="제목을 입력하세요.">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control addCheck" id="addBoardPrice" name="boardPrice" placeholder="가격을 입력하세요.">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			   <div class="form-group">
			  	<textarea class="form-control addCheck" rows="5" id="addBoardContent" name="boardContent" placeholder="내용을 입력하세요."></textarea>
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			  	<input type="button" id="addFileBtn" value="파일선택">
			  	<input type="file" multiple="multiple" class="btn btn-danger" id="ImgFiles" name="ImgFiles" accept="image/*">
			  	<input type="submit" id="addBoardBtn" value="등록하기">
			  </div>
			  <div id="addImgMessage">
			  	※ 첫 번째 사진이 메인 사진으로 자동 등록 됩니다.<br>
			  	(게시판 사진은 435*435 사이즈에 최적화 되어 있습니다)
			  </div>
			</form>
		</div>
		<div id="imgPreviewDiv">
		
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>