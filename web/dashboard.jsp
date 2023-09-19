<%-- 
    Document   : dashboard
    Created on : Sep 18, 2023, 9:09:50 AM
    Author     : MinhDQ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="assets/css/eduzone/sidebar.css">
  <!-- Custom CSS -->
  <link rel="stylesheet" href="assets/css/eduzone/color-modes.css">
  <link rel="stylesheet" href="assets/css/eduzone/common.css">
  <link rel="stylesheet" href="assets/css/eduzone/animation.css">
  <link rel="stylesheet" href="assets/css/eduzone/index.css">
  <!-- Font Awesome CSS -->
  <link rel="stylesheet" href="assets/css/all.css">
  <title>Dashboard</title>
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar" data-offset="50" onload="startTime()">
  <div class="wrapper">
    <!-- Sidebar -->
    <aside id="sidebar">
      <div class="h-100">
        <div class="sidebar-logo">
          <a href="#">EduZone</a>
        </div>
        <!-- Sidebar Navigation -->
        <ul class="sidebar-nav">
          <li class="sidebar-header">
            Tools & Components
          </li>
          <li class="sidebar-item">
            <a href="#" class="sidebar-link">
              <i class="fa-solid fa-list pe-2"></i>
              Dashboard
            </a>
          </li>
          <li class="sidebar-item">
            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#pages"
              aria-expanded="false" aria-controls="pages">
              <i class="fa-regular fa-file-lines pe-2"></i>
              Courses
            </a>
            <ul id="pages" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
              <li class="sidebar-item">
                <a href="#" class="sidebar-link">My courses</a>
              </li>
              <li class="sidebar-item">
                <a href="#" class="sidebar-link">All course</a>
              </li>
            </ul>
          </li>
          <!-- <li class="sidebar-item">
            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard"
              aria-expanded="false" aria-controls="dashboard">
              <i class="fa-solid fa-sliders pe-2"></i>
              Dashboard
            </a>
            <ul id="dashboard" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
              <li class="sidebar-item">
                <a href="#" class="sidebar-link">Dashboard Analytics</a>
              </li>
              <li class="sidebar-item">
                <a href="#" class="sidebar-link">Dashboard Ecommerce</a>
              </li>
            </ul>
          </li> -->
          <li class="sidebar-item">
            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#auth"
              aria-expanded="false" aria-controls="auth">
              <i class="fa-regular fa-user pe-2"></i>
              My profile
            </a>
            <ul id="auth" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
              <li class="sidebar-item">
                <a href="#" class="sidebar-link">Setting profile</a>
              </li>
              <li class="sidebar-item">
                <a href="#" class="sidebar-link">Logout</a>
              </li>
            </ul>
          </li>
          <!-- <li class="sidebar-header">
            Multi Level Nav
          </li>
          <li class="sidebar-item">
            <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#multi"
              aria-expanded="false" aria-controls="multi">
              <i class="fa-solid fa-share-nodes pe-2"></i>
              Multi Level
            </a>
            <ul id="multi" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
              <li class="sidebar-item">
                <a href="#" class="sidebar-link collapsed" data-bs-toggle="collapse" data-bs-target="#multi-two"
                  aria-expanded="false" aria-controls="multi-two">
                  Two Links
                </a>
                <ul id="multi-two" class="sidebar-dropdown list-unstyled collapse">
                  <li class="sidebar-item">
                    <a href="#" class="sidebar-link">Link 1</a>
                  </li>
                  <li class="sidebar-item">
                    <a href="#" class="sidebar-link">Link 2</a>
                  </li>
                </ul>
              </li>
            </ul>
          </li> -->
        </ul>
      </div>
    </aside>
    <!-- Main Component -->
    <div class="main">
      <section id="menu">
        <div class="container">
          <nav class="navbar navbar-expand-lg justify-content">
            <div class="site-branding">
              <!-- Button for sidebar toggle -->
              <button class="btn" type="button" data-bs-theme="dark">
                <span class="navbar-toggler-icon"></span>
              </button>
              <a href="index.html">
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
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                      data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
                        class="fas fa-user fa-fw"></i>minhdqhe163046</a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                      <li><button class="dropdown-item" type="button"><a href="login.html">My profile</a></button></li>
                      <li><button class="dropdown-item" type="button"><a href="register.html">Message</a></button></li>
                      <li><button class="dropdown-item" type="button"><a href="register.html">Logout</a></button></li>
                    </ul>
                  </div>
                </li>


                <li class="nav-item">
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                    data-display="static" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-star-half-alt fa-fw"></i>SCREEN
                  </a>
                  <div class="dropdown-menu dropdown-menu-md-right" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="javascript:void(0)" data-bs-theme-value="light">
                      <i class="fas fa-sun fa-fw mr-2"></i>Light
                      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                        class="bi bi-check-lg" viewBox="0 0 16 16">
                        <path
                          d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                      </svg>
                    </a>
                    <a class="dropdown-item" href="javascript:void(0)" data-bs-theme-value="dark">
                      <i class="fas fa-moon fa-fw mr-2"></i>Dark
                      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                        class="bi bi-check-lg" viewBox="0 0 16 16">
                        <path
                          d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                      </svg>
                    </a>
                    <a class="dropdown-item" href="javascript:void(0)" data-bs-theme-value="auto">
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-circle-half mr-2" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z" />
                      </svg>Auto
                      <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                        class="bi bi-check-lg" viewBox="0 0 16 16">
                        <path
                          d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                      </svg>
                    </a>
                    <div class="dropdown-divider"></div>
                    <h6 class="dropdown-header">Color</h6>
                    <div class="color-theme" style="margin-top: 8px !important;">
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Brown"
                        data-bs-color-value="tan" class="color" style="background-color: #c7af8b;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                        </svg>
                      </a>
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Yellow"
                        data-bs-color-value="yellow" class="color" style="background-color: #f8d06d;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                        </svg>
                      </a>
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Orange"
                        data-bs-color-value="orange" class="color" style="background-color: #fd7e14;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                        </svg>
                      </a>
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Red"
                        data-bs-color-value="red" class="color" style="background-color: #dc3545;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                        </svg>
                      </a>
                    </div>
                    <div class="color-theme mb-1">
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Green"
                        data-bs-color-value="green" class="color" style="background-color: #03bb63;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                        </svg>
                      </a>
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Teal Blue"
                        data-bs-color-value="teal" class="color" style="background-color: #20c997;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                        </svg>
                      </a>
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Blue"
                        data-bs-color-value="cyan" class="color" style="background-color: #0dcaf0;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
                        </svg>
                      </a>
                      <a href="javascript:void(0)" data-toggle="tooltip" data-placement="top" title="Pink"
                        data-bs-color-value="pink" class="color" style="background-color: #d63384;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                          class="bi bi-check-lg" viewBox="0 0 16 16">
                          <path
                            d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z" />
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
        
      <section id="cover">
        <div class="container bg-color-secondary">
          <div class="row">
            <div class="col-lg-9">
              <div class="text-left">
                <h1>MinhDQHE163046 <span class="color-highlight"></span></h1>
                <p>WELCOME EDUZONE_</p>
              </div>
            </div>
            <div class="col-lg-4">
              <div class="wrap">
                <img src="assets/images/1.svg" alt="Mobirise" class="image-1 animated-elements1">
                <img src="assets/images/2.svg" alt="Mobirise" class="image-2 animated-elements2">
                <img src="assets/images/3.svg" alt="Mobirise" class="image-3 animated-elements3">
                <img src="assets/images/4.svg" alt="Mobirise" class="image-4 animated-elements4">
                <img src="assets/images/5.svg" alt="Mobirise" class="image-5 animated-elements5">
                <img src="assets/images/6.svg" alt="Mobirise" class="image-6 animated-elements6">
              </div>
            </div>



          </div>
        </div>
      </section>
        
      <section id="course">
        <div class="container row-list">
          <div class="row">
            <div class="col-lg-5">
              <div class="text-left">
                <h1 class="title">Subject</h1>
                <h6 class="sub-title"><span class="color-highlight">READY</span> FOR YOU</h6>
                <p>Subject are ready for you to participate and explore.</p>
                <a class="btn btn-outline-bottom-bold btn-highlight btn-success" href="courses.html">View more</a>
              </div>
            </div>
            <div class="col-lg-7">
              <div class="row list-course">
                <div class="col-md-4">
                  <div class="box text-center">
                    <div class="box-body">
                      <div class="icon">
                        <i style="font-size: 60px;" class="fas fa-copyright color-blue center-icon"></i>
                      </div>
                      <h5>C Fundamentals</h5>
                      <div class="tags">
                        <div class="tag">Basic</div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="box text-center">
                    <div class="box-body">
                      <div class="icon">
                        <i style="font-size: 60px;" class="fab fa-node-js color-yellow center-icon"></i>
                      </div>
                      <h5>Javascript</h5>
                      <div class="tags">
                        <div class="tag">Basic</div>
                        <div class="tag">advanced</div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="box text-center">
                    <div class="box-body">
                      <div class="icon">
                        <i style="font-size: 65px;" class="fab fa-html5 mr-2 color-orange center-icon"></i>
                      </div>
                      <h5>HTML/CSS</h5>
                      <div class="tags">
                        <div class="tag">Basic</div>
                        <div class="tag">advanced</div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="box text-center">
                    <div class="box-body">
                      <div class="icon">
                        <i style="font-size: 70px;" class="fab fa-java color-red center-icon"></i>
                      </div>
                      <h5>Java Core</h5>
                      <div class="tags">
                        <div class="tag">Basic</div>
                        <div class="tag">advanced</div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="box text-center">
                    <div class="box-body">
                      <div class="icon">
                        <i style="font-size: 55px;" class="fas fa-file-code color-green center-icon"></i>
                      </div>
                      <h5>Java Web</h5>
                      <div class="tags">
                        <div class="tag">Basic</div>
                        <div class="tag">advanced</div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="box text-center">
                    <div class="box-body">
                      <div class="icon">
                        <i style="font-size: 58px;" class="fab fa-uikit text-info center-icon"></i>
                      </div>
                      <h5>Full stack Java</h5>
                      <div class="tags">
                        <div class="tag">advanced</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
        
      <section id="course">
        <div class="container">
          <div class="row">
            <div class="col-4">
              <div class="text-left">
                <h1 class="title">Subject</h1>
                <h6 class="sub-title"><span class="color-highlight">READY</span> FOR YOU</h6>
                <p>Subject are ready for you to participate and explore.</p>
                <a class="btn btn-outline-bottom-bold btn-highlight btn-success" href="courses.html">View more</a>
              </div>
            </div>
            <div class="col-8">
              <div class="list-course card-row" id="style-online">
                <div class="card bg-color-secondary">
                  <div class="card-header">
                  </div>
                  <div class="card-body">
                    <div class="d-flex">
                      <div class="icon">
                        <i class="fab fa-html5" style="color: var(--color-text-orange); margin-top: 8px;"></i>
                      </div>
                      <div class="course-name">
                        <h5>Front-end Developer</h5>
                      </div>
                    </div>
                    <div class="tags">
                      <a href="" class="tag">Beginner</a>
                      <a href="" class="tag">Student</a>
                      <a href="" class="tag">Worker</a>
                    </div>
                  </div>
                </div>
                <div class="card bg-color-secondary">
                  <div class="card-header">
                  </div>
                  <div class="card-body">
                    <div class="d-flex">
                      <div class="icon">
                        <i class="fab fa-node-js" style="color: var(--color-text-yellow)"></i>
                      </div>
                      <div class="course-name">
                        <h5>Javascript Essentials</h5>
                      </div>
                    </div>
                    <div class="tags">
                      <a href="" class="tag">Beginner</a>
                    </div>
                  </div>
                </div>
                <div class="card bg-color-secondary">
                  <div class="card-header">
                  </div>
                  <div class="card-body">
                    <div class="d-flex">
                      <div class="icon">
                        <svg style="color: var(--blue)" xmlns="http://www.w3.org/2000/svg" width="42" height="42"
                          fill="currentColor" class="bi bi-c-circle" viewBox="0 0 16 16">
                          <path
                            d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8Zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0ZM8.146 4.992c-1.212 0-1.927.92-1.927 2.502v1.06c0 1.571.703 2.462 1.927 2.462.979 0 1.641-.586 1.729-1.418h1.295v.093c-.1 1.448-1.354 2.467-3.03 2.467-2.091 0-3.269-1.336-3.269-3.603V7.482c0-2.261 1.201-3.638 3.27-3.638 1.681 0 2.935 1.054 3.029 2.572v.088H9.875c-.088-.879-.768-1.512-1.729-1.512Z">
                          </path>
                        </svg>
                      </div>
                      <div class="course-name">
                        <h5>C Essentials</h5>
                      </div>
                    </div>
                    <div class="tags">
                      <a href="" class="tag">Beginner</a>
                    </div>
                  </div>
                </div>
                <div class="card bg-color-secondary">
                  <div class="card-header">
                  </div>
                  <div class="card-body">
                    <div class="d-flex">
                      <div class="icon">
                        <svg style="color: var(--purple)" xmlns="http://www.w3.org/2000/svg" width="42" height="42"
                          fill="currentColor" class="bi bi-database" viewBox="0 0 16 16">
                          <path
                            d="M4.318 2.687C5.234 2.271 6.536 2 8 2s2.766.27 3.682.687C12.644 3.125 13 3.627 13 4c0 .374-.356.875-1.318 1.313C10.766 5.729 9.464 6 8 6s-2.766-.27-3.682-.687C3.356 4.875 3 4.373 3 4c0-.374.356-.875 1.318-1.313ZM13 5.698V7c0 .374-.356.875-1.318 1.313C10.766 8.729 9.464 9 8 9s-2.766-.27-3.682-.687C3.356 7.875 3 7.373 3 7V5.698c.271.202.58.378.904.525C4.978 6.711 6.427 7 8 7s3.022-.289 4.096-.777A4.92 4.92 0 0 0 13 5.698ZM14 4c0-1.007-.875-1.755-1.904-2.223C11.022 1.289 9.573 1 8 1s-3.022.289-4.096.777C2.875 2.245 2 2.993 2 4v9c0 1.007.875 1.755 1.904 2.223C4.978 15.71 6.427 16 8 16s3.022-.289 4.096-.777C13.125 14.755 14 14.007 14 13V4Zm-1 4.698V10c0 .374-.356.875-1.318 1.313C10.766 11.729 9.464 12 8 12s-2.766-.27-3.682-.687C3.356 10.875 3 10.373 3 10V8.698c.271.202.58.378.904.525C4.978 9.71 6.427 10 8 10s3.022-.289 4.096-.777A4.92 4.92 0 0 0 13 8.698Zm0 3V13c0 .374-.356.875-1.318 1.313C10.766 14.729 9.464 15 8 15s-2.766-.27-3.682-.687C3.356 13.875 3 13.373 3 13v-1.302c.271.202.58.378.904.525C4.978 12.71 6.427 13 8 13s3.022-.289 4.096-.777c.324-.147.633-.323.904-.525Z">
                          </path>
                        </svg>
                      </div>
                      <div class="course-name">
                        <h5>Database / SQL</h5>
                      </div>
                    </div>
                    <div class="tags">
                      <a href="" class="tag">Beginner</a>
                      <a href="" class="tag">Worker</a>
                    </div>
                  </div>
                </div>
                <div class="card bg-color-secondary">
                  <div class="card-header">
                  </div>
                  <div class="card-body">
                    <div class="d-flex">
                      <div class="icon">
                        <i class="fab fa-java" style="color: var(--color-text-red)"></i>
                      </div>
                      <div class="course-name">
                        <h5>Java SE Developer Advanced</h5>
                      </div>
                    </div>
                    <div class="tags">
                      <a href="" class="tag">Worker</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">

          </div>
        </div>
      </section>
        
      <!-- Footer -->
      <section id="footer">
        <div class="container">
          <div class="row f-top">
            <div class="col-12 col-sm-12 col-md-5 info">
              <img src="assets/images/cover/logo.png">
              <p>Study with <span class="color-secondary-highlight font-weight-500">EDUZONE</span></p>
              <ul>
                <li><i class="far fa-envelope fa-fw mr-2"></i>eduzone.academy@gmail.com</li>
                <li><i class="fas fa-phone fa-fw mr-2"></i>(+84) 0919 982 032</li>
                <li><i class="fas fa-map-marker-alt fa-fw mr-2"></i>FPT UNIVERSITY</li>
              </ul>
            </div>
            <div class="col-12 col-sm-12 col-md-4 course">
              <h6>Subject</h6>
              <p>The subject are ready</p>
              <ul>
                <li>Java</li>
                <li>Javascript</li>
                <li>Database</li>
                <li>HTML/CSS</li>
                <li>VueJS</li>
              </ul>
            </div>
            <div class="col-12 col-sm-12 col-md-3 social">
              <h6>FOLLOW US</h6>
              <p>Update the fastest news and lessons</p>
              <ul>
                <li>
                  <a href="https://www.facebook.com/qminh4real/" target="_blank">
                    <i class="fab fa-facebook-square"></i>
                  </a>
                  <a href="https://www.youtube.com/@eduzone3384" target="_blank">
                    <i class="fab fa-youtube"></i>
                  </a>
                </li>
                <li>
                  <a href="courses.html"
                    class="btn btn-outline-bottom-bold btn-highlight btn-highlight-icon btn-success mt-4"><i
                      class="fas fa-edit fa-fw mr-1"></i>Logout</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </section>
      <section id="signature">
        <div class="container">
          <div class="row f-bot">
            <div class="col-12 col-sm-12 col-md-6 clock">
              <i class="far fa-clock color-secondary-highlight fa-fw mr-1"></i><span id=clock></span>
            </div>
            <div class="col-12 col-sm-12 col-md-6 copyright">
              <span>Copyright © 2020 EDUZONE ACADEMY</span>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
    crossorigin="anonymous"></script>

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
  <script src="assets/js/anest/script.js"></script>
</body>

</html>
