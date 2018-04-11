<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		var login = "${login}";
	
		$("#addReviewBtn").click(function(e){
			if(login == "" || login == null){
				$("#navLoginAtag").trigger("click");
				return;
			}
			
			var title = $("#replyTitle").val();
			var content = $("#replyContent").val();
			
			if(title == "" || title == null){
				alert("제목을 작성해 작성해주세요.");
				$("#replyTitle").focus();
				return;
			}else if(content == "" || content == null){
				alert("본문을 작성해주세요.");
				$("#replyContent").focus();
				return;
			}
			
			$("#addReviewForm").submit();
		})
	})
</script>
<section>
	<div id="reviewContainer">
		<div id="reviewTextDiv">
			상품리뷰 작성
		</div>
		<div id="reviewFormDiv">
			<form action="${pageContext.request.contextPath }/addReview" method="POST" id="addReviewForm">
				<input type="hidden" name="page" value="${cri.page }">
				<input type="hidden" name="perPageNum" value="30">
				<input type="hidden" name="boardNum" value="${boardNum }">
				<input type="hidden" name="sectionNum" value="${sectionNum }">
				<div class="form-group">
				   <input type="text" class="form-control" id="replyTitle" name="replyTitle" placeholder="제목을 입력해주세요.">
				</div>
				<div class="form-group">
				   <textarea class="form-control" rows="5" id="replyContent" name="replyContent" placeholder="상품리뷰를 작성해주세요. 고객님이 올려주신 상품에 관련된 글은 주관적인 의견으로 사실과 다르거나 보는 사람에 따라 다르게 해석될 수 있습니다."></textarea>
				</div>
				<input type="button" class="btn btn-default" id="addReviewBtn" value="작성완료">
			</form>
			
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>