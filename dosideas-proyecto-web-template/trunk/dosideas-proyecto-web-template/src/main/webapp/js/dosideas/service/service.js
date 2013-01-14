/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

dosideas.service = (function () {

    /** Esta es la URI base para los servicios de la aplicación. */
    var SERVICE_BASE_URI = dosideas.baseURI + "services";

    /**
     * Realiza una invocación HTTP POST a la url indicada.
     */
    function postJSON(url, data, successCallback, errorCallback, completeCallback) {
        return jQuery.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: successCallback,
            error: errorCallback,
            complete: completeCallback
        });
    }

    /**
    * Realiza una invocación HTTP GET a la url indicada.
    */
    function getJSON(url, successCallback, errorCallback, completeCallback) {
        return jQuery.ajax({
            url: url,
            dataType: 'json',
            success: successCallback,
            error: errorCallback,
            complete: completeCallback
        });
    }

    /**
    * Realiza una invocación HTTP PUT a la url indicada.
    */
    function putJSON(url, data, successCallback, errorCallback, completeCallback) {
        return jQuery.ajax({
            type: 'PUT',
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: successCallback,
            error: errorCallback,
            complete: completeCallback
        });
    }

    return {
        serviceBaseURI : SERVICE_BASE_URI,
        getJSON : getJSON,
        postJSON : postJSON,
        putJSON : putJSON
    }
})();