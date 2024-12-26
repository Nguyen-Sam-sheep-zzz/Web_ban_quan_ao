<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="CSS/cart_user.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css" rel="stylesheet">

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

<section class="h-100 h-custom h-custom mt-5" style="background-color: #33a985;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-9">
                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                    <div class="card-body p-0">
                        <div class="row g-0">
                            <div class="col-lg-7">
                                <div class="p-5">
                                    <div class="d-flex justify-content-between align-items-center mb-5">
                                        <h1 class="fw-bold mb-0">Shopping Cart</h1>
                                        <h6 class="mb-0 text-muted">${cart.size()} items</h6>
                                    </div>
                                    <hr class="my-4">
                                    <div class="product-list"
                                         style="max-height: 380px; overflow-y: auto; overflow-x: hidden; padding-right: 20px; margin-right: -20px;">
                                        <c:forEach var="o" items="${cart}">
                                            <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img src="/img/${o.urlImage}" class="img-fluid rounded-3"
                                                         alt="Cotton T-shirt"/>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <h6 class="text-muted">${o.choice}</h6>
                                                    <h6 class="mb-0">${o.nameProduct}</h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex"
                                                     style="padding-left: 0px;">
                                                    <button id="reloadButton1"
                                                            data-mdb-button-init="" data-mdb-ripple-init=""
                                                            class="btn btn-link px-1"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <label>
                                                        <input id="quantityC" min="0" name="quantityC" value="${quantityP}"
                                                               type="number"
                                                               class="form-control form-control-sm"
                                                               style="width: 55px">
                                                        <input type="hidden" name="productId"
                                                               value="${o.idProduct}">
                                                    </label>
                                                    <button id="reloadButton"
                                                            data-mdb-button-init="" data-mdb-ripple-init=""
                                                            class="btn btn-link px-1"
                                                            onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>

                                                <div class="col-md-3 col-lg-2 col-xl-1">
                                                    <select data-mdb-select-init=""
                                                            class="form-control form-control-sm"
                                                            style="width: 50px; margin-left: 5px"
                                                            autocompleted="">
                                                        <option selected="">Size</option>
                                                        <option value="S">S</option>
                                                        <option value="M">M</option>
                                                        <option value="L">L</option>
                                                        <option value="XL">XL</option>
                                                        <option value="XXL">XXL</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2"
                                                     style="margin-left: 25px;">
                                                    <h6 class="mb-0" data-price-id="${o.idProduct}"
                                                        data-unit-price="${o.price}">$ ${o.price}</h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <form action="cartUserServlet" method="post"
                                                          style="display: inline;">
                                                        <input type="hidden" name="action" value="delete">
                                                        <button type="submit"
                                                                style="border: none; background: none; padding: 0; outline: none;">
                                                            <input type="hidden" name="deleteP" value="${o.idProduct}">
                                                            <a href="" class="text-muted"><i
                                                                    class="fas fa-times"></i></a>
                                                        </button>
                                                    </form>
                                                </div>

                                            </div>
                                            <hr class="my-4">
                                        </c:forEach>
                                    </div>
                                    <div class="pt-5">
                                        <h6 class="mb-0"><a href="/homeUserServlet?action=All" class="text-body"><i
                                                class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-5 bg-body-tertiary">
                                <div class="p-5">
                                    <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-4">
                                        <h5 class="text-uppercase">items ${cart.size()}</h5>
                                        <h5 id="total-price">$ </h5>
                                    </div>

                                    <h5 class="text-uppercase mb-3">Shipping</h5>

                                    <div class="mb-4 pb-2">
                                        <select data-mdb-select-init>
                                            <option selected>Choice your address</option>
                                            <option>${addressUser}</option>
                                        </select>
                                    </div>

                                    <h5 class="text-uppercase mb-3">Give code</h5>

                                    <div class="mb-5">
                                        <div data-mdb-input-init class="form-outline">
                                            <input type="text" id="form3Examplea2"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Examplea2">Enter your code</label>
                                        </div>
                                    </div>

                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-5">
                                        <h5 class="text-uppercase">Total price</h5>
                                        <h5 id="total-priceEnd">$ </h5>
                                    </div>

                                    <button type="button" data-mdb-button-init data-mdb-ripple-init
                                            class="btn btn-dark btn-block btn-lg"
                                            data-mdb-ripple-color="dark">Buy now
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    function calculateTotal() {
        var total = 0;
        document.querySelectorAll('.row.mb-4.d-flex.justify-content-between.align-items-center').forEach(function (row, index) {

            var priceElement = row.querySelector('[data-price-id]');
            if (!priceElement) {
                return;
            }

            var price = parseFloat(priceElement.getAttribute('data-unit-price'));
            if (isNaN(price)) {
                return;
            }

            var quantityInput = row.querySelector('input[name="quantityC"]');
            if (!quantityInput) {
                return;
            }

            var quantity = parseInt(quantityInput.value, 10);
            if (isNaN(quantity)) {
                quantity = 0;
            }
            total += price * quantity;
        });
        document.getElementById('total-price').textContent = '$' + total.toFixed(2);
        document.getElementById('total-priceEnd').textContent = '$' + total.toFixed(2);
    }

    document.querySelectorAll('input[name="quantityC"]').forEach(function (input) {
        input.addEventListener('change', calculateTotal);
    });
    window.onload = calculateTotal;

</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"></script>
</body>
</html>
