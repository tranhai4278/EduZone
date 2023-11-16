<%-- 
    Document   : admin
    Created on : Sep 24, 2023, 12:30:41 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="assignmentDAO" value="<%= new dal.AssignmentDAO() %>" />
<%@page import="model.AssignmentSubmit"%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>



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
                    <h4 class="breadcrumb-title">Assignment Evaluation</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="home"><i class="fa fa-home"></i>Home</a></li>
                        <li>Assignment Evaluation</li>
                    </ul>
                </div>
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="mail-list-container">
                                    <div class="mail-toolbar">
                                        <div class="row" style="width: 100%">
                                            <div class="col-md-6">
                                                <form action="searchAssignment" method="post">
                                                    <div class="row">
                                                        <div class="col-12 col-sm-9 col-md-9 col-lg-4">
                                                            <input type="text" class="form-control" name="key" placeholder="Enter fullname" />
                                                        </div>
                                                        <div class="col-12 col-sm-3 col-md-3 col-lg-1">
                                                            <input type="submit" class="btn btn-primary" value="Search" />
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                            <div class="col-md-2">
                                                <select id="filterStatus" name="status" onchange="filterTableByStatus()">
                                                    <option  ${type == -1 ? ' selected' : ' '} value="-1">Status</option>
                                                    <option ${status ==1 ? ' selected' : ' '} value="1">Submitted</option>
                                                    <option ${status ==0 ? ' selected' : ' '} value="0">Unsubmitted</option>
                                                </select>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mail-box-list">
                                    <table class="table" id="myTable">
                                        <thead>
                                            <tr>
                                                <th scope="col">Full Name <span id="submitNameIcon" class="sort-icon">▼</span></th>
                                                <th scope="col">Submission</th>
                                                <th scope="col">Submit time <span id="submitTimeIcon" class="sort-icon">▼</span> </th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Grade <span id="submitGradeIcon" class="sort-icon">▼</span></th>
                                                <th scope="col">Comment</th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="a" items="${list}" >
                                                <tr>
                                            <input type="hidden" name="assignmentID" value="${a.getaID()}">
                                            <input type="hidden" name="classID" value="${a.getClassID()}">
                                            <input type="hidden" name="traineeID" value="${a.getTraineeID()}">
                                            <td>${assignmentDAO.getTraineeName(a.getTraineeID())}</td>
                                            <td>${a.getFile()}</td>
                                            <td>${a.getSubmitTime()}</td>
                                            <td data-status="${a.isStatus() ? 'submitted' : 'unsubmitted'}">
                                                ${assignmentDAO.getStatusDisplay(a.getaID(),a.getClassID(), a.getTraineeID())}
                                            </td>
                                            <td>${a.getMark()}</td>
                                            <td>${a.getComment()}</td>
                                            <td>
                                                <div class="col-md-2 offset-md-4">
                                                    <c:if test="${sessionScope.user.roleId == 3}">
                                                        <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#chapterModal"
                                                           onclick="setEvaluationData('${a.getaID()}', '${a.getClassID()}', '${a.getTraineeID()}')">
                                                            Grade   
                                                        </a>
                                                    </c:if>
                                                </div>
                                            </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
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
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="chapterModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Assignment Evaluation</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form class="edit-profile m-b30" action="evaluate" method="post">
                        <input type="hidden" name="assignmentID" id="assignmentID">
                        <input type="hidden" name="classID" id="classID">
                        <input type="hidden" name="traineeID" id="traineeID">
                        <div class="row">
                            <div class="col-12">
                                <div class="ml-auto">
                                    <h3>Grade</h3>
                                </div>
                            </div>
                            <div class="form-group col-12">
                                <div>
                                    <input class="form-control" type="text" name="mark" required>
                                </div>
                            </div>
                            <div class="seperator"></div>
                            <div class="col-12">
                                <div class="ml-auto">
                                    <h3>Comment</h3>
                                </div>
                            </div>
                            <div class="form-group col-12">
                                <textarea id="summernote" name="comment" style="width: 100%; height: 150px;"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn">Save</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<div class="ttr-overlay"></div>
<!-- External JavaScripts -->

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
    function setEvaluationData(assignmentID, classID, traineeID) {
        document.getElementById("assignmentID").value = assignmentID;
        document.getElementById("classID").value = classID;
        document.getElementById("traineeID").value = traineeID;
    }

</script>

<script>
document.addEventListener("DOMContentLoaded", function () {
    var submitTimeIcon = document.getElementById("submitTimeIcon");
    var sortOrder = 1; // 1 for ascending, -1 for descending

    submitTimeIcon.addEventListener("click", function () {
        sortOrder *= -1; // Toggle between ascending and descending

        var table = document.getElementById("myTable");
        var tbody = table.querySelector("tbody");
        var rows = Array.from(tbody.querySelectorAll("tr"));

        rows.sort(function (a, b) {
            var dateA = new Date(a.cells[2].textContent);
            var dateB = new Date(b.cells[2].textContent);

            return sortOrder * (dateA - dateB);
        });

        rows.forEach(function (row) {
            tbody.appendChild(row);
        });

        // Update the icon based on the sort order
        submitTimeIcon.innerHTML = sortOrder === 1 ? "▼" : "▲";
    });
});
</script>
<script>
document.addEventListener("DOMContentLoaded", function () {
    var submitNameIcon = document.getElementById("submitNameIcon");
    var submitGradeIcon = document.getElementById("submitGradeIcon");
    var sortOrderName = 1; // 1 for ascending, -1 for descending
    var sortOrderGrade = 1; // 1 for ascending, -1 for descending

    submitNameIcon.addEventListener("click", function () {
        sortOrderName *= -1; // Toggle between ascending and descending
        sortTable("myTable", 0, sortOrderName, submitNameIcon);
    });

    submitGradeIcon.addEventListener("click", function () {
        sortOrderGrade *= -1; // Toggle between ascending and descending
        sortTable("myTable", 4, sortOrderGrade, submitGradeIcon);
    });

    function sortTable(tableId, columnIndex, sortOrder, icon) {
        var table = document.getElementById(tableId);
        var tbody = table.querySelector("tbody");
        var rows = Array.from(tbody.querySelectorAll("tr"));

        rows.sort(function (a, b) {
            var valueA = a.cells[columnIndex].textContent.trim();
            var valueB = b.cells[columnIndex].textContent.trim();

            if (columnIndex === 4) { // Check if sorting by grade
                valueA = parseFloat(valueA);
                valueB = parseFloat(valueB);
            }

            if (isNaN(valueA) || isNaN(valueB)) {
                // For non-numeric values, use localeCompare
                return sortOrder * valueA.localeCompare(valueB);
            } else {
                // For numeric values, use subtraction
                return sortOrder * (valueA - valueB);
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
        submitGradeIcon.innerHTML = "▼";
    }
});
</script>
<script>
    function filterTableByStatus() {
        var statusFilter = document.getElementById("filterStatus");
        // Lấy bảng và tất cả các dòng trong tbody
        var table = document.getElementById("myTable");
        var rows = table.querySelectorAll("tbody tr");

        // Lắng nghe sự kiện thay đổi của dropdown
        statusFilter.addEventListener("change", function () {
            // Lấy giá trị được chọn trong dropdown
            var selectedStatus = this.value;

            // Duyệt qua tất cả các dòng và ẩn/hiển thị dựa trên trạng thái đã chọn
            rows.forEach(function (row) {
                // Lấy giá trị trạng thái từ thuộc tính data-status
                var rowStatus = row.getAttribute("data-status");

                // Ẩn hoặc hiển thị dòng dựa trên giá trị của dropdown
                row.style.display = selectedStatus === "-1" || selectedStatus === rowStatus ? "table-row" : "none";
            });
        });
    }
</script>

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
<!--        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>-->
</body>

<!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>