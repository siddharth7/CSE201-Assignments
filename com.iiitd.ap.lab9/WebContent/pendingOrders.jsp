<%@page import="java.util.ArrayList"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader" %>
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.util.ArrayList" %>

<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>current orders</title>
</head>
<body>
<%
		if(session.getAttribute("managerActive")==null){
			request.getRequestDispatcher("manager").forward(request,response);
		}
	%>
<h1> welcome user</h1>
<%!
public void printorders(ArrayList<String> alldata, javax.servlet.jsp.JspWriter myOut)
{
	ArrayList<String> alldata2= new ArrayList<String>();
	try
	{
		BufferedReader br = new BufferedReader(new FileReader("/Users/siddharthsingh/Documents/orders.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
		    String values[]=line.split(",");  
			alldata2.add(line);
			if(values[5].equals("delivered"))
			{
				
			}
			else
			{
			String s="<tr>";
		      myOut.println("<div>");
		      myOut.println("<form action='updateOrderPage2' method='post'>");
		      //myOut.println("<h3>"+line+"</h3>");
		      s += "<td>";
					s += values[0];
					s += "</td>";
					s += "<td>";
					s += values[1]+" ";
					s += "</td>";
					s += "<td>";
					s += (values[2])+" ";
					s += "</td>";
					s += "<td>";
					s += (values[3].substring(1, values[3].length() - 1))+" ";
					s += "</td>";
					s += "<td>";
					s += values[4]+" ";
					s += "</td>";
					s += "<td>";
					s += values[5]+" ";
					s += "</td>";
					s += "</tr>";
					myOut.println(s);
		   	myOut.println("<button type='submit' value="+values[4]+" "+"name='ubtn'>Update Order Status</button>");
		   	myOut.println("</form>");
		   	myOut.println("</div>");
		   	myOut.println("<br>");
		   	
			}   
		}
		br.close();
	}
	catch(Exception e)
	{
		
	}
}
%>
<%
	HttpSession s = request.getSession();
	ArrayList<String> alldata2=(ArrayList<String>)s.getAttribute("alldata2");
	printorders(alldata2,out);
%>
<form action="logout" method="get">
	<button type="submit">LogOutManager</button>
</form>
</body>
</html>