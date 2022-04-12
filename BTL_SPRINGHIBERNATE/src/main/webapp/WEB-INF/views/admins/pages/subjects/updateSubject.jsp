<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>
<style type="text/css">
	.colorRed{
		color: red
	}
</style>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Subject Manager</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Subject Manager</a></li>
						<li class="breadcrumb-item active">Update Subject</li>
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
					<h3 class="card-title">Update Subject</h3>
				</div>
				<!-- /.card-header -->
				<!-- form start -->
				<form:form modelAttribute="sub" action="updateSubject" method="post">
					<div class="card-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Id Subject: ${sub.subId}</label> 
							<form:input path="subId" type="hidden" readonly="readonly"/>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Subject Name</label> 
							<form:input path="subName" type="text" class="form-control" placeholder="Enter subject name"/>
							<label for="exampleInputEmail1"><form:errors path="subName" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Status</label>
							<br> 
							<form:radiobutton path="status" value="true"/>Open
							<form:radiobutton path="status" value="false"/>Off
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Course</label> 
							<form:select path="objCourses.couId" class="form-control">
								<form:option value="">----------Please select a course----------</form:option>
								<form:options items="${listCourse}" itemLabel="couName" itemValue="couId" /> 
							</form:select>
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
