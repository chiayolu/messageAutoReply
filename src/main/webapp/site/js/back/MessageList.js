
/**
 * 调用后台批量删除方法
 * */
function deleteBatch(bathPath) {
	if (confirm('您确认要执行批量删除操作！')) {
		$("#mainForm").attr("action", bathPath + "DeleteBatchServlet.action");
		$("#mainForm").submit();
	}
}