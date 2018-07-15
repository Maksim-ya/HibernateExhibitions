<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="/css/color.css" rel="stylesheet" type="text/css">
</head>
<form action="exhibitions" method="get">
    <div align="right">
        <button type="Submit" name="command" value="localRu">
            RU
        </button>
        <button type="Submit" name="command" value="localEn">
            EN
        </button>
    </div>
</form>
<body>
<c:if test="${requestScope.logoutMessage!=null}">
    <h6>
        <success>
            <fmt:message bundle="${messages}" key="SUCCESS_LOGOUT_MESSAGE"/>
        </success>
    </h6>
</c:if>
<c:if test="${requestScope.registrationMessage!=null}">
    <h6>
        <success>
            <fmt:message bundle="${messages}" key="SUCCESS_REGISTRATION_MESSAGE"/>
        </success>
    </h6>
</c:if>
<h3><fmt:message bundle="${messages}" key="ENTER"></fmt:message></h3>
<form name="loginForm" method="POST" action="exhibitions">
    <input type="hidden" name="command" value="login"/>
    <fmt:message bundle="${messages}" key="LOGIN"></fmt:message>:<br/>
    <input type="text" name="login"><br/>
    <fmt:message bundle="${messages}" key="PASSWORD"></fmt:message>:<br/>
    <input type="password" name="password">
    <br/>
    <c:if test="${requestScope.errorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="LOGIN_ERROR_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <button type="submit">
        <fmt:message bundle="${messages}" key="ENTER"></fmt:message>
    </button>
</form>
<br>
<form action="exhibitions" method="get">
    <button type="Submit" name="command" value="registrationPage">
        <fmt:message bundle="${messages}" key="REGISTRATION"></fmt:message>
    </button>
</form>


</body>
</html>