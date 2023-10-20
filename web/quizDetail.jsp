<%-- 
    Document   : quizDetail
    Created on : Oct 20, 2023, 12:00:13 AM
    Author     : MinhDQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <style>
            /* CSS cho hộp thoại popup */
            #randomPopup {
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background: #fff;
                padding: 20px;
                border: 1px solid #ccc;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
                z-index: 2;
            }
        </style>
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
                        <li>New Quiz</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="mail-list-container">
                                    <div class="mail-toolbar">
                                        <div class="container">
                                            <form id="quizForm" action="/eduzone/newquiz" method="post">
                                                <!-- Các trường thông tin cho Quiz -->
                                                <div class="form-group">
                                                    <label for="quizTitle">Quiz title:</label>
                                                    <input type="text" class="form-control" id="quizTitle" name="quizTitle" required>
                                                </div>
                                                <div class="form-group">
                                                    <label for="subject">Subject:</label>
                                                    <select class="form-control" id="subject" name="subject">
                                                        <c:forEach var="s" items="${listS}">
                                                            <option value="subject1"><c:out value="${s.subjectName}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

<!--                                                <div class="form-group">
                                                    <label for="chapter">Chapter:</label>
                                                    <select class="form-control" id="chapter" name="chapter">
                                                        <c:forEach var="q" items="${listQ}">
                                                            <option value="chapter1"><c:out value="${q.chapterId}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>-->
                                                <div class="form-group">
                                                    <label for="questionType">Question list:</label>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                                        <label class="form-check-label" for="inlineRadio1">Random</label>
                                                    </div>
                                                    <div class="form-check form-check-inline">
                                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                                        <label class="form-check-label" for="inlineRadio2">Fix</label>
                                                    </div>
                                                </div>
                                                <button type="submit" class="btn btn-primary btn-block" id="createQuiz">Create</button>
                                            </form>
<!--                                            <div id="randomPopup">
                                                 Popup cho tùy chọn Random 
                                                <h2>Random Options</h2>
                                                <div class="form-group">
                                                    <label for="dimension">Dimension:</label>
                                                    <select class="form-control" id="chapter" name="chapter">
                                                        <c:forEach var="d" items="${listD}">
                                                            <option value="dimension1"><c:out value="${d.dimensionId}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                
                                                <label for="numberOfQuestions">Number of Questions:</label>
                                                <input type="number" id="numberOfQuestions">
                                                <br>
                                                <button id="randomSubmit">Create</button>
                                            </div>-->

                                        </div> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

<!--                <div id="questionTable" style="display: none;">
                    <div class="mail-box-list">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Question</th>
                                    <th scope="col">Lesson ID</th>
                                    <th scope="col">Chapter ID</th>
                                    <th scope="col">Subject ID</th>
                                    <th scope="col">Create At</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="q" items="${listQ}">
                                    <tr>
                                        <td><c:out value="${q.question}"/></td>
                                        <td><c:out value="${q.lessonId}"/></td>
                                        <td><c:out value="${q.chapterId}"/></td>
                                        <td><c:out value="${q.subjectId}"/></td>
                                        <td><c:out value="${q.createAt}"/></td>
                                        <td><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <button type="submit" class="btn btn-primary btn-block" id="backQuiz">Back</button>
                        <button type="submit" class="btn btn-primary btn-block" id="CreateQuiz">Create</button>
                    </div>

                </div>-->
        </main>
        <div class="ttr-overlay"></div>

<!--        <script>
            document.addEventListener("DOMContentLoaded", function () {
                const quizForm = document.getElementById("quizForm");
                const randomPopup = document.getElementById("randomPopup");
                const questionTable = document.getElementById("questionTable");
                const randomRadio = document.getElementById("inlineRadio1");
                const fixedRadio = document.getElementById("inlineRadio2");
                const randomSubmitButton = document.getElementById("randomSubmit");
                const createQuizButton = document.getElementById("createQuiz");
                const backQuizButton = document.getElementById("backQuiz");

                // Ẩn mặc định randomPopup và createQuizButton
                randomPopup.style.display = "none";


                randomRadio.addEventListener("change", function () {
                    if (randomRadio.checked) {
                        randomPopup.style.display = "block";
                        createQuizButton.style.display = "none";
                    }
                });

                fixedRadio.addEventListener("change", function () {
                    if (fixedRadio.checked) {
                        randomPopup.style.display = "none";
                        createQuizButton.style.display = "block";
                    }
                });

                createQuizButton.addEventListener("click", function (e) {
                    e.preventDefault();
                    // Kiểm tra xem radio "Fix" đã được chọn
                    if (fixedRadio.checked) {
                        quizForm.style.display = "none";
                        randomPopup.style.display = "none";
                        questionTable.style.display = "block";
                    }
                });
                backQuizButton.addEventListener("click", function (e) {
                    e.preventDefault();
                    // Khi người dùng nhấn nút "Back," hiển thị lại form và ẩn bảng danh sách câu hỏi
                    quizForm.style.display = "block";
                    questionTable.style.display = "none";
                });

                randomSubmitButton.addEventListener("click", function (e) {
                    e.preventDefault();
                    randomPopup.style.display = "none";
                });
            });
        </script>-->

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


