<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Topics Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<h1><fmt:message bundle="${messages}" key="LIST_OF_ALL_TOPICS"/></h1>
<form action="exhibitions" method="post">

    <c:forEach items="${listOfTopics}" var="topic">
        <tr>
            <button type="Submit" name="topic" value="${topic}">
                <input type="hidden" name="command" value="allExpositions"/> ${topic}
            </button>
        </tr>
    </c:forEach>
</form>
</body>
</html>
