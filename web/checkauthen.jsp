<%-- 
    Document   : checkauthen
    Created on : Sep 23, 2023, 6:50:09 PM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Get your OTP</title>
        <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
        <script
        src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

        <style type="text/css">
            .form-gap {
                padding-top: 70px;
            }
        </style>
    </head>

    <body>
        <div class="form-gap"></div>
        
        <div class="container">
             
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-center">
                                <h3>Hello ${sessionScope.user_rgt.fullName} ! </h3>
                                <h3>
                                    <i class="fa fa-lock fa-4x"></i>
                                </h3>
                                <h2 class="text-center">Enter OTP</h2>
                               
                                <div class="panel-body">

                                    <form id="register-form" action="authen" method="post"role="form" autocomplete="off"
                                          class="form">

                                        <div class="form-group">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i
                                                        class="glyphicon glyphicon-envelope color-blue"></i></span> <input
                                                    id="opt" name="code" placeholder="Enter OTP"
                                                    class="form-control" type="text" required="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input name="Verify" value="Verify"
                                                   class="btn btn-lg btn-primary btn-block"
                                                    type="submit"><span>${message}</span>
                                            <p id="resendLink">Click <a href="authen">here</a> to resend OTP</p>
                                        </div>

                                        <input type="hidden" class="hide" name="token" id="token"
                                               value="">
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
