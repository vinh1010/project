<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="layouts/header.jsp" flush="true"></jsp:include>
<style type="text/css">
	.colorRed{
		color: red
	}
</style>
<div class="register_course" style="margin-top: 50px;margin-bottom: 50px; display: flex;">
	<div class="container">
		<div class="row">
			<div class="text-center"><h1>Register Course</h1></div>
			<div class="form col-md-6" style="float: left;">
				<h2>Form</h2>
				<p>Please provide more information so we can contact you</p>
				<form:form modelAttribute="rc" action="registerCourse" method="post">
				  <div class="form-group">
				    <label for="exampleInputEmail1">Full name</label>
				    <form:input path="fullName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter is full name"/>
				  	<label for="exampleInputEmail1"><form:errors path="fullName" cssClass="colorRed"></form:errors></label>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Email</label>
				    <form:input path="email" type="text" class="form-control" id="exampleInputPassword1" placeholder="Enter is email"/>
				  	<label for="exampleInputEmail1"><form:errors path="email" cssClass="colorRed"></form:errors></label>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Phone</label>
				    <form:input path="phone" type="text" class="form-control" id="exampleInputPassword1" placeholder="Enter is phone"/>
				 	<label for="exampleInputEmail1"><form:errors path="phone" cssClass="colorRed"></form:errors></label>
				  </div>
				  	<form:input path="coursesId" type="hidden" value="${c.couId}" />
				   <form:input path="status" type="hidden" value="false" />
				  <button type="submit" class="btn btn-primary form-control" style="background: #29ca8e">Submit</button>
				</form:form>
			</div>
			<div class="inf col-md-6">
				<h2>Course Information</h2>
				<p>Information about your chosen course</p>
				<table class="table">
				  <tbody>
				    <tr>
				      <th scope="row" style="width="10%">Course Name: </th>
				      <th>${c.couName}</th>
				    </tr>
				    <tr>
				      <th scope="row">Start Day: </th>
				      <th>${c.startDay}</th>
				    </tr>
				    <tr>
				      <th scope="row">Hours Study: </th>
				      <th>${c.hoursStudy}</th>
				    </tr>
				    <tr style="border-bottom: 1px solid #ddd;">
				      <th scope="row">Price: </th>
				      <th>${c.price} $</th>
				    </tr>
				  </tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<jsp:include page="layouts/footer.jsp" flush="true"></jsp:include> 