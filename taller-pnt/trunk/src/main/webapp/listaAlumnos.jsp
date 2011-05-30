<%@ page isELIgnored="true" %>

<h1>Listado de alumnos</h1>
<p>
    Esta página utiliza: 
<ul>
    <li>Servicios REST</li>
    <li>jQuery para invocar a REST</li>
    <li>jQuery Template para dibujar los datos</li>

</ul>
</p>

<div id="listaAlumnos" class="listaAlumnosClass">
</div>



<script id="alumnoTemplate" type="text/x-jquery-tmpl">

    <div class="alumno">
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
        alumnoService_buscarTodos(dibujarAlumnos); 
    });

    /**
     * Dibuja la lista de alumnoss.
     * @param data un array de Alumnos.
     */
    function dibujarAlumnos(data) {
        
        $("#listaAlumnos").empty();
        $( "#listaAlumnos" ).sortable({revert: true});
        $("#alumnoTemplate" ).tmpl(data).appendTo("#listaAlumnos");
        
    }
        
    function borrarAlumno(id) {
        alumnoService_eliminar(id,onSuccessDelete);
    }
    
    function onSuccessDelete() {        
        alumnoService_buscarTodos(dibujarAlumnos); 
    }
    
    

</script>



