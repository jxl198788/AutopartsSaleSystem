var towndata = {"591":[{ "id":101,
							"text":"鼓楼区",
					   		"group":350000
					   	},{"id":102,
					   		"text":"台江区",
					   		"group":350000
					   	},{"id":103,
					   		"text":"晋安区",
					   		"group":350000
					   	},{"id":104,
					   		"text":"马尾区",
					   		"group":350000
					   	},{"id":105,
					   		"text":"苍山区",
					   		"group":350000
					   	},{"id":106,
					   		"text":"闽侯县",
					   		"group":350000
					   	},{"id":107,
					   		"text":"长乐县",
					   		"group":350000
					   	},{"id":108,
					   		"text":"福清",
					   		"group":350000
					   	}],
			   	"594":[{ "id":401,
							"text":"莆田市区"
					   	},{"id":402,
					   		"text":"城乡区"
					   	},{"id":403,
					   		"text":"荔城区"
					   	},{"id":404,
					   		"text":"仙游县"
					   	}]
};
var citydata = {"350000":[{ "id":591,
	"text":"福州市",
		"group":350000
	},{"id":592,
		"text":"厦门市",
		"group":350000
	},{"id":593,
		"text":"宁德市",
		"group":350000
	},{"id":594,
		"text":"莆田市",
		"group":350000
	},{"id":595,
		"text":"泉州市",
		"group":350000
	},{"id":596,
		"text":"漳州市",
		"group":350000
	},{"id":597,
		"text":"龙岩市",
		"group":350000
	},{"id":598,
		"text":"三明市",
		"group":350000
	},{"id":599,
		"text":"南平市",
		"group":350000
	}],
"360000":[{ "id":691,
	"text":"吉安市"
	},{"id":692,
		"text":"其他市"
	}]
};
var provincedata = [{	"id":350000,
						"text":"福建省"
					},{"id":360000,
						"text":"江西省"
					}];

//页面初始化
$(function(){
	$('#dataTables-example').DataTable({
	    responsive: true,
	    ordering:false//排序控件
	});
	$('#dataTables-example_length').hide();//每页显示条数下拉框
	$('#dataTables-example_info').hide();//分页显示提示信息

	getProvinces();//省份初始化
});

//营业执照图片选择实时显示
function setImagePreview() { 
	var docObj=document.getElementById("imag-file"); 
	var imgObjPreview=document.getElementById("busi-licence"); 
	if(docObj.files && docObj.files[0]){ 
		//火狐下，直接设img属性 
		imgObjPreview.style.display = 'block'; 
		imgObjPreview.style.width = '120px'; 
		imgObjPreview.style.height = '80px'; 
		//imgObjPreview.src = docObj.files[0].getAsDataURL(); 
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式 
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]); 
	}else{ 
		//IE下，使用滤镜 
		docObj.select(); 
		var imgSrc = document.selection.createRange().text; 
		var localImagId = document.getElementById("localImag"); 
		//必须设置初始大小 
		localImagId.style.width = "120px"; 
		localImagId.style.height = "80px"; 
		//图片异常的捕捉，防止用户修改后缀来伪造图片 
		try{ 
			localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)"; 
			localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
		}catch(e){ 
			alert("您上传的图片格式不正确，请重新选择!"); 
			return false; 
		} 
		imgObjPreview.style.display = 'none'; 
		document.selection.empty(); 
	} 
	return true; 
} 

//供应商信息修改
$("#supplier_form #update").click(function(){
	$("#supplier_form #update").hide();
	$("#supplier_form #submit").show();
	//表单中所有的文本框
	$("#supplier_form input").each(function(){
		$(this).attr("disabled",false);//移除不可编辑属性
	}, {});
	//表单中所有的下拉框
	$("#supplier_form select").each(function(){
		$(this).attr("disabled",false);
	}, {});
});

//供应商信息保存
$("#supplier_form #submit").click(function(){
	$("#supplier_form #submit").hide();
	$("#supplier_form #update").show();
	//表单中所有的文本框
	$("#supplier_form input").each(function(){
		$(this).attr("disabled",true);
	}, {});
	//表单中所有的下拉框
	$("#supplier_form select").each(function(){
		$(this).attr("disabled",true);
	}, {});
});

//供应商信息取消
$("#supplier_form #cancel").click(function(){
//	alert($("#supplier_form #update").is(":hidden"));//is()函数用于判断对象的可视化，返回true/false
	if(!$("#supplier_form #update").is(":hidden")){
		$("#supplier_form").hide();
	}else{
		$("#supplier_form #submit").hide();
		$("#supplier_form #update").show();
		//表单中所有的文本框
		$("#supplier_form input").each(function(){
			$(this).attr("disabled",true);
		}, {});
		//表单中所有的下拉框
		$("#supplier_form select").each(function(){
			$(this).attr("disabled",true);
		}, {});
	}
});

/******************省市区三级联动***************************************/
//获取省份下拉框
function getProvinces(){
	$('#province').combobox({  
       valueField:'id',  
       textField:'text', 
       data:provincedata,
       //url:'../broadbandInfoQuery/guangTongAction.do?operate=getProvinces&service_name=GET_PROVINCES',  
       onSelect:function(data){
       	getCitys(data.id);
		 },
		 onLoadSuccess:function(){
        	var dataArr = $('#province').combobox("getData");
        	if(dataArr.length==1){
        		var data = dataArr[0];
        		$('#province').combobox("select",data.id);
        	}
       }
   }); 
}

//获取城市下拉框
function getCitys(provinceid){
	$('#city').combobox({  
     valueField:'id',  
     textField:'text', 
     data:citydata[provinceid],
//     url:'../broadbandInfoQuery/guangTongAction.do?operate=getCitys&service_name=GET_CITIES&params_name=stateCode&params_value='+provinceId,  
      onSelect:function(data){
      	getDist(data.id);
		}
 }); 
}

//获取区域下拉框
function getDist(cityId){
	$('#town').combobox({  
     valueField:'id',  
     textField:'text', 
     data:towndata[cityId],
//     url:'../broadbandInfoQuery/guangTongAction.do?operate=getDist&service_name=GET_DIST&params_name=cityCode&params_value='+cityId,  
     onSelect:function(data){
	   }
 }); 
}
