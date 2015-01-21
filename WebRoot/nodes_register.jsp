<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<% 
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://"
        + request.getServerName() + ":" + request.getServerPort()
        + path;
%>
<base href="<%=basePath%>">
<!-- saved from url=(0021)https://worktile.com/ -->
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>智能实验室后台管理系统</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/unicorn.main.css" />
    <link rel="stylesheet" href="css/bootstrap-v2-2-1.min.css">
    <link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
    <script language="javascript" type="text/javascript">
    
    	function checkType(){
    		if(choice("type") == -1){
				var obj = document.getElementById("inputType");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputType");
			obj.setAttribute("class", "form-group has-success");
			return true;
    	}
    
		function checkForm(){
			var result = true;
			if(checkType() == false){
				result = false;
			}
			if(result){
				sendStudentInfo();
			}
			return result;
		}
		
		function addSOP(id, text, value){
    		var obj = document.getElementById(id);
    		obj.options.add(new Option(text, value));
    	}
    	
        function removeAllSOP(id){
            var obj=document.getElementById(id);
            obj.options.length=0;
        }
        
        function selectSOP(id, index){
        	 var obj=document.getElementById(id);
        	 obj.value = index;
        }
        
        function choice(id){
        	var obj=document.getElementById(id);
        	var index = obj.selectedIndex;
        	var val = obj.options[index].value;
        	return parseInt(val);
        }
		
		function setType(){
			var params = {};
			$.ajax({
				type : "post",
				url : "node_json/node_type_json_getNodeTypes.action",
				data : params,
				dataType : "text",
				success : function(json){
					var obj = $.parseJSON(json);
					addSOP("type", "== 选择结点类型 ==", -1);
					for(var i = 0; i < obj.result.length; i++){
						addSOP("type", obj.result[i].type, obj.result[i].id);
					}
					selectSOP("type", -1);
				},
				error : function(json){
					alert("error " + json);
				}
			});
		}
		
		function sendStudentInfo(){
			var params = {
				"node.name" : document.getElementById("name").value,
				"node.description" : document.getElementById("description").value,
				"node.location" : document.getElementById("location").value,
				"node.status" : 1,
				"node.type" : choice("type")
			};
			$.ajax({
				type : "post",
				url : "node_json/node_json_addNode.action",
				data : params,
				dataType : "text",
				success : function(json){
					var obj = $.parseJSON(json);
					if(obj.result == "true"){
						window.location.href="user/user_success";
					}
				},
				error : function(json){
					alert("error " + json);
				}
			});
		}
		window.onload = function () {
			setType();
		}
	</script>
</head>
	<body>
	    <jsp:include page="menu.jsp" />
	    <div id="content" style="min-height: 1000px">
            <div id="content-header">
                <h1>结点录入</h1>
                <div class="btn-group">
                    <a class="btn btn-large tip-bottom" title="Manage Files">
                    	<i class="icon-file"></i>
                    	<span class="label label-important">1</span>
                    </a>
                    <a class="btn btn-large tip-bottom" title="Manage Users">
                    	<i class="icon-user"></i>
                    	<span class="label label-important">2</span>
                    </a>
                    <a class="btn btn-large tip-bottom" title="Manage Comments">
                    	<i class="icon-comment"></i>
                    	<span class="label label-important">5</span>
                    </a>
                    <a class="btn btn-large tip-bottom" title="Manage Orders">
                    	<i class="icon-shopping-cart"></i>
                    	<span class="label label-important">1</span>
                    </a>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span11">
                    <div class="alert alert-info">
                        Welcome in the <strong>Dalian University of Technology</strong>. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Happy New Year!
                        <a href="#" data-dismiss="alert" class="close">×</a>
                    </div>
                    <div class="widget-box">
                        <div class="widget-title">
                        	<span class="icon"><i class="icon-signal"></i></span>
                        	<h5>Site Statistics</h5>
                        	<div class="buttons">
                        		<a href="#" class="btn btn-mini"><i class="icon-refresh"></i> Update data</a>
                        	</div>
                        </div>
                        <div class="span12"></div>
	                    <div class="span12">
		                    <div class="span8">
		                    	<form class="form-horizontal" role="form" >
		                    		<div class="form-group" id="inputName">
										<label class="col-sm-2 control-label" for="name" > <big>名&nbsp;&nbsp;称</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="name" type="text" 
									    		placeholder="输入结点名称" >
									    </div>
									</div>
									
									<div class="form-group" id="inputLocation">
										<label class="col-sm-2 control-label" for="location" > <big>位&nbsp;&nbsp;置</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="location" type="text" 
									    		placeholder="输入结点位置" >
									    </div>
									</div>
									
									<div class="form-group" id="inputType">
										<label class="col-sm-2 control-label" for="type" > <big>类&nbsp;&nbsp;型</big></label>
										<div class="col-sm-3">
										    <select id="type" class="form-control" style="width:80%;">
										    </select>
										</div>
									</div>
									<div class="form-group" id="inputDescription">
										<label class="col-sm-2 control-label" for="description" > <big>描&nbsp;&nbsp;述</big></label>
										<div class="col-sm-3">
											<textarea class="form-control" rows="3" id="description" placeholder="结点描述" ></textarea>
									    </div>
									</div>
							
									<div class="form-group" id="output">
			                            <div class="col-sm-2"></div>
			                            <div class="col-sm-3">
			                                <input type="button" class="btn btn-success" onclick="checkForm()" value="添加新结点">
			                                </input>
			                            </div>
			                        </div>
								</form>
							</div>
		                </div>
		                <div class="span12"></div>
                    </div>                  
                </div>
            </div>

            <div class="row-fluid">
                <div id="footer" class="span12">
                    2014 &copy; Dlut Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a>
                </div>
            </div>
        </div>
        <s:debug></s:debug>
        <script src="js/excanvas.min.js"></script>
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.ui.custom.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.flot.min.js"></script>
		<script src="js/jquery.flot.resize.min.js"></script>
		<script src="js/jquery.peity.min.js"></script>
		<script src="js/fullcalendar.min.js"></script>
		<script src="js/unicorn.js"></script>
		<script src="js/unicorn.dashboard.js"></script>
		<script src="js/raphael.js"></script>
	</body>
    
</div>
</div></div>

</body>
</html>
