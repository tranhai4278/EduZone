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
        <style>
            .content-block {
                padding-top: 20px;
                padding-left: 10px;
            }

            .answer {
                margin-top: 10px;
            }

            .delete-answer {
                margin-left: 10px;
            }

            #add-answer-button {
                margin-top: 10px;

            }

            .ac-section {
                margin-top: 10px;
            }

            .question-section,
            .answer-section {
                width: 50%;
                float: left;
                box-sizing: border-box;
                padding: 20px;
            }

            .question-section {
                margin-top: 33px;
            }

            .clearfix::after {
                content: "";
                display: table;
                clear: both;
            }

            .divider {
                width: 1px;
                background-color: black;
                height: 100%;
                display: inline-block;
                margin: 0 10px;
            }

            #dimension-select {
                display: flex;
                flex-wrap: wrap;
                align-items: center;
                justify-content: space-between;
            }

            .dimension-type,
            .dimension-name,
            #add-dimension-button {
                flex: 0 0 auto;
                margin-right: 10px; /* Adjust the margin to control spacing */
            }

            .sd-section {
                display: flex;
                width: 100%;
                justify-content: space-between;
                gap: 70px;
            }

            .subject-dropdown,
            #dimension-select {
                flex: 1;
            }

            #add-dimension-button {
                margin-top: 36px;
            }

            .answer-section {
                margin-top: 32px;
            }

            .dimension-header {
                padding-left: 770px;
            }

            #dimension-select {
                margin-top: 8px;
            }

            .question-area,
            answer-area {
                padding-top: 30px;
            }

            .subject-dropdown select {
                max-width: 40%;
            }

            #questionArea {
                margin-top: -40px;
            }

            .answer-section {
                margin-top: -40px;
            }

            .asc {
                margin-left: 14px;
            }

            .answer-area {
                padding-left: 600px;
            }

            .dimension {
                margin-top: 10px;
            }

            #dimension-container {
                display: flex; /* Use Flexbox to layout children horizontally */
                align-items: center; /* Vertically align items in the center */
            }

            .select-container {
                display: flex; /* Use Flexbox to layout children horizontally */
                align-items: center; /* Vertically align items in the center */
            }

            /* Adjust styling as needed */
            label {
                margin-right: 10px; /* Add spacing between label and select */
            }
            
            .question-area {
                padding-left: 45px;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Manager Page</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Question Detail</li>
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
                                                <h3>Edit Question</h3>
                                            </div>
                                            <form class="edit-profile" method="post" action="EditQuestion">
                                                <input type="hidden" name="questionId" value="${questionId}">

                                                <!--<h6 class="dimension-header">Dimension:</h6>-->
                                                <div class="sd-section">
                                                    <div class="subject-dropdown">
                                                        <label for="subject"><h6>Subject:</h6></label>
                                                        <select id="subject" name="subject">
                                                            <c:forEach var="subject" items="${subjectList}">
                                                                <option value="${subject.getSubjectId()}" 
                                                                        <c:if test="${subject.getSubjectId() == subjectId}">
                                                                            selected
                                                                        </c:if>>${subject.getSubjectCode()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                    <div id="dimension-select">

                                                        <div id="dimension-container">
                                                            <label>Dimension:</label>
                                                            <div class="select-container">
                                                                <select name="dimension">
                                                                    <c:forEach var="ss" items="${subjectSettingList}">
                                                                        <option value="${ss.getSettingId()}">${ss.getSettingType()}/${ss.getSettingName()}</option>
                                                                    </c:forEach>
                                                                </select>
                                                                <button class="delete-dimension btn-secondry">Delete</button>
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <button id="add-dimension-button" class="btn">Add Dimension</button>
                                                </div>
                                        </div>


                                        <label for="questionArea" class="question-area">Question:</label>
                                        <label class="answer-area">Answer:</label>
                                        <div class="clearfix">

                                            <div class="question-section">

                                                <textarea id="questionArea" name="questionString" rows="6" cols="70">${qContent}</textarea>
                                            </div>
                                            <div class="divider"></div>
                                            <div class="answer-section"> 
                                                <div class="asc">
                                                    <div id="answers-container">
                                                        <c:forEach var="answer" items="${answerList}">
                                                            <input type="text" name="answer" placeholder="Enter answer text" value="${answer.getChoice()}">
                                                            <input type="checkbox" name="true-answer" 
                                                                   <c:if test="${answer.isTrueAnswer() == true}">
                                                                       checked
                                                                   </c:if>
                                                                   > True Answer
                                                            <button class="delete-answer btn-secondry">Delete</button><br>
                                                        </c:forEach>
                                                    </div>
                                                    <button id="add-answer-button" class="btn">Add Answer</button>
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
                                                        <button type="reset" class="btn-secondry">Cancel</button>
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
            let answerIndex = 0;
            document.getElementById('add-answer-button').addEventListener('click', function () {
                event.preventDefault();
                const answersContainer = document.getElementById('answers-container');
                const answerDiv = document.createElement('div');
                answerDiv.classList.add('answer');
                answerDiv.innerHTML = `
                    <input type="text" name="answer" placeholder="Enter answer text">
                    <input type="checkbox" name="true-answer" > True Answer
                    <button class="delete-answer btn-secondry">Delete</button>`;

                answersContainer.appendChild(answerDiv);
                // Add event listener to delete button
                answerDiv.querySelector('.delete-answer').addEventListener('click', function () {
                    event.preventDefault();
                    answersContainer.removeChild(answerDiv);
                });
            });

            document.getElementById('add-dimension-button').addEventListener('click', function () {
                event.preventDefault();
                const dimensionContainer = document.getElementById('dimension-container');
                const dimensionDiv = document.createElement('div');
                dimensionDiv.classList.add('dimension');
                dimensionDiv.innerHTML = `
                    <select name="dimension">
            <c:forEach var="ss" items="${subjectSettingList}">
                        <option value="${ss.getSettingId()}">${ss.getSettingType()}/${ss.getSettingName()}</option>
            </c:forEach>
                    </select>
                    <button class="delete-dimension btn-secondry">Delete</button>`;

                dimensionContainer.appendChild(dimensionDiv);

                // Add event listener to delete button
                dimensionDiv.querySelector('.delete-dimension').addEventListener('click', function () {
                    event.preventDefault();
                    dimensionContainer.removeChild(dimensionDiv);
                });
            });


        </script>
    </body>
</html>