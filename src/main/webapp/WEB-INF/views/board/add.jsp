<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		$("#addFileBtn").click(function(){
			$("#files").trigger("click");
		})
		
		$("#files").change(function(){
			$("#imgPreviewDiv").empty();
			
			var file = document.getElementById("files");
			
			if(file.files.length > 6){
				alert("최대 6장까지 등록가능합니다.");
				return;
			}
			
			$(file.files).each(function(i, file){
				var reader = new FileReader();
				reader.onload = function(e){
					var img = $("<img>").attr("src", e.target.result);
					$("#imgPreviewDiv").append(img);
				}
				
				reader.readAsDataURL(file);
				
			})
			
			$("#imgPreviewDiv").css("display", "block");
		})
	})
</script>
<section>
	<div id="addContainer">
		<div id="addMainText">
			게시글 등록
		</div>
		<div id="addFormDiv">
			<form action="" method="post" id="addForm" enctype="multipart/form-data">
			  <div class="form-group">
			    <input type="text" class="form-control" value="${login.name }" id="addName" name="name" placeholder="이름을 입력하세요." readonly="readonly">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="password" class="form-control" id="addAddress" name="address" placeholder="주소를 입력하세요.">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control"  value="${login.phone }" id="addPhone" name="phone" placeholder="휴대폰 번호 '-'표 없이 입력해주세요." readonly="readonly">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control" id="addBoardTitle" name="boardTitle" placeholder="제목을 입력하세요.">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			    <input type="text" class="form-control" id="addBoardPrice" name="boardPrice" placeholder="가격을 입력하세요.">
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			  	<textarea class="form-control" rows="5" id="addBoardContent" name="boardContent" placeholder="내용을 입력하세요."></textarea>
			  </div>
			  <div class="addCheckMessage">
			  	필수 입력 항목입니다.
			  </div>
			  
			  <div class="form-group">
			  	<input type="button" id="addFileBtn" value="파일선택">
			  	<input type="file" multiple="multiple" class="btn btn-danger" id="files" name="files" accept="image/*">
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