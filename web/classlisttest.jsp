<%--
    Document: classlist
    Created on: Oct 13, 2023, 12:30:41 AM
    Author: Your Name
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Class"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="" />
    <meta name="author" content="" />
    <meta name="robots" content="" />
    <meta name="description" content="EduNext: Education HTML Template" />
    <meta property="og:title" content="EduNext: Education HTML Template" />
    <meta property="og:description" content="EduNext: Education HTML Template" />
    <meta property="og:image" content="" />
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="../error-404.html" type="image/x-icon" />
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />
    <title>EduNext: Education HTML Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
    <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">
    <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
    <!-- Add CSS classes for a similar design -->
    <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
    <link rel="stylesheet" type="text/css" href="assets/vendors/bootstrap-select/bootstrap-select.min.css">
</head>
<body class="ttr-opened-sidebar ttr-pinned-sidebar">
    <%@include file="setting-header.jsp" %>
    <main class="ttr-wrapper">
        <div class="container-fluid">
            <div class="db-breadcrumb">
                <!-- Breadcrumb content -->
            </div>
            <div class="row">
                <div class="col-lg-12 m-b30">
                    <div class="widget-box">
                        <div class="email-wrapper">
                            <div class="mail-toolbar">
                                <div class="row">
                                    <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                        <form action="YourServletURL" method="get">
                                            <input type="text" class="form-control" name="search" placeholder="Search by Class Code or Teacher" />
                                        </form>
                                    </div>
                                    <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                        <select name="subject" class="form-control">
                                            <option value="">Select Subject</option>
                                            <c:forEach var="subjects" items="${subjects}">
                                                <option value="${subjects.subjectCode}">${subjects.subjectCode}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-12 col-sm-2 col-md-2 col-lg-1">
                                        <form action="YourServletURL" method="get">
                                            <button class="btn btn-primary">Search</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="mail-box-list">
                                <section id="classList">
                                    <form action="activateDeactivateClasses" method="post">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Select</th>
                                                    <th scope="col">Class Code</th>
                                                    <th scope="col">Subject</th>
                                                    <th scope="col">Teacher ID</th>
                                                    <th scope="col">Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="classObj" items="${classes}">
                                                    <tr>
                                                        <td><input type="checkbox" name="selectedClasses" value="${classObj.ID}" /></td>
                                                        <td><c:out value="${classObj.classCode}" /></td>
                                                        <td>
                                                            <c:forEach var="subjects" items="${subjects}">
                                                                <c:if test="${subjects.subjectId eq classObj.subjectID}">
                                                                    <c:out value="${subjects.subjectCode}" />
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td><c:out value="${classObj.trainerID}" /></td>
                                                        <td><c:out value="${classObj.status ? 'Active' : 'Inactive'}" /></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </form>
                                </section>
                                <div class="row">
                                    <div class="col-12">
                                        <a class="btn btn-success" href="addNewClass.jsp">Add New Class</a>
                                    </div>
                                    <div class="col-12">
                                        <form action="YourServletURL" method="post">
                                            <button class="btn btn-secondary">Activate/Deactivate</button>
                                        </form>
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
    <script src="assets/js/functions.js"></script>
</body>
</html>
