var roomImg_delete_files = [];
var reservImg_delete_files = [];
var index = 0; 

$(function(){
	// input file change 이벤트
	$("#roomList").change("change", function(e){
		handleImgFileSelect(e,"roomImg_wrap", "roomImgDiv", "roomImgBtn");
	});
	$("#reservList").change("change", function(e){
		handleImgFileSelect(e, "reservImg_wrap", "reservImgDiv", "reservImgBtn");
	});
	
	// 객실 이미지 선택 버튼
	$("#TableDiv img:eq(0)").click(function(){
		 $("#roomList").trigger('click'); 
	})
	
	
	// 예약 이미지 선택 버튼
	$("#TableDiv img:eq(1)").click(function(){
		 $("#reservList").trigger('click'); 
	})
	
	// 추가 버튼
	$("img[src*='registerBtn']").click(function(){
		$("#registerRoom").trigger('click'); 
	})
	
	// 취소 버튼
	$("img[src*='cancelBtn']").click(function(){
		location.replace("/Project_JSP/adminRoom.do");
	})
	
	
	// 추가 버튼 submit 이벤트 호출 시
	$("#registerForm").submit(function(e){
		if($("#room_num").val() == "" || $("#room_num").val() == null){
			$("#room_num").focus();
			alert("객실을 작성해주세요.");
			return false;
		}
		
		if($("#room_info_name").val() == "" || $("#room_info_name").val() == null){
			$("#room_info_name").focus();
			alert("객실명을 작성해주세요.");
			return false;
		}
		
		if($("#room_size").val() == "" || $("#room_size").val() == null){
			$("#room_size").focus();
			alert("객실명을 작성해주세요.");
			return false;
		}
		
		if($("#roomGrade").val() == "선택하세요."){
			$("#roomGrade").focus();
			alert("객실등급을 선택해주세요.");
			return false;
		}
		
		if($("#bedType").val() == "선택하세요."){
			$("#bedType").focus();
			alert("침대타입을 선택해주세요.");
			return false;
		}
		
		if($("#viewType").val() == "선택하세요."){
			$("#viewType").focus();
			alert("전망을 선택해주세요.");
			return false;
		}
		
		if($("#room_price").val() == "" || $("#room_price").val() == null){
			$("#room_price").focus();
			alert("가격을 작성해주세요.");
			return false;
		}
		
		
		var roomImg_upload_files = [];
		var reservImg_upload_files = [];
		
		var roomImg_length = $(".roomImg_wrap li");
		var reservImg_length = $(".reservImg_wrap li");

		if($(roomImg_length).length == 0){
			alert("객실이미지를 등록하세요.");
			return false;
		}
		
		if($(reservImg_length).length == 0){
			alert("예약이미지를 등록하세요.");
			return false;
		}
		
		for(var i = 0; i < $(roomImg_length).length; i++){
			roomImg_upload_files.push($(".roomImg_wrap li:eq(" + i + ") > div img").attr("data-file"));

		}
		
		for(var i = 0; i < $(reservImg_length).length; i++){
			reservImg_upload_files.push($(".reservImg_wrap li:eq(" + i + ") > div img").attr("data-file"));
		}
		
		/*$("#roomImgUpload").val(roomImg_upload_files);
		$("#roomImgDelete").val(roomImg_delete_files);
		$("#reservImgUpload").val(reservImg_upload_files);
		$("#reservImgDelete").val(reservImg_delete_files);*/
		
		$("#registerForm").attr("action", "/Project_JSP/adminRoomAdd.do?room_info_name=" + $("#room_info_name").val() + 
				"&roomImgUpload=" + roomImg_upload_files + "&roomImgDelete=" + roomImg_delete_files + 
				"&reservImgUpload=" + reservImg_upload_files + "&reservImgDelete=" + reservImg_delete_files);
		
	})
	
	// 이미지 삭제 버튼
	$(document).on("click", "img[src*='btnDelete']", function(){
		var id = $(this).parent().prev().find("img").attr("id"); 
		var fileName = $(this).parent().prev().find("img").attr("data-file"); 
		deleteImageAction(id, fileName);
	})
		
})




function handleImgFileSelect(e, position, imgDiv, btnDiv) {
	
	// 이미지 정보들을 초기화
	 if(position == "roomImg_wrap"){
		 var length = $(".roomImg_wrap li");
		 if($(length).length >= 4){
			alert("최대 4장의 이미지만 등록할 수 있습니다. 삭제 후 다시 시도해주세요.");
			return;
		 };
		 
	 }else if(position == "reservImg_wrap"){
		 var length = $(".reservImg_wrap li");
		 if($(length).length >= 1){
			alert("최대 1장의 이미지만 등록할 수 있습니다. 삭제 후 다시 시도해주세요.");
			return;
		 };
	 }
	    
	var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);
		
    if(filesArr.length >= 5){
		alert("최대 4장의 이미지만 등록할 수 있습니다.");
    	return;
	}
        
    
	if(filesArr.length <= 0){
		alert("사진을 선택하세요.");
    	return;
	}
	   
     
    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")) {
        alert("확장자는 이미지 확장자만 가능합니다."); 
        return; 
    } 
	    
    var reader = new FileReader(); 
    reader.onload = function(e) {
    	  var html = 
    	  "<li>"
        	  + "<div class='"+ imgDiv +"'>" +
        	  		"<img src=\"" + e.target.result + "\" data-file='"+ f.name + "' id='" + imgDiv + "_" + index + "'>" +
        	  	"</div>" +
        	  	"<div class='"+ btnDiv +"'>" +
        	  		"<img src='/Project_JSP/img/adminpage/btnDelete.png'>" +
        	  	"</div>" +
 		  "</li>"; 
		// console.log("인풋 html")
        $("." + position).append(html);  
        index++;                
    } 
    reader.readAsDataURL(f);
  }); 
} 

//이미지 삭제
function deleteImageAction(id, fileName) {
    // console.log("index : "+index);
	var div = "." + id.split("_")[0];
	
	if(div == ".roomImgDiv"){
		roomImg_delete_files.push(fileName);
	}else if(div == ".reservImgDiv"){
		reservImg_delete_files.push(fileName);
	}	
	
	$("#"+ id).parents("li").remove();

}