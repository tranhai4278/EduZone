<%-- 
    Document   : edit_subject
    Created on : Sep 24, 2023, 11:58:15 PM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">

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
    <body class=" ttr-pinned-sidebar">


        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <div class="ttr-logo-box">
                    <div>
                        <a href="" class="ttr-logo">
                            <img alt="" class="ttr-logo-mobile" src="assets/images/logo.png" width="30" height="15">
                            <img alt="" class="ttr-logo-desktop" src="assets/images/logo.png" width="70" height="27">
                        </a>
                    </div>
                </div>
                <!--logo end -->
                <div class="ttr-header-menu">
                    <div id="countdown"></div>
                </div>


            </div>
        </header>
        <!-- header end -->
        <!-- Left sidebar menu start -->

        <main class="ttr-wrapper">

            <div class="container-fluid">
                <div class="col-lg-12 m-b30">
                    <h1>${detail.quizName}</h1>

                    <div class="widget-box">
                        <div class="email-wrapper" style="border-bottom: solid gray 1px">
                            <div class="col-2" style="border-right:  solid gray 1px">
                                <div class="email-menu-bar-inner" >
                                    <ul>
                                        <h4>Quesion </h4>
                                    </ul>
                                </div>
                            </div>
                            <div class="col">
                                <div class=" ml-sm-5 " >
                                    <div  style="border-bottom: solid gray 1px"><b>${quession.getQuestion()}</b></div>
                                    <p>Chosse one:</p>
                                    <div class="ml-md-3"  id="options">
                                        <c:forEach var="c" items="${listC}">
                                            <input type="radio" name="radio" value="${c.choiceId}" >${c.choice} </br>
                                        </c:forEach>
                                    </div>

                                </div>
                                <div class="d-flex align-items-center pt-3">
                                    <div id="prev">
                                        <button class="btn btn-primary" id="prevBtn" onclick="prevBtn()">Previous</button>
                                    </div>
                                    <div class="ml-auto mr-sm-5">
                                        <button class="btn btn-success" onclick="nextBtn()">Next</button>
                                    </div>
                                </div> 
                            </div>
                            <div class="col-2" style="border-left: solid gray 1px ">
                                <div class="email-menu-bar-inner">
                                    <p>Quiz navigation</p>
                                    <div class="row">
                                        <div class="col">
                                            <c:forEach var="a" begin="1" end="${detail.numberQuestion}">
                                                <a class="btn m-1"  ${que == a ? 'style="background-color: purple" ' : ' '} href="quiz?qid=${detail.quizId}&que=${a}"" >${a}</a>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <a href="h"><i>Finish Test</i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <script>
            var currentQuestion = ${que};
            var totalQuestions = ${detail.numberQuestion};
            $(document).ready(function () {
                if (currentQuestion === 1) {
                    $('#prevBtn').hide();
                }
            });
            function prevBtn() {
                if (currentQuestion > 1) {
                    currentQuestion--;
                    updateQuestion(currentQuestion); // Cập nhật giao diện cho câu hỏi mới
                }

            }
            function nextBtn() {
                if (currentQuestion < totalQuestions) {
                    currentQuestion++;
                    updateQuestion(currentQuestion);
                }
            }
            console.log(currentQuestion);
            function updateQuestion(questionNumber) {
                window.location.href = 'quiz?qid=${detail.quizId}&que=' + questionNumber;
            }
        </script>
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