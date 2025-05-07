<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<h2>Add New Customer</h2>
<form:form modelAttribute="customer" method="post" action="/saveCustomer">
    Name: <form:input path="name"/><br/>
    Email: <form:input path="email"/><br/>
    Phone: <form:input path="phoneNumber"/><br/>
    <input type="submit" value="Save"/>
</form:form>
<a href="/customers">View All Customers</a>
</body>
</html>
