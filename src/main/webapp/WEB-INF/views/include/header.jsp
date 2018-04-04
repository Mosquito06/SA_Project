<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css?a=a">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css?a=dd">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css?a=d">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css?a=da">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/sign.css?a=a">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/complete.css?a=da">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/sign.js?a=a"></script>
<script>
	
	$(function(){
		$("#loginModal img:eq(1)").click(function(){
			var userId = $("#loginId").val();
			var userPw = $("#loginPw").val();
			
			var sendData = {id : userId, pw : userPw};
			
			
			
			$.ajax({
				url : "${pageContext.request.contextPath}/loginCheck",
				type : "POST",
				headers : {"Content-Type" : "application/json"},
				data : JSON.stringify(sendData),
				dataType : "text",
				success : function(result){
					if(result == "not exist"){
						alert("가입되지 않는 ID입니다.");
					}else if(result == "pw error"){
						alert("패스워드가 일치하지 않습니다.");
					}else if(result == "correct"){
						$("#loginForm").submit();
					}
				}
			})
			
		})
	})

</script>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top TopNav"> 
  <div class="container-fluid">
    <div class="navbar-header">
            
      <button type="button" class="navbar-toggle" id="topNavBtn" data-toggle="collapse" data-target="#myNavbar">
        <span class="glyphicon glyphicon-menu-hamburger"></span>
      </button>
     
      <button type="button" class="navbar-toggle" id="cartBtn" data-toggle="collapse">
        <span class="glyphicon glyphicon-shopping-cart"></span>
      </button>
      
      <button type="button" class="navbar-toggle" id="logoBtn" data-toggle="collapse">
        <img src="${pageContext.request.contextPath }/resources/img/main/logo.png">
      </button>
      
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
    	<li><a href="${pageContext.request.contextPath }/sign">회원가입</a></li>
    	<li><a data-toggle="modal" data-target="#loginModal">로그인</a></li>
        <li><a href="#">고객센터</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
      </ul>
    </div>
   </div>
</nav>

<nav class="navbar navbar-inverse navbar-fixed-top" id="secondNav">
  <div class="container-fluid">
    <div class="row">
	  
	  <div class="col-md-1 col-sm-1" id="secondNavFirstDiv">
	  	<div class="navbar-header">
	      <a class="navbar-brand" href="${pageContext.request.contextPath }/"><img id="mainLogo" src="${pageContext.request.contextPath }/resources/img/main/logo.png"></a>
	    </div>
	  </div>
	  
	  <div class="col-md-9 col-sm-8" id="secondNavSecondDiv">
	  	 <ul class="nav navbar-nav">
	      <li><a href="#">농산물</a></li>
	      <li><a href="#">수산물</a></li>
		</ul>
	  </div>
	  
	  <div class="col-md-2 col-sm-3" id="secondNavThirdDiv">
	  	<form class="navbar-form navbar-right" action="/action_page.php">
		  <div class="input-group">
		    <input type="text" class="form-control" placeholder="Search">
		    <div class="input-group-btn">
		      <button class="btn btn-default" type="submit">
		        <i class="glyphicon glyphicon-search"></i>
		      </button>
		    </div>
		  </div>
		</form>
	  </div>
	  
	</div>
   </div>
</nav>

<div id="loginModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <img src="${pageContext.request.contextPath }/resources/img/main/logo.png">
      </div>
      <div class="modal-body">
        <div id="modalContent">
	        <form action="${pageContext.request.contextPath }/login" method="post" id="loginForm">
	        	<div class="form-group">
				  <label for="id">아이디</label>
				  <input type="text" class="form-control" id="loginId" name="id" placeholder="아이디">
				  <input type="hidden" name="path" value="${pageContext.request.requestURI }">
				</div>
				
				<div class="form-group">
				  <label for="pw">패스워드</label>
				  <input type="password" class="form-control" id="loginPw" name="pw" placeholder="패스워드">
				</div>
	        	
	        	<div class="checkbox">
				  <label><input type="checkbox" >아이디 기억하기</label>
				</div>
	        	
	        	<img src="${pageContext.request.contextPath }/resources/img/main/loginBtn.JPG">
	        </form>
        </div>
      </div>
      <div class="modal-footer">
		<div id="modalfooter">
			<a href="${pageContext.request.contextPath }/sign">회원가입</a>
			<a href="#">계정찾기</a>
		</div>       
      </div>
    </div>

  </div>
</div>

