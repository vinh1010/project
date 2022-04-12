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
					<h1 class="m-0">Course Manager</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Course Manager</a></li>
						<li class="breadcrumb-item active">Add Course</li>
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
					<h3 class="card-title">Add Course</h3>
				</div>
				<!-- /.card-header -->
				<!-- form start -->
				<form:form modelAttribute="c" action="addCourse" method="post" enctype="multipart/form-data">
					<div class="card-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Id Course</label> 
							<form:input path="couId" type="text" class="form-control" placeholder="Enter id course"/>
							<label for="exampleInputEmail1"><form:errors path="couId" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Course Name</label> 
							<form:input path="couName" type="text" class="form-control" placeholder="Enter course name"/>
							<label for="exampleInputEmail1"><form:errors path="couName" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputFile">Images</label>
							<div class="input-group">
								<div class="custom-file">
									<input type="file" class="custom-file-input"
										id="exampleInputFile" name="avartar"> <label
										class="custom-file-label" for="exampleInputFile">Choose
										file</label>
								</div>
								<div class="input-group-append">
									<span class="input-group-text">Upload</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Start Day</label> 
							<form:input path="startDay" type="date" class="form-control"/>
							<label for="exampleInputEmail1"><form:errors path="startDay" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Hours Study</label> 
							<form:input path="hoursStudy" type="number" class="form-control" placeholder="Enter hours study"/>
							<label for="exampleInputEmail1"><form:errors path="hoursStudy" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Price</label> 
							<form:input path="price" type="number" class="form-control" placeholder="Enter price"/>
							<label for="exampleInputEmail1"><form:errors path="price" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Description</label> 
							<form:input path="description" type="text" class="form-control" placeholder="Enter description"/>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Status</label>
							<br> 
							<form:radiobutton path="status" value="true"/>Open
							<form:radiobutton path="status" value="false"/>Off
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Lab</label> 
							<form:select path="objLLap.LabId" class="form-control">
								<form:option value="">----------Please select a lab----------</form:option>
								<form:options items="${listLab}" itemLabel="labName" itemValue="labId" /> 
							</form:select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Teacher</label> 
							<form:select path="objTeacher.stt" class="form-control">
								<form:option value="">----------Please select a lab----------</form:option>
								<form:options items="${listTeach}" itemLabel="fullName" itemValue="stt" /> 
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
