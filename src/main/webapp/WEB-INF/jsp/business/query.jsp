<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/jsp/head.jsp" %> 
 <style type="text/css">
        .layui-layer-content {
            border: 1px #F4811F solid;
        }
        .selectSpan{
            padding: 0px 12px;
            background-color: wheat;
            height: 20px;
            display: inline-block;
            padding: 0px 12px;
            margin-bottom: 0;
            font-size: 14px;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: center;
            white-space: nowrap;
            vertical-align: middle;
            -ms-touch-action: manipulation;
            touch-action: manipulation;
            /*cursor: pointer;*/
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
            background-image: none;
            border: 1px solid transparent;
            border-radius: 4px;
        }

        .moreSpan{
            background-color: #EEE;
            cursor: pointer;
        }
    </style>

<script type="text/javascript">
var typeId = "";
var autoTypeTabless;
function showSpan(id){
    var target = $("#"+id);
    target.toggle();
}
function showDescription(typeIdsStr){
	var arr = (typeIdsStr+"").split(',');
	var params = "";
	for(var i=0;i<arr.length;i++){
		params += "&typeIds="+arr[i];
	}
	$.ajax(
			  {	
			   type: "GET",
			   url: "${ctx}/business/types",
			   data:params,
			   success: function(data){
				   	if(autoTypeTabless){
				   		autoTypeTabless.destroy();
				   	}
					autoTypeTabless = $('#autoTypeTable').DataTable( {
				        rowId: 'id',
				        dom: "rt",//Bfrtip B button f search
				        pageLength: 1000,
				        ordering : false ,
				        data:data.data,
				        //ajax: "./tables-editor.json",
				        columns: [
							{ data: "brand.name"  
							},      
				            { data: "series.name" },
				            { data: "type.manufactureYear","defaultContent": ""/* ,"orderable": false  */},
				            { data: "type.engineType" ,"defaultContent": ""},
				            { data: "type.horsepower","defaultContent": ""},
				            { data: "type.power" ,"defaultContent": ""},
				            { data: "type.displacement" ,"defaultContent": ""},
				            { data: "type.bodyType" ,"defaultContent": ""},
				            { data: "type.origin"  ,"defaultContent": "" }
				        ]
				    } );
					$('#myModal').modal({
				        //keyboard: false,
				        //backdrop:"static",
				        show:true
					})
			   }
		});
	
	
	
}
$(function(){
	$(".tabPanelButton").on("click",function(){
		$(this).removeClass("btn-default").addClass("btn-success");
		$(this).siblings().each(function(index,target){
			$(this).removeClass("btn-success").addClass("btn-default");
		})
	})
	$("#brand").on("change",function(){
		var value = $(this).val();
		$.ajax({
			   type: "GET",
			   url: "${ctx}/business/series/"+value,
			   success: function(data){
				   $("#series").html("");
				   for(var i=0;i<data.length;i++){
					   //class="btn btn-default"
					   $("#series").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
				   }	     	
			   }
		});
	}).on("dblclick","option",function(){
		$("#seriesButton").trigger("click");
	}).keydown(function(e){
		if(e.keyCode == 13){
			$("#seriesButton").trigger("click");
		}
	});


	$("#series").on("change",function(){
		var value = $(this).val();
		$.ajax({
			   type: "GET",
			   url: "${ctx}/business/type/"+value,
			   success: function(data){
				   $("#type").html("");
				   for(var i=0;i<data.length;i++){
					   var text = data[i].manufactureYear + "款&nbsp;&nbsp;" + data[i].engineType + "&nbsp;&nbsp;" + 
					   data[i].horsepower + "&nbsp;&nbsp;"+ data[i].power + "&nbsp;&nbsp;"+ data[i].displacement + "&nbsp;&nbsp;"
					   $("#type").append('<option value="'+data[i].id+'">'+text+'</option>');
				   }	     	
			   }
		});
	}).on("dblclick","option",function(){
		$("#typeButton").trigger("click");
	}).keydown(function(e){
		if(e.keyCode == 13){
			$("#typeButton").trigger("click");
		}
	});
	$("#type").on("change",function(){
		typeId = $(this).val();
	}).on("dblclick","option",function(){
		$("#sureType").trigger("click");
	}).keydown(function(e){
		if(e.keyCode == 13){
			$("#sureType").trigger("click");
		}
	});
	$("#submitBtn").on("click",function(){
		$("#searchForm").submit();
	});
	
	$("#sureType").on("click",function(){
		if(typeId){
			window.location.href = "${ctx}/business/query.do?autoTypeId="+typeId;
		}else{
			layer.tips('您还未选择车型', '#sureType' ,{tips: 4});
		}
	});
	$("#cancelType").on("click",function(){
		layer.close(typeLayer);
	});
	/*
		layer2.2
	*/
    $(".moreSpan").on("mouseenter",function(){
        $(this).css("backgroundColor","#999");
    }).on("mouseleave",function(){
        $(this).css("backgroundColor"," #EEE");
    });
    $("#selectType").on("click",function(e){
        $(".layui-layer-content").show();
        typeLayer = layer.open({
            type: 1,
            shade: false,
            title: false, //不显示标题
            content: $('.layer-content'), //捕获的元素
            offset: '150px',
            area : ['495px' , '430px'],
            fix: false,
            //offset: ['auto', '400px'],
            cancel: function(index){
                layer.close(index);
                //this.content.hide();
            }
        });
    })
    //加载扩展模块
    layer.config({
        extend: 'extend/layer.ext.js'
    });
	/*
		Editor
	*/
    var data = ${json};
	var queryTable = $('#queryTable').DataTable( {
	        rowId: 'id',
	        dom: "rti",//Bfrtip B button f search
	        language: {
	            "info": "Showing _START_ to _END_ of "+data.data.length+" entries"
	         },
	         "order": [],
	        pageLength: 50,
	        data:data.data,
	        //ajax: "./tables-editor.json",
	        columns: [
				{ data: "imageUrl"  ,"orderable": false, render: function ( data, type, row ) {
				    // Combine the first and last names into a single table field
				    //<input type="checkbox" name="ids" value="${c.id}" >-${c.id}
				    var imgUrl = "#";
				    if(row.imageUrl){
				    	imgUrl = "${ctx}"+row.imageUrl;
				    }
				    return '<img width="64px" height="32px" src="'+imgUrl+'" />';
					}
				},      
	            { data: "productBrand" },
	            { data: "productName"/* ,"orderable": false  */},
	            { data: "productCode" },
	            { data: "productSize","defaultContent": ""},
	            { data: "firstPrice" },
	            { data: "secondPrice" },
	            { data: "thirdPrice" },
	            { data: "autoTypeId"  , render: function ( data, type, row ) {
	            	var str = row.autoTypes + "";
	            		if(str){
	            			return '<a href="javascript:showDescription(\''+row.autoTypes+'\')">详情</a>';
	            		}
						return "未匹配相应车型";
	          	 	}
	            }
	        ]
	    } );

})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/nav.jsp" %>
	<div id="page-wrapper">
           <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">配件查询</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <form id="searchForm" action="${ctx}/business/query.do?partSortId=${partSortId}&productBrand=${productBrand}&autoTypeId=${autoTypeId}" method="post">
            <div style="margin-left: auto;margin-right: auto;width: 400px">
                <button type="button" class="btn btn-outline btn-primary btn-sm">关键字</button>
                <button type="button" class="btn btn-outline btn-primary btn-sm">VIN</button>
            </div>

            <div class="input-group custom-search-form" style="margin-left: auto;margin-right: auto;width:400px;">
                <input type="text" name="search" value="${search }" class="form-control"  placeholder="请输入配件名称、配件编号、品牌">
                <span class="input-group-btn">
                     <button id="submitBtn" class="btn btn-default" type="button" style="width: 40px;height: 34px;">
                         <i class="fa fa-search"></i>
                     </button>
                </span>
            </div>
             </form>
            <div>
           		 <b>过滤器：</b>
           		 	<c:if test="${partSortId!=null}">
           		 		<a href="${ctx}/business/query.do?search=${search}&productBrand=${productBrand}&autoTypeId=${autoTypeId}" class="btn btn-default" style="height: 25px;padding: 3px 12px;font-size: 12px;border-radius: 20px;">
           		 	      ${partSortName} <span class="badge" style="color: #333;background-color: #fcf8e3;padding: 4px 7px;margin-left: 2px;">✘</span></a>
           		 	</c:if>
           		 	<c:if test="${productBrand!=null}">
           		 		<a href="${ctx}/business/query.do?search=${search}&partSortId=${partSortId}&partSortName=${partSortName}&autoTypeId=${autoTypeId}" class="btn btn-default" style="height: 25px;padding: 3px 12px;font-size: 12px;border-radius: 20px;">
           		 	      ${productBrand} <span class="badge" style="color: #333;background-color: #fcf8e3;padding: 4px 7px;margin-left: 2px;">✘</span></a>
           		 	</c:if>
           		 	<c:if test="${autoTypeId!=null}">
           		 		<a href="${ctx}/business/query.do?search=${search}&productBrand=${productBrand}&partSortId=${partSortId}&partSortName=${partSortName}" class="btn btn-default" style="height: 25px;padding: 3px 12px;font-size: 12px;border-radius: 20px;">
           		 	   ${autoType.manufactureYear }款&nbsp;&nbsp;${autoType.engineType }&nbsp;&nbsp; 
					   ${autoType.horsepower }&nbsp;&nbsp;${autoType.power }&nbsp;&nbsp;
					   ${autoType.displacement }&nbsp;&nbsp;<span class="badge" style="color: #333;background-color: #fcf8e3;padding: 4px 7px;margin-left: 2px;">✘</span></a>
           		 	</c:if>
            </div>
            <br/>
            <div>
                <div>
                   	 配件车型：
                    <a href="javascript:void(0);" id="selectType" class="btn" style="padding: 0px 12px;height: 20px;">选择车型</a>
                </div>
                <div>
               	     配件分类：
                    <span>
                    <c:forEach items="${partSortList}" var="p" step="1" begin="0" end="4">
                    	<a href="${ctx}/business/query.do?search=${search}&partSortId=${p.id}&partSortName=${p.name}&productBrand=${productBrand}&autoTypeId=${autoTypeId}" class="btn" style="padding: 0px 12px;height: 20px;">${p.name}</a>
                    </c:forEach>

                    </span>
                    <span id="moreType" style="display: none">
                    <c:forEach items="${partSortList}" var="p" step="1" begin="5">
                    	<a href="${ctx}/business/query.do?search=${search}&partSortId=${p.id}&partSortName=${p.name}&productBrand=${productBrand}&autoTypeId=${autoTypeId}" class="btn" style="padding: 0px 12px;height: 20px;">${p.name}</a>
                    </c:forEach>
                    </span>
                    <span class="selectSpan moreSpan" style=""  onclick="showSpan('moreType')">More</span>

                </div>       
                <div>
                    配件品牌：
                    <span>
                    <c:forEach items="${producerList}" var="p" step="1" begin="0" end="4">
                    	<a href="${ctx}/business/query.do?search=${search}&partSortId=${partSortId}&partSortName=${partSortName}&productBrand=${p.name}&autoTypeId=${autoTypeId}" class="btn" style="padding: 0px 12px;height: 20px;">${p.name}</a>
                    </c:forEach>

                    </span>
                    <span id="moreProducer" style="display: none">
                    <c:forEach items="${producerList}" var="p" step="1" begin="5">
                    	<a href="${ctx}/business/query.do?search=${search}&partSortId=${partSortId}&productBrand=${p.name}&autoTypeId=${autoTypeId}" class="btn" style="padding: 0px 12px;height: 20px;">${p.name}</a>
                    </c:forEach>
                    </span>
                    <span class="selectSpan moreSpan" style=""  onclick="showSpan('moreProducer')">More</span>
                </div>

            </div>
            <br/>
            <table id="queryTable" class="display" cellspacing="0" style="font-size: 12px;">
                <thead>
                <tr>
                    <th>图片</th>
                    <th>品牌</th>
                    <th>配件名称</th>
                    <th>配件编码</th>
                    <th>规格</th>
                    <th>一级报价</th>
                    <th>二级报价</th>
                    <th>三级报价</th>
                    <th>合适车型</th>
                </tr>
                </thead>
                <tbody>
                
         
                </tbody>
            </table>
            <div class="col-sm-6" style="position:relative;margin-left: 300px;width: 70%">
            <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
           		${pager.pageView }
            </div>
            </div>
        </div>
		<!-- 弹出层-->
            <div class="layer-content" style="display: none;">
                <input type="text" class="form-control" style="width: 220px;margin-left: 93px;margin-top: 20px;" placeholder="请输入VIN...">
                    <span class="input-group-btn" style="float:left;top: -34px;left: 312px;">
                        <button class="btn btn-default"  type="button" style="width: 40px;height: 34px;" >
                            <i class="fa fa-search"></i>
                        </button>
                        <span class="input-group-btn">s
                </span>
                    </span>
                <div style="margin-top:10px;margin-left: 44px;">
                    <button id="brandButton" type="button" class="btn btn-success tabPanelButton"
                            href="#brandPanel" aria-controls="brandPanel" role="tab" data-toggle="tab" style="width: 130px;;">品&nbsp;&nbsp;牌</button>

                    <button id="seriesButton" type="button" class="btn btn-default tabPanelButton"
                            href="#seriesPanel" aria-controls="seriesPanel" role="tab" data-toggle="tab" style="width: 130px;">车&nbsp;&nbsp;系</button>

                    <button id="typeButton" type="button" class="btn btn-default tabPanelButton"
                            href="#typePanel" aria-controls="typePanel" role="tab" data-toggle="tab" style="width: 130px;">车&nbsp;&nbsp;型</button>
                </div>
                <div id="myTabContent" class="tab-content" style="width: 81%;margin-left: 45px">
                    <div role="tabpanel" class="tab-pane fade active in" id="brandPanel" aria-labelledby="brandPanel-tab">
                        <select id="brand" name="brand" class="form-control"  size="15">
                            <c:forEach items="${brandList }" var="brand">
                            	<option value="${brand.id }">${brand.name }</option>                          	
                            </c:forEach>
                        </select>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="seriesPanel" aria-labelledby="seriesPanel-tab">

                        <select id="series" name="series" class="form-control" size="15">
                        </select>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="typePanel" aria-labelledby="typePanel-tab">

                        <select id="type" name="type" class="form-control" size="15">
                        </select>
                    </div>
                </div>
                    <button type="button" id="sureType" class="btn btn-default" style="margin-left: 173px;margin-top: 14px;">确定</button>
                    <button type="button" id="cancelType" class="btn btn-default" style="margin-left: 36px;margin-top: 14px;">取消</button>
            </div>
        <!-- 弹出层  End -->
        <!-- Modal -->
          <div id="myModal"   class="modal fade" tabindex="-1" role="dialog" aria-labelledby="apply">
                <div class="modal-dialog" role="document">
                    <div class="modal-content" style="width:650px;">
                      
                        <div class="modal-body">
                            <table id="autoTypeTable" class="display" cellspacing="0" style="font-size: 12px;">
				                <thead>
				                <tr>
				                    <th>汽车品牌</th>
				                    <th>车系</th>
				                    <th>年款</th>
				                    <th>引擎类型</th>
				                    <th>马力</th>
				                    <th>功率</th>
				                    <th>排量</th>
				                    <th>车架</th>
				                    <th>原产地</th>
				                </tr>
				                </thead>
				                <tbody>
				              				         
				                </tbody>
				            </table>
                        </div>
                        <div class="modal-footer">
                             <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        <!-- Modal End -->
        <!-- /#page-wrapper -->
</body>
</html>