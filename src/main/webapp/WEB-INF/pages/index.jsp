<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Todo List</title>

<link href="${ctx }/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${ctx }/resources/style/style.css" rel="stylesheet">
<script src="${ctx }/resources/jquery/jquery-1.9.0.js"></script>
<script src="${ctx }/resources/bootstrap/js/bootstrap.js"></script>
</head>

<body>

	<div class="container-narrow">
		<div class="masthead">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">About</a></li>
			</ul>
			<h3 class="muted">Todo List</h3>
		</div>

		<hr>
		<div class="row-fluid">
			<div class="span12">
				<div class="btn-toolbar">
					<button type="button" class="btn">完成</button>
					<button type="button" class="btn">推迟</button>
					<div class="btn-group">
						<button class="btn dropdown-toggle" data-toggle="dropdown">
							更多操作 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">删除任务</a></li>
							<li class="divider"></li>
							<li><a href="#">优先级设为1</a></li>
							<li><a href="#">优先级设为2</a></li>
							<li><a href="#">优先级设为3</a></li>
						</ul>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>完成？</th>
							<th>优先级</th>
							<th>时间</th>
							<th>项目</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${items }">
							<tr>
								<td><input type="checkbox" name="chk" value="" /></td>
								<td><i class="icon-ok"></i></td>
								<td>${item.priority }</td>
								<td>${item.duration }</td>
								<td>${item.info }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="${ctx }/task/add" method="post">
				<div class="input-append">
					<input type="text" id="task" name="task" class="input-xxlarge"
						placeholder="add task" />
					<button type="submit" id="btnAdd" class="btn">Add</button>
				</div>
				</form>
			</div>
		</div>
		<div class="span6"></div>
		<hr>

		<div class="footer">
			<p>&copy; Company 2013</p>
		</div>

	</div>
	<!-- /container -->

</body>
</html>
