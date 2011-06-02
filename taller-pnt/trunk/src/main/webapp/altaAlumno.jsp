<%@ page isELIgnored="true" %>

<h1>Alta de alumnos</h1>
<p>
    Esta página utiliza: 
<ul>
    <li>Servicios REST</li>
    <li>jQuery para invocar a REST</li>
    <br>
    <li>
        <a onclick="fade('GUARDAR', this)" href="#">GUARDAR</a>  
    </li>

    <div id="GUARDAR" align="center">

        <p>En la función redy dentro de la función de submite del formulario guardar, agregar la siguiente línea:</p>
        <b><em> guardar($('#save').serializeObject());</em></b>

    </div>
    <br>
    <li>
        <a onclick="fade('OK', this)" href="#">MENSAJE OK</a>  
    </li>

    <div id="OK" align="center">

        <p>En la función onSuccessSave agregar la siguiente línea:</p>
        <b><em> $().toastmessage('showSuccessToast', 'Alta realizada con id:'+data.id);</em></b>

    </div>
    <br>
    <li>
        <a onclick="fade('ERROR', this)" href="#">MENSAJE ERROR</a>  
    </li>

    <div id="ERROR" align="center">

        <p>En la función onErrorSave agregar la siguiente linea:</p>
        <b><em> $().toastmessage('showToast', {
            text     : 'Error realizando alta de alumno: '+data.responseText,
            sticky   : true,
            type     : 'error'
            
        });</em></b>

    </div>
    <br>

</ul>
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
        
        acultarDocumentacion();
        
        $("#guardar").submit(function(){
            
             
            
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
    function onSuccessSave(data) {        
        
    }
    
    
    /**
     * Muestra el mensaje de error.
     * @param data response.
     */
    function onErrorSave(data) {  
        
        
    }
    
    /**
     * Limpia el formulario.
     */
    function onCompleteSave() {        
        $('#saveCancel').click();
        
    }
    
    /**
     * Convierte el formulario en un
     * objeto json.
     */
    $.fn.serializeObject = function()
    {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
    
    function acultarDocumentacion() {
        $('#GUARDAR').hide();
        $('#OK').hide();
        $('#ERROR').hide();
        
    }
    
    function fade(div_id, elemento) {
        if(elemento.value == 'Mostrar') {
            $('#'+div_id).fadeOut('slow');
            elemento.value = 'Ocultar';
        }
        else {
            $('#'+div_id).fadeIn('slow');
            elemento.value = 'Mostrar';
        }
    }
    

</script>



