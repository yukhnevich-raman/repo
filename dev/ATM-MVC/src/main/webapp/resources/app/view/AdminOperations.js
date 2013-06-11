/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/19/13
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('E3S.view.AdminOperations', {
    extend: 'Ext.panel.Panel',
    alias: 'view.admin',
    initComponent: function () {
        var me = this;
        Ext.apply(me, {
            title: 'Операции',
            layout: {
                type: 'vbox',
                align: 'stretch',
                pack: 'start'
            },
            items: [
                {
                    xtype: 'panel',
                    collapsible: true,
                    collapsed: true,
                    draggable: true,
                    title: 'Создать карту',
                    id: 'createPanel',
                    height: 400,
                    items: [
                        {
                            xtype: 'form',
                            id: 'addForm',
                            cls: 'form',
                            method: 'POST',
                            url: 'admin/add',
                            items: [
                                {
                                    xtype: 'textfield',
                                    allowBlank: false,
                                    name: 'name',
                                    cls: 'container-center',
                                    fieldLabel: 'Имя владельца'

                                },
                                {
                                    xtype: 'textfield',
                                    allowBlank: false,
                                    name: 'surname',
                                    cls: 'container-center',
                                    fieldLabel: 'Фамилия владельца'

                                },
                                {
                                    xtype: 'textfield',
                                    allowBlank: false,
                                    name: 'pin',
                                    cls: 'container-center',
                                    fieldLabel: 'Пин код'

                                },
                                {
                                    xtype: 'textfield',
                                    allowBlank: false,
                                    name: 'amount',
                                    cls: 'container-center',
                                    fieldLabel: 'Сумма'

                                },
                                {
                                    xtype: 'combobox',
                                    store: new ATM.store.AdminCurrenciesStore(),
                                    fieldLabel: 'Валюта',
                                    allowBlank: false,
                                    cls: 'container-center',
                                    displayField: 'currency',
                                    valueField: 'currency',
                                    editable: false,
                                    name: 'currency'
                                },
                                {
                                    xtype: 'combobox',
                                    store: new ATM.store.BlockedStore(),
                                    fieldLabel: 'Блокировка',
                                    allowBlank: false,
                                    cls: 'container-center',
                                    displayField: 'state',
                                    valueField: 'state',
                                    editable: false,
                                    name: 'blocked'
                                }
                            ],
                            buttons: [
                                {
                                    xtype: 'button',
                                    text: 'Добавить',
                                    handler: function () {
                                        Ext.getCmp('addForm').getForm().submit({
                                            success: function (form, action) {
                                                Ext.Msg.alert('Result', action.result.result);
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('Error!', "Error!");
                                            }
                                        });
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Очистить',
                                    handler: function () {
                                        Ext.getCmp('addForm').getForm().reset();
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    collapsible: true,
                    collapsed: true,
                    title: 'Удалить карту',
                    id: 'deletePanel',
                    draggable: true,
                    height: 300,
                    items: [
                        {
                            xtype: 'form',
                            id: 'deleteForm',
                            cls: 'form',
                            method: 'POST',
                            url: 'admin/delete',
                            items: [
                                {
                                    xtype: 'combobox',
                                    id: 'allcardsCombo',
                                    store: new ATM.store.AllCardsStore(),
                                    fieldLabel: 'Удалить карту',
                                    allowBlank: false,
                                    cls: 'container-center',
                                    displayField: 'card',
                                    valueField: 'card',
                                    editable: false,
                                    name: 'id'
                                }
                            ],
                            buttons: [
                                {
                                    xtype: 'button',
                                    text: 'Удалить',
                                    handler: function () {
                                        Ext.getCmp('deleteForm').getForm().submit({
                                            success: function (form, action) {
                                                Ext.Msg.alert('Result', action.result.result);
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('Error!', "Error!");
                                            }
                                        });
                                        Ext.getCmp('allcardsCombo').getStore().load();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Очистить',
                                    handler: function () {
                                        Ext.getCmp('deleteForm').getForm().reset();
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    collapsible: true,
                    collapsed: true,
                    draggable: true,
                    title: 'Разблокировать карту',
                    id: 'unlockPanel',
                    height: 300,
                    items: [
                        {
                            xtype: 'form',
                            id: 'unblockForm',
                            cls: 'form',
                            method: 'POST',
                            url: 'admin/unblock',
                            items: [
                                {
                                    xtype: 'combobox',
                                    store: new ATM.store.BlockedCardsStore(),
                                    id: 'ublockCardsCombo',
                                    fieldLabel: 'Разблокировать карту',
                                    labelPad: 20,
                                    allowBlank: false,
                                    cls: 'container-center',
                                    displayField: 'card',
                                    valueField: 'card',
                                    editable: false,
                                    name: 'id'
                                }
                            ],
                            buttons: [
                                {
                                    xtype: 'button',
                                    text: 'Разблокировать',
                                    handler: function () {
                                        Ext.getCmp('unblockForm').getForm().submit({
                                            success: function (form, action) {
                                                Ext.Msg.alert('Result', action.result.result);
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('Error!', "Error!");
                                            }
                                        });
                                        Ext.getCmp('unblockCardsCombo').getStore().load();
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Очистить',
                                    handler: function () {
                                        Ext.getCmp('unblockForm').getForm().reset();
                                    }
                                }
                            ]
                        }
                    ]
                }
            ]
        });
        me.callParent(arguments);
    }
});
