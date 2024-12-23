<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
<%--    <link rel="stylesheet" href="CSS/register.css">--%>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css" rel="stylesheet">
</head>
<body>
<section class="vh-100 bg-image"
         style="background-color: #619A6D;);">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                            <form action="registerServlet" method="post">

                                <div class="alert alert-danger" role="alert"
                                     style="display: ${not empty errorMessage ? 'block' : 'none'};">
                                    ${errorMessage}
                                </div>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="text" id="form3Example1cg" class="form-control form-control-lg" name= "username"/>
                                    <label class="form-label" for="form3Example1cg">Your Username</label>
                                </div>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="text" id="form3Example3cg" class="form-control form-control-lg" name="fullname" />
                                    <label class="form-label" for="form3Example3cg">Your full name</label>
                                </div>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="password" id="form3Example4cg" class="form-control form-control-lg" name="password" />
                                    <label class="form-label" for="form3Example4cg">Password</label>
                                </div>

                                <div data-mdb-input-init class="form-outline mb-4">
                                    <input type="password" id="form3Example4cdg" class="form-control form-control-lg" name="Rpassword"/>
                                    <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                                </div>

                                <div class="d-flex justify-content-center">
                                    <button  type="submit" data-mdb-button-init
                                             data-mdb-ripple-init class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="/registerServlet?action=login"
                                                                                                        class="fw-bold text-body">Login here</a></p>
                            </form>
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
