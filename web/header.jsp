<%-- 
    Document   : header
    Created on : Sep 16, 2023, 10:47:53 PM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">  

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- <link rel="icon" type="image/x-icon" href="Eduzone/assets/images/cover/favicon.ico"> -->
        <!-- Font Awesome CSS -->
        <link rel="stylesheet" href="assets/css/all.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="assets/css/eduzone/color-modes.css">
        <link rel="stylesheet" href="assets/css/eduzone/common.css">
        <link rel="stylesheet" href="assets/css/eduzone/animation.css">
        <link rel="stylesheet" href="css/eduzone/index.css">
        <!-- Title -->
        <title>Eduzone - Home</title>
    </head>
    
        <body id="page-top" data-spy="scroll" data-target=".navbar" data-offset="50" onload="startTime()">
            <!-- Start hero -->

            <section id="menu">
                <div class="container">
                    <nav class="navbar navbar-expand-lg justify-content">
                        <div class="site-branding">
                            <a href="home.jsp">
                                <img src="assets/images/cover/logo.png"> 
                            </a>
                        </div>
                        <div class="site-navigation d-flex">
                            <div>
                                <form class="d-flex" role="search">
                                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </form>
                            </div>
                            <ul class="navbar-nav">
                                <!-- <li class="nav-item">
                                  <a class="nav-link" href="index.html"><i class="fas fa-home fa-fw"></i>HOME</a>
                                </li>
                                <li class="nav-item">
                                  <a class="nav-link" href="dashboard.html"><i class="fas fa-bars fa-fw"></i>DASHBOARD</a>
                                </li>
                                <li class="nav-item">
                                  <a class="nav-link" href="#course"><i class="fas fa-code fa-fw"></i>COURSES</a>
                                </li> -->
                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i>LOGIN</a>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                                            <li><button class="dropdown-item" type="button"><a href="login.html">Login</a></button></li>
                                            <li><button class="dropdown-item" type="button"><a href="register.html">Register</a></button></li>
                                            <li><button class="dropdown-item" type="button">Help</button></li>
                                        </ul>
                                    </div>
                                </li>


                                <li class="nav-item">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" data-display="static" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-star-half-alt fa-fw"></i>SCREEN
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-md-right" aria-labelledby="navbarDropdownMenuLink">
                                        <a class="dropdown-item" href="javascript:void(0)" data-bs-theme-value="light">
                                            <i class="fas fa-sun fa-fw mr-2"></i>Light
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                            <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                            </svg>
                                        </a>
                                        <a class="dropdown-item" href="javascript:void(0)" data-bs-theme-value="dark">
                                            <i class="fas fa-moon fa-fw mr-2"></i>Dark
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                            <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                            </svg>
                                        </a>
                                        <a class="dropdown-item" href="javascript:void(0)" data-bs-theme-value="auto">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-circle-half mr-2" viewBox="0 0 16 16">
                                            <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
                                            </svg>Auto
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                            <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                            </svg>
                                        </a>
                                        <div class="dropdown-divider"></div>
                                        <h6 class="dropdown-header">Color</h6>
                                        <div class="color-theme" style="margin-top: 8px !important;">
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Brown" data-bs-color-value="tan" class="color" style="background-color: #c7af8b;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Yellow" data-bs-color-value="yellow" class="color" style="background-color: #f8d06d;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Orange" data-bs-color-value="orange" class="color" style="background-color: #fd7e14;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Red" data-bs-color-value="red" class="color" style="background-color: #dc3545;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                        </div>
                                        <div class="color-theme mb-1">
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Green" data-bs-color-value="green" class="color" style="background-color: #03bb63;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Teal Blue" data-bs-color-value="teal" class="color" style="background-color: #20c997;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Blue" data-bs-color-value="cyan" class="color" style="background-color: #0dcaf0;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                            <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Pink" data-bs-color-value="pink" class="color" style="background-color: #d63384;">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                                                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                                                </svg>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                </li>
                            </ul>
                            <div id="btn-collapse" class="hamburger-menu d-lg-none rotate">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </div>
                        </div>
                    </nav>
                </div>
            </section>

            <!-- Bootstrap core JavaScript-->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="assets/js/bootstrap/bootstrap.bundle.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="assets/js/anest/anest.js"></script>
            <script src="assets/js/anest/jarallax.min.js"></script>
            <script src="assets/js/anest/animation.js"></script>
            <script src="assets/js/anest/color-modes.js"></script>
            <script src="assets/js/anest/index.js"></script>

            <!-- Custom scripts for current pages-->
            <script src="assets/js/anest/contact.js"></script>
        </body>
    </html>
