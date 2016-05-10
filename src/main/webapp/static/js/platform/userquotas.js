
var treedata = [{
	"id":1,
	"text":"壳牌供应商（高级查询 配额100-已分配80-剩余20 已分配80-已使用40-未使用40<br/><label>普通查询 配额100-已分配80-剩余20 已分配80-已使用40-未使用40）<label>",
	"children":[{
		"id":11,
		"text":"壳牌供应商（高级查询 已分配20-已使用10-未使用10<br/><label>普通查询 已分配20-已使用10-未使用10）</label>",
		"children":[{
			"id":111,
			"text":"壳牌二级分销商（高级查询 已分配20-已使用10-未使用10<br/><label>普通查询 已分配20-已使用10-未使用10）</label>",
			"children":[{
					"id":1111,
					"text":"壳牌三级分销商（高级查询 已分配10-已使用1-未使用9<br/><label>普通查询 已分配10-已使用2-未使用8）</label>",
					"children":[]
					},{
					"id":1112,
					"text":"壳牌维修厂（高级查询 已分配10-已使用1-未使用9<br/><label>普通查询 已分配10-已使用2-未使用8）</label>",
					"children":[]
					}]
		},{
			"id":112,
			"text":"壳牌维修厂（高级查询 已分配20-已使用10-未使用10<br/><label>普通查询 已分配20-已使用10-未使用10）</label>",
			"children":[{
				"id":1111,
				"text":"张三 139000000 高级查询使用2次 普通查询使用1次"
				},{
				"id":1112,
				"text":"李四 139000000 高级查询使用2次 普通查询使用1次"
				}]	
		}]
	}]
}];

//页面初始化
$(function(){
	tableSet('#dataTables-example');//表格属性设置
	$('#quotas_info').tree({//树结构初始化
        data:treedata,
        method:'get',
        animate:true
	});
});

//表格属性设置
function tableSet(obj_id){
	$(obj_id).DataTable({
	    responsive: true,
	    pageLength:4,//设置每页显示条数
	    searching:false,//查询控件
	    ordering:false//排序控件
	});
	$('#dataTables-example_length').hide();//隐藏页面显示条数的下拉控件
	$('#dataTables-example_info').hide();//隐藏分页的提示信息：显示第几条到第几条
}

//复选框事件
$(".table-div table>tbody>tr td:nth-child(1)").each(function(){
	$(this).css("display","none");
});
$(".table-div table>thead>tr th:nth-child(1)").css("display","none");

//多选事件
$("#bulk").click(function(){
	$(".table-div table>tbody>tr td:nth-child(1)").each(function(){
		$(this).css("display","block");
	});
	$(".table-div table>thead>tr th:nth-child(1)").show();
	$(this).hide();
	$("#bulk_set").show();
	$("#bulk_up").show();
	$("#bulk_cancel").show();
});

//取消批量操作
$("#bulk_cancel").click(function(){
	$(".table-div table>tbody>tr td:nth-child(1)").each(function(){
		$(this).css("display","none");
	});
	$(".table-div table>thead>tr th:nth-child(1)").css("display","none");
	$("input[type='checkbox']").each(function(){
		$(this).removeAttr("checked");//消除选中后的checkbox
	});
	$(this).hide();
	$("#bulk_set").hide();
	$("#bulk_up").hide();
	$("#bulk").show();
});

//批量设置操作
function bulkSet(obj){
	var ids="";
	$("input:checked").each(function(){
		ids=ids+$(this).val()+",";// 选中的值 
	});
	ids = ids.substring(0,ids.length-1);
	var supplierids = "";
	$.ajax({
		type:"post",
		url:"getUserQuotasByKeys/"+ids,
		success:function(data){
			setUserQuotas = data.setUserQuotas;
			size = data.size;
			var str = "";
			for (var i = 0; i < setUserQuotas.length; i++) {
				var obj = setUserQuotas[i];
				supplierids = supplierids + obj.supplierid + ",";
				str += '<tr class="success">';
				str +='<td>'+obj.username+'</td>';
				str +='<td>'+obj.telphone+'</td>';
				str +='<td>'+obj.suppliername+'</td>';
				str +='<td>';
				str +='<select id="types" name="types" class="select-css left margin" onchange="changeQuotas(this,'+obj.id+');">';
				str +='<option value="1">高级查询</option>';
				str +='<option value="2">普通查询</option>';
				str +='</select>';
				str +='</td>';
				str +='<td>';
//				str +='<span class="left">设置配额</span>';
				str +='<input class="form-control form-group-input left" id="set_quotas" name="set_quotas" type="text" placeholder="设置配额">';
				str +='<span id="high_quotas'+obj.id+'" class="left" style="margin-left:5px">配额'+obj.high_quotas+'-已分配'+obj.h_deal_quotas+'-剩余'+obj.h_left_quotas+' 已分配'+obj.h_deal_quotas+'-已使用'+obj.h_use_quotas+'-未使用'+obj.h_unuse_quotas+'</span>';
				str +='<span id="comm_quotas'+obj.id+'" class="left display-none" style="margin-left:5px;">配额'+obj.comm_quotas+'-已分配'+obj.c_deal_quotas+'-剩余'+obj.c_left_quotas+' 已分配'+obj.c_deal_quotas+'-已使用'+obj.c_use_quotas+'-未使用'+obj.c_unuse_quotas+'</span>';
				str +='</td>';
				str +='<td></td>';
				str +='</tr>';
			}
			supplierids = supplierids.substring(0,supplierids.length-1);
			str +='<tr><td align="center" colspan="7"><button type="button" class="btn btn-success" onclick="updateQuotasByKeys('+"'"+supplierids+"'"+');">确认</button><button type="button" class="btn btn-warning" data-dismiss="modal" aria-label="Close" style="margin-left:20px;">取消</button></td></tr>';
			$("#setQuotaTable").html(str);
		},
		error:function(data){
			alert("error:【"+JSON.stringify(data)+"】");
		},
		dataType:"json"
	});
	obj.href="#quotas_set_div";
}

//批量升级查看操作
function bulkUp(obj){
	var str="";
	$("input:checked").each(function(){
		str=str+$(this).val()+",";//选中的值 
	});
	str = str.substring(0,str.length-1);
	$.ajax({
		type:"post",
		url:"getUserQuotasByKeys/"+str,
		success:function(data){
			var setUserQuotas = data.setUserQuotas;
			var str = "";
			for (var i = 0; i < setUserQuotas.length; i++) {
				var obj = setUserQuotas[i];
				str += '<tr class="success">';
				str +='<td>'+obj.username+'</td>';
				str +='<td>'+obj.telphone+'</td>';
				str +='<td>'+obj.suppliername+'</td>';
				str +='<td></td>';//“20元高级查询配额10套餐”，这个暂时不做展示，等购买配额的弄好再做处理
				str +='<td>';
				str +='高级查询 配额'+obj.high_quotas+'-已分配'+obj.h_deal_quotas+'-剩余'+obj.h_left_quotas+' 已分配'+obj.h_deal_quotas+'-已使用'+obj.h_use_quotas+'-未使用'+obj.h_unuse_quotas;
				str +='<br/>普通查询 配额'+obj.comm_quotas+'-已分配'+obj.c_deal_quotas+'-剩余'+obj.c_left_quotas+' 已分配'+obj.c_deal_quotas+'-已使用'+obj.c_use_quotas+'-未使用'+obj.c_unuse_quotas;
				str +='</td>';
				str +='</tr>';
			}
			$("#quotasUpTable").html(str);
		},
		error:function(data){
			alert("error:【"+JSON.stringify(data)+"】");
		},
		dataType:"json"
	});
	obj.href="#quotas_detail_div";
}

function changeQuotas(obj,userid){
	if(obj.value==1){//高级查询
		$("#high_quotas"+userid).css("display","block");
		$("#comm_quotas"+userid).css("display","none");
	}else{//普通查询
		$("#comm_quotas"+userid).css("display","block");
		$("#high_quotas"+userid).css("display","none");
	}
}

function changeQuota(obj){
	if(obj.value==1){//高级查询
		$("#high_quotas").css("display","block");
		$("#comm_quotas").css("display","none");
	}else{//普通查询
		$("#comm_quotas").css("display","block");
		$("#high_quotas").css("display","none");
	}
}
//根据用户id显示配额情况
function setUserQuotas(e,id){
	alert(id);
	$.ajax({
		type:"post",
		url:"getUserQuotasByKey/"+id,
		success:function(data){
			var str = "";
			var obj = data.userQuotas;
			str += '<tr class="success">';
			str +='<td>'+obj.username+'</td>';
			str +='<td>'+obj.telphone+'</td>';
			str +='<td>'+obj.suppliername+'</td>';
			str +='<td>';
			str +='<select id="type" name="type" class="select-css left margin" onchange="changeQuota(this);">';
			str +='<option value="1">高级查询</option>';
			str +='<option value="2">普通查询</option>';
			str +='</select>';
			str +='</td>';
			str +='<td>';
//			str +='<span class="left">设置配额</span>';
			str +='<input class="form-control form-group-input left" id="set_quota" name="set_quota" type="text" placeholder="设置配额">';
			str +='<span id="high_quotas" class="left" style="margin-left:5px;">配额'+obj.high_quotas+'-已分配'+obj.h_deal_quotas+'-剩余'+obj.h_left_quotas+' 已分配'+obj.h_deal_quotas+'-已使用'+obj.h_use_quotas+'-未使用'+obj.h_unuse_quotas+'</span>';
			str +='<span id="comm_quotas" class="left display-none" style="margin-left:5px;">配额'+obj.comm_quotas+'-已分配'+obj.c_deal_quotas+'-剩余'+obj.c_left_quotas+' 已分配'+obj.c_deal_quotas+'-已使用'+obj.c_use_quotas+'-未使用'+obj.c_unuse_quotas+'</span>';
			str +='</td>';
			str +='<td>';
			str +='<a id="save" class="td-a2" onclick="saveQuotas('+obj.supplierid+')">确定</a>';
			str +='<a id="cancel" class="td-a1" data-dismiss="modal" aria-label="Close">取消</a>';
			str +='</td>';
			str +='</tr>';
			$("#setQuotaTable").html(str);
		},
		error:function(data){
			alert("error:【"+JSON.stringify(data)+"】");
		},
		dataType:"json"
	});
	e.href="#quotas_set_div";
}

//提交设置的配额
function saveQuotas(supplierid){
	var type = $("#type").val();
	var setquota = $("#set_quota").val();
	if(confirm("您确定要执行此操作吗？")){
		$.ajax({
			type:"post",
			url:"updateUserQuotaByKey/"+type+"/"+supplierid+"/"+setquota,
			success:function(data){
				alert(data.result);
				$("#userQuotasForm").submit();
			},
			error:function(data){
				alert("error:【"+JSON.stringify(data)+"】");
			},
			dataType:"json"
		});
	}
}

//升级
function upUserQuotas(obj,id){
	$.ajax({
		type:"post",
		url:"getUserQuotasByKey/"+id,
		success:function(data){
			var obj = data.userQuotas;
			var str = "";
			str += '<tr class="success">';
			str +='<td>'+obj.username+'</td>';
			str +='<td>'+obj.telphone+'</td>';
			str +='<td>'+obj.suppliername+'</td>';
			str +='<td></td>';//“20元高级查询配额10套餐”，这个暂时不做展示，等购买配额的弄好再做处理
			str +='<td>';
			str +='高级查询 配额'+obj.high_quotas+'-已分配'+obj.h_deal_quotas+'-剩余'+obj.h_left_quotas+' 已分配'+obj.h_deal_quotas+'-已使用'+obj.h_use_quotas+'-未使用'+obj.h_unuse_quotas;
			str +='<br/>普通查询 配额'+obj.comm_quotas+'-已分配'+obj.c_deal_quotas+'-剩余'+obj.c_left_quotas+' 已分配'+obj.c_deal_quotas+'-已使用'+obj.c_use_quotas+'-未使用'+obj.c_unuse_quotas;
			str +='</td>';
			str +='</tr>';
			$("#quotasUpTable").html(str);
		},
		error:function(data){
			alert("error:【"+JSON.stringify(data)+"】");
		},
		dataType:"json"
	});
	obj.href="#quotas_detail_div";
}

//批量设置配额
function updateQuotasByKeys(supplierids){
	alert(supplierids);
	var types = "";
	var setquotas = "";
	$("select[name=types]").each(function(){//同name的select的标签个数
		types = types + $(this).val() + ",";
	});
	$("input[name=set_quotas]").each(function(){//同name的input的标签个数
		setquotas = setquotas + $(this).val() + ",";
	});
	if(confirm("您确定要执行此操作吗？")){
		$.ajax({
			type:"post",
			url:"updateUserQuotaByKeys/"+types+"/"+supplierids+"/"+setquotas,
			success:function(data){
				alert(data.result);
				$("#userQuotasForm").submit();
			},
			error:function(data){
				alert("error:【"+JSON.stringify(data)+"】");
			},
			dataType:"json"
		});
	}
}