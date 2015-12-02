<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Information</title>
</head>
<body>
<%
		try
		{
			if(session.getAttribute("orderid") == null){
				long unixTime = System.currentTimeMillis() / 1000L;
				String id = "" + unixTime;
				id = id.substring(id.length() - 6);
				session.setAttribute("orderid", id);
			}
		}
		catch(Exception e)
		{
		
		}
	%>
	
	<h3>Order id - <%= session.getAttribute("orderid")%></h3>
<form action="yourOrderPage" method="post">
  <input type="text" name="username" placeholder="username">
  	<input type="text" name="contact" placeholder="contact" >
    <input type="text" name="address" placeholder="address">
    	<button type="submit">Place Order</button>
</body>
</html>