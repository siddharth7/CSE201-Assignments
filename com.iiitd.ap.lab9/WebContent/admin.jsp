<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.RequestDispatcher" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
<%
		try
			{
			if(session.getAttribute("adminActive").toString().compareTo("true") == 0){
			request.getRequestDispatcher("currentOrders.jsp").forward(request,response);
		}
		else
		{
			request.getRequestDispatcher("admin.jsp").forward(request,response);
		}
			}
	catch(Exception e)
	{
		
	}
%>
<form action="allorders" method="post">
		<input name="userName" type="text" placeholder="username"/>
		<input name="password" type="password" placeholder="password"/>
		<input type="submit" />
	</form>
</body>
</html>