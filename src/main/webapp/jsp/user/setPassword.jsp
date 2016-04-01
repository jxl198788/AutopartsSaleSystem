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
                    <h1 class="page-header">账户密码</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

                <form >
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">手机号</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="手机号" disabled>
                        <br/>
                    </div>
                    <div style="width: 150px">
                        <label for="disabledSelect">短信验证码</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="请输入验证码"><input style="position:relative;top: -34px;left: 166px;" type="button" value="获取验证码" class="btn btn-primary" >
                    </div>

                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">旧密码</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="请输入旧密码">
                        <br/>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">新密码</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="请输入新密码">
                        <br/>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">确认密码</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="请输入旧密码">
                        <br/>
                    </div>
                    <input type="submit" class="btn btn-primary" value="提交"/>
                </form>

        </div>
        <!-- /#page-wrapper -->
</body>
</html>