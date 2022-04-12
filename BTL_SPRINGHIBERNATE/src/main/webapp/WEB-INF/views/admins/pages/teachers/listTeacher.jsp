<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">List Teachers</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Teacher Manager</a></li>
						<li class="breadcrumb-item active">List Teachers</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->
	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">List Teachers</h3>
						<div class="card-tools">
							<form action="searchTeacher" method="post">
								<div class="input-group input-group-sm" style="width: 200px;">
									<input type="text" name="searchTech" class="form-control float-right" placeholder="Enter Name">
									<div class="input-group-append">
										<button type="submit" class="btn btn-default">
											<i class="fas fa-search"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<c:if test="${success.length() > 0}">
						<div class="alert alert-success" role="alert">
						  ${success}
						</div>
					</c:if>
					
					<c:if test="${error.length() > 0}">
						<div class="alert alert-danger" role="alert">
						  ${error}
						</div>
					</c:if>
					<div class="card-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th style="width: 10px">STT</th>
									<th style="width: 100px">ID Teacher</th>
									<th>Full Name</th>
									<th>BirthDay</th>
									<th style="width: 40px">Status</th>
									<th style="width: 120px">Tools</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="t">
									<tr>
										<td>${t.stt}.</td>
										<td>${t.teaId}</td>
										<td>${t.fullName}</td>
										<td>${t.birthDay}</td>
										<td>
											<c:choose>
												<c:when test="${t.status}">
									            	<p class="badge bg-success">Work</p>
									         	</c:when>
									         	
												<c:otherwise>
									            	<p class="badge bg-danger">Rested</p>
									         	</c:otherwise>
											</c:choose>
										</td>
										<td class="text-center">
											<a href="initUpdateTeacher?id=${t.stt}" title="Update"><i style="color: green;" class="fas fa-pen"></i></a>
											<a href="detailTeacher?id=${t.stt}" title="Detail"><i style="color: orange;margin-left: 10px" class="fa fa-eye"></i></a>
											<a href="deleteTeacher?id=${t.stt}" title="Delete"><i style="margin-left: 10px; color: red" class="fa fa-trash" aria-hidden="true"></i></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="card-footer clearfix">
						<ul class="pagination pagination-sm m-0 float-right">
							<li class="page-item"><a class="page-link" href="#">«</a></li>
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#">»</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--/. container-fluid -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>
