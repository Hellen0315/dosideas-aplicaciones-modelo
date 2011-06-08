<%@ page isELIgnored="true" %>

<h1>Listado de alumnos</h1>
<p>
    Esta página utiliza: 
<ul>
    <li>Servicios REST</li>
    <li>jQuery para invocar a REST</li>
    <li>jQuery Template para dibujar los datos</li>
    <li>
        <a onclick="toggleDocumentacion('GET')" href="#">GET</a>  
    </li>

    <li>
        <a onclick="toggleDocumentacion('DELETE')" href="#">DELETE</a>  
    </li>

    <li>
        <a onclick="toggleDocumentacion('SORTABLE')" href="#">SORTABLE</a>  
    </li>

</ul>

<div id="GET" align="center">
    <p>En la función ready agregar la siguiente línea:</p>
    <b><em>alumnoService_buscarTodos(dibujarAlumnos);</em></b>
</div>
<div id="DELETE" align="center">
    <p>En el template agregar el div que contiene el link a borrar:</p>
    <b>
        <em>
            &lt;div class="footer"&gt; 
            &lt;a class="borrar" onclick="borrarAlumno(${id})" href="#"&gt;borrar&lt;/a&gt;  
            &lt;/div&gt; 
        </em>
    </b>  
</div>
<div id="SORTABLE" align="center">
    <p>En la función dibujarAlumnos agregar la siguiente linea:</p>
    <b><em>$( "#listaAlumnos" ).sortable({revert: true});</em></b>
</div>


<div id="listaAlumnos" class="listaAlumnosClass">
</div>


<script id="alumnoTemplate" type="text/x-jquery-tmpl">

    <div class="alumno" id="alumno_${id}">
        <div class="header">
            <h1>${apellido}, ${nombre}</h1>
            <small>${email}</small>
        </div>
        <div class="content">
            <h2>Cursos</h2>
            <ol>
                {{each cursos}}
                <li><em>${$value.titulo}.</em></li>
                {{/each}}
            </ol>
        </div>
        
        <div class="footer"> 
            <a class="borrar" onclick="borrarAlumno(${id})" href="#">borrar</a> 
        </div>   

    </div>
</script>

<script type="text/javascript">

    $(document).ready(function() {  
        
        ocultarDocumentacion();
        
        alumnoService_buscarTodos(dibujarAlumnos);
        
        
    });

    /**
     * Dibuja la lista de alumnoss.
     * @param data un array de Alumnos.
     */
    function dibujarAlumnos(data) {
        $( "#listaAlumnos" ).sortable({revert: true});
        $("#listaAlumnos").empty();
        $("#alumnoTemplate" ).tmpl(data).appendTo("#listaAlumnos");    
        
    }

    /**
     * Borra un alumno 
     * @param id del alumno a norrar.
     */
    function borrarAlumno(id) {
        alumnoService_borrar(id,function(){
            $('#alumno_'+id).hide("slow");
        });
    }
    
            
    function toggleDocumentacion(div_id) {
        ocultarDocumentacion();
        $('#'+div_id).toggle("fast");
    }
    
    function ocultarDocumentacion() {
        $('#GET').hide("fast");
        $('#DELETE').hide("fast");
        $('#SORTABLE').hide("fast");
    }

</script>
