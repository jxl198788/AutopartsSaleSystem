<!--describe: 供应商管理页面样式 
	author: lyn
	create: 2016.04.05
	version: 0.1
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理页面</title>
<%@ include file="/jsp/head.jsp" %> 
<link href="${pageContext.request.contextPath}/static/css/platform/suppliermanage.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/bootstrap/dataTables.bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/bootstrap/dataTables.responsive.css" rel="stylesheet">

</head>
<body style="height:100%">
	<%@ include file="/jsp/nav.jsp" %>
	<div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12 page-div">
                <h3 class="page-header">供应商管理</h3>
            </div>
        </div>
        <div class="table-div" id="detail-info"><!-- panel-body与easyUI冲突  可不用  -->
	        <div class="dataTable_wrapper">
                 <table class="table table-striped table-hover" id="dataTables-example">
			        <thead>
			        	<tr class="info">
			        		<th>用户名</th>
				            <th>手机号</th>
				            <th>汽配商名称</th>
				            <th>角色</th>
				            <th>域名</th>
				            <th>操作</th>
			        	</tr>
			        </thead>
			        <tbody id="movies">
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        	<tr>
			        		<td><a href="#supplier_form_div" data-toggle="modal">565@163.com</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">1378932964</a></td>
	                        <td><a href="#supplier_form_div" data-toggle="modal">康众汽配</a></td>
	                        <td>供应商根管理员</td>
	                        <td>kangzhong.inquiry.com</td>
	                        <td><a id="active" name="" style="margin-left:5px;">激活</a><a id="lock" name="" style="margin-left:3px;">锁定</a><a id="delete" name="" style="margin-left:3px;">删除</a></td>
			        	</tr>
			        </tbody>
			      </table>
	        </div>
	        <!-- /.table-responsive -->
	    </div>
        <!-- modal  begin  -->
	    <div id="supplier_form_div" class="modal fade">
            <div class="modal-dialog">
                   <div class="modal-body">
                   <!-- body  begin 只要修改这里的内容即可 -->
				    <div class="panel panel-success supplier_form" id="supplier_form">
			            <div class="panel-heading">供应商详细信息
			                <button type="button" id="supplier_form_close" data-dismiss="modal" aria-label="Close" class="btn btn-success close-btn">X</button>
			            </div>
			            <div>
			                <form class="panel-body-form">
					            <div class="form-group panel-body-div1">
					                <label class="left panel-body-label1">用户名</label>
					                <input class="form-control form-group-input left" id="username" type="text" placeholder="用户名" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div2">
					                <label class="left panel-body-label1">手机号</label>
					                <input class="form-control form-group-input left" id="msisdn" type="text" placeholder="手机号" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div2">
					                <label class="left panel-body-label2">汽配商域名</label>
					                <input class="form-control form-group-input left" id="domain_name" type="text" placeholder="汽配商域名" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div2">
					                <label class="left panel-body-label2">汽配商名称</label>
					                <input class="form-control form-group-input left" id="supplier_name" type="text" placeholder="汽配商名称" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div3">
					                <label class="left panel-body-label3">营业执照</label>
					            	<input type="file" id="imag-file" class="imag-file form-group-input" onchange="javascript:setImagePreview();" disabled>
					                <div id="localImag"><img class="file-img" id="busi-licence" src="../../static/image/th.jpg"><br/></div>
					            <br/></div><br/>
					            <div class="form-group panel-body-div4"><br/>
					                <label class="left panel-body-label4">所属区域</label>
					                <input id="province" name="province" class="left div-select" value="请选择省份"/>
									<input id="city" name="city" class="easyui-combobox left div-select" value="请选择城市"/>
									<input id="town" name="town" class="easyui-combobox left div-select" value="请选择城镇"/>
								<br/></div><br/>
					            <div class="form-group panel-body-div5">
					                <label class="left panel-body-label2">汽配商地址</label>
					                <input class="form-control form-group-input left" id="supplier_addr" type="text" placeholder="汽配商地址" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div5">
					                <label class="left panel-body-label5">联系人</label>
					                <input class="form-control form-group-input left" id="contact_user" type="text" placeholder="联系人" disabled>
					            <br/></div><br/>
					        </form>
					        <div class="panel-body-div7">
						        <button type="button" id="update" class="btn btn1 btn-primary">修改</button>
								<button type="button" id="submit" style="display:none;" class="btn btn1 btn-primary">保存</button>
								<button type="button" id="cancel" data-dismiss="modal" aria-label="Close" class="btn btn2">取消</button>
			           		</div>
			            </div>
			        </div>
                   <!-- body  begin  -->
        		</div>
	        </div>
	    </div>
        <!-- modal  end  -->
    </div>
    <!-- /#page-wrapper -->
<script src="${pageContext.request.contextPath}/static/bootstrap/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/platform/suppliermanage.js"></script>
    
</body>
</html>