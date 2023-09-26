<%-- 
    Document   : register
    Created on : Sep 23, 2023, 6:48:56 PM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="cssconnect.jsp" %>
    <script>
       // validate.js
function validateForm() {
    var name = document.forms["registerForm"]["rgt_Name"].value;
    var email = document.forms["registerForm"]["rgt_Email"].value;
    var pass = document.forms["registerForm"]["rgt_Pass"].value;
    var phone = document.forms["registerForm"]["rgt_Phone"].value;
    var gender = document.querySelector('input[name="rgt_gender"]:checked');

    // Kiểm tra xem các trường đã được điền đầy đủ hay chưa
    if (name === "" || email === "" || pass === "" || phone === "" || !gender) {
        alert("Vui lòng điền đầy đủ thông tin.");
        return false;
    }

    // Kiểm tra độ dài tên người dùng (không quá 250 kí tự)
    if (name.length > 250) {
        alert("Tên người dùng không được vượt quá 250 kí tự.");
        return false;
    }

    // Kiểm tra định dạng email
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailPattern.test(email)) {
        alert("Email không hợp lệ.");
        return false;
    }

    // Kiểm tra số điện thoại (10 chữ số)
    var phonePattern = /^\d{10}$/;
    if (!phonePattern.test(phone)) {
        alert("Số điện thoại không hợp lệ. Vui lòng nhập 10 chữ số.");
        return false;
    }

    return true;
}
    </head>
    
 
    </script>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <div class="account-form">
                <div class="account-head" style="background-image:url(assets/images/background/bg2.jpg);">
                    <a href="index.html"><img src="assets/images/logo-white-2.png" alt=""></a>
                </div>
                <div class="account-form-inner">
                    <div class="account-container">
                        <div class="heading-bx left">
                            <h2 class="title-head">Sign Up <span>Now</span></h2>
                            <p>Login Your Account <a href="login.jsp">Click here</a></p>
                        </div>	
                        <form action="register" method="post" class="contact-bx">
                            <div class="row placeani">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Your Name</label>
                                            <input name="rgt_Name" type="text" required="" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Your Email Address</label>
                                            <input name="rgt_Email" type="email" required="" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <label>Your Password</label>
                                            <input name="rgt_Pass" type="password" class="form-control" required="">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Phone Number</label>
                                            <input name="rgt_Phone" type="text" required="" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div >
                                    <table bgcolor="#000000" align="center" cellspacing="5px">
                                        <tr>
                                            <td>Gender</td>
                                            <td>
                                                <input type="radio" name="rgt_gender"  value="1"> Male
                                                <input type="radio" name="rgt_gender"  value="0"> Female</td>
                                        </tr>
                                    </table>
                                    <div>
                                        

                                        <div class="col-lg-12 m-b30">
                                            <button name="submit" type="submit" value="Submit" class="btn button-md">Sign Up</button><span>${message_email}</span><span>${message_phone}</span>
                                        </div>
                                        <div class="col-lg-12">
                                            <h6>Sign Up with Social media</h6>
                                            <div class="d-flex">
                                                <a class="btn flex-fill m-r5 facebook" href="#"><i class="fa fa-facebook"></i>Facebook</a>
                                                <a class="btn flex-fill m-l5 google-plus" href="#"><i class="fa fa-google-plus"></i>Google Plus</a>
                                            </div>
                                        </div>
                                    </div>
                                    </form>
                                </div>
                            </div>
                    </div>
                </div>
                <%@include file="scripjs.jsp" %>
                </body>

                </html>

