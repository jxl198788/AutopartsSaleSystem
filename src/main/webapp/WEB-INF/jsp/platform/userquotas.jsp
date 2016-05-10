<%--describe: 用户配额管理页面页面样式 
	author: lyn
	create: 2016.04.08
	version: 0.1
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户配额管理页面</title>
<%@ include file="/jsp/head.jsp" %> 
<link href="${pageContext.request.contextPath}/static/css/platform/userquotas.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/bootstrap/dataTables.bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/bootstrap/dataTables.responsive.css" rel="stylesheet">

</head>
<body>
	<%@ include file="/jsp/nav.jsp" %>
	<div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12 page-div">
                <h3 class="page-header">配额管理</h3>
            </div>
        </div>
        <div class="row">
                <a href="#" id="bulk" class="right" style="margin-right:20px;">批量操作</a>
                <a id="bulk_cancel" class="right display-none" style="margin-right:20px;">取消</a>
                <a data-toggle="modal" id="bulk_up" class="right display-none" style="margin-right:20px;" onclick="bulkUp(this);">升级</a>
                <a data-toggle="modal" id="bulk_set" class="right display-none" style="margin-right:20px;" onclick="bulkSet(this);">设置</a>
        </div>
        <form id="userQuotasForm" action="${ctx }/platform/getUserQuotasList" method="post" enctype="multipart/form-data">
		</form>
        <div class="table-div" id="detail-info">
	        <div class="dataTable_wrapper">
                 <table class="table table-striped table-hover" id="dataTables-example">
			        <thead>
			        	<tr class="info">
			        		<th></th>
			        		<th>用户名</th>
				            <th>手机号</th>
				            <th>汽配商名称</th>
				            <th>角色</th>
				            <th>配额</th>
				            <th>操作</th>
			        	</tr>
			        </thead>
			        <tbody>
			        <c:forEach items="${userQuotasList }" var="c">
			        	<tr>
			        		<td><input type="checkbox" value="${c.id }"></td>
			        		<td><a href="#quotas_info_div" data-toggle="modal">${c.username }</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">${c.telphone }</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">${c.suppliername }</a></td>
	                        <td>${c.rolename }</td>
	                        <td>
	                        	<a href="#quotas_info_div" data-toggle="modal">高级查询 配额${c.high_quotas }-已分配${c.h_deal_quotas }-剩余${c.h_left_quotas } 
		                        <br/>已分配${c.h_deal_quotas }-已使用${c.h_use_quotas }-未使用${c.h_unuse_quotas }
		                        <br/>普通查询 配额${c.comm_quotas }-已分配${c.c_deal_quotas }-剩余${c.c_left_quotas } 
		                        <br/>已分配${c.c_deal_quotas }-已使用${c.c_use_quotas }-未使用${c.c_unuse_quotas }</a>
	                        </td>
	                        <td>
		                        <a data-toggle="modal" class="td-a1" onclick="setUserQuotas(this,${c.id });">设置</a>
		                        <a data-toggle="modal" class="td-a1" onclick="upUserQuotas(this,${c.id });">升级</a>
		                        <a class="td-a1">取消</a>
	                        </td>
			        	</tr>
			        </c:forEach>
			        </tbody>
			      </table>
	        </div>
	    </div>
	    <form id="setUserQuotas" action="${ctx }/platform/getUserQuotasByKeys" method="post" enctype="multipart/form-data">
		</form>
        <!--点击设置弹出  ---- 配额设置        begin-->
	    <div id="quotas_set_div" class="modal fade">
            <div class="modal-dialog" style="width: 70%;">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			            <!-- body  begin   遮罩只要修改body里的内容即可 ，以及最外层div的id -->
			            <div class="panel-body">
			                <div class="table-responsive">
			                    <table class="table">
			                        <thead>
			                            <tr>
							        		<th>用户名</th>
								            <th>手机号</th>
								            <th>汽配商名称</th>
								            <th>配额种类</th>
								            <th>配额</th>
								            <th>操作</th>
							        	</tr>
			                        </thead>
			                        <tbody id="setQuotaTable">
			                        <!-- 配额信息展示  -->
			                        </tbody>
			                    </table>
			                </div>
			            </div>
			            <!-- body  end -->
                    </div>
                </div>
            </div>
        </div>
        <!--点击设置弹出  ---- 配额设置        end-->
        <form id="upUserQuotas" action="${ctx }/platform/getUserQuotasUpByKeys" method="post" enctype="multipart/form-data">
		</form>
        <!--点击设置弹出  ---- 配额升级信息      begin-->
        <div id="quotas_detail_div" class="modal fade">
            <div class="modal-dialog" style="width: 70%;">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			            <!-- body  begin   遮罩只要修改body里的内容即可 ，以及最外层div的id -->
			            <div class="panel-body">
			                <div class="table-responsive">
			                    <table class="table">
			                        <thead>
			                            <tr>
							        		<th>用户名</th>
								            <th>手机号</th>
								            <th>汽配商名称</th>
								            <th>已支付配额套餐</th>
								            <th>当前配额</th>
							        	</tr>
			                        </thead>
			                        <tbody id="quotasUpTable">
			                        <!-- 配额升级信息展示  -->
			                        </tbody>
			                    </table>
			                </div>
			            </div>
			            <!-- body  end -->
                    </div>
                </div>
            </div>
        </div>
        <!--点击设置弹出  ---- 配额升级信息      end-->
        <!-- 配额层级详细情况    begin -->
        <div id="quotas_info_div" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
			            <!-- body  begin  遮罩只要修改body里的内容即可 ，以及最外层div的id -->
			            <div class="panel-body div-scroll">
					        <div>
					             <ul class="easyui-tree tree_font tree-scroll" id="quotas_info" ></ul>
					        </div>
			            </div>
			            <!-- body  end -->
	        		</div>
	    		 </div>
	        </div>
	    </div>
        <!-- 配额层级详细情况    end -->
    </div>
    <!-- /#page-wrapper -->
<script src="${pageContext.request.contextPath}/static/bootstrap/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/platform/userquotas.js"></script>
    
</body>
</html>