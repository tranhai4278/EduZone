<%-- 
    Document   : newPracticeQuiz
    Created on : Nov 5, 2023, 2:40:55 PM
    Author     : MinhDQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .error {
                color: red;
            }
        </style>

        <script>
            $(document).ready(function () {
                // Ẩn toàn bộ các thông tin khi trang tải
                $('#chapter').hide();
                $('#dimension').show;

                // Bắt sự kiện khi ấn vào nút Chapter
                $('#btn-chapter').click(function () {
                    $('#chapter').show();
                    $('#dimension').hide();
                });

                // Bắt sự kiện khi ấn vào nút Dimention
                $('#btn-dimention').click(function () {
                    $('#chapter').hide();
                    $('#dimension').show();
                });
            });
        </script>
    </head>
    <body>
        <div class="modal fade" id="NewQuiz" tabindex="-1" role="dialog" aria-labelledby="NewQuizLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addProductModalLabel">Add Quiz</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="newpracticequiz?sid=${detail.subjectId}" method="post" >
                            <!--Name-->
                            <div class="form-group" style="margin-top:10px; margin-top: 20px">
                                <label for="name">Quiz Name:</label>
                                <input type="text" class="form-control" id="quiz_name" name="quiz_name">
                                <div id="nameError" class="error"></div>
                            </div>

                            <!--Type-->
                            <div>
                                <label for="type">Quiz Type:</label><br>
                                <div class="form-check form-check-inline" style="margin-right: 60px">
                                    <input class="form-check-input" type="radio" name="type" id="btn-dimention" value="false" checked/>
                                    <label class="form-check-label" for="randomQues">By Dimensions</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="type" id="btn-chapter" value="true" />
                                    <label class="form-check-label" for="fixedQues">By Chapter</label>
                                </div>
                            </div>
                            <div class="row">
                                <!--Duration-->
                                <div class="col-md-6" style="margin-top:10px; margin-top: 20px">
                                    <label for="name">Duration:</label>
                                    <input type="text" class="form-control" id="duration" name="duration">
                                    <div id="nameError" class="error"></div>
                                </div>
                                <!--NumOfQues-->
                                <div class="col-md-6" style="margin-top:10px; margin-top: 20px">
                                    <label for="name">NumberOfQuestion:</label>
                                    <input type="text" class="form-control" id="numOfQues" name="numOfQues">
                                    <div id="nameError" class="error"></div>
                                </div>
                            </div>



                            <div class="form-group" id = "dimension">
                                <div  style="margin-top:10px; margin-top: 20px">
                                    <label for="dimentype">Choose Question dimention</label>
                                    <select name="dimName">
                                        <c:forEach var="ss" items="${listss}">
                                            <option value="${ss.settingId}">${ss.getSettingType()}/${ss.getSettingName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div id = "chapter">
                                <div class="row">
                                    <div class="col-md-6" style="margin-top:10px; margin-top: 20px">
                                        <label for="chapName">Choose Question Chapter</label>
                                        <select name="chapques">
                                            <c:forEach var="c" items="${listC}">
                                                <option value="${ss.settingId}">${c.settingName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer" style="justify-content: flex-start">
                                <button name="submit" type="submit" value="Submit" class="btn btn-primary">Save Quiz</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>

        <script>
            function validateForm() {
                let name = $('#nameInput').val();
//                let total = $('#totalInput').val();
                //xoá thông báo lỗi hiện tại
                $('.error').html('');
                if (name === '') {
                    $('#nameError').html('Name of quiz must not be empty');
                } else if (name.length > 100) {
                    $('#nameError').html('Name of quiz must less than or equal 100 characters');
                }
                if (total === '') {
//                    $('#totalError').html('Total questions must not be empty');
                } else if (!$.isNumeric(total) || parseInt(total) < 0) {
                    $('#totalError').html('Total questions must be digits and greater than 0');
                }


                // Kiểm tra nếu không có lỗi thì submit form
                let error = '';
                $('.error').each(function () {
                    error += $(this).html();
                });
                if (error === '') {
                    $('#addPracticeQuizForm').submit();
                } else {
                    event.preventDefault();
                }
            }
        </script>
    </body>
</html>
