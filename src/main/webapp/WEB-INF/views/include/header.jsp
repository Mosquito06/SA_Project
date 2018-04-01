<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css?a=ad">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    	<li><a href="#">회원가입</a></li>
    	<li><a href="#">로그인</a></li>
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
	      <a class="navbar-brand" href="#"><img id="mainLogo" src="${pageContext.request.contextPath }/resources/img/main/logo.png"></a>
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
