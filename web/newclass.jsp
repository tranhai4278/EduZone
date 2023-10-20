<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="" />
    <meta name="author" content="" />
    <meta name="robots" content="" />
    <meta name="description" content="Eduzone - New Class" />
    <link rel="icon" href="../error-404.html" type="image/x-icon" />
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
    <title>Eduzone - New Class</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
    <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">
    <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
    <link rel="stylesheet" type="text css" href="assets/css/style.css">
</head>

<body class="ttr-opened-sidebar ttr-pinned-sidebar">
    <div class="page-wraper">
        <%@include file="setting-header.jsp" %>
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">New Class</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>New Class</li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Create a New Class</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="new-class-form m-b30" action="newclass" method="post">
                                    <div class="col-sm-10 ml-auto">
                                        <% String errorMessage = (String) request.getAttribute("error"); %>
                                        <% if (errorMessage != null) { %>
                                        <div class="alert alert-danger" role="alert">
                                            <strong>Error:</strong> <%= errorMessage %>
                                        </div>
                                        <% } %>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Class Code</label>
                                        <div class="col-sm-7">
                                            <input class="form-control" type="text" name="class_code" placeholder="Class Code">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Semester</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" name="semester">
                                                <c:forEach var="semester" items="${semesters}">
                                                    <option value="<c:out value='${semester.settingId}'/>"><c:out value='${semester.settingName}'/></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Lecturer</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" name="trainer">
                                                <c:forEach var="user" items="${users}">
                                                    <option value="<c:out value='${user.userId}'/>"><c:out value='${user.fullName}'/></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Subject</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" name="subject">
                                                <c:forEach var="subject" items="${subjects}">
                                                    <option value="<c:out value='${subject.subjectId}'/>"><c:out value='${subject.subjectCode}'/></option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-7">
                                            <button type="submit" class="btn">Create Class</button>
                                            <button type="reset" class="btn">Reset</button>
                                            <button type="button" class="btn-secondry" onclick="location.href = 'classlist';">Cancel</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>
        script src="assets/js/jquery.min.js"></script>
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
    </div>
</body>
</html>
