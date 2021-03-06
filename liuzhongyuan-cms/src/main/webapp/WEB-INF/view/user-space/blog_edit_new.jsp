<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>发布博客</title>
	<script type="text/javascript" src="/libs/jquery/jquery.min.js"></script>
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
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
				<jsp:include page="/WEB-INF/inc/my_left.jsp"><jsp:param value="blog" name="module"/></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
				  <div class="panel-body">
				    	<h1>发布博客</h1>
				    	<hr/>
				    	
				    	<form action="/my/blog/save" enctype="multipart/form-data" method="post" >
				    	<input type="hidden" value="${blog.id}" name="id">
				    	<p align="center" class="red"> </p>
				    	<p>
				    		<span>频道</span>
				    		<select id="channel" name="channel.id"></select>
				    		
				    		<span>种类</span>
				    		<select id="category" name="category.id"></select>
				    	</p>
				    	<p>
				    		
				    		<input id="title" style="" name="title" value="${blog.title}" class="form-control" placeholder="博客标题"/>
				    		<button id="bTitle" type="button" class="btn btn-default">B</button>
				    		<button id="iTitle" type="button" class="btn btn-default">I</button>
				    		<button id="rTitle" type="button" class="btn btn-default">R</button>
				    		<span class="red"></span>
				    		<input name="style" id="style" type="text">
				    	</p>
				    	
				    	<p id="photo">
				    		<button type="button" class="btn btn-info" onclick="addphoto()">添加图片</button> <br>
				    		<c:if test="${pictures!=null }">
				    			<c:forEach items="${pictures }" var="picture">
				    				<img alt="" src="<%=request.getContextPath() %>${picture.photo}" style="max-height: 2.5rem" class="rounded img-fluid"><br>
				    				<input type="file" name="photo"/>
				    				<input name="desc" class="form-control" value="${picture.content }" placeholder="图片描述"/>
				    			</c:forEach>
				    		</c:if>
				    	</p>
				    	
				    	<p>
				    		<textarea name="summary" rows="3" class="form-control" placeholder="摘要">${blog.summary }</textarea>
				    		<span class="red"></span>
				    	</p>
				    	
				    	<p>上传封面：<input type="file" name="file"/>
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
	
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
	<script type="text/javascript">
		/* $(document).ready(function(){
			$("#content").summernote({
				placeholder:'博客内容',
				height:300
			});
		}); */
		//加载所有频道
		$.ajax({
			url :'/queryAllChannel',
			dataType : 'json',
			type : 'post',
			success : function(data){
				var content = "";
				for(var i = 0 ; i < data.length; i++){
					content += "<option value="+data[i].id+">"+data[i].name+"</option>";
				}
				$('#channel').html(content);
				var channel_id = $('#channel').find('option')[0].value;
				//默认加载第一个频道下的所有种类
				 $.ajax({
					url :'/queryCategoryByChannelId?channel=' + channel_id,
					dataType : 'json',
					type : 'post',
					success : function(data){
						var content = "";
						for(var i = 0 ; i < data.length; i++){
							content += "<option value="+data[i].id+">"+data[i].name+"</option>";
						}
						$('#category').html(content);
					}
				}); 
			}
		});
		
		$("#bTitle").click(function(){
			var style = $("#title").attr("style");
			if(style.indexOf("font-weight: bolder;")!=-1){
				var str=style.replace("font-weight: bolder;","");
				$("#title").attr("style",str);
				$("#style").val($("#title").attr("style"));
			}else{
				$("#title").attr("style",style+"font-weight: bolder;");
				$("#style").val($("#title").attr("style"));
			}
		})
		
		
		$("#iTitle").click(function(){
			var style = $("#title").attr("style");
			if(style.indexOf("font-style: italic;")!=-1){
				var str=style.replace("font-style: italic;","");
				$("#title").attr("style",str);
				$("#style").val($("#title").attr("style"));
			}else{
				$("#title").attr("style",style+"font-style: italic;");
				$("#style").val($("#title").attr("style"));
			}
		})
		
		$("#rTitle").click(function(){
			alert(1);
			var style = $("#title").attr("style");
			if(style.indexOf("color: red;")!=-1){
				var str=style.replace("color: red;","");
				$("#title").attr("style",str);
				$("#style").val($("#title").attr("style"));
			}else{
				$("#title").attr("style",style+"color: red;");
				$("#style").val($("#title").attr("style"));
			}
		})
		
		
		$('#channel').change(function(){
			var channel_id = $(this).find('option:selected').val();
			$.ajax({
				url :'/queryCategoryByChannelId?channel='+channel_id,
				dataType : 'json',
				type : 'post',
				success : function(data){
					var content = "";
					for(var i = 0 ; i < data.length; i++){
						content += "<option value="+data[i].id+">"+data[i].name+"</option>";
					}
					$('#category').html(content);
				}
			});
		});
		$.ajax({
			url :'/admin/queryAll',
			dataType : 'json',
			type : 'post',
			success : function(data){
				var content = "";
				for(var i = 0 ; i < data.length; i++){
					content += "<option value="+data[i].id+">"+data[i].title+"</option>";
				}
				$('#special').html(content);
			}
		});
		
		function addphoto(){
			$("#photo").append("<input type='file' name='photos'/><input name='desc' class='form-control' placeholder='图片描述'/>");
		}
	</script>
  </body>
</html>