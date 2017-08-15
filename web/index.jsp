<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>爬虫采集</title>
	<link rel="stylesheet" href="/css/reset.css">
	<link rel="stylesheet" href="/css/index.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
	<script src="/js/jquery.min.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script src="/js/table_task.js"></script>
	<script src="/js/index.js"></script>
</head>
<body>
	<div id="header">
		<img src="/image/logo.jpg" alt="" class="logo">
		<img src="/image/logo_title.png" alt="" class="l_title">
		<ul>
			<li>
				<img src="/image/u69.png" alt="">
				<div class="text">
					<p>降低人工开发成本</p>
					<span>无须代码轻松配置获取数据</span>
				</div>
			</li>
			<li>
				<img src="/image/u76.png" alt="">
				<div class="text">
					<p>实时自动更新数据</p>
					<span>精准完整获取目标数据</span>
				</div>
			</li>
			<li>
				<img src="/image/u83.png" alt="">
				<div class="text">
					<p>无缝对接自有系统</p>
					<span>支持多种CMS系统自动发布</span>
				</div>
			</li>
		</ul>
	</div>
	<div class="bg-wrapper">
		<div class="bg"></div>
	</div>
	<div id="content">
		<a href="new.jsp" target="_blank">新建任务</a>
		<div class="container">
			<table id="task" class="table table-striped table-bordered">
				<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>URL</th>
					<th>CREATED_AT</th>
					<th></th>
				</tr>
				</thead>
			</table>
		</div>
		<div id="detail-wrapper">
			<div id="detail">
				<p>任务名称：<span></span></p>
				<p>任务描述：<span></span></p>
				<p>抓取网址：<span></span></p>
				<div id="table_wrapper">
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
				<div class="close">×</div>
			</div>
		</div>
	</div>
</body>
<script>

	 	var mytable = $('#example').DataTable({

        ajax: {
            url: "/list_detail.jsp?taskName="+"null"
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

        var taskName = "";
        function detail(that) {
            $("#detail-wrapper").fadeIn();
            var name = $(that).parents("tr").children("td:nth-child(2)").text();
            var desc = $(that).parents("tr").children("td:nth-child(3)").text();
            var url = $(that).parents("tr").children("td:nth-child(4)").text();
            var time = $(that).parents("tr").children("td:nth-child(5)").text();
            $("#detail").children("p:first-child").children("span").text(name);
            $("#detail").children("p:nth-child(2)").children("span").text(desc);
            $("#detail").children("p:nth-child(3)").children("span").text(url);
            taskName = name;

            mytable.ajax.url("/list_detail.jsp?taskName="+taskName).load();
        }
</script>
</html>