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
                    <h4 class="breadcrumb-title">Class Detail</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Class Detail</li>
                    </ul>
                </div>
                <!-- header END ==== -->
                <!-- Content -->
                <div class="page-content bg-white">
                    <!-- Breadcrumb row END -->
                    <!-- inner page banner END -->
                    <div class="content-block">
                        <!-- About Us -->
                        <c:set var="classObj" value="${classObj}"/>
                        <c:set var="subjects" value="${subjects}"/>
                        <c:set var="users" value="${users}"/>
                        <c:set var="semesters" value="${semesters}"/>

                        <div class="row">
                            <!-- Your Profile Views Chart -->
                            <div class="col-lg-12 m-b30">
                                <div class="widget-box">
                                    <div class="wc-title">
                                        <h4>Class Detail</h4>
                                    </div>
                                    <% if (request.getAttribute("classAddFailed") != null) { %>
                                    <div class="alert alert-danger">
                                        <%= request.getAttribute("classAddFailed") %>
                                    </div>
                                    <% } %>
                                    <div class="widget-inner">
                                        <form class="edit-profile" action="updateclass" method="post">
                                            <div class="form-group row" hidden>
                                                <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Class ID</label>
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <input class="form-control" type="text" name="classID" value="<c:out value="${classObj.ID}"/>" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Class Code</label>
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <input class="form-control" type="text" name="classCode" value="<c:out value="${classObj.classCode}"/>" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Semester</label>
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <select name="semester" class="form-control">
                                                        <c:forEach var="semester" items="${semesters}">
                                                            <c:choose>
                                                                <c:when test="${semester.settingId eq classObj.semesterID}">
                                                                    <option value="<c:out value='${semester.settingId}'/>" selected><c:out value='${semester.settingName}'/></option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="<c:out value='${semester.settingId}'/>"><c:out value='${semester.settingName}'/></option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Lecturer</label>
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <select name="lecturer" class="form-control">
                                                        <c:forEach var="user" items="${users}">
                                                            <c:choose>
                                                                <c:when test="${user.userId eq classObj.trainerID}">
                                                                    <option value="<c:out value='${user.userId}'/>" selected><c:out value='${user.fullName}'/></option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="<c:out value='${user.userId}'/>"><c:out value='${user.fullName}'/></option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Subject</label>
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <select name="subject" class="form-control">
                                                        <c:forEach var="subject" items="${subjects}">
                                                            <c:choose>
                                                                <c:when test="${subject.subjectId eq classObj.subjectID}">
                                                                    <option value="<c:out value='${subject.subjectId}'/>" selected><c:out value='${subject.subjectCode}'/></option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="<c:out value='${subject.subjectId}'/>"><c:out value='${subject.subjectCode}'/></option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Status</label>
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <select name="status" class="form-control">
                                                        <c:choose>
                                                            <c:when test="${classObj.status == true}">
                                                                <option value="1" selected>Active</option>
                                                                <option value="0">Inactive</option>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <option value="1">Active</option>
                                                                <option value="0" selected>Inactive</option>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="seperator"></div>
                                            <div>
                                                <div>
                                                    <div class="row">
                                                        <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                        </div>
                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                            <button type="submit" class="btn">Save Change</button>
                                                            <button type="button" class="btn-secondry" onclick="window.location.href = 'classstudentlist?code=${classObj.ID}'">Return to Class List</button>

                                                            <button type="button" class="btn-secondry" onclick="window.location.href = 'classlist'">Return to Class List</button>
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
