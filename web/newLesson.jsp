<%-- 
    Document   : lessonDetail
    Created on : Oct 17, 2023, 11:26:08 PM
    Author     : PHAM NGOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="lessonDAO" value="<%= new dal.LessonDAO() %>" />
<c:set var="subjectDAO" value="<%= new dal.SubjectDAO() %>" />
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
                                <h4>Lesson Details</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30">
                                    <div class="row">
                                        
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject</label>
                                            <div>
                                                <select name="subject">
                                                    <option></option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Chapter</label>
                                            <div>
                                                <select name="chapter">
                                                    <option value="" ${user.getRoleId() == 1 ? "selected" : ""}>Chap 1</option>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Lesson type</label>
                                            <div>
                                                <select name="type">
                                                    <option value="Video" ${user.getRoleId() == 1 ? "selected" : ""}>Video</option>
                                                    <option value="Quiz" ${user.getRoleId() == 1 ? "selected" : ""}>Quiz</option>
                                                    <option value="Assignment" ${user.getRoleId() == 1 ? "selected" : ""}>Assignment</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Status</label>
                                            <div>
                                                <select name="chapter">
                                                    <option value="0" ${user.isStatus() == false ? "selected" : ""}>Unpublished</option>
                                                    <option value="1" ${user.isStatus() == true ? "selected" : ""}>Published</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Lesson title</label>
                                            <div>
                                                <input class="form-control" type="text" name="title" value="">
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Video link</label>
                                            <div>
                                                <input class="form-control" type="text" name="video" value="">
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Quiz</label>
                                            <div>
                                                <select name="quiz">
                                                    <option value="" ${user.getRoleId() == 1 ? "selected" : ""}>Quiz</option>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="form-group col-10">
                                            <label class="col-form-label">File attack</label>
                                            <div>
                                                <input class="form-control" type="text" name="file" value="">
                                            </div>
                                        </div>
                                        <div class="form-group col-2">
                                            <label class="col-form-label"></label>
                                            <div>
                                                <button type="button" class="btn">Browse</button>
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Description</label>
                                            <div>
                                                <textarea class="form-control"> </textarea>
                                            </div>
                                        </div>
                                        
                                        <div class="col-12">
                                            <button type="submit" class="btn">Save</button>
                                            <button type="reset" class="btn-secondry">Cancel</button>
                                        </div>
                                    </div>
                                </form>
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
