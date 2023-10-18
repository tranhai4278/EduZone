<%-- 
    Document   : subjectDetail
    Created on : Oct 18, 2023, 2:40:21 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/basic-calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
<script>
    $(document).ready(function () {
        // Ẩn toàn bộ các thông tin khi trang tải
        $('#general').show();
        $('#chapter').hide();
        $('#dimension').hide();

        // Bắt sự kiện khi ấn vào nút General
        $('#btn-general').click(function () {
            $('#general').show();
            $('#chapter').hide();
            $('#dimension').hide();
        });

        // Bắt sự kiện khi ấn vào nút Chapter
        $('#btn-chapter').click(function () {
            $('#general').hide();
            $('#chapter').show();
            $('#dimension').hide();
        });

        // Bắt sự kiện khi ấn vào nút Dimention
        $('#btn-dimention').click(function () {
            $('#general').hide();
            $('#chapter').hide();
            $('#dimension').show();
        });
    });
</script>



    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>

        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Basic Calendar</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="#"></a>Subject Setting</li>

                        <li></li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <button class="btn btn-light" id="btn-general">
                                General
                            </button>
                            <button class="btn btn-light" id="btn-chapter">
                                Chapter
                            </button>
                            <button class="btn btn-light" id="btn-dimention">
                                Dimension
                            </button>
                            <div class="widget-inner">
                                <div id="general">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="ml-auto">
                                                <h3>1. Basic info</h3>
                                            </div>
                                        </div>

                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject code</label>
                                            <div>
                                                <input class="form-control" type="text" value="${detail.subjectCode}" name="scode" required maxlength="11" readonly="">
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Subject name</label>
                                            <div>
                                                <input class="form-control" type="text" value="${detail.subjectName}" name="sname" required maxlength="50" readonly>
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
                                                <textarea class="form-control" name="description" required maxlength="250" readonly >${detail.description} </textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="mail-list-container" id="chapter">
                                    <div class="mail-toolbar">
                                        <div class="row">
                                            <div class="col-sm-5">
                                                <a class="btn" href="add-setting.jsp">
                                                    Add a new setting   
                                                </a>
                                            </div>
                                        </div>
                                        <div class="next-prev-btn">
                                            <a href="#"><i class="fa fa-angle-left"></i></a>
                                            <a href="#"><i class="fa fa-angle-right"></i></a>
                                        </div>
                                    </div>
                                    <div class="mail-box-list">
                                        <section id="role">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Chapter</th>
                                                        <th scope="col">Description</th>
                                                        <th scope="col">Display Order </th>
                                                        <th scope="col">Status</th>
                                                        <th scope="col">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="s" items="${listC}" >
                                                        <tr>
                                                            <td>${s.settingName}</td>
                                                            <td>${s.note}</td>
                                                            <td>${s.displayOrder}</td>
                                                            <td>
                                                                <div class="form-check form-switch">
                                                                    <input style="margin: 0" class="form-check-input" type="checkbox" ${s.isStatus() ? 'checked' : ''} onclick="updateStatus(${s.settingId}, this)">
                                                                </div>
                                                            <td>
                                                                <a href="editsetting?sid=${s.settingId}&gid=${s.settingGroup}" class="tm-product-delete-link">
                                                                    <i> Edit</i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </section>
                                    </div>
                                </div>
                                            <div class="mail-list-container" id="dimension">
                                    <div class="mail-toolbar">
                                        <div class="row">
                                            <div class="col-sm-5">
                                                <a class="btn" href="add-setting.jsp">
                                                    Add a new setting   
                                                </a>
                                            </div>
                                        </div>
                                        <div class="next-prev-btn">
                                            <a href="#"><i class="fa fa-angle-left"></i></a>
                                            <a href="#"><i class="fa fa-angle-right"></i></a>
                                        </div>
                                    </div>
                                    <div class="mail-box-list">
                                        <section id="role">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Name</th>
                                                        <th scope="col">Description</th>
                                                        <th scope="col">Display Order </th>
                                                        <th scope="col">Type </th>
                                                        <th scope="col">Status</th>
                                                        <th scope="col">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="s" items="${listR}" >
                                                        <tr>
                                                            <td>${s.settingName}</td>
                                                            <td>${s.note}</td>
                                                            <td>${s.displayOrder}</td>
                                                            <td> <c:choose>
                                                                    <c:when test="${s.settingGroup == 1}">
                                                                        Role
                                                                    </c:when>
                                                                    <c:when test="${s.settingGroup == 2}">
                                                                        Email Domain
                                                                    </c:when>
                                                                    <c:when test="${s.settingGroup == 3}">
                                                                        Semester
                                                                    </c:when>
                                                                </c:choose>
                                                            </td>

                                                            <td>
                                                                <div class="form-check form-switch">
                                                                    <input style="margin: 0" class="form-check-input" type="checkbox" ${s.isStatus() ? 'checked' : ''} onclick="updateStatus(${s.settingId}, this)">
                                                                </div>
                                                            <td>
                                                                <a href="editsetting?sid=${s.settingId}&gid=${s.settingGroup}" class="tm-product-delete-link">
                                                                    <i> Edit</i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </section>
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
        <script src='assets/vendors/calendar/moment.min.js'></script>
        <script src='assets/vendors/calendar/fullcalendar.js'></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/basic-calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>
