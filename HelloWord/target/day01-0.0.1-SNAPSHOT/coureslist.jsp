<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
</head>
	<script type="text/javascript">
	
		$(function () {
			$("#qxqbx").toggle(
				function () {
					$("input[name=cid]").attr("checked",true);
				},
				function () {
					$("input[name=cid]").attr("checked",false);
				}
			)
		})
		function HxShi() {
				var aid=$("#sheng").val();
				alert(aid);
				$.post(
						"HxShi.do",
						{aid:aid},
						function (data) {
							$("#shi").empty();
							for ( var i in data) {
								$("#shi").append("<option value="+data[i].aid+">"+data[i].aname+"</option>")
							}
						},
						"json"
					)
			}
			
			
			function HxXian() {
				var aid=$("#shi").val();
				alert(aid);
				$.post(
						"HxXian.do",
						{aid:aid},
						function (data) {
							$("#xian").empty();
							for ( var i in data) {
								$("#xian").append("<option value="+data[i].aid+">"+data[i].aname+"</option>")
							}
						},
						"json"
					)
			}
			
			function chakankc() {
				var cid=$("input[name=cid]:checked").val();
				alert(cid);
				location.href="jiarukc.jsp?cid="+cid;
			}
			
			function deleteAll() {
				/* var cid=$("input[name=cid]:checked").map(function (){
					return this.value;
				}).get().join(); */
				var cid=$("input[name=cid]:checked").val();
				alert(cid);
				$.post(
						"deleteAll.do",
						{cid:cid},
						function (data) {
							alert("删除成功！");
							alert("已成功删除1条");
							location.href="courselist.do";
						},
						"json"
					)
			}
	</script>
<body>
	<form action="courselist.do" method="post">
		<font color="red">
			<c:if test="${user.rolecode ==0 }">
				
				欢迎${user.uname } 老师登陆
				
			</c:if>
		</font>
		课程名称:<input type="text" name="cname"> 特色标签:<input type="text" name="label"> <br><br>
		
		地区 :	<select name="area1" id="sheng" onchange="HxShi()">
					<option>请选择----</option>
					<option value="1">华东区</option>
					<option value="2">华北区</option>
				</select>
				
				<select name="area2" id="shi" onchange="HxXian()">
					<option>请选择----</option>
				</select>
				
				<select name="area3" id="xian">
					<option>请选择----</option>
				</select>
				
				<input type="submit" value="搜索">
	</form>
	<table>
		<tr>
			<td>
				<input type="button" value="全选/全不选" id="qxqbx">
			</td>
			<td>课程名称</td>
			<td>特色标签</td>	
			<td>地区</td>
			<td>参与人员姓名</td>
			<td>参与人员身份</td>
			<td>课程介绍</td>
			<td>开始日期</td>
			<td>结束日期</td>	
			<td>照片</td>
			<td>操作</td>
		</tr>
<c:forEach items="${page.list }" var="e">
		<tr>
			<td>
				<input type="checkbox" name="cid" value="${e.cid }">
			</td>
			<td>${e.cname }</td>
			<td>${e.label }</td>
			<td>
				${e.sname.aname }
				${e.ssname.aname }
				${e.xname.aname }
			</td>
			<td>${e.uname }</td>
			<td>
				<c:if test="${e.rolecode ==0 }">
					讲师
				</c:if>
				<c:if test="${e.rolecode ==1 }">
					学生
				</c:if>
			</td>
			<td>${e.content }</td>
			<td>${e.startdate }</td>
			<td>${e.enddate }</td>
			<td>
				<img alt="" src="lookImg.do?path=${e.path }" width="25px" height="25px" >
			</td>
			<td></td>
		</tr>
</c:forEach>
	<tr>
		<td colspan="15">
			<a href="courselist.do?pageNum=${page.firstPage }">首页</a>
			<a href="courselist.do?pageNum=${page.prePage }">上一页</a>
			<a href="courselist.do?pageNum=${page.nextPage }">下一页</a>
			<a href="courselist.do?pageNum=${page.lastPage }">末页</a>
			
			总页${pages }
		</td>
	</tr>
	<tr>
		<td colspan="15">
			<c:if test="${user.rolecode ==0 }">
				<input type="button" value="批量删除" onclick="deleteAll()">
				<a href="addCourse.jsp"><input type="button" value="添加课程"></a>
			</c:if>
			<c:if test="${user.rolecode ==1 }">
				<input type="button" value="查看课程" onclick="chakankc()">
				
			</c:if>
		</td>
	</tr>
	</table>
</body>
</html>