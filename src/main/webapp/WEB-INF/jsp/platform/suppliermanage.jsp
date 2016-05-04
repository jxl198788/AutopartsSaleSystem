<!--describe: 供应商管理页面样式 
	author: lyn
	create: 2016.04.05
	version: 0.1
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.fjsaas.web.bean.User"%>
<%
	//User user = (User)request.getSession().getAttribute("user");
	//String uname = user.getUsername();//登录用户名
	//String is_root = user.getIsRoot();//是否为根管理员
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理页面</title>
<%@ include file="/WEB-INF/jsp/head.jsp" %>  
<link href="${pageContext.request.contextPath}/static/css/platform/suppliermanage.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/bootstrap/dataTables.bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/bootstrap/dataTables.responsive.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/json.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery/json2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common/city.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/platform/suppliermanage.js"></script>
<script type="text/javascript">
var path = "${pageContext.request.contextPath}";
<%-- var uname = "<%=uname%>";
var is_root = "<%=is_root%>"; --%>
</script>
</head>
<body style="height:100%">
	<%@ include file="/WEB-INF/jsp/nav.jsp" %>
	<form id="suppliersForm" action="${ctx }/platform/getSupplierInfoList" method="post" enctype="multipart/form-data">
	</form>
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
			        <tbody id="tbody_data">
			        <c:forEach items="${supplierList }" var="c">
			        	<tr>
			        		<td><a data-toggle="modal" onclick="javascript:toForm(this,${c.id },${c.supplierid });">${c.username }</a></td>
	                        <td><a data-toggle="modal" onclick="javascript:toForm(this,${c.id },${c.supplierid });">${c.telphone }</a></td>
	                        <td><a data-toggle="modal" onclick="javascript:toForm(this,${c.id },${c.supplierid });">${c.suppliername }</a></td>
	                        <td>${c.rolename }</td>
	                        <td>${c.domain_name }</td>
	                        <td>
	                        	<c:if test="${c.locked==1 }">
		                        	<a name="" style="margin-left:5px;" onclick="doChangeStatus(${c.id },0);">激活</a>
		                        </c:if>
		                        <c:if test="${c.locked==0 }">
		                        	<a name="" style="margin-left:3px;" onclick="doChangeStatus(${c.id },1);">锁定</a>
		                        </c:if>
		                        <a name="" style="margin-left:3px;" onclick="doDelete(${c.id });">删除</a>
	                        </td>
			        	</tr>
			        </c:forEach>
			        </tbody>
			      </table>
	        </div>
	        <!-- /.table-responsive -->
	    </div>
	    <form id="supplierDetail" action="" method="post" enctype="multipart/form-data">
			<input type="hidden" id="userId" name="userId" value=""/>
			<input type="hidden" id="supplierId" name="supplierId" value=""/>
		</form>
        <!-- modal  begin  -->
	    <div id="supplier_form_div" class="modal fade">
            <div class="modal-dialog">
                   <div class="modal-body">
                   <!-- body begin 只要修改这里的内容即可 -->
				    <div class="panel panel-success supplier_form" id="supplier_form">
			            <div class="panel-heading">供应商详细信息
			                <button type="button" id="supplier_form_close" data-dismiss="modal" aria-label="Close" class="btn btn-success close-btn">X</button>
			            </div>
			            <div>
			                <form id="panel-body-form" class="panel-body-form" action="" method="post" enctype="multipart/form-data">
					            <div class="form-group panel-body-div1">
					                <label class="left panel-body-label1">用户名</label>
					                <input class="form-control form-group-input left" id="username" name="username" type="text" placeholder="用户名" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div2">
					                <label class="left panel-body-label1">手机号</label>
					                <input class="form-control form-group-input left" id="telphone" name="telphone" type="text" placeholder="手机号" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div2">
					                <label class="left panel-body-label2">汽配商域名</label>
					                <input class="form-control form-group-input left" id="domain_name" name="domain_name" type="text" placeholder="汽配商域名" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div2">
					                <label class="left panel-body-label2">汽配商名称</label>
					                <input class="form-control form-group-input left" id="suppliername" name="suppliername" type="text" placeholder="汽配商名称" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div3">
					                <label class="left panel-body-label3">营业执照</label>
					            	<input type="file" id="imag-file" value="" name="importImag" class="imag-file form-group-input" onchange="javascript:setImagePreview();" disabled>
					                <div id="localImag"><img class="file-img" id="busi-licence" src="${ctx }/static/image/businessLicense/th.jpg"><br/></div>
					            <br/></div><br/>
					            <div class="form-group panel-body-div4"><br/>
					                <label class="left panel-body-label4">所属区域</label>
					                <input id="province" name="province" class="easyui-combobox left div-select" value=""/>
									<input id="city" name="city" class="easyui-combobox left div-select" value=""/>
									<input id="town" name="town" class="easyui-combobox left div-select" value=""/>
								<br/></div><br/>
					            <div class="form-group panel-body-div5">
					                <label class="left panel-body-label2">汽配商地址</label>
					                <input class="form-control form-group-input left" value="" name="addr" id="addr" type="text" placeholder="汽配商地址" disabled>
					            <br/></div><br/>
					            <div class="form-group panel-body-div5">
					                <label class="left panel-body-label5">联系人</label>
					                <input class="form-control form-group-input left" value="" name="linkman" id="linkman" type="text" placeholder="联系人" disabled>
					            <br/></div><br/>
					        </form>
					        <div class="panel-body-div7">
						        <button type="button" id="update" class="btn btn1 btn-primary" onclick="javascript:updateDetail();">修改</button>
								<button type="button" id="submit" style="display:none;" class="btn btn1 btn-primary" onclick="javascript:submitDetail();">保存</button>
								<button type="button" id="cancel" data-dismiss="modal" aria-label="Close" class="btn btn2" onclick="doCancel();">取消</button>
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
</body>
</html>