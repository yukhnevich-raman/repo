Ext.define('ATM.view.Admin', {
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
            url: 'administrate',
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
                    fieldLabel: 'Логин',
                    id: 'login',
                    name: 'login',
                    allowBlank: false,
                    cls: 'container-center'
                },
                {
                    fieldLabel: 'Пароль',
                    id: 'pass',
                    name: 'pass',
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
                        Ext.getCmp('loginForm').getForm().submit({
                            success: function (form, action) {
                                window.location = 'admin';
                            },
                            failure: function (form, action) {
                                Ext.Msg.alert('Error!', "Неверное имя пользователя или пароль!");
                                form.getForm().reset();
                            }
                        })
                    }
                },
                {
                    text: 'Очистить',
                    handler: function () {
                        form.getForm().reset();
                    }
                }
            ]
        }
        return form;
    }

});
Ext.onReady(function () {
    new ATM.view.Admin();
});