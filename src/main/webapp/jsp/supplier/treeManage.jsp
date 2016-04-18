<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商管理-树形结构维护</title>
<%@ include file="/jsp/head.jsp" %> 
<link href="${pageContext.request.contextPath}/static/css/supplier/treeManage.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/jsp/nav.jsp" %>
	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12 page-div">
                    <h3 class="page-header">供应商管理</h3>
                </div>
            </div>
            <div class="row">
                <div class="div-scroll" style="padding:5px">
                    <ul class="easyui-tree" id="tt" ></ul>
                </div>
                <!--右键菜单定义如下：-->
                <div id="mm" class="easyui-menu" style="width:120px;">
                    <div  data-options="iconCls:'icon-add',name:'add'" >
                        <span>添加</span>
                        <div style="width:150px;">
                            <div data-options="name:'topAdd'">上方添加</div>
                            <div data-options="name:'underAdd'">下方添加</div>
                            <div data-options="name:'childrenAdd'">子级添加</div>
                        </div>
                    </div>
                    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
                </div>
            </div>
            <div style="width: 250px;margin-top:20px;">
                <label for="disabledSelect">邀请成员</label><a href="#batchInvite" data-toggle="modal" style="float:right;">批量邀请</a>
                <input class="form-control" id="disabledInput" type="text" placeholder="输入手机号 回车确认">
                <div id="batchInvite"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="batchInvite">
                    <div class="modal-dialog" style="width: 450px;" role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>批量输入手机号</label>
                                    <textarea class="form-control" rows="13"></textarea>
                                </div>
                            </div>
                            <div class="modal-footer">

                                <button type="button" class="btn btn-primary">邀请</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<script src="${pageContext.request.contextPath}/static/js/supplier/treeManage.js"></script>
</body>
</html>