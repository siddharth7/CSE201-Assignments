<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager</title>
</head>
<body>
<%
	try
	{
		if(session.getAttribute("managerActive").toString().compareTo("true") == 0){
			request.getRequestDispatcher("pendingOrders.jsp").forward(request,response);
		}
		else
		{
			request.getRequestDispatcher("manager.jsp").forward(request,response);
		}
	}
	catch(Exception e)
	{
		
	}
%>
	<h1>Manager Login</h1>
	<form action="PendingOrders" method="post">
		<input name="username" type="text" placeholder="username"/>
		<input name="password" type="password" placeholder="password"/>
		<input type="submit" />
	</form>
</body>
</html>