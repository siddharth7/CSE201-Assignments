<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Complete</title>
</head>
<body>
	<h3>Your Order has been Placed</h3>
<%!
	public void showorder(String order,String name,String address, String contact, javax.servlet.jsp.JspWriter myOut)
	{
		try
		{
			/* myOut.println("<h3>"+"your oder is : "+order+"</h3>");
			myOut.println("<h3>"+"Name : "+name+"</h3>");
			myOut.println("<h3>"+"Contact Number : "+contact+"</h3>");
			myOut.println("<h3>"+"Address : "+address+"</h3>"); */
			myOut.println("<p>"+"Your order is : "+order+"<p>");
			myOut.println("<p>"+"Name : "+name+"</p>");
			myOut.println("<p>"+"Contact Number : "+contact+"</p>");
			myOut.println("<p>"+"Address : "+address+"</p>");
			
		}
		catch(Exception e)
		{
			
		}
		return;
	}
%>
<% 
	HttpSession s = request.getSession();
	System.out.println(s.getAttribute("order"));
	/* System.out.println(s.getAttribute("address")+"kya mazak hai");
	System.out.println(s.getAttribute("contact")); */

	showorder(s.getAttribute("order").toString(),s.getAttribute("username").toString(),s.getAttribute("address").toString(),s.getAttribute("contact").toString(),out); 

	out.println("<form action='trackOrderPage'>");
	out.println("<button type='submit' value="+s.getAttribute("orderid")+" "+"name='orderid'>Track your Order</button>");
	out.println("</form>");
%>
	</body>
</html>