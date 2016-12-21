<%--
  Created by IntelliJ IDEA.
  User: yuume
  Date: 16/12/20
  Time: 下午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ht" uri="http://www.lacemile.com/tags/hellotag" %>
<%@ taglib prefix="card" uri="http://www.lacemile.com/tags/cardtag" %>
<html>
<head>
    <title>卡片测试页</title>
    <link rel="stylesheet" href="/assets/css/main.css" type="text/css" />
</head>
<body>

<%--卡片自定义标签 测试--%>
<%--Card:仅有一个可点击图片的卡片标签--%>
<card:C010 urlImage="/assets/img/card/A-2.jpg" />

<card:C010 urlImage="/assets/img/card/B-2.jpg" />

</body>
</html>
