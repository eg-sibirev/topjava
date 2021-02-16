<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://example.com/functions" prefix="f" %>

<c:set var="fntColour" scope="session" value="green"/>

<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table border="2">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
    </tr>

    <c:forEach items="${meals}" var="meal">

        <c:choose>
            <c:when test="${meal.excess == false}">
                <c:set var="fntColour" value="red"/>
            </c:when>
            <c:otherwise>
                <c:set var="fntColour" value="green"/>
            </c:otherwise>
        </c:choose>

        <tr style="color: ${fntColour}">
            <td>${f:formatLocalDateTime( meal.dateTime, 'yyyy-MM-dd HH:mm')} </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>