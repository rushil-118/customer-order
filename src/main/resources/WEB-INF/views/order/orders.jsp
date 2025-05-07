<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Orders</h2>
<a href="/orders/new">Add Order</a>
<table>
    <tr><th>Date</th><th>Total</th><th>Customer</th><th>Actions</th></tr>
    <c:forEach items="${orders}" var="ord">
        <tr>
            <td>${ord.orderDate}</td>
            <td>${ord.totalAmount}</td>
            <td>${ord.customer.name}</td>
            <td><a href="/orders/edit/${ord.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
