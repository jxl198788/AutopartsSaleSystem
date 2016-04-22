
//页面初始化
$(function(){
    $("#suppliersForm").ajaxSubmit();
	$('#dataTables-example').DataTable({
	    responsive: true,
	    ordering:false//排序控件
	});
	$('#dataTables-example_length').hide();//每页显示条数下拉框
	$('#dataTables-example_info').hide();//分页显示提示信息
	$("#submit").on("click",function(){
	       $(".panel-body-form").ajaxSubmit();
    });
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

