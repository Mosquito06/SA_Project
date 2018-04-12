<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp"/>
<section>
	<div id="updateContainer">
		<div id="updateMainText">
			게시글 수정
		</div>
		<div id="updateForm">
			<form action="${pageContext.request.contextPath }/update" method="post" id="updateForm" enctype="multipart/form-data">
			  <input type="hidden" name="num" value="${sectionNum }">
			  <div class="form-group">
			    <input type="text" class="form-control updateCheck" value="${login.name }" id="updateName" name="name" placeholder="이름을 입력하세요." readonly="readonly">
			  </div>
			  <div class="updateCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control updateCheck" id="updateAddress" value="${login.address }" name="address" placeholder="주소를 입력하세요." readonly="readonly">
			  </div>
			  <div class="updateCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control updateCheck"  value="${login.phone }" id="updatePhone" name="phone" placeholder="휴대폰 번호 '-'표 없이 입력해주세요." readonly="readonly">
			  </div>
			  <div class="updateCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			 <div class="form-group">
			    <input type="text" class="form-control updateCheck" value="${board.boardTitle }" id="updateBoardTitle" name="boardTitle" placeholder="제목을 입력하세요.">
			  </div>
			  <div class="updateCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control updateCheck" value="${board.boardPrice }" id="updateBoardPrice" name="boardPrice" placeholder="가격을 입력하세요.">
			  </div>
			  <div class="updateCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			   <div class="form-group">
			  	<textarea class="form-control updateCheck" rows="5" id="updateBoardContent" name="boardContent" placeholder="내용을 입력하세요.">${boardContent.boardContent }</textarea>
			  </div>
			  <div class="updateCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			  	<input type="button" id="updateFileBtn" value="파일선택">
			  	<input type="file" multiple="multiple" class="btn btn-danger" id="updateImgFiles" name="ImgFiles" accept="image/*">
			  	<input type="submit" id="updateBoardBtn" value="등록하기">
			  </div>
			  <div id="updateImgMessage">
			  	※ 첫 번째 사진이 메인 사진으로 자동 등록 됩니다.<br>
			  	(게시판 사진은 435*435 사이즈에 최적화 되어 있습니다)
			  </div>
			</form>
		</div>
		<div id="updateImgPreviewDiv">
			<c:if test="${board.files != null }">
				<c:forEach var="img" items="${board.files }">
					<img src="${pageContext.request.contextPath }/resources/upload${img.filePath}"> 
				</c:forEach>
			</c:if>
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>