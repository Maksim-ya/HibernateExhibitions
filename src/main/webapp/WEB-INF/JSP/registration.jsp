<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="/css/color.css" rel="stylesheet" type="text/css">
    <title>Registration</title>
</head>
<body>
<form name="registrationForm" method="POST" action="exhibitions">
    <input type="hidden" name="command" value="registration"/>
    <h2><fmt:message bundle="${messages}" key="REGISTRATION"/></h2><br/>
    <fmt:message bundle="${messages}" key="LOGIN"/>*:<br/>
    <input type="text" name="login" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <c:if test="${requestScope.loginNotUniqueErrorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="LOGIN_NOT_UNIQUE_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <fmt:message bundle="${messages}" key="PASSWORD"/>*:<br/>
    <input type="password" name="password" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <fmt:message bundle="${messages}" key="CONFIRM_PASSWORD"/>*:<br/>
    <input type="password" name="confirmPassword" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <c:if test="${requestScope.passwordsDoNotMatchErrorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="PASSWORDS_DO_NOT_MATCH_ERROR_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <fmt:message bundle="${messages}" key="FULL_NAME"/>*:<br/>
    <input type="text" name="fullName" value=""><br/>
    <c:if test="${requestScope.requiredFieldMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <fmt:message bundle="${messages}" key="EMAIL"/>*:<br/>
    <input type="text" name="email" value="">
    <c:if test="${requestScope.invalidEmailErrorMessage!=null}">
        <h6>
            <error>
                <fmt:message bundle="${messages}" key="INVALID_EMAIL_ERROR_MESSAGE"/>
            </error>
        </h6>
    </c:if>
    <br/>
    <h6>
        <info>
            <fmt:message bundle="${messages}" key="REQUIRED_FIELD_MESSAGE"/>
        </info>
    </h6>
        <button type="Submit">
            <fmt:message bundle="${messages}" key="REGISTRATION"></fmt:message>
        </button>
</form>
</body>
</html>
