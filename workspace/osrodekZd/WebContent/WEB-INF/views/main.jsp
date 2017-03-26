<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<%@ include file="/WEB-INF/views/include/navbar.jsp" %>
<%@ page session="false"%>

<c:url value="/" var="welcomePage"/>
<c:url value="/login" var="loginPage"/>

<header>
<div class=bg-color">
<div class="container">
				<div class="row">
					<div class="banner-info">
						<div class="banner-logo text-center">
							<img src="${pageContext.servletContext.contextPath}/resources/img/logo.png" class="img-responsive">
						</div>
						<div class="banner-text text-center">
							<h1 class="white">Medical Center</h1>
							<p>Sign in to fully use the service!</p>
							<a href="{loginPage}" class="btn btn-appoint">Sign In</a>
						</div>		
					</div>
				</div>
			</div>
			</div>
			</header>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
