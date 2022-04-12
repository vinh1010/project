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
					<h1 class="m-0">List Subjects</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Subjects Manager</a></li>
						<li class="breadcrumb-item active">List Subjects</li>
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
						<h3 class="card-title">List Subjects</h3>
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
									<th style="width: 100px">ID Subject</th>
									<th>Subject Name</th>
									<th>Course Name</th>
									<th style="width: 40px">Status</th>
									<th style="width: 120px">Tools</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="sub">
									<tr>
										<td>${sub.subId}</td>
										<td>${sub.subName}</td>
										<td>${sub.objCourses.couName}</td>
										<td>
											<c:choose>
												<c:when test="${sub.status}">
									            	<p class="badge bg-success">Open</p>
									         	</c:when>
									         	
												<c:otherwise>
									            	<p class="badge bg-danger">Off</p>
									         	</c:otherwise>
											</c:choose>
										</td>
										<td class="text-center">
											<a href="initUpdateSubject?id=${sub.subId}" title="Update"><i style="color: green;" class="fas fa-pen"></i></a>
											<a href="deleteSubject?id=${sub.subId}" title="Delete"><i style="margin-left: 10px; color: red" class="fa fa-trash" aria-hidden="true"></i></a>
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
