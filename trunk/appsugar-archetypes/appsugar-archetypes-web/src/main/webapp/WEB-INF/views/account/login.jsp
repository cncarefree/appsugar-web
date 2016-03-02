<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title><spring:message code="login"/></title>
<script>
	
</script>
</head>

<body>
	<div class="center">
		<form id="loginForm" action="${ctx}/login" method="post" class="form-signin" autocomplete="off">
			<h2 class="form-signin-heading">
				<spring:message code="login"/>
			</h2>
			<c:if test="${login_error}">
				<div class="alert alert-danger fade in">
					<button class="close" data-dismiss="alert">×</button>
					<spring:message code="login.fail.message"/>
				</div>
			</c:if>
			<input type="text" id="username" name="username" value="${username}" class="form-control" placeholder="<spring:message code="loginName"/>" required
				tabindex="1" /> 
			<input type="password" id="password" name="password" class="form-control" required placeholder="<spring:message code="password"/>"
				tabindex="2" /> 
			<label class="checkbox" for="rememberMe"> <input type="checkbox" class="checkbox"
				id="rememberMe" name="rememberMe" tabindex="3" /> <spring:message code="rememberMe"/>
			</label> <input id="submit_btn" class="btn btn-lg btn-primary btn-block" type="submit" value="<spring:message code="login"/>" tabindex="4" /> 
		</form>
	</div>
</body>
</html>