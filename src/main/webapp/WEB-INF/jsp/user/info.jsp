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
                    <h1 class="page-header">个人信息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
                <form role="form">
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">头像:</label>&nbsp;&nbsp;&nbsp;
                        <img style="width: 120px;height: 80px" src="../../static/image/th.jpg">

                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">手机号</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">用户名</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">真实姓名</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">职位</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">邮箱</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">汽配商名称</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">营业执照:</label>&nbsp;&nbsp;&nbsp;
                        <img style="width: 120px;height: 80px" src="../../static/image/th.jpg">
                    </div>
                    <div class="form-group" style="width: 800px">
                        <label for="disabledSelect">所属区域</label><br/>
 
                        <select >
                            <option value=""><-------请选择省份-----&ndash;&gt;</option>

                        </select>
                        <select >
                            <option value=""><-------请选择城市-----&ndash;&gt;</option>

                        </select>
                        <select >
                            <option value=""><-------请选择城镇-----&ndash;&gt;</option>
                        </select>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">汽配商地址</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>
                    <div class="form-group" style="width: 450px">
                        <label for="disabledSelect">联系人</label>
                        <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled>
                    </div>

                </form>

        </div>
        <!-- /#page-wrapper -->
</body>
</html>