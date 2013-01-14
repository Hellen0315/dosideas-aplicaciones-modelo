/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

dosideas.service.persona = (function () {

    function guardar(persona, onSuccessCallback, onErrorCallback) {
        dosideas.service.postJSON(dosideas.service.serviceBaseURI + "/persona", persona, onSuccessCallback, onErrorCallback);
    }

    return {
        guardar : guardar
    }
})();