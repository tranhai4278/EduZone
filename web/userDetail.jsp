<%-- 
    Document   : userDetail
    Created on : Sep 25, 2023, 2:17:11 AM
    Author     : PHAM NGOC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User" %>
<!DOCTYPE html>
<html lang="en">

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
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

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
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Setting</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="home"><i class="fa fa-home"></i>Home</a></li>
                        <li>Edit User</li>
                    </ul>
                </div>
            </div>

            <div class="content-block">
                <!-- About Us -->
                <c:set var="user" value="${user}"/>
                    <div class="container">
                        <div class="col-lg-11 col-md-11 col-sm-11 m-b30">
                            <div class="tab-content">
                                <div class="tab-pane active" id="edit-profile">
                                    <div class="profile-head">
                                        <h3>Edit User Details</h3>
                                    </div>
                                    <form class="edit-profile" action="userEdit" method="post" >
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <h3>1. Personal Details</h3>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">User ID</label>
                                            <div class="col-12 col-sm-8 col-md-8 col-lg-3">
                                                <input class="form-control" type="text" name="userId"  value="${user.userId}" readonly>
                                            </div>
                                            <div class="col-12 col-sm-8 col-md-8 col-lg-1">
                                            </div>
                                            <label class="col-12 col-sm-6 col-md-6 col-lg-2 col-form-label">Full Name</label>
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-4">
                                                <input class="form-control" type="text" value="${user.fullName}" readonly>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Gender</label>
                                            <div class="col-12 col-sm-8 col-md-8 col-lg-3">
                                                <input class="form-control" type="text" value="${user.genderDisplay}" readonly>
                                            </div>
                                            <div class="col-12 col-sm-8 col-md-8 col-lg-1">
                                            </div>
                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Email</label>
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-4">
                                                <input class="form-control" name="email" type="text" value="${user.email}" readonly>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Phone</label>
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-3">
                                                <input class="form-control" type="text" value="${user.phone}" readonly>
                                            </div>
                                        </div>
                                        <div class="seperator"></div>

                                        <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>

                                        <div class="form-group row">
                                            <div class="col-12">
                                                <h3 class="m-form__section">2. Edit User
                                                </h3>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Role</label>
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-5">
                                                <select name="role">
                                                    <option value="1" ${user.getRoleId() == 1 ? "selected" : ""}>Admin</option>
                                                    <option value="2" ${user.getRoleId() == 2 ? "selected" : ""}>Subject Manager</option>
                                                    <option value="3" ${user.getRoleId() == 3 ? "selected" : ""}>Trainer</option>
                                                    <option value="4" ${user.getRoleId() == 4 ? "selected" : ""}>Trainee</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label">Status</label>
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-5">
                                                <select name="status">
                                                    <option value="0" ${user.isStatus() == false ? "selected" : ""}>Inactive</option>
                                                    <option value="1" ${user.isStatus() == true ? "selected" : ""}>Active</option>
                                                </select>
                                            </div>
                                        </div> 




                                        <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>

                                        <div class="">
                                            <div class="">
                                                <div class="row">
                                                    <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                    </div>
                                                    <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                        <button type="submit" class="btn">Save changes</button>
                                                        <button type="reset" class="btn-secondry">Cancel</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div> 
                            </div>
                        </div>
                    </div>
                <!-- contact area END -->
            </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
            setTimeout(function () {
                var notificationMessage = document.getElementById("notificationMessage");
                if (notificationMessage) {
                    notificationMessage.style.display = "none";
                }
            }, 3000);
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
</html>
