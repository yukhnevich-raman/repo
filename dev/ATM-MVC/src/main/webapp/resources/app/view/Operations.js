Ext.define('ATM.view.Operations', {
    extend: 'Ext.tab.Panel',
    alias: 'view.operations',
    initComponent: function () {
        var me = this;
        me.historyStore = new ATM.store.HistoryStore();
        Ext.apply(me, {
            id: 'operationsTabs',
            items: [
                {
                    title: 'Баланс',
                    id: 'balanceTab',
                    items: [
                        {
                            xtype: 'grid',
                            id: 'balanceGrid',
                            store: new ATM.store.BalanceStore(),
                            width: 750,
                            columnLines: true,
                            columns: [
                                {
                                    text: 'Номер карты',
                                    width: 150,
                                    dataIndex: 'id'
                                },
                                {
                                    text: 'Имя держателя',
                                    width: 150,
                                    dataIndex: 'name'
                                },
                                {
                                    text: 'Фамилия держателя',
                                    width: 150,
                                    dataIndex: 'surname'
                                },
                                {
                                    text: 'Сумма',
                                    width: 150,
                                    dataIndex: 'amount'
                                },
                                {
                                    text: 'Валюта',
                                    width: 150,
                                    dataIndex: 'currency'
                                }
                            ]


                        }
                    ]

                },
                {
                    title: 'Платежи',
                    id: 'paysTab',
                    items: [
                        {
                            xtype: 'form',
                            id: 'paysForm',
                            method: 'POST',
                            cls: 'form',
                            url: 'pay',
                            items: [
                                {
                                    xtype: 'textfield',
                                    name: 'amount',
                                    cls: 'container-center',
                                    fieldLabel: 'Сумма',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    name: 'to',
                                    cls: 'container-center',
                                    fieldLabel: 'Расчетный счет',
                                    allowBlank: false
                                },
                                {
                                    xtype: 'textfield',
                                    name: 'description',
                                    cls: 'container-center',
                                    fieldLabel: 'Назначение платежа',
                                    allowBlank: false
                                }

                            ],
                            buttons: [
                                {
                                    xtype: 'button',
                                    text: 'Оплатить',
                                    handler: function () {
                                        Ext.getCmp('paysForm').getForm().submit({
                                            success: function (form, action) {
                                                Ext.Msg.alert('Result', 'Платеж успешно завершен');
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('Error!', action.result.result);
                                            }
                                        });
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Очистить',
                                    handler: function () {
                                        Ext.getCmp('paysForm').getForm().reset();
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    title: 'Перевод денег',
                    id: 'transferTab',
                    items: [
                        {
                            xtype: 'form',
                            id: 'transferForm',
                            cls: 'form',
                            method: 'POST',
                            url: 'transfer',
                            items: [
                                {
                                    xtype: 'combobox',
                                    store: new ATM.store.TransferCardsStore(),
                                    fieldLabel: 'Перевести на карту',
                                    allowBlank: false,
                                    cls: 'container-center',
                                    displayField: 'card',
                                    valueField: 'card',
                                    editable: false,
                                    name: 'to'
                                },
                                {
                                    xtype: 'textfield',
                                    cls: 'container-center',
                                    allowBlank: false,
                                    fieldLabel: 'Сумма',
                                    name: 'amount'
                                }
                            ],
                            buttons: [
                                {
                                    xtype: 'button',
                                    text: 'Перевести',
                                    handler: function () {
                                        Ext.getCmp('transferForm').getForm().submit({
                                            success: function (form, action) {
                                                Ext.Msg.alert('Result', action.result.result);
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('Error!', action.result.result);
                                            }
                                        });
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Очистить',
                                    handler: function () {
                                        Ext.getCmp('transferForm').getForm().reset();
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    title: 'История операций',
                    id: 'historyTab',
                    items: [
                        {
                            xtype: 'grid',
                            store: this.historyStore,
                            columnLines: true,
                            id: 'historyGrid',
                            loadMask: true,
                            width: 750,
                            height: 400,
                            columns: [
                                {
                                    text: 'Сумма',
                                    width: 150,
                                    dataIndex: 'amount'
                                },
                                {
                                    text: 'Валюта',
                                    width: 150,
                                    dataIndex: 'currency'
                                },
                                {
                                    text: 'C карты',
                                    width: 150,
                                    dataIndex: 'from'
                                },
                                {
                                    text: 'На карту',
                                    width: 150,
                                    dataIndex: 'to'
                                },
                                {
                                    text: 'Дата транзакции',
                                    width: 150,
                                    dataIndex: 'date'
                                }
                            ],
                            dockedItems: [
                                {
                                    xtype: 'pagination',
                                    store: this.historyStore
                                }
                            ]


                        }
                    ]
                },
                {
                    title: 'Калькулятор валют',
                    id: 'calculatorTab',
                    items: [
                        {
                            xtype: 'form',
                            id: 'calculatorForm',
                            cls: 'form',
                            method: 'POST',
                            url: 'exchange',
                            items: [
                                {
                                    xtype: 'combobox',
                                    store: new ATM.store.CurrenciesStore(),
                                    fieldLabel: 'Из',
                                    cls: 'container-center',
                                    allowBlank: false,
                                    displayField: 'currency',
                                    valueField: 'currency',
                                    editable: false,
                                    name: 'from'
                                },
                                {
                                    xtype: 'combobox',
                                    store: new ATM.store.CurrenciesStore(),
                                    fieldLabel: 'В',
                                    allowBlank: false,
                                    cls: 'container-center',
                                    displayField: 'currency',
                                    valueField: 'currency',
                                    editable: false,
                                    name: 'to'
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Сумма',
                                    allowBlank: false,
                                    cls: 'container-center',
                                    name: 'amount'
                                }
                            ],
                            buttons: [
                                {
                                    xtype: 'button',
                                    text: 'Посчитать',
                                    handler: function () {
                                        Ext.getCmp('calculatorForm').getForm().submit({
                                            success: function (form, action) {
                                                Ext.Msg.alert('Result', action.result.result);
                                            },
                                            failure: function (form, action) {
                                                Ext.Msg.alert('Error!');
                                            }
                                        });
                                    }
                                },
                                {
                                    xtype: 'button',
                                    text: 'Очистить',
                                    handler: function () {
                                        Ext.getCmp('calculatorForm').getForm().reset();
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
