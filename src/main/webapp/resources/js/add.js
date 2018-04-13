$(function(){
	// 파일 선택 버튼 클릭 시 숨겨둔 file 트리거 발동
	$("#addFileBtn").click(function(){
		$("#ImgFiles").trigger("click");
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
				var div = $("<div>");
				var img = $("<img>").attr("src", e.target.result);
				div.append(img);
				$("#imgPreviewDiv").append(div);
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

	function isCheckPattern(input, index){
		var value = input.val();
		
		var emptyCheck = isEmptyCheck(input);
		if(emptyCheck){
			return;
		}
		
		if(index == 4){
			var pattern = /^[0-9]+$/;
			var check = pattern.test(value);
			
			if(!check){
				input.parent().next().css("display", "block").text("숫자만 입력가능합니다.");
			}else{
				input.parent().next().css("display", "none").text("필수 입력 항목입니다.");
			}
		}
	}
	
	
	function isEmptyCheck(input){
		var value = input.val();
		
		if(value == "" || value.length == 0){
			input.parent().next().css("display", "block").text("필수 입력 항목입니다.");
			return true;
		}else{
			input.parent().next().css("display", "none").text("필수 입력 항목입니다.");
			return false;
		}
	}