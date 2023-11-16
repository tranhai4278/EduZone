<%-- 
    Document   : login
    Created on : Sep 23, 2023, 6:49:14 PM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="cssconnect.jsp" %>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <div class="account-form">
                <div class="account-head" style="background-image:url(assets/images/logo.sm.png);">
                    <a href="index.html"><img src="assets/images/logo.png" alt=""></a>
                </div>
                <div class="account-form-inner">
                    <div class="account-container">
                        <div class="heading-bx left">
                            <h2 class="title-head">Login to your <span>Account</span></h2>
                            <p>Don't have an account? <a href="register.jsp">Create one here</a></p>
                        </div>	
                        <form action="login" method="post" class="contact-bx">
                            <div class="row placeani">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <label>Your Email</label>
                                            <input name="lg_email" type="text" required="" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <div class="input-group"> 
                                            <label>Your Password</label>
                                            <input name="lg_pass" type="password" class="form-control" required="">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group form-forget">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customControlAutosizing">
                                            <label class="custom-control-label" for="customControlAutosizing">Remember me</label>
                                        </div>
                                        <a href="forgetpassword.jsp" class="ml-auto">Forgot Password?</a>
                                    </div>
                                </div>
                                <div class="col-lg-12 m-b30">
                                    <button name="submit" type="submit" value="Submit" class="btn button-md">Login</button><span>${message}</span><span>${message1}</span><span>${err}</span>
                                </div>
                                <div class="col-lg-12">
                                    <h6>Login with Social media</h6>
                                    <div class="d-flex">
                                        <!--<a class="btn flex-fill m-r5 facebook" href="#"><i class="fa fa-facebook"></i>Facebook</a>-->
                                        <a class="btn flex-fill m-l5 google-plus" 
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
