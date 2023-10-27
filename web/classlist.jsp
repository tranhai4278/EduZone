<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userDAO" value="<%= new dal.UserDAO() %>" />
<%@page import="model.User" %>

<!DOCTYPE html>
<html>

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

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script>
            $(document).ready(function () {
                // Show the General section by default
                $('#general').show();
                $('#add').hide();

                // Click event for "General" button
                $('#btn-general').click(function () {
                    $('#general').show();
                    $('#add').hide();
                });

                // Click event for "Add a new Class" button
                $('#btn-add').click(function () {
                    $('#general').hide();
                    $('#add').show();
                });
            });
        </script>

    </head>

    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <%@ include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Setting</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Setting</li>
                    </ul>
                </div>

                <!-- Buttons for switching between General and Add sections -->
                <button class="btn btn-light" id="btn-general">General</button>
                <button class="btn btn-light" id="btn-add">Add a new Class</button>

                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <!-- General Section -->
                            <div id="general">
                                <div class="widget-box">
                                    <% if (request.getAttribute("classAddSuccess") != null) { %>
                                    <div class="alert alert-success">
                                        <%= request.getAttribute("classAddSuccess") %>
                                    </div>
                                    <% } %>
                                    <% if (request.getAttribute("classAddFailed") != null) { %>
                                    <div class="alert alert-danger">
                                        <%= request.getAttribute("classAddFailed") %>
                                    </div>
                                    <% } %>


                                    <div class="search-bar-section">
                                        <form action="searchclasses" method="post">
                                            <div class="row">
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <input type="text" class="form-control" name="search"
                                                           placeholder="Search by Class Code or Teacher" />
                                                </div>
                                                <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                    <input type="submit" class="btn btn-primary" value="Search" />
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- Subject Filter Section -->
                                    <div class="subject-filter-section">
                                        <form action="filterclasses" method="post">
                                            <div class="row">
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                    <select name="selectedSubject" class="form-control-sm">
                                                        <option value="">Select Subject</option>
                                                        <c:forEach var="subject" items="${subjects}">
                                                            <option value="${subject.subjectCode}">${subject.subjectCode}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-12 col-sm-2 col-md-2 col-lg-2">
                                                    <button class="btn btn-primary">Filter</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- Class List Table and Action Buttons -->
                                    <form action="classlist" method="post">

                                        <!-- Card -->
                                        <div class="row">
                                            <c:forEach items="${classes}" var="classObj">
                                                <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                                                    
                                                    <a href="classdetail?Code=${classObj.classCode}">
                                                        <div class="widget-card widget-bg1" style="height: 150px">					 
                                                            <div class="wc-item">
                                                                
                                                                <h3 class="wc-title">
                                                                    <input type="checkbox" name="selectedClasses" value="${classObj.ID}" />
                                                                    ${classObj.classCode}
                                                                </h3>
                                                              <span class="wc-progress-bx">
                                                                    <c:forEach var="subjects" items="${subjects}">
                                                                        <c:if test="${subjects.subjectId eq classObj.subjectID}">
                                                                           Subject: <c:out value="${subjects.subjectCode}" />
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </span>
                                                                <span class="wc-progress-bx">
                                                                    <span class="wc-change" >
                                                                        <c:forEach var="subjects" items="${semesters}">
                                                                            <c:if test="${subjects.settingId eq classObj.semesterID}">
                                                                                Semester: <c:out value="${subjects.settingName}" />
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </span>
                                                                </span>
                                                                <span class="wc-progress-bx">
                                                                    <span class="wc-change" >
                                                                        <c:forEach var="users" items="${users}">
                                                                            <c:if test="${users.userId eq classObj.trainerID}">
                                                                              Trainer: <c:out value="${users.fullName}" />
                                                                            </c:if>
                                                                        </c:forEach>
                                                                    </span>
                                                                </span>
                                                                <span class="wc-progress-bx">
                                                                    <span class="wc-change" >
                                                                       Status: <c:out value="${classObj.status ? 'Active' : 'Inactive'}" />
                                                                    </span>
                                                                </span>
                                                            </div>				      
                                                        </div>
                                                    </a>
                                                </div>
                                            </c:forEach>
                                        </div>

                                        <!-- Card END -->

                                        <div class="action-buttons">
                                            <button type="submit" class="btn btn-primary" name="action" value="activate">Activate</button>
                                            <button type="submit" class="btn btn-primary" name="action" value="deactivate">Deactivate</button>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <!-- Add Section -->
                            <div class="mail-list-container" id="add">
                                <div class="row">
                                    <div class="col-lg-12 m-b30">
                                        <div class="widget-box">
                                            <div class="wc-title">
                                                <h4>Create a New Class</h4>
                                            </div>
                                            <div class="widget-inner">
                                                <form class="new-class-form" action="newclass" method="post">
                                                    <div class="form-group">
                                                        <label for="class_code">Class Code</label>
                                                        <input type="text" class="form-control" id="class_code" name="class_code" placeholder="Class Code">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="semester">Semester</label>
                                                        <select class="form-control" id="semester" name="semester">
                                                            <c:forEach var="semester" items="${semesters}">
                                                                <option value="${semester.settingId}">${semester.settingName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="trainer">Lecturer</label>
                                                        <select class="form-control" id="trainer" name="trainer">
                                                            <c:forEach var="user" items="${trainers}">
                                                                <option value="${user.userId}">${user.fullName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="subject">Subject</label>
                                                        <select class="form-control" id="subject" name="subject">
                                                            <c:forEach var="subject" items="${subjects}">
                                                                <option value="${subject.subjectId}">${subject.subjectCode}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-primary">Create Class</button>
                                                        <button type="reset" class="btn btn-secondary">Reset</button>
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
            </div>
        </main>
        <div class="ttr-overlay"></div>
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
        <script src='assets/vendors/calendar/moment.min.js'></script>
        <script src='assets/vendors/calendar/fullcalendar.js'></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>