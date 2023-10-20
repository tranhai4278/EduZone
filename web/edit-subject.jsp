<%-- 
    Document   : edit_subject
    Created on : Sep 24, 2023, 11:58:15 PM
    Author     : Nết
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

        <!-- DESCRIPTION -->
        <meta name="description" content="EduZone : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduZone : Education HTML Template" />
        <meta property="og:description" content="EduZone : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">


        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>
        <!-- header end -->

        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Edit Subject</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="settingSubject">Subject List</a></li>
                        <li>Edit Subject</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Edit Subject</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="editsubject" method="post">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="ml-auto">
                                                <h3>1. Basic info</h3>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject ID</label>
                                            <div>
                                                <input class="form-control" type="text" value="${detail.subjectId}" readonly="" name="id">
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject code</label>
                                            <div>
                                                <input class="form-control" type="text" value="${detail.subjectCode}" name="scode" required maxlength="11">
                                            </div>
                                            <p style="color: red">${requestScope.error}</p>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject name</label>
                                            <div>
                                                <input class="form-control" type="text" value="${detail.subjectName}" name="sname" required maxlength="50">
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label" >Manager</label>
                                            <select
                                                name="mid"
                                                id="manager"
                                                >
                                                <c:forEach items="${listSM}" var="s">
                                                    <option <c:if test="${detail.managerId eq s.userId}">
                                                            selected
                                                        </c:if> value="${s.userId}">
                                                        ${s.fullName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Status</label>
                                            <div class="form-check form-switch">
                                                <input name="on"  style="margin: 0" class="form-check-input" type="checkbox" ${detail.isStatus() ? 'checked' : ' '} >
                                            </div>
                                        </div>
                                        <div class="seperator"></div>

                                        <div class="col-12 m-t20">
                                            <div class="ml-auto m-b5">
                                                <h3>2. Description</h3>
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Subject description</label>
                                            <div>
                                                <textarea class="form-control" name="description" required maxlength="250" >${detail.description} </textarea>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <button  type="button" class="btn-secondry add-item m-r5" ><i class="fa fa-fw fa-arrow-left"></i>Cancel</button>
                                            <button type="submit" onclick="setSellDate()" class="btn">Save changes</button>
                                        </div>
                                    </div>
                                </form>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script>
                                                // Pricing add
                                                function newMenuItem() {
                                                    var newElem = $('tr.list-item').first().clone();
                                                    newElem.find('input').val('');
                                                    newElem.appendTo('table#item-add');
                                                }
                                                if ($("table#item-add").is('*')) {
                                                    $('.add-item').on('click', function (e) {
                                                        e.preventDefault();
                                                        newMenuItem();
                                                    });
                                                    $(document).on("click", "#item-add .delete", function (e) {
                                                        e.preventDefault();
                                                        $(this).parent().parent().parent().parent().remove();
                                                    });
                                                }
        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>