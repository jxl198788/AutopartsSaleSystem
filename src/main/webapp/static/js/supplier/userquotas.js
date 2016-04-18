//初始化变量
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
	tableEvent('#dataTables-example');//表格属性设置
	$('#quotas_info').tree({//树结构初始化
        data:treedata,//treedata数据格式
        method:'get',
        animate:true
	});
});

//复选框事件
$(".table-div table>tbody>tr td:nth-child(1)").each(function(){
	$(this).css("display","none");
});
$(".table-div table>thead>tr th:nth-child(1)").css("display","none");
//多选事件
$("#bulk").click(function(){
	$(".table-div table>tbody>tr td:nth-child(1)").each(function(){
		if($(this).css("display")=="none"){
			$(this).css("display","block");
		}else{
			$(this).css("display","none");
		}
	});
	var obj = $(".table-div table>thead>tr th:nth-child(1)");
	if(obj.css("display")=="none"){
		obj.show();
	}else{
		obj.css("display","none");
	}
});
//升级<a>标签的点击事件
$(".table-div table>tbody>tr td:nth-child(7) a:nth-child(4)").each(function(){
	$(this).click(function(){
		divmove("#sel_type_div",$(this));//div显示位置随鼠标点击位置改变事件
		clickhide("#sel_type_div");//div点击隐藏事件
//		var index = $(this).parent("td").parent("tr").index();//获取选择行的索引index
		$(this).attr("href","javascript:ulEvent();");//显示ul设置的下拉选择框
	});
});

//升级套餐“选择”按钮事件
$(".rise_pack_div button").click(function(){//click改成select？？？？？？？？？？？？？？？？？？？？
	$("#rise_warning").fadeIn("slow");
});

//取消支付升级事件
$("#rise_no").click(function(){
	$("#rise_warning").fadeOut(500);
});

//ul事件设置
function ulEvent(){
	var aa = $("#sel_type_div").css("display");
	if(aa=="none"){
		$("#sel_type_div").fadeIn(400);//淡入
	}
}
//表格事件设置
function tableEvent(obj_id){
	$(obj_id).DataTable({
	    responsive: true,
	    pageLength:4,//设置每页显示条数
	    searching:false,//查询控件
	    ordering:false,//排序控件
	    pageChange:function(){
	    	alert(1);
	    }
	});
	$('#dataTables-example_length').hide();//隐藏页面显示条数的下拉控件
	$('#dataTables-example_info').hide();//隐藏分页的提示信息：显示第几条到第几条
}

//div显示位置随鼠标点击位置改变事件
function divmove(target,obj){
	var _ww = $(window).width();
	var _tw = $(target).outerWidth(true);
	var _offset = obj.offset();
//	alert(_ww+"-"+_tw+"-"+_offset.left+"-"+_offset.top);
	if(_offset.left+_tw<_ww){
		$(target).css({left:_offset.left+78,top:_offset.top+15});
	}else{
		$(target).css({left:205,top:_offset.top+5});
	}
}
//点击div以外的地方，隐藏该div
function clickhide(objid){//objid为目标div的id
	  $("body").css("overflow","hidden");
	  $(objid).css("display","block");
	  document.onclick=function(){
		  $(objid).css("display","none");
	  };
}
