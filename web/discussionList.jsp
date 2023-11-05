<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Questions List </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
        <link rel="stylesheet" href="assets/css/questionListStyle.css" />
        <style>
            .no-display img {
                display: none;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Manager Page</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Discussion List</li>
                    </ul>
                </div>	
                <div class="row">
                    <div class="table">
                        <section class="table__header" style="margin-left: 12px; height: 40px; width: 99.8%;">
                            <div style="display: flex;">
                                <div class="input-group" style="height: 40px; width: 450px; border-radius: 1px;">
                                    <input type="search" placeholder="Search Data...">
                                    <img src="assets/images/search.png" alt="">
                                </div>
                                <div style="height: 40px; width: 40%; margin-left: 30px;">
                                    <select>
                                        <option>1</option>
                                    </select>
                                </div>
                                <div style="height: 40px; width: 40%; margin-left: 30px;">
                                    <select>
                                        <option>1</option>
                                    </select>
                                </div>
                            </div>

                            <div class="">
                                <div class="">
                                    <div class="row">
                                        <div class="col-12 col-sm-7 col-md-7 col-lg-7">
                                            <a class="btn" href="addQuestion">Add new question</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <section class="table__body" style="border-radius: 1px;">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID <span class="icon-arrow">&UpArrow;</span></th>
                                        <th>Title <span class="icon-arrow">&UpArrow;</span></th>
                                        <th>Subject <span class="icon-arrow">&UpArrow;</span></th>
                                        <th>Class <span class="icon-arrow">&UpArrow;</span></th>
                                        <th>Poster <span class="icon-arrow">&UpArrow;</span></th>
                                        <th>Time <span class="icon-arrow">&UpArrow;</span></th>
                                        <th>Status <span class="icon-arrow">&UpArrow;</span></th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td><a href="#">Edit</a></td>
                                        </tr>
                                </tbody>
                            </table>
                        </section>
                    </div>
                    <!-- Your Profile Views Chart END-->
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
        <script src="assets/js/questionListJS.js"></script>
    </body>
</html>