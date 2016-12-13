<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittle</title>
</head>
<body>

<div class="spittleView">
	<div class="spittleMessage"><c:out value="${spittle.message}" /></div>
	<span class="spittleTime"><c:out value="${spittle.time}" /></span>
</div>

</body>
</html>
