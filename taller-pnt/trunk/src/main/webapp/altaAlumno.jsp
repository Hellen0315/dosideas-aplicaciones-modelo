<%@ page isELIgnored="true" %>

<h1>Alta de alumnos</h1>
<p>
    Esta página utiliza: 
<ul>
    <li>Servicios REST</li>
    <li>jQuery para invocar a REST</li>

</ul>
</p>

<form id="save">
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
        
        $("#save").submit(function(){
            
            guardar($('#save').serializeObject());
            
            return false;
        });
        
    });
           
    function guardar(data) {        
        alumnoService_guardar(data, onSuccessSave,onCompleteSave,onErrorSave); 
    }
    
    function onSuccessSave(data) {        
        $().toastmessage('showSuccessToast', 'Alta realizada con id:'+data.id);
        
    }
    
    function onCompleteSave() {        
        $('#saveCancel').click();
        
    }
    
    function onErrorSave(data) {        
        $().toastmessage('showToast', {
            text     : 'Error realizando alta de alumno: '+data.responseText,
            sticky   : true,
            type     : 'error'
            
        });
        
    }
    
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
    

</script>



