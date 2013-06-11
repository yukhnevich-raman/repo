Ext.define('ATM.view.Index', {
    extend: 'Ext.container.Viewport',
    initComponent: function () {
        var me = this;
        Ext.apply(me, {
            items: [me.getForm()]
        });
        me.callParent(arguments);
    },
    getForm: function () {
        var me = this;
        var form = {
            xtype: 'form',
            labelWidth: 75,
            url: '?do',
            frame: true,
            title: 'Login',
            width: 400,
            heigth: 260,
            bodyStyle: 'padding:5px 5px 0',
            buttonAlign: 'center',
            id: 'loginForm',
            componentCls: 'center',
            defaults: {
                width: 230
            },
            defaultType: 'textfield',

            items: [
                {
                    fieldLabel: 'Номер карты',
                    id: 'number',
                    name: 'number',
                    allowBlank: false,
                    cls: 'container-center'
                },
                {
                    fieldLabel: 'Пин код',
                    id: 'pin',
                    name: 'pin',
                    regex: new RegExp('(\\d){4}'),
                    allowBlank: false,
                    inputType: 'password',
                    cls: 'container-center'
                }
            ],
            buttons: [
                {
                    text: 'Войти',
                    id: 'enterBut',
                    handler: function () {
                        if (me.checkForm()) {
                            Ext.Ajax.request({
                                url: '?login',
                                metod: 'POST',
                                params: 'number=' + Ext.getCmp('number').value
                                    + '&pin=' + Ext.getCmp('pin').value,

                                success: function (response, opts) {
                                    var result = Ext.JSON
                                        .decode(response.responseText);
                                    if (result.success === 'false') {
                                        Ext.Msg.show({
                                            modal: true,
                                            title: 'Login error',
                                            msg: result.errors,
                                            icon: Ext.Msg.ERROR,
                                            buttons: Ext.Msg.OK
                                        });
                                    }
                                    if (result.success === 'true') {
                                        window.location = "/ATM/operations";
                                    }

                                },
                                failure: function (response, opts) {
                                    console
                                        .log('server-side failure with status code '
                                            + response.status);
                                }
                            });
                        }
                    }

                },
                {
                    text: 'Очистить',
                    handler: function () {
                        var login = Ext.getCmp('number');
                        var pass = Ext.getCmp('pin');
                        login.reset();
                        pass.reset();
                    }
                }
            ]
        }
        return form;
    },
    checkForm: function () {
        var logF = Ext.getCmp('number').getValue();
        var passF = Ext.getCmp('pin').getValue();
        if (!logF || !passF) {
            Ext.Msg.alert('Some errors were found!');
            return false;
        } else {
            return true;
        }
    }
});
Ext.onReady(function () {
    var my = new ATM.view.Index();
});