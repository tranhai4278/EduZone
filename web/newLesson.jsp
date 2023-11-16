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
<%@page import="com.google.gson.Gson" %>
<%@page import="com.google.gson.JsonObject" %>


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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <script>
            $(document).ready(function () {
                // Ẩn toàn bộ các thông tin khi trang tải

                $('#videoSection').hide();
                $('#quizSection').hide();
                $('#fileSection').hide();
            });
        </script>
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
                                <h4>Add new lesson</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="addLesson" method="post">
                                    <div class="row">
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject* </label>
                                            <div>
                                                <select name="subject" required="true" onchange="getSubject(this)">
                                                    <c:forEach items="${subjectDAO.getAllSubjects()}" var="subject">
                                                        <option value="${subject.subjectId}">${subject.subjectName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
<!--                                                                                                                        <div class="form-group col-6" id="chapterModal">
                                                                                                                        </div>-->
                                        <div class="form-group col-6" id="chapterModal">
                                            <label class="col-form-label">Chapter* </label>
                                            <div>
                                                <select name="chapter" required="true">
                                                </select>
                                            </div>
                                        </div>


                                        <div class="form-group col-6">
                                            <label class="col-form-label">Lesson type*</label>
                                            <div>
                                                <select name="type" id="lessonType" required="true" onchange="getType(this)">
                                                    <option value="0" >Type</option>
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
                                                    <c:forEach items="${quizDAO.getAllQuizzes() }" var="quiz">
                                                        <option value="${quiz.getQuizId()}">${quiz.getQuizName()}</option>
                                                    </c:forEach>
                                                </select> 
                                            </div>
                                        </div>
                                        
                                        <form action="upload" method="post" enctype="multipart/form-data">
                                            <div class="row" id="fileSection"> 
                                                <div class="form-group col-10">
                                                    <label class="col-form-label">File attachment</label>
                                                    <input class="form-control" type="file" id="file" name="file" required="true">
                                                </div>
                                                <div class="form-group col-2">
                                                    <label class="col-form-label"></label>
                                                    <div>
                                                        <input type="submit" class="btn" value="Upload">
                                                    </div>
                                                </div>
                                            </div>
                                        </form>

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


        <div class="ttr-overlay"></div>
        <script>
            function getType(selectElement) {
                var type = selectElement.value;
                if (type === "Video") {
                    $('#videoSection').show();
                    $('#quizSection').hide();
                    $('#fileSection').hide();
                } else if (type === "Quiz") {
                    $('#videoSection').hide();
                    $('#quizSection').show();
                    $('#fileSection').hide();
                } else if (type === "Assignment") {
                    $('#videoSection').hide();
                    $('#quizSection').hide();
                    $('#fileSection').show();
                } else {
                    $('#videoSection').hide();
                    $('#quizSection').hide();
                    $('#fileSection').hide();
                }
            }
        </script>
        <script>
            function getSubject(selectElement) {
                var subject = selectElement.value;
                $.ajax({
                    url: "/eduzone/getChapter",
                    type: "get",
                    data: {
                        subject: subject
                    },
                    success: function (data) {
                        $('#chapterModal').show();
                        var content = document.getElementById("chapterModal");
                        content.innerHTML = data;
                    },
                    error: function (xhr) {
                        // Xử lý lỗi ở đây nếu cần
                    }
                });
//            function getSubject(selectElement) {
//                var subject = selectElement.value;
//                $.ajax({
//                    url: "/eduzone/getChapter",
//                    type: "get",
//                    data: {
//                        subject: subject
//                    },
//                    dataType: "json",
//                    success: function (data) {
//                        var chapterModal = document.getElementById("chapterModal"); 
//                        chapterModal.innerHTML = "";
//
//                        var chapterSelect = document.createElement("select");
//                        chapterSelect.name = "chapter";
//                        chapterSelect.required = true;
//
//                        var chapters = data.chapters;
//                        for (var i = 0; i < chapters.length; i++) {
//                            var option = document.createElement("option");
//                            option.value = chapters[i].id;
//                            option.text = chapters[i].name;
//                            chapterSelect.appendChild(option);
//                        }
//
//                        chapterModal.appendChild(chapterSelect); 
//                    },
//                    error: function (xhr) {
//                        // Xử lý lỗi ở đây nếu cần
//                    }
//                });
//            }
//
//

        </script>
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
