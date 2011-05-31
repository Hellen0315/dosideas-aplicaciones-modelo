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
    $.postJSON("app/alumno/alta",data,onSuccessCallback, onCompleteCallback, onErrorCallback);
}

/**
 * Funci�n encargada de crear un nuevo alumno
 * Paerametro: data - Alumno
 * Paerametro: onSuccessCallback - Puntero a
 * funci�n.
 */
function alumnoService_borrar(data, onSuccessCallback) {
    $.borrar("app/alumno/"+data, onSuccessCallback );
}

/**
 * Implemetaci�n de la funci�n $.postJSON.
 * Paerametro: successCallback - Puntero a
 * funci�n.
 * Paerametro: completeCallback - Puntero a
 * funci�n.
 * Paerametro: errorCallback - Puntero a
 * funci�n.
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
 * Implemetaci�n de DELETE.
 * Paerametro: successCallback - Puntero a
 * funci�n.
 */
$.borrar = function(url, successCallback) {
    return jQuery.ajax({
        type: 'DELETE',
        url: url,
        success: successCallback
    });
};