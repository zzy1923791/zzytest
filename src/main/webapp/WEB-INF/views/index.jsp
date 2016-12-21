<%--
  Created by IntelliJ IDEA.
  User: yuume
  Date: 16/12/12
  Time: 下午2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ht" uri="http://www.lacemile.com/tags/hellotag" %>
<%@ taglib prefix="img" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="cu" uri="/WEB-INF/hellotag.tld" %>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assets/css/hellotag.css" type="text/css" />
</head>
<body>

    <%--静态标签示例--%>
    <ht:Hello/>
    <br/>
    <%--动态标签示例--%>
    <ht:query
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/zzyDB"
            user="root"
            pass="123456"
            sql="select * from news_inf"/>
    <br/>
    <%--带标签体的标签示例--%>
    <%
        //创建一个List对象
        List<String> a = new ArrayList<String>();
        a.add("hello");
        a.add("world");
        a.add("java");
        //将List对象放入page范围内
        pageContext.setAttribute("a" , a);
    %>
    <ht:iterator collection="a" item="item">
        <tr>
            <td>${pageScope.item}</td>
        </tr>
    </ht:iterator>

    <img src="/assets/img/Wechat.jpeg" alt="AAAAAAA"/>

    <%--<c:redirect url="/list" />--%>

    <c:redirect url="/card" />

</body>
</html>
