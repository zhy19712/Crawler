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
    <div class="container">
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
<script>
    var mytable = $('#example').DataTable({

        ajax: {
            url: "/list_detail.jsp?taskName=null"
        },
        "order": [[1, 'asc']],// dt默认是第一列升序排列 这里第一列为序号列，所以设置为不排序，并把默认的排序列设置到后面
        "serverSide": true,
        "columns": [
            {"data": "ID"},
            {"data": "TITLE"},
            {"data": "PATH"},
            {"data": "TYPE"},
            {"data": "CREATED_AT"}

        ],
        "columnDefs": [
            {
                "searchable": false,
                "orderable": false,
                "targets": [0.-1]
            }
        ],

        "language": {
            "lengthMenu": "每页_MENU_ 条记录",
            "zeroRecords": "没有找到记录",
            "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
            "infoEmpty": "无记录",
            "search": "搜索：",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "paginate": {
                "previous": "上一页",
                "next": "下一页"
            }
        }

    });

    //添加序号
    //不管是排序，还是分页，还是搜索最后都会重画，这里监听draw事件即可
    mytable.on('draw.dt',function() {
        mytable.column(0, {
            search: 'applied',
            order: 'applied'
        }).nodes().each(function(cell, i) {
            //i 从0开始，所以这里先加1
            i = i+1;
            //服务器模式下获取分页信息
            var page = mytable.page.info();
            //当前第几页，从0开始
            var pageno = page.page;
            //每页数据
            var length = page.length;
            //行号等于 页数*每页数据长度+行号
            var columnIndex = (i+pageno*length);
            cell.innerHTML = columnIndex;
        });
    }).draw();
</script>

</html>