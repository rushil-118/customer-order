<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<h2>Customer List</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    <c:forEach var="cust" items="${customers}">
        <tr>
            <td>${cust.name}</td>
            <td>${cust.email}</td>
            <td>${cust.phoneNumber}</td>
        </tr>
    </c:forEach>
</table>
<a href="/addCustomer">Add New Customer</a>
</body>
</html>
