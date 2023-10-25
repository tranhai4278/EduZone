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

    </head>

    <style>
        /* Style for the pop-up overlay */
        .popup-overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 999;
        }

        /* Style for the pop-up dialog */
        .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            z-index: 1000;
        }

        /* Style for the table and buttons */
        table {
            font-size: 16px; /* Adjust the font size as needed */
            width: 100%; /* Make the table full width */
        }

        .btn {
            font-size: 16px; /* Adjust the font size for buttons */
        }


    </style>


    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
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
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="">
                                    <!-- Search Bar Section -->
                                    <form action="searchclasses" method="post">
                                        <div class="row">
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                <input type="text" class="form-control" name="search" placeholder="Search by Class Code or Teacher" />
                                            </div>
                                            <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                <input type="submit" class="btn btn-primary" value="Search" />
                                            </div>
                                        </div>
                                    </form>

                                    <!-- Subject Filter Section -->
                                    <form action="filterclasses" method="post">
                                        <div class="row">
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                <select name="selectedSubject" class="form-control-sm">
                                                    <option value="">Select Subject</option>
                                                    <c:forEach var="subject" items="${subjects}">
                                                        <option value="${subject.subjectCode}">${subject.subjectCode}</option>
                                                    </c:forEach>
                                                </select>
                                                <div class="row"></div>
                                            </div>
                                            <div class="col-12 col-sm-2 col-md-2 col-lg-2">
                                                <button class="btn btn-primary">Filter</button>
                                            </div>
                                        </div>
                                    </form>

                                    <form action="classlist" method="post">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Select</th>
                                                    <th scope="col">Class Code</th>
                                                    <th scope="col">Subject</th>
                                                    <th scope="col">Teacher's Name</th>
                                                    <th scope="col">Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="classObj" items="${classes}">
                                                    <tr>
                                                        <td>
                                                            <input type="checkbox" name="selectedClasses" value="${classObj.ID}" />
                                                        </td>
                                                        <td>
                                                            <a href="classdetail?Code=${classObj.classCode}">
                                                                ${classObj.classCode}
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <c:forEach var="subjects" items="${subjects}">
                                                                <c:if test="${subjects.subjectId eq classObj.subjectID}">
                                                                    <c:out value="${subjects.subjectCode}" />
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <c:forEach var="users" items="${users}">
                                                                <c:if test="${users.userId eq classObj.trainerID}">
                                                                    <c:out value="${users.fullName}" />
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td><c:out value="${classObj.status ? 'Active' : 'Inactive'}" /></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>

                                        <button type="submit" class="btn btn-primary" name="action" value="activate">Activate</button>
                                        <button type="submit" class="btn btn-primary" name="action" value="deactivate">Deactivate</button>
                                        <button type="button" class="btn btn-secondary" id="newClassButton">Create a new Class</button>
                                    </form>



                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="newClassPopup" class="popup">

                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Create a New Class</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="new-class-form m-b30" action="newclass" method="post">
                                    <div class="col-sm-10 ml-auto">
                                        <% String errorMessage = (String) request.getAttribute("error"); %>
                                        <% if (errorMessage != null) { %>
                                        <div class="alert alert-danger" role="alert">
                                            <strong>Error:</strong> <%= errorMessage %>
                                        </div>
                                        <% } %>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Class Code</label>
                                        <div class="col-sm-7">
                                            <input class="form-control" type="text" name="class_code" placeholder="Class Code">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Semester</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" name="semester">
                                                <c:forEach var="semester" items="${semesters}">
                                                    <option value="<c:out value='${semester.settingId}'/>"><c:out value='${semester.settingName}'/></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Lecturer</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" name="trainer">
                                                <c:forEach var="user" items="${trainers}">
                                                    <option value="<c:out value='${user.userId}'/>"><c:out value='${user.fullName}'/></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Subject</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" name="subject">
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option value="<c:out value='${subject.subjectId}'/>"><c:out value='${subject.subjectCode}'/></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-7">
                                            <button type="submit" class="btn">Create Class</button>
                                            <button type="reset" class="btn">Reset</button>
                                            <button type="button" class="btn-secondry" id="closePopupButton">Cancel</button>

                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>               
                </div>
        </main>
        <div class="ttr-overlay"></div>

        <script>
            document.getElementById('newClassButton').addEventListener('click', function () {
                // Show the overlay
                document.querySelector('.ttr-overlay').style.display = 'block';
                // Show the pop-up dialog
                document.querySelector('#newClassPopup').style.display = 'block';
            });

            // Add functionality to close the pop-up
            document.getElementById('closePopupButton').addEventListener('click', function () {
                // Hide the overlay and pop-up dialog
                document.querySelector('.ttr-overlay').style.display = 'none';
                document.querySelector('#newClassPopup').style.display = 'none';
            });

            document.querySelector('.ttr-overlay').addEventListener('click', function () {
                // Hide the overlay and pop-up dialog
                this.style.display = 'none';
                document.querySelector('#newClassPopup').style.display = 'none';
            });
        </script>

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
