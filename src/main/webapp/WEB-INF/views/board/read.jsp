<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section>
	<div id="readContainer">
		<div id="readLeftDiv">
			<c:forEach begin="1" end="6">
				<img src="${pageContext.request.contextPath }/resources/img/sam.jpg">
			</c:forEach>
		</div>
		
		<div id="readRightDiv">
		
		</div>
		
	</div>
</section>
<jsp:include page="../include/footer.jsp"/>



