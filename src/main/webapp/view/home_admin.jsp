<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="CSS/Admin.css">
</head>
<body>
<form action="home_admin" method="get">
    <header class="header">
        <h1>Admin Dashboard</h1>
        <div class="logout">
            <a href="/home_admin?action=logout">Log out</a>
        </div>
    </header>

    <aside class="sidebar">
        <nav>
            <ul>
                <li><a href="#">Trang chủ</a></li>
                <li><a href="#">Quản lý sản phẩm</a></li>
                <li><a href="#">Quản lý đơn hàng</a></li>
                <li><a href="#">Quản lý khách hàng</a></li>
                <li><a href="#">Thống kê doanh thu</a></li>
                <li><a href="#">Cài đặt</a></li>
            </ul>
        </nav>
    </aside>

    <main class="main-content">
        <div class="search-bar">
            <input type="text" placeholder="Tìm kiếm..."/>
            <button>Tìm kiếm</button>
        </div>
        <section class="recent-orders">
            <h2>Đơn hàng gần đây</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>size</th>
                    <th>Price</th>
                    <th>Status</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td>${product.idProduct}</td>
                        <td>${product.nameProduct}</td>
                        <td>${product.descriptionProduct}</td>
                        <td>${product.size}</td>
                        <td>${product.price}</td>
                        <td>${product.status}</td>
                        <td>${product.quantity}</td>
                        <td class="actions">
                            <a href="/home_admin?action=edit&id=${product.idProduct}">
                                Edit
                            </a>
                            <a href="/home_admin?action=add&id=${product.idProduct}">
                                Add
                            </a>
                            <a href="/home_admin?action=delete&id=${product.idProduct}">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </section>
    </main>
</form>
<footer class="footer">
    <p>&copy; 2024 Admin SKT store</p>
</footer>
</body>
</html>
