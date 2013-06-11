<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ATM</title>
    <link rel="stylesheet" href="/ATM/resources/style.css" type="text/css"/>
    <script type="text/javascript" src="/ATM/resources/scripts/validator.js"></script>
</head>
<body>
<div style="margin-top:200px ">
    <table align="center">
        <tbody>
        <tr align="center">
            <td align="center">${error}<br/></td>
        </tr>
        <tr align="center">
            <td align="center">
                <form name="form1" id="form1" action="?login" method="POST">
                    <table align="center">
                        <tbody>
                        <tr>
                            <td align="right">
                                <p>Choose card number</p>
                            </td>
                            <td align="left">
                                <!-- 										<input type="text" id="number" name="number"/>	-->
                                <select id="number" name="number" onchange="test(this.form , this.name);check()">
                                    <option value="">Choose</option>
                                    <c:forEach var="card" items="${cards}">
                                        <option value="${card.id}">${card.id}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td align="left">
                                <img align="left" id="number_ok_img" src="/ATM/resources/ok.png" class="undisplayed"/>
                                <img align="left" id="number_bad_img" src="/ATM/resources/bad.png" class="undisplayed"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <p>Enter pincode</p>
                            </td>
                            <td align="left">
                                <input type="password" id="pin" name="pin" onBlur=""
                                       onkeyup="test(this.form , this.name);check()"/>
                            </td>
                            <td align="left">
                                <img align="left" id="pin_ok_img" src="/ATM/resources/ok.png" class="undisplayed"/>
                                <img align="left" id="pin_bad_img" src="/ATM/resources/bad.png" class="undisplayed"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <a href="admin">Admin</a>
                            </td>
                            <td align="left">
                                <input id="enter" type="submit" class="undisplayed" value="Enter"/>
                            </td>
                            <td/>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </td>
        </tr>
        <tr>
            <td align="center">
                <img src="/ATM/resources/card-logo.jpg" align="bottom" style="display: block;"/>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>