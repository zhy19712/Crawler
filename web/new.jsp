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
    <title>爬虫采集</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/j-select.css">
    <link rel="stylesheet" href="/css/new.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
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
        <span>选择网址：</span>
        <select id="myselect">
            <option value="www.baidu.com">www.baidu.com</option>
            <option value="www.sina.com.cn">www.sina.com.cn</option>
            <option value="www.tencent.com">www.tencent.com</option>
            <option value="www.mi.com">www.mi.com</option>
            <option value="www.huawei.com">www.huawei.com</option>
            <option value="www.1688.com">www.1688.com</option>
        </select>
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
    <div class="container"
        <table id="example" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>PATH</th>
                <th>TYPE</th>
                <th>CREATED_AT</th>
            </tr>
            </thead>
        </table>
    </div>

</div>
</body>
<script src="http://localhost:8080/js/jquery.min.js"></script>
<script src="/js/jquery-nicescroll.js"></script>
<script src="/js/jquery-jSelect.min.js"></script>
<script src="http://localhost:8080/js/new.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="/js/table_content.js"></script>

</html>