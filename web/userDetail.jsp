<%-- 
    Document   : userDetail
    Created on : Sep 25, 2023, 2:17:11 AM
    Author     : PHAM NGOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduNext : Education HTML Template" />

        <!-- OG -->
        <meta uperty="og:title" content="EduNext : Education HTML Template" />
        <meta uperty="og:description" content="EduNext : Education HTML Template" />
        <meta uperty="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduNext : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Setting</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Setting</li>
                    </ul>
                </div>	
                <!-- header END ==== -->
                <!-- Content -->
                <div class="page-content bg-white">
                    <div class="breadcrumb-row">
                        <div class="container">

                        </div>
                    </div>
                    <!-- Breadcrumb row END -->
                    <!-- inner page banner END -->
                    <div class="content-block">
                        <!-- About Us -->
                        <c:set var="user" value="${user}"/>
                        <div class="section-area section-sp1">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                        <div class="profile-bx text-center">
                                            <div class="user-profile-thumb">
                                                <img src="${user.avatarUrl}" alt=""/>
                                            </div>
                                            <div class="profile-info">
                                                <h4><c:out value="${user.fullName}"/></h4>
                                                <span><c:out value="${user.email}"/></span>
                                            </div>

                                            <div class="profile-tabnav">
                                                <ul class="nav nav-tabs">
                                                    <li class="nav-item">
                                                        <a class="nav-link" data-toggle="tab" href="#edit-profile"><i class="ti-pencil-alt"></i>Edit User</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link active" data-toggle="tab" href="#courses"><i class="ti-book"></i>Courses</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" data-toggle="tab" href="#quiz-results"><i class="ti-bookmark-alt"></i>Quiz Results </a>
                                                    </li>                                              
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-9 col-md-8 col-sm-12 m-b30">
                                        <div class="profile-content-bx">
                                            <div class="tab-content">
                                                <div class="tab-pane active" id="courses">
                                                    <div class="profile-head">
                                                        <h3>Enrolled Courses</h3>
                                                        <div class="feature-filters style1 ml-auto">
                                                            <ul class="filters" data-toggle="buttons">
                                                                <li data-filter="" class="btn active">
                                                                    <input type="radio">
                                                                    <a href="#"><span>All</span></a> 
                                                                </li>
                                                                <li data-filter="publish" class="btn">
                                                                    <input type="radio">
                                                                    <a href="#"><span>Publish</span></a> 
                                                                </li>
                                                                <li data-filter="pending" class="btn">
                                                                    <input type="radio">
                                                                    <a href="#"><span>Pending</span></a> 
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="courses-filter">
                                                        <div class="clearfix">
                                                            <ul id="masonry" class="ttr-gallery-listing magnific-image row">
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic1.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic2.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic3.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic4.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic5.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic6.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic7.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 book">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic8.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                                <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                    <div class="cours-bx">
                                                                        <div class="action-box">
                                                                            <img src="assets/images/courses/pic9.jpg" alt="">
                                                                            <a href="#" class="btn">Read More</a>
                                                                        </div>
                                                                        <div class="info-bx text-center">
                                                                            <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                            <span>Programming</span>
                                                                        </div>
                                                                        <div class="cours-more-info">
                                                                            <div class="review">
                                                                                <span>3 Review</span>
                                                                                <ul class="cours-star">
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                    <li><i class="fa fa-star"></i></li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="price">
                                                                                <del>$190</del>
                                                                                <h5>$120</h5>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="tab-pane" id="quiz-results">
                                                    <div class="profile-head">
                                                        <h3>Quiz Results</h3>
                                                    </div>
                                                    <div class="courses-filter">
                                                        <div class="row">
                                                            <div class="col-md-6 col-lg-6">
                                                                <ul class="course-features">
                                                                    <li><i class="ti-book"></i> <span class="label">Lectures</span> <span class="value">8</span></li>
                                                                    <li><i class="ti-help-alt"></i> <span class="label">Quizzes</span> <span class="value">1</span></li>
                                                                    <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">60 hours</span></li>
                                                                    <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">Beginner</span></li>
                                                                    <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
                                                                    <li><i class="ti-user"></i> <span class="label">Students</span> <span class="value">32</span></li>
                                                                    <li><i class="ti-check-box"></i> <span class="label">Assessments</span> <span class="value">Yes</span></li>
                                                                </ul>
                                                            </div>
                                                            <div class="col-md-6 col-lg-6">
                                                                <ul class="course-features">
                                                                    <li><i class="ti-book"></i> <span class="label">Lectures</span> <span class="value">8</span></li>
                                                                    <li><i class="ti-help-alt"></i> <span class="label">Quizzes</span> <span class="value">1</span></li>
                                                                    <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">60 hours</span></li>
                                                                    <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">Beginner</span></li>
                                                                    <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
                                                                    <li><i class="ti-user"></i> <span class="label">Students</span> <span class="value">32</span></li>
                                                                    <li><i class="ti-check-box"></i> <span class="label">Assessments</span> <span class="value">Yes</span></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="tab-pane" id="edit-profile">
                                                    <div class="profile-head">
                                                        <h3>Edit User Details</h3>
                                                    </div>

                                                    <div class="edit-profile">
                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3>1. Personal Details</h3>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">User ID</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.userId}" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Full Name</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.fullName}" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Gender</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.genderDisplay}" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="seperator"></div>

                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3>2. Contact</h3>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Email</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.email}" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Phone</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.phone}" readonly>
                                                            </div>
                                                        </div>

                                                        <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>

                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3 class="m-form__section">3. History</h3>
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Create user at</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.createAt}">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Create user by</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.createBy}">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Update user at</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.updateAt}">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Update user by</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <input class="form-control" type="text" value="${user.updateBy}">
                                                            </div>
                                                        </div>
                                                        <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>
                                                        <div class="form-group row">
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-10 ml-auto">
                                                                <h3 class="m-form__section">4. Edit User</h3>
                                                            </div>
                                                        </div>
                                                        <c:choose>
                                                            <c:when test="${user.roleId eq 0}">
                                                                <c:set var="trainerSelected" value="selected" />
                                                                <c:set var="traineeSelected" value="" />
                                                            </c:when>
                                                            <c:when test="${user.roleId eq 1}">
                                                                <c:set var="trainerSelected" value="" />
                                                                <c:set var="traineeSelected" value="selected" />
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:set var="trainerSelected" value="" />
                                                                <c:set var="traineeSelected" value="" />
                                                            </c:otherwise>
                                                        </c:choose>

                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Role</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <select name="role" class="form-control">
                                                                    <option value="1" ${traineeSelected}>Trainee</option>
                                                                    <option value="2" ${trainerSelected}>Trainer</option>
                                                                    <option value="3" ${subjectManagerSelected}>Subject Manager</option>
                                                                    <option value="4" ${adminSelected}>Admin</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Status</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <select name="role" class="form-control">
                                                                    <option value="1" ${activeSelected}>Active</option>
                                                                    <option value="0" ${inactiveSelected}>Inactive</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="">
                                                        <div class="">
                                                            <div class="row">
                                                                <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                                </div>
                                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                    <button type="submit" class="btn">Save changes</button>
                                                                    <button type="reset" class="btn-secondry">Cancel</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    </form>
                                                </div>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- contact area END -->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="assets/vendors/counter/waypoints-min.js"></script>
        <script src="assets/vendors/counter/counterup.min.js"></script>
        <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="assets/vendors/masonry/masonry.js"></script>
        <script src="assets/vendors/masonry/filter.js"></script>
        <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/vendors/chart/chart.min.js"></script>
        <script src="assets/js/admin.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>

    </body>
</html>
