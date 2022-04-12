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
					<h1 class="m-0">List Courses</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Course Manager</a></li>
						<li class="breadcrumb-item active">List Courses</li>
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
						<h3 class="card-title">List Courses</h3>
						<div class="card-tools">
							<form action="searchCourse" method="post">
								<div class="input-group input-group-sm" style="width: 200px;">
									<input type="text" name="search" class="form-control float-right" placeholder="Enter Name">
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
									<th style="width: 100px">ID Course</th>
									<th>Course Name</th>
									<th>Start Day</th>
									<th>Price</th>
									<th>Lab</th>
									<th>Teacher</th>
									<th style="width: 40px">Status</th>
									<th style="width: 120px">Tools</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="c">
									<tr>
										<td>${c.couId}</td>
										<td>${c.couName}</td>
										<td>${c.startDay}</td>
										<td>${c.price}</td>
										<td>${c.objLLap.labName}</td>
										<td>${c.objTeacher.fullName}</td>
										<td>
											<c:choose>
												<c:when test="${c.status}">
									            	<p class="badge bg-success">Open</p>
									         	</c:when>
									         	
												<c:otherwise>
									            	<p class="badge bg-danger">Off</p>
									         	</c:otherwise>
											</c:choose>
										</td>
										<td class="text-center">
											<a href="initUpdateCourse?id=${c.couId}" title="Update"><i style="color: green;" class="fas fa-pen"></i></a>
											<a href="detailCourse?id=${c.couId}" title="Detail"><i style="color: orange;margin-left: 10px" class="fa fa-eye"></i></a>
											<a href="deleteCourse?id=${c.couId}" title="Delete"><i style="margin-left: 10px; color: red" class="fa fa-trash" aria-hidden="true"></i></a>
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
