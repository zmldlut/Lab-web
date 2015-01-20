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
    
		function checkStudentNumber(studentNumber){
			if(!(/^[0-9]{8,9}$/.test(studentNumber))){
				var obj = document.getElementById("inputStudentNumber");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputStudentNumber");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkCardID(cardID){
			if(!(/^[0-9|A-Z]{8}$/.test(cardID))){
				var obj = document.getElementById("inputCardID");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputCardID");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkName(name){
			if(!(/^[\u4e00-\u9fa5]{1,10}$/.test(name))){
				var obj = document.getElementById("inputName");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputName");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkMajor(){
			if(choice("major") == 0){
				var obj = document.getElementById("inputMajor");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputMajor");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkGrade(){
			if(choice("grade") == 0){
				var obj = document.getElementById("inputGrade");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputGrade");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkPhone(phone){
			if(!(/^[0-9]{11,13}$/.test(phone))){
				var obj = document.getElementById("inputPhone");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputPhone");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkEmail(email){
			if(!(/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(email))){
				var obj = document.getElementById("inputEmail");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputEmail");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkQQ(qq){
			if(!(/^[0-9]{6,11}$/.test(qq))){
				var obj = document.getElementById("inputQQ");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputQQ");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkPassword(password){
			if(!(/^[\w]{6,100}$/.test(password))){
				var obj = document.getElementById("inputPassword");
				obj.setAttribute("class", "form-group has-error");
				obj = document.getElementById("inputRepeatedPassword");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputPassword");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkRepeatedPassword(repeatedPassword){
			if(!(document.getElementById("password").value == repeatedPassword)){
				var obj = document.getElementById("inputRepeatedPassword");
				obj.setAttribute("class", "form-group has-error");
				return false;
			}
			var obj = document.getElementById("inputRepeatedPassword");
			obj.setAttribute("class", "form-group has-success");
			return true;
		}
		
		function checkForm(){
			var result = true;
			if(checkStudentNumber(document.getElementById("studentNumber").value) == false){
				result = false;
			}
			if(checkCardID(document.getElementById("cardID").value) == false){
				result = false;
			}
			if(checkName(document.getElementById("name").value) == false){
				result = false;
			}
			if(checkMajor() == false){
				result = false;
			}
			if(checkGrade() == false){
				result = false;
			}
			if(checkPhone(document.getElementById("phone").value) == false){
				result = false;
			}
			if(checkEmail(document.getElementById("email").value) == false){
				result = false;
			}
			if(checkQQ(document.getElementById("qq").value) == false){
				result = false;
			}
			if(checkRepeatedPassword(document.getElementById("repeatedPassword").value) == false){
				result = false;
			}
			if(checkPassword(document.getElementById("password").value) == false){
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
        
		function setMajor(){
			var params = {};
			$.ajax({
				type : "post",
				url : "user_json/getMajorsInfoAction.action",
				data : params,
				dataType : "text",
				success : function(json){
					var obj = $.parseJSON(json);
					addSOP("major", "== 请选择专业 ==", 0);
					for(var i = 0; i < obj.result.length; i++){
						addSOP("major", obj.result[i].major_name, obj.result[i].id);
					}
					selectSOP("major", 0);
				},
				error : function(json){
					alert("error " + json);
				}
			});
		}
		
		function setGrade(){
			var params = {};
			$.ajax({
				type : "post",
				url : "user_json/getGradesInfoAction.action",
				data : params,
				dataType : "text",
				success : function(json){
					var obj = $.parseJSON(json);
					addSOP("grade", "== 请选择年级 ==", 0);
					for(var i = 0; i < obj.result.length; i++){
						addSOP("grade", obj.result[i].grade_name, obj.result[i].id);
					}
					selectSOP("grade", 0);
				},
				error : function(json){
					alert("error " + json);
				}
			});
		}
		
		function sendStudentInfo(){
			var params = {
				"studentInfo.stdnum" : document.getElementById("studentNumber").value,
				"studentInfo.cardID" : document.getElementById("cardID").value,
				"studentInfo.name" : document.getElementById("name").value,
				"studentInfo.password" : document.getElementById("password").value,
				"studentInfo.major_id" : choice("major"),
				"studentInfo.grade_id" : choice("grade"),
				"studentInfo.phone" : document.getElementById("phone").value,
				"studentInfo.email" : document.getElementById("email").value,
				"studentInfo.QQ" : document.getElementById("qq").value
			};
			$.ajax({
				type : "post",
				url : "user_json/user_json_checkStudentRegisterInfoAction.action",
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
			setMajor();
			setGrade();
		}
	</script>
</head>
	<body>
	    <jsp:include page="menu.jsp" />
	    <div id="content" style="min-height: 1000px">
            <div id="content-header">
                <h1>信息录入</h1>
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
		                    		<div class="form-group" id="inputStudentNumber">
										<label class="col-sm-2 control-label" for="studentNumber" > <big>学&nbsp;&nbsp;号</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="studentNumber" type="text" 
									    		placeholder="你的真实学号" oninput="checkStudentNumber(this.value)">
									    </div>
									</div>
									<div class="form-group" id="inputCardID">
										<label class="col-sm-2 control-label" for="cardID" > <big>卡&nbsp;&nbsp;号</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="cardID" type="text" 
									    		placeholder="你的真实卡号" oninput="checkCardID(this.value)">
									    </div>
									</div>
									<div class="form-group" id="inputName">
										<label class="col-sm-2 control-label" for="name" > <big>姓&nbsp;&nbsp;名</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="name" type="text" 
									    		placeholder="输入真实姓名" oninput="checkName(this.value)">
									    </div>
									</div>
									
									<div class="form-group" id="inputMajor">
										<label class="col-sm-2 control-label" for="major" > <big>专&nbsp;&nbsp;业</big></label>
										<div class="col-sm-3">
										    <select id="major" class="form-control" style="width:80%;" onchange="checkMajor()">
										    </select>
										</div>
									</div>
									
									<div class="form-group" id="inputGrade">
										<label class="col-sm-2 control-label" for="grade" > <big>年&nbsp;&nbsp;级</big></label>
										<div class="col-sm-3">
										    <select id="grade" class="form-control" style="width:80%;" onchange="checkGrade()">
										    </select>
										</div>
									</div>
									
									<div class="form-group" id="inputPhone">
										<label class="col-sm-2 control-label" for="phone" > <big>电&nbsp;&nbsp;话</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="phone" type="text" 
									    		placeholder="输入联系电话" oninput="checkPhone(this.value)">
									    </div>
									</div>
									
									<div class="form-group" id="inputEmail">
										<label class="col-sm-2 control-label" for="email" > <big>邮&nbsp;&nbsp;箱</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="email" type="text" 
									    		placeholder="输入常用邮箱" oninput="checkEmail(this.value)">
									    </div>
									</div>
									
									<div class="form-group" id="inputQQ">
										<label class="col-sm-2 control-label" for="qq" > <big>QQ&nbsp;&nbsp;</big></label>
										<div class="col-sm-3">
									    	<input type="text" class="form-control" id="qq" type="text" 
									    		placeholder="输入常用QQ" oninput="checkQQ(this.value)">
									    </div>
									</div>
									
									<div class="form-group" id="inputPassword">
										<label class="col-sm-2 control-label" for="password" > <big>密&nbsp;&nbsp;码</big></label>
										<div class="col-sm-3">
									    	<input type="password" class="form-control" id="password" type="text" 
									    		placeholder="最少6位" oninput="checkPassword(this.value)">
									    </div>
									</div>
									
									<div class="form-group" id="inputRepeatedPassword">
										<label class="col-sm-2 control-label" for="repeatedPassword" > <big>确认密码</big></label>
										<div class="col-sm-3">
									    	<input type="password" class="form-control" id="repeatedPassword" type="text" 
									    		placeholder="最少6位" oninput="checkRepeatedPassword(this.value)">
									    </div>
									</div>
									<div class="form-group" id="output">
			                            <div class="col-sm-2"></div>
			                            <div class="col-sm-3">
			                                <input type="button" class="btn btn-success" onclick="checkForm()" value="添加新用户">
			                                	
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
