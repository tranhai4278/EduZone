<!DOCTYPE html>
<html lang="en">
<%@page import="model.User"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="" />
    <meta name="author" content="" />
    <meta name="robots" content="" />
    <meta name="description" content="EduChamp : Education HTML Template" />
    <meta property="og:title" content="EduChamp : Education HTML Template" />
    <meta property="og:description" content="EduChamp : Education HTML Template" />
    <meta property="og:image" content="" />
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="../error-404.html" type="image/x-icon" />
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
    <title>EduChamp : Education HTML Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.min.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
    <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">
    <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
    <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
    <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
</head>
<body class="ttr-opened-sidebar ttr-pinned-sidebar">
    <div class="page-wraper">
        <div id="loading-icon-bx"></div>
        <!-- Header Top ==== -->
        <%@include file="setting-header.jsp" %>
        <!-- header END ==== -->
        <!-- Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">User Profile</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>User Profile</li>
                    </ul>
                </div>
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>User Profile</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="verifyotp" method="POST">
                                    <div class="">
                                        <div class="form-group row">
                                            <div class="col-sm-10 ml-auto">
                                                <!-- Display OTP sent message here -->
                                                <p>We have sent you an OTP code to your email.</p>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-10 ml-auto">
                                                <!-- OTP input field -->
                                                <input class="form-control" type="text" name="otp_code" placeholder="Enter Code" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-10 ml-auto">
                                                <!-- Resend OTP button -->
                                                <button type="button" class="btn btn-secondary" onclick="resendOTP()">Resend</button>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-10 ml-auto">
                                                <!-- Submit button -->
                                                <button type="submit" class="btn">Submit</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END -->
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
        <script src='assets/vendors/switcher/switcher.js'></script>

        <script>
            // Function to resend OTP (You can implement this function)
            function resendOTP() {
                // Implement OTP resend logic here
                alert("OTP Resent");
            }
        </script>
    </body>
</html>
