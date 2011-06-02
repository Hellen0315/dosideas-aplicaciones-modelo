/**
 * Funci�n encargada de invocar al servicio que
 * busca todas los alumnos.
 * Paerametro: onSuccessCallback - Puntero a
 * funci�n.
 */
function alumnoService_buscarTodos(onSuccessCallback) {
    $.getJSON('app/alumno', onSuccessCallback );
    
}

/**
 * Funci�n encargada de crear un nuevo alumno
 * Paerametro: data - Alumno
 * Paerametro: onSuccessCallback - Puntero a
 * funci�n.
 * Paerametro: onCompleteCallback - Puntero a
 * funci�n.
 * Paerametro: onErrorCallback - Puntero a
 * funci�n.
 */
function alumnoService_guardar(data, onSuccessCallback,onCompleteCallback, onErrorCallback) {
    
    var url = "app/alumno/alta";
    
    jQuery.ajax({
        type: 'POST',
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: onSuccessCallback,
        complete: onCompleteCallback,
        error: onErrorCallback
        
    });
}

/**
 * Funci�n encargada de crear un nuevo alumno
 * Paerametro: data - Alumno
 * Paerametro: onSuccessCallback - Puntero a
 * funci�n.
 */
function alumnoService_borrar(data, onSuccessCallback) {
    var url = "app/alumno/"+data;
    jQuery.ajax({
        type: 'DELETE',
        url: url,
        success: onSuccessCallback
    });
}

