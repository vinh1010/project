<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../../layouts/header.jsp" flush="true"></jsp:include>
<div class="content-wrapper" style="min-height: 1604.8px;">

	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Profile</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Course Profile</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-5">

					<div class="card card-primary card-outline">
						<div class="card-body box-profile">
							<div class="text-center">
								<img class="profile-user-img img-fluid img-circle"
									src="<c:url value="http://localhost:8080/BTL_SPRINGHIBERNATE/resources"/>/images/courses/${c.images}"
									alt="User profile picture" width="100%">
							</div>
							<h3 class="profile-username text-center">${c.couName}</h3>
							<ul class="list-group list-group-unbordered mb-3">
								<li class="list-group-item"><b>Course Id: ${c.couId}</b></li>
								<li class="list-group-item"><b>Start Day: ${c.startDay}</b></li>
								<li class="list-group-item"><b>Teacher: ${c.objTeacher.fullName}</b></li>
								<li class="list-group-item"><b>Price: ${c.price} $</b></li>
							</ul>
							<a href="listCourses" class="btn btn-primary btn-block"><b>Go List</b></a>
						</div>

					</div>

				</div>

				<div class="col-md-7">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">About Course</h3>
						</div>

						<div class="card-body">
							<hr>
							<strong><i class="fa fa-clock mr-1"></i> Hours Study</strong>
							<p class="text-muted">${c.hoursStudy}</p>
							<hr>
							<strong><i class="fa fa-building mr-1"></i>
								Status</strong>
							<p class="text-muted">
								<c:if test="${c.status}">
									Open
								</c:if>
								<c:if test="${!c.status}">
									Off
								</c:if>
							</p>
							<hr>
							<strong><i class="fa fa-desktop mr-1"></i> Lab Name</strong>
							<p class="text-muted">${c.objLLap.labName}</p>
							<hr>
							<strong><i class="fa fa-info-circle mr-1"></i> Description</strong>
							<p class="text-muted">${c.description}</p>
							<hr>
						</div>

					</div>
				</div>

			</div>

		</div>
	</section>

</div>
<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>