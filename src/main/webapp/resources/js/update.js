$(function(){
	// 파일 선택 버튼 클릭 시 숨겨둔 file 트리거 발동
	$("#updateFileBtn").click(function(){
		$("#updateImgFiles").trigger("click");
	})
	
	
	// 파일 첨부 시 미리보기
	$("#updateImgFiles").change(function(){
				
		var file = document.getElementById("updateImgFiles");
		
		var currentLength = $("#updateImgPreviewDiv img").length;
		var newFileLength = file.files.length;
		
		var totlaLength = currentLength + newFileLength;
		
		if(totlaLength > 6){
			alert("최대 6장까지 등록가능합니다.");
			return;
		}
		
		$(file.files).each(function(i, file){
			var reader = new FileReader();
			reader.onload = function(e){
				var div = $("<div>");
				var img = $("<img>").attr("src", e.target.result);
				var button = $("<button>").attr("type", "button").addClass("btn btn-danger previewDelBtn").attr("data-del", file.name).text("삭제");
				div.append(img);
				div.append(button);
				$("#updateImgPreviewDiv").append(div);
			}
			
			reader.readAsDataURL(file);
			
		})

		$("#updateImgPreviewDiv").css("display", "block");
	})
	
	// 파일 미리보기 삭제
	$(document).on("click", ".previewDelBtn", function(){
		var currentLength = $("#updateImgPreviewDiv img").length;
		if(currentLength <= 1){
			$("#updateImgPreviewDiv").css("display", "none");
		}
		
		$(this).parent().remove();
		
		var target = $(this).attr("data-del");
		var input = $("<input>").attr("type", "hidden").attr("name", "updateDelFiles").attr("value", target);
		
		$("#boardUpdateForm").prepend(input);
	})
	
	
	// 입력 이벤트 처리
	$(".updateCheck").each(function(i, obj){
		$(obj).keyup(function(){
			isCheckPattern($(this), i);
		})
		
	})
	
	// 수정 버튼 클릭 시 발생 이벤트 처리
	$("#updateBoardBtn").click(function(e){ 
		e.preventDefault();
		var checkEmpty = false;		
		var checkCss = false;
		
		$(".updateCheckMessage").each(function(i, obj){
			var visible = $(obj).css("display");
			
			if(visible == "block"){
				$(obj).prev().find("input").focus();
				if(i == 5){
					$(obj).prev().find("textarea").focus();
				}
				checkCss = true;
				return false;
			} 
		})
		
		if(checkCss){
			return;
		}
		
		$(".updateCheck").each(function(i, obj){
			var emptyCheck = isEmptyCheck($(obj));
			if(emptyCheck){
				checkEmpty = true;
				$(obj).focus();
				return false;
			}
		})
		
		if(checkEmpty){
			return;
		}
		
		var exist = $("input[name='updateDelFiles']").length;
		
		if(exist == 0){
			var input = $("<input>").attr("type", "hidden").attr("name", "updateDelFiles").attr("value", "");
			$("#boardUpdateForm").prepend(input);
		}
		
		
		$("#boardUpdateForm").submit();
	})
	
})