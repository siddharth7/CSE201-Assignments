<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
     <%= "OrderPizza.com" %>
<form action="orderPage" method="post">
		<button type="submit">Place a New Order</button>
	</form>
<form action="trackOrderPage" method="post">
		<button type="submit">Track your Order</button>
	</form>
<a href = "manager.jsp">Manager login</a>
<br>
	<a href = "admin.jsp">System login</a>
</body>
</html>