<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
</head>
<body>
<!-- Navbar -->
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white">
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
                <img src="img/logoLogin.jpg" height="50" alt="MDB Logo"
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
                <i class="fas fa-shopping-cart"></i>
                <span class="badge rounded-pill badge-notification bg-danger">1</span>
            </a>

            <a class="nav-link me-3" href="#">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a class="nav-link me-3" href="#">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="/loginServlet?action=login"
               target="_blank"> <i class="fab fa-github me-2"></i>Log out </a>
        </div>
        <!-- Right elements -->
    </div>
    <!-- Container wrapper -->
</nav>
<!-- Navbar -->

<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container mt-5">
        <!--Grid row-->
        <div class="row">
            <!--Grid column-->
            <div class="col-md-6 mb-4">
                <img src="img/${detailProduct.urlImage}"
                     alt="" width="485" height="485"/>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-6 mb-4">
                <!--Content-->
                <div class="p-4">
                    <%--                    <div class="mb-3">--%>
                    <%--                        <a href="">--%>
                    <%--                            <span class="badge bg-dark me-1">Category</span>--%>
                    <%--                        </a>--%>
                    <%--                        <a href="">--%>
                    <%--                            <span class="badge bg-info me-1">New</span>--%>
                    <%--                        </a>--%>
                    <%--                        <a href="">--%>
                    <%--                            <span class="badge bg-danger me-1">Bestseller</span>--%>
                    <%--                        </a>--%>
                    <%--                    </div>--%>

                    <p class="lead">
                        <%--                        <span class="me-1">--%>
                        <%--                            <del>$200</del>--%>
                        <%--                        </span>--%>
                        <span>$ ${detailProduct.price}</span>
                    </p>

                    <strong><p style="font-size: 20px;">Description</p></strong>

                    <p>${detailProduct.descriptionProduct}</p>

                    <form class="d-flex justify-content-left">
                        <!-- Default input -->
                        <div class="form-outline me-1" style="width: 100px;">
                            <input type="number" value="1" class="form-control"/>

                        </div>
                        <%--                        <hr class="my-4">--%>
                        <button class="btn btn-success ms-1" type="submit">
                            Buy now
                            <i class="fas fa-shopping-cart ms-1"></i>
                        </button>

                        <button class="btn btn-primary ms-1" type="submit">
                            Add to cart
                            <i class="fas fa-shopping-cart ms-1"></i>
                        </button>
                    </form>
                </div>
                <!--Content-->
            </div>
            <!--Grid column-->
        </div>
    </div>
</main>
<!--Main layout-->
<footer class="text-center text-white mt-4" style="background-color: #00614a">
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2); text-color: #E0E0E0">
        © 2025 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">SKT Shop</a>
    </div>
</footer>
<!-- footer -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>
</html>
