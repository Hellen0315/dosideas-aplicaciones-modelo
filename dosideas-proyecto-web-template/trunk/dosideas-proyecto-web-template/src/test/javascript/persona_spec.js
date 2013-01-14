describe('persona test', function() {

    it('post de persona retorna yay', function() {
        var responseData = 'yay';
        var persona;
        var callbackOk = jasmine.createSpy();
        var callbackError = jasmine.createSpy();

        registerFakeAjax({
            url: '/persona',
            type: 'post',
            successData: responseData
        });
        dosideas.service.persona.guardar(persona,callbackOk,callbackError);
        expect(callbackOk).toHaveBeenCalledWith(responseData);
    });

    it('post de persona retorna error', function() {
        var persona;
        var callbackOk = jasmine.createSpy();
        var callbackError = jasmine.createSpy();
        var esperado = {
            responseText : 'fallo'
        };

        registerFakeAjax({
            url: '/persona',
            type: 'post',
            errorMessage: 'fallo'
        });
        dosideas.service.persona.guardar(persona,callbackOk,callbackError);
        expect(callbackError).toHaveBeenCalledWith(esperado);
    });
});