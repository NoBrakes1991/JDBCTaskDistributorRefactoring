<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Task List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index">Task Distributor</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/createTask">Add new Task<span
                        class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">

    <h1>Tasks List</h1>

    <form method="post" action="filter">
        Start date: <input type="date" name="startDate">
        End date: <input type="date" name="endDate">
        <select name="period" itemtype="text">
            <option value="" label="------Set Period------"/>
            <option value="lastQuarter" label="Last Quarter"/>
            <option value="lastMonth" label="Last Month"/>
            <option value="lastWeek" label="Last Week"/>
            <option value="currentQuarterToDate" label="Current Quarter to Date"/>
            <option value="currentMonthToDate" label="Current Month to Date"/>
            <option value="currentWeekToDate" label="Current Week to Date"/>
        </select>
        <select name="assignee" itemtype="text">
            <option value="" label="All assignees"/>
            <c:forEach items="${uniqAssignee}" var="assignee">
                <option value="${assignee}"><c:out value="${assignee}"/></option>
            </c:forEach>
        </select>
        <button type="submit">Find</button>
    </form>

    <br>
    <h4>${messageSelectedFilter}</h4>
    <h3>${messageNotFound}</h3>
    <br>

    <div class="table-responsive-md">
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Summary</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Assignee</th>
            </tr>
            </thead>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.summary}</td>
                    <fmt:setLocale value="en_US"/>
                    <td><fmt:formatDate pattern="dd/MMM/yyyy" value="${task.startDate}"/></td>
                    <td><fmt:formatDate pattern="dd/MMM/yyyy" value="${task.endDate}"/></td>
                    <td>${task.assignee}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


</body>
</html>