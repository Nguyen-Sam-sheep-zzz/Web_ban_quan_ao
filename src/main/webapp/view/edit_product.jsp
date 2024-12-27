<%@ page import="com.example.web_ban_quan_ao.Model.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
</head>
<body>
<header class="header">
    <h1>Admin Dashboard</h1>
    <div class="leave-product">
        <a href="/home_admin_product?action=leave">leave the activity</a>
    </div>
</header>
<main class="main">
    <div class="recent-orders">
        <div class="">
            <h2>Edit the Product</h2>
        </div>
        <div>
            <form method="post">
                <table>

                    <tr>
                        <th>Name of product:</th>
                        <td><input type="text" name="nameProduct" placeholder="${editProduct.nameProduct}"></td>
                    </tr>
                    <tr>
                        <th>URL of image:</th>
                        <td><input type="text" name="urlImage" placeholder="${editProduct.urlImage}"></td>
                    </tr>
                    <tr>
                        <th>Description of product:</th>
                        <td>
                            <textarea name="descriptionProduct" placeholder="${editProduct.descriptionProduct}">
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>Price of product:</th>
                        <td><input type="number" name="priceProduct" placeholder="${editProduct.price}"></td>
                    </tr>
                    <tr>
                        <th>Quantity:</th>
                        <td><input type="number" name="quantityProduct" placeholder="${editProduct.quantity}">
                        </td>
                    </tr>
                    <tr>
                        <th>Size of product:</th>
                        <td><select name="size">
                            <option value="${editProduct.size}">${editProduct.size}</option>
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                            <option value="XXL">XXL</option>
                        </select></td>
                    </tr>
                    <tr>
                        <th>Category of product:</th>
                        <td><select name="category">
                            <option value="${editProduct.choice}">${editProduct.choice}</option>
                            <option value="Shirts">Shirts</option>
                            <option value="Pants">Pants</option>
                            <option value="Outwears">Outwears</option>
                            <option value="ACCESSORIES">Accessories</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Edit the product"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</main>
<footer class="footer">
    <p>&copy; 2024 Admin SKT store</p>
</footer>
</body>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        display: flex;
        flex-direction: column;
        min-height: 100vh;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        background-attachment: fixed;
    }

    .main {
        margin: 45px auto auto auto;
        padding: 20px;
        width: 40%;
        border-radius: 8px;
        text-align: center;
        background-color: rgba(76, 175, 80, 0.8);
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
        backdrop-filter: blur(10px);
    }


    .header {
        background-color: #4CAF50;
        width: 100%;
        color: white;
        padding: 20px 30px;
        text-align: center;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-size: 15px;
        font-weight: bold;
        height: auto;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .header .leave-product a {
        color: white;
        text-decoration: none;
        font-weight: bold;
        padding: 8px 16px;
        background-color: #ff5722;
        border-radius: 4px;
        transition: background-color 0.3s;
    }

    .header .leave-product a:hover {
        background-color: #e64a19;
        color: white;
    }

    .recent-orders {
        text-align: center;
    }

    .recent-orders h2 {
        margin-bottom: 20px;
        font-size: 24px;
        color: #333;
    }

    .recent-orders table {
        width: 100%;
        border-collapse: collapse;
        margin: 0 auto;
        background-color: white;
        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    }

    .recent-orders th, .recent-orders td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: center;
    }

    .recent-orders td input, .recent-orders td textarea {
        border: 1px solid #ddd;
        padding: 10px;
        color: #333333;
        width: 100%;
    }

    .recent-orders td select {
        border: 1px solid #ddd;
        padding: 10px;
        width: 100%;
    }

    .recent-orders td input[type="submit"] {
        width: 150px;
        background-color: #4CAF50;

        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .recent-orders td input[type="submit"]:hover {
        background-color: #45a049;
    }

    .recent-orders th {
        color: #333;
        background-color: #f2f2f2;
        text-align: left;
        font-size: 18px;
        font-weight: bold;
        width: 45%;
    }

    .recent-orders td img {
        object-fit: cover;
        border-radius: 5px;
    }

    .recent-orders .actions a {
        text-decoration: none;
        color: #2196F3;
        font-weight: bold;
        padding: 5px 10px;
        border: 1px solid #2196F3;
        border-radius: 3px;
        transition: background-color 0.3s;
    }

    .recent-orders .actions a:hover {
        background-color: #2196F3;
        color: white;
    }

    .footer {
        margin-top: 20px;
        background-color: #333333;
        color: white;
        text-align: center;
        padding: 10px;
    }
</style>
</html>
