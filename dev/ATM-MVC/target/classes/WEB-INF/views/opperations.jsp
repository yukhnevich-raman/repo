<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Card operations</title>
<script type="text/javascript"
	src="http://localhost:8080/ATM/resources/scripts/opperations.js"></script>
<script src="http://localhost:8080/ATM/resources/scripts/jquery.js"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="http://localhost:8080/ATM/resources/style.css" type="text/css" />
</head>
<body>
	<table align="center" cellpadding="1" cellspacing="1"
		style="width: 1000px;" height="500px">
		<tbody>
			<tr>
				<td valign="top" align="right">Hi ${card.name} ${card.surname}!
					(<a href="index">log out</a>)
				</td>
			</tr>
			<tr>
				<td>
					<table align="center" border="1" cellpadding="1" cellspacing="1"
						style="width: 1000px;" height="100%">
						<tbody>
							<tr>
								<td style="width: 300px;" align="left" valign="top">
									<table>
										<tbody>
											<tr>
												<td valign="top"><br />Available operations:</td>
											</tr>
											<tr>
												<td valign="top"><a href="" name="ballance"
													onclick="opp(this.name); return false">View card
														balance</a><br /> <a href="" name="pays"
													onclick="opp(this.name); return false">Pays</a><br /> <a
													href="" name="transfer"
													onclick="opp(this.name); return false">Money transfer</a><br />
													<a href="" name="stat"
													onclick="opp(this.name); return false">Billing activity</a><br />
													<a href="" name="exchange"
													onclick="opp(this.name); return false">Currency Exchange Calculator</a><br />
												</td>
											</tr>
										</tbody>
									</table>
								</td>
								<td style="width: 700px;" align="right" valign="top">
									<div id="error">
										<p align="center">${error}</p>
									</div>
									<table>
										<tbody>
											<tr>
												<td valign="top">
													<div id="ballance" class="undisplayed">
														<br />
														<p align="center">Card balance information</p>
														<table border="1" align="right" cellpadding="1"
															cellspacing="1" style="width: 700px;" height="100%">
															<tbody>
																<tr>
																	<td style="width: 140px;">Id</td>
																	<td style="width: 140px;">Name</td>
																	<td style="width: 140px;">Surname</td>
																	<td style="width: 140px;">Amount</td>
																	<td style="width: 140px;">Currency</td>
																</tr>
																<tr>
																	<td style="width: 140px;">${card.id}</td>
																	<td style="width: 140px;">${card.name}</td>
																	<td style="width: 140px;">${card.surname}</td>
																	<td style="width: 140px;">${card.amount}</td>
																	<td style="width: 140px;">${card.currency}</td>
																</tr>
															</tbody>
														</table>
													</div>
													<div id="pays" class="undisplayed">
														<br />
														<table border="1" align="right" cellpadding="1"
															cellspacing="1" style="width: 700px;" height="100%">
															<tbody>
																<tr>
																	<td>Fuck U !</td>
																</tr>
															</tbody>
														</table>
													</div>
													<div id="transfer" class="undisplayed">
														<p align="center">Money transfer</p>
														<form name="transfer_form" id="transfer_form"
															action="?transfer" method="POST">
															<table border="0" align="right" cellpadding="1"
																cellspacing="1" style="width: 700px;" height="100%">
																<tbody>
																	<tr>
																		<td valign="top" class="opperations-300-width"
																			align="right">Select a card you want to transfer
																			money:</td>
																		<td valign="top" class="opperations-300-width"
																			align="left"><select id="to" name="to">
																				<option value="" class="opperations-300-width">Choose</option>
																				<c:forEach var="card" items="${transfer}">
																					<option value="${card.id}">${card.id}</option>
																				</c:forEach>
																		</select></td>
																	</tr>
																	<br />
																	<tr>
																		<td valign="top" align="right"
																			class="opperations-300-width">Enter amount to
																			transfer:<br /> (${card.amount} ${card.currency} available on your card)
																		</td>
																		<td valign="top" align="left"
																			class="opperations-300-width"><input id="amount"
																			name="amount" type="text" value="0"
																			class="opperations-300-width"></td>
																	</tr>
																	<br />
																	<tr>
																		<td class="opperations-300-width" />
																		<td valign="top" style="width: 100px;" align="left"><input
																			id="sub_transfer" name="sub_transfer" type="submit"
																			value="Transfer"></td>
																	</tr>
																</tbody>
															</table>
														</form>
													</div>
													<div id="stat" class="undisplayed">
														<br />
														<p align="center">Billing activity</p>
														<table border="1" cellpadding="1" cellspacing="1"
															style="width: 700px;">
															<tbody>
																<tr>
																	<td class="invoice-column">From card</td>
																	<td class="invoice-column">To card</td>
																	<td class="invoice-column">Amount</td>
																	<td class="invoice-column">Currency</td>
																	<td class="invoice-column">Date</td>
																	<td class="invoice-column">Type</td>
																</tr>
																<c:forEach var="outcome" items="${outcome}">
																	<tr>
																		<td class="invoice-column">${outcome.fromCard}</td>
																		<td class="invoice-column">${outcome.toCard}</td>
																		<td class="invoice-column">${outcome.amount}</td>
																		<td class="invoice-column">${outcome.currency}</td>
																		<td class="invoice-column">${outcome.date}</td>
																		<td class="invoice-column">Expenditure</td>
																	</tr>
																</c:forEach>
																<c:forEach var="income" items="${income}">
																	<tr>
																		<td class="invoice-column">${income.fromCard}</td>
																		<td class="invoice-column">${income.toCard}</td>
																		<td class="invoice-column">${income.amount}</td>
																		<td class="invoice-column">${income.currency}</td>
																		<td class="invoice-column">${income.date}</td>
																		<td class="invoice-column">Income</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
													<div id="exchange" class="undisplayed">
														<p align="center">Currency exchange calculator</p>
														<form name="exchange_form" id="exchange_form"
															action="?exchange" method="POST">
															<table border="0" align="center" cellpadding="1"
																cellspacing="1" style="width: 700px;" height="100%">
																<tbody>
																	<tr>
																		<td valign="top" class="opperations-300-width"
																			align="right">From:</td>
																		<td valign="top" class="opperations-300-width"
																			align="left"><select id="from" name="from">
																				<option value="" class="opperations-300-width">Choose</option>
																				<c:forEach var="currency" items="${currency}">
																					<option value="${currency}">${currency}</option>
																				</c:forEach>
																		</select></td>
																	</tr>
																	<br />
																	<tr>
																		<td valign="top" align="right"
																			class="opperations-300-width">To:
																		</td>
																		<td valign="top" class="opperations-300-width"
																			align="left"><select id="to" name="to">
																				<option value="" class="opperations-300-width">Choose</option>
																				<c:forEach var="currency" items="${currency}">
																					<option value="${currency}">${currency}</option>
																				</c:forEach>
																		</select></td>
																	</tr>
																	<tr>
																		<td valign="top" align="right"
																			class="opperations-300-width">Amount:
																		</td>
																		<td valign="top" align="left"
																			class="opperations-300-width"><input id="amount"
																			name="amount" type="text" value="0"
																			class="opperations-300-width"></td>
																	</tr>
																	<br />
																	<tr>
																		<td class="opperations-300-width" />
																		<td valign="top" style="width: 100px;" align="left"><input
																			id="exchange_" name="exchange_" type="submit"
																			value="Exchange"></td>
																	</tr>
																	<tr>
																		<td valign="top" align="right"
																			class="opperations-300-width">Result:
																		</td>
																		<td valign="top" align="left"
																			class="opperations-300-width"><input id="result"
																			name="result" type="result" value="${result}"
																			class="opperations-300-width"></td>
																	</tr>
																</tbody>
															</table>
														</form>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>