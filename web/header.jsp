<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="cssconnect.jsp" %>
<%@ page import="dal.SubjectDAO" %>
<%@ page import="model.Subject" %>
<%@ page import="java.util.ArrayList" %>

<style>
    .result-box ul {
        border-top: 1px solid #999;
        padding: 15px 10px;
    }

    .result-box ul li {
        list-style: none;
        border-radius: 3px;
        padding: 15px 10px;
        cursor: pointer;
    }

    .result-box ul li:hover {
        background: #e9f3ff;
    }

    .result-box {
        max-height: 300px;
        overflow-y: scroll;
    }
</style>


<header class="header rs-nav header-transparent">
    <div class="top-bar">
        <div class="container">
            <div class="row d-flex justify-content-between">
                <div class="topbar-left">
                    <ul>

                    </ul>
                </div>
                <div class="topbar-right">
                    <ul>
                        <li> <c:if test="${sessionScope.user!=null}"><a href="logout">Logout</a></c:if></li>
                        <!--                                    <li><a href="register.jsp">Register</a></li>-->
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="sticky-header navbar-expand-lg">
        <div class="menu-bar clearfix">
            <div class="container clearfix">
                <!-- Header Logo ==== -->
                <div class="menu-logo">
                    <a href="home.jsp"><img src="assets/images/logo.png" alt=""></a>
                </div>
                <!-- Mobile Nav Button ==== -->
                <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
                <!-- Author Nav ==== -->
                <div class="secondary-menu">
                    <div class="secondary-inner">
                        <ul>
                            <li><a href="javascript:;" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
                            <!-- Search Button ==== -->
                            <li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>
                        </ul>
                    </div>
                </div>
                <!-- Search Box ==== -->
                <div class="nav-search-bar">
                    <form id="search-form" action="SubjectList" method="POST">
                        <input name="search" value="" type="text" id="input-box" class="form-control" placeholder="Type to search" autocomplete="off">
                        <input type="submit" style="display: none;">
                        <div class="result-box">
                        </div>
                    </form>
                    <span id="search-remove"><i class="ti-close"></i></span>
                </div>

                <!-- Navigation Menu ==== -->
                <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                    <div class="menu-logo">
                        <a href="home.jsp"><img src="assets/images/logo.png" alt=""></a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li><a href="javascript:;">${sessionScope.user.getFullName()} <i class="fa fa-chevron-down"></i></a>
                            <ul class="sub-menu">
                                <!--                                            
                                <li><a href="javascript:;">About<i class="fa fa-angle-right"></i></a>
                                                                                <ul class="sub-menu">
                                                                                    <li><a href="about-1.jsp">About 1</a></li>
                                                                                    <li><a href="about-2.jsp">About 2</a></li>
                                                                                </ul>
                                                                            </li>
                                                                            <li><a href="javascript:;">Event<i class="fa fa-angle-right"></i></a>
                                                                                <ul class="sub-menu">
                                                                                    <li><a href="event.jsp">Event</a></li>
                                                                                    <li><a href="events-details.jsp">Events Details</a></li>
                                                                                </ul>
                                                                            </li>
                                                                            <li><a href="javascript:;">FAQ's<i class="fa fa-angle-right"></i></a>
                                                                                <ul class="sub-menu">
                                                                                    <li><a href="faq-1.jsp">FAQ's 1</a></li>
                                                                                    <li><a href="faq-2.jsp">FAQ's 2</a></li>
                                                                                </ul>
                                                                            </li>
                                                                            <li><a href="javascript:;">Contact Us<i class="fa fa-angle-right"></i></a>
                                                                                <ul class="sub-menu">
                                                                                    <li><a href="contact-1.jsp">Contact Us 1</a></li>
                                                                                    <li><a href="contact-2.jsp">Contact Us 2</a></li>
                                                                                </ul>
                                                                            </li>-->
                                <!--                                            
                                <li><a href="portfolio.jsp">Portfolio</a></li>-->
                                <li><a href="profile">My Profile</a></li>
                                <!--                                            <li><a href="profile.jsp">My Subject</a></li>
                                                                            <li><a href="profile.jsp">My Class</a></li>                                    Will do this in future--> 
                                <li><a href="changepassword">Change Password</a></li>
                                <li><c:if test="${sessionScope.user!=null}">
                                        <a href="logout">Logout</a>
                                    </c:if></li>

                                <!--                                            <li><a href="membership.jsp">Membership</a></li>
                                                                            <li><a href="error-404.jsp">404 Page</a></li>-->
                            </ul>
                        </li>
                        <li class="add-mega-menu"><a href="javascript:;">Our Subjects <i class="fa fa-chevron-down"></i></a>
                            <ul class="sub-menu add-menu">
                                <li class="add-menu-left">
                                    <h5 class="menu-adv-title">Our Subjects</h5>
                                    <ul>
                                        <li><a href="SubjectList">Subjects </a></li>
                                        <!--                                                    <li><a href="courses-details.jsp">Courses Details</a></li>-->
                                        <!--                                                    <li><a href="profile.jsp">Instructor Profile</a></li>
                                                                                            <li><a href="event.jsp">Upcoming Event</a></li>
                                                                                            <li><a href="membership.jsp">Membership</a></li>-->
                                    </ul>
                                </li>
                                <li class="add-menu-right">
                                    <img src="assets/images/adv/adv.jpg" alt=""/>
                                </li>
                            </ul>
                        </li>
                        <c:if test="${sessionScope.user.roleId == 1}">
                        <li class="nav-dashboard"><a href="javascript:;">Admin Dashboard Setting <i class="fa fa-chevron-down"></i></a>
                            <ul class="sub-menu">
                                <li><a href="userList">User</a></li>
                                <li><a href="settingSubject">Subject</a></li>
                                <li><a href="setting">Setting</a></li>
                            </ul>
                        </li>
                        </c:if>
                        
                        <c:if test="${sessionScope.user.roleId == 2}">
                        <li class="nav-dashboard"><a href="javascript:;">Subject Manager Dashboard Setting <i class="fa fa-chevron-down"></i></a>
                            <ul class="sub-menu">
                                <li><a href="classlist">Class List</a></li>
                                <li><a href="newclass">Create A New Class</a></li>
                            </ul>
                        </li>
                        </c:if>
                    </ul>
                    <div class="nav-social-link">
                        <a href="javascript:;"><i class="fa fa-google-plus"></i></a>
                    </div>
                </div>
                <!-- Navigation Menu END ==== -->
            </div>
        </div>
    </div>
</header>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    let availableKeywords = [];

    <%
        SubjectDAO subjectDAO = new SubjectDAO();
        ArrayList<String> SubjectNameList = subjectDAO.getAllSubjectNames();
        ArrayList<String> SubjectCodeList = subjectDAO.getAllSubjectCodes();
        
    for (String subjectName : SubjectNameList) {
    %>
    availableKeywords.push("<%= subjectName %>");
    <%
    }

    for (String subjectCode : SubjectCodeList) {
    %>
    availableKeywords.push("<%= subjectCode %>");
    <%
    }
    %>



    $(document).ready(function () {
        $('#input-box').keypress(function (e) {
            if (e.which === 13) { // 13 is the key code for Enter
                e.preventDefault(); // Prevent the default form submission
                $('#search-form').submit(); // Trigger the form submission
            }
        });
    });
</script>
<script src="assets/js/autocomplete.js"></script>
