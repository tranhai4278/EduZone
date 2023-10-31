<%-- 
    Document   : quizList
    Created on : Oct 19, 2023, 6:06:41 PM
    Author     : MinhDQ
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h4 class="breadcrumb-title">Quiz</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Quiz List</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="mail-list-container">
                                    <div class="mail-toolbar">
<!--                                        <div class="dropdown all-msg-toolbar">
                                            <select name="subject" class="input-select">
                                                <option>All Status</option>
                                                <option value="0">Inactive</option>
                                                <option value="1">Active</option>
                                            </select>
                                        </div> 
                                        <div class="mail-search-bar">
                                            <input type="text" class="form-control" placeholder="Search"/>
                                        </div>
                                        <div class="dropdown all-msg-toolbar">
                                            <span class="btn btn-info-icon" data-toggle="dropdown"><i class="fa fa-ellipsis-v"></i></span>
                                            <ul class="dropdown-menu">
                                                <li><a href="#"><i class="fa fa-arrow-down"></i>A-Z</a></li>
                                                <li><a href="#"><i class="fa fa-arrow-up"></i>Z-A</a></li>
                                            </ul>
                                        </div>-->
                                        <div class="">
                                            <div class="">
                                                <div class="row">
                                                    <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                    </div>
                                                    <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                        <a class="btn" href="/eduzone/newquiz">
                                                            New Quiz   
                                                        </a></td>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="next-prev-btn">
                                            <a href="#"><i class="fa fa-angle-left"></i></a>
                                            <a href="#"><i class="fa fa-angle-right"></i></a>
                                        </div>

                                    </div>

                                    <div class="mail-box-list">
                                        <section id="subject">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Title</th>
                                                        <th scope="col">Subject</th>
                                                        <th scope="col">Type</th>
                                                        <th scope="col">Number of Question</th>
                                                        <th scope="col">Action</th>
                                                        
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="q" items="${listQ}">
                                                        <tr>
                                                            <td><c:out value="${q.quizName}"/></td>
                                                            <td><c:out value="${q.subjectId}"/></td>     
                                                            <td><c:out value="${q.quizType ? 'Random' : 'Fix'}"/></td>
                                                            <td><c:out value="${q.numberQuestion}"/></td>
                                                            <td><a href="/eduzone/quizdetail">Edit</a></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </section>
                                    </div>
                                </div>
                            </div> 
                        </div>
                        <!-- Your Profile Views Chart END-->
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

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>

