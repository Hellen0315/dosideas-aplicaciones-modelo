/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

/**
 * Funciones públicas para la aplicación. Este es el módulo principal para todas
 * las funciones y servicios del cliente.
 */
var dosideas = (function () {
    /** Returna la URI base de la aplicación.
     */
    function baseURI() {
        if (document.baseURI) {
            return document.baseURI;
        }
        //para variar, IE no soporta document.baseURI...
        var base = document.getElementsByTagName('base');
        if (base && base[0] && base[0].href) {
            return base[0].href;
        }
        //no se encontró la base URI en el documento, se usan URIs relativas
        return "";
    }

    var BASE_URI = baseURI();

    return {
        baseURI : BASE_URI
    }
})();