<%@ page isELIgnored="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />

        <title>Listado de personas</title>

        <link href="css/demo_page.css" rel="stylesheet" type="text/css"/>
        <link href="css/demo_table_jui.css" rel="stylesheet" type="text/css"/>
        <link href="js/jquery-datatables/smoothness/jquery-ui-1.8.4.custom.css" rel="stylesheet" type="text/css"/>

        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-datatables/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/jquery-template/jquery.tmpl.min.js"></script>
        <script type="text/javascript" src="js/servicios/personaService.js"></script>

    </head>

    <body id="dt_example">
        <div id="container">
            <h1>Listado de personas</h1>
            <table id="listaDePersonas" class="display">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Email</th>
                    </tr>
                </thead>
            </table>
        </div>

    </body>

    <script type="text/javascript" charset="utf-8">

        $(document).ready(function() {

            $("#container").hide();

            personaService_buscarTodos(dibujarTablaDePersonas);
                                
            $("#container").fadeIn("slow");
            
        } );

        /**
         * onSuccessCallback
         */
        function dibujarTablaDePersonas(data) {

            $("#contactTemplate" ).tmpl(data).appendTo("#listaDePersonas");

            $('#listaDePersonas').dataTable({
                "bJQueryUI": true,
                "bScrollInfinite": true,
                "bScrollCollapse": true,
                "sScrollY": "245px",
                "oLanguage": {
                    "sUrl": "js/jquery-datatables/es_AR.txt"
                },
                "fnRowCallback"  :  estiloFilas
            });
        }

        function estiloFilas(nRow,aData,iDisplayIndex) {
            $(nRow).addClass('gradeA');
            return nRow;
        }

    </script>

    <script id="contactTemplate" type="text/x-jquery-tmpl">
        <tr>
            <td>${id}</td>
            <td>${nombre}</td>
            <td>${apellido}</td>
            <td>${email}</td>
        </tr>
    </script>

</html>
