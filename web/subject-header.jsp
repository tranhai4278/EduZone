<%-- 
    Document   : onlineLearning-header
    Created on : Nov 7, 2023, 2:58:11 AM
    Author     : MinhDQ
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

        <meta name="description" content="EduZone : Education HTML Template" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <meta property="og:title" content="EduZone : Education HTML Template" />
        <meta property="og:description" content="EduZone : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
    </head>
    <script>
        $(document).ready(function () {
            // Ẩn toàn bộ các thông tin khi trang tải

            $('#videoSection').hide();
            $('#quizSection').hide();
            $('#fileSection').hide();
        });
    </script>

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
            <nav class="ttr-sidebar-navi">
                <ul>
                    <form action="onlineLearning"  method ="post">
                        <input hidden="" name="sid" value="${detail.subjectId}" />
                        <li>
                            <div id="class">
                                <select
                                    name="classid"
                                    id="class"
                                    onchange="this.form.submit()"
                                    >
                                    <c:forEach items="${listClass}" var="c">
                                        <option ${c.ID == classid ? 'selected' : ''} value="${c.ID}" >${c.classCode}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </li>
                    </form>
                    <c:forEach var="s" items="${listC}" >
                        <li>
                            <a onclick="getChapter(${s.settingId}, ${classid})" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">${s.settingName}</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i> </span>
                            </a>
                            <ul id="lesson_${s.settingId}">
                                
                            </ul>
                        </li>
                    </c:forEach>
                    <c:if test="${sessionScope.user.roleId != 4}">
                        <li>
                            <a href="#" class="ttr-material-button" data-bs-toggle="modal" data-bs-target="#lessonModal">
                                <span class="ttr-icon"><i class="ti-plus"></i></span>
                                <span class="ttr-label">New Lesson</span>
                            </a>
                        </li>
                    </c:if>
                    <li>
                        <a href="#" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-pencil-alt2"></i></span>
                            <span class="ttr-label">Grades</span>
                        </a>
                    </li>
                    <li>
                        <a href="discussionList?subjectId=${detail.subjectId}" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-comments"></i></span>
                            <span class="ttr-label">Discussion</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-file"></i></span>
                            <span class="ttr-label">Assignment</span>
                        </a>
                    </li>
                    <li>
                        <a href="practicequiz?sid=${detail.subjectId}" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-pencil-alt"></i></span>
                            <span class="ttr-label">Practice Quizzes</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- header end -->
    <div class="modal fade" id="lessonModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add Lesson<span style="color: red">*</span></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form class="edit-profile m-b30" action="extraLesson" method="post">
                        <input hidden="" name="sid" value="${detail.subjectId}" />
                        <input hidden="" name="cid" value="${classid}" />

                        <div class="row">
                            <div class="form-group col-6">
                                <label class="col-form-label">Chapter* </label>
                                <div>
                                    <select name="chapter" required="true">
                                        <c:forEach var="c"  items="${listC}">
                                            <option value="${c.settingId}">${c.settingName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-6">
                                <label class="col-form-label">Lesson type*</label>
                                <div>
                                    <select name="type" id="lessonType" required="true" onchange="getType(this)">
                                        <option value="0" >Choose lesson type</option>
                                        <option value="Video" >Video</option>
                                        <option value="Quiz">Quiz</option>
                                        <option value="Assignment">Assignment</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group col-12">
                                <label class="col-form-label">Lesson title* </label>
                                <div>
                                    <input class="form-control" type="text" name="title" required="" maxlength="50">
                                </div>
                            </div>
                            <div class="form-group col-12" id="videoSection">
                                <label class="col-form-label">Video link</label>
                                <div>
                                    <input class="form-control" type="text" name="video">
                                </div>
                            </div>
                            <div class="form-group col-12" id="quizSection">
                                <div>
                                    <label class="col-form-label">Quiz</label>
                                </div>
                                <div>
                                    <select name="quiz">
                                        <c:forEach var="quiz"  items="${listQuizzes}" >
                                            <option value="${quiz.getQuizId()}">${quiz.getQuizName()}</option>
                                        </c:forEach>
                                    </select> 
                                </div>
                                <div>
                                    <label class="col-form-label">Start Date</label>
                                    <input type="date" name="sdate" />
                                </div>
                                <div>
                                    <label class="col-form-label">End Date</label>
                                    <input type="date" name="edate" />
                                </div>
                            </div>
                            <div class="form-group col-6">
                                <label class="col-form-label">Display Order<span style="color: red">*</span></label>
                                <div>
                                    <input class="form-control" type="number"  name="displayOrder" required maxlength="11" >
                                </div>
                            </div>
                            <div class="form-group col-6">

                                <label class="col-form-label">Status</label>
                                <div class="form-check form-switch">
                                    <input name="on"  style="margin: 0" class="form-check-input" type="checkbox" ${detail.isStatus() ? 'checked' : ' '} >
                                </div>
                            </div>

                            <div>
                                <div class="form-group col-12" id="fileSection">
                                    <label class="col-form-label">File attachment</label>
                                    <div>
                                        <input class="form-control" type="file" name="file" accept=".pdf, .doc, .txt, .zip, .xls, .xlsx">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group col-12">
                                <label class="col-form-label">Description</label>
                                <div>
                                    <textarea class="form-control" type="text" name="des" > </textarea>
                                </div>
                            </div>
                            <div class="col-12">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                <button type="submit" onclick="setSellDate()" class="btn">Add</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
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
        function getChapter(cid, classid) {
            console.log(cid);
            $.ajax({
                url: "/eduzone/chapterLesson",
                type: "get",
                data: {
                    cid: cid,
                    classid: classid
                },
                success: function (data) {
                    var content = document.getElementById("lesson_" + cid);
                    content.innerHTML = data;
                },
                error: function (xhr) {
                    console.log('Lỗi');
                }
            });
        }

    </script>
    <!-- Left sidebar menu end -->