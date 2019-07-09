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
			
			function zhuce() {
				var check=true;
				var password=$("input[name=password]").val();
				/* var uname=$("input[name=uname]").val();
				var rolecode=$("select[name=rolecode]:selected").val();
				alert(rolecode) */
				var rolecode=$("#sle").val();
				alert(rolecode);
				var mima=$("input[name=mima]").val();
				if(password!=mima){
					alert("俩次密码输入的不一致");
					return check=false;
				}
				
				if(check){
					
					$.post(
						"zhuece.do",
						$("form").serialize(),
						function (data) {
							if(data>0){
								
								
									if(confirm("已成功注册为讲师!"));
									location.href="login.jsp";
								
								
							}else{
								alert("注册失败");
							}
						},
						"json"
						
					)
					
				}
			}
			
			function MimaXy() {
				var password=$("input[name=password]").val();
				var reg=/^[0-9a-zA-Z_]+$/;
				if(!reg.test(password)){
					alert("密码必须为字母数字下滑线");
				}
			}
	</script>
<body>
<form action="">
	<table>
		<tr>
			<td colspan="2">用户登陆注册</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>
				<input type="text" name="uname">
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="text" name="password" onchange="MimaXy()">
			</td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td>
				<input type="text" name="mima">
			</td>
		</tr>
		<tr>
			<td>身份</td>
			<td>
				<select name="rolecode" id="sle">
					<option value="0">讲师</option>
					<option value="1">学生</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="注册" onclick="zhuce()">
				<a href="login.jsp"><input type="button" value="已有用户登录"></a>
			</td>
		</tr>
	</table>

</form>
</body>
</html>