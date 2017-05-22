<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String ctx = request.getContextPath();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>


</head>
<body>
	<form action="<%=request.getContextPath() %>/archive" method="post" id="form_id">
		<input type="hidden" name="timingType" id ="timingType" >
    	
    	<table>
    	  
       		<tr><td></td><td></td>
       			<td>
			    	<h2>
				    	<font color="red" >请选择接口：</font>
				    	<br/>
				    	<!-- hj 区域 -->
				    	<input type="button" id="_button" value="零件品种统计" onclick="goto_Inter('addTempLingjpztj')"/>
				    	<input type="button" id="_button" value="物流路径包装" onclick="goto_Inter('timingAddRepWulljbz')"/>
				    	<input type="button" id="_button" value="基础数据汇总" onclick="goto_Inter('timingAddRepJicsjhz')"/>
				    	<input type="button" id="_button" value="装车统计" onclick="goto_Inter('addRepFjzhuangc')"/>
				    	<br/>
				    	<!-- wy 区域 -->
				    	<input type="button" id="_button" value="删除备货令跟踪超过3个月的数据" onclick="goto_Inter('timingDeleteRepBeihlgz')"/>
				    	<input type="button" id="_button" value="物流故障数据" onclick="goto_Inter('timingAddwulgz')"/>
				    	<input type="button" id="_button" value="定时周期计划报表" onclick="goto_Inter('timingAddzhouqjh')"/>
				    	<input type="button" id="_button" value="删除零件财务流水帐超过3个月的数据" onclick="goto_Inter('timingDeleteRepLingjcwlsz')"/>
				    	<br/>
				    	<!-- wyc 区域 -->
						<input type="button" id="_button" value="要货令准时交付(" onclick="goto_Inter('timingAddyaohlzsjf')"/>
						<input type="button" id="_button" value="工废料废与随废信息(" onclick="goto_Inter('timingAddfeilxx')"/>
						<input type="button" id="_button" value="供应商每日报废与入库信息(" onclick="goto_Inter('timingAddgysmrbfyrk')"/>
				    	
				    	<br/>
				    	
				    	<!-- *wl* 区域 -->
				    	<input type="button" id="_button" value="总成件库存分析" onclick="goto_Inter('timingAddZongcjkcfx')"/>
				    	<input type="button" id="_button" value="库龄报表" onclick="goto_Inter('timingAddkulbb')"/>
				    	<br/>
				    	
				    	
				    	<!-- xryuan 区域 -->
				    	<input type="button" id="_button" value="开箱入库集装箱报表" onclick="goto_Inter('timingAddkaixruk')"/>
				    	<input type="button" id="_button" value="发运超过100天汇总零件清单" onclick="goto_Inter('timingAddfaycg100t')"/>
				    	<input type="button" id="_button" value="流量报表" onclick="goto_Inter('timingAddLiulBB')"/>
				    	<input type="button" id="_button" value="总成入库报表" onclick="goto_Inter('timingAddRigund')"/>
				    	<br/>
			    	</h2>
	    		</td>
    		</tr>
       		 <tr >
    	   <td colspan="3">
    	  操作提示： <font color="red" >${mes }</font>
    	    </td>  	  
    	   </tr>
    	</table>
    	
    </form>
</body>
<script type="text/javascript">
	//提交给后台
	//输入框测试
	
	function goto_Inter(funcName){
		var formEle = document.getElementById("form_id");
		var hidden_input = document.getElementById("timingType");
		hidden_input.value = funcName;
		formEle.submit();
	}
	
	
	
	
</script>
</html>

