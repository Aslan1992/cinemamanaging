<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<h2>${gretting}</h2>

<%--<form:form action="/admin/getEventById" method="get">--%>
    <%--Search by id:--%>
    <%--<input type="text" name="eventId">--%>
    <%--<input type="submit" value="search">--%>
<%--</form:form>--%>

<h3>Cinema event list</h3>

<c:if test="${!empty filmEvents}">
    <table cellspacing="20">
        <tr>
            <th>ID</th>
            <th>DAY</th>
            <th>TIME</th>
            <th>FILM_INFO_ID</th>
        </tr>
        <c:forEach items="${filmEvents}" var="events">
            <tr>
                <td>${events.id}</td>
                <td>${events.day}</td>
                <td>${events.time}</td>
                <td>${events.filmInfoId}</td>
                <td><a href="<c:url value="/admin/remove/${events.id}"/>">remove</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:url var="addNewEvent" value="/admin/addNewEvent"/>
<h3>New event: </h3>
<form:form action="${addNewEvent}" modelAttribute="filmEvent" method="post">
    <p>DAY:</p>
    <form:input path="day" id="day"/>
    <p>TIME:</p>
    <form:input path="time" id="time"/>
    <br>
    <input type="submit" value="add event">
</form:form>
</body>
</html>
