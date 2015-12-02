<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader" %>
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Track Order</title>
</head>
<body>
<%
	System.out.println(request.getParameter("orderid"));
	if(request.getAttribute("orderid")==null)
	{
		out.println("<h1>Enter Id</h1>");
		out.println("<form action='trackOrderPage' method='get'>");
		out.println("<input type='text' name='orderid'>");
		out.println("<button type='submit'>Track your Order</button>");
		out.println("</form>");
	}
     else 
     {
    	 try
    		{
    			BufferedReader br = new BufferedReader(new FileReader("/Users/siddharthsingh/Documents/orders.txt"));
    			String line = null;
    			while ((line = br.readLine()) != null) {
    			    String values[]=line.split(",");  
    			    if(values[4].equals(request.getAttribute("orderid")))
    			    {
    			    out.println("<div>");
    			     out.println("<form action='trackOrderPage'");
    			     out.println("<h3>"+line+"</h3>");
    			   	 out.println("<button type='submit' value="+values[4]+" "+"name='orderid'>refresh</button>");
    			   	out.println("</form>");
    			   	out.println("</div>");
    			   	out.println("<br>");
    			    } 
    			}
    			br.close();
    		}
    		catch(Exception e)
    		{
    			
    		}
    }

%>
</body>
</html>