<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Administrate cards</title>
</head>
<body>
<a href="index">Back on index</a>

<div style="margin-top:50px ">
    <table align="center">
        <tbody>
        <tr align="center">
            <td align="center">${error}<br/></td>
        </tr>
        <tr align="center">
            <td align="center">
                <form name="form" id="form" action="?delete" method="POST">
                    <p>Delete card</p>
                    <table align="center">
                        <tbody>
                        <tr>
                            <td align="right">
                                <input type="text" id="number" name="number"/>
                            </td>
                            <td align="left">
                                <input type="submit" value="Delete"/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </td>
        </tr>
        <tr align="center">
            <td align="center">
                <form:form name="form1" id="form1" action="?add" method="POST" commandName="card">
                    <p>Add card</p>

                    <p>${id}</p>
                    <table align="center">
                        <tbody>
                        <tr>
                            <td align="right">
                                <p>Enter pin code</p>
                            </td>
                            <td align="left">
                                <form:input id="pin" name="pin" path="pin"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <p>Enter amount</p>
                            </td>
                            <td align="left">
                                <form:input id="amount" name="amount" path="amount"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <p>Enter card holder name</p>
                            </td>
                            <td align="left">
                                <form:input id="name" name="name" path="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <p>Enter card holder surname</p>
                            </td>
                            <td align="left">
                                <form:input id="surname" name="name" path="surname"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <p>Choose currency</p>
                            </td>
                            <td align="left">
                                <form:select name="currency" id="currency" path="currency">
                                    <form:options items="${currency}"/>
                                </form:select>
                                <!-- 										<input type="text" id="surname" name="name" path="surname"/>	 -->
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
                                <!-- 										<input type="text" id="surname" name="name" path="surname"/>	 -->
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
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>