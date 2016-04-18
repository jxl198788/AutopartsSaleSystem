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
                    <h1 class="page-header">配额申请</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>

                    <th>用户名</th>
                    <th>手机号</th>
                    <th>汽配商名称</th>
                    <th>角色</th>
                    <th>配额</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><a href="#tree" data-toggle="modal">张三</a></td>
                    <td>1390000000</td>
                    <td>壳牌二级供应商</td>
                    <td>企业管理员</td>
                    <td>
                        高级查询：已分配80，其中已使用80，未使用0<br/>
                        普通查询：已分配180，其中已使用80，未使用40<br/>
                    </td>
                    <td><a href="#message" data-toggle="modal">消息</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#apply" data-toggle="modal">申请</a></td>
                </tr>

                </tbody>
            </table>
            <!--modal-->
            <!--<div class="bs-example bs-example-padded-bottom">
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#gridSystemModal">
                    Launch demo modal
                </button>
            </div>-->
            <div id="apply"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="apply">
                <div class="modal-dialog" style="width: 450px;" role="document">
                    <div class="modal-content">
                      <!--  <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <h4 class="modal-title" id="gridModalLabel">Modal title</h4>
                        </div>-->
                        <div class="modal-body">
                            <form class="form-horizontal">
                                <div class="form-group">
                                   <div class="col-sm-10"><b>用户名：</b>张三</div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>手机号：</b>18505915518</div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>汽车配件商：</b>壳牌二级分销商</div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b> 配额使用情况：</b><br/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;高级查询：已分配80，其中已使用80，未使用0<br/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;普通查询：已分配180，其中已使用80，未使用40</div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>配额种类：</b>
                                        <select name="quotaType">
                                            <option name="#">高级查询</option>
                                            <option name="#">普通查询</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                        <div class="col-sm-10"><b>申请配额：</b><input type="text" style="width: 150px;display: inline" class="form-control" id="quota" name="quota" placeholder="quota" /></div>
                                </div>

                            </form>

                        </div>
                        <div class="modal-footer">

                            <button type="button" class="btn btn-primary">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
            <div id="message"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="message">
                <div class="modal-dialog" style="width: 450px;" role="document">
                    <div class="modal-content">
                       <!-- <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                          </div>-->
                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <br/>
                            <br/>
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>申请时间</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>配额</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>2014-1-1</td>
                                    <td>Mark</td>
                                    <td>13033773777</td>
                                    <td>申请高级查询配额30</td>
                                </tr>
                                <tr>
                                    <td>2014-1-12</td>
                                    <td>Jacob</td>
                                    <td>13033773777</td>
                                    <td>申请高级查询配额32</td>
                                </tr>
                                <tr>
                                    <td>2014-11-12</td>
                                    <td>Larry</td>
                                    <td>13033773777</td>
                                    <td>申请高级查询配额42</td>
                                </tr>
                                <tr>
                                    <td>2014-3-12</td>
                                    <td>marry</td>
                                    <td>13033773777</td>
                                    <td>申请高级查询配额33</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>

                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>

            <div id="tree"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="tree">
                <div class="modal-dialog" style="width: 450px;" role="document">
                    <div class="modal-content">
                        <!-- <div class="modal-header">
                               <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                           </div>-->
                        <div class="modal-body">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                            <br/>
                            <br/>
                            <!-- tree -->
                            <div class="easyui-panel" style="padding:5px;width:420px">
                                <ul class="easyui-tree">
                                    <li>
                                        <span>壳牌二级分销商</span>
                                        <ul>
                                            <li>张三&nbsp;1370000000&nbsp;高级查询使用2次&nbsp;普通查询使用1次</li>
                                            <li>李四&nbsp;1370000002&nbsp;高级查询使用22次&nbsp;普通查询使用21次</li>
                                            <li>王五&nbsp;1370000001&nbsp;高级查询使用12次&nbsp;普通查询使用11次</li>
                                            <li data-options="state:'closed'">
                                                <span>壳牌三级分销商</span>
                                                <ul>
                                                    <li>赵六&nbsp;1370000000&nbsp;高级查询使用2次&nbsp;普通查询使用1次</li>
                                                    <li>小明&nbsp;1370000000&nbsp;高级查询使用2次&nbsp;普通查询使用1次</li>
                                                    <li>小红&nbsp;1370000000&nbsp;高级查询使用2次&nbsp;普通查询使用1次</li>
                                                </ul>
                                            </li>
                                            <li>
                                                <span>维修厂</span>
                                                <ul>
                                                    <li>小猴&nbsp;1370000000&nbsp;高级查询使用2次&nbsp;普通查询使用1次</li>
                                                    <li>小米&nbsp;1370000000&nbsp;高级查询使用2次&nbsp;普通查询使用1次</li>
                                                    <li>大米&nbsp;1370000000&nbsp;高级查询使用2次&nbsp;普通查询使用1次</li>
                                                </ul>
                                            </li>

                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>

                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>

        </div>
        <!-- /#page-wrapper -->
</body>
</html>