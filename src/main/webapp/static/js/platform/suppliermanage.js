//页面初始化
$(function(){
	$('#dataTables-example').DataTable({
	    responsive: true,
	    ordering:false//排序控件
	});
	$('#dataTables-example_length').hide();//每页显示条数下拉框
	$('#dataTables-example_info').hide();//分页显示提示信息
});

//改变供应商的账户状态，锁定0 or 激活1
function doChangeStatus(id,option){//option：0 or 1
	if(confirm("您确定要执行此操作吗？")){
		$.ajax({
			type:"post",
			url:"updateUserStatusById/"+id,
			data:{locked:option},
			success:function(data){
//				alert("success:【"+JSON.stringify(data)+"】");
				alert(data.imsg);
				$("#suppliersForm").submit();
			},
			error:function(data){
				alert("error:【"+JSON.stringify(data)+"】");
			},
			dataType:"json"
		});
	}
}

//根据id删除供应商
function doDelete(id){
	if(confirm("您确定要执行此操作吗？")){
		$.ajax({
			type:"post",
			url:"deleteById/"+id,
			success:function(data){
				alert(data.imsg);
				$("#suppliersForm").submit();
			},
			error:function(data){
				alert("error:【"+JSON.stringify(data)+"】");
			},
			dataType:"json"
		});
	}
}

//点击弹出供应商详细信息
function toForm(obj,id,supplierid){
	$("#userId").val(id);
	var userId = $("#userId").val();
	$("#supplierId").val(supplierid);
	$.ajax({
		type:"post",
		url:"getSupplierById/"+userId,
		success:function(data){
//			alert("success:【"+JSON.stringify(data)+"】");
//			alert(data.supplier.name);
			$("#username").val(data.supplier.username);
			$("#telphone").val(data.supplier.telphone);
			$("#domain_name").val(data.supplier.domain_name);
			$("#suppliername").val(data.supplier.suppliername);
			$("#busi-licence").attr("src",path+"/upload/image/busslicense/"+data.supplier.businessLicenseUrl);
			$("#province").combobox('setValue', data.supplier.province);
			$("#city").combobox('setValue', data.supplier.city);
			$("#town").combobox('setValue', data.supplier.town);
			$("#addr").val(data.supplier.addr);
			$("#linkman").val(data.supplier.linkman);
			//if(is_root==1){//登录用户为根管理员，“修改”按钮才有效
				$("#update").attr("disabled",false);
//			}else{
//				$("#update").attr("disabled",true);
//			}
		},
		error:function(data){
			alert("error:【"+JSON.stringify(data)+"】");
		},
		dataType:"json"
	});
	obj.href="#supplier_form_div";
}

//供应商信息修改
function updateDetail(){
	$("#update").hide();
	$("#submit").show();
	//表单中所有的文本框
	$("#supplier_form_div input").each(function(){
		$(this).attr("disabled",false);//移除不可编辑属性
	}, {});
	//表单中所有的下拉框
	$("#supplier_form_div select").each(function(){
		$(this).attr("disabled",false);
	}, {});
}

//供应商信息保存
function submitDetail(){
	if(confirm("您确定要执行此操作吗？")){
		var userId = $("#userId").val();
		var username = $("#username").val();//获取用户名
		var telphone = $("#telphone").val();//获取电话号码
		var domain_name = $("#domain_name").val();//获取供应商域名
		var supplierId = $("#supplierId").val();
		var suppliername = $("#suppliername").val();//获取供应商名称
		var filepath = $("#imag-file").val();//获取file标签的文件路径
		var province = $("#province").combobox("getValue");//获取省
		var city = $("#city").combobox("getValue");;//获取市
		var town = $("#town").combobox("getValue");;//获取县
		var addr = $("#addr").val();//获取地址
		var linkman = $("#linkman").val();//获取联系人
		$.ajax({
			type:"post",
			url:"updateSupplierById/"+userId+"/"+supplierId,
			data:{username:username,telphone:telphone,domain_name:domain_name,suppliername:suppliername,filepath:filepath,province:province,city:city,town:town,addr:addr,linkman:linkman},
			success:function(data){
				$("#suppliersForm").submit();
				if(data.imsg!=null&&data.imsg!=""){
					alert(data.imsg);
				}
			},
			error:function(data){
				alert("error:【"+JSON.stringify(data)+"】");
			},
			dataType:"json"
		});
		$("#submit").hide();
		$("#update").show();
		//表单中所有的文本框
		$("#supplier_form_div input").each(function(){
			$(this).attr("disabled",true);
		}, {});
		//表单中所有的下拉框
		$("#supplier_form_div select").each(function(){
			$(this).attr("disabled",true);
		}, {});
	}
}

//点击取消按钮的事件
function doCancel(){
	$("#submit").hide();
	$("#update").show();
	//表单中所有的文本框
	$("#supplier_form_div input").each(function(){
		$(this).attr("disabled",true);
	}, {});
	//表单中所有的下拉框
	$("#supplier_form_div select").each(function(){
		$(this).attr("disabled",true);
	}, {});
}

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
