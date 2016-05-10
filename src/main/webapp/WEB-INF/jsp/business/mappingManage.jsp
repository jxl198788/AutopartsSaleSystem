<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/jsp/head.jsp" %> 
<script type="text/javascript">
/* function add(){
	//<tr>
	alert($("#addTr").html());
    ;
}
function deleteAll(){
	$("#batchForm").attr("action",encodeURI("${ctx}/business/deleteAll.do?search=${search}&status=${status}&pageNo=${pageNo}"));
	$("#batchForm").submit();
}
function forbiddenAll(){
	$("#batchForm").attr("action",encodeURI("${ctx}/business/deleteAll.do?search=${search}&status=${status}&pageNo=${pageNo}"));
	$("#batchForm").submit();
} */
function validation ( e, o, action ) {
    if ( action !== 'remove' ) {

        var productBrand = this.field( 'productBrand' );
        var productName = this.field( 'productName' );
        var productCode = this.field( 'productCode' );
        var referenceCode = this.field( 'referenceCode' );
        var firstPrice = this.field( 'firstPrice' );
        var secondPrice = this.field( 'secondPrice' );
        var thirdPrice = this.field( 'thirdPrice' );
        var flag = false;

        // Only validate user input values - different values indicate that
        // the end user has not entered a value
        if ( ! productBrand.isMultiValue() ) {
            if ( ! productBrand.val() ) {
            	productBrand.error( '品牌不能为空！' );
            	flag = true;
            }
             
           /*  if ( firstName.val().length >= 20 ) {
                firstName.error( 'The first name length must be less that 20 characters' );
            } */
        }
        
        if ( ! productName.isMultiValue() ) {
            if ( ! productName.val() ) {
            	productName.error( '配件名称不能为空！' );
            	flag = true;
            }
        }
        if ( ! productCode.isMultiValue() ) {
            if ( ! productCode.val() ) {
            	productCode.error( '配件编码不能为空！' );
            	flag = true;
            }
        }
        if ( ! referenceCode.isMultiValue() ) {
            if ( ! referenceCode.val() ) {
            	referenceCode.error( '参照编码不能为空！' );
            	flag = true;
            }
        }
        if ( ! firstPrice.isMultiValue() ) {
            if (  isNaN(firstPrice.val()) ) {
            	firstPrice.error( '一级报价必须为数字！' );
            	flag = true;
            }
        }
        if ( ! secondPrice.isMultiValue() ) {
            if ( isNaN(secondPrice.val()) ) {
            	secondPrice.error( '二级报价必须为数字！' );
            	flag = true;
            }
        }
        if ( ! thirdPrice.isMultiValue() ) {
            if (  isNaN(thirdPrice.val()) ) {
            	thirdPrice.error( '三级报价必须为数字！' );
            	flag = true;
            }
        }

        // ... additional validation rules

        // If any error was reported, cancel the submission so it can be corrected
        if ( flag ) {
            return false;
        }
    }
} 
$(function(){
	forbiddenEditor = new $.fn.dataTable.Editor( {
        ajax: function ( method, url, data, success, error ) {  	
	       		var params = "";
	    		for(var key in data.data){
	    			 params += "&ids="+key;
	            }        	
                $.ajax( {
                    type: "POST",
                    url:  "${ctx}/business/forbiddenAll.do",
                    data: params.substr(1),
                    dataType: "json",
                    success: function (json) {
                        success(json);
                    },
                    error: function (xhr, error, thrown) {
                        error( xhr, error, thrown );
                    }
                } );   	 
        },
        idSrc:  'id',
        table: "#mappingTable",
        fields: [ {
            name: "id",
            type: "hidden"
        }]
    } );
	
	editEditor = new $.fn.dataTable.Editor( {
         ajax: function ( method, url, data, success, error ) {
        	 if(data.action == "remove"){
				 var params = "";
        		 for(var key in data.data){
        			 params += "&ids="+key;
                 }        		 
                 $.ajax( {
                     type: "POST",
                     url:  "${ctx}/business/deleteAll.do",
                     data: params.substr(1),
                     dataType: "json",
                     success: function (json) {
                         success(json);
                     },
                     error: function (xhr, error, thrown) {
                         error( xhr, error, thrown );
                     }
                 } );
        	 }else if(data.action == "edit"){
        		 var id;
                 for(var key in data.data){
                	 id = key;
                 }
                 $.ajax( {
                     type: "POST",
                     url:  "${ctx}/business/update.do",
                     data: data.data[id],
                     dataType: "json",
                     success: function (json) {
                         success(json);
                     },
                     error: function (xhr, error, thrown) {
                         error( xhr, error, thrown );
                     }
                 } );
        	 }
        	 
         },
         idSrc:  'id',
         table: "#mappingTable",
         fields: [ {
             name: "id",
             type: "hidden"
         },{
             label: "品牌:",
             name: "productBrand",
         }, {
             label: "配件名称:",
             name: "productName",
             id: "2"
         }, {
             label: "配件编码:",
             name: "productCode",
             id: "3"
         }, {
             label: "编码类型:",
             name: "codeType",
             data: function ( data, type, set ) {
                if(data.referenceCode){
                	return 0;
                }else{
                	return 1;
                }
             },
             type:  "select",
             options: [
                       { label: "参照编码", value: 0 },
                       { label: "OE编",    value: 1 }
                   ]
         }, {
             label: "参照编码:",
             name: "referenceCode",
             data: function ( data, type, set ) {
                 if(data.referenceCode){
                 	return data.referenceCode;
                 }else{
                 	return data.oeCode;
                 }
              },
         }, {
             label: "参照品牌:",
             name: "referenceBrand",
             //type: "datetime"
         }, {
             label: "一级报价:",
             name: "firstPrice"
         }, {
             label: "二级报价:",
             name: "secondPrice"
         }, {
             label: "三级报价:",
             name: "thirdPrice"
         }, {
             label: "状态:",
             name: "status",
             type:  "select",
             options: [
                       { label: "新增", value: 0 },
                       { label: "修改",    value: 1 },
                       { label: "禁用",    value: 2}
                   ]
         }
         ]
     } ).on( 'preSubmit', validation);
	
	addEditor = new $.fn.dataTable.Editor( {
        ajax: function ( method, url, data, success, error ) {
       	 var id;
            for(var key in data.data){
           	 id = key;
            }
            $.ajax( {
                type: "POST",
                url:  "${ctx}/business/add.do",
                data: data.data[id],
                dataType: "json",
                success: function (json) {
                    success(json);
                },
                error: function (xhr, error, thrown) {
                    error( xhr, error, thrown );
                }
            } );
        },
        idSrc:  'id',
        table: "#mappingTable",
        fields: [ {
            label: "品牌:",
            name: "productBrand",
        }, {
            label: "配件名称:",
            name: "productName",
        }, {
            label: "配件编码:",
            name: "productCode",
        }, {
            label: "编码类型:",
            name: "codeType",
            data: function ( data, type, set ) {
               if(data.referenceCode){
               	return 0;
               }else{
               	return 1;
               }
            },
            type:  "select",
            options: [
                      { label: "参照编码", value: 0 },
                      { label: "OE编",    value: 1 }
                  ]
        }, {
            label: "参照编码:",
            name: "referenceCode",
        }, {
            label: "参照品牌:",
            name: "referenceBrand",
            //type: "datetime"
        }, {
            label: "一级报价:",
            name: "firstPrice"
        }, {
            label: "二级报价:",
            name: "secondPrice"
        }, {
            label: "三级报价:",
            name: "thirdPrice"
        }
        ]
    } ).on( 'preSubmit', validation);
	 var data = ${json};
	 var mappingTable = $('#mappingTable').DataTable( {
	        rowId: 'id',
	        dom: "Brti",//Bfrtip B button f search
	        "language": {
	            "info": "Showing _START_ to _END_ of ${pager.total} entries"
	         },
	        "pageLength": 50,
	        data:data.data,
	        //ajax: "./tables-editor.json",
	        columns: [
	           /*  { data: "id", "orderable": false , render: function ( data, type, row ) {
	                // Combine the first and last names into a single table field
	                //<input type="checkbox" name="ids" value="${c.id}" >-${c.id}
	                return '<input type="checkbox" name="ids" value="'+row.id+'" >';
	            } }, */
	            {
	                data: null,
	                defaultContent: '',
	                className: 'select-checkbox',
	                orderable: false
	            },
	            { data: "productBrand" },
	            { data: "productName"/* ,"orderable": false  */},
	            { data: "productCode" },
	            { data: null ,render: function ( data, type, row ) {
	                // Combine the first and last names into a single table field
	                //<input type="checkbox" name="ids" value="${c.id}" >-${c.id}
	                if(row.referenceCode){
	                	return "参照编码";
	                }else{
	                	return "OE码";
	                }
	            }},
	            { data: "referenceCode",render: function ( data, type, row ) {
	                // Combine the first and last names into a single table field
	                //<input type="checkbox" name="ids" value="${c.id}" >-${c.id}
	                if(row.referenceCode){
	                	return row.referenceCode;
	                }else{
	                	return row.oeCode;
	                }
	            } },
	            { data: "referenceBrand" , "defaultContent": ""},
	            { data: "firstPrice" },
	            { data: "secondPrice" },
	            { data: "thirdPrice" },
	            { data: "status"  , render: function ( data, type, row ) {
	                // Combine the first and last names into a single table field
	                //<input type="checkbox" name="ids" value="${c.id}" >-${c.id}
	                if(data == 0){
	                	return "新增";
	                }else if(data == 1){
	                	return "修改";
	                }else{
	                	return "禁用";
	                }
	            } /* , render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) */ }
	        ],
	        order: [ 1, 'desc' ],
	        select: {
	            style:    'os',
	            selector: 'td:first-child'
	        },
	        buttons: [
	            
	            { extend: "create", editor: addEditor,text:"新增" },
	            { extend: "edit",   editor: editEditor ,text:"编辑"},
	            { 
	            	editor: forbiddenEditor ,
	            	extend: "edit",
	            	text:"禁用",
	            	formTitle : "禁用",
	                formButtons: [
	                              {
	                                  label: '取消',
	                                  fn: function () { this.close(); }
	                              },
	                              "确定",
	                          ],
	                formMessage: function ( editor, dt ) {
	                 /*    var rows = dt.rows( { selected: true } ).data().map( function (rowData) {
	                        return rowData.first_name;
	                    } ); */
	                    var rows = dt.rows( { selected: true } ).data();
	     				
	                    return '<center>您真的要禁用选中的'+rows.length+'行吗？</center>';
	                    //return 'Are you sure you want to delete the data for users '+rows.join(', ')+'?';
	                }
	            },
	            {
	              	extend: "remove", 
	                editor: editEditor, 
	                text:"删除",
	                formTitle : "删除",
	                formButtons: [
	                              {
	                                  label: '取消',
	                                  fn: function () { this.close(); }
	                              },
	                              "确定",
	                          ],
	                formMessage: function ( editor, dt ) {
	                 /*    var rows = dt.rows( { selected: true } ).data().map( function (rowData) {
	                        return rowData.first_name;
	                    } ); */
	                    var rows = dt.rows( { selected: true } ).data();
	     				
	                    return '您真的要删除选中的'+rows.length+'行吗？';
	                    //return 'Are you sure you want to delete the data for users '+rows.join(', ')+'?';
	                }
	            }
	        ]
	    } );

     /* $('#mappingTable').DataTable( {
    	 rowId: 'id',
         dom: "Bfrtip",
         ajax: "./tables-editor.json",
         columns: [
             { data: "position2" },
             { data: "position" },
             { data: "office" },
             { data: "extn" },
             { data: "start_date" },
             { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) }
         ],
         select: true,
         buttons: [
             { extend: "create", editor: editor },
             { extend: "edit",   editor: editor },
             { extend: "remove", editor: editor }
         ]
     } ); */
	
	$(".update").on("click",function(){
 		var tr = $(this).parent().parent().parent();
 		var id = tr.find(":checkbox").val();
 		var productBrand = tr.find(".productBrand").val();
 		var productName = tr.find(".productName").val();
 		var productCode = tr.find(".productCode").val();
 		var codeType = tr.find(".codeType").val();
 		var referenceCode = tr.find(".referenceCode").val();
 		var referenceBrand = tr.find(".referenceBrand").val();
 		var firstPrice = tr.find(".firstPrice").val();
 		var secondPrice = tr.find(".secondPrice").val();
 		var thirdPrice = tr.find(".thirdPrice").val();
 		if(isNaN(firstPrice)){
 		   alert("一级报价必须为数字");
 		   return false;
 		}
 		if(isNaN(firstPrice)){
  		   alert("二级报价必须为数字");
  		 	return false;
  		}
 		if(isNaN(firstPrice)){
  		   alert("三级报价必须为数字");
  		   return false;
  		}
 		var status = tr.find(".status").val();	
 		//保存
 		var url = "${ctx}/business/update.do";
 		var params = {"productBrand" : productBrand,"productName" : productName,"productCode" : productCode,
 				"codeType" : codeType,
 				"firstPrice" : firstPrice,"secondPrice" : secondPrice,"thirdPrice" : thirdPrice,
 				"status" : status,"id" : id};
 		if(codeType == 0){
 			params.referenceCode = referenceCode;
 			params.referenceBrand = referenceBrand;
 		}else{
 			params.oeCode = referenceCode;
 			params.referenceBrand = "";
 		}
 		$.post(url,params,function(flag){
 			alert(flag);
 		},"json")
		tr.find(".editOperate").hide();
		tr.find(".commonOperate").show();
	}); 
	$(".cancel").on("click",function(){
 		var tr = $(this).parent().parent().parent();
		tr.find(":enabled").each(function(index, domEle){
			var initValue = $(this).attr("initValue");
			if($(this).is("select")){
				//.removeAttr("selected");
				$(this).find("option[value="+initValue+"]").removeAttr("selected").attr("selected",true);
				$(this).attr("disabled",true);
			}else{
				$(this).attr("disabled",true).val(initValue);
			}
			
			
		})
		tr.find(".editOperate").hide();
		tr.find(".commonOperate").show();
	}); 
/* 	$(".edit").on("click",function(){
		var tr = $(this).parent().parent().parent();
		tr.find(":disabled").attr("disabled",false);
		tr.find(".editOperate").show();
		tr.find(".commonOperate").hide();
	}); 
	$("#all").on("click",function(){
		$(":checkbox[name=ids]").prop("checked",$(this).prop("checked"));
		
	}) */
	$("#status").on("change",function(){
		$("#searchForm").submit();
	});
	$("#submitBtn").on("click",function(){
		$("#searchForm").submit();
	});
    $("#importCSV").on("change",function(){
    	$("#importBtn").attr("disable",true).val("正在导入...");
    	var options = {
    			success:function(target){
    				if(target.msg == "success"){
    					$("#uploadStatus").html("导入成功");
    				}else{
    					$("#uploadStatus").html("导入失败："+target.msg);
    				}
    				$("#importTotal").html(target.data.optRows_sum);
    				$("#successTotal").html(target.data.optRows_success);
    				$("#failTotal").html(target.data.optRows_failure);
    				var failmsgs = target.data.failmsgs;
    				var failHtml = "";
    				for(var i=0;i<failmsgs.length;i++){
    					failHtml += "&nbsp;&nbsp;&nbsp;&nbsp;"+(i+1)+"、"+failmsgs[i]+"<br/>"; 
    				}
    				
    				if(failmsgs.length>0){
    					$("#failFile").html('<a href="'+target.downloadUrl+'">点击下载</a>');
    				}
    				
    				$("#failReason").html(failHtml);
    				
    				$('#myModal').modal({
    	                    keyboard: false,
    	                    show:true,
    	                    backdrop:"static"
    	            })
    			}
    	};
       	$("#importFile").ajaxSubmit(options);
    })
})
</script>
</head>
<body>
	 <%@ include file="/WEB-INF/jsp/nav.jsp" %>
	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">映射管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- <div style="margin-left: auto;margin-right: auto;width: 400px" >
                <button type="button" class="btn btn-outline btn-primary btn-sm">关键字</button>
                <button type="button" class="btn btn-outline btn-primary btn-sm">OE</button>
            </div> -->
            <br/>
             <br/>
			<form id="searchForm" action="mappingIndex.do" method="post">
            <div class="input-group custom-search-form" style="margin-left: auto;margin-right: auto;width:400px;">
                <input type="text" name="search" value="${search }" class="form-control"  placeholder="请输入配件名称、配件编号、品牌">
                <span class="input-group-btn">
                     <button id="submitBtn" class="btn btn-default" type="button" style="width: 40px;height: 34px;">
                         <i class="fa fa-search"></i>
                     </button>
                </span>
            </div>
            <br/>
            <div><b>过滤器</b></div>
            <br/>
            <div>
               	状态：
               <select id="status" name="status">
                	<option <c:if test="${status == null }">selected = "selected"</c:if> value="">全部</option>
                    <option <c:if test="${status == 0 }">selected = "selected"</c:if> value="0" >新增</option>
                    <option <c:if test="${status == 1 }">selected = "selected"</c:if> value="1">修改</option>
                    <option <c:if test="${status == 2 }">selected = "selected"</c:if> value="2">禁用</option>
               </select>
            </div>
            </form>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <div style="position: relative;top:-5px;">
                
                <form id="importFile" action="${ctx }/business/import.do" method="post" enctype="multipart/form-data">
                	<input type="button" class="btn btn-default" id="importBtn" value="csv导入" onclick='javascript:$("#importCSV").trigger("click")' />
                	<a href="${ctx }/business/csvExport.do?status=${status}&search=${search}" class="btn btn-default">csv导出</a>
                	<a href="${ctx }/business/excleExport.do?status=${status}&search=${search}" class="btn btn-default">Excel导出</a>
                	<input type="file" id="importCSV" style="display: none" name="importCSV" />
                	<a href="${ctx }/static/template/Template.xlsx" class="btn btn-default">导出模板</a>
                </form>
            </div>
<!--             <div style="margin-left: 855px;">
                &nbsp;&nbsp;<a href="javascript:deleteAll();">批量删除</a>
                &nbsp;&nbsp;<a href="javascript:forbiddenAll();">批量禁用</a>
                &nbsp;&nbsp;<a href="javascript:add()">新增</a>
            </div> -->
            <form id="batchForm" action="" method="post">
        
            <table id="mappingTable" class="display" cellspacing="0" style="font-size: 12px;">
                <thead>
                <tr>
                   <!--  <th><input type="checkbox" name="all" id="all" >全选</th> -->
                    <th></th>
                    <th>品牌</th>
                    <th>配件名称</th>
                    <th>配件编码</th>
                    <th>编码类型</th>
                    <th>对应编码</th>
                    <th>参照品牌</th>
                    <th>一级报价</th>
                    <th>二级报价</th>
                    <th>三级报价</th>
                    <th>状态</th>
                    <!-- <th>操作类型</th> -->
                </tr>
                </thead>
                <tbody>
                
                
                </tbody>
            </table>
            </form>
            <div class="col-sm-6" style="position:relative;margin-left: 300px;width: 70%">
            <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
           		${pager.pageView }
            </div>
            </div>
        
        
				
            <div id="myModal"  class="modal fade" tabindex="-1" role="dialog" aria-labelledby="apply">
                <div class="modal-dialog" style="width: 450px;" role="document">
                    <div class="modal-content">
                      
                        <div class="modal-body">
                            <form class="form-horizontal">
                           		 <div class="form-group">
                                    <div class="col-sm-10"><b>文件状态：</b><span id="uploadStatus">上传成功</span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>导入数据总数：</b><span id="importTotal"></span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>成功数：</b><span id="successTotal"></span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>失败数：</b><span id="failTotal"></span></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>导入失败汇总：</b><br/>
                                        <div id="failReason">
                                            &nbsp;&nbsp;&nbsp;&nbsp;高级查询：已分配80，其中已使用80，未使用0<br/>
                                            &nbsp;&nbsp;&nbsp;&nbsp;普通查询：已分配180，其中已使用80，未使用40<br/>

                                        </div>
                                        </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-10"><b>导出失败数据：</b><span id="failFile"><a href="#">点击下载</a></span></div>
                                </div>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" onclick="location.reload(true)" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        </div>
    <div style="display: none">
	<tr>
	    <td><input type="checkbox" name="ids" value="$id$"></td>
	    <td><input disabled="disabled" class="productBrand" initvalue="" size="7" type="text" value=""></td>
	    <td><input disabled="disabled" class="productName" initvalue="" size="7" type="text" value=""></td>
	    <td><input disabled="disabled" class="productCode" initvalue="" size="7" type="text" value=""></td>
	    <td>
	        <select class="codeType" initvalue="0" disabled="">
	            <option selected="selected" value="0">参照编码</option>
	            <option value="1">OE码</option>
	        </select>
	    </td>
	    <td><input disabled="disabled" class="referenceCode" initvalue="" size="7" type="text" value=""></td>
	    <td><input disabled="disabled" class="referenceBrand" initvalue="" size="7" type="text" value=""></td>
	    <td><input disabled="disabled" class="firstPrice" initvalue="" size="2" type="text" value=""></td>
	    <td><input disabled="disabled" class="secondPrice" initvalue="" size="2" type="text" value=""></td>
	    <td><input disabled="disabled" class="thirdPrice" initvalue="" size="2" type="text" value=""></td>
	    <td>
	    	<select name="status" class="status" initvalue="" disabled="">
	            <option value="0">新增</option>
	            <option value="1">修改</option>
	            <option value="2">禁用</option>
	        </select>
	    </td>
	    <td>
	    	<span class="commonOperate">
	    		<a href="#message">详情</a>
	            &nbsp;<a href="javascript:void(0)" class="edit">编辑</a>
	            <br>
	            <a href="/AutopartsSaleSystem/business/forbidden.do?id=$id$&amp;search=&amp;status=">禁用</a>
	            &nbsp;<a href="/AutopartsSaleSystem/business/delete.do?id=$id$&amp;search=&amp;status=">删除</a>
	    	</span>
	       
	        <span class="editOperate" style="display: none">
	        	<a href="javascript:void(0)" class="update">保存</a>
	      		  &nbsp;<a href="javascript:void(0)" class="cancel">取消</a>
	        </span>
	    </td>
	</tr>
    </div>

        <!-- /#page-wrapper -->
</body>
</html>