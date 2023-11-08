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
        <title>${subjectCode}/${title}</title>

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
        <!-- include libraries(jQuery, bootstrap) -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>

            .container {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .row {
                width: 100%;
                display: flex;
                flex-direction: column;
            }

            .top, .mid, .bottom {
                padding-bottom: 10px;
                border: 1px solid #ccc;
            }

            .comment-box {
                width: 100%;
                margin: 0 auto;
                padding: 10px;
            }

            .bottom {
                width: 100%;
                margin: 0 auto;
            }

            .comment {
                width: 90%;
                margin: 0 auto;
                display: flex;
                flex-direction: column;
                align-items: flex-end;
            }

            .headpart {
                width: 100%;
                margin: 0 auto;
                display: flex;
                flex-direction: column;
            }

            .main-comment {
                width: 100%;
            }

            .reply {
                width: 96%;
                margin-top: 10px;
            }

            .comment-content {
                text-align: left;
                border: 1px solid black;
                border-radius: 10px;
            }

            .comment-content p {
                margin-left: 10px;
            }

            .reply-content {
                text-align: left;
                border: 1px solid black;
                border-radius: 10px;
            }

            .reply-content p {
                margin-left: 10px;
            }

            .main-name {
                height: 30px;
                text-align: left;
            }

            .reply-name {
                height: 30px;
                text-align: left;
            }

            .subject-headpart {
                margin: 0;
                padding: 0;
                background-color: lightgray;
            }

            .subject-headpart h4 {
                padding: 10px;
            }

            .description {
                padding-left: 30px;
            }

            .description p {
                padding-left: 10px;
            }

            .description img {
                height: 350px;
            }

        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <div class="order1">
            <%@include file="subject-header.jsp" %>
        </div>

        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Discussion Details</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Discussion Details</li>
                    </ul>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="top">
                            <div class="headpart">
                                <div class="subject-headpart">
                                    <h4>${subjectCode}/${subjectName}</h4>
                                </div>
                                <div>
                                    <h2 style="margin-left: 20px;">${title}</h2>
                                    <div class="description" style="margin-bottom: 20px;">${description}</div>
                                    <label><p style="margin-left: 30px; font-size: 16px;">Time: ${time}</p></label>
                                </div>
                            </div>
                        </div>

                        <c:choose>
                            <c:when test="${status == true}">
                                <div class="mid">
                                    <div style="margin-top: 10px; margin-left: 10px;">
                                        <label for="summernote"><h4>Comment:</h4></label>
                                        
                                        <form action="postComment" method="post" style="margin-left: 32px;">
                                            <input type="hidden" name="discussionId" value="${discussionId}" />
                                            <textarea id="summernote" name="comment"></textarea>
                                            <input type="submit" value="Comment" class="btn-secondry">
                                            <button class="btn-secondry" onclick="reloadPage()" style="background-color: red;">Cancel</button>
                                        </form>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="mid">
                                    <div style="margin-top: 10px; margin-left: 10px;">
                                        <label for="summernote"><h4>Discussion is closed.</h4></label>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <div class="bottom">
                            <div class="comment-box">
                                <h4>Discussion:</h4>
                                <c:forEach var="c" items="${commentList}">
                                    <div class="comment" style="margin-top: 15px;">
                                        <div class="main-comment">
                                            <div class="main-name">
                                                <label>${c.getFullName()}:</label>
                                            </div>
                                            <div class="comment-content">
                                                <p>${c.getComment()}</p>
                                            </div>
                                            <div style="float: right; margin-right: 10px;">
                                                <a href="#">Delete</a>
                                            </div>
                                        </div>
                                        <!--<div class="reply">
                                                <div>
                                                    <div class="reply-name">
                                                        <label>Username 2</label>
                                                    </div>
                                                    <div class="reply-content">
                                                        <p>reply here</p>
                                                    </div>
                                                </div>
                                            </div>-->
                                    </div>
                                </c:forEach>

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
        <!-- include summernote css/js -->
        <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
        <script type="text/javascript">
                                                $(document).ready(function () {
                                                    $('#summernote').summernote({
                                                        placeholder: 'Comment here...',
                                                        width: 1020
                                                    });
                                                });
        </script>
        <script>
            function reloadPage() {
                event.preventDefault();
                window.location.reload();
            }
        </script>
    </body>
</html>