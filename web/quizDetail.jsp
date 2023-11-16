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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css?v51" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!--<!Jquery CDN link >-->
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>


        <!--<! CSS file >-->

        <link rel="stylesheet" href="style.css">

        <!--<! JavaScript file>-->

        <script src="function.js"></script>

        <script>
            $(document).ready(function () {
                // Ẩn toàn bộ các thông tin khi trang tải
                $('#chapter').hide();
                $('#dimension').show;

                // Bắt sự kiện khi ấn vào nút Chapter
                $('#btn-chapter').click(function () {
                    $('#chapter').show();
                    $('#dimension').hide();
                });

                // Bắt sự kiện khi ấn vào nút Dimention
                $('#btn-dimention').click(function () {
                    $('#chapter').hide();
                    $('#dimension').show();
                });
            });
        </script>
    </head>
    <body onload="showToast('${txt}');turnEditMode('${txt}', '${err}')" class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>
        <!--Main container start -->
        <div style="background-color: #CBFFDF;margin-bottom: 10px">
            <p style="color:#6C6C6C;font-size: 18px;padding-left: 30px;font-family: initial;margin: 0;line-height: 60px">${txt}</p>
        </div>
        <div style="background-color: #FFB4C4;margin-bottom: 10px">
            <p style="color:#6C6C6C;font-size: 18px;padding-left: 30px;font-family: initial;margin: 0;line-height: 60px">${err}</p>
        </div>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Quiz</h4>
                    <ul class="db-breadcrumb-list">
                        <li><i class="fa fa-home"></i>Home</li>
                        <li><a href="quizs?action=list">Quiz</a></li>
                        <li>Quiz Details</li>
                    </ul>
                </div>

                <div id="snackbar" style="display: flex">
                    <i class="fa-solid fa-circle-check" style="font-size: 50px;float:left;margin-right: 10px;padding:10px 0 10px 0"></i>
                    <div>
                        <p style="text-align: left;margin-top: 20px">${txt}</p>
                    </div>
                </div>

                <div id="confirm-modal" class="modal">
                    <div class="modal-content" id="deleteModal">
                        <p>Are you sure you want to remove this question?</p>
                        <div style="display:flex;justify-content: space-between">
                            <button class="btn btn-primary" id="delete-confirm" >Delete</button>
                            <button id="delete-cancel">Cancel</button>
                        </div>
                    </div>
                </div>


                <!-- Tab -->
                <ul class="nav nav-tabs" id="nav-tab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="nav-general-tab" data-toggle="tab" href="#nav-general" role="tab"
                           aria-controls="nav-general" aria-selected="true">General</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="nav-question-tab" data-toggle="tab" href="#nav-question" role="tab"
                           aria-controls="nav-question" aria-selected="false">Question</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="nav-random-tab" data-toggle="tab" href="#nav-random" role="tab" aria-controls="nav-random" aria-selected="false">Random Option</a>
                    </li>
                </ul>

                <!-- Tab Content -->
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-general" role="tabpanel" aria-labelledby="nav-general-tab">
                        <div class="row">
                            <!--Your Profile Views Chart--> 
                            <div class="col-lg-12 m-b30">
                                <div class="widget-box">
                                    <div class="wc-title">
                                        <h4>Quiz Details</h4>
                                    </div>
                                    <div class="widget-inner">                               
                                        <form action="quizs" method="get" class="edit-profile m-b30">
                                            <div class="row">
                                                <input style="display: none" type="text" name="quizID" value="${quiz.quizId}">
                                                <div class="form-group col-6">
                                                    <label class="col-form-label" >Quiz Name</label>
                                                    <div>
                                                        <input class="form-control" id="inputname" style="background-color: white" type="text" name="name" value="${quiz.quizName}"readonly>                                               
                                                    </div>
                                                </div>
                                                <div class="form-group col-3">
                                                    <label class="col-form-label">Status</label>
                                                    <c:if test="${quiz.status==true}">
                                                        <div>
                                                            <input class="form-control" id="" style="background-color: white" type="text" name="status" value="Activated"readonly>                                               
                                                        </div>
                                                    </c:if>                     
                                                    <c:if test="${quiz.status==false}">
                                                        <div>
                                                            <input class="form-control" id="" style="background-color: white" type="text" name="status" value="Deactivated"readonly>                                               
                                                        </div>
                                                    </c:if>  
                                                </div>	
                                                <div class="form-group col-3">
                                                    <label class="col-form-label">Total of questions</label>
                                                    <div>
                                                        <input class="form-control" id="inputtotal" style="background-color: white" type="text" name="total" value="${quiz.numberQuestion}"readonly>
                                                    </div>
                                                </div>	
                                                <div class="form-group col-6">
                                                    <label class="col-form-label" >Subject</label>
                                                    <div>
                                                        <input class="form-control" id="inputsubname" style="background-color: white" type="text" name="subjectname" value="${subjectname}"readonly>                                               
                                                    </div>
                                                </div>
                                                <div class="form-group col-3">
                                                    <label class="col-form-label">Type</label>
                                                    <div>
                                                        <input class="form-control" id="inputtype" style="background-color: white" type="text" name="type" value="${quiz.quizType==true?"Fix":"Random"}"readonly>
                                                    </div>
                                                </div>

                                                <div class="form-group col-3">
                                                    <label class="col-form-label">Duration</label>
                                                    <div>
                                                        <input class="form-control" id="inputtime" style="background-color: white" type="text" name="time" value="${quiz.quizTime}"readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group col-6">
                                                    <label class="col-form-label" >Chapter</label>
                                                    <div>
                                                        <input class="form-control" id="inputchapname" style="background-color: white" type="text" name="chaptername" value="${chaptername}"readonly>                                               
                                                    </div>
                                                </div>


                                                <div class="form-group col-6">
                                                    <label class="col-form-label">Created by</label>
                                                    <div>
                                                        <c:if test="${quiz.createBy!=0}">
                                                            <input class="form-control" style="background-color: white" type="text" name="createBy" value="${creater}"readonly>
                                                        </c:if>
                                                        <c:if test="${quiz.createBy==0}">
                                                            <input class="form-control" style="background-color: white" type="text" name="createBy" readonly>
                                                        </c:if>
                                                    </div>
                                                </div>   



                                                <div class="col-12" id="editbut" style="display: block">
                                                    <button type="button" class="btn-secondry add-item m-r5" onclick="turnEdit()">Edit</button>                                            
                                                </div>

                                                <input type="text" name="action" style="display: none" value="updateQuiz"/>
                                                <div class="col-12" id="savebut" style="display: none">
                                                    <input type="submit" class="btn-secondry add-item m-r5" value="Save changes"/>
                                                    <button type="button" class="btn-secondry add-item m-r5" onclick="turnView()">View</button>
                                                </div>                                                                    
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!--Your Profile Views Chart END-->
                        </div>
                    </div>
                    <div class="tab-pane fade" id="nav-question" role="tabpanel" aria-labelledby="nav-question-tab">
                        <div class="row">
                            <div class="col-lg-12 m-b30">
                                <div class="widget-box">
                                    <div class="wc-title">
                                        <h4>Quiz Details</h4>
                                    </div>
                                    <div class="widget-inner">                               
                                        <form action="Quizs" method="get" class="edit-profile m-b30">
                                            <input type="text" name="action" style="display: none" value="questionList"/> 
                                            <input style="display: none" type="text" id ="quizID" name="quizID" value="${quiz.quizId}">
                                            <div class="row" style="justify-content: flex-end">
                                                <!--                                                Export
                                                                                                <input type="text" name="action" style="display: none" value="addQuestion"/>
                                                                                                <div class="col-1" id="" style="margin:0 13px 10px 0">
                                                                                                    <button type="button" class="btn-secondry add-item m-r5">Export</button>
                                                                                                </div>
                                                                                                Import
                                                                                                <input type="text" name="action" style="display: none" value="addQuestion"/>
                                                                                                <div class="col-1" id="" style="margin:0 13px 10px 0">
                                                                                                    <button type="button" class="btn-secondry add-item m-r5">Import</button>
                                                                                                </div>-->
                                                <!--Add ques-->
                                                <input type="text" name="action" style="display: none" value="addQuestion"/>
                                                <div class="col-2" id="" style="margin:0 0 10px 0">
                                                    <button type="button" class="btn btn-primary add-item m-r5" id="addQuestionBtn">Add Question</button>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <c:forEach  var = "i" begin = "1" end = "${questionList.size()}">
                                                    <input style="display: none" type="text" name="quesId" value="${questionList.get(i-1).questionId}"> 
                                                    <div class="question" style="display: flex">
                                                        <div class="col-md-11">
                                                            <div class="question-title"style="font-size: 17px;font-weight: bold" >Question ${i}:</div>
                                                            <div class="question-text">${questionList.get(i-1).question}</div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <i onclick="openDeleteModal('${questionList.get(i-1).questionId}')" class="fas fa-trash" style="padding:20px 20px 0 0;font-size: 20px;cursor: pointer"></i>
                                                        </div>

                                                    </div>
                                                </c:forEach>
                                            </div>   
                                        </form>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 m-b30" id="questionToAdd" style="display:none">
                                <div class="widget-box" >
                                    <div class="wc-title">
                                        <h4>Add Question</h4>
                                    </div>
                                    <div class="widget-inner">                               
                                        <form action="quizs" method="get" class="edit-profile m-b30">
                                            <input style="display: none" type="text" name="quizID"  value="${quiz.quizId}">
                                            <input style="display: none" type="text"id ="questionIdToAdd" name="questionIdToAdd" value="">
                                            <div class="row" style="justify-content: flex-end">
                                                <!--Export-->
                                                <div class="col-1" id="" style="margin:0 13px 10px 0">
                                                </div>
                                                <!--Import-->
                                                <div class="col-1" id="" style="margin:0 13px 10px 0">
                                                </div>
                                                <!--Add ques-->
                                                <input type="text" name="action" style="display: none" value="addQuestionToQuiz"/>
                                                <div class="col-2" id="" style="margin:0 0 10px 0">
                                                    <button type="submit" class="btn btn-primary add-item m-r5" onclick = "addQuestionToQuiz()">Add Question</button>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <c:forEach  var = "i" begin = "1" end = "${questionListToAdd.size()}">
                                                    <div class="question" style="display: flex">
                                                        <div class="col-md-11">
                                                            <div class="question-title"style="font-size: 17px;font-weight: bold" >Question ${i}:</div>
                                                            <div class="question-text">${questionListToAdd.get(i-1).question}</div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <!--<i class="fas fa-trash" style="Padding:20px 20px 0 0;font-size: 20px;cursor: pointer"></i>-->
                                                            <input type="checkbox" class ="question-added" value="${questionListToAdd.get(i-1).getQuestionId()}" />
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>   
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="nav-random" role="tabpanel" aria-labelledby="nav-random-tab">
                        <div class="widget-box" >
                            <div class="wc-title">
                                <h4>Add Question</h4>
                            </div>
                            <div class="widget-inner">                               
                                <form action="newquiz" method="post" class="edit-profile m-b30">
                                    <input style="display: none" type="text" name="quizID"  value="${quiz.quizId}">
                                    <input style="display: none" type="text" name="quizNum"  value="${quiz.numberQuestion}">
                                    <div>
                                        <div class="form-check form-check-inline" style="margin-right: 60px">
                                            <input class="form-check-input" type="radio" name="type" id="btn-dimention" value="false" checked/>
                                            <label class="form-check-label" for="randomQues">By Dimensions</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="type" id="btn-chapter" value="true" />
                                            <label class="form-check-label" for="fixedQues">By Chapter</label>
                                        </div>
                                    </div>
                                    <div class="form-group" id = "dimension">
                                        <div  style="margin-top:10px; margin-top: 20px">
                                            <label for="dimentype">Choose Question dimention</label>
                                            <select name="settingID">
                                                <c:forEach var="ss" items="${listss}">
                                                    <option value="${ss.settingId}">${ss.getSettingType()}/${ss.getSettingName()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div id = "chapter">
                                        <div class="row">
                                            <div class="col-md-6" style="margin-top:10px; margin-top: 20px">
                                                <label for="chapName">Choose Question Chapter</label>
                                                <select name="settingID">
                                                    <c:forEach var="c" items="${listC}">
                                                        <option value="${ss.settingId}">${c.settingName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <br>
                                    <button type="submit" class="btn btn-primary add-item m-r5" id="addQuestionBtn">Add Question</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>

        </div>
    </div>
</div>
</main>

<div class="ttr-overlay"></div>
<style>
    .question {
        background: #fff;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
        margin-bottom: 10px;
    }
    .question-title {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .answers {
        margin-top: 10px;
    }
    .answer {
        padding: 5px 0;
    }
    @media (max-width:768px){
        table{
            text-align: center;
            border-collapse: collapse;
        }
        th{
            display: none;
        }
        .bot-row{
            margin-bottom: 20px;
        }
        .action-container{
            display: none;
        }
        .mobile-action{
            display: block;
        }
    }
    @media (min-width:768px){
        .action-container{
            display: flex;
        }
        .mobile-action{
            display: none;
        }
    }
    ::placeholder {
        font-size: 13px;
        color:#C1C1C1;
    }
    thead th:hover{
        cursor: pointer;
    }
    tbody tr:hover{
        background-color: #F9F9F9;
    }

    .subjectTable th{
        padding: 8px 10px 8px 10px;
        text-align: center;
    }
    .subjectTable td{
        padding:0;
        text-align: center;
        padding: 5px 10px 5px 10px;
        line-height: 36px;
    }
    td,th{
        border-bottom: 1px solid gray;
        word-break: break-word;
        border:1px solid #F5F5F5;
    }
    .paging{
        display: inline-block;
    }
    .paging a{
        color: black;
        font-size: 14px;
        padding: 9px 14px;
        text-decoration: none;
        border: 1px solid #DBDBDB;
    }
    .paging a.active{
        background-color: #337ab7;
        color: white;
    }
    .paging a:hover{
        cursor: pointer;
    }
    .paging a:hover:not(.active){
        cursor: pointer;
        background-color: #EFEFEF;
        color: #337ab7
    }
    .button{
        line-height: 34px;
        border: none;
        padding: 3px 15px;
        border-radius: 3px;
        background-color: #337ab7;
        color: white;
    }
    .button:hover{
        opacity: 0.7;
    }
    #snackbar {
        visibility: hidden;
        min-width: 280px;
        margin-left: -125px;
        background-color: #7BF470;
        color: white;
        text-align: center;
        border-radius: 2px;
        padding: 10px 16px 10px 16px;
        position: fixed;
        z-index: 3;
        right: 30px;
        font-size: 20px;
        font-weight: 400;
    }

    #snackbar.show {
        visibility: visible;
        -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
        animation: fadein 0.5s, fadeout 0.5s 2.5s;
    }

    @-webkit-keyframes fadein {
        from {
            right: 0;
            opacity: 0;
        }
        to {
            right: 30px;
            opacity: 1;
        }
    }

    @keyframes fadein {
        from {
            right: 0;
            opacity: 0;
        }
        to {
            right: 30px;
            opacity: 1;
        }
    }

    @-webkit-keyframes fadeout {
        from {
            right: 30px;
            opacity: 1;
        }
        to {
            right: 0;
            opacity: 0;
        }
    }

    @keyframes fadeout {
        from {
            right: 30px;
            opacity: 1;
        }
        to {
            right: 0;
            opacity: 0;
        }
    }

    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0,0,0,0.5);
    }

    .modal-content {
        background-color: #fff;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 110%;
        max-width: 1000px;
    }
    #deleteModal {
        background-color: #fff;
        margin: 15% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
        max-width: 380px;
    }

    .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }

    #delete-confirm, #delete-cancel {
        width: 45%;
        padding: 10px;
        margin-top: 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }

    #delete-confirm {
        background: #ff7777;
        color: white;
    }

    #delete-cancel {
        background: #eee;
    }

    .modal-backdrop {
        z-index: -1;
    }

</style>
<script>
    function turnEdit() {
        document.getElementById('inputname').readOnly = false;
        document.getElementById('inputtotal').readOnly = false;
        document.getElementById('savebut').style.display = "block";
        document.getElementById('editbut').style.display = "none";
    }
    function turnView() {
        document.getElementById('inputname').readOnly = true;
        document.getElementById('inputtotal').readOnly = true;
        document.getElementById('savebut').style.display = "none";
        document.getElementById('editbut').style.display = "block";
    }
    function turnEditMode(txt, err) {
        if (err !== "") {
            document.getElementById('inputname').readOnly = false;
            document.getElementById('inputtotal').readOnly = false;
            document.getElementById('savebut').style.display = "block";
            document.getElementById('editbut').style.display = "none";
        } else {
            document.getElementById('inputname').readOnly = true;
            document.getElementById('inputtotal').readOnly = true;
            document.getElementById('savebut').style.display = "none";
            document.getElementById('editbut').style.display = "block";
        }
    }
    function openDeleteModal(quesId) {
        document.getElementById('confirm-modal').style.display = 'block';
        document.getElementById('delete-confirm').onclick = () => {
            deleteQuiz(quesId);
        }
        document.getElementById('delete-cancel').onclick = () => {
            closeModal();
        }
    }
    function deleteQuiz(quesId) {
        var quizId = document.getElementById('quizID').value;
        $.ajax({
            url: 'quizs?action=removeQuestion&quizID=' + quizId + '&quesID=' + quesId,
            method: 'GET',
            success: function (result) {
                closeModal();
                showToast('Câu hỏi đã được xóa thành công');
                window.location.reload();
            },
            error: function (error) {
                showToast('Lỗi khi xóa câu hỏi');
            }
        });
    }

    function closeModal() {
        document.getElementById('confirm-modal').style.display = 'none';
    }
    function showToast(txt) {
        if (txt !== "") {
            var x = document.getElementById("snackbar");
            x.className = "show";
            setTimeout(function () {
                x.className = x.className.replace("show", "");
            }, 3000);
        }
    }
    ;
    function handleSelect(elm)
    {
        window.location = elm.value;
    }

    function addQuestionToQuiz() {
        var selectedRadios = document.querySelectorAll('input[type="checkbox"].question-added:checked');
        var selectedValues = Array.from(selectedRadios).map(radio => radio.value).join(',');
        document.getElementById('questionIdToAdd').value = selectedValues;
    }

    document.getElementById('addQuestionBtn').addEventListener('click', () => {
        document.getElementById('questionToAdd').style.display = 'block';
        questionToAdd.scrollIntoView();

    });

</script>

<script>
    // Assume you have the 'type' variable defined
    var quizType = ${quiz.quizType};

    // Function to show/hide tabs based on the quiz type
    function toggleTabs() {
        var navGeneralTab = document.getElementById('nav-general-tab');
        var navQuestionTab = document.getElementById('nav-question-tab');
        var navRandomTab = document.getElementById('nav-random-tab');

        if (quizType) {
            // Show General and Question tabs, hide Random tab
            navGeneralTab.style.display = 'block';
            navQuestionTab.style.display = 'block';
            navRandomTab.style.display = 'none';
        } else {
            // Hide Question tab, show Random tab
            navGeneralTab.style.display = 'block';
            navQuestionTab.style.display = 'none';
            navRandomTab.style.display = 'block';
        }
    }

    // Call the function on page load
    window.onload = toggleTabs;
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
<script src='assets/vendors/switcher/switcher.js'></script>

</body>

<!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>


