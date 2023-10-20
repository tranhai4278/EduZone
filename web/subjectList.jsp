<!DOCTYPE html><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduNext : Education HTML Template </title>


        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">

        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>


        <main class="ttr-wrapper">
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
                    <h4 class="breadcrumb-title">Subject Setting</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Subject Setting</li>
                    </ul>
                </div>	
                <!-- Card -->
                <div class="row">
                    <c:forEach items="${listS}" var="s">
                        <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                            <a href="subjectDetail?sid=${s.subjectId}">
                                <div class="widget-card widget-bg1" style="height: 150px">					 
                                    <div class="wc-item">
                                        <h3 class="wc-title">
                                            ${s.subjectCode}
                                        </h3>
                                        <span class="wc-des" style="font-size: 15px; font-weight: 500">
                                            ${s.subjectName}
                                        </span>
                                        <span class="wc-progress-bx">
                                            <span class="wc-change" >
                                                ${s.description}
                                            </span>
                                        </span>
                                    </div>				      
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>

                <!-- Card END -->
        </main>
        <div class="ttr-overlay"></div>
        <script>
            setTimeout(function () {
                var notificationMessage = document.getElementById("notificationMessage");
                if (notificationMessage) {
                    notificationMessage.style.display = "none";
                }
            }, 5000);
        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
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

<!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
