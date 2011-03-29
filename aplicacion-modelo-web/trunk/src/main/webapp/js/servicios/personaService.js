/**
 * Función encargada de invocar al servicio que
 * busca todas las personas.
 * Paerametro: onSuccessCallback - Puntero a
 * función.
 */
function personaService_buscarTodos(onSuccessCallback) {
    $.getJSON('app/persona/todos', onSuccessCallback );
}

function personaService_guardar(data, onSuccessCallback) {
    alert("guardar: "+ data);
    $.postJSON("/app/persona/guardar",data,successCallback);
}

$.postJSON = function(url, data, successCallback) {
    
    alert("POST: "+ data);
    return jQuery.ajax({
        type: 'POST',
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: successCallback
        
    });
};





