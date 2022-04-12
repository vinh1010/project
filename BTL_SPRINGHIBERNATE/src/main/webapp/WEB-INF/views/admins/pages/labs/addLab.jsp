<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Labs Manager</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Labs Manager</a></li>
						<li class="breadcrumb-item active">Add Lab</li>
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
			<div class="card card-primary">
				<div class="card-header">
					<h3 class="card-title">Add Lab</h3>
				</div>
				<!-- /.card-header -->
				<!-- form start -->
				<form:form modelAttribute="l" action="addLab" method="post">
					<div class="card-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Id Lab</label> 
							<form:input path="labId" type="text" class="form-control" placeholder="Enter id lab"/>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Lab Name</label> 
							<form:input path="labName" type="text" class="form-control" placeholder="Enter lab name"/>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Status</label>
							<br> 
							<form:radiobutton path="status" value="true"/>Onl
							<form:radiobutton path="status" value="false"/>Off
						</div>
					</div>
					<!-- /.card-body -->

					<div class="card-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
		<!--/. container-fluid -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>
