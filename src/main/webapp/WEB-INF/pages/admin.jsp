<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
<h2>Administration page</h2>

<%--<form:form action="/admin/getEventById" method="get">--%>
<%--Search by id:--%>
<%--<input type="text" name="eventId">--%>
<%--<input type="submit" value="search">--%>
<%--</form:form>--%>

<h3>Events</h3>

<c:if test="${!empty events}">
    <table border="1" style="border-collapse: collapse;  padding: 20px; width: 600px">
        <tr>
            <th>ID</th>
            <th>DAY</th>
            <th>TIME</th>
            <th>FILM_ID</th>
            <th></th>
        </tr>
        <c:forEach items="${events}" var="event">
            <tr>
                <td>${event.id}</td>
                <td>${event.day}</td>
                <td>${event.time}</td>
                <td>${event.filmId}</td>
                <td><a href="<c:url value="/admin/remove/${event.id}"/>">remove</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:url var="addNewEvent" value="/admin/addNewEvent"/>

<h3>Add new event here: </h3>
<div>
    <form:form action="${addNewEvent}" modelAttribute="event" method="post">
        <h4>Day:</h4>
        <form:input path="day"/>
        <h4>Time:</h4>
        <form:input path="time"/>

        <form:select path="filmId">
            <form:option value="NONE" label="---Select film---"/>

            <c:forEach items="${films}" var="film">
                <form:option value="${film.id}">${film.name}</form:option>
            </c:forEach>

        </form:select>
        <br><br>
        <input type="submit" value="add event">
    </form:form>
</div>

<a id="addFilmLink" href="#">Add new film to database</a>

<div id="newFilmCreationForm" style="display: none">
    <form:form action="/admin/addNewFilm" modelAttribute="film" method="post"
               enctype="multipart/form-data">
        <h4>Name:</h4>
        <form:input path="name"/>
        <h4>Genre:</h4>
        <form:input path="genre"/>
        <h4>Upload picture for the film</h4>
        <input type="file" name="imageFile"/>
        <input type="submit" value="add film">
    </form:form>
</div>

<script>
    $("#addFilmLink").click(function () {
        if ($("#newFilmCreationForm")[0].style.display === "none") {
            $("#newFilmCreationForm").show("slow");
        } else {
            $("#newFilmCreationForm").hide("slow");
        }
    });
</script>

</body>
</html>
