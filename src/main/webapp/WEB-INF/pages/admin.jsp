<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<h2>${gretting}</h2>
<h3>Cinema event list</h3>

<c:if test="${!empty cinemaEvents}">
    <table>
        <tr>
            <th>id</th>
            <th>description</th>
        </tr>
        <c:forEach items="${cinemaEvents}" var="events">
            <tr>
                <td>${events.id}</td>
                <td>${events.description}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
