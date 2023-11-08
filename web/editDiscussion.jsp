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
        <title>Question Detail </title>

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
            .content-block {
                display: flex;
                flex-direction: column;
                margin: 10px;
            }

            .top-part, .bottom-part {
                display: flex;
                margin: 10px 0;
                flex-wrap: wrap;
            }

            .top-part > div, .bottom-part > div {
                flex: 1;
                width: 50%;
                margin: 5px;
            }

            .page-content {
                padding-bottom: 10px;
            }

            .no-style {
                font-family: inherit;
                font-size: inherit;
                font-weight: inherit;
                color: inherit;
                background: none;
                border: none;
                padding: 0;
                margin: 0;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">General</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Update Discussion</li>
                    </ul>
                </div>	
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="mail-list-container">
                                    <div class="page-content bg-white">
                                        <div class="content-block">
                                            <div class="col-lg-9 col-md-8 col-sm-12 m-b30">
                                                <h3>Update Discussion</h3>
                                            </div>
                                            <form class="edit-profile" method="post" action="editDiscussion">
                                                <input type="hidden" name="message" value="" />
                                                <input type="hidden" name="discussionId" value="${discussionId}" />
                                                <div class="top-part">
                                                    <div class="ssc-section">
                                                        <div id="ssc-section">
                                                            <div class="subject-section">
                                                                <label>Subject:</label>
                                                                <div style="width: 90%;">
                                                                    <select id="subject" name="subject" onchange="getClass(this);" disabled>
                                                                        <c:forEach var="subject" items="${subjectList}">
                                                                            <option value="${subject.getSubjectId()}"
                                                                                    <c:if test="${subject.getSubjectId() == subjectId}">
                                                                                        selected
                                                                                    </c:if>>${subject.getSubjectCode()}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div id="c-section" style="margin-left: 60px;">
                                                        <div class="class-section new-box">
                                                            <label>Class:</label>
                                                            <div style="width: 90%;">
                                                                <select id="class" name="class" disabled>
                                                                    <c:forEach var="c" items="${classList}">
                                                                        <option value="${c.getID()}"
                                                                                <c:if test="${c.getID() == classId}">
                                                                                </c:if>>${c.getclassCode()}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="bottom-part">
                                                    <div class="description-section">
                                                        <label for="title" class="description-area">Title:</label><br>
                                                        <input id="title" type="text" name="title" value="${title}" placeholder=" Title here..." style="height: 40px; width: 100%"/><br>
                                                        <br>
                                                        <label for="summernote" class="description-area">Description:</label>
                                                        <textarea id="summernote" name="summernote" style="width: 80%">${description}</textarea>
                                                        <br>
                                                        <label>Current Time: (${startTime}) - (${endTime})</label>
                                                        <br>
                                                        &nbsp;&nbsp;<label>Extend End Time (optional):</label>
                                                        <br>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;<input type="datetime-local" name="endDateTime">
                                                    </div>
                                                </div>

                                        </div>
                                        <div class="ac-section">
                                            <div class="">
                                                <div class="row">
                                                    <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                    </div>
                                                    <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                        <button type="submit" class="btn">Update</button>
                                                        <button class="btn-secondry" onclick="reloadPage()">Cancel</button>
                                                        ${message}
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        </form>
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
        <script>
            function getClass(selectElement) {
                var subject = selectElement.value;
                console.log(subject);
                $.ajax({
                    url: "/eduzone/getClassBySubject",
                    type: "get",
                    data: {
                        subject: subject
                    },
                    success: function (data) {
                        var sscSection = document.getElementById("c-section");
                        var newContainer = document.createElement("div");
                        newContainer.classList.add("new-box");

                        var divToDelete = document.querySelector(".new-box");
                        if (divToDelete) {
                            var parentElement = divToDelete.parentNode;

                            parentElement.removeChild(divToDelete);
                        }
                        newContainer.innerHTML = data;

                        sscSection.appendChild(newContainer);
                    },
                    error: function (xhr) {
                        // Xử lý lỗi ở đây nếu cần
                    }
                });
            }

            function reloadPage() {
                event.preventDefault();
                window.location.reload();
            }
        </script>
        <!-- include summernote css/js -->
        <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#summernote').summernote({
                    placeholder: "Description here...",
                    height: 200
                });
            });
        </script>
    </body>
</html>