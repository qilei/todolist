<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>to do list</title>
</head>
<body>
<h2>page location:WEB-INF/pages/index.jsp</h2>
<h2>Hello World!</h2>

<c:forEach items="${items }" var="item">
${item.info }<br/>
</c:forEach>
</body>
</html>
