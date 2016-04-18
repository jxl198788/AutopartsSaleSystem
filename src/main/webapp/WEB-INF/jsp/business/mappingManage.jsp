<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/jsp/head.jsp" %> 
<script type="text/javascript">
$(function(){
	$("#status").on("change",function(){
		$("#searchForm").submit();
	});
	$("#submitBtn").on("click",function(){
		$("#searchForm").submit();
	});
    $("#importCSV").on("change",function(){
    	var options = {
    			success:function(target){
    				if(target.msg == "success"){
    					$("#uploadStatus").html("导入成功");
    				}else{
    					$("#uploadStatus").html("导入失败："+target.msg);
    				}
    				$("#importTotal").html(target.data.optRows_sum);
    				$("#successTotal").html(target.data.optRows_success);
    				$("#failTotal").html(target.data.optRows_failure);
    				var failmsgs = target.data.failmsgs;
    				var failHtml = "";
    				for(var i=0;i<failmsgs.length;i++){
    					failHtml += "&nbsp;&nbsp;&nbsp;&nbsp;"+(i+1)+"、"+failmsgs[i]+"<br/>"; 
    				}
    				
    				if(failmsgs.length>0){
    					$("#failFile").html('<a href="'+target.downloadUrl+'">点击下载</a>');
    				}
    				
    				$("#failReason").html(failHtml);
    				
    				$('#myModal').modal({
    	                    keyboard: false,
    	                    show:true,
    	                    backdrop:"static"
    	            })
    			}
    	};
       	$("#importFile").ajaxSubmit(options);
    })
})
</script>
</head>
<body>
	<%@ include file="/jsp/nav.jsp" %>
	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">映射管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div style="margin-left: auto;margin-right: auto;width: 400px" >
                <button type="button" class="btn btn-outline btn-primary btn-sm">关键字</button>
                <button type="button" class="btn btn-outline btn-primary btn-sm">OE</button>
            </div>

			<form id="searchForm" action="mappingIndex.do" method="post">
            <div class="input-group custom-search-form" style="margin-left: auto;margin-right: auto;width:400px;">
                <input type="text" name="search" value="${search }" class="form-control"  placeholder="请输入配件名称、配件编号、品牌">
                <span class="input-group-btn">
                     <button id="submitBtn" class="btn btn-default" type="button" style="width: 40px;height: 34px;">
                         <i class="fa fa-search"></i>
                     </button>
                </span>
            </div>
            <div><b>过滤器</b></div>
            <br/>
            <div>
               	状态：
               <select id="status" name="status">
                	<option>--请选择--</option>
                    <option <c:if test="${status == 0 }">selected = "selected"</c:if> value="0" >新增</option>
                    <option <c:if test="${status == 1 }">selected = "selected"</c:if> value="1">修改</option>
                    <option <c:if test="${status == 2 }">selected = "selected"</c:if> value="2">禁用</option>
               </select>
            </div>
            </form>
            <br/>
            <br/>
            <br/>
            <br/>
            <div style="position: relative;top: 13px;">
                
                <form id="importFile" action="${ctx }/business/import.do" method="post" enctype="multipart/form-data">
                	<input type="button" class="btn btn-default" value="csv导入" onclick='javascript:$("#importCSV").trigger("click")' />
                	<input type="button" class="btn btn-default" value="csv导出" onclick='javascript:$("#outputCSV").trigger("click")' />         
                	<input type="file" id="importCSV" style="display: none" name="importCSV" />
                	<input type="button" id="outputCSV" style="display: none"/>
                	 <a href="" class="btn btn-default">导出模板</a>
                </form>
            </div>
            <div style="margin-left: 855px;">
                &nbsp;&nbsp;<a href="#apply">批量删除</a>
                &nbsp;&nbsp;<a href="#apply">批量禁用</a>
                &nbsp;&nbsp;<a href="#apply">新增</a>
            </div>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th><input type="checkbox" name="all" id="all" >全选</th>
                    <th>品牌</th>
                    <th>配件名称</th>
                    <th>配件编码</th>
                    <th>编码类型</th>
                    <th>对应编码</th>
                    <th>参照品牌</th>
                    <th>一级报价</th>
                    <th>二级报价</th>
                    <th>三级报价</th>
                    <th>状态</th>
                    <th>操作类型</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  items="${pager.list }" var="c">
                	<tr>
                    <td><input type="checkbox" name="single" id="single" ></td>
                    <td>${c.productBrand }</td>
                    <td>${c.productName }</td>
                    <td>${c.productCode }</td>
                    <td>
                        <select disabled>
                            <option <c:if test="${c.referenceCode!=null }">selected = "selected"</c:if> value="0">参照编码</option>
                            <option <c:if test="${c.oeCode!=null }">selected = "selected"</c:if> value="1">OE码</option>
                        </select>
                    </td>
                    <td><c:if test="${c.referenceCode!=null }">${c.referenceCode }</c:if><c:if test="${c.oeCode!=null }">${c.oeCode }</c:if></td>
                    <td>${c.referenceBrand }</td>
                    <td>${c.firstPrice }</td>
                    <td>${c.secondPrice }</td>
                    <td>${c.thirdPrice }</td>
                    <td>${c.status }</td>
                    <td>
                        <a href="#message">详情</a>
                        &nbsp;&nbsp;<a href="#apply">编辑</a>
                        &nbsp;&nbsp;<a href="#apply">禁用</a>
                        &nbsp;&nbsp;<a href="#apply">删除</a>
                    </td>
                </tr>
                </c:forEach>


                </tbody>
            </table>
            	<ul class="pagination">
            	<li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Previous</a></li>
            	<li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="#">1</a></li>
            	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">2</a></li>
            	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">3</a></li>
            	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">4</a></li>
            	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">5</a></li>
            	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">6</a></li>
            	<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Next</a></li>
            	</ul>
				<ul class='pagination'><li class='paginate_button previous disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>首页</a></li><li class='paginate_button previous disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>上一页</a></li><li class='paginate_button active' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>1</a></li><li class='paginate_button next disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>下一页</a></li><li class='paginate_button next disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>尾页</a></li>&nbsp;&nbsp;<span>共1页</span></div>
				
            <div id="myModal"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="apply">
                <div class="modal-dialog" style="width: 450px;" role="document">
                    <div class="modal-content">
                      
                        <div class="modal-body">
                            <form class="form-horizontal">
                           		 <div class="form-group">
                                    <div class="col-sm-10"><b>文件状态：</b><span id="uploadStatus">上传成功</span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>导入数据总数：</b><span id="importTotal"></span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>成功数：</b><span id="successTotal"></span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>失败数：</b><span id="failTotal"></span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>导入失败汇总：</b><br/>
                                        <div id="failReason">
                                            &nbsp;&nbsp;&nbsp;&nbsp;高级查询：已分配80，其中已使用80，未使用0<br/>
                                            &nbsp;&nbsp;&nbsp;&nbsp;普通查询：已分配180，其中已使用80，未使用40<br/>

                                        </div>
                                        </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>导出失败数据：</b><span id="failFile"><a href="#">点击下载</a></span></div>
                                </div>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        </div>
        <!-- /#page-wrapper -->
</body>
</html>