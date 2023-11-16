<%-- 
    Document   : subjectDetail
    Created on : Oct 18, 2023, 2:40:21 AM
    Author     : Nết
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/basic-calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
    <head>

        <!-- META ============================================= -->
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
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/logo.sm.png" />
        <title>EduNext : Education HTML Template </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <script>
            $(document).ready(function () {
                // Ẩn toàn bộ các thông tin khi trang tải
                $('#general').show();
                $('#chapter').hide();
                $('#dimension').hide();

                // Bắt sự kiện khi ấn vào nút General
                $('#btn-general').click(function () {
                    $('#general').show();
                    $('#chapter').hide();
                    $('#dimension').hide();
                });

                // Bắt sự kiện khi ấn vào nút Chapter
                $('#btn-chapter').click(function () {
                    $('#general').hide();
                    $('#chapter').show();
                    $('#dimension').hide();
                });

                // Bắt sự kiện khi ấn vào nút Dimention
                $('#btn-dimention').click(function () {
                    $('#general').hide();
                    $('#chapter').hide();
                    $('#dimension').show();
                });
            });
        </script>

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file="setting-header.jsp" %>

        <!-- Left sidebar menu end -->

        <!--Main container start -->
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
                    <h4 class="breadcrumb-title">${detail.subjectCode}</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="settingSubject">Subject Setting</a></li>

                        <li>${detail.subjectCode}</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <button class="btn btn-light" id="btn-general">
                            General
                        </button>
                        <button class="btn btn-light" id="btn-chapter">
                            Chapter
                        </button>
                        <button class="btn btn-light" id="btn-dimention">
                            Dimension
                        </button>
                        <div class="widget-box">

                            <div class="widget-inner">
                                <div id="general">
                                    <form class="edit-profile m-b30" action="editsubject" method="post">
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="ml-auto">
                                                    <h3>1. Basic info</h3>
                                                </div>
                                            </div>
                                            <div class="form-group col-6">
                                                <input class="form-control" type="text" value="${detail.subjectId}" hidden="" name="id"  >
                                                <label class="col-form-label">Subject code</label>
                                                <div>
                                                    <input class="form-control" type="text" value="${detail.subjectCode}" name="scode" required maxlength="11" <c:if test="${sessionScope.user.roleId == 2 }">readonly </c:if>>
                                                    </div>
                                                    <p style="color: red">${requestScope.error}</p>
                                            </div>
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Subject name</label>
                                                <div>
                                                    <input class="form-control" type="text" value="${detail.subjectName}" name="sname" required maxlength="50" <c:if test="${sessionScope.user.roleId == 2 }">readonly </c:if>>
                                                    </div>
                                                </div>
                                            <c:if test="${sessionScope.user.roleId == 1 }">
                                                <div class="form-group col-6">
                                                    <label class="col-form-label" >Manager</label>
                                                    <select
                                                        name="mid"
                                                        id="manager"
                                                        >
                                                        <c:forEach items="${listSM}" var="s">
                                                            <option <c:if test="${detail.managerId eq s.userId}">
                                                                    selected
                                                                </c:if> value="${s.userId}">
                                                                ${s.fullName}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="form-group col-3">
                                                    <label class="col-form-label">Status</label>
                                                    <div class="form-check form-switch">
                                                        <input name="on"  style="margin: 0" class="form-check-input" type="checkbox" ${detail.isStatus() ? 'checked' : ' '} >
                                                    </div>
                                                </div>
                                            </c:if>

                                            <div class="seperator"></div>

                                            <div class="col-12 m-t20">
                                                <div class="ml-auto m-b5">
                                                    <h3>2. Description</h3>
                                                </div>
                                            </div>
                                            <div class="form-group col-12">
                                                <label class="col-form-label">Subject description</label>
                                                <div>
                                                    <textarea class="form-control" name="description" required maxlength="250" <c:if test="${sessionScope.user.roleId == 2 }">readonly </c:if>>${detail.description} </textarea>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <a href="settingSubject" type="button" class="btn-secondry add-item m-r5" ><i class="fa fa-fw fa-arrow-left"></i>Cancel</a>
                                                <button type="submit" onclick="setSellDate()" class="btn">Save changes</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                                <div class="mail-list-container" id="chapter">
                                    <h3>Chapter</h3>
                                    <div class="mail-toolbar">
                                        <div class="row" style="width: 100%">
                                            <div class="col-sm-2 offset-10">
                                                <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#chapterModal">
                                                    Add a new Chapter   
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mail-box-list">
                                        <section id="role">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Chapter</th>
                                                        <th scope="col">Description</th>
                                                        <th scope="col">Display Order </th>
                                                        <th scope="col">Status</th>
                                                        <th scope="col">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="s" items="${listC}" >
                                                        <tr>
                                                            <td>${s.settingName}</td>
                                                            <td>${s.description}</td>
                                                            <td>${s.displayOrder}</td>
                                                            <td>
                                                                <div class="form-check form-switch">
                                                                    <input style="margin: 0" class="form-check-input" type="checkbox" ${s.isStatus() ? 'checked' : ''} onclick="updateStatus(${s.settingId},${s.subjectId}, this)">
                                                                </div>
                                                            <td>
                                                                <a href="editSubjectSetting?sid=${s.settingId}" class="tm-product-delete-link">
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
                                <div class="mail-list-container" id="dimension">
                                    <h3>Dimension</h3>
                                    <div class="mail-toolbar">
                                        <div class="row" style="width: 100%">
                                            <div class="col-sm-2 offset-sm-10">
                                                <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#dimentionModal">
                                                    Add a new Dimension   
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="mail-box-list">
                                        <section id="role">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Type</th>
                                                        <th scope="col">Name</th>
                                                        <th scope="col">Description</th>
                                                        <th scope="col">Display Order </th>
                                                        <th scope="col">Status</th>
                                                        <th scope="col">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="s" items="${listD}" >
                                                        <tr>
                                                            <td>${s.settingType}</td>
                                                            <td>${s.settingName}</td>
                                                            <td>${s.description}</td>
                                                            <td>${s.displayOrder}</td>
                                                            <td>
                                                                <div class="form-check form-switch">
                                                                    <input style="margin: 0" class="form-check-input" type="checkbox" ${s.isStatus() ? 'checked' : ''} onclick="updateStatus(${s.settingId},${s.subjectId}, this)">
                                                                </div>
                                                            <td>
                                                                <a href="editSubjectSetting?sid=${s.settingId}" class="tm-product-delete-link">
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

                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>

            <div class="modal fade" id="chapterModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add Chapter</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form class="edit-profile m-b30" action="subjectDetail" method="post">
                                <div class="row">
                                    <div class="col-12">
                                        <div class="ml-auto">
                                            <h3>1. Basic info</h3>
                                        </div>
                                    </div>
                                    <input name="sid" value="${detail.subjectId}" hidden>
                                    <input name="sid" value="${detail.subjectId}" hidden>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Chapter Name<span style="color: red">*</span></label>
                                        <div>
                                            <input class="form-control" type="text"  name="name" required maxlength="50" >
                                        </div>
                                    </div>
                                    <input name="type"  value="Chapter" hidden>

                                    <div class="form-group col-6">
                                        <label class="col-form-label">Display Order<span style="color: red">*</span></label>
                                        <div>
                                            <input class="form-control" type="number"  name="displayOrder" required maxlength="11" >
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Status</label>
                                        <div class="form-check form-switch">
                                            <input name="on"  style="margin: 0" class="form-check-input" type="checkbox">
                                        </div>
                                    </div>
                                    <div class="seperator"></div>
                                    <div class="col-12 m-t20">
                                        <div class="ml-auto m-b5">
                                            <h3>2. Description</h3>
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-form-label">Chapter Description</label>
                                        <div>
                                            <textarea class="form-control" name="description" required maxlength="250" > </textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                    <button type="submit" onclick="setSellDate()" class="btn">Add</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="dimentionModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add Dimention<span style="color: red">*</span></h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form class="edit-profile m-b30" action="extraLesson" method="post">
                                <div class="row">
                                    <div class="col-12">
                                        <div class="ml-auto">
                                            <h3>1. Basic info</h3>
                                        </div>
                                    </div>
                                    <input name="sid" value="${detail.subjectId}" hidden>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Dimention Type<span style="color: red">*</span></label>
                                        <div>
                                            <input class="form-control" type="text"  name="type" required maxlength="20" >
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Dimention Name<span style="color: red">*</span></label>
                                        <div>
                                            <input class="form-control" type="text"  name="name" required maxlength="50" >
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Display Order<span style="color: red">*</span></label>
                                        <div>
                                            <input class="form-control" type="number"  name="displayOrder" required maxlength="11" >
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Status</label>
                                        <div class="form-check form-switch">
                                            <input name="on"  style="margin: 0" class="form-check-input" type="checkbox">
                                        </div>
                                    </div>
                                    <div class="seperator"></div>
                                    <input name="dimension"  value="Chapter" hidden>
                                    <div class="col-12 m-t20">
                                        <div class="ml-auto m-b5">
                                            <h3>2. Description</h3>
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-form-label">Dimention Description</label>
                                        <div>
                                            <textarea class="form-control" name="description" required maxlength="250" > </textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                    <button type="submit" onclick="setSellDate()" class="btn">Add</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

        </main>
        <div class="ttr-overlay"></div>
        <script>
            function updateStatus(id, sid, checkbox) {
                let status = checkbox.checked;
                if (confirm('Are you sure?'))
                    window.location.href = 'updateStatusChapter?id=' + id + '&sid=' + sid + '&status=' + status;
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

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/basic-calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>
