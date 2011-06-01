<%@ page isELIgnored="true" %>

<h1>Listado de alumnos</h1>
<p>
    Esta página utiliza: 
<ul>
    <li>Servicios REST</li>
    <li>jQuery para invocar a REST</li>
    <li>jQuery Template para dibujar los datos</li>
    <br>

    <li>
        <a onclick="fade('GET', this)" href="#">GET</a>  
    </li>

    <div id="GET" align="center">
        <p>En la función redy de la pagina poner la invocación a la siguiente función:</p>
        <b><em>alumnoService_buscarTodos(dibujarAlumnos);</em></b>
    </div>
    
    <li>
        <a onclick="fade('DELETE', this)" href="#">DELETE</a>  
    </li>
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
    
    <li>
        <a onclick="fade('SORTABLE', this)" href="#">SORTABLE</a>  
    </li>

    <div id="SORTABLE" align="center">

        <p>En la función dibujarAlumnos de la pagina agregar la siguiente linea:</p>
        <b><em>$( "#listaAlumnos" ).sortable({revert: true});</em></b>

    </div>
    <br>
    
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

    </div>
</script>

<script type="text/javascript">

    $(document).ready(function() {  
        
        acultarDocumentacion();
        
        
    });

    /**
     * Dibuja la lista de alumnoss.
     * @param data un array de Alumnos.
     */
    function dibujarAlumnos(data) {
        
        $("#listaAlumnos").empty();
        $("#alumnoTemplate" ).tmpl(data).appendTo("#listaAlumnos");
        
    }

    /**
     * Borra un alumno 
     * @param id del alumno a norrar.
     */
    function borrarAlumno(id) {
        alumnoService_borrar(id,onSuccessDelete);
    }
    
    /**
     * Busca todos los alumnos.
     */
    function onSuccessDelete() {        
        alumnoService_buscarTodos(dibujarAlumnos); 
    }
        
    function fade(div_id, button) {
        if(button.value == 'Mostrar') {
            $('#'+div_id).fadeOut('slow');
            button.value = 'Ocultar';
        }
        else {
            $('#'+div_id).fadeIn('slow');
            button.value = 'Mostrar';
        }
    }
    
    function acultarDocumentacion() {
        $('#GET').hide();
        $('#DELETE').hide();
        $('#SORTABLE').hide();
    }

</script>
