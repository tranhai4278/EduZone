<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userDAO" value="<%= new dal.UserDAO() %>" />
<%@page import="model.User" %>


<!DOCTYPE html>
<html>
    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
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
                    <h4 class="breadcrumb-title">Student Management</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Student Management</li>
                    </ul>
                </div>

                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="mail-list-container">
                                    <div class="mail-toolbar">
                                        <form action = "classsearchstudent" method="post">
                                            <div class="search-bar">
                                                <input type="hidden" name="code" value="${Classcode}">
                                                <input type="text" name="search" class="form-control" placeholder="Search by Student Name, Email, or Phone Number" />
                                                <input type="submit" class="btn btn-primary" value="Search">
                                            </div>
                                        </form>

                                    </div>

                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">
                                                    <input type="checkbox" id="selectAllStudents" />
                                                </th>
                                                <th scope="col">Student Name</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Phone Number</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="student" items="${studentList}">
                                                <tr>
                                                    <td>
                                                        <input type="checkbox" class="studentCheckbox" value="${student.student.traineeID}" />
                                                    </td>
                                                    <td><c:out value="${student.fullName}" /></td>
                                                    <td><c:out value="${student.email}" /></td>
                                                    <td><c:out value="${student.phone}" /></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                    <form action="classaddstudent" method="post">
                                        <div class="row">
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                <input type="hidden" name="Classcode" value="${Classcode}">
                                                <select name="selectedStudent" class="form-control-sm">
                                                    <option value="">Select a Student to Add</option>
                                                    <c:choose>
                                                        <c:when test="${empty studentList}">
                                                            <c:forEach var="studentnew" items="${studentList2}">
                                                                <option value="${studentnew.userID}">
                                                                    <c:out value="${studentnew.fullName}" />
                                                                </option>
                                                            </c:forEach>
                                                        </c:when>

                                                        <c:otherwise>
                                                            <c:forEach var="studentnew" items="${studentList2}">
                                                                <c:set var="addToSelect" value="true" />

                                                                <c:forEach var="student" items="${studentList}">
                                                                    <c:if test="${studentnew.student.classID == Classcode || studentnew.student.traineeID == student.student.traineeID}">
                                                                        <c:set var="addToSelect" value="false" />
                                                                    </c:if>
                                                                </c:forEach>

                                                                <c:if test="${addToSelect}">
                                                                    <option value="${studentnew.userID}">
                                                                        <c:out value="${studentnew.fullName}" />
                                                                    </option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:otherwise>

                                                    </c:choose>
                                                </select>
                                                <button class="btn btn-primary" type="submit">Add Student</button>
                                            </div>
                                        </div>
                                    </form>



                                    <div class="action-buttons">
                                        <div class="col-12 col-sm-2 col-md-2 col-lg-2">
                                            <form action="removestudent" method="post" id="removeStudentsForm">
                                                <input type="hidden" name="Classcode" value="${Classcode}">
                                                <input type="hidden" name="selectedStudentIds" id="selectedStudentIds" />
                                                <button class="btn btn-danger" type="submit" id="removeStudentsBtn">Remove Students</button>
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

    <!-- External JavaScripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script>
        document.getElementById("removeStudentsBtn").addEventListener("click", function () {
            var selectedStudents = document.querySelectorAll(".studentCheckbox:checked");
            var selectedStudentIds = Array.from(selectedStudents).map(function (student) {
                return student.value;
            });

            // Populate the hidden input with the selected student IDs
            document.getElementById("selectedStudentIds").value = selectedStudentIds.join(",");
        });
    </script>

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

<!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>