<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css?a=D">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css?a=ddd">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main.css?a=d">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/login.css?a=da">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/sign.css?a=a">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/complete.css?a=da">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css?a=a">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/read.css?a=sdd">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/review.css?a=sd">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
<script>
	var contextPath = "${pageContext.request.contextPath}";
	// js 파일에서는 el을 못쓰기 때문에 contextPath를 미리 받아둔 변수를 선언해둠
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/sign.js?a=a"></script>
<script src="${pageContext.request.contextPath }/resources/js/header.js?a=da"></script>
<script src="${pageContext.request.contextPath }/resources/js/read.js?a=sddd"></script>

</head>
<body>

<!-- 최상단 nav -->
<nav class="navbar navbar-inverse navbar-fixed-top TopNav"> 
  <div class="container-fluid">
    <div class="navbar-header">
            
      <button type="button" class="navbar-toggle" id="topNavBtn" data-toggle="collapse" data-target="#myNavbar">
        <span class="glyphicon glyphicon-menu-hamburger"></span>
      </button>
     
      <button type="button" class="navbar-toggle" id="cartBtn" data-toggle="collapse">
        <span class="glyphicon glyphicon-shopping-cart"></span>
      </button>
      
      <c:choose>
   		<c:when test="${login == null }">
		  <button type="button" class="navbar-toggle" id="logoBtn" data-toggle="collapse">
	        <img src="${pageContext.request.contextPath }/resources/img/main/logo.png">
	      </button>
   		</c:when>
      	   <c:otherwise>
      	   	<button type="button" class="navbar-toggle" id="navText" data-toggle="collapse">
	        	${login.name }
	        </button>
      		 
      	   </c:otherwise>
      	</c:choose>
    </div>
    
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      	<c:choose>
      		<c:when test="${login == null }">
      			<li><a href="${pageContext.request.contextPath }/sign">회원가입</a></li>
    			<li><a data-toggle="modal" data-target="#loginModal" id="navLoginAtag">로그인</a></li>
      		</c:when>
      		<c:otherwise>
      			<li><a href="#" id="loginNameA">${login.name }</a></li>
      		</c:otherwise>
      	</c:choose>
    	
    	<!-- 반응형 메뉴 처리 -->
    	<c:if test="${category != null }">
    		<c:forEach var="category" items="${category }">
    			<li class="mobileCategory"><a href="#">${category.categoryName }</a></li>
    			<c:if test="${division != null }">
    				<c:forEach var="division" items="${division }">
    					<li class="dropdown mobileDropdown">
    					<c:if test="${category.categoryNum == division.category.categoryNum }">
    						<a class="dropdown-toggle mobileDropdownA" data-toggle="dropdown" href="#">${division.divisionName }
				       		<span class="caret"></span></a>
    						<c:if test="${section != null }">
    							<ul class="dropdown-menu">
    							<c:forEach var="section" items="${section }">
    								<c:if test="${division.divisionNum == section.division.divisionNum }">
										<li><a href="${pageContext.request.contextPath }/board?sectionNum=${section.sectionNum}">${section.sectionName }</a></li>
									</c:if>		
    							</c:forEach>
    							</ul>
    						</c:if>
    					</c:if>
    					  </li>
   					</c:forEach>
				</c:if>
    		</c:forEach>
    	</c:if>
    	    	
        <li><a href="#" class="mobileNavBack">고객센터</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
      </ul>
    </div>
   </div>
</nav>

<!-- 두번쨰 nav -->
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
	  	 	<c:if test="${category != null }">
	  	 		<c:forEach var="category" items="${category }">
	  	 			 <li data-hover="category${category.categoryNum }"><a href="#">${category.categoryName}</a></li>	
	  	 		</c:forEach>
	  	 	</c:if>
		</ul>
	  </div>
	  
	  <div class="col-md-2 col-sm-3" id="secondNavThirdDiv">
	  	<form class="navbar-form navbar-right" action="/action_page.php">
		  <div class="input-group">
		    <input type="text" class="form-control" placeholder="Search">
		    <div class="input-group-btn">
		      <button class="btn btn-default" type="submit" id="searchBtn">
		        <i class="glyphicon glyphicon-search"></i>
		      </button>
		    </div>
		  </div>
		</form>
	  </div>
	  
	</div>
   </div>
</nav>

<!-- hover nav -->
<c:if test="${category != null }">
	<c:forEach var="category" items="${category }">
	   <nav class="navbar navbar-inverse navbar-fixed-top hoverNav category${category.categoryNum }">
		  <div class="container-fluid">
		    	<ul class="nav navbar-nav hoverUl">
		    		<c:if test="${division != null }">
		    			<c:forEach var="division" items="${division}">
			    			<c:if test="${category.categoryNum == division.category.categoryNum }">
			    				<li class="divisionLi"><a href="#" class="divisionA">${division.divisionName }</a>
			    					<c:if test="${section != null }">
			    						<ul>
			    							<c:forEach var="section" items="${section }">
												<c:if test="${division.divisionNum == section.division.divisionNum }">
													<li><a href="${pageContext.request.contextPath }/board?sectionNum=${section.sectionNum}" class="sectionA">${section.sectionName }</a></li>
												</c:if>		    							
			    							</c:forEach>
			    						</ul>
			    					</c:if>
			    				</li>	
			    			</c:if>
		    			</c:forEach>
		    		</c:if>
				</ul>
		   </div>
		</nav>	
	</c:forEach>
</c:if>

<!-- 로그인 modal -->
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
				  <input type="hidden" name="query" value="${pageContext.request.queryString }">
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

<!-- 로그인 시 메뉴 -->
<div id="loginMenu">
	<ul>
		<li><a href="#">마이페이지</a></li>
		<li><a href="${pageContext.request.contextPath }/loginOut">로그아웃</a></li>
	</ul>
</div>

	  	 			