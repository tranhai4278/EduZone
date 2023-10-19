<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />

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

    <!-- TYPOGRAPHY ============================================= -->
    <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

    <!-- SHORTCODES ============================================= -->
    <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

    <!-- STYLESHEETS ============================================= -->
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
    <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
</head>

<header class="ttr-header">
    <div class="ttr-header-wrapper">
        <!--sidebar menu toggler start -->
        <div class="ttr-toggle-sidebar ttr-material-button">
            <i class="ti-close ttr-open-icon"></i>
            <i class="ti-menu ttr-close-icon"></i>
        </div>
        <!--sidebar menu toggler end -->
        <!--logo start -->
        <div class="ttr-logo-box">
            <div>
                <a href="home" class="ttr-logo">
                    <img alt="" class="ttr-logo-mobile" src="assets/images/logo.png" width="30" height="15">
                    <img alt="" class="ttr-logo-desktop" src="assets/images/logo.png" width="70" height="27">
                </a>
            </div>
        </div>
        <!--logo end -->
        <div class="ttr-header-menu">
            <!-- header left menu start -->
            <ul class="ttr-header-navigation">
                <li>
                    <a href="home" class="ttr-material-button ttr-submenu-toggle">HOME</a>
                </li>
                <li>
                    <a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                    <div class="ttr-header-submenu">
                        <ul>
                            <!--                            <li><a href="../courses.html">Subject</a></li>-->
                            <!--                                    <li><a href="../event.html">New Event</a></li>
                                                                <li><a href="../membership.html">Membership</a></li>-->
                        </ul>
                    </div>
                </li>
            </ul>
            <!-- header left menu end -->
        </div>
        <div class="ttr-header-right ttr-with-seperator">
            <!-- header right menu start -->
            <ul class="ttr-header-navigation">
                <li>
                    <a href="#" class="ttr-material-button ttr-search-toggle"><i class="fa fa-search"></i></a>
                </li>
                <li>
                    <a href="#" class="ttr-material-button ttr-submenu-toggle"><i class="fa fa-bell"></i></a>
                    <div class="ttr-header-submenu noti-menu">
                        <div class="ttr-notify-header">
                            <span class="ttr-notify-text-top">9 New</span>
                            <span class="ttr-notify-text">User Notifications</span>
                        </div>
                        <div class="noti-box-list">
                            <ul>
                                <li>
                                    <span class="notification-icon dashbg-gray">
                                        <i class="fa fa-check"></i>
                                    </span>
                                    <span class="notification-text">
                                        <span>Sneha Jogi</span> sent you a message.
                                    </span>
                                    <span class="notification-time">
                                        <a href="#" class="fa fa-close"></a>
                                        <span> 02:14</span>
                                    </span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="assets/images/testimonials/pic3.jpg" width="32" height="32"></span></a>
                    <div class="ttr-header-submenu">
                        <ul>
                            <li><a href="profile">My profile</a></li>
                            <li><a href="list-view-calendar.html">Activity</a></li>
                            <li><a href="mailbox.html">Messages</a></li>
                            <li><a href="logout">Logout</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
            <!-- header right menu end -->
        </div>

    </div>
</header>
<!-- header end -->
<!-- Left sidebar menu start -->
<div class="ttr-sidebar">
    <div class="ttr-sidebar-wrapper content-scroll">
        <!-- side menu logo start -->
        <div class="ttr-sidebar-logo">
            <a href="#"><img alt="" src="assets/images/logo.png" width="50" height="50"></a>
            <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                    <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                    <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
            </div> -->
            <div class="ttr-sidebar-toggle-button">
                <i class="ti-arrow-left"></i>
            </div>
        </div>
        <!-- side menu logo end -->
        <!-- sidebar menu start -->
        <nav class="ttr-sidebar-navi">
            <ul>
                
               
                <li>
                    <a href="profile" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-face-smile"></i></span>
                        <span class="ttr-label">User Profile</span>
                    </a>
                </li>
                <li>
                    <a href="changepassword" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-pencil-alt2"></i></span>
                        <span class="ttr-label">Change Password</span>
                    </a>
                </li>
                <li class="ttr-seperate"></li>     
                <c:if test="${sessionScope.user.roleId == 1}">
                    <li>
                        <a href="userList" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-user"></i></span>
                            <span class="ttr-label">User</span>
                        </a>
                    </li>
                    <li>
                        <a href="settingSubject" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-book"></i></span>
                            <span class="ttr-label">Subject</span>
                        </a>
                    </li>
                    <li>
                        <a href="setting" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-settings"></i></span>
                            <span class="ttr-label">Setting</span>
                        </a>
                    </li>
                </c:if>
                    <c:if test="${sessionScope.user.roleId == 2}">
                    <li>
                        <a href="#" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-clipboard"></i></span>
                            <span class="ttr-label">Question</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-pencil-alt"></i></span>
                            <span class="ttr-label">Quiz</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                            <span class="ttr-label">Lesson</span>
                        </a>
                    </li>
                    <li>
                        <a href="subjectList" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-agenda"></i></span>
                            <span class="ttr-label">Subject Setting</span>
                        </a>
                    </li>
                    
                </c:if>
                    
                       <c:if test="${sessionScope.user.roleId == 2}">
                    <li>
                        <a href="classlist" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-clipboard"></i></span>
                            <span class="ttr-label">Class List</span>
                        </a>
                    </li>
                    <li>
                        <a href="newclass" class="ttr-material-button">
                            <span class="ttr-icon"><i class="ti-pencil-alt"></i></span>
                            <span class="ttr-label">Create a New Class</span>
                        </a>
                    </li>
                    
                </c:if>
                    


                <!--                        <li>
                                            <a href="review.html" class="ttr-material-button">
                                                <span class="ttr-icon"><i class="ti-comments"></i></span>
                                                <span class="ttr-label">Review</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="add-listing.html" class="ttr-material-button">
                                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                                <span class="ttr-label">Add listing</span>
                                            </a>
                                        </li>-->
                <!--                <li>
                                    <a href="#" class="ttr-material-button">
                                        <span class="ttr-icon"><i class="ti-settings"></i></span>
                                        <span class="ttr-label">Setting List</span>
                                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                                    </a>
                                    <ul>
                                        <li>
                                            <a href="userList" class="ttr-material-button"><span class="ttr-label">User Setting</span></a>
                                        </li>
                                        <li>
                                            <a href="settingSubject" class="ttr-material-button"><span class="ttr-label">Subject Setting</span></a>
                                        </li>
                                        <li>
                                            <a href="" class="ttr-material-button"><span class="ttr-label">Setting</span></a>
                                        </li>
                                    </ul>
                                </li>-->     

            </ul>

        </nav>

    </div>
</div>