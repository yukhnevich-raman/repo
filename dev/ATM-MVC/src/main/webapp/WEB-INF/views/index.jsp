<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ATM</title>
<link rel="stylesheet" href="http://localhost:8080/ATM-MVC/resources/style.css" type="text/css"/>
</head>
<body>
	<div style="margin-top:200px ">
	<table align="center">
		<tbody>
			<tr align="center">
				<td align="center">${error}<br /></td>
			</tr>
				<tr align="center">
					<td align="center">
					<form name="form1" id="form1" action="?login" method="POST">
					<table align="center">
					<tbody>					
							<tr>
								<td align="right">
									<p>Enter card number</p>
								</td>
								<td align="left">									
										<input type="text" id="number" name="number"/>																	
								</td>
							</tr>
							<tr>
								<td align="right">
									<p>Enter pincode</p>
								</td>
								<td align="left">
									<input type="password" id="pin" name="pin"/>	
								</td>
							</tr>
							<tr>
								<td align="right">
									<a href="admin">Admin</a>
								</td>
								<td align="left">
									<input type="submit" value="Enter"/>
								</td>
							</tr>
						</tbody>
					</table>
					</form>
				</td> 				
			</tr>
			<tr>
				<td align="center">
					<img src="http://localhost:8080/ATM-MVC/resources/card-logo.jpg" align="bottom" />
				</td>
			</tr>
		</tbody>
	</table>
	</div>

</body>
</html>