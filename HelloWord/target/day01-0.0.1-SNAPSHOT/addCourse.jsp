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
				$.post(
					"hxarea1.do",
					function (data) {
						for ( var i in data) {
							$("#sheng").append("<option value="+data[i].aid+">"+data[i].aname+"</option>")
						}
					},
					"json"
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
			
			function gnxy() {
				var startdate=$("input[name=startdate]").val().trim();
				var enddate=$("input[name=enddate]").val().trim();
				if(startdate!='' ){
					alert("时间不能为空");
					return false;
				}if( enddate !=''){
					alert("时间不能为空");
					return false;
				}
				return true;
	}
	</script>
<body>
	<form action="addCoures.do" method="post" enctype="multipart/form-data" onsubmit="gnxy()">
		<table>
		<tr>
			<td>课程名称</td>
			<td>
				<input type="text" name="cname">
			</td>
		</tr>
		<tr>
			<td>课程时间</td>
			<td>
				<input type="date" name="startdate">
				-
				<input type="date" name="enddate">
			</td>
		</tr>
		<tr>
			<td>地区</td>
			<td>
				<select name="area1" id="sheng" onchange="HxShi()">
					<option>请选择----</option>
				</select>
				
				<select name="area2" id="shi" onchange="HxXian()">
					<option>请选择----</option>
				</select>
				
				<select name="area3" id="xian">
					<option>请选择----</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>课程介绍</td>
			<td>
				<textarea rows="" cols="" name="content">
				
				</textarea>
			</td>
		</tr>
		<tr>
			<td>特色标签</td>
			<td>
				<input type="text" name="label">
			</td>
		</tr>
		<tr>
			<td>图片</td>
			<td>
				<input type="file" name="photo">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="创建课程">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>