/**
 * Mensajes Ok.
 */
function pnt_mostrarMensajeOk(mensaje) {
    $().toastmessage('showSuccessToast', mensaje);   
}

/**
 * Mensajes de error.
 */
function pnt_mostrarMensajeError(mensaje) {
    
    $().toastmessage('showToast', {
            text     : mensaje,
            sticky   : true,
            type     : 'error'

            });
            
}

