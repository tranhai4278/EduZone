<%-- 
    Document   : admin
    Created on : Sep 24, 2023, 12:30:41 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="assignDAO" value="<%= new dal.AssignmentDAO() %>" />
<%@page import="model.AssignmentSubmit" %>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>



<!DOCTYPE html>
<html lang="en">

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
        <meta property="og:title" content="EduNext : Education HTML Template" />
        <meta property="og:description" content="EduNext : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="subject-header.jsp" %>
        <main class="ttr-wrapper">
            <c:if test="${not empty requestScope.error}">
                <div class="alert alert-danger" id="notificationMessage" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="True">&times;</span>
                    </button>
                    ${requestScope.error}
                </div>
            </c:if>
            <c:if test="${not empty requestScope.successMessage}">
                <div class="alert alert-success" id="notificationMessage" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="True">&times;</span>
                    </button>
                    ${requestScope.successMessage}
                </div>
            </c:if>
            <form action="setting" method="post" id="form">
                <div class="container-fluid">
                    <div class="db-breadcrumb">
                        <h4 class="breadcrumb-title">Setting</h4>
                        <ul class="db-breadcrumb-list">
                            <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                            <li>Setting</li>
                        </ul>
                    </div>	
                    <div class="row">
                        <!-- Your Profile Views Chart -->
                        <div class="col-lg-12 m-b30">
                            <div class="widget-box">
                                <div class="email-wrapper">
                                    <div class="mail-list-container">
                                    </div>
                                </div>
                                <div class="mail-box-list">
                                    <section id="role">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Assignment</th>
                                                    <th scope="col">File</th>
                                                    <th scope="col">Mark</th>
                                                    <th scope="col">Status</th>
                                                    <th scope="col">Detail</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="a" items="${data}">
                                                    <tr>
                                                        <td>${a.title}</td>
                                                        
                                                        <td>
                                                            <a href="#" download="${a.submit_file}" onclick="showFileList('${a.submit_file}')">${a.submit_file}</a>                                                        </td>
                                                        <td>${a.mark}</td>
                                                        <td>
                                                            ${a.status == true ? "Submitted" : "Not Submitted"}
                                                        </td>
                                                        <td>
                                                            <a href="assignmentdetail?assignmentId=${a.asignment_id}&classId=${a.class_id}&userId=${a.trainee_id}&sid=${sid}" class="btn btn-primary">Assignment Detail</a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </section>
                                </div>

                                <c:if test="${totalPage!=0}">
                                    <nav aria-label="Page navigation example" style="margin-top: 20px;">
                                        <ul class="pagination justify-content-end">
                                            <li class="page-item ${pageNo == 1 ? ' disabled' : ' '}">
                                                <a class="page-link" style="cursor: pointer"
                                                   onclick="goToPage(${pageNo} - 1)">
                                                    <span aria-hidden="true">&laquo;</span>
                                                </a>
                                            </li>
                                            <input type="hidden" name="pageNo" id="pageNoInput" value="${pageNo}">
                                            <c:forEach begin="1" var="i" end="${totalPage}">
                                                <li class="page-item  ${pageNo == i  ? ' active' : ' '}">
                                                    <a class="page-link"  style="cursor: pointer"
                                                       onclick="goToPage(${i})">
                                                        ${i}
                                                    </a>
                                                </li>
                                            </c:forEach>
                                            <li class="page-item ${pageNo == (totalPage) ? ' disabled' : ' '}">
                                                <a class="page-link user-select-all" style="cursor: pointer"
                                                   onclick="goToPage(${pageNo+1})">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </c:if>
                            </div>

                        </div>
                    </div>
                </div>
            </form>

            <ul hidden id="fileList"></ul>


            <!-- Load Firebase and dependencies first -->
            <script type="module" src="assets/js/firebaseconfig.js"></script>
            <script type="module" src="assets/js/firebasedownload.js"></script>


            <!-- Load your script that uses downloadFile after Firebase modules -->
            <script type="module" src="assets/js/filebaselist.js"></script>

            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>


            <script>
                                                   function showFileList(submitFileName) {
                                                       // Get all file links
                                                       const fileLinks = document.querySelectorAll('ul#fileList li a');

                                                       // Loop through the links and hide/show them based on the text content
                                                       fileLinks.forEach((link) => {
                                                           if (link.textContent.includes(submitFileName)) {
                                                               link.style.display = 'inline';
                                                           } else {
                                                               link.style.display = 'none';
                                                           }
                                                       });
                                                   }
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
            <!--        <script>
                        $(document).ready(function () {
                            $('[data-toggle="tooltip"]').tooltip();
                        });
                    </script>-->
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>