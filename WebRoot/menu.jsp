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
                <li class="active"><a href="admin/admin.action"><i class="icon icon-home"></i> <span>首页</span></a></li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-th-list"></i> <span>用户信息管理</span> <span class="label">2</span></a>
                    <ul>
                        <li><a href="user/user_info.action">用户信息查询</a></li>
                        <li><a href="user/user_register.action">用户信息录入</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-th-list"></i> <span>结点管理</span> <span class="label">2</span></a>
                    <ul>
                        <li><a href="node/node_info.action">结点信息查询</a></li>
                        <li><a href="node/node_register.action">结点信息录入</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-file"></i> <span>设备管理</span> <span class="label">2</span></a>
                    <ul>
                        <li><a href="device/device_info.action">设备信息查询</a></li>
                        <li><a href="device/device_register.action">设备信息录入</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-file"></i> <span>环境管理</span> <span class="label">4</span></a>
                    <ul>
                        <li><a href="sensor/temperatureInfo.action">温度管理</a></li>
                        <li><a href="sensor/humidityInfo.action">湿度管理</a></li>
                        <li><a href="sensor/pmInfo.action">PM2.5值管理</a></li>
                        <li><a href="sensor/lightInfo.action">光强管理</a></li>
                    </ul>
                </li>
                <li class="submenu">
                    <a href="#"><i class="icon icon-signal"></i> <span>控制管理</span> <span class="label">4</span></a>
                    <ul>
                        <li><a href="controller/door_doorInfo.action">门锁管理</a></li>
                        <li><a href="controller/curtain_curtainInfo.action">窗帘管理</a></li>
                        <li><a href="controller/lamp_lampInfo.action">灯光管理</a></li>
                        <li><a href="controller/controller_center.action">控制中心</a></li>
                    </ul>
                </li>
                <li>
                    <a href="sign/sign_signInfo"><i class="icon icon-inbox"></i> <span>签到管理</span></a>
                </li>
                
            </ul>
        </div>
