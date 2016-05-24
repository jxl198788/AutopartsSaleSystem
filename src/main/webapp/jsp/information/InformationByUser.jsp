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
<%@ include file="/WEB-INF/jsp/head.jsp" %>
<link href="${ctx}/static/css/platform/suppliermanage.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/static/bootstrap/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/json.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery/json2.js"></script>
<script type="text/javascript" src="${ctx}/static/js/common/city.js"></script>
<script type="text/javascript" src="${ctx}/static/js/information/informaitonByUser.js"></script>
</head>
<body style="height:100%">
	<%@ include file="/WEB-INF/jsp/nav.jsp" %>
<%-- 	<form id="suppliersForm" action="${ctx }/platform/querySupplierRootManagers" method="get" enctype="multipart/form-data">
	</form> --%>
	<div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12 page-div">
                <h3 class="page-header">信息</h3>
                <h30 ><a style="color: red" href="#" onclick="updataInformation(1)">全部已读</a></h30>&ensp; 	&ensp; 	&ensp;
  				<h30 ><a style="color: red" href="#" onclick="updataInformation(2)">全部删除</a></h30>
            </div>
        </div>
        <div class="panel-body table-div"><!-- panel-body与easyUI冲突  可不用  -->
	        <div class="table-responsive">
                 <table class="table table-hover">
			        <tbody id="tbody_data">
			          
			        
			        
			        </tbody>
			      </table>
			      <%-- <div class="col-sm-6" style="margin-left: 50px; float: right;">
	            		<div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
	           				${pager.pageView }
	            		</div>
	              </div> --%>
	        </div>
	    </div>
        <!-- modal  begin  -->
	    <%-- <div id="supplier_form_div" class="modal fade">
            <div class="modal-dialog">
                   <div class="modal-body">
                   <!-- body begin 只要修改这里的内容即可 -->
				    <div class="panel panel-success supplier_form" id="supplier_form">
			            <div class="panel-heading">供应商详细信息
			                <button type="button" id="supplier_form_close" data-dismiss="modal" aria-label="Close" class="btn btn-success close-btn">X</button>
			            </div>
			            <div>
			                <form id="panel-body-form" class="panel-body-form" action="" method="post" enctype="multipart/form-data">
								<input type="hidden" id="userId" name="userId" value=""/>
								<input type="hidden" id="supplierId" name="supplierId" value=""/>
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
					                <input class="form-control form-group-input left" style="width:160px;margin:-5px 0 0 10px;" id="domain_name" name="domain_name" type="text" placeholder="汽配商域名" disabled>.inquiry.com
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
					                <input id="province" name="province" class="province easyui-combobox left div-select" value=""/>
									<input id="city" name="city" class="city easyui-combobox left div-select" value=""/>
									<input id="town" name="town" class="town easyui-combobox left div-select" value=""/>
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
						        <button type="button" id="update" class="btn btn1 btn-primary" onclick="doUpdate();">修改</button>
								<button type="button" id="submit" style="display:none;" class="btn btn1 btn-primary" onclick="doSubmit();">保存</button>
								<button type="button" id="cancel" data-dismiss="modal" aria-label="Close" class="btn btn2" onclick="doCancel();">取消</button>
			           		</div>
			            </div>
			        </div>
                   <!-- body  begin  -->
        		</div>
	        </div>
	    </div> --%>
        <!-- modal  end  -->
    </div>
 <script type="text/javascript">
var path = "${ctx}";
<%-- var clientname = "<%=user.getUsername()%>";
var clientid = "<%=user.getId()%>"; --%>
var data = ${json};
var data1=eval(data);
function updataInformation(num){
	url = path+"/information/allOperation.do";
	$.post(url,{id:num},function(data){
		if(data=="1"){
			url = path+"/information/loop.do";
			window.location.reload(url);
			}
	});
	
}
</script> 
</body>
</html>