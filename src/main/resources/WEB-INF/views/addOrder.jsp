<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Order</title>
</head>
<body>
<h2>Add New Order</h2>
<form:form modelAttribute="order" method="post" action="/saveOrder">
    Date: <form:input path="orderDate" type="date"/><br/>
    Total Amount: <form:input path="totalAmount"/><br/>
    Customer:
    <form:select path="customer.id">
        <form:options items="${customers}" itemValue="id" itemLabel="name"/>
    </form:select><br/>
    <input type="submit" value="Save"/>
</form:form>
<a href="/orders">View All Orders</a>
</body>
</html>
