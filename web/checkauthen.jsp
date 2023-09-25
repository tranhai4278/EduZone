<%-- 
    Document   : checkauthen
    Created on : Sep 23, 2023, 6:50:09 PM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>authentication</title>
    </head>
    <style>
        /* Reset các giá trị padding và margin */
        * {
            margin: 0;
            padding: 0;
        }

        /* Thiết lập font chữ và background cho body */
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
        }


        .form-container {
            text-align: center;
            background-color: #f2f2f2;
            padding: 20px;
        }


        /* Thiết lập độ rộng của form */
        form {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h3 {
            font-family: 'Montserrat', sans-serif;
            font-weight: bold;
            color: red;
            text-align: center;
            margin-bottom: 20px;
        }

        /* Thiết lập kiểu chữ cho tiêu đề */
        h4,p  {
            font-family: 'Montserrat', sans-serif;
            font-weight: bold;
            color: red;
            text-align: center;
        }
        .input_otp {
            padding: 10px;
            border: 2px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            color: #333;
            margin-top: 20px;
            margin-bottom: 20px;
            text-align: center;
        }

        .input_otp:focus {
            outline: none;
            border-color: #1e90ff;
        }


        /* Thiết lập kiểu chữ cho nội dung thông báo */


        /* Thiết lập kiểu chữ cho link */
        a:hover {
            color: #00688B;
        }

        /* Thiết lập kiểm soát cho phần countdown */
        #timer {
            font-weight: bold;
            font-size: 24px;
            display: block;
            margin-top: 30px;
            animation: pulse 1s ease-in-out infinite;
        }

        /* Thiết lập style cho nút resubmit */
        input[type="submit"] {
            background: #008CBA;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin-bottom: 20px;
        }

        /* Thiết lập hover cho nút resubmit */
        input[type="submit"]:hover {
            background: #005A7D;
            transform: scale(1.05);
        }
        @keyframes pulse {
            0% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.05);
            }
            100% {
                transform: scale(1);
            }
        }
    </style>
    <body>
        <div class="form-container">
            <form action="authen" method="post">
                <h3>The otp code has been sent to your email</h3>
                <h3>Enter the correct code to verify account</h3>
                Hello ${sessionScope.user_rgt.fullName} <br/>
                <input class="input_otp" type="text" name="ma"><br><br>
                <input type="submit" name="xacThuc" value="Xac thuc">
            </form>
        </div>
    </body>
</html>-->
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
                                                    id="opt" name="ma" placeholder="Enter OTP"
                                                    class="form-control" type="text" required="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input name="xacThuc" value="Xac thuc"
                                                   class="btn btn-lg btn-primary btn-block"
                                                    type="submit"><span>${message}</span>
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
