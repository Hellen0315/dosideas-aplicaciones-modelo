<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Security Workshop</title>
    </head>
    <body>
        <h1>Login</h1>

        <form id="loginForm" name="f" action="<c:url value="/j_spring_security_check" />" method="POST">
            <label>Usuario: </label><input type="text" name="j_username" required="required" />
            <br/>
            <label>Contraseña: </label><input type="password" name="j_password" required="required" />
            <br/>
            <label>Recordarme: </label><input type="checkbox" name="_spring_security_remember_me"/>
            <br/><br/>
            <input type="submit" value="Login"/>
        </form>

        <br/><br/>
        <a href="<c:url value="/"/>">Página de inicio</a>
    </body>
</html>
