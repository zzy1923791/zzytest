<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%--引入JSP标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--引入C标签--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>University Enrollments</title>
    <%--标题:"大学招生"--%>

    <style>
        <%--CSS样式--%>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>

</head>


<body>
<h2>List of Employees</h2>
<table>
    <%--表头--%>
    <tr>
        <td>NAME</td><td>Joining Date</td><td>Salary</td><td>SSN</td><td></td>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <%--表内容--%>
        <tr>
            <td>${employee.name}</td>
            <td>${employee.joiningDate}</td>
            <td>${employee.salary}</td>
            <td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
            <%--编辑--%>
            <td><a href="<c:url value='/delete-${employee.ssn}-employee' />">delete</a></td>
            <%--删除--%>
        </tr>
    </c:forEach>
</table>
<br/>
<%--空标签--%>
<a href="<c:url value='/new' />">Add New Employee</a>
<%--"添加记录"超链, 指向Controller定义的"@RequestMapping(value = { "/new" }, method = RequestMethod.GET)"--%>
<%--"<a href="/new">Add New Employee</a>"--%>
</body>
</html>