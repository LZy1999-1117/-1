<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>我的个人空间</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/cms.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	
	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 my_banner">
			</div>
		</div>
	</div>
	<br/>
	<!-- 主体内容区 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="/WEB-INF/inc/my_left.jsp"><jsp:param value="profile" name="module"/></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
				  <div class="panel-body">
				    <fieldset><legend>个人设置</legend></fieldset>
				    <hr class="bg-danger"/>
					<form action="/my/user/save" enctype="multipart/form-data" method="post" >
				    	<input type="hidden" value="${user.id}" name="id">
				    	<p align="center" class="red"> </p>
				    	
				    	<p>
				    		<input type="text" value="${user.username}" class="form-control" placeholder="用户名" name="username"/ >
				    		<span class="red"></span>
				    	</p>
				    	<p>
				    		<input  type="text" value="${user.nickname}" class="form-control" placeholder="姓名" name="nickname" / >
				    		<span class="red"></span>
				    	</p>
				    	
				    	<p>
				    		性别 : &nbsp;&nbsp;&nbsp;&nbsp;
				    		<input type="radio" value="FAMALE" name="sex" <c:if test="${user.gender.name()=='FAMALE' }">checked="checked"</c:if>>女士
				    		&nbsp;&nbsp;&nbsp;&nbsp;
				    		<input type="radio" value="MALE" name="sex" <c:if test="${user.gender.name()=='MALE' }">checked="checked"</c:if>>先生
				    	</p>
				    	<p>
				    		时间: &nbsp;&nbsp;&nbsp;&nbsp;
				    		<input  type="date" value="${birth}" class="form-control"  name="birth" / >
				    		<span class="red"></span>
				    	</p>
				    	<p>
				    		<input type="text" value="${user.phone}" class="form-control" placeholder="电话" name="phone" / >
				    		<span class="red"></span>
				    	</p>
				    	
				    	<p>
				    		<input type="text"  value="${user.email}" class="form-control" placeholder="邮箱" name="email" / >
				    		<span class="red"></span>
				    	</p>
				    	
				    	<p>
				    		<input type="text"  value="${user.address}" class="form-control" placeholder="地区" name="address" / >
				    		<span class="red"></span>
				    	</p>
				    	<p>
				    		<input type="text"  value="${user.star}" class="form-control" placeholder="星座" name="star" / >
				    		<span class="red"></span>
				    	</p>
				    	
				    	<p>
				    		<input type="text"  value="${user.motto}" class="form-control" placeholder="座右铭" name="motto" / >
				    		<span class="red"></span>
				    	</p>
				    	<p>
				    		<button type="submit" class="btn btn-info btn-block">保存</button> 
				    	</p>
				    	
				    	</form>
				  </div>
				</div>
				
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script type="text/javascript">
		
	</script>
  </body>
</html>