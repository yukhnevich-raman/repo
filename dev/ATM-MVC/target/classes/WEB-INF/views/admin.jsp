<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://localhost:8080/ATM/resources/style.css" type="text/css"/>
<script type="text/javascript" src="http://localhost:8080/ATM/resources/scripts/validator.js"></script>
<script src="http://localhost:8080/ATM/resources/scripts/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
	$('.splLink').click(function(){
	$(this).parent().children('div.splCont').toggle('normal');
	return false;
	});
	});
</script>
<title>Administrate cards</title>
</head>
<body>
	<a href="index">Back on index</a>
	<div style="margin-top:50px ">
	<table align="center" width="50%">
		<tbody>
			<tr align="center">
				<td align="center">
					<p>${message}</p>
				</td>
			</tr>
			<tr align="center">
				<td align="center" class="header">
					<a href="javscript://" class="splLink"><strong>Delete card</strong></a>
					<div class="splCont">
						<form name="form" id="form" action="?delete" method="POST">
						<table align="center" class="control-table">
							<tbody>					
								<tr>
									<td align="right" width="30%">
										<select id="id" name="id">
											<option value="">Choose</option>
											<c:forEach var="card" items="${cards}">
												<option value="${card.id}">${card.id}</option>
											</c:forEach>
										</select>			
									</td>
									<td align="right" width="42%">									
										<input type="submit" value="Delete"/>																
									</td>
									<td align="left">
										<img align="left" id="id_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
										<img align="left" id="id_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
									</td>
								</tr>
							</tbody>
						</table>
					</form>
					</div> 
				</td>
			</tr>
			<tr align="center">
				<td align="center" class="header">
					<a href="javscript://" class="splLink"><strong>Unblock card</strong></a>
					<div class="splCont">
						<form name="form" id="form" action="?unblock" method="POST">
						<table align="center" class="control-table">
							<tbody>					
								<tr>
									<td align="right" width="30%">
										<select id="id" name="id">
											<option value="">Choose</option>
											<c:forEach var="card" items="${block}">
												<option value="${card.id}">${card.id}</option>
											</c:forEach>
										</select>			
									</td>
									<td align="right" width="42%">									
										<input type="submit" value="Unblock"/>																
									</td>
									<td align="left">
										<img align="left" id="id_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
										<img align="left" id="id_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
									</td>
								</tr>
							</tbody>
						</table>
					</form>
					</div> 
				</td>
			</tr>
			<tr align="center">
				<td align="center" class="header">
				<a href="javscript://" class="splLink"><strong>Add card</strong></a>
					<div class="splCont">
						<form:form name="form1" id="form1" action="?add" method="POST" commandName="card">
						<table align="center" class="control-table">
							<tbody>					
								<tr>
									<td align="right">
										<p>Enter pin code</p>
									</td>
									<td align="left">									
										<form:input id="pin" name="pin" path="pin"/>																	
									</td>
									<td align="left">
										<img align="left" id="pin_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
										<img align="left" id="pin_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
									</td>
								</tr>
								<tr>
									<td align="right">
										<p>Enter amount</p>
									</td>
									<td align="left">
										<form:input id="amount" name="amount" path="amount"/>	
									</td>
									<td align="left">
										<img align="left" id="amount_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
										<img align="left" id="amount_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
									</td>
								</tr>
								<tr>
									<td align="right">
										<p>Enter card holder name</p>
									</td>
									<td align="left">
										<form:input id="name" name="name" path="name"/>	
									</td>
									<td align="left">
										<img align="left" id="name_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
										<img align="left" id="name_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
								</td>
								</tr>
								<tr>
									<td align="right">
										<p>Enter card holder surname</p>
									</td>
									<td align="left">
										<form:input id="surname" name="name" path="surname"/>	
									</td>
									<td align="left">
										<img align="left" id="surname_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
										<img align="left" id="surname_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
									</td>
								</tr>
								<tr>
									<td align="right">
										<p>Choose currency</p>
									</td>
									<td align="left">
										<form:select name="currency" id="currency" path="currency">
											<form:options items="${currency}" />
										</form:select>
									</td>
									<td align="left">
										<img align="left" id="currency_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
										<img align="left" id="currency_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
									</td>
									</tr>
									<tr>
										<td align="right">
											<p>Choose blocked</p>
										</td>
										<td align="left">
											<form:select name="blocked" id="blocked" path="blocked">
												<form:options items="${blocked}"/>
											</form:select>
										</td>
										<td align="left">
											<img align="left" id="blocked_ok_img" src="http://localhost:8080/ATM/resources/ok.png" class="undisplayed"/>
											<img align="left" id="blocked_bad_img" src="http://localhost:8080/ATM/resources/bad.png" class="undisplayed"/>	
										</td>
									</tr>
									<tr>
										<td align="right">
										</td>
									<td align="left">
										<input type="submit" value="Add"/>
									</td>
								</tr>
							</tbody>
						</table>
						</form:form>
					</div>
				</td> 				
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>