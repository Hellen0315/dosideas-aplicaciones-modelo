<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Página restringida para usuarios con rol "ALUMNO"</h1>
        <p>
            Bienvenido, <%=request.getUserPrincipal().getName()%> - <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
        </p>
        
        <sec:authorize access="hasRole('PROFESOR')">
            <p>Un PROFESOR visita la página de alumnos!</p>
        </sec:authorize>
        
    </body>    
</html>
