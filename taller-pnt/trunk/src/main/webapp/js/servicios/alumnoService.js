/**
 * Función encargada de invocar al servicio que
 * busca todas los alumnos.
 * Paerametro: onSuccessCallback - Puntero a
 * función.
 */
function alumnoService_buscarTodos(onSuccessCallback) {
    $.getJSON('app/alumno/todos', onSuccessCallback );
}

function alumnoService_guardar(data, onSuccessCallback) {
    $.postJSON("/app/alumno/guardar",data,successCallback);
}

function alumnoService_eliminar(data, onSuccessCallback) {
    $.deleteAlumno("app/alumno/"+data+"/eliminar", onSuccessCallback );
}

$.postJSON = function(url, data, successCallback) {
    return jQuery.ajax({
        type: 'POST',
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: successCallback
        
    });
};

$.deleteAlumno = function(url, successCallback) {
    return jQuery.ajax({
        type: 'DELETE',
        url: url,
        success: successCallback
    });
};






