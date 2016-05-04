<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/jsp/head.jsp" %> 
</head>
<body>
	<%@ include file="/WEB-INF/jsp/nav.jsp" %>
	 <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">通知/消息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <b>消息列表</b>
                    <span style="float:right;">
                    全部标记为已读&nbsp;&nbsp;<button type="button" style=" width: 25px;height: 25px;border-radius: 20px;padding: 4px 0;" class="btn btn-info btn-circle"><i class="fa fa-check"></i></button>
                    &nbsp;&nbsp;全部删除&nbsp;&nbsp;<button type="button" style=" width: 25px;height: 25px;border-radius: 20px;padding: 4px 0;" class="btn btn-warning btn-circle"><i class="fa fa-times"></i>
                    </button>
                    </span>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="alert alert-success">
                       二级分销商张三申请配额20个。&nbsp;&nbsp;<i class="fa fa-check"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    </div>
                    <div class="alert alert-info">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    </div>
                    <div class="alert alert-warning">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    </div>
                    <div class="alert alert-danger">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                </div>
                </div>
                <!-- .panel-body -->
            </div>
            <!-- /.panel -->

        </div>
        <!-- /#page-wrapper -->
</body>
</html>