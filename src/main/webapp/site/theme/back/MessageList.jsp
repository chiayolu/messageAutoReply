<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
	<title>内容列表页面</title>
	<link href="<%=basePath%>site/css/all.css" rel="stylesheet" type="text/css" />
	<script language="javascript" type="text/javascript" src="<%=basePath%>site/js/common/jquery-1.8.0.min.js"></script>
	<script language="javascript" type="text/javascript" src="<%=basePath%>site/js/back/MessageList.js"></script>
</head>
<body style="background: #e1e9eb;">
	<script type="text/javascript">
		// 单条删除jquery语句
		function deleteOne(order_id){
			confirm_ = confirm("确定要删除这条数据吗？");
			if (confirm_) {
				$.ajax({
	                type:"POST",
	                url:'<%=basePath%>DeleteOneServlet.action?id='+order_id,
	                success:function(msg){
	                    //alert("test order");
	                    //all delete is success,this can be execute
	                    $("#tr_"+order_id).remove();
// 	                    alert("删除成功");
	                    alert(msg);
	                }
	            });
			}
		}
		
		// 批量删除成功提示
		$(function(){
			var mes = '<%=request.getAttribute("mes")%>';
			if (mes != 'null') {
				alert(mes);
			}
		});
	</script>
	<form action="<%=basePath%>List.action" id="mainForm" method="post">
		<div class="right">
			<div class="current">
				当前位置： <a href="javascript:void(0)" style="color: #6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					内容列表 <a class="btn03" href="#">新 增</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
						class="btn03" href="#" onclick="javascript:deleteBatch('<%=basePath%>');">删 除</a>
				</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">指令名称：</td>
							<td>
								<input id="command" name="command" type="text" class="allInput" value="${command}" />
							</td>
							<td width="90" align="right">描述：</td>
							<td>
								<input id="description" name="description" type="text" class="allInput" value="${description}" />
							</td>
							<td width="85" align="right">
								<input type="submit" class="tabSub" value="查 询" />
							</td>
						</tr>
					</tbody>
				</table>
				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
							<tr>
								<th>
									<!-- <input type="checkbox" id="all" onclick="#" /> -->
								</th>
								<th>序号</th>
								<th>指令名称</th>
								<th>描述</th>
								<th>指令内容</th>
							</tr>
							<c:forEach items="${messageList}" var="message"
								varStatus="status">
								<tr id="tr_${message.id}"
									<c:if test="${status.index % 2 != 0}">style="background-color: #ECF6EE;"
								</c:if>>
									<td>
										<input type="checkbox" name="id" value="${message.id}"/>
									</td>
									<%-- <td>${status.index + 1}</td> --%>
									<td>${message.id}</td>
									<td>${message.command}</td>
									<td>${message.description}</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp; 
<!-- 										<a href="<%=basePath%>DeleteOneServlet.action?id=${message.id}">删除</a> -->
										<!-- <a href="#" class="delete1">删除</a> -->
										<a href="#" onclick="deleteOne(${message.id})">删除</a>
									</td>
								</tr>
							</c:forEach>
							<%-- <input type="hidden" id="deleteOne1" name="id" value="<%=basePath%>DeleteOneServlet.action"> --%>
							<!-- <tr>
								<td><input type="checkbox" /></td>
								<td>1</td>
								<td>演示值1</td>
								<td>演示值2</td>
								<td><a href="#">修改</a>&nbsp;&nbsp;&nbsp; <a href="#">删除</a>
								</td>
							</tr>
							<tr style="background-color: #ECF6EE;">
								<td><input type="checkbox" /></td>
								<td>2</td>
								<td>演示值1</td>
								<td>演示值2</td>
								<td><a href="#">修改</a>&nbsp;&nbsp;&nbsp; <a href="#">删除</a>
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>3</td>
								<td>演示值1</td>
								<td>演示值2</td>
								<td><a href="#">修改</a>&nbsp;&nbsp;&nbsp; <a href="#">删除</a>
								</td>
							</tr>
							<tr style="background-color: #ECF6EE;">
								<td><input type="checkbox" /></td>
								<td>4</td>
								<td>演示值1</td>
								<td>演示值2</td>
								<td><a href="#">修改</a>&nbsp;&nbsp;&nbsp; <a href="#">删除</a>
								</td>
							</tr> -->
						</tbody>
					</table>
					<div class='page fix'>
						共 <b>4</b> 条 <a href='###' class='first'>首页</a> <a href='###'
							class='pre'>上一页</a> 当前第<span>1/1</span>页 <a href='###'
							class='next'>下一页</a> <a href='###' class='last'>末页</a> 跳至&nbsp;<input
							type='text' value='1' class='allInput w28' />&nbsp;页&nbsp; <a
							href='###' class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>

</html>
