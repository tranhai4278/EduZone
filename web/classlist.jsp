<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userDAO" value="<%= new dal.UserDAO() %>" />
<%@page import="model.User" %>

<!DOCTYPE html>
<html>

    <head>
        <!-- Your existing head content -->
    </head>

    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <%@include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Setting</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Setting</li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="">
                                    <!-- Search Bar Section -->
                                    <form action="searchclasses" method="post">
                                        <div class="row">
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                <input type="text" class="form-control" name="search" placeholder="Search by Class Code or Teacher" />
                                            </div>
                                            <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                <input type="submit" class="btn btn-primary" value="Search" />
                                            </div>
                                        </div>
                                    </form>

                                    <!-- Subject Filter Section -->
                                    <form action="filterclasses" method="post">
                                        <div class="row">
                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                <select name="selectedSubject" class="form-control-sm">
                                                    <option value="">Select Subject</option>
                                                    <c:forEach var="subject" items="${subjects}">
                                                        <option value="${subject.subjectCode}">${subject.subjectCode}</option>
                                                    </c:forEach>
                                                </select>
                                                <div class="row"></div>
                                            </div>
                                            <div class="col-12 col-sm-2 col-md-2 col-lg-2">
                                                <button class="btn btn-primary">Filter</button>
                                            </div>
                                        </div>
                                    </form>

                                    <form action="classlist" method="post">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Select</th>
                                                    <th scope="col">Class Code</th>
                                                    <th scope="col">Subject</th>
                                                    <th scope="col">Teacher's Name</th>
                                                    <th scope="col">Status</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="classObj" items="${classes}">
                                                    <tr>
                                                        <td>
                                                            <input type="checkbox" name="selectedClasses" value="${classObj.ID}" />
                                                        </td>
                                                        <td>
                                                            <a href="classdetail?Code=${classObj.classCode}">
                                                                ${classObj.classCode}
                                                            </a>
                                                        </td>
                                                        <td>
                                                            <c:forEach var="subjects" items="${subjects}">
                                                                <c:if test="${subjects.subjectId eq classObj.subjectID}">
                                                                    <c:out value="${subjects.subjectCode}" />
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td>
                                                            <c:forEach var="users" items="${users}">
                                                                <c:if test="${users.userId eq classObj.trainerID}">
                                                                    <c:out value="${users.fullName}" />
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td><c:out value="${classObj.status ? 'Active' : 'Inactive'}" /></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>

                                        <button type="submit" class="btn btn-primary" name="action" value="activate">Activate</button>
                                        <button type="submit" class="btn btn-primary" name="action" value="deactivate">Deactivate</button>
                                        <button type="button" class="btn-secondry" onclick="window.location.href = 'newclass'">Create a new Class</button>
                                    </form>
                                
                                </div>
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

    </body>
</html>
