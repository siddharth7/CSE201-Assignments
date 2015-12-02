<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userInfo" method="post">
	<table border="1" style="width:100%">
		<tr>
	 		<td>
	 			<input type="checkbox" name="pizza" value="pizza1" >Pizza1
	 		</td>
	 		<td>
	 			<input type="checkbox" name="pizza1_size" value="regular" >regular
	 	    	<input type="text" name="pizza1_regular">
	 	    </td>
	 	    <td>
	   			<input type="checkbox" name="pizza1_size" value="medium">medium
	       		<input type="text" name="pizza1_medium">
	       	</td>
	 		<td>
	 			<input type="checkbox" name="pizza1_size" value="large">large
	   			<input type="text" name="pizza1_large">
	   		</td>
	   	</tr>
	   	<tr>
	   		<td>
	   			<input type="checkbox" name="pizza" value="pizza2" >Pizza2
	   		</td>
	   		<td>
	 			<input type="checkbox" name="pizza2_size" value="regular" >regular
	 	    	<input type="text" name="pizza2_regular">
	 	    </td>
	   		<td>
	   			<input type="checkbox" name="pizza2_size" value="medium">medium
	       		<input type="text" name="pizza2_medium">
	       	</td>
	   		<td>
	   			<input type="checkbox" name="pizza2_size" value="large">large
	   			<input type="text" name="pizza2_large">
	   		</td>
	   	<tr>
	   	<tr>
	   		<td>
	   			<input type="checkbox" name="pizza" value="pizza3">Pizza3
	   		</td>
	 		<td>
	 			<input type="checkbox" name="pizza3_size" value="regular" >regular
	 	    	<input type="text" name="pizza3_regular">
	 	    </td>
	   		<td>
	   			<input type="checkbox" name="pizza3_size" value="medium">medium
	       		<input type="text" name="pizza3_medium">
	       	</td>
	   		<td>
		   		<input type="checkbox" name="pizza3_size" value="large">large
		       	<input type="text" name="pizza3_large">
	       	</td>
	   	</tr>
	   	<tr>
	   		<td>
	   			<input type="checkbox" name="pizza" value="pizza4">Pizza4
	   		</td>
	 		<td>
	 			<input type="checkbox" name="pizza4_size" value="regular" >regular
	 		    <input type="text" name="pizza4_regular">
	 		</td>
	   		<td>
	   			<input type="checkbox" name="pizza4_size" value="medium">medium
	       		<input type="text" name="pizza4_medium">
	       	</td>
	   		<td>
	   			<input type="checkbox" name="pizza4_size" value="large">large
	       		<input type="text" name="pizza4_large">
	       	</td>
	   	</tr>
	</table>
	<br>
	<input type="checkbox" name="side" value="side1">Side1
	<input type="text" name="side1_quantity">
	   
	<input type="checkbox" name="side" value="side2">Side2
	<input type="text" name="side2_quantity">
	   
	<input type="checkbox" name="side" value="side3">Side3
	<input type="text" name="side3_quantity">
	<br><br>
	<button type="submit">Place Order</button>
</form>
</body>
</html>