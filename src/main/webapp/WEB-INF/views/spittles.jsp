<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Latest spittles</title>
</head>
<body>

<h1>Last Spittles:</h1>

<ul>
<c:forEach items="${spittleList}" var="spittle" >
	<li id="spittle_<c:out value="spittle.id"/>">
		<div class="spittleMessage">
			<c:out value="${spittle.message}" />
		</div>
		<div>
			<span class="spittleTime"><c:out value="${spittle.time}" /></span>
			<span class="spittleLocation">
				(<c:out value="${spittle.latitude}" />,
				<c:out value="${spittle.longitude}" />)
			</span>
		</div>
	</li>
</c:forEach>
</ul>

</body>
</html>
