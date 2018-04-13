<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<script>
	$(function(){
		$("#updateReviewBtn").click(function(e){
			var title = $("#updateReplyTitle").val();
			var content = $("#updateReplyContent").val();
			
			if(title == "" || title == null){
				alert("제목을 작성해 작성해주세요.");
				$("#updateReplyTitle").focus();
				return;
			}else if(content == "" || content == null){
				alert("본문을 작성해주세요.");
				$("#updateReplyContent").focus();
				return;
			}
			
			$("#updateReviewForm").submit();
		})
	})
</script>
<section>
	<div id="updateContainer">
		<div id="updateTextDiv">
			상품리뷰 작성
		</div>
		<div id="updateFormDiv">
			<form action="${pageContext.request.contextPath }/updateReview" method="POST" id="updateReviewForm">
				<input type="hidden" name="page" value="${cri.page }">
				<input type="hidden" name="perPageNum" value="30">
				<input type="hidden" name="boardNum" value="${boardNum }">
				<input type="hidden" name="sectionNum" value="${sectionNum }">
				<input type="hidden" name="replyNum" value="${replyNum }">
				<input type="hidden" name="readCheck" value="false">
				<div class="form-group">
				   <input type="text" class="form-control" id="updateReplyTitle" name="replyTitle" value="${reply.replyTitle }" placeholder="제목을 입력해주세요.">
				</div>
				<div class="form-group">
				   <textarea class="form-control" rows="5" id="updateReplyContent" name="replyContent" placeholder="상품리뷰를 작성해주세요. 고객님이 올려주신 상품에 관련된 글은 주관적인 의견으로 사실과 다르거나 보는 사람에 따라 다르게 해석될 수 있습니다.">${reply.replyContent }</textarea>
				</div>
				<input type="button" class="btn btn-default" id="updateReviewBtn" value="수정완료">
			</form>
			
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>