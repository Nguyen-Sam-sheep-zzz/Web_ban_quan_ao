<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home user</title>
    <link rel="stylesheet" href="CSS/home_user.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

</head>
<body>
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white">
    <div class="container">
        <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarSupportedContent1"
                aria-controls="navbarSupportedContent1"
                aria-expanded="false"
                aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent1">
            <a class="navbar-brand mt-2 mt-sm-0" href="/homeUserServlet?action=All">
                <img src="img/logoLogin.jpg" height="40" alt="MDB Logo"
                     loading="lazy"/>
            </a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/homeUserServlet?action=All">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/homeUserServlet?action=Shirts">Shirts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/homeUserServlet?action=Pants">Pants
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/homeUserServlet?action=Outwears">Outwears</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/homeUserServlet?action=Accessories">Accessories</a>
                </li>
            </ul>
        </div>
        <div class="d-flex align-items-center">
            <a class="nav-link me-3" href="/cartUserServlet">
                <img src="img/cart.png" alt="error" height="30">
            </a>
            <a href="/loginServlet?action=login" style="margin-left: 20px"
               target="_blank"> <i class="btn btn-dark btn-lg btn-block">Log out</i></a>
        </div>
    </div>
</nav>
<div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-mdb-ride="carousel"
     style="margin-top: 70px">
    <div class="carousel-indicators">
        <button
                type="button"
                data-mdb-target="#carouselExampleCaptions"
                data-mdb-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
        ></button>
        <button
                type="button"
                data-mdb-target="#carouselExampleCaptions"
                data-mdb-slide-to="1"
                aria-label="Slide 2"
        ></button>
        <button
                type="button"
                data-mdb-target="#carouselExampleCaptions"
                data-mdb-slide-to="2"
                aria-label="Slide 3"
        ></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/banner2.png"
                 class="d-block w-100" alt="Wild Landscape"/>
        </div>
        <div class="carousel-item">
            <img src="img/banner1.png"
                 class="d-block w-100" alt="Camera"/>
        </div>
        <div class="carousel-item">
            <img src="img/banner3.png"
                 class="d-block w-100" alt="Exotic Fruits"/>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-mdb-target="#carouselExampleCaptions"
            data-mdb-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-mdb-target="#carouselExampleCaptions"
            data-mdb-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"> </span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<main>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2" style="background-color:#7d0810">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Categories:</a>
                <button
                        class="navbar-toggler"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarSupportedContent2"
                        aria-controls="navbarSupportedContent2"
                        aria-expanded="false"
                        aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent2">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                        <li class="nav-item acitve">
                            <a class="nav-link text-white" href="/homeUserServlet?action=All">All items</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/homeUserServlet?action=Shirts">Shirts</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/homeUserServlet?action=Pants">Pants</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/homeUserServlet?action=Outwears">Outwears</a>
                        </li>
                        <li class="nav-item acitve">
                            <a class="nav-link text-white" href="/homeUserServlet?action=Accessories">Accessories</a>
                        </li>
                        <style>
                            .navbar-nav .nav-item:hover > .nav-link {
                                color: #023217 !important;
                                transition: color 0.3s ease;
                            }
                        </style>
                    </ul>

                    <form action="/homeUserServlet" method="post" class="w-auto py-1"
                          style="max-width: 12rem;margin-bottom: 0px;">
                        <input value="${keyword}" name="search" type="search" class="form-control rounded-0"
                               placeholder="Search with name" aria-label="Search">
                    </form>

                </div>
            </div>
        </nav>

        <section>
            <div class="text-center">
                <div class="row">
                    <c:forEach var="o" items="${productList}">
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="card shadow-lg">
                                <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                                     data-mdb-ripple-color="light">
                                    <img src="img/${o.urlImage}"
                                         class="w-100"/>
                                    <a href="detailProductUserServlet?pid=${o.idProduct}">
                                        <div class="mask">
                                            <div class="d-flex justify-content-start align-items-end h-100">
                                                <h5><span class="badge bg-dark ms-2">NEW</span></h5>
                                            </div>
                                        </div>
                                        <div class="hover-overlay">
                                            <div class="mask"
                                                 style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                        </div>
                                    </a>
                                </div>
                                <div class="card-body">
                                    <a href="detailProductUserServlet?pid=${o.idProduct}" class="text-reset">
                                        <h5 class="card-title mb-2">${o.nameProduct}</h5>
                                    </a>
                                    <a href="detailProductUserServlet?pid=${o.idProduct}" class="text-reset ">
                                        <p>${o.choice}</p>
                                    </a>
                                    <h6 class="mb-3 price">${o.price}$</h6>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>

    </div>
</main>
<footer class="text-center text-white mt-4" style="background-color: #00614a">
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2); text-color: #E0E0E0">
        © 2025 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">SKT Shop</a>
    </div>
</footer>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>
</html>
