/**
 * Función encargada de invocar al servicio que
 * busca todas los alumnos.
 * Paerametro: onSuccessCallback - Puntero a
 * función.
 */
function alumnoService_buscarTodos(onSuccessCallback) {
    $.getJSON('app/alumno', onSuccessCallback );
}

function alumnoService_guardar(data, onSuccessCallback,onCompleteCallback, onErrorCallback) {
    $.postJSON("app/alumno/alta",data,onSuccessCallback, onCompleteCallback, onErrorCallback);
}

function alumnoService_eliminar(data, onSuccessCallback) {
    $.borrarAlumno("app/alumno/"+data, onSuccessCallback );
}

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

$.borrarAlumno = function(url, successCallback) {
    return jQuery.ajax({
        type: 'DELETE',
        url: url,
        success: successCallback
    });
};