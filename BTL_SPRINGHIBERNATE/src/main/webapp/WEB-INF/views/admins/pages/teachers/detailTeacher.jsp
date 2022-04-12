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
						<li class="breadcrumb-item active">Teacher Profile</li>
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
									src="<c:url value="http://localhost:8080/BTL_SPRINGHIBERNATE/resources"/>/images/teachers/${t.avartar}"
									alt="User profile picture">
							</div>
							<h3 class="profile-username text-center">${t.fullName}</h3>
							<p class="text-muted text-center">${t.degree}</p>
							<ul class="list-group list-group-unbordered mb-3">
								<li class="list-group-item"><b>Teacher Id: ${t.teaId}</b></li>
								<li class="list-group-item"><b>Gender: 
									<c:if test="${t.gender}">
										Male
									</c:if>
									<c:if test="${!t.gender}">
										Female
									</c:if>
								</b></li>
								<li class="list-group-item"><b>Slogan: ${t.slogan}</b></li>
							</ul>
							<a href="listTeacher" class="btn btn-primary btn-block"><b>Go List</b></a>
						</div>

					</div>

				</div>

				<div class="col-md-7">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">About Me</h3>
						</div>

						<div class="card-body">
							<strong><i class="fa fa-birthday-cake mr-1" aria-hidden="true"></i> BirthDay</strong>
							<p class="text-muted">${t.birthDay}</p>
							<hr>
							<strong><i class="fa fa-building mr-1"></i>
								Status</strong>
							<p class="text-muted">
								<c:if test="${t.status}">
									Work
								</c:if>
								<c:if test="${!t.status}">
									Rested
								</c:if>
							</p>
						</div>

					</div>
				</div>

			</div>

		</div>
	</section>

</div>
<jsp:include page="../../layouts/footer.jsp" flush="true"></jsp:include>