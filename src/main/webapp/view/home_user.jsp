<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home user</title>
    <link rel="stylesheet" href="CSS/home_user.css">
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/home_user.css">--%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white" >
    <!-- Container wrapper -->
    <div class="container">
        <!-- Toggle button -->
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

        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent1">
            <!-- Navbar brand -->
            <a class="navbar-brand mt-2 mt-sm-0" href="/homeUserServlet?action=All">
                <img src="img/logoLogin.jpg" height="40" alt="MDB Logo"
                     loading="lazy"/>
            </a>
            <!-- Left links -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/homeUserServlet?action=All">Home</a>
                </li>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="https://mdbootstrap.com/docs/standard/">About MDB</a>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="https://mdbootstrap.com/docs/standard/getting-started/installation/">Free--%>
                <%--                        download</a>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="https://mdbootstrap.com/education/bootstrap/">Free tutorials</a>--%>
                <%--                </li>--%>
            </ul>
            <!-- Left links -->
        </div>
        <!-- Collapsible wrapper -->

        <%--        <!-- Right elements -->--%>
        <div class="d-flex align-items-center">
            <!-- Icon -->
            <a class="nav-link me-3" href="#">
                <img src="img/cart.png" alt="error" height="30">
<%--                <i class="fas fa-shopping-cart"></i>--%>
<%--                <span class="badge rounded-pill badge-notification bg-danger">1</span>--%>
            </a>

            <a class="nav-link me-3" href="#">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a class="nav-link me-3" href="#">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="/loginServlet?action=login"
               target="_blank"> <i class="fab fa-github me-2"></i>Log out</a>
        </div>
        <!-- Right elements -->
    </div>
    <!-- Container wrapper -->
</nav>
<!-- carousel -->
<div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-mdb-ride="carousel" style="margin-top: 70px">
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
            <%--            <div class="mask" style="background-color: rgba(0, 0, 0, 0.4)"></div>--%>
        </div>
        <div class="carousel-item">
            <img src="img/banner1.png"
                 class="d-block w-100" alt="Camera"/>
            <%--            <div class="mask" style="background-color: rgba(0, 0, 0, 0.4)"></div>--%>
        </div>
        <div class="carousel-item">
            <img src="img/banner3.png"
                 class="d-block w-100" alt="Exotic Fruits"/>
            <%--            <div class="mask" style="background-color: rgba(0, 0, 0, 0.4)"></div>--%>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-mdb-target="#carouselExampleCaptions"
            data-mdb-slide="prev">
        <%--        <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
        <%--        <span class="visually-hidden">Previous</span>--%>
    </button>
    <button class="carousel-control-next" type="button" data-mdb-target="#carouselExampleCaptions"
            data-mdb-slide="next">
        <%--        <span class="carousel-control-next-icon" aria-hidden="true"> </span>--%>
        <%--        <span class="visually-hidden">Next</span>--%>
    </button>
</div>

<!--Main layout-->
<main>
    <div class="container">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2" style="background-color:#7d0810">
            <!-- Container wrapper -->
            <div class="container-fluid">

                <!-- Navbar brand -->
                <a class="navbar-brand" href="#">Categories:</a>

                <!-- Toggle button -->
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

                <!-- Collapsible wrapper -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent2">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                        <!-- Link -->

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

                    <!-- Search -->
                    <form action="/homeUserServlet" method="post" class="w-auto py-1" style="max-width: 12rem;margin-bottom: 0px;">
                        <input name="search" type="search" class="form-control rounded-0" placeholder="Search with name" aria-label="Search">
                    </form>

                </div>
            </div>
            <!-- Container wrapper -->
        </nav>
        <!-- Navbar -->

        <!-- Products -->
        <section>
            <div class="text-center">
                <div class="row">
                    <c:forEach var="o" items="${productList}">
                        <div class="col-lg-3 col-md-6 mb-4">
                            <div class="card">
                                <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                                     data-mdb-ripple-color="light">
                                    <img src="img/${o.urlImage}"
                                         class="w-100"/>
                                    <a href="detailProductServlet?pid=${o.idProduct}">
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
                                    <a href="" class="text-reset">
                                        <h5 class="card-title mb-2">${o.nameProduct}</h5>
                                    </a>
                                    <a href="" class="text-reset ">
                                        <p>${o.descriptionProduct}</p>
                                    </a>
                                    <h6 class="mb-3 price">${o.price}$</h6>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>

        <!-- Pagination -->
<%--        <nav aria-label="Page navigation example" class="d-flex justify-content-center mt-3">--%>
<%--            <ul class="pagination">--%>
<%--                <li class="page-item disabled">--%>
<%--                    <a class="page-link" href="#" aria-label="Previous">--%>
<%--                        <span aria-hidden="true">&laquo;</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--                <li class="page-item active"><a class="page-link" href="#">1</a></li>--%>
<%--                <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                <li class="page-item"><a class="page-link" href="#">4</a></li>--%>
<%--                <li class="page-item"><a class="page-link" href="#">5</a></li>--%>
<%--                <li class="page-item">--%>
<%--                    <a class="page-link" href="#" aria-label="Next">--%>
<%--                        <span aria-hidden="true">&raquo;</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </nav>--%>
        <!-- Pagination -->
    </div>
</main>
<!--Main layout-->

<footer class="text-center text-white mt-4" style="background-color: #7d0810">

    <%--    <hr class="text-dark">--%>

    <%--    <div class="container">--%>
    <%--        <!-- Section: Social media -->--%>
    <%--        <section class="mb-3">--%>

    <%--            <!-- Facebook -->--%>
    <%--            <a--%>
    <%--                    class="btn-link btn-floating btn-lg text-white"--%>
    <%--                    href="#!"--%>
    <%--                    role="button"--%>
    <%--                    data-mdb-ripple-color="dark"--%>
    <%--            ><i class="fab fa-facebook-f"></i--%>
    <%--            ></a>--%>

    <%--            <!-- Twitter -->--%>
    <%--            <a--%>
    <%--                    class="btn-link btn-floating btn-lg text-white"--%>
    <%--                    href="#!"--%>
    <%--                    role="button"--%>
    <%--                    data-mdb-ripple-color="dark"--%>
    <%--            ><i class="fab fa-twitter"></i--%>
    <%--            ></a>--%>

    <%--            <!-- Google -->--%>
    <%--            <a--%>
    <%--                    class="btn-link btn-floating btn-lg text-white"--%>
    <%--                    href="#!"--%>
    <%--                    role="button"--%>
    <%--                    data-mdb-ripple-color="dark"--%>
    <%--            ><i class="fab fa-google"></i--%>
    <%--            ></a>--%>

    <%--            <!-- Instagram -->--%>
    <%--            <a--%>
    <%--                    class="btn-link btn-floating btn-lg text-white"--%>
    <%--                    href="#!"--%>
    <%--                    role="button"--%>
    <%--                    data-mdb-ripple-color="dark"--%>
    <%--            ><i class="fab fa-instagram"></i--%>
    <%--            ></a>--%>

    <%--            <!-- YouTube -->--%>
    <%--            <a--%>
    <%--                    class="btn-link btn-floating btn-lg text-white"--%>
    <%--                    href="#!"--%>
    <%--                    role="button"--%>
    <%--                    data-mdb-ripple-color="dark"--%>
    <%--            ><i class="fab fa-youtube"></i--%>
    <%--            ></a>--%>
    <%--            <!-- Github -->--%>
    <%--            <a--%>
    <%--                    class="btn-link btn-floating btn-lg text-white"--%>
    <%--                    href="#!"--%>
    <%--                    role="button"--%>
    <%--                    data-mdb-ripple-color="dark"--%>
    <%--            ><i class="fab fa-github"></i--%>
    <%--            ></a>--%>
    <%--        </section>--%>
    <%--        <!-- Section: Social media -->--%>
    <%--    </div>--%>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2); text-color: #E0E0E0">
        © 2025 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">SKT Shop</a>
    </div>
    <!-- Copyright -->
</footer>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>
</html>
