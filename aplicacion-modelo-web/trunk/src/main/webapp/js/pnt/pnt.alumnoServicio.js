/**
 * Función encargada de invocar al servicio que
 * busca todas los alumnos.
 * Paerametro: onSuccessCallback - Puntero a
 * función.
 */
function alumnoService_buscarTodos(onSuccessCallback) {
    $.getJSON('app/alumno', onSuccessCallback );
    
}

/**
 * Función encargada de crear un nuevo alumno
 * Paerametro: data - Alumno
 * Paerametro: onSuccessCallback - Puntero a
 * función.
 * Paerametro: onCompleteCallback - Puntero a
 * función.
 * Paerametro: onErrorCallback - Puntero a
 * función.
 */
function alumnoService_guardar(alumno, onSuccessCallback,onCompleteCallback, onErrorCallback) {
    
    var url = "app/alumno/alta";
    
    jQuery.ajax({
        type: 'POST',
        url: url,
        contentType: 'application/json',
        data: $.toJSON(alumno),
        dataType: 'json',
        success: onSuccessCallback,
        complete: onCompleteCallback,
        error: onErrorCallback
        
    });
}

/**
 * Función encargada de crear un nuevo alumno
 * Paerametro: id - id del Alumno
 * Paerametro: onSuccessCallback - Puntero a
 * función.
 */
function alumnoService_borrar(id, onSuccessCallback) {
    var url = "app/alumno/"+id;
    jQuery.ajax({
        type: 'DELETE',
        url: url,
        success: onSuccessCallback
    });
}

