<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/jsp/head.jsp" %> 
<style type="text/css">
        .tree-folder {
            background: url('${ctx }/static/jquery-easy-ui/themes/default/images/tree_icons.png') no-repeat -208px 0;
        }
        .tree-folder-open {
            background: url('${ctx }/static/jquery-easy-ui/themes/default/images/tree_icons.png') no-repeat -224px 0;
        }
</style>
<script type="text/javascript">
    $(function(){
        // 右键点击节点并显示快捷菜单
        $('#tt').tree({
            url:'tree_data.json',
            method:'get',
            animate:true,
            dnd:true,
            onBeforeDrop:function(target, source, point){
                var sIsDirectory =  source.attributes["isDirectory"];
                var tId = target.childNodes[target.childNodes.length-1].childNodes[1].innerText;
                //var tId = $(html).find("span").text();
                var targetNode =  $('#tt').tree('find',tId);
                var tIsDirectory =  targetNode.attributes["isDirectory"];
                console.log("sIsDirectory"+sIsDirectory);
                console.log("tIsDirectory"+tIsDirectory);
                console.log("point"+point);
                if(tIsDirectory=="false"){
                    if(point=="append"){
                        return false;
                    }
                }
            },
            formatter:function(node){
                //将nodeId写入到节点的title中
                var nodeId = node.id;
                return node.text + '<span style="display: none">'+nodeId+'</span>';
            },
            onDblClick: function(node){
                if(node.children || node.attributes["isDirectory"]=="true"){
                    $(this).tree('beginEdit',node.target);
                }

            },
            onContextMenu: function(e, node){
                e.preventDefault();
                // 查找节点
                if(node.children || node.attributes["isDirectory"]=="true"){
                    $('#mm').menu('show', {
                        left: e.pageX,
                        top: e.pageY,
                        onClick:function(item){

                            if(item.name == "topAdd"){
                                var  i = $('#tt').tree('insert', {
                                    before: node.target,
                                    data: {
                                        id: 21,
                                        text: 'undefine',
                                        "attributes":{
                                            "isDirectory":"true"
                                        },
                                        "iconCls":"tree-folder"
                                    }
                                });
                            }
                            if(item.name == "underAdd"){
                                $('#tt').tree('insert', {
                                    after: node.target,
                                    data: {
                                        id: 21,
                                        text: 'undefine',
                                        "attributes":{
                                            "isDirectory":"true"
                                        },
                                        "iconCls":"tree-folder"
                                    }
                                });
                            }
                            if(item.name == "childrenAdd"){
                                $('#tt').tree('append', {
                                    parent: node.target,
                                    data: [{
                                        id: 21,
                                        text: 'undefine',
                                        "attributes":{
                                            "isDirectory":"true"
                                        },
                                        "iconCls":"tree-folder"
                                    }]
                                });

                            }

                            if(item.name == "delete"){
                                $('#tt').tree('remove',node.target);

                            }



                        }

                    });
                }
                $('#tt').tree('select', node.target);


            }
        });
    })
    </script>
</head>
<body>
	<%@ include file="/jsp/nav.jsp" %>
	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">供应商管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="easyui-panel" style="padding:5px">
                    <!-- data-options="url:'tree_data1.json',method:'get',animate:true"-->
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
                    <!--<div data-options="iconCls:'icon-redo'">
                        <span>移动</span>
                        <div style="width:150px;">
                            <div data-options="name:'topMove'">上移</div>
                            <div data-options="name:'underMove'">下移</div>
                            <div data-options="name:'raise'">升级</div>
                            <div data-options="name:'drop'">降级</div>
                        </div>
                    </div>-->
                    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
                </div>

            </div>
            <br/>
            <br/>
            <br/>

            <div style="width: 250px">
                <label for="disabledSelect">邀请成员</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#batchInvite" data-toggle="modal">批量邀请</a>
                <input class="form-control" id="disabledInput" type="text" placeholder="输入邮箱/手机号/用户名 回车确认">
                <div id="batchInvite"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="batchInvite">
                    <div class="modal-dialog" style="width: 450px;" role="document">
                        <div class="modal-content">
                            <!--  <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                  <h4 class="modal-title" id="gridModalLabel">Modal title</h4>
                              </div>-->
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
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div>
            </div>

        </div>
        <!-- /#page-wrapper -->
</body>
</html>