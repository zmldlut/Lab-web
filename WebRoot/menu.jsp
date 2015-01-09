<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

        <div id="header">
        	<h1><a herf="#">创新实验学院</a></h1>
        </div>
        
        <div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li  class="btn btn-inverse dropdown" id="profile-messages" >
                	<a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle">
                	<i class="icon icon-user"></i>  
                	<span class="text">欢迎Admin</span>
                	<b class="caret"></b></a>
	                <ul class="dropdown-menu">
	                    <li><a href="#"><i class="icon-user"></i> 人员信息</a></li>
	                    <li class="divider"></li>
	                    <li><a href="#"><i class="icon-cog"></i> 密码修改</a></li>
	                    <li class="divider"></li>
	                    <li><a href="login.html"><i class="icon-check"></i> 登录信息</a></li>
	                 </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">设置</span></a></li>
                <li class="btn btn-inverse"><a title="" href="logout.action"><i class="icon icon-share-alt"></i> <span class="text">登出</span></a></li>
            </ul>
        </div>

        <!--
        <div id="search">
            <input type="text" placeholder="Search here..." />
            <button type="submit" class="tip-right" title="Search">
            	<i class="icon-search icon-white"></i>
            </button>
        </div>
        -->

        <div id="sidebar">
            <ul>
                <li class="active"><a href="admin/main.action"><i class="icon icon-home"></i> <span>首页</span></a></li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-th-list"></i> <span>用户信息管理</span> <span class="label">3</span></a>
                    <ul>
                        <li><a href="admin/studentsInfo.action">用户信息查询</a></li>
                        <li><a href="admin/studentsRegister.action">用户信息录入</a></li>
                        <li><a href="form-wizard.html">用户信息修改</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-file"></i> <span>设备管理</span> <span class="label">4</span></a>
                    <ul>
                        <li><a href="invoice.html">设备信息查询</a></li>
                        <li><a href="chat.html">设备信息录入</a></li>
                        <li><a href="calendar.html">设备信息修改</a></li>
                        <li><a href="gallery.html">设备信息统计</a></li>
                    </ul>
                </li>
                <li>
                    <a href="charts.html"><i class="icon icon-signal"></i> <span>门锁管理</span></a>
                </li>
                <li>
                    <a href="widgets.html"><i class="icon icon-inbox"></i> <span>签到管理</span></a>
                </li>
            </ul>
        </div>
