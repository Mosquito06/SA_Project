$(function(){
	// 파일 선택 버튼 클릭 시 숨겨둔 file 트리거 발동
	$("#updateFileBtn").click(function(){
		$("#updateImgFiles").trigger("click");
	})
	
	
	// 파일 첨부 시 미리보기
	$("#ImgFiles").change(function(){
		$("#imgPreviewDiv").empty();
		
		var file = document.getElementById("ImgFiles");
		
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
	
	// 입력 이벤트 처리
	$(".addCheck").each(function(i, obj){
		$(obj).keyup(function(){
			isCheckPattern($(this), i);
		})
		
	})
	
	// 등록 버튼 클릭 시 발생 이벤트 처리
	$("#addBoardBtn").click(function(e){ 
		e.preventDefault();
		var checkEmpty = false;		
		var checkCss = false;
		
		$(".addCheckMessage").each(function(i, obj){
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
		
		$(".addCheck").each(function(i, obj){
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
		
		$("#addForm").submit();
	})
	
})