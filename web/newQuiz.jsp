<%-- 
    Document   : newQuiz
    Created on : Oct 19, 2023, 10:40:24 PM
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
                        <form id="addQuizForm" action="quizs" method="get" >
                            <input type="text" name="action" style="display: none" value="addQuiz">
                            <div class="row">
<!--                                Subject-->
                                <div class="col-md-6">
                                    <select id="subject" name="subject" onchange="getChapters(this)">
                                        <option value="">Nothing selected</option>
                                        <c:forEach items="${subjectList}" var="i">
                                            <c:if test="${searchBySubject == i.subjectId}">
                                                <option value="${i.subjectId}" selected style="text-align: left">${i.subjectCode}</option>
                                            </c:if>
                                            <c:if test="${searchBySubject != i.subjectId}">
                                                <option value="${i.subjectId}"  style="text-align: left">${i.subjectCode}</option>
                                            </c:if>        
                                        </c:forEach>
                                    </select>
                                </div>
<!--                                Chapter-->
                                <div class="col-md-6" id="content">
                                    
                                </div>   
                                
                            </div>  
                            <!--Name-->
                            <div class="form-group" style="margin-top:10px; margin-top: 20px">
                                <label for="name">Quiz Name:</label>
                                <input type="text" class="form-control" id="nameInput" name="name">
                                <div id="nameError" class="error"></div>
                            </div>
                            <!--Type-->
                            <div>
                                <label for="type">Type:</label><br>
                                <div class="form-check form-check-inline" style="margin-right: 60px">
                                    <input class="form-check-input" type="radio" name="type" id="randomQues" value="false" checked/>
                                    <label class="form-check-label" for="randomQues">Random Questions</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="type" id="fixedQues" value="true" />
                                    <label class="form-check-label" for="fixedQues">Fixed Questions</label>
                                </div>
                            </div>

                            <!--Total-->
                            <div class="form-group" style="margin-top: 23px">
                                <label for="total">Total of questions:</label>
                                <input type="number" class="form-control" id="totalInput" name="total">
                                <div id="totalError" class="error"></div>
                            </div>

                            <!--Time-->
                            <div class="form-group" style="margin-top: 23px">
                                <label for="time">Duration:</label>
                                <input type="number" class="form-control" id="totalInput" name="time">
                                <div id="totalError" class="error"></div>
                            </div>

                            <!--Status-->
                            <div style="margin-bottom: 25px">
                                <label for="status">Status:</label><br>
                                <div class="form-check form-check-inline" style="margin-right: 142px">
                                    <input class="form-check-input" type="radio" name="status" id="Inactive" value="false" checked/>
                                    <label class="form-check-label" for="Inactive">Inactive</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="status" id="Active" value="true" />
                                    <label class="form-check-label" for="Active">Active</label>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer" style="justify-content: flex-start">
                        <button type="submit" class="btn btn-primary" form="addQuizForm" onclick="validateForm()">Add</button>
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
        <script>
            function getChapters(selectElement) {
                var subject = selectElement.value;
                console.log(1);
                $.ajax({
                    url: "/eduzone/getchapbysubject",
                    type: "get",
                    data: {
                        subject: subject
                    },
                    success: function (data) {
                        var content = document.getElementById("content");
                        content.innerHTML = data;
                    },
                    error: function (xhr) {
                        // Xử lý lỗi ở đây nếu cần
                    }
                });
            }
        </script>
    </body>
</html>


