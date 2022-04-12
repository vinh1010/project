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
					<h1 class="m-0">Students Manager</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Students Manager</a></li>
						<li class="breadcrumb-item active">Update Student</li>
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
					<h3 class="card-title">Update Teacher</h3>
				</div>
				<!-- /.card-header -->
				<!-- form start -->
				<form:form modelAttribute="s" action="updateStudent" method="post" enctype="multipart/form-data">
					<div class="card-body">
						<form:input path="stt" type="hidden" readonly="readonly" />
						<div class="form-group">
							<label for="exampleInputEmail1">Id Student: ${s.stuId}</label> 
							<form:input path="stuId" type="hidden"/>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Full Name</label> 
							<form:input path="fullName" type="text" class="form-control" placeholder="Enter full name"/>
							<label for="exampleInputEmail1"><form:errors path="fullName" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputFile">Avatar</label>
							<br>
							<img alt="" src="<c:url value="http://localhost:8080/BTL_SPRINGHIBERNATE/resources"/>/images/students/${s.avartar}" width="200px" height="200px" />
							<div class="input-group">
								<div class="custom-file">
									<input type="file" class="custom-file-input"
										id="exampleInputFile" name="img"> <label
										class="custom-file-label" for="exampleInputFile">Choose
										file</label>
								</div>
								<div class="input-group-append">
									<span class="input-group-text">Upload</span>
								</div>
							</div>
							<form:input path="avartar" type="hidden"/>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Phone</label> 
							<form:input path="phone" type="text" class="form-control" placeholder="Enter phone"/>
							<label for="exampleInputEmail1"><form:errors path="phone" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">BirthDay</label> 
							<form:input path="birthDay" type="date" class="form-control"/>
							<label for="exampleInputEmail1"><form:errors path="birthDay" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Gender</label>
							<br> 
							<form:radiobutton path="gender" value="true"/>Male
							<form:radiobutton path="gender" value="false"/>Female
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Address</label> 
							<form:input path="address" type="text" class="form-control" placeholder="Enter address"/>
							<label for="exampleInputEmail1"><form:errors path="address" cssClass="colorRed"></form:errors></label>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Status</label>
							<br> 
							<form:radiobutton path="status" value="true"/>Onl
							<form:radiobutton path="status" value="false"/>Off
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
