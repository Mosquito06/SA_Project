<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp"/>
<style>
/* ---------------------------------------------------
   CONTENT
----------------------------------------------------- */
	

	#boardSection{
		min-height: 700px;
	}
	
	
	#boardContainer{
		width: 100%;
		min-height: 700px;
		margin: 131px auto 0;
		border: 1px solid black;
	}
	
	#boardLeftNav{
		float: left;
		width: 15%;
		border: 1px solid black;
		min-height: 700px;
	}
	
	#boardContent{
		float: right;
		width: 85%;
		border: 1px solid black;
		min-height: 700px;
	}


/* ---------------------------------------------------
   MEDIAQUERIES
----------------------------------------------------- */
@media screen and (max-width: 320px){
	

}

@media screen and (max-width: 700px){
	
}

@media screen and (min-width: 767px) and (max-width: 1023px){
	
}
</style>

<section id="boardSection">
	<div id="boardContainer">
		<div id="boardLeftNav">
			<c:if test="${typeInfo != null }">
				<ul>
					<li>${typeInfo.categoryName }</li>
					<li>${typeInfo.divisionName }
						<ul>
							<c:if test="${section != null }">
								<c:forEach var="section" items="section">
									
								</c:forEach>
							</c:if>
						</ul>
					</li>
				</ul>
			</c:if>
		</div>
		<div id="boardContent">
			
			
		</div>
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>