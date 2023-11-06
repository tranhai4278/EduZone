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
                        <form id="addPractieQuizForm" action="quizs" method="get" >
                            <input type="text" name="action" style="display: none" value="addQuiz">
                            <!--Name-->
                            <div class="form-group" style="margin-top:10px; margin-top: 20px">
                                <label for="name">Quiz Name:</label>
                                <input type="text" class="form-control" id="nameInput" name="name">
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
                                    <input type="text" class="form-control" id="nameInput" name="name">
                                    <div id="nameError" class="error"></div>
                                </div>
                                <!--NumOfQues-->
                                <div class="col-md-6" style="margin-top:10px; margin-top: 20px">
                                    <label for="name">NumberOfQuestion:</label>
                                    <input type="text" class="form-control" id="nameInput" name="name">
                                    <div id="nameError" class="error"></div>
                                </div>
                            </div>



                            <div class="form-group" id = "dimension">
                                <div  style="margin-top:10px; margin-top: 20px">
                                    <label for="dimentype">Choose a dimention type</label>
                                    <select name="searchBySubject">
                                        <option value="">dimention Type 1</option>
                                    </select>
                                </div>
                                <div class="row">
                                    <div class="col-md-6" style="margin-top:10px; margin-top: 20px">
                                        <label for="dimentype">Choose Question Dimention</label>
                                        <select name="dimentionQues">
                                            <option value="">dimention name 1</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div id = "chapter">
                                <div class="row">
                                    <div class="col-md-6" style="margin-top:10px; margin-top: 20px">
                                        <label for="chap">Choose Question Chapter</label>
                                        <select name="chapques">
                                            <option value="">chapter 1</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer" style="justify-content: flex-start">
                        <button type="submit" class="btn btn-primary" form="addPractieQuizForm" onclick="validateForm()">Take Quiz</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
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
                    $('#addQuizForm').submit();
                } else {
                    event.preventDefault();
                }
            }
        </script>
    </body>
</html>
