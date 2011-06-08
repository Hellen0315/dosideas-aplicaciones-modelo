<%@ page isELIgnored="true" %>

<h1>Alta de alumnos</h1>
<p>
    Esta página utiliza: 
<ul>
    <li>Servicios REST</li>
    <li>jQuery para invocar a REST</li>
    <br>
    <li>
        <a onclick="toggleDocumentacion('GUARDAR')" href="#">GUARDAR</a>  
    </li>
    <li>
        <a onclick="toggleDocumentacion('OK')" href="#">MENSAJE OK</a>  
    </li>

    <li>
        <a onclick="toggleDocumentacion('ERROR')" href="#">MENSAJE ERROR</a>  
    </li>

    <br>

</ul>

<div id="GUARDAR" align="center">

    <p>En la función ready dentro de la función de submite del formulario guardar, agregar la siguiente línea:</p>
    <b><em> guardar($('#guardar').serializeObject());</em></b>

</div>

<div id="OK" align="center">

    <p>En la función onSuccessSave agregar la siguiente línea:</p>
    <b><em> $().toastmessage('showSuccessToast', 'Alta realizada con id:'+data.id);</em></b>

</div>

<div id="ERROR" align="center">

    <p>En la función onErrorSave agregar la siguiente linea:</p>
    <b><em> $().toastmessage('showToast', {
            text     : 'Error realizando alta de alumno: '+data.responseText,
            sticky   : true,
            type     : 'error'

            });</em></b>

</div>
</p>

<form id="guardar">
    <div class="alta">
        <fieldset>
            <div class="header_alta">
                <h1>Formulario de Alta</h1>
            </div>

            <label> Nombre : </label>
            <input type="text" name="nombre" />
            <label> Apellido : </label>
            <input type="text" name="apellido"  />
            <label> Email : </label>
            <input type="text" name="email"  />

        </fieldset>
        <input type="submit" value="Guardar Alumno" id="save"/>
        <input type="reset" value="Cancelar" id="saveCancel" />
    </div>
</form>

<script type="text/javascript">

    $(document).ready(function() {
        
        ocultarDocumentacion();
        
        $("#guardar").submit(function(){
            
            guardar($('#guardar').serializeObject());
             
            return false;
        });
        
    });
    
    /**
     * Guarda un alumno.
     * @param data un Alumno.
     */
    function guardar(data) {        
        alumnoService_guardar(data, onSuccessSave,onCompleteSave,onErrorSave); 
    }
    
    /**
     * Muestra el mensaje por success.
     * @param data alumno guardado.
     */
    function onSuccessSave(alumno) {        
        onSuccess('Alta realizada con id:'+alumno.id);
    }
    
    
    /**
     * Muestra el mensaje de error.
     * @param data response.
     */
    function onErrorSave(data) {  
        onError('Error realizando alta de alumno: '+data.responseText);
      
    }
    
    /**
     * Limpia el formulario.
     */
    function onCompleteSave() {        
        $('#saveCancel').click();
        
    }
    
    
    
    function toggleDocumentacion(div_id) {
        ocultarDocumentacion();
        $('#'+div_id).toggle("fast");
    }
    
    function ocultarDocumentacion() {
        $('#GUARDAR').hide("fast");
        $('#OK').hide("fast");
        $('#ERROR').hide("fast");
    }
    

</script>



