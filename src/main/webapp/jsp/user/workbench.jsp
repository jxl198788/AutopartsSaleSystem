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
                <div class="col-lg-12 ">
                    <h1 class="page-header">我的工作台</h1>
                    <label  for="searched_content">搜索:</label><input type="text" name="serch" id="serchID" title="搜索！"  />
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
		<div class="pagebox"  style="font-size:20px;"  ><a  title="Total record">&nbsp;<b>首页</b> </a>&nbsp;&nbsp;&nbsp;<b >1</b>&nbsp;<a  href="#">2</a>&nbsp;<a  href="#">3</a>&nbsp;<a  href="#">4</a>&nbsp;<a  href="#">5</a>&nbsp;<a  href="#">6</a>&nbsp;<a  href="#">7</a>&nbsp;<a  href="#">8</a>&nbsp;<a  href="#">9</a>&nbsp;<a  href="#">10</a>&nbsp;<a  href="#">下一页</a>&nbsp;<a  href="#">尾页</a>&nbsp;&nbsp;&nbsp;<b >每页显示</b>&nbsp;&nbsp;<b >条</b>&nbsp;&nbsp;&nbsp;<b >总计20条记录</b></div>
        </div>
        <!-- /#page-wrapper -->
</body>
</html>