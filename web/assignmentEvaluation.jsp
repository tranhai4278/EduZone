<%-- 
    Document   : admin
    Created on : Sep 24, 2023, 12:30:41 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="assignDAO" value="<%= new dal.AssignmentDAO() %>" />
<%@page import="model.AssignmentSubmit" %>


<!DOCTYPE html>
<html lang="en">

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
        <meta property="og:title" content="EduNext : Education HTML Template" />
        <meta property="og:description" content="EduNext : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <c:if test="${not empty requestScope.error}">
                <div class="alert alert-danger" id="notificationMessage" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="True">&times;</span>
                    </button>
                    ${requestScope.error}
                </div>
            </c:if>
            <c:if test="${not empty requestScope.successMessage}">
                <div class="alert alert-success" id="notificationMessage" role="alert" >
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="True">&times;</span>
                    </button>
                    ${requestScope.successMessage}
                </div>
            </c:if>
            <form action="setting" method="post" id="form">
                <div class="container-fluid">
                    <div class="db-breadcrumb">
                        <h4 class="breadcrumb-title">Setting</h4>
                        <ul class="db-breadcrumb-list">
                            <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                            <li>Setting</li>
                        </ul>
                    </div>	
                    <div class="row">
                        <!-- Your Profile Views Chart -->
                        <div class="col-lg-12 m-b30">
                            <div class="widget-box">
                                <div class="email-wrapper">
                                    <div class="mail-list-container">
                                        <div class="mail-toolbar">
                                            <div class="row" style="width: 100%">
                                                <div class="col-md-2">
                                                    <input value="${search}" name="search" type="text" id="filterSubject" placeholder="Search setting" class="form-control" autocomplete="off" onchange="this.form.submit()">
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="filter-section">
                                                        <select id="filterType" name="type" onchange="this.form.submit()">
                                                            <option ${type == -1 ? ' selected' : ' '} value="-1">Type</option>
                                                            <option ${type == 1 ? ' selected' : ' '}  value="1">Role</option>
                                                            <option ${type == 2 ? ' selected' : ' '}  value="2">Email Domain</option>
                                                            <option ${type == 3 ? ' selected' : ' '}   value="3">Semester</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <select id="filterStatus" name="status" onchange="this.form.submit()">
                                                        <option  ${type == -1 ? ' selected' : ' '} value="-1">Status</option>
                                                        <option ${status ==1 ? ' selected' : ' '} value="1">Active</option>
                                                        <option ${status ==0 ? ' selected' : ' '} value="0">Inactive</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-2 offset-md-4">
                                                    <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#chapterModal">
                                                        Add a new Setting   
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mail-box-list">
                                    <section id="role">
                                        <input  type="hidden" name="order" id="order" value="${order}"/>
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th style="position: relative;" scope="col">Full Name <i style="position: absolute;
                                                                                                        right: 6px;
                                                                                                        top: 10px;
                                                                                                        color: #cccccc;
                                                                                                        cursor: pointer;" class="fa fa-caret-up ${order eq 'setting_name  ASC ' ? ' sort-active' : ' '}" onclick="sortData('setting_name  ASC')" ></i>
                                                        <i style=" position: absolute;
                                                           right: 6px;
                                                           top: 18px;
                                                           color: #cccccc;
                                                           cursor: pointer;" class="fa fa-caret-down ${order eq 'setting_name  DESC ' ? ' sort-active' : ' '}" onclick="sortData('setting_name  DESC')"></i></th>
                                                    <th scope="col">Submission</th>
                                                    <th scope="col">Submit time</th>
                                                    <th scope="col">Status</th>
                                                    <th scope="col">Grade</th>
                                                    <th scope="col">Comment</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="a" items="${list}" >
                                                    <tr>
                                                        <td>${assignDAO.getTraineeName(a.getTraineeID())}</td>
                                                        <td>${a.getFile()}</td>
                                                        <td>${a.getSubmitTime()}</td>
                                                        <td>
                                                            <div class="form-check form-switch">
                                                                <input style="margin: 0" class="form-check-input" type="checkbox" ${a.isStatus() ? 'checked' : ''} onclick="updateStatus(${s.settingId}, this)">
                                                            </div>
                                                        </td>
                                                        <td>${a.getMark()}</td>
                                                        <td>${a.getComment()}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </section>
                                </div>
                            </div>
                            <c:if test="${totalPage!=0}">
                                <nav aria-label="Page navigation example" style="margin-top: 20px;">
                                    <ul class="pagination justify-content-end">
                                        <li class="page-item ${pageNo == 1 ? ' disabled' : ' '}">
                                            <a class="page-link" style="cursor: pointer"
                                               onclick="goToPage(${pageNo} - 1)">
                                                <span aria-hidden="true">&laquo;</span>
                                            </a>
                                        </li>
                                        <input type="hidden" name="pageNo" id="pageNoInput" value="${pageNo}">
                                        <c:forEach begin="1" var="i" end="${totalPage}">
                                            <li class="page-item  ${pageNo == i  ? ' active' : ' '}">
                                                <a class="page-link"  style="cursor: pointer"
                                                   onclick="goToPage(${i})">
                                                    ${i}
                                                </a>
                                            </li>
                                        </c:forEach>
                                        <li class="page-item ${pageNo == (totalPage) ? ' disabled' : ' '}">
                                            <a class="page-link user-select-all" style="cursor: pointer"
                                               onclick="goToPage(${pageNo+1})">
                                                <span aria-hidden="true">&raquo;</span>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </c:if>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <div class="modal fade" id="chapterModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add Setting</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form class="edit-profile m-b30" action="addsetting" method="post">
                        <div class="row">
                            <div class="col-12">
                                <div class="ml-auto">
                                    <h3>1. Basic info</h3>
                                </div>
                            </div>

                            <div class="form-group col-6">
                                <label class="col-form-label">Group</label>
                                <select
                                    name="gid"
                                    id="group"
                                    required
                                    >
                                    <option value="1">
                                        Role
                                    </option>
                                    <option value="2">
                                        Email Domain
                                    </option>
                                    <option value="3">
                                        Semester
                                    </option>
                                </select>
                            </div>

                            <div class="form-group col-6">
                                <label class="col-form-label">Name</label>
                                <div>
                                    <input class="form-control" type="text"  name="sname" required>
                                </div>
                            </div>
                            <div class="seperator"></div>
                            <div class="col-12 m-t20">
                                <div class="ml-auto m-b5">
                                    <h3>2. Description</h3>
                                </div>
                            </div>
                            <div class="form-group col-12">
                                <label class="col-form-label">Description</label>
                                <div>
                                    <textarea class="form-control" name="description" required maxlength="250" > </textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" onclick="setSellDate()" class="btn">Add</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<div class="ttr-overlay"></div>
<!-- External JavaScripts -->
<script>
    function updateStatus(id, checkbox) {
        let status = checkbox.checked;
        if (confirm('Are you sure?'))
            window.location.href = 'updateStatusSetting?id=' + id + '&status=' + status;
        else
            checkbox.checked = !status;
    }
</script>
<script>
    setTimeout(function () {
        var notificationMessage = document.getElementById("notificationMessage");
        if (notificationMessage) {
            notificationMessage.style.display = "none";
        }
    }, 5000);
</script>
<script>
    function goToPage(i) {
        document.getElementById('pageNoInput').value = i;
        document.getElementById('form').submit();
    }
    function sortData(order) {
        document.getElementById('order').value = order;
        document.getElementById('form').submit();
    }
</script>

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
<!--        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>-->
</body>

<!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>