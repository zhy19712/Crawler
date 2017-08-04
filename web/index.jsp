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
				<p>任务名称：<span>爬虫1</span></p>
				<p>任务描述：<span>我的第一个爬虫</span></p>
				<p>抓取网址：<span>www.baidu.com</span></p>
				<div id="table_wrapper"></div>
				<div class="close">×</div>
			</div>
		</div>
	</div>
</body>
<script>

</script>
</html>