<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="head.jsp" %> 
<script type="text/javascript">
        $(document).ready(function (e) {
        	var error = "${error}";
        	if(error){
        		layer.tips(error, '#username');
        	}
        	
            //设置最大值
            ScrollBar.maxValue = 84;
            ScrollBar.value = 0;
            //初始化
            ScrollBar.Initialize();
            //设置最大值
            ProgressBar.maxValue = 84;
            //设置当前刻度

            //定时滚动条
           /* var index = 0;
            var mProgressTimer = setInterval(function () {
                index += 2;
                ProgressBar.SetValue(index);
            }, 100);*/

        });
        var ScrollBar = {
            value: 20,
            maxValue: 100,
            step: 1,
            currentX: 0,
            Initialize: function () {
                if (this.value > this.maxValue) {
                    alert("给定当前值大于了最大值");
                    return;
                }
                this.GetValue();
                $("#scroll_Track").css("width", this.currentX + 2 + "px");
                $("#scroll_Thumb").css("margin-left", this.currentX + "px");
                this.Value();
                $("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
            },
            Value: function () {
                var valite = false;
                var currentValue;
                $("#scroll_Thumb").mousedown(function () {
                    valite = true;
                    $(document.body).mousemove(function (event) {
                        if (valite == false) return;
                        var changeX = event.clientX - ScrollBar.currentX;
                        currentValue = changeX - ScrollBar.currentX - $("#Demo").offset().left;
                        $("#scroll_Thumb").css("margin-left", currentValue + "px");
                        $("#scroll_Track").css("width", currentValue + 2 + "px");
                        if ((currentValue + 25) >= $("#scrollBar").width()) {
                            $("#scroll_Thumb").css("margin-left", $("#scrollBar").width() - 25 + "px");
                            $("#scroll_Track").css("width", $("#scrollBar").width() + 2 + "px");
                            ScrollBar.value = ScrollBar.maxValue;
                        } else if (currentValue <= 0) {
                            $("#scroll_Thumb").css("margin-left", "0px");
                            $("#scroll_Track").css("width", "0px");
                        } else {
                            ScrollBar.value = Math.round(100 * (currentValue / $("#scrollBar").width()));
                        }
                        $("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
                        //16777199 --> 16777115 蓝到绿 84步
                        //background-color: rgb(171, 205, 239);
                        //document.getElementById("scrollBar").bgColor = 16777199-ScrollBar.value;
                        var tmp = 239 -ScrollBar.value;
                        //console.log(tmp);
                        $("#scrollBar").css("background-color","rgb("+tmp+", 255, 0)");
                        if(ScrollBar.value>=84){
                            $("#yzm").css("background-color","#68FF00");
                        }
                        //$("#scroll_Track").css("background-color","rgb("+tmp+", 255, 0)");
                        //$("#scrollBar").attr("background-color",);
                    });
                });
                $(document.body).mouseup(function () {
                    ScrollBar.value = Math.round(100 * (currentValue / $("#scrollBar").width()));
                    valite = false;
                    if (ScrollBar.value >= ScrollBar.maxValue) ScrollBar.value = ScrollBar.maxValue;
                    if (ScrollBar.value <= 0) ScrollBar.value = 0;
                    $("#scrollBarTxt").html(ScrollBar.value + "/" + ScrollBar.maxValue);
                });
            },
            GetValue: function () {
                this.currentX = $("#scrollBar").width() * (this.value / this.maxValue);
            }
        }
        var ProgressBar = {
            maxValue: 100,
            value: 20,
            SetValue: function (aValue) {
                this.value = aValue;
                if (this.value >= this.maxValue) this.value = this.maxValue;
                if (this.value <= 0) this.value = 0;
                var mWidth = this.value / this.maxValue * $("#progressBar").width() + "px";
                $("#progressBar_Track").css("width", mWidth);
                $("#progressBarTxt").html(this.value + "/" + this.maxValue);
            }
        }
    </script>
     <style type="text/css">
        #Main {
            width:75%;
           /* height: 300px;*/
            /*margin: 0 auto;
            margin-top: 10px;*/
        }
        #scrollBar {
            width: 80%;
            height: 10px;
            background-color: #ccc;
            margin: 0 auto;
            margin-top: 50px;
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
            cursor: pointer;
        }
        #scroll_Track {
            width: 0px;
            height: 10px;
            background-color: #ff4400;
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
        }
        #scroll_Thumb {
            height: 25px;
            width: 25px;
            background-color: #efefef;
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
            border: 1px solid #ffff00;
            -webkit-box-shadow: 0px 0px 5px #ccc;
            -moz-box-shadow: 0px 0px 5px #ccc;
            box-shadow: 0px 0px 5px #ccc;
            position: absolute;
            margin-top: -18px;
            cursor: pointer;
        }
        #scroll_Thumb:hover {
            background-color: #ff4400;
            border: 1px solid #fff;
        }
        #progressBar {
            width: 80%;
            height: 10px;
            background-color: #ccc;
            margin: 0 auto;
            margin-top: 50px;
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
        }
        #progressBar_Track {
            width: 200px;
            height: 10px;
            background-color: #ff4400;
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
        }
        #beian {
            text-align: center;
            float: left;
            width: 100%;
            margin-top: 50px
        }
        #beian a {
            color: gray;
            font: 13px "微软雅黑", Arial, Helvetica, sans-serif;
        }

        .progressTime {
            filter: alpha(opacity=50);
            -moz-opacity: 0.5;
            -khtml-opacity: 0.5;
            opacity: 0.5;
            position: absolute;
            _position: fixed;
            left: 25%;
            top:25%;
            Z-INDEX: 2;
            border: 1px solid gray;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            color: white;
            background: #000;
            width: 660px;
            height:200px;
            padding-top: 0px;
            padding-bottom: 0px;
        }
    </style>
</head>
<body>
	<div class="container" style="background-color: #FEFEFE;">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">壳牌配件查询系统</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">

                    <div class="panel-body">
                        <img src="${ctx }/static/image/u=4157469911,3074775462&fm=21&gp=0.jpg" style="position: absolute;top: 91px;left: -286px;"  />
                        <form role="form" action="${ctx }/login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <label for="disabledSelect">用户名</label>
                                    <input class="form-control" placeholder="请输入邮箱\用户名\手机号" name="username" id="username" type="" autofocus>
                                </div>
                                <div class="form-group">
                                    <label for="disabledSelect">密码</label>
                                    <input class="form-control" placeholder="请输入密码" name="password" type="password" value="">
                                </div>
                                <div class="form-group">
                                    <label for="disabledSelect">滑动验证码</label>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <button type="button" id="yzm" class="btn btn-default btn-circle" style="position: absolute;top: 277px;left: 324px"><i class="fa fa-check" ></i>
                                    </button>


                                    <div id="Demo" style="position:absolute;top:237px;left:3px;height: 30px;width: 445px">
                                        <div id="Main">
                                            <div id="scrollBar">
                                                <div id="scroll_Track"></div>
                                                <div id="scroll_Thumb"></div>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                                <div class="checkbox">
                                    <label>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="rememberMe" value="true" />一周内免登录
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">忘记密码?</a>
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" class="btn btn-lg btn-success btn-block" value="登录" >
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>