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
function alumnoService_guardar(data, onSuccessCallback,onCompleteCallback, onErrorCallback) {
    $.postJSON("app/alumno/alta",data,onSuccessCallback, onCompleteCallback, onErrorCallback);
}

/**
 * Función encargada de crear un nuevo alumno
 * Paerametro: data - Alumno
 * Paerametro: onSuccessCallback - Puntero a
 * función.
 */
function alumnoService_borrar(data, onSuccessCallback) {
    $.borrar("app/alumno/"+data, onSuccessCallback );
}

/**
 * Implemetación de la función $.postJSON.
 * Paerametro: successCallback - Puntero a
 * función.
 * Paerametro: completeCallback - Puntero a
 * función.
 * Paerametro: errorCallback - Puntero a
 * función.
 */
$.postJSON = function(url, data, successCallback, completeCallback, errorCallback) {
    return jQuery.ajax({
        type: 'POST',
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: successCallback,
        complete: completeCallback,
        error: errorCallback
        
    });
};

/**
 * Implemetación de DELETE.
 * Paerametro: successCallback - Puntero a
 * función.
 */
$.borrar = function(url, successCallback) {
    return jQuery.ajax({
        type: 'DELETE',
        url: url,
        success: successCallback
    });
};