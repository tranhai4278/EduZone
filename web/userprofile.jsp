<!DOCTYPE html>
<html lang="en">
    <%@page import="model.User"%>
    <!-- Mirrored from educhamp.themetrades.com/demo/admin/user-profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
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

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <%@include file="setting-header.jsp" %>
            <!-- header END ==== -->

            <!--Main container start -->
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
                                    <form class="edit-profile m-b30" action="updateprofile" method="POST">
                                        <div class="">
                                            <div class="form-group row">
                                                <div class="col-sm-10  ml-auto">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-sm-10 ml-auto">
                                                    <%-- Display success message only if available and operation was successful --%>
                                                    <% String successMessage = (String) request.getAttribute("success"); %>
                                                    <% if (successMessage != null) { %>
                                                    <div class="alert alert-success" role="alert">
                                                        <strong>Success:</strong> <%= successMessage %>
                                                    </div>
                                                    <% } %>

                                                    <%-- Display error message only if available and operation failed --%>
                                                    <% String errorMessage = (String) request.getAttribute("error"); %>
                                                    <% if (errorMessage != null) { %>
                                                    <div class="alert alert-danger" role="alert">
                                                        <strong>Error:</strong> <%= errorMessage %>
                                                    </div>
                                                    <% } %>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <div class="col-sm-2"></div>
                                                <div class="col-sm-7">
                                                    <span class="ttr-user-avatar" style="width: 150px; height: 150px; display: block; margin: 0 auto;">
                                                        <img src="<%= ((User) request.getAttribute("user")).getAvatarUrl() %>" width="150" height="150">
                                                    </span>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Avatar URL</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" name="avatar_url" value="<%= ((User) request.getAttribute("user")).getAvatarUrl() %>">
                                                </div>
                                            </div>

                                            <div class="form-group row" hidden>
                                                <label class="col-sm-2 col-form-label">ID</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" name="id" placeholder="Full Name" value="<%= ((User) request.getAttribute("user")).getUserId() %>">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Full Name</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" name="full_name" placeholder="Full Name" value="<%= ((User) request.getAttribute("user")).getFullName() %>">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Email</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" name="email" placeholder="Email" value="<%= ((User) request.getAttribute("user")).getEmail() %>" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Gender</label>
                                                <div class="col-sm-7">
                                                    <label class="radio-inline">
                                                        <input type="radio" name="gender" value="0" <% if (!((User) request.getAttribute("user")).isGender()) out.print("checked"); %>> Female
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input type="radio" name="gender" value="1" <% if (((User) request.getAttribute("user")).isGender()) out.print("checked"); %>> Male
                                                    </label>
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Phone No.</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" type="text" name="phone_number" placeholder="Phone Number" value="<%= ((User) request.getAttribute("user")).getPhone() %>">
                                                </div>
                                            </div>

                                            <div class="seperator"></div>

                                            <!-- Rest of the form remains the same -->
                                            <!-- ... -->

                                            <div class="row">
                                                <div class="col-sm-2"></div>
                                                <div class="col-sm-7">
                                                    <button type="submit" class="btn">Save changes</button>
                                                    <input type="button" class="btn" onclick="location.href = 'changepassword';" value="Change your password" />
                                                    <button type="reset" class="btn-secondry">Cancel</button>
                                                </div>
                                            </div>
                                        </div>

                                    </form>
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
            <script src='assets/vendors/switcher/switcher.js'></script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/user-profile.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>