<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="CSS/Admin.css">
    <style>
        .recent-orders a {
            background-color: #f44336;
            color: #f2f2f2;
            padding: 10px 15px;
            text-align: center;
            justify-content: center;
            align-items: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            border: none;
            margin-top: 25px;
            margin-bottom: 25px;
        }

        .recent-orders a:hover {
            border-color: #4CAF50;
            color: white;
            background-color: #4CAF50;
        }

    </style>
</head>
<body>

<header class="header">
    <h1>Admin Dashboard</h1>
    <div class="add-product">
        <a href="home_admin_product?action=add">Add new Product</a>
    </div>
</header>

<aside class="sidebar">
    <nav>
        <ul>
<%--            <li><a href="#">Menu</a></li>--%>
            <li><a href="home_admin_product?action=product_list">Products Management</a></li>
<%--            <li><a href="#">Users Management</a></li>--%>
<%--            <li><a href="#">Orders Management</a></li>--%>
<%--            <li><a href="#">Cart Management</a></li>--%>
            <li><a href="home_admin_product?action=logout">Log out</a></li>
        </ul>
    </nav>
</aside>

<main class="main-content">
    <div class="search-bar">
        <form action="home_admin_product?action=search" method="post">
            <input type="text" name="search" placeholder="Tìm kiếm..."/>
            <button>Search</button>
        </form>
    </div>
    <section class="recent-orders">
        <h2>Đơn hàng gần đây</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Image</th>
                <th>Name</th>
                <th>Description</th>
                <th>size</th>
                <th>Price</th>
                <th>Status</th>
                <th>Quantity</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
            </thead>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.idProduct}</td>
                    <td><img style="width: 60px; height: 80px" src="img/${product.urlImage}"></td>
                    <td>${product.nameProduct}</td>
                    <td style="max-width: 200px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${product.descriptionProduct}</td>
                    <td>${product.size}</td>
                    <td>${product.price}$</td>
                    <td>${product.status}</td>
                    <td>${product.quantity}</td>
                    <td>${product.choice}</td>
                    <td class="actions">
                        <a href="home_admin_product?action=edit&id=${product.idProduct}">
                            Edit the product
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </section>
</main>
</body>
<footer class="footer">
    <p>&copy; 2024 Admin SKT store</p>
</footer>
<style>
</style>
</html>
