
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
//	    searching:false,//查询控件
	    ordering:false//排序控件
	});
	$('#dataTables-example_length').hide();//隐藏页面显示条数的下拉控件
	$('#dataTables-example_info').hide();//隐藏分页的提示信息：显示第几条到第几条
}

