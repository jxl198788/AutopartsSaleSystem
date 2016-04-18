<!--describe: 用户配额管理页面页面样式 
	author: lyn
	create: 2016.04.08
	version: 0.1
-->
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
        <div class="table-div" id="detail-info">
	        <div class="dataTable_wrapper">
                 <table class="table table-striped table-hover" id="dataTables-example">
			        <thead>
			        	<tr class="info">
			        		<th>用户名</th>
				            <th>手机号</th>
				            <th>汽配商名称</th>
				            <th>角色</th>
				            <th>配额</th>
				            <th>操作</th>
			        	</tr>
			        </thead>
			        <tbody>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#quotas_info_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_info_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td><a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a><a href="#quotas_detail_div" data-toggle="modal" id="update" class="td-a1">升级</a><a id="cancel" class="td-a1">取消</a></td>
			        	</tr>
			        </tbody>
			      </table>
	        </div>
	    </div>
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
			                        <tbody>
			                            <tr class="success">
			                                <td>5651@163.com</td>
					                        <td>1378932964</td>
					                        <td>康众汽配</td>
					                        <td>
					                        	<select id="sel_type" class="select-css left margin">
								                    <option value="">高级查询</option>
								                    <option value="">普通查询</option>
							                	</select>
							                </td>
					                        <td><span class="left">设置配额</span><input class="form-control form-group-input left" id="contact_user" type="text" placeholder="配额"><br/><span class="left">配额100-已分配80-剩余20 已分配80-已使用40-未使用40</span></td>
					                        <td><a id="save" name="" class="td-a2">确定</a><a id="cancel" class="td-a1" data-dismiss="modal" aria-label="Close">取消</a></td>
							        	</tr>
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
			                        <tbody>
			                            <tr class="success">
			                                <td>5651@163.com</td>
					                        <td>1378932964</td>
					                        <td>康众汽配</td>
					                        <td>20元高级查询配额10套餐</td>
					                        <td>高级查询 配额110-已分配80-剩余30 已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 已分配80-已使用40-未使用40</td>
							        	</tr>
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