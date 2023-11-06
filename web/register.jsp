<%-- 
    Document   : register
    Created on : Sep 23, 2023, 6:48:56 PM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="cssconnect.jsp" %>
    <script>
        // Validate the form on submit
        function validateForm() {
            var yourname = document.getElementById("yourname").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;
            var phone = document.getElementById("phone").value;
            var successMessage = document.getElementById("successMessage");
            var isValid = true;

            if (successMessage) {
                successMessage.style.display = "none";
            }

            // Validate fullName
            if (!/^[\p{L} ]+$/u.test(yourname)) {
                document.getElementById("yourNameError").innerHTML = "Fullname should only contain letters";
                isValid = false;
            } else {
                document.getElementById("yourNameError").innerHTML = "";
            }

            // Validate email
            if (!/\S+@\S+\.\S+/.test(email)) {
                document.getElementById("emailError").innerHTML = "Invalid email format";
                isValid = false;
            } else {
                document.getElementById("emailError").innerHTML = "";
            }

            // Validate password
            if (!/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W)^.{8,16}$/.test(password)) {
                document.getElementById("passwordError").innerHTML = "Passwordshould have from 8 to 16 characters, at least one uppercase, one digit, and one special character";
                isValid = false;
            } else {
                document.getElementById("passwordError").innerHTML = "";
            }

            // Validate phone
            if (!/^\d{7,11}$/.test(phone)) {
                document.getElementById("phoneError").innerHTML = "Phones can only contain numbers and have 10 numbers";
                isValid = false;
            } else {
                document.getElementById("phoneError").innerHTML = "";
            }

            return isValid;
        }
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
                        <form name="registerForm" action="register" method="post" class="contact-bx" onsubmit="return validateForm()">
                            <div class="row placeani">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Your Name</label>
                                            <input name="rgt_Name" id="yourname" type="text" required maxlength="20" class="form-control">
                                            <span id="yourNameError" class="error-message position-relative"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Your Email Address</label>
                                            <input name="rgt_Email" id="email" type="email" required maxlength="30"  class="form-control">
                                            <span id="emailError" class="error-message position-relative"></span>
                                        </div><span>${message_domain}</span>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <label>Your Password</label>
                                            <input name="rgt_Pass" id="password" type="password" class="form-control" required maxlength="16">
                                            <span id="passwordError" class="error-message position-relative"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Phone Number</label>
                                            <input name="rgt_Phone" id="phone" type="text" class="form-control" required maxlength="11">
                                            <span id="phoneError" class="error-message position-relative"></span>
                                        </div>
                                    </div>
                                </div>
                                <div >
                                    <table bgcolor="#000000" align="center" cellspacing="5px">
                                        <tr>
                                            <td>Gender</td>
                                            <td>
                                                <input id="gender" type="radio" name="rgt_gender" required value="1"> Male
                                                <input id="gender" type="radio" name="rgt_gender" required value="0"> Female</td>
                                        </tr>
                                    </table>
                                    <div>
                                        <div class="col-lg-12 m-b30">
                                            <button name="submit" type="submit" value="Submit" class="btn button-md">Sign Up</button><span>${message_email}</span><span>${message_phone}</span>
                                        </div>
                                        <div class="col-lg-12">
                                            <h6>Login with Social media</h6>
                                            <div class="d-flex">
                                                <!--<a class="btn flex-fill m-r5 facebook" href="#"><i class="fa fa-facebook"></i>Facebook</a>-->
                                                <a class="btn flex-fill m-l5 google-plus" 
                                                   href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:9999/eduzone/LoginGoogleHandler&response_type=code
                                                   &client_id=873369314493-0633objgah4ms59h8cihg92v1lphq2am.apps.googleusercontent.com&approval_prompt=force">
                                                    <i class="fa fa-google-plus"></i>Google Plus</a>
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

