<%-- 
    Document   : admin
    Created on : Sep 24, 2023, 12:30:41 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Discussion List </title>

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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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
            
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Discussion List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Discussion List</li>
                    </ul>
                </div>	
                <div class="row">
                    <form action="discussionList" method="post" id="form">
                        <input type="hidden" name="subjectId" value="${subjectId}" />
                        <!-- Your Profile Views Chart -->
                        <div class="col-lg-12 m-b30">
                            <div class="widget-box">
                                <div class="email-wrapper">
                                    <div class="mail-list-container">
                                        <div class="mail-toolbar">
                                            <div class="row" style="width: 100%">
                                                <div class="col-md-2">
                                                    <input value="${search}" name="search" type="text" id="filterSubject" placeholder="Search discussion" class="form-control" autocomplete="off" onchange="this.form.submit()">
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="filter-section">
                                                        <select id="filterType" name="classCode" onchange="this.form.submit()">
                                                            <option ${manager == -1 ? ' selected' : ' '} value="-1">Class</option>
                                                            <c:forEach var="c" items="${classList}">
                                                                <option ${classCode == c.getClassCode() ? ' selected' : ' '}  value="${c.getID()}">${c.getClassCode()}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <select id="filterStatus" name="status" onchange="this.form.submit()">
                                                        <option value="-1">Status</option>
                                                        <option ${status ==1 ? ' selected' : ' '} value="1">Active</option>
                                                        <option ${status ==0 ? ' selected' : ' '} value="0">Inactive</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-2 offset-md-4">
                                                    <a href="addDiscussion" class="btn btn-primary">
                                                        Create new Discussion
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <input  type="hidden" name="orders" id="orders" value="${orders}"/>

                                        <div class="mail-box-list">
                                            <section id="subject">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th style="position: relative;" scope="col">Title
                                                                <i style="position: absolute; right: 6px; top: 10px; color: #cccccc; cursor: pointer;" class="fa fa-caret-up ${orders eq 'title ASC' ? 'sort-active' : ''}" onclick="sortDatas('title ASC')"></i>
                                                                <i style="position: absolute; right: 6px; top: 18px; color: #cccccc; cursor: pointer;" class="fa fa-caret-down ${orders eq 'title DESC' ? 'sort-active' : ''}" onclick="sortDatas('title DESC')"></i>
                                                            </th>
                                                            <th scope="col">Class</th>
                                                            <th scope="col">Poster</th>
                                                            <th scope="col">Time</th>
                                                            <th scope="col">Status</th>
                                                            <th scope="col">Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="d" items="${discussionList}" >
                                                            <tr>
                                                                <td><a href="discussionDetail?discussionId=${d.getDiscussionId()}">${d.getTitle()}</a></td>
                                                                <td>${d.getClassCode()}</td>
                                                                <td>${d.getUserName()}</td>
                                                                <td>(${d.getFormattedStartTime()}) / (${d.getFormattedEndTime()})</td>
                                                                <td>
                                                                    <div class="form-check form-switch">
                                                                        <input style="margin: 0" class="form-check-input" type="checkbox" ${d.isStatus() ? 'checked' : ''} onclick="updateStatus(${d.getDiscussionId()}, this)">
                                                                    </div>
                                                                </td>
                                                                <td>
                                                                    <a href="editDiscussion?discussionId=${d.getDiscussionId()}" class="tm-product-delete-link">
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
                    </form>
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
            function updateStatus(discussionId, checkbox) {
                let status = checkbox.checked;
                if (confirm('Are you sure?'))
                    window.location.href = 'updateDiscussionStatus?subjectId=${subjectId}&discussionId=' + discussionId + '&status=' + status;
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
            function sortDatas(orders) {
                document.getElementById('orders').value = orders;
                document.getElementById('form').submit();
            }
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