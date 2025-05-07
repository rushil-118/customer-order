<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Customers</h2>
<a href="/customers/new">Add Customer</a>
<table>
    <tr><th>Name</th><th>Email</th><th>Phone</th><th>Actions</th></tr>
    <c:forEach items="${customers}" var="cust">
        <tr>
            <td>${cust.name}</td>
            <td>${cust.email}</td>
            <td>${cust.phoneNumber}</td>
            <td><a href="/customers/edit/${cust.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
