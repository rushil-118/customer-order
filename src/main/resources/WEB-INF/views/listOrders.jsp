<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h2>Order List</h2>
<table border="1">
    <tr>
        <th>Order Date</th>
        <th>Total</th>
        <th>Customer Name</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.orderDate}</td>
            <td>${order.totalAmount}</td>
            <td>${order.customer.name}</td>
        </tr>
    </c:forEach>
</table>
<a href="/addOrder">Add New Order</a>
</body>
</html>
