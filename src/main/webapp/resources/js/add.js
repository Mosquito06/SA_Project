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
	
	$("#addBoardPrice").keyup(function(){
		var value = $(this).val();
		var pattern = /^[0-9]$/;
		
		if(value == "" || value.length == 0){
			$(this).parent().next().css("display", "block").text("필수 입력 항목입니다.");
			return;
		}
		
		var check = pattern.test(value);
		
		if(!check){
			$(this).parent().next().css("display", "block").text("숫자만 입력가능합니다.");
		}else{
			$(this).parent().next().css("display", "none").text("필수 입력 항목입니다.");
		}
	})
	
	
	
	$("#addBoardBtn").click(function(e){ 
		e.preventDefault();
		
		
		
	})

})