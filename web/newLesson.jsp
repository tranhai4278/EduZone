<%-- 
    Document   : lessonDetail
    Created on : Oct 17, 2023, 11:26:08 PM
    Author     : PHAM NGOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="lessonDAO" value="<%= new dal.LessonDAO() %>" />
<c:set var="subjectDAO" value="<%= new dal.SubjectDAO() %>" />
<c:set var="subjectSettingDAO" value="<%= new dal.SubjectSettingDAO() %>" />
<c:set var="quizDAO" value="<%= new dal.QuizDAO() %>" />
<%@page import="model.Lesson" %>
<%@page import="model.Subject" %>
<%@page import="model.Quiz" %>


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
                                <form class="edit-profile m-b30" action="addLesson" method="post">
                                    <div class="row">

                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject* </label>
                                            <div>
                                                <select name="subject" required="true">
                                                    <c:forEach items="${subjectDAO.getAllSubjects()}" var="subject">
                                                        <option value="${subject.subjectId}">${subject.subjectName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Chapter* </label>
                                            <div>
                                                <select name="chapter" required="true">
                                                    <c:forEach items="${subjectSettingDAO.getAllChapters()}" var="subjectSetting">
                                                        <option value="${subjectSetting.settingId}">${subjectSetting.settingName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Lesson type*</label>
                                            <div>
                                                <select name="type" id="lessonType" required="true">
                                                    <option value="Video" >Video</option>
                                                    <option value="Quiz">Quiz</option>
                                                    <option value="Assignment">Assignment</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Status* </label>
                                            <div>
                                                <select name="status" required="true">
                                                    <option value="0">Unpublished</option>
                                                    <option value="1">Published</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Lesson title* </label>
                                            <div>
                                                <input class="form-control" type="text" name="title" required="true">
                                            </div>
                                        </div>
                                        <div class="form-group col-12" id="videoSection">
                                            <label class="col-form-label">Video link</label>
                                            <div>
                                                <input class="form-control" type="text" name="video">
                                            </div>
                                        </div>
                                        <div class="form-group col-12" id="quizSection">
                                            <label class="col-form-label">Quiz</label>
                                            <div>
                                                <select name="quiz">
                                                    <c:forEach items="${quizDAO.getAllQuizes()}" var="quiz">
                                                        <option value="${quiz.getQuizId()}">${quiz.getQuizName()}</option>
                                                    </c:forEach>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="form-group col-10" id="fileSection">
                                            <label class="col-form-label">File attack</label>
                                            <div>
                                                <input class="form-control" type="text" name="file">
                                            </div>
                                        </div>
                                        <div class="form-group col-2" id="browseButton">
                                            <label class="col-form-label"></label>
                                            <div>
                                                <button type="button" class="btn">Browse</button>
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Description</label>
                                            <div>
                                                <textarea class="form-control" type="text" name="des"> </textarea>
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
        <script>
        document.getElementById('lessonType').addEventListener('change', function () {
        var selectedType = this.value;
        // Hiển thị phần tử tương ứng
        if (selectedType === 'Video') {
            document.getElementById('videoSection').style.display = 'block';
            document.getElementById('quizSection').style.display = 'none';
            document.getElementById('fileSection').style.display = 'none';
            document.getElementById('browseButton').style.display = 'none';
        } else if (selectedType === 'Quiz') {
            document.getElementById('quizSection').style.display = 'block';
            document.getElementById('videoSection').style.display = 'none';
            document.getElementById('fileSection').style.display = 'none';
            document.getElementById('browseButton').style.display = 'none';
        } else if (selectedType === 'Assignment') {
            document.getElementById('fileSection').style.display = 'block';
            document.getElementById('browseButton').style.display = 'block';
            document.getElementById('videoSection').style.display = 'none';
            document.getElementById('quizSection').style.display = 'none';
        }
    });
        </script>

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
