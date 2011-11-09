<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />

        <link href="<c:url value="/css/default.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/js/jquery-toastmessage/css/jquery.toastmessage.css"/>" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="<c:url value="/js/jquery/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-template/jquery.tmpl.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-json/jquery.json-2.2.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-toastmessage/jquery.toastmessage.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-ui/jquery-ui-1.8.12.custom.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/pnt/pnt.alumnoServicio.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/pnt/pnt.conversores.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/pnt/pnt.mensajes.js"/>"></script>
    </head>
    <body>
        <h1>Consulta de paises</h1>
        <p>
            <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
        </p>

        <form id="consultaPaisForm" action="#">
            <input type="text" id="codigoPais" value="" size="10"/>
            <input type="submit" value="Consultar"/>
        </form>

        <div id="listaPaises"></div>

        
        
        <script id="paisTemplate" type="text/x-jquery-tmpl">
            ${id} - ${nombre}
            <br/>
        </script>

        <script lang="javascript">
            $(document).ready(function() {
                $("#consultaPaisForm").submit(function () {
                    consultarPais();
                    return false;
                });
            });
            
            function consultarPais() {
                var url = "<c:url value="/app/pais"/>" + "/" + $("#codigoPais").val();
                $.getJSON(url, onConsultarPaisSuccess).error(function (e) {
                    $("#listaPaises").empty();
                    $("#listaPaises").html("Error al consultar - HTTP StatusCode: " + e.status);
                });
            }
            
            function onConsultarPaisSuccess(pais) {
                $("#listaPaises").empty();
                $("#paisTemplate" ).tmpl(pais).appendTo("#listaPaises"); 
            }

        </script>

    </body>    
</html>
