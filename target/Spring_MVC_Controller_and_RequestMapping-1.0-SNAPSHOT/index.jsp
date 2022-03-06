<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
未注册的用户，请
<a href="${pageContext.request.contextPath }/register"> 注册</a>！
<br /> 已注册的用户，去
<a href="${pageContext.request.contextPath }/login"> 登录</a>！
</body>
</html>