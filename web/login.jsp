<%-- 
    Document   : login
    Created on : Sep 19, 2023, 2:33:41 PM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="assets/css/all.css">
  <link rel="stylesheet" href="assets/css/eduzone/login.css">
  <link rel="stylesheet" href="assets/css/eduzone/index.css">
  <title>Bootstrap demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
  <section class="vh-100">
    <div class="container-fluid h-custom">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-9 col-lg-6 col-xl-5">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp" class="img-fluid"
            alt="Sample image">
        </div>
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
          <form>
            <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
              <p class="lead fw-normal mb-0 me-3">Sign in with</p>
              <button type="button" class="btn btn-primary btn-floating mx-1">
                <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 488 512"><!--! Font Awesome Free 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M488 261.8C488 403.3 391.1 504 248 504 110.8 504 0 393.2 0 256S110.8 8 248 8c66.8 0 123 24.5 166.3 64.9l-67.5 64.9C258.5 52.6 94.3 116.6 94.3 256c0 86.5 69.1 156.6 153.7 156.6 98.2 0 135-70.4 140.8-106.9H248v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4z"/></svg>
              </button>
            </div>

            <div class="divider d-flex align-items-center my-4">
              <p class="text-center fw-bold mx-3 mb-0">Or</p>
            </div>

            <!-- Email input -->
            <div class="form-outline mb-4">
              <input type="email" id="form3Example3" class="form-control form-control-lg"
                placeholder="Enter a valid email address" />
              <label class="form-label" for="form3Example3">Email address</label>
            </div>

            <!-- Password input -->
            <div class="form-outline mb-3">
              <input type="password" id="form3Example4" class="form-control form-control-lg"
                placeholder="Enter password" />
              <label class="form-label" for="form3Example4">Password</label>
            </div>

            <div class="d-flex justify-content-between align-items-center">
              <!-- Checkbox -->
              <div class="form-check mb-0">
                <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3" />
                <label class="form-check-label" for="form2Example3">
                  Remember me
                </label>
              </div>
              <a href="#!" class="text-body">Forgot password?</a>
            </div>

            <div class="text-center text-lg-start mt-4 pt-2">
              <button type="button" class="btn btn-primary btn-lg"
                style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
              <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="register.jsp"
                  class="link-danger">Register</a></p>
            </div>

          </form>
        </div>
      </div>
    </div>
  </section>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
    crossorigin="anonymous"></script>
</body>

</html>
