/******************省市区三级联动***************************************/
//获取省份下拉框
function province(){
	$('#province').combobox({  
       valueField:'id',  
       textField:'text', 
       method:'get',//设置get，使所有 Web 服务器都应允许（以防出现405错误）
       url:'../static/data/province.json',  
       onSelect:function(data){
    	   getCities(data);//市级
       },
       onLoadSuccess:function(data){
    		$(this).combobox('setValues', ['--请选择省份--']);
       }
   }); 
	$('#city').combobox('setValues', ['--请选择城市--']);
	$('#town').combobox('setValues', ['--请选择城镇--']);
}

//获取城市下拉框
function getCities(data){
	$('#city').combobox({  
	    valueField:'id',  
	    textField:'text', 
	    data:data.children,  
	    onSelect:function(data){
	    	getTowns(data);
	    }
 }); 
}

//获取区域下拉框
function getTowns(data){
	$('#town').combobox({  
	     valueField:'id',  
	     textField:'text', 
	     data:data.children,
         onLoadSuccess:function(data){
//        	 alert(JSON.stringify(data));
    		$(this).combobox('setValues', [data[0].text]);
         }
	}); 
}
