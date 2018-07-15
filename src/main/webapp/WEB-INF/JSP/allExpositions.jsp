<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Expositions Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="/css/color.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1><fmt:message bundle="${messages}" key="LIST_OF_EXPOSITIONS"/></h1>
<form action="exhibitions" method="post">
    <table class="tg">
        <tr>
            <th width="100"></th>
            <th width="120"><fmt:message bundle="${messages}" key="TITLE"/></th>
            <th width="120"><fmt:message bundle="${messages}" key="PRICE"/></th>
            <th width="200"><fmt:message bundle="${messages}" key="SHOWROOM"/></th>
            <th width="200"><fmt:message bundle="${messages}" key="START_DATE"/></th>
            <th width="200"><fmt:message bundle="${messages}" key="FINISH_DATE"/></th>
        </tr>
        <c:forEach items="${listOfExpositions}" var="exposition">
            <tr>
                <td><label><input type="checkbox" name="exposition${exposition.expositionId}" onclick="setButton"
                                  value="${exposition.expositionId}"></label></td>
                <td>${exposition.title}</td>
                <td>${exposition.price}</td>
                <td>${exposition.showroom.title}</td>
                <td>${exposition.startDate}</td>
                <td>${exposition.finishDate}</td>
                <td>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${requestScope.noChoosen!=null}">
        <error>
            <fmt:message bundle="${messages}" key="NO_CHOSEN"/>
        </error>
    </c:if>
    <br>
    <button type="Submit" name="command" value="basket">
        <fmt:message bundle="${messages}" key="BUY"/>
    </button>
</form>
</body>
</html>

