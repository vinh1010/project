<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="layouts/header.jsp" flush="true"></jsp:include>

	<!-- HOME -->
	<section id="home">
		<div class="row">

			<div class="owl-carousel owl-theme home-slider">
				<div class="item item-first">
					<div class="caption">
						<div class="container">
							<div class="col-md-6 col-sm-12">
								<h1>Distance Learning Education Center</h1>
								<h3>Our online courses are designed to fit in your industry
									supporting all-round with latest technologies.</h3>
								<a href="#feature"
									class="section-btn btn btn-default smoothScroll">Discover
									more</a>
							</div>
						</div>
					</div>
				</div>

				<div class="item item-second">
					<div class="caption">
						<div class="container">
							<div class="col-md-6 col-sm-12">
								<h1>Start your journey with our practical courses</h1>
								<h3>Our online courses are built in partnership with
									technology leaders and are designed to meet industry demands.</h3>
								<a href="#courses"
									class="section-btn btn btn-default smoothScroll">Take a
									course</a>
							</div>
						</div>
					</div>
				</div>

				<div class="item item-third">
					<div class="caption">
						<div class="container">
							<div class="col-md-6 col-sm-12">
								<h1>Efficient Learning Methods</h1>
								<h3>
									Nam eget sapien vel nibh euismod vulputate in vel nibh. Quisque
									eu ex eu urna venenatis sollicitudin ut at libero. Visit <a
										rel="nofollow" href="https://www.facebook.com/templatemo">templatemo</a>
									page.
								</h3>
								<a href="#contact"
									class="section-btn btn btn-default smoothScroll">Let's chat</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- FEATURE -->
	<section id="feature">
		<div class="container">
			<div class="row">

				<div class="col-md-4 col-sm-4">
					<div class="feature-thumb">
						<span>01</span>
						<h3>Trending Courses</h3>
						<p>Known is free education HTML Bootstrap Template. You can
							download and use this for your website.</p>
					</div>
				</div>

				<div class="col-md-4 col-sm-4">
					<div class="feature-thumb">
						<span>02</span>
						<h3>Books & Library</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing eiusmod
							tempor incididunt ut labore et dolore magna.</p>
					</div>
				</div>

				<div class="col-md-4 col-sm-4">
					<div class="feature-thumb">
						<span>03</span>
						<h3>Certified Teachers</h3>
						<p>templatemo provides a wide variety of free Bootstrap
							Templates for you. Please tell your friends about us. Thank you.</p>
					</div>
				</div>

			</div>
		</div>
	</section>


	<!-- ABOUT -->
	<section id="about">
		<div class="container">
			<div class="row">

				<div class="col-md-6 col-sm-12">
					<div class="about-info">
						<h2>Start your journey to a better life with online practical
							courses</h2>

						<figure>
							<span><i class="fa fa-users"></i></span>
							<figcaption>
								<h3>Professional Trainers</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Sint ipsa voluptatibus.</p>
							</figcaption>
						</figure>

						<figure>
							<span><i class="fa fa-certificate"></i></span>
							<figcaption>
								<h3>International Certifications</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Sint ipsa voluptatibus.</p>
							</figcaption>
						</figure>

						<figure>
							<span><i class="fa fa-bar-chart-o"></i></span>
							<figcaption>
								<h3>Free for 3 months</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Sint ipsa voluptatibus.</p>
							</figcaption>
						</figure>
					</div>
				</div>
			</div>
		</div>
	</section>

      <!-- Team -->
	<section id="team">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="section-title">
						<h2>
							Teachers <small>Meet Professional Trainers</small>
						</h2>
					</div>
				
					<div class="owl-carousel owl-theme owl-courses">
						<c:forEach items="${listTeacher}" var="t">
							<div class="col-sm-3">
		                        <div class="team-thumb">
		                             <div class="team-image">
		                                  <img
		                                       src="<c:url value="http://localhost:8080/BTL_SPRINGHIBERNATE/resources"/>/images/teachers/${t.avartar}"
		                                       class="img-responsive" alt="" width="50%">
		                             </div>
		                             <div class="team-info">
		                                  <h3>${t.fullName}</h3>
		                                  <span>${t.slogan}</span>
		                             </div>
		                             <ul class="social-icon">
		                                  <li><a href="https://www.facebook.com/vinh.nhok.7798" class="fa fa-facebook-square"
		                                       attr="facebook icon"></a></li>
		                                  <li><a href="https://www.instagram.com/tiu.bach/" class="fa fa-instagram"></a></li>
		                             </ul>
		                        </div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Courses -->
	<section id="courses">
		<div class="container">
			<div class="row">

				<div class="col-md-12 col-sm-12">
					<div class="section-title">
						<h2>
							Popular Courses <small>Upgrade your skills with newest
								courses</small>
						</h2>
					</div>

					<div class="owl-carousel owl-theme owl-courses">
						<c:forEach items="${listCouse}" var="c">
							<div class="col-md-4 col-sm-4">
								<div class="item">
									<div class="courses-thumb">
										<div class="courses-top">
											<div class="courses-image">
												<img
													src="<c:url value="http://localhost:8080/BTL_SPRINGHIBERNATE/resources"/>/images/courses/${c.images}"
													class="img-responsive" alt="" width="50%">
											</div>
											<div class="courses-date">
												<span><i class="fa fa-calendar mr-1"></i>${c.startDay}</span> <span><i
													class="fa fa-clock-o"></i> ${c.hoursStudy} Hours</span>
											</div>
										</div>
	
										<div class="courses-detail">
											<h3>
												<a href="" data-toggle="modal" data-target="#exampleModal">${c.couName}</a>
											</h3>
											<p>${c.description}</p>
										</div>
	
										<div class="courses-info">
											<div class="courses-author">
												<img
													src="<c:url value="http://localhost:8080/BTL_SPRINGHIBERNATE/resources"/>/images/teachers/${c.objTeacher.avartar}"
													class="img-responsive" alt=""> <span>${c.objTeacher.fullName}</span>
											</div>
											<div class="courses-price">
												<a href="initRegisterCourse?id=${c.couId}"><span>USD ${c.price}</span></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
	</section>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="col-md-4 col-sm-4"></div>
	  <div class="col-md-4 col-sm-4">
			<div class="item">
				<div class="courses-thumb">
					<div class="courses-top">
						<div class="courses-image">
							<img
								src="<c:url value="assets"/>/customers/images/courses-image1.jpg"
								class="img-responsive" alt="" width="100%">
						</div>
						<div class="courses-date">
							<span><i class="fa fa-calendar"></i> 12 / 7 / 2018</span> <span><i
								class="fa fa-clock-o"></i> 7 Hours</span>
						</div>
					</div>

					<div class="courses-detail">
						<h3>
							<a href="" data-toggle="modal" data-target="#exampleModal">Social Media Management</a>
						</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing
							elit.</p>
					</div>

					<div class="courses-info">
						<div class="courses-author">
							<img
								src="<c:url value="assets"/>/customers/images/author-image1.jpg"
								class="img-responsive" alt=""> <span>Mark
								Wilson</span>
						</div>
						<div class="courses-price">
							<a href="#"><span>USD 25</span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-sm-4"></div>
	</div>
 <jsp:include page="layouts/footer.jsp" flush="true"></jsp:include>  

	