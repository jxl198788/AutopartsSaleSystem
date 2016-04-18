<!--describe: 用户配额管理页面
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
<link href="${pageContext.request.contextPath}/static/css/supplier/userquotas.css" rel="stylesheet">
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
        </div>
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
			        	<tr>
			        		<td><input type="checkbox"></td>
			        		<td><a href="#quotas_tree_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td>
	                        	<a href="#quotas_check_div" data-toggle="modal" id="check" class="td-a1">审核(3)</a>
	                        	<a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a>
	                        	<a id="cancel" class="td-a1">取消</a>
                        		<a href="" class="ul-first">升级</a>
	                        </td>
			        	</tr>
			        	<tr>
			        		<td><input type="checkbox"></td>
			        		<td><a href="#quotas_tree_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td>
	                        	<a href="#quotas_check_div" data-toggle="modal" id="check" class="td-a1">审核(3)</a>
	                        	<a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a>
	                        	<a id="cancel" class="td-a1">取消</a>
                        		<a href="" class="ul-first">升级</a>
	                        </td>
			        	</tr>
			        	<tr>
			        		<td><input type="checkbox"></td>
			        		<td><a href="#quotas_tree_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td>
	                        	<a href="#quotas_check_div" data-toggle="modal" id="check" class="td-a1">审核(3)</a>
	                        	<a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a>
	                        	<a id="cancel" class="td-a1">取消</a>
                        		<a href="" class="ul-first">升级</a>
	                        </td>
			        	</tr>
			        	<tr>
			        		<td><input type="checkbox"></td>
			        		<td><a href="#quotas_tree_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td>
	                        	<a href="#quotas_check_div" data-toggle="modal" id="check" class="td-a1">审核(3)</a>
	                        	<a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a>
	                        	<a id="cancel" class="td-a1">取消</a>
                        		<a href="" class="ul-first">升级</a>
	                        </td>
			        	</tr>
			        	<tr>
			        		<td><input type="checkbox"></td>
			        		<td><a href="#quotas_tree_div" data-toggle="modal">5625@163.com</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td><a href="#quotas_tree_div" data-toggle="modal">高级查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40<br/>普通查询 配额100-已分配80-剩余20 <br/>已分配80-已使用40-未使用40</a></td>
	                        <td>
	                        	<a href="#quotas_check_div" data-toggle="modal" id="check" class="td-a1">审核(3)</a>
	                        	<a href="#quotas_set_div" data-toggle="modal" id="setting" class="td-a1">设置</a>
	                        	<a id="cancel" class="td-a1">取消</a>
                        		<a href="" class="ul-first">升级</a>
	                        </td>
			        	</tr>
			        </tbody>
			      </table>
	        </div>
	    </div>
        <!--点击升级弹出  ---- 升级套餐选择        begin-->
	    <div id="sel_type_div" style="display:none;position:absolute;">
			<ul id="rise-second" class="ul-second">
				<li><a href="#quotas_rise_div" data-toggle="modal">高级查询套餐</a></li><br/>
	          	<li><a href="#quotas_rise_div" data-toggle="modal">普通查询套餐</a></li>
			</ul>
		</div>
        <!--点击升级弹出  ---- 升级套餐选择        begin-->
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
					                        	<select class="select-css left margin">
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
        <!--点击审核弹出  ---- 审核信息      begin-->
        <div id="quotas_check_div" class="modal fade">
            <div class="modal-dialog" style="width: 65%;">
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
								            <th>配额</th>
								            <th>审核操作</th>
							        	</tr>
			                        </thead>
			                        <tbody>
			                            <tr class="success" valign="center">
			                                <td>5651@163.com</td>
					                        <td>1378932964</td>
					                        <td>康众汽配</td>
					                        <td><span class="left">申请高级查询配额</span><input class="form-control form-group-input left" type="text" value="30"><span style="margin-left:5px;">已分配20-已使用15-未使用5</span></td>
							        		<td><a id="pass" class="td-a2">通过</a><a id="reject" class="td-a1" data-dismiss="modal" aria-label="Close">拒绝</a></td>
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
        <!--点击审核弹出  ---- 审核信息      end-->
        <!-- 配额层级详细情况    begin -->
        <div id="quotas_tree_div" class="modal fade">
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
        <!-- 配额升级    begin -->
        <div id="quotas_rise_div" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content"><!-- 白色框 可去掉-->
                    <div class="modal-body">
			            <!-- body  begin  遮罩只要修改body里的内容即可 ，以及最外层div的id -->
				        <div class="panel panel-success quotas_form" id="">
				            <div class="panel-heading"><span id="rise_item" class="rise_item">高级查询套餐</span>
				                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
				            </div>
				            <div class="panel-body">
				                <div class="well left rise_pack_div">
			                        <h4>免费</h4>
			                        <p>高级查询5次</p>
			                        <button type="button" class="btn btn-success">选择</button>
			                    </div>
			                    <div class="well left rise_pack_div">
			                        <h4>20元/月</h4>
			                        <p>高级查询20次</p>
			                        <button type="button" class="btn btn-success">选择</button>
			                    </div>
			                    <div class="well left rise_pack_div">
			                        <h4 class="rise_h">30元/月</h4>
			                        <p>高级查询40次</p>
			                        <button type="button" class="btn btn-success">选择</button>
			                    </div>
				            </div>
				        </div>
				        <div id="rise_warning" class="panel panel-yellow rise_warning display_none">
	                        <div class="panel-heading">
	                            <div class="row">
	                                <div class="col-xs-9 text-center rise_head">
	                                    <div class="huge" style="font-size:16px;">变更套餐需支付<span id="rise_money">20</span>元</div>
	                                </div>
	                            </div>
	                        </div>
                            <div class="panel-footer">
                                <span class="pull-left"><button type="button" id="rise_ok" class="btn rise_margin1 left btn-outline btn-success">确定</button></span>
                                <span class="pull-right"><button type="button" id="rise_no" class="btn rise_margin2 left btn-outline btn-success">取消</button></span>
                            </div>
	                    </div>
			            <!-- body  end -->
	        		</div>
	    		 </div>
	        </div>
	    </div>
        <!-- 配额升级   end -->
    </div>
    <!-- /#page-wrapper -->
<script src="${pageContext.request.contextPath}/static/bootstrap/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/supplier/userquotas.js"></script>
    
</body>
</html>