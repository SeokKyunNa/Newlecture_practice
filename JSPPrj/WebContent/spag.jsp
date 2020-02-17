<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	pageContext.setAttribute("result", "hello");
%>
<body>
	<%=request.getAttribute("result") %>입니다.<br >
	<!-- EL 표기 연습 -->
	${requestScope.result} 입니다.<br >
	${names[0] }<br >
	${notice.title }<br >
	${result}<br >
	${param.n }<br >
	${header.accept }<br >
	${pageContext.request.method }<br >
	${param.n ge 3 }<br >
	${empty param.n}<br >	<!-- (param.n == null || param.n == "") 같은 의미-->
	${empty param.n ? "값이 비어있습니다." : param.n }<br >
	${param.n / 2 }<br >
</body>
</html>