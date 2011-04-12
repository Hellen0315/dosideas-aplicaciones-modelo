<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />

        <title><tiles:getAsString name="title"/></title>

        <link href="<c:url value="/css/default.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/js/jquery-datatables/demo_page.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/js/jquery-datatables/demo_table_jui.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/js/jquery-datatables/smoothness/jquery-ui-1.8.4.custom.css"/>" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="<c:url value="/js/jquery/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-datatables/jquery.dataTables.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery-template/jquery.tmpl.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/servicios/personaService.js"/>"></script>

    </head>
    <body>
        <div class="header">
            <a href="<c:url value="/"/>">Inicio</a>
        </div>
        <div class="wrapper">
            <tiles:insertAttribute name="body"/>
        </div>
    </body>
</html>
