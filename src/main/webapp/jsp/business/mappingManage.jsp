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
    $("#importCSV").on("change",function(){
       alert("aa");
       $("#importFile").ajaxSubmit();
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

            <div class="input-group custom-search-form" style="margin-left: auto;margin-right: auto;width:400px;">

                <input type="text" class="form-control"  placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button" style="width: 40px;height: 34px;">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
            </div>
            <div><b>过滤器</b></div>
            <br/>
            <div>
                状态：
                <select name="filter">
                    <option value="">启用</option>
                    <option value="">等于</option>
                    <option value="">不等于</option>
                    <option value="">禁用</option>
                    <option value="">删除</option>
                </select>
                <select name="status">
                    <option value="">新增</option>
                    <option value="">修改</option>

                </select>
            </div>
            <br/>
            <br/>
            <br/>
            <br/>
            <div style="position: relative;top: 13px;">
                <input type="button" class="btn btn-default" value="csv导入" onclick='javascript:$("#importCSV").trigger("click")' />
                <input type="button" class="btn btn-default" value="csv导出" onclick='javascript:$("#outputCSV").trigger("click")' />
                <form id="importFile" action="${ctx }/business/import.do" method="post" enctype="multipart/form-data">         
                	<input type="file" id="importCSV" style="display: none" name="importCSV" />
                 </form>
                	<input type="file" id="outputCSV" style="display: none" name="outputCSV" />
               
                <a href="" class="btn btn-default">导出模板</a>
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
                    <th>品牌${pager.total })</th>
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
                    <td>${c.referenceCode }</td>
                    <td>${c.referenceBrand }</td>
                    <td>${c.firstPrice }</td>
                    <td>${c.secondPrice }</td>
                    <td>${c.thirdPrice }</td>
                    <td>新增</td>
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
        </div>
        <!-- /#page-wrapper -->
</body>
</html>