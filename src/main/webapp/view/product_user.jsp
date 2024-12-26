<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
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
<main class="mt-5 pt-4">
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 mb-4">
                <img src="img/${detailProduct.urlImage}"
                     alt="" width="485" height="485"/>
            </div>
            <div class="col-md-6 mb-4">
                <div class="p-4">
                    <div class="mb-3">
                        <a href="">
                            <span class="badge bg-dark me-1">Category</span>
                        </a>
                        <a href="">
                            <span class="badge bg-info me-1">New</span>
                        </a>
                        <a href="">
                            <span class="badge bg-danger me-1">Bestseller</span>
                        </a>
                    </div>

                    <p class="lead">
                        <span>$ ${detailProduct.price}</span>
                    </p>

                    <strong><p style="font-size: 20px;">Description</p></strong>

                    <p>${detailProduct.descriptionProduct}</p>

                    <form class="d-flex justify-content-left" action="cartUserServlet" method="get">
                        <div class="form-outline me-1" style="width: 100px;">
                            <input type="number" value="1" class="form-control" name="quantityP"/>
                        </div>
                        <input type="hidden" name="action" value="buy">
                        <%--                        <button class="btn btn-success ms-1" type="submit">--%>
                        <%--                            <input type="hidden" name="cid" value="${detailProduct.idProduct}"/>--%>
                        <%--                            Buy now--%>
                        <%--                        </button>--%>

                        <button class="btn btn-primary ms-1" type="submit">
                            <input type="hidden" name="cid" value="${detailProduct.idProduct}"/>
                            Add to cart
                        </button>
                    </form>
                </div>
            </div>
        </div>
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
