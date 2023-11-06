<%-- 
    Document   : lessonDetail
    Created on : Oct 17, 2023, 11:26:08 PM
    Author     : PHAM NGOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="lessonDAO" value="<%= new dal.LessonDAO() %>" />
<%@page import="model.Lesson" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Lesson List</h4>
                            </div>
                            
                            <div class="col-sm-10"> 
                                <div class="row">
                                    <div class="col-12 col-sm-9 col-md-9 col-lg-3">
                                        <a class="btn" href="newLesson.jsp">
                                            Add a new lesson 
                                        </a> 
                                    </div>
                                    <form action="searchLesson" method="post">
                                        <div class="row">
                                            <p>Search by</p>
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-4">
                                                <select name="criteria">
                                                    <option value="subject_name">Subject Name</option>
                                                    <option value="setting_name">Chapter</option>
                                                    <option value="title">Lesson title</option>
                                                    <option value="lesson_type">Lesson type</option>
                                                </select>
                                            </div>
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-4">
                                                <input type="text" class="form-control" name="key" placeholder="Search key" />
                                            </div>
                                            <div class="col-12 col-sm-3 col-md-3 col-lg-1">
                                                <input type="submit" class="btn btn-primary" value="Search" />
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="mail-box-list">
                                <section id="subject">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Lesson title</th>
                                                        <th scope="col">Subject</th>
                                                        <th scope="col">Chapter</th>
                                                        <th scope="col">Lesson Content</th>
                                                        <th scope="col">Lesson Type</th>
<!--                                                        <th scope="col">Status</th>-->
                                                        <th scope="col">Detail</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="l" items="${list}">
                                                        <tr>
                                                            <td><c:out value="${l.title}"/></td>
                                                            <td><c:out value="${lessonDAO.getSubjectName(l.lessonId)}"/></td>
                                                            <td><c:out value="${lessonDAO.getChapterName(l.lessonId)}"/></td>
                                                            <td>
                                                                <c:choose>
                                                                    <c:when test="${l.getLessonType() eq 'Video'}">
                                                                        <c:out value="${l.videoLink}"/>
                                                                    </c:when>
                                                                    <c:when test="${l.getLessonType() eq 'Quiz'}">
                                                                        <c:out value="${lessonDAO.getQuizName(l.lessonId)}"/>
                                                                    </c:when>
                                                                    <c:when test="${l.getLessonType() eq 'Assignment'}">
                                                                        <c:out value="${l.file}"/>
                                                                    </c:when>
                                                                </c:choose> 
                                                            </td>
                                                            <td><c:out value="${l.lessonType}"/></td>
                                                            <td><a href="lessonDetail?lessonId=${l.lessonId}" class="btn">View</a>
                                                                </a></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </section>
                                    </div>
                            <div class="modal fade review-bx-reply" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Reply to review</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <textarea class="form-control" placeholder="Type text"></textarea>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn mr-auto">Reply</button>
                                        </div>
                                    </div>
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
        <script src='assets/vendors/calendar/moment.min.js'></script>
        <script src='assets/vendors/calendar/fullcalendar.js'></script>
        <script src='assets/vendors/switcher/switcher.js'></script>

    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
