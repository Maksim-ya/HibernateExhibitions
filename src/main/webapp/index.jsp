<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="messages" var="messages"/>
<html>
<head>
    <title>Index JSP</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<form action="exhibitions" method="get">
    <div align="right">
        <button type="Submit" name="command" value="localRu">
            RU
        </button>
        <button type="Submit" name="command" value="localEn">
            EN
        </button>
    </div>
    <button type="Submit" name="command" value="loginPage">
        <fmt:message bundle="${messages}" key="ENTER"/>
    </button>
    <button type="Submit" name="command" value="allTopics">
        <fmt:message bundle="${messages}" key="VIEW_ALL_TOPICS"/>
    </button>
</form>
<br>

</body>
</html>
