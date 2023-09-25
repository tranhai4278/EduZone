<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="cssconnect.jsp" %>
<%@ page import="dal.UserDAO" %>
<%@ page import="model.User" %>
<%@ page import="dal.SubjectDAO" %>
<%@ page import="model.Subject" %>
<%@ page import="java.util.ArrayList" %>

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
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <style>


            .subject-result-box ul li {
                list-style: none;
                border-radius: 3px;
                padding: 15px 10px;
                cursor: pointer;
            }

            .subject-result-box ul li:hover {
                background: #e9f3ff;
            }

            .subject-result-box {
                max-height: 150px;
                overflow-y: scroll;
            }
        </style>

    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <%@include file="header.jsp" %>
            <!-- header END ==== -->

            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner3.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Our Subjects</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Our Subjects</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">

                                    <!--Search Box-->
                                    <div class="widget courses-search-bx placeani">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <!--<label>Search Subjects</label>-->
                                                <form id="subject-search-form" action="SubjectList" method="POST">
                                                    <input name="search" type="text" id="subject-input-box" placeholder="Search subject" class="form-control" autocomplete="off">
                                                    <input type="submit" style="display: none;">
                                                    <div class="subject-result-box">
                                                    </div>
                                                </form>
                                            </div>
                                        </div>

                                    </div>
                                    <!--End Search Box-->

                                    <div class="widget widget_archive">
                                        <h5 class="widget-title style-1">All Subjects</h5>
                                        <ul>
                                            <li class="active"><a href="#">General</a></li>
                                            <li><a href="#">IT & Software</a></li>
                                            <li><a href="#">Photography</a></li>
                                            <li><a href="#">Programming Language</a></li>
                                            <li><a href="#">Technology</a></li>
                                        </ul>
                                    </div>
                                    <div class="widget">
                                        <a href="#"><img src="assets/images/adv/adv.jpg" alt=""/></a>
                                    </div>
                                    <div class="widget recent-posts-entry widget-courses">
                                        <h5 class="widget-title style-1">Recent Subjects</h5>
                                        <div class="widget-post-bx">

                                            <c:forEach var="subject" items="${subjectList}">
                                                <div class="widget-post clearfix">
                                                    <div class="ttr-post-media"> <img src="${subject.getImgUrl()}" width="200" height="143" alt=""> </div>
                                                    <div class="ttr-post-info">
                                                        <div class="ttr-post-header">
                                                            <h6 class="post-title"><a href="#">${subject.getSubjectName()}</a></h6>
                                                        </div>
                                                        <div class="ttr-post-meta">
                                                            <ul>
                                                                <li class="price">
                                                                <h8>
                                                                    <c:forEach var="user" items="${userList}">
                                                                        <c:if test="${subject.getManagerId() eq user.getUserId()}">
                                                                            Instructor ${user.getFullName()}
                                                                        </c:if>
                                                                    </c:forEach>
                                                                </h8>
                                                                </li>
                                                                <li class="review">03 Review</li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>

                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="row">

                                        <c:forEach var="subject" items="${subjectList}">

                                            <div class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                                <div class="cours-bx">
                                                    <div class="action-box">
                                                        <img src="${subject.getImgUrl()}" alt="">
                                                        <a href="#" class="btn">Read More</a>
                                                    </div>
                                                    <div class="info-bx text-center">
                                                        <h5><a href="#">${subject.getSubjectName()}</a></h5>
                                                        <span>${subject.getSubjectCode()}</span>
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
                                                            <h7>Instructor</h7>
                                                            <br>
                                                            <h8>
                                                                <c:forEach var="user" items="${userList}">
                                                                    <c:if test="${subject.getManagerId() eq user.getUserId()}">
                                                                        ${user.getFullName()}
                                                                    </c:if>
                                                                </c:forEach>
                                                            </h8>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- contact area END -->

            </div>
            <!-- Content END-->

            <!-- Footer ==== -->
            <%@include file="footer.jsp" %>
            <!-- Footer END ==== -->

            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>
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
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
    </body>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        let availableSubjects = [
            'sss',
            'sedf'
        ];

        <%
        SubjectDAO subjectDAO2 = new SubjectDAO();
        ArrayList<String> SubjectNameList2 = subjectDAO2.getAllSubjectNames();
        ArrayList<String> SubjectCodeList2 = subjectDAO2.getAllSubjectCodes();   
        
        for (String subjectName2 : SubjectNameList2) {
        %>
        availableSubjects.push("<%= subjectName2 %>");
        <%
        }

        for (String subjectCode2 : SubjectCodeList2) {
        %>
        availableSubjects.push("<%= subjectCode2 %>");
        <%
        }
        %>



        $(document).ready(function () {
            $('#subject-input-box').keypress(function (e) {
                if (e.which === 13) { // 13 is the key code for Enter
                    e.preventDefault(); // Prevent the default form submission
                    $('#subject-search-form').submit(); // Trigger the form submission
                }
            });
        });
    </script>
    <script src="assets/js/autocomplete-subject-only.js"></script>

</html>
