<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Product</title>
    <link rel="stylesheet" href="CSS/add_product.css">
    <style>
        a {
            background-color: #f44336;
            color: white;
            padding: 5px 5px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            border-color: #4CAF50;
        }

        input {
            border-radius: 5px;
            border: 1px solid #ccc;
            padding: 5px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input:hover {
            border-color: #4CAF50;
        }
        .link-cancel{
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Add New Product</h1>
</div>
<div class="container">
    <form method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="nameProduct" placeholder="Insert the name: "></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="descriptionProduct" placeholder="Insert the description: "></td>
            </tr>
            <tr>
                <td>The Image Link:</td>
                <td><input type="text" name="image" placeholder="Insert the image link: "></td>
            </tr>
            <tr>
                <td>The type of product:</td>
                <td>
                    <select name="type">
                        <option value="Shirts">Shirts</option>
                        <option value="Pants">Pants</option>
                        <option value="Outwears">Outwears</option>
                        <option value="Accessories">Accessories</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Size:</td>
                <td>
                    <select name="size">
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                        <option value="XXL">XXL</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Price($):</td>
                <td><input type="number" name="price" placeholder="Insert the price: "></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="quantity" placeholder="Insert the quantity: "></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add new product">
                </td>
                <td>
                    <a class="link-cancel" href="/home_admin?action=home">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
