    
var treedata = [{
	"id":1,
	"text":"壳牌供应商",
    "attributes":{
        "isDirectory":"true"
    },
	"children":[{
		"id":11,
		"text":"壳牌二级分销商",
        "attributes":{
            "isDirectory":"true"
        },
		"state":"closed",
		"children":[{
			"id":111,
			"text":"张三 13905915518 supperAdmin",
            "attributes":{
                "isDirectory":"false"
            }
		},{
			"id":112,
			"text":"李四 13905915218 admin",
            "attributes":{
                "isDirectory":"false"
            }
		},{
			"id":113,
			"text":"王五 13905915418 user",
            "attributes":{
                "isDirectory":"false"
            }
		}]
	},{
		"id":12,
		"text":"壳牌维修厂",
        "attributes":{
            "isDirectory":"true"
        },
		"children":[{
			"id":121,
			"text":"赵六 13905915218 admin",
            "attributes":{
                "isDirectory":"false"
            }
		},{
			"id":122,
			"text":"小明 13905915218 admin",
            "attributes":{
                "isDirectory":"false"
            }
		},{
			"id":123,
			"text":"小红 13905915218 admin",
            "attributes":{
                "isDirectory":"false"
            }
		},{
			"id":124,
			"text":"小红明 13905915218 admin",
			"checked":true,
            "attributes":{
                "isDirectory":"false"
            }
		}]
	},{
		"id":13,
		"text":"小白",
        "attributes":{
            "isDirectory":"false"
        }
	},{
		"id":14,
		"text":"小黄",
        "attributes":{
            "isDirectory":"false"
        }
	},{
		"id":15,
		"text":"小汪",
        "attributes":{
            "isDirectory":"false"
        }
	}]
}];

//初始化
$(function(){
	treeEvent(".easyui-tree");
});

//树结构事件
function treeEvent(id){
	// 右键点击节点并显示快捷菜单
    $(id).tree({
        data:treedata,
        method:'get',
        animate:true,
        dnd:true,
        onBeforeDrop:function(target, source, point){
            var sIsDirectory =  source.attributes["isDirectory"];
            var tId = target.childNodes[target.childNodes.length-1].childNodes[1].innerText;
            //var tId = $(html).find("span").text();
            var targetNode =  $(id).tree('find',tId);
            var tIsDirectory =  targetNode.attributes["isDirectory"];
            console.log("sIsDirectory"+sIsDirectory);
            console.log("tIsDirectory"+tIsDirectory);
            console.log("point"+point);
            /*if(tIsDirectory=="false"){//叶子节点之间不能被拖动
                if(point=="append"){
                    return false;
                }
            }*/
        },
        formatter:function(node){
            //将nodeId写入到节点的title中
            var nodeId = node.id;
            var childs = node.children;
            if(childs!=undefined){
//            	var len = childs.length;//节点下子节点个数
            	return node.text + '<span style="display: none">'+nodeId+'</span>';//(共计'+len+'人)
            }else{
            	return node.text + '<span style="display: none">'+nodeId+'</span> <a style="margin-left:10px;">锁定<a/> <a style="margin-left:5px;">删除<a/>';
            }
            return null;
        },
        onDblClick: function(node){
            if(node.children || node.attributes["isDirectory"]=="true"){
                $(this).tree('beginEdit',node.target);
            }

        },
        onContextMenu: function(e, node){
            e.preventDefault();
            // 查找节点
//          if(node.children || node.attributes["isDirectory"]=="true"){//只有有子节点的才能显示右键菜单
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY,
                    onClick:function(item){
                        if(item.name == "topAdd"){
                            $(id).tree('insert', {
                                before: node.target,
                                data: {
                                    id: 21,
                                    text: 'undefine',
                                    "attributes":{
                                        "isDirectory":"true"
                                    },
                                    "iconCls":"tree-folder"
                                }
                            });
                        }
                        if(item.name == "underAdd"){
                            $(id).tree('insert', {
                                after: node.target,
                                data: {
                                    id: 21,
                                    text: 'undefine',
                                    "attributes":{
                                        "isDirectory":"true"
                                    },
                                    "iconCls":"tree-folder"
                                }
                            });
                        }
                        if(item.name == "childrenAdd"){
                            $(id).tree('append', {
                                parent: node.target,
                                data: [{
                                    id: 21,
                                    text: 'undefine',
                                    "attributes":{
                                        "isDirectory":"true"
                                    },
                                    "iconCls":"tree-folder"
                                }]
                            });
                        }
                        //删除
                        if(item.name == "delete"){
                            $(id).tree('remove',node.target);
                        }
                    }
                });
//        	}
            $(id).tree('select', node.target);
        }
    });
}