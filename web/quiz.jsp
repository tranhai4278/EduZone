<%-- 
    Document   : edit_subject
    Created on : Sep 24, 2023, 11:58:15 PM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
    <head>
        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduZone : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduZone : Education HTML Template" />
        <meta property="og:description" content="EduZone : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduZone : Education HTML Template </title>

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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <script>
            $(document).ready(function () {

            });
        </script>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">


        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <!--sidebar menu toggler start -->
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <!--sidebar menu toggler end -->
                <!--logo start -->
                <div class="ttr-logo-box">
                    <div>
                        <a href="home" class="ttr-logo">
                            <img alt="" class="ttr-logo-mobile" src="assets/images/logo.png" width="30" height="15">
                            <img alt="" class="ttr-logo-desktop" src="assets/images/logo.png" width="70" height="27">
                        </a>
                    </div>
                </div>
                <!--logo end -->
                <div class="ttr-header-menu">
                    <!-- header left menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="home" class="ttr-material-button ttr-submenu-toggle">HOME</a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                            </div>
                        </li>
                    </ul>
                    <!-- header left menu end -->
                </div>
                <div class="ttr-header-right ttr-with-seperator">
                    <!-- header right menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="assets/images/testimonials/pic3.jpg" width="32" height="32"></span></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="profile">My profile</a></li>
                                    <li><a href="list-view-calendar.html">Activity</a></li>
                                    <li><a href="mailbox.html">Messages</a></li>
                                    <li><a href="logout">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <!-- header right menu end -->
                </div>

            </div>
        </header>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <div class="ttr-sidebar">
            <div class="ttr-sidebar-wrapper content-scroll">
                <!-- side menu logo start -->
                <div class="row">
                    <div class="col-9" style="text-align: center ; margin: 13px" >
                        <div class="row">
                            <div class="col">
                                ${detail.subjectCode}
                                <div class="col">
                                    ${detail.subjectName}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-2" >
                        <div class="ttr-sidebar-toggle-button">
                            <i class="ti-arrow-left"></i>
                        </div>
                    </div>
                </div>

                <!-- side menu logo end -->
                <!-- sidebar menu start -->
                <nav class="ttr-sidebar-navi">
                    <ul>


                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-pencil-alt2"></i></span>
                                <span class="ttr-label">Grades</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-comments-smiley"></i></span>
                                <span class="ttr-label">Discussion</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- header end -->

        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="col-lg-12 m-b30">
                    <h1>Quiz</h1>

                    <div class="widget-box">
                        <div class="email-wrapper">
                            <div class="email-menu-bar">
                                <div class="email-menu-bar-inner">
                                    <ul>
                                        <li class="active"><a href="mailbox.html"><i class="fa fa-envelope-o"></i>Inbox <span class="badge badge-success">8</span></a></li>
                                        <li><a href="mailbox.html"><i class="fa fa-send-o"></i>Sent</a></li>
                                        <li><a href="mailbox.html"><i class="fa fa-file-text-o"></i>Drafts <span class="badge badge-warning">8</span></a></li>
                                        <li><a href="mailbox.html"><i class="fa fa-cloud-upload"></i>Outbox <span class="badge badge-danger">8</span></a></li>
                                        <li><a href="mailbox.html"><i class="fa fa-trash-o"></i>Trash</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="email-wrapper">
                                <div class="col-9">
                                    <div class="question ml-sm-5 pl-sm-5 pt-2">
                                        <div class="py-2 h5"><b>Q. which option best describes your job role?</b></div>
                                        <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options">
                                            <label class="options">Small Business Owner or Employee
                                                <input type="radio" name="radio">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="options">Nonprofit Owner or Employee
                                                <input type="radio" name="radio">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="options">Journalist or Activist
                                                <input type="radio" name="radio">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="options">Other
                                                <input type="radio" name="radio">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="d-flex align-items-center pt-3">
                                        <div id="prev">
                                            <button class="btn btn-primary">Previous</button>
                                        </div>
                                        <div class="ml-auto mr-sm-5">
                                            <button class="btn btn-success">Next</button>
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
        <script src='assets/vendors/switcher/switcher.js'></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>