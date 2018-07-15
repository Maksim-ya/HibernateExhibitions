<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <title>Welcome</title>
</head>
<body>
${userName}, <fmt:message bundle="${messages}" key="HELLO"/>
<h2><fmt:message bundle="${messages}" key="LIST_OF_YOUR_TICKETS"/></h2>
<table class="tg">
    <tr>
        <th width="120"><fmt:message bundle="${messages}" key="DATE"/></th>
        <th width="120"><fmt:message bundle="${messages}" key="TITLE"/></th>
        <th width="120"><fmt:message bundle="${messages}" key="SHOWROOM"/></th>
    </tr>
    <c:forEach items="${listOfTickets}" var="ticket">
        <tr>
            <td>${ticket.eventDate}</td>
            <td>${ticket.exposition.title}</td>
            <td>${ticket.exposition.showroom.title}</td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="exhibitions" method="get">
    <button type="Submit" name="command" value="allTopics">
        <fmt:message bundle="${messages}" key="VIEW_ALL_TOPICS"/>
    </button>
    <button type="Submit" name="command" value="logout">
        <fmt:message bundle="${messages}" key="LOGOUT"></fmt:message>
    </button>
</form>
</body>
</html>

