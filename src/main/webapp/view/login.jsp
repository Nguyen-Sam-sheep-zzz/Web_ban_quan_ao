<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%--    <link rel="stylesheet" href="/CSS/register.css">--%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
</head>
<body>
<section class="vh-100" style="background-color: #9A616D;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-7.5">
                <div class="card w-75 mx-auto" style="border-radius: 1rem;">
                    <div class="row g-0">
                        <div class="col-md-6 col-lg-5 d-none d-md-block">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp"
                                 alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;"/>
                        </div>
                        <div class="col-md-6 col-lg-7 d-flex align-items-center">
                            <div class="card-body p-4 p-lg-5 text-black">

                                <form action="loginServlet" method="post">

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                        <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
                                        <span class="h1 fw-bold mb-0">Logo</span>
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign into your
                                        account</h5>

                                    <div class="alert alert-success" role="alert"
                                         style="display: ${not empty successMessage ? 'block' : 'none'};">
                                        ${successMessage}
                                    </div>

                                    <div class="alert alert-danger" role="alert"
                                         style="display: ${not empty errorMessage ? 'block' : 'none'};">
                                        ${errorMessage}
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="text" id="form2Example17" class="form-control form-control-lg"
                                               name="username"/>
                                        <label class="form-label" for="form2Example17">Username</label>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <input type="password" id="form2Example27" class="form-control form-control-lg"
                                               name="password"/>
                                        <label class="form-label" for="form2Example27">Password</label>
                                    </div>

                                    <div class="pt-1 mb-4">
                                        <button data-mdb-button-init data-mdb-ripple-init
                                                class="btn btn-dark btn-lg btn-block" type="submit">Login
                                        </button>
                                    </div>
                                </form>
                                <p class="mb-5 pb-lg-2" style="color: #393f81;">Don't have an account? <a
                                        href="/loginServlet?action=register"
                                        style="color: #393f81;">Register here</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</body>
</html>