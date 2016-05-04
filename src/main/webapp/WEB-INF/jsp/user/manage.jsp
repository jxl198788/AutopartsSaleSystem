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
                    <h1 class="page-header">用户管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div style="width: 250px">
                <label for="disabledSelect">邀请成员</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" >批量邀请</a>
                <input class="form-control" id="disabledInput" type="text" placeholder="输入邮箱/手机号/用户名 回车确认">
            </div>
            <br/>
            <br/>
            <br/>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>用户名</th>
                    <th>手机号</th>
                    <th>角色</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Mark</td>
                    <td>13033773777</td>
                    <td>平台管理员</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Jacob</td>
                    <td>13033773777</td>
                    <td>平台审核员</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Larry</td>
                    <td>13033773777</td>
                    <td>平台业务员</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>marry</td>
                    <td>13033773777</td>
                    <td>平台根管理员&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="移交" class="btn btn-default btn-sm" ></td>
                </tr>
                </tbody>
            </table>
        </div>

        </div>
        <!-- /#page-wrapper -->
</body>
</html>