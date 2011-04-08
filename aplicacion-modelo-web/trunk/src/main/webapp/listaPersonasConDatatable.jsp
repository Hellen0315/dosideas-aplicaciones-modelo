<%@ page isELIgnored="true" %>

<h1>Listado de personas</h1>
<p>
    Esta página utiliza: 
    <ul>
        <li>Servicios REST</li>
        <li>jQuery para invocar a REST</li>
        <li>jQuery Template para dibujar los datos</li>
        <li>jQuery Datatable para armar la tabla final</li>
    </ul>
</p>

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

<script id="contactTemplate" type="text/x-jquery-tmpl">
    <tr>
        <td>${id}</td>
        <td>${nombre}</td>
        <td>${apellido}</td>
        <td>${email}</td>
    </tr>
</script>

<script type="text/javascript">

    $(document).ready(function() {
        $("#container").hide();
        personaService_buscarTodos(dibujarTablaDePersonas); 
        $("#container").fadeIn("slow");
    } );

    /**
     * Dibuja la lista de personas en la tabla.
     * @param data un array de Persona.
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



