<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> simulate combox control - http://www.never-online.net </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<style>
body, input
{
	font-family: verdana;
	font-size: 9pt;
	background:#000000;
}
.CtlSelect
{
	border: 1px solid #3a3b3c;
	font-family: verdana;
	height: 20px;
	color: #fff;
	background: #1c1e1f;
}
.selected
{
	background: #000;
	color: #ffffff;
	height: 20px;
}
.unselected
{
	height: 20px;
	color: #fff;
	line-height: 120%;
}
</style>
</HEAD>
<BODY>
<SCRIPT LANGUAGE="JavaScript">
<!--
function $(objID)
{
	return document.getElementById(objID);
};
function Offset(e)
{
	var t = e.offsetTop;
	var l = e.offsetLeft;
	var w = e.offsetWidth;
	var h = e.offsetHeight-2;
	while(e=e.offsetParent)
	{
		t+=e.offsetTop;
		l+=e.offsetLeft;
	}
	return {
		top : t,
		left : l,
		width : w,
		height : h
	}
}
//-----------------------------------------------
function simulateSelect() { with(this)
{
	this.IDs = [];
	this.name = this;
	//  property for beta Version
	//  can editable combox
	this.readonly = true;
	this.height = 20;
	this.width = null;
	this.ctlStyle = "CtlSelect";
	this.selStyle = "selected";
	this.unselStyle = "unselected";
	this.elementPrefix = "e__";
	this.inputPrefix = "i__";
	this.containerPrefix = "c__";
	this.buttonPrefix = "b__";
	return this;
}};
simulateSelect.prototype.init = function(ctlSelIDs) { with(this)
{
	eval(name).append(ctlSelIDs);
	eval(name).simulates();
}};
simulateSelect.prototype.style = function() { with(this)
{
	ctlStyle = arguments[0];
	selStyle = arguments[1];
	unselStyle = arguments[2];
}};
//-----------------------------------------------
simulateSelect.prototype.append = function(ctlSelIDs) { with(this)
{
	if( ctlSelIDs.indexOf(",")>0 )
	{
		var arrCtlSel = ctlSelIDs.split(",");
		for(var i=0; i<arrCtlSel.length; i++)
		{
			eval(name).IDs.push(arrCtlSel[i]);
		}
	}
	else
	{
		eval(name).IDs.push(ctlSelIDs);
	}
}};
simulateSelect.prototype.checkupOnMouseDown = function(e) { with(this)
{
	// here compatible mf.
	var el = e ? e.srcElement : e.target;
	if( el.id.indexOf(elementPrefix)>-1 || 
	el.id.indexOf(inputPrefix)>-1 || 
	el.id.indexOf(containerPrefix)>-1 || 
	el.id.indexOf(buttonPrefix)>-1 )
	{
		return;
	}
	else
	{
		for(var i=0; i<eval(name).IDs.length; i++)
		if( $(containerPrefix + IDs[i]) )
		$(containerPrefix + eval(name).IDs[i]).style.display = "none";
	}
}};
simulateSelect.prototype.simulates = function() { with(this)
{
	for(var i=0; i<IDs.length; i++)
	eval(name).simulate(IDs[i]);
}};
simulateSelect.prototype.simulate = function(ctlSelID) { with (this)
{
	var input;
	var button;
	var object;
	var offset;
	object = $(ctlSelID);
	offset = Offset(object);
	input = document.createElement("INPUT");
	button = document.createElement("BUTTON");
	button.setAttribute("id", buttonPrefix + ctlSelID);
	//button.value = "⊿";
	button.value = "6";
	button.style.fontFamily = "Webdings, Marlett";
	button.style.background = "";
	button.onclick = input.onclick = function()
	{
		this.blur();
		eval(name).expand(ctlSelID, offset);
	}
	input.onselectstart = function() { eval(name).expand(ctlSelID, offset); event.returnValue = false; };
	input.setAttribute("id", inputPrefix + ctlSelID);
	input.title = button.title = "click expand options";
	input.style.cursor = button.style.cursor = "default";
	input.className = button.className = ctlStyle;
	input.style.width = (width>0 ? width : object.offsetWidth);
	height ? input.style.height=button.style.height=height : "";
	input.value = object[0].text;
	if( readonly==true ) input.readOnly=true;
	// this method is only IE.
	object.insertAdjacentElement("afterEnd",button);
	object.insertAdjacentElement("afterEnd",input);
	object.style.display = 'none';
}};
simulateSelect.prototype.expand = function(ctlSelID, offset) { with(this)
{
	var div, btn_off;
	var object = $(ctlSelID);
	if( !$(containerPrefix + ctlSelID) )
	{
		div = document.createElement("DIV");
		div.style.position = "absolute";
		div.style.display = "block";
div.style.height = "300px";
		div.style.overflow = "auto";
		div.setAttribute("id", containerPrefix + ctlSelID);
		div.className = ctlStyle;
		div.style.left = offset.left;
		div.style.top = offset.top + offset.height;
		div.style.width = (width ? width : offset.width) + 20;
		div.style.height = 300;
		document.body.appendChild(div);
		for(var i=0; i<object.length; i++)
		{
			div = document.createElement("DIV");
			div.setAttribute("id", div.id = elementPrefix + ctlSelID + i);
			div.style.cursor = "default";
			if( object[i].text==$(inputPrefix + ctlSelID).value )
			div.className = selStyle;
			else
			div.className = unselStyle;
			div.innerText = div.title = object[i].text;
			div.style.height = height;
			div.setAttribute("value", object[i].value);
			div.onmouseover = function()
			{
				for(var j=0; j<$(containerPrefix + ctlSelID).childNodes.length; j++)
				{
					if($(containerPrefix + ctlSelID).childNodes[j]==this)
					$(containerPrefix + ctlSelID).childNodes[j].className = selStyle;
					else
					$(containerPrefix + ctlSelID).childNodes[j].className = unselStyle;
				}						
			};
			div.onclick = function()
			{
				$(inputPrefix + ctlSelID).value = this.innerText;
				$(containerPrefix + ctlSelID).style.display = "none";
			};
			$(containerPrefix + ctlSelID).appendChild(div);
		}
		return;
	}
	if( $(containerPrefix + ctlSelID).style.display=="none" )
	{
		for(var i=0; i<object.length; i++)
		{
			if( object[i].text==$(inputPrefix + ctlSelID).value )
			$(elementPrefix + ctlSelID + i).className = selStyle;
			else
			$(elementPrefix + ctlSelID + i).className = unselStyle;
		}
		$(containerPrefix + ctlSelID).style.display="block";
		return;
	}
	if( $(containerPrefix + ctlSelID).style.display=="block" )
	{
		$(containerPrefix + ctlSelID).style.display="none";
		return;
	}
}};
simulateSelect.prototype.getValue = function(ctlSelID) { with(this)
{
	if( $(inputPrefix + ctlSelID) )
	return $(inputPrefix + ctlSelID).value;
	else
	return null;
}};
simulateSelect.prototype.addEvent = function(w, h) { with(this)
{
}};
//-----------------------------------------------
//window.onerror = Function("return true;");
//  IE only.
document.attachEvent("onmousedown", function() {
						a.checkupOnMouseDown(event);
						//b.checkupOnMouseDown(event);
						//c.checkupOnMouseDown(event)
						}
					);
//-->
</SCRIPT>
<p>
<select id="s1">
<option value="- please select your options -"> - please select your options -</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
<option value="1">1option1</option>
<option value="2">1option2</option>
<option value="3">1option3</option>
<option value="4">1option4</option>
<option value="5">1option5</option>
</select>
</p>
<SCRIPT LANGUAGE="JavaScript">
<!--
	var a = new simulateSelect();
	a.style("CtlSelect", "selected", "unselected");
	a.init("s1");
//-->
</SCRIPT>
</BODY>
</HTML>