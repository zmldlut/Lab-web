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
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>智能实验室后台管理系统</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap-v2-2-1.min.css">
        <link rel="stylesheet" href="css/unicorn.main.css" />
        <link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />
        <style type="text/css">
        	.shortselect{
        		width:80px; background:none; border:none;
				display:block; overflow:hidden;
				border:#61AC36 1px solid; border-right:none; background:url(arrow.gif) #fff no-repeat 62px 1px; display:block;
		    }
        </style>
        <script language="javascript" type="text/javascript">
        	var type = -1;
        	var page = 1;
        	var maxPage = 0;
        	
        	var arr=["id", "name", "type"];
        	function addTR(cols){
        		var table = document.getElementById("info");
        		var tr = table.insertRow();
        		if(cols["is_here"] == false){
        			if(window.navigator.userAgent.toLowerCase().indexOf("firefox") != -1){
        				tr.setAttribute("class", "warning");
        				tr.setAttribute("name", "student");        				
        			}
        			else{
        				tr.setAttribute("class", "warning");
        				tr.setAttribute("name", "student");
        			}
        		}
        		else{
        			if(window.navigator.userAgent.toLowerCase().indexOf("firefox") != -1){
        				tr.setAttribute("class", "success");
        				tr.setAttribute("name", "student");
        			}
        			else{
        				tr.setAttribute("class", "success");
        				tr.setAttribute("name", "student");
        			}
        		}
        		var checkNum = 0;
        		for(var i = 0; i <= arr.length; i++){
        			var td = tr.insertCell(i);
        			if(i == 0){
        				td.setAttribute("text-align", "center");
        				var newInput = document.createElement("input"); 
        				newInput.type = "checkbox";
        				newInput.name = "delete";
        				newInput.value = cols["id"];
        				newInput.onchange = function (){
        					if(this.checked){
        						checkNum ++;
        					}
        					else {
        						checkNum --;
        					}
        					if(checkNum > 0) document.getElementById("deleteDev").setAttribute("class", "btn btn-success");
        					else document.getElementById("deleteDev").setAttribute("class", "btn btn-danger");
        				}
        				td.appendChild(newInput);
        			}
        			else{
	        			td.setAttribute("text-align", "center");
	        			td.value = cols["id"];
	        			td.onclick = function (){
	        				window.location.href="device/device_update.action?device.id=" + this.value;
	        			}
	        			if(window.navigator.userAgent.toLowerCase().indexOf("firefox")!=-1){
	        				td.textContent = cols[arr[i-1]];
	        			}
	        			else{
	        				td.innerText = cols[arr[i-1]];
	        			}
        			}
        		}
        	}
        	
        	function deleteDevAjax(id){
        		var params = {
        			"device.id" : id
        		};
    			$.ajax({
    				type : "post",
    				url : "device_json/device_json_delDevice.action",
    				data : params,
    				dataType : "text",
    				success : function(json){
    					setInfo();
    				},
    				error : function(json){
    					alert("error " + json);
    				}
    			});
        	}
        	
        	function deleteDev(){
        		var objName= document.getElementsByName("delete");
        		for(var i = 0; i < objName.length; i++){
        			var obj = objName[i];
        			if(obj.checked){
        				deleteDevAjax(obj.value);
        			}
        		}
        		
        		checkNum = 0;
        	}
        	
        	function delTR(){
        		var table = document.getElementById("info");
        		while(table.getElementsByTagName("tr").length > 0){
        			table.removeChild(table.getElementsByTagName("tr")[0]);
        		}
        	}
        	
        	function prePage(){
        		if(page == 1){
        			return ;
        		}
        		page = page - 1;
        		setInfo();
        	}
        	
        	function nxtPage(){
        		if(page == maxPage){
        			return ;
        		}
        		page = page + 1;
        		setInfo();
        	}
        	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        	
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
            
            function choice(){
            	var obj=document.getElementById("pageNum");
            	var index = obj.selectedIndex;
            	var val = obj.options[index].value;
            	page = parseInt(val);
            	setInfo();
            }
            
            function deviceTypeSearch(){
            	var obj=document.getElementById("deviceTypeSearch");
            	var index = obj.selectedIndex;
            	var val = obj.options[index].value;
            	type = val;
            	setInfo();
            }
        	
        	function setInfo(){
        		delTR();
        		var params = {
    				"page" : page,
    				"pageCount" : 20,
    				"device.type" : type,
    				"device.status" : 0
    			};
   				$.ajax({
   					type : "post",
   					url : "device_json/device_json_getDevices.action",
   					data : params,
   					dataType : "text",
   					success : function(json){
   						var obj = $.parseJSON(json);
   						maxPage = obj.maxPage;
   						removeAllSOP("pageNum");
   						for(var i = 1; i <= maxPage; i++){
   							addSOP("pageNum", "第 " + i + " 页", i);
   						}
   						selectSOP("pageNum", page);
   						for(var i = 0; i < obj.result.length; i++){
   							addTR(obj.result[i]);
   						}
   						if(page == 1){
   							document.getElementById("prePage").setAttribute("class", "btn btn-danger");
   						}
   						else{
   							document.getElementById("prePage").setAttribute("class", "btn btn-success");
   						}
   						if(page == maxPage){
   							document.getElementById("nxtPage").setAttribute("class", "btn btn-danger");
   						}
   						else{
   							document.getElementById("nxtPage").setAttribute("class", "btn btn-success");
   						}
   					},
   					error : function(json){
   						alert("error " + json);
   					}
   				});
        	}
        	
        	function setDeviceType(){
        		removeAllSOP("deviceTypeSearch");
        		addSOP("deviceTypeSearch", "== 选择类型 ==", "null");
				addSOP("deviceTypeSearch", "DELL", "DELL");
				addSOP("deviceTypeSearch", "PAD", "PAD");
				addSOP("deviceTypeSearch", "MAC", "MAC");
				selectSOP("deviceTypeSearch", "null");
        	}
        	
        	window.onload = function () {
        		setDeviceType();
        		setInfo();
			}
		</script>
    </head>
    <body>
    <jsp:include page="menu.jsp" />
    <div id="content" style="min-height: 1000px">
            <div id="content-header">
                <h1>设备信息</h1>
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
                        	<select id="deviceTypeSearch" class="form-control" style="width: 12%;height: 80%;margin-top: 0.25%;" class="select" onchange="deviceTypeSearch()">
                        	</select>
                        	<div class="buttons">
                        		<a href="#" class="btn btn-mini"><i class="icon-refresh"></i> Update data</a>
                        	</div>
                        </div>
                        <div class="span11"> </div>
	                    <div class="span8">
                            <table class="table">
                            	<thead>
		                            <tr>
		                            	<th></th>
					                    <th>ID</th>  
					                    <th>设备名称</th>
					                    <th>设备类型</th>
					                </tr>  
				                </thead>
				                <tbody id="info">
				                </tbody>
                            </table>
                            <div style="float:left" class="form-inline">
	                            <button type="button" class="btn btn-danger" onclick="deleteDev()" id="deleteDev">删除</button>
                            </div>
                            <div style="float:right" class="form-inline">
	                            <button type="button" class="btn btn-success" onclick="prePage()" id="prePage">上一页</button>
	                            <select id="pageNum" onchange="choice()" class="shortselect"></select>
	                            <button type="button" class="btn btn-success" onclick="nxtPage()" id="nxtPage">下一页</button>
                            </div>
                            
	                    </div>
                    </div>                  
                </div>
            </div>

            <div class="row-fluid">
                <div id="footer" class="span12">
                    2014 &copy; Dlut Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a>
                </div>
            </div>
        </div>
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
</html>