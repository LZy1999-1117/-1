<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html lang="en">
	<script type="text/javascript">
	
		function articleByd() {
			var sid=$("#sid").val();
			var aid=$("#ones").val();
			alert(sid);
			$.post(
				"/admin/articleByd",
				{sid:sid,aid:aid},
				function (data) {
					if(data>0){
						alert("追加成功!");
						location="/admin/specialAll";
					}else{
						alert("追加失败!");
					}
					
				},
				"json"
			)
		}
	</script>
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="howsun">

    <title>CMS后台管理系统</title>

    <!-- Bootstrap core CSS-->
    <link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">

  </head>

  <body id="page-top">

	<!-- 后台管理系统顶部 -->
 	<jsp:include page="_inc_top.jsp"/>

    <div id="wrapper">

 		<!-- 后台管理系统左部菜单 -->
 		<jsp:include page="_inc_left.jsp"/>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">后台首页</a>
            </li>
             <li class="breadcrumb-item">
              <a href="#">标题管理</a>
            </li>
             <li class="breadcrumb-item">
              <a href="#">文章管理</a>
            </li>
          </ol>

          <!-- Icon Cards-->
          <br/>
          <br/>
          <h1 align="center">欢迎光临文章管理</h1>
          <br/>
          <br/>
          <div class="row">          		
           			<table class="table table-striped table-bordered table-hover">
				    		<thead>
				    			<tr class="info">
				    				<th>文章ID</th>
				    				<th>文章标题</th>
				    				<th>文章发布时间</th>
				    				<th>操作</th>
				    			</tr>
				    		</thead>
				    		<tbody class="">
				    		<c:forEach items="${list}" var="e">
				    			<tr id="item_${e.id}">
				    				<td>${e.id}</td>
				    				<td>${e.title}</td>
				    				<td><fmt:formatDate value="${e.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				    				<%-- <td><fmt:formatDate value="${blog.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
				    				<td><a class="btn btn-primary" href="/admin/articleAll?id=${e.id}" title="追加文章"><span class="glyphicon glyphicon-edit">移除</span></a>&nbsp;&nbsp;
				    				
				    			</tr>
				    		</c:forEach>
				    		</tbody>
				    	</table>
				    	<input type="hidden" value="${sid }" id="sid">
				    	<input type="text" placeholder="文章ID" id="ones">&nbsp;&nbsp;
				    	<button type="button" class="btn btn-danger" onclick="articleByd()">添加文章</button>
          </div>

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright Â© Your Website 2019</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="/libs/jquery/jquery.min.js"></script>
    <script src="/libs/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/libs/sb-admin/sb-admin.min.js"></script>
  </body>

</html>
