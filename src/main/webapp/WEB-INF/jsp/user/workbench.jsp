<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/jsp/head.jsp" %> 
</head>
<body>
	<%@ include file="/jsp/nav.jsp" %>
	 <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">我的工作台</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    代办任务(5)
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>创建时间</th>
                            <th>提交人</th>
                            <th>主题</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>2016-1-1 12:11:11</td>
                            <td>Mark</td>
                            <td>映射审核</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>2016-12-1 12:11:11</td>
                            <td>Larry</td>
                            <td>申请配额</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>2016-11-1 12:11:11</td>
                            <td>marry</td>
                            <td>申请账号</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>2016-5-1 12:11:11</td>
                            <td>tom</td>
                            <td>EPC审核</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- /.panel-body -->
            </div>
            <br/>
        <div class="panel panel-default">
            <div class="panel-heading">
                已完成任务(5)
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>创建时间</th>
                        <th>提交人</th>
                        <th>主题</th>
                        <th>审核人</th>
                        <th>审核时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>2016-1-1 12:11:11</td>
                        <td>Mark</td>
                        <td>映射审核</td>
                        <td>张三</td>
                        <td>2017-1-1 12:11:11</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>2016-12-1 12:11:11</td>
                        <td>Larry</td>
                        <td>申请配额</td>
                        <td>张三</td>
                        <td>2017-1-1 12:11:11</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>2016-11-1 12:11:11</td>
                        <td>marry</td>
                        <td>申请账号</td>
                        <td>张三</td>
                        <td>2017-1-1 12:11:11</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>2016-5-1 12:11:11</td>
                        <td>tom</td>
                        <td>EPC审核</td>
                        <td>张三</td>
                        <td>2017-1-1 12:11:11</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!-- /.panel-body -->
        </div>

        </div>
        <!-- /#page-wrapper -->
</body>
</html>