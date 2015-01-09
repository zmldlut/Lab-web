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
       	<style type="text/css" media="screen">
            body {
			    background: #333;
			    color: #fff;
			    font: 300 100.1% "Helvetica Neue", Helvetica, "Arial Unicode MS", Arial, sans-serif;
			}
			#holder {
			    height: 480px;
			    left: 50%;
			    margin: -240px 0 0 -320px;
			    position: absolute;
			    top: 50%;
			    width: 640px;
			}
			#copy {
			    bottom: 0;
			    font: 300 .7em "Helvetica Neue", Helvetica, "Arial Unicode MS", Arial, sans-serif;
			    position: absolute;
			    right: 1em;
			    text-align: right;
			}
			#copy a {
			    color: #fff;
			}
        </style>
        <style type="text/css" media="print">
            body {
			    background: #fff;
			    color: #000;
			    font: 100.1% "Lucida Grande", Lucida, Verdana, sans-serif;
			}
			#holder {
			    height: 480px;
			    left: 50%;
			    margin: 0 0 0 -320px;
			    position: absolute;
			    top: 0;
			    width: 640px;
			}
			#copy {
			    bottom: 0;
			    font-size: .7em;
			    position: absolute;
			    right: 1em;
			    text-align: right;
			}
        </style>
        <style type="text/css" media="screen">
            #holder {
                height: 250px;
                margin: -125px 0 0 -400px;
                width: 800px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
        <div id="content">
            <div id="content-header">
                <h1>首页</h1>
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
                        <div class="widget-content">
                            <div class="row-fluid">
	                            <div class="span4">
	                                <ul class="site-stats">
	                                	<li class="divider"></li>
	                                    <li><i class="icon-user"></i> <small>30</small> <small>Total Students</small></li>
	                                    <li class="divider"></li>
	                                    <li><i class="icon-arrow-right"></i> <small>16</small> <small>Sign Students (Today)</small></li>
	                                    <li class="divider"></li>
	                                    <li><i class="icon-tag"></i> <small>200</small> <small>Sign Students (last Week)</small></li>
	                                    <li class="divider"></li>
	                                    <li><i class="icon-repeat"></i> <small>29</small> <small>On Computers (now)</small></li>
	                                    <li class="divider"></li>
	                                </ul>
	                            </div>
	                            <div class="span6">
                               		<table id="data">
                                		<tfoot>
							                <tr>
							                    <th>1</th>
							                    <th>2</th>
							                    <th>3</th>
							                    <th>4</th>
							                    <th>5</th>
							                    <th>6</th>
							                    <th>7</th>
							                    <th>8</th>
							                    <th>9</th>
							                    <th>10</th>
							                    <th>11</th>
							                    <th>12</th>
							                    <th>13</th>
							                    <th>14</th>
							                    <th>15</th>
							                    <th>16</th>
							                    <th>17</th>
							                    <th>18</th>
							                    <th>19</th>
							                    <th>19</th>
							                    <th>20</th>
							                    <th>22</th>
							                    <th>23</th>
							                    <th>24</th>
							                    <th>25</th>
							                    <th>26</th>
							                    <th>27</th>
							                    <th>28</th>
							                    <th>29</th>
							                    <th>30</th>
							                    <th>31</th>
							                </tr>
							            </tfoot>
							            <tbody>
							                <tr>
							                    <td>8</td>
							                    <td>25</td>
							                    <td>27</td>
							                    <td>25</td>
							                    <td>54</td>
							                    <td>59</td>
							                    <td>79</td>
							                    <td>47</td>
							                    <td>27</td>
							                    <td>44</td>
							                    <td>44</td>
							                    <td>51</td>
							                    <td>56</td>
							                    <td>83</td>
							                    <td>12</td>
							                    <td>91</td>
							                    <td>52</td>
							                    <td>12</td>
							                    <td>40</td>
							                    <td>8</td>
							                    <td>60</td>
							                    <td>29</td>
							                    <td>7</td>
							                    <td>33</td>
							                    <td>56</td>
							                    <td>25</td>
							                    <td>1</td>
							                    <td>78</td>
							                    <td>70</td>
							                    <td>68</td>
							                    <td>2</td>
							                </tr>
							            </tbody>
							         </table>
	                                <div id="holder"></div>
	                            </div>  
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
		<script>
		    (function () {
		    	var tokenRegex = /\{([^\}]+)\}/g,
		    	    objNotationRegex = /(?:(?:^|\.)(.+?)(?=\[|\.|$|\()|\[('|")(.+?)\2\])(\(\))?/g, // matches .xxxxx or ["xxxxx"] to run over object properties
		    	    replacer = function (all, key, obj) {
		    	        var res = obj;
		    	        key.replace(objNotationRegex, function (all, name, quote, quotedName, isFunc) {
		    	            name = name || quotedName;
		    	            if (res) {
		    	                if (name in res) {
		    	                    res = res[name];
		    	                }
		    	                typeof res == "function" && isFunc && (res = res());
		    	            }
		    	        });
		    	        res = (res == null || res == obj ? all : res) + "";
		    	        return res;
		    	    },
		    	    fill = function (str, obj) {
		    	        return String(str).replace(tokenRegex, function (all, key) {
		    	            return replacer(all, key, obj);
		    	        });
		    	    };
		    	    Raphael.fn.popup = function (X, Y, set, pos, ret) {
		    	        pos = String(pos || "top-middle").split("-");
		    	        pos[1] = pos[1] || "middle";
		    	        var r = 5,
		    	            bb = set.getBBox(),
		    	            w = Math.round(bb.width),
		    	            h = Math.round(bb.height),
		    	            x = Math.round(bb.x) - r,
		    	            y = Math.round(bb.y) - r,
		    	            gap = Math.min(h / 2, w / 2, 10),
		    	            shapes = {
		    	                top: "M{x},{y}h{w4},{w4},{w4},{w4}a{r},{r},0,0,1,{r},{r}v{h4},{h4},{h4},{h4}a{r},{r},0,0,1,-{r},{r}l-{right},0-{gap},{gap}-{gap}-{gap}-{left},0a{r},{r},0,0,1-{r}-{r}v-{h4}-{h4}-{h4}-{h4}a{r},{r},0,0,1,{r}-{r}z",
		    	                bottom: "M{x},{y}l{left},0,{gap}-{gap},{gap},{gap},{right},0a{r},{r},0,0,1,{r},{r}v{h4},{h4},{h4},{h4}a{r},{r},0,0,1,-{r},{r}h-{w4}-{w4}-{w4}-{w4}a{r},{r},0,0,1-{r}-{r}v-{h4}-{h4}-{h4}-{h4}a{r},{r},0,0,1,{r}-{r}z",
		    	                right: "M{x},{y}h{w4},{w4},{w4},{w4}a{r},{r},0,0,1,{r},{r}v{h4},{h4},{h4},{h4}a{r},{r},0,0,1,-{r},{r}h-{w4}-{w4}-{w4}-{w4}a{r},{r},0,0,1-{r}-{r}l0-{bottom}-{gap}-{gap},{gap}-{gap},0-{top}a{r},{r},0,0,1,{r}-{r}z",
		    	                left: "M{x},{y}h{w4},{w4},{w4},{w4}a{r},{r},0,0,1,{r},{r}l0,{top},{gap},{gap}-{gap},{gap},0,{bottom}a{r},{r},0,0,1,-{r},{r}h-{w4}-{w4}-{w4}-{w4}a{r},{r},0,0,1-{r}-{r}v-{h4}-{h4}-{h4}-{h4}a{r},{r},0,0,1,{r}-{r}z"
		    	            },
		    	            offset = {
		    	                hx0: X - (x + r + w - gap * 2),
		    	                hx1: X - (x + r + w / 2 - gap),
		    	                hx2: X - (x + r + gap),
		    	                vhy: Y - (y + r + h + r + gap),
		    	                "^hy": Y - (y - gap)
		    	                
		    	            },
		    	            mask = [{
		    	                x: x + r,
		    	                y: y,
		    	                w: w,
		    	                w4: w / 4,
		    	                h4: h / 4,
		    	                right: 0,
		    	                left: w - gap * 2,
		    	                bottom: 0,
		    	                top: h - gap * 2,
		    	                r: r,
		    	                h: h,
		    	                gap: gap
		    	            }, {
		    	                x: x + r,
		    	                y: y,
		    	                w: w,
		    	                w4: w / 4,
		    	                h4: h / 4,
		    	                left: w / 2 - gap,
		    	                right: w / 2 - gap,
		    	                top: h / 2 - gap,
		    	                bottom: h / 2 - gap,
		    	                r: r,
		    	                h: h,
		    	                gap: gap
		    	            }, {
		    	                x: x + r,
		    	                y: y,
		    	                w: w,
		    	                w4: w / 4,
		    	                h4: h / 4,
		    	                left: 0,
		    	                right: w - gap * 2,
		    	                top: 0,
		    	                bottom: h - gap * 2,
		    	                r: r,
		    	                h: h,
		    	                gap: gap
		    	            }][pos[1] == "middle" ? 1 : (pos[1] == "top" || pos[1] == "left") * 2];
		    	            var dx = 0,
		    	                dy = 0,
		    	                out = this.path(fill(shapes[pos[0]], mask)).insertBefore(set);
		    	            switch (pos[0]) {
		    	                case "top":
		    	                    dx = X - (x + r + mask.left + gap);
		    	                    dy = Y - (y + r + h + r + gap);
		    	                break;
		    	                case "bottom":
		    	                    dx = X - (x + r + mask.left + gap);
		    	                    dy = Y - (y - gap);
		    	                break;
		    	                case "left":
		    	                    dx = X - (x + r + w + r + gap);
		    	                    dy = Y - (y + r + mask.top + gap);
		    	                break;
		    	                case "right":
		    	                    dx = X - (x - gap);
		    	                    dy = Y - (y + r + mask.top + gap);
		    	                break;
		    	            }
		    	            out.translate(dx, dy);
		    	            if (ret) {
		    	                ret = out.attr("path");
		    	                out.remove();
		    	                return {
		    	                    path: ret,
		    	                    dx: dx,
		    	                    dy: dy
		    	                };
		    	            }
		    	            set.translate(dx, dy);
		    	            return out;
		    	    };
		    	})();
		    </script>
		    <script type="text/javascript">
		    Raphael.fn.drawGrid = function (x, y, w, h, wv, hv, color) {
		        color = color || "#000";
		        var path = ["M", Math.round(x) + .5, Math.round(y) + .5, "L", Math.round(x + w) + .5, Math.round(y) + .5, Math.round(x + w) + .5, Math.round(y + h) + .5, Math.round(x) + .5, Math.round(y + h) + .5, Math.round(x) + .5, Math.round(y) + .5],
		            rowHeight = h / hv,
		            columnWidth = w / wv;
		        for (var i = 1; i < hv; i++) {
		            path = path.concat(["M", Math.round(x) + .5, Math.round(y + i * rowHeight) + .5, "H", Math.round(x + w) + .5]);
		        }
		        for (i = 1; i < wv; i++) {
		            path = path.concat(["M", Math.round(x + i * columnWidth) + .5, Math.round(y) + .5, "V", Math.round(y + h) + .5]);
		        }
		        return this.path(path.join(",")).attr({stroke: color});
		    };
		
		    $(function () {
		        $("#data").css({
		            position: "absolute",
		            left: "-9999em",
		            top: "-9999em"
		        });
		    });
		
		    window.onload = function () {
		        function getAnchors(p1x, p1y, p2x, p2y, p3x, p3y) {
		            var l1 = (p2x - p1x) / 2,
		                l2 = (p3x - p2x) / 2,
		                a = Math.atan((p2x - p1x) / Math.abs(p2y - p1y)),
		                b = Math.atan((p3x - p2x) / Math.abs(p2y - p3y));
		            a = p1y < p2y ? Math.PI - a : a;
		            b = p3y < p2y ? Math.PI - b : b;
		            var alpha = Math.PI / 2 - ((a + b) % (Math.PI * 2)) / 2,
		                dx1 = l1 * Math.sin(alpha + a),
		                dy1 = l1 * Math.cos(alpha + a),
		                dx2 = l2 * Math.sin(alpha + b),
		                dy2 = l2 * Math.cos(alpha + b);
		            return {
		                x1: p2x - dx1,
		                y1: p2y + dy1,
		                x2: p2x + dx2,
		                y2: p2y + dy2
		            };
		        }
		        // Grab the data
		        var labels = [],
		            data = [];
		        $("#data tfoot th").each(function () {
		            labels.push($(this).html());
		        });
		        $("#data tbody td").each(function () {
		            data.push($(this).html());
		        });
		        
		        // Draw
		        var width = 1200,
		            height = 400,
		            leftgutter = 250,
		            bottomgutter = 20,
		            topgutter = 170,
		            colorhue = .6 || Math.random(),
		            color = "hsl(" + [colorhue, .5, .5] + ")",
		            r = Raphael("holder", width, height),
		            txt = {font: '12px Helvetica, Arial', fill: "#f00"},
		            txt1 = {font: '10px Helvetica, Arial', fill: "#00f"},
		            txt2 = {font: '12px Helvetica, Arial', fill: "#0f0"},
		            X = (width - leftgutter) / labels.length,
		            max = Math.max.apply(Math, data),
		            Y = (height - bottomgutter - topgutter) / max;
		        r.drawGrid(leftgutter + X * .5 + .5, topgutter + .5, width - leftgutter - X, height - topgutter - bottomgutter, 10, 10, "#f0f");
		        var path = r.path().attr({stroke: color, "stroke-width": 4, "stroke-linejoin": "round"}),
		            bgp = r.path().attr({stroke: "none", opacity: .3, fill: color}),
		            label = r.set(),
		            lx = 0, ly = 0,
		            is_label_visible = false,
		            leave_timer,
		            blanket = r.set();
		        label.push(r.text(60, 12, "24 persons").attr(txt));
		        label.push(r.text(60, 27, "22 12 2014").attr(txt1).attr({fill: color}));
		        label.hide();
		        var frame = r.popup(100, 100, label, "right").attr({fill: "#000", stroke: "#666", "stroke-width": 2, "fill-opacity": .7}).hide();
		
		        var p, bgpp;
		        for (var i = 0, ii = labels.length; i < ii; i++) {
		            var y = Math.round(height - bottomgutter - Y * data[i]),
		                x = Math.round(leftgutter + X * (i + .5)),
		                t = r.text(x, height - 6, labels[i]).attr(txt).toBack();
		            if (!i) {
		                p = ["M", x, y, "C", x, y];
		                bgpp = ["M", leftgutter + X * .5, height - bottomgutter, "L", x, y, "C", x, y];
		            }
		            if (i && i < ii - 1) {
		                var Y0 = Math.round(height - bottomgutter - Y * data[i - 1]),
		                    X0 = Math.round(leftgutter + X * (i - .5)),
		                    Y2 = Math.round(height - bottomgutter - Y * data[i + 1]),
		                    X2 = Math.round(leftgutter + X * (i + 1.5));
		                var a = getAnchors(X0, Y0, x, y, X2, Y2);
		                p = p.concat([a.x1, a.y1, x, y, a.x2, a.y2]);
		                bgpp = bgpp.concat([a.x1, a.y1, x, y, a.x2, a.y2]);
		            }
		            var dot = r.circle(x, y, 4).attr({fill: "#333", stroke: color, "stroke-width": 2});
		            blanket.push(r.rect(leftgutter + X * i, 0, X, height - bottomgutter).attr({stroke: "none", fill: "#fff", opacity: 0}));
		            var rect = blanket[blanket.length - 1];
		            (function (x, y, data, lbl, dot) {
		                var timer, i = 0;
		                rect.hover(function () {
		                    clearTimeout(leave_timer);
		                    var side = "right";
		                    if (x + frame.getBBox().width > width) {
		                        side = "left";
		                    }
		                    var ppp = r.popup(x, y, label, side, 1),
		                        anim = Raphael.animation({
		                            path: ppp.path,
		                            transform: ["t", ppp.dx, ppp.dy]
		                        }, 200 * is_label_visible);
		                    lx = label[0].transform()[0][1] + ppp.dx;
		                    ly = label[0].transform()[0][2] + ppp.dy;
		                    frame.show().stop().animate(anim);
		                    label[0].attr({text: data + " person" + (data == 1 ? "" : "s")}).show().stop().animateWith(frame, anim, {transform: ["t", lx, ly]}, 200 * is_label_visible);
		                    label[1].attr({text: lbl + " 12 2014"}).show().stop().animateWith(frame, anim, {transform: ["t", lx, ly]}, 200 * is_label_visible);
		                    dot.attr("r", 6);
		                    is_label_visible = true;
		                }, function () {
		                    dot.attr("r", 4);
		                    leave_timer = setTimeout(function () {
		                        frame.hide();
		                        label[0].hide();
		                        label[1].hide();
		                        is_label_visible = false;
		                    }, 1);
		                });
		            })(x, y, data[i], labels[i], dot);
		        }
		        p = p.concat([x, y, x, y]);
		        bgpp = bgpp.concat([x, y, x, y, "L", x, height - bottomgutter, "z"]);
		        path.attr({path: p});
		        bgp.attr({path: bgpp});
		        frame.toFront();
		        label[0].toFront();
		        label[1].toFront();
		        blanket.toFront();
		    };
		</script>
	</body>
</html>