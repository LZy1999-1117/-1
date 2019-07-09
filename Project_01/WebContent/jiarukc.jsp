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
			var cid=${param.cid};
			alert(cid);
			$.post(
					"chakankc.do",
					{cid:cid},
					function (data) {
		
						
						alert(JSON.stringify(data));
						$("input[name=cname]").val(data.cname);
						$("input[name=startdate]").val(data.startdate);
						$("input[name=enddate]").val(data.enddate);
						$("input[name=label]").val(data.label);
						$("input[name=cid]").val(data.cid);
						$("#nr").text(data.content);
						/* $("select[name=area1][value="+data.area1+"]").attr("selected",true);
						$("select[name=area2][value="+data.area2+"]").attr("selected",true);
						$("select[name=area3][value="+data.area3+"]").attr("selected",true); */
						$("#dk").val(data.path);
					},
					"json"
				)
		})
		
		function addCouser() {
			var cid=$("input[name=cid]").val();
			alert(cid);
			$.post(
				"addCouser.do",
				{cid:cid},
				function (data) {
					if(data>0){
						alert("添加课程成功");
						location.href="courselist.do";
						
					}
				},
				"json"
			)
		}
	</script>
<body>
	<form action="addCoures.do" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<td>课程名称</td>
			<td>
				<input type="hidden" name="cid">
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
			<td>课程介绍</td>
			<td>
				<textarea rows="" cols="" name="content" id="nr">
				
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
				<%-- <img alt="" src="lookImg.do?path=${user.path }" width="25px" height="25px" > --%>
				<input type="text" id="dk" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="加入课程" onclick="addCouser()">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>