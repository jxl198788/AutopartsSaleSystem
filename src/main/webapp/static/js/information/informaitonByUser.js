/**
 * 用户的JS
 */

//页面初始化
$(function(){
	initTable();//初始化表格数据
	setInterval("showTime()", 5000); 
});

function showTime()
{
	url = path+"/information/loop.do";
	window.location.reload(url);
}

function jinru(num){
    $("#"+num).find("td").eq(1).show();
  
}
function likai(num){
	$("#"+num).find("td").eq(1).hide();
}

function realread(num){
	var url = path + "/information/updataInformation.do"
	$.post(url,{id:num},function(data){
		if(data =="1"){
			$("#"+num).find("td").eq(0).removeAttr("style");
			$("#"+num).find("td").eq(0).attr("color","gary");
		}
	});
}

function delInformation(num){
	var url = path + "/information/delInformation.do"
	$.post(url,{id:num},function(data){
		if(data =="1"){
			url = path+"/information/loop.do";
			window.location.reload(url);
		}
	});
}


//初始化表格数据
function initTable(){
	var str = "";
	if(data1!=null&&data1.length>0){
		for(var i = 0;i<data1.length;i++){
			var obj = data1[i];
			str += "<tr id='"+obj.id+"' onmouseover='jinru("+obj.id+")'onmouseout='likai("+obj.id+")'>";
			if(obj.checkStatus == 0){
				str += "<td><li style='color: red'>"+obj.newsConent+"</li></td><td style='display: none;'><a onclick='realread("+obj.id+")' >已读</a> 	&ensp; 	&ensp; 	&ensp;<a  onclick='delInformation("+obj.id+");' >删除</a></td>";
			}
			
			if(obj.checkStatus == 1){
				str += "<td><li style='color: gary'>"+obj.newsConent+"</li></td><td style='display: none;'>&ensp; 	&ensp;<a  onclick='delInformation("+obj.id+");' >删除</a></td>";
			}
		}
	}else{
		str += "<tr>";
		str += "<td colspan='6' align='center'>";
		str += "暂无数据";
		str += "</td></tr>";
	}
	$("#tbody_data").html(str);
}