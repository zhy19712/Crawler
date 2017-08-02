<%--
  Created by IntelliJ IDEA.
  User: zhy19712
  Date: 28/07/2017
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<div id="header">
    <ul>
        <li class="one">① 设置任务名称</li>
        <li class="two">② 设置网址</li>
        <li class="three">③ 完成</li>
    </ul>
</div>
<div id="content">
    <div class="first">
        <div class="name">
            <span>任务名：</span>
            <input type="text">
        </div>
        <div class="remake">
            <span>描&nbsp;&nbsp;&nbsp;&nbsp;述：</span>
            <input type="text">
        </div>
    </div>
    <div class="second">
        <span>采集网址：</span>
        <input type="text">
    </div>
    <div class="third">
        <span id="start">开始采集</span>
        <span id="stop">停止采集</span>
        <span id="end">完成采集</span>
        <i></i>
        <div id="container"></div>
        <%--<form action="/Hello.do" method = get>
          账号：<input type="text" name="" id="s">
          密码：<input type="text" name="" id="ss">
          <input type = submit name="submit">
        </form>>--%>
    </div>

</div>
<div id="btn">
    <span class="pre"></span>
    <span class="next"></span>
</div>
<div id="table_wrapper">
    <div id="table"></div>
</div>
</body>
<script src="http://localhost:8080/js/jquery.min.js"></script>
<script src="http://localhost:8080/js/zUI.js"></script>
<script src="http://localhost:8080/js/index.js"></script>
</html>