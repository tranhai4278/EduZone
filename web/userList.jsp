<%-- 
    Document   : admin
    Created on : Sep 24, 2023, 12:30:41 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userDAO" value="<%= new dal.UserDAO() %>" />
<%@page import="model.User" %>


<!DOCTYPE html>
<html>
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
        <meta uperty="og:title" content="EduNext : Education HTML Template" />
        <meta uperty="og:description" content="EduNext : Education HTML Template" />
        <meta uperty="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduNext : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

       
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
                    <h4 class="breadcrumb-title">Setting User</h4>
                </div>	
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="mail-list-container">
                                    <div class="mail-toolbar">

                                        <form action="searchUser" method="post">
                                            <div class="row">
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-5">
                                                    <a class="btn" href="addUser.jsp">
                                                        Add a new user   
                                                    </a>
                                                </div>
                                                <div class="col-12 col-sm-9 col-md-9 col-lg-5">
                                                    <input type="text" class="form-control" name="key" placeholder="Search key" />
                                                </div>
                                                <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                    <input type="submit" class="btn btn-primary" value="Search" />
                                                </div>
                                            </div>
                                        </form>
                                       
                                    </div>
                                    <div class="mail-box-list">
                                        <section id="subject">
                                            <table class="table" id="myTable">
                                                <thead>
                                                    <tr>
                                                        <th scope="col"><span id="submitNameIcon" class="sort-icon">▼</span>Full name</th>
                                                        <th scope="col">Phone number</th>
                                                        <th scope="col">Email <span id="submitEmailIcon" class="sort-icon">▼</span></th>
                                                        <th scope="col">Role</th>
                                                        <th scope="col">Status</th>
                                                        <th scope="col">Edit</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="u" items="${list}">
                                                        <tr>
                                                            <td><c:out value="${u.fullName}"/></td>
                                                            <td><c:out value="${u.phone}"/></td>
                                                            <td><c:out value="${u.email}"/></td>
                                                            <td><c:out value="${u.roleName}"/></td>
                                                            <td><c:out value="${userDAO.getStatusDisplay(u.userId)}"/>
                                                            </td>
                                                            <td><a href="userDetail?email=${u.email}">
                                                                    Detail   
                                                                </a></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </section>
                                    </div>
                                </div>
                            </div> 
                        </div>
                        <!-- Your Profile Views Chart END-->
                    </div>
                </div>
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
<script>
    function goToPage(i) {
        document.getElementById('pageNoInput').value = i;
        document.getElementById('form').submit();
    }
</script>
<script>
document.addEventListener("DOMContentLoaded", function () {
    var submitNameIcon = document.getElementById("submitNameIcon");
    var submitEmailIcon = document.getElementById("submitEmailIcon");
    var sortOrderName = 1; // 1 for ascending, -1 for descending
    var sortOrderEmail = 1; // 1 for ascending, -1 for descending

    submitNameIcon.addEventListener("click", function () {
        sortOrderName *= -1; // Toggle between ascending and descending
        sortTable("myTable", 0, sortOrderName, submitNameIcon);
    });

    submitEmailIcon.addEventListener("click", function () {
        sortOrderEmail *= -1; // Toggle between ascending and descending
        sortTable("myTable", 4, sortOrderEmail, submitEmailIcon);
    });

    function sortTable(tableId, columnIndex, sortOrder, icon) {
        var table = document.getElementById(tableId);
        var tbody = table.querySelector("tbody");
        var rows = Array.from(tbody.querySelectorAll("tr"));

        rows.sort(function (a, b) {
            var valueA = a.cells[columnIndex].textContent.trim();
            var valueB = b.cells[columnIndex].textContent.trim();

            if (columnIndex === 4) { // Check if sorting by email
                var valueA = a.cells[columnIndex].textContent.trim();
                var valueB = b.cells[columnIndex].textContent.trim();
            }

            if (isNaN(valueA) || isNaN(valueB)) {
                // For non-numeric values, use localeCompare
                return sortOrder * valueA.localeCompare(valueB);
            } else {
                // For numeric values, use subtraction
                return sortOrder * valueA.localeCompare(valueB);
            }
        });

        rows.forEach(function (row) {
            tbody.appendChild(row);
        });

        // Update the icons based on the sort order
        resetIcons();
        icon.innerHTML = sortOrder === 1 ? "▼" : "▲";
    }

    function resetIcons() {
        submitNameIcon.innerHTML = "▼";
        submitEmailIcon.innerHTML = "▼";
    }
});
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