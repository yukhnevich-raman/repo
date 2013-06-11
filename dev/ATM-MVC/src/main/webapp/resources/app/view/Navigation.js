/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/4/13
 * Time: 6:56 PM
 */
Ext.define('ATM.view.Navigation', {
        extend: 'Ext.panel.Panel',
        alias: 'view.navigate',
        layout: 'fit',
        title: 'Навигация',

        initComponent: function () {
            var me = this;
            Ext.apply(me, {
                items: me.createView()
            });
            me.callParent(arguments);
        },
        createView: function () {
            var me = this;
            me.navTree = Ext.create('Ext.tree.Panel', {
                border: 0,
                listeners: {
                    itemclick: {
                        fn: function (view, record, item, index, eventObj) {
                            if (record.raw && record.raw.action) {
                                me.doNavigate(record.raw.action);
                            }
                        }
                    }
                }
            });
            me.navTree.setRootNode({
                text: 'Операции',
                expanded: true,
                children: [
                    {
                        text: 'Баланс',
                        leaf: true,
                        action: 'NAV_BALANCE'
                    },
                    {
                        text: 'Платежи',
                        leaf: true,
                        action: 'NAV_PAYS'
                    },
                    {
                        text: 'Перевод денег',
                        leaf: true,
                        action: 'NAV_TRANSFER'
                    },
                    {
                        text: 'История операций',
                        leaf: true,
                        action: 'NAV_HISTORY'
                    },
                    {
                        text: 'Калькулятор валют',
                        leaf: true,
                        action: 'NAV_CALCULATOR'
                    }
                ]});
            return me.navTree;
        },
        doNavigate: function (navAction) {
            var tabPanel = Ext.getCmp('operationsTabs');
            if (navAction == 'NAV_BALANCE') {
                tabPanel.setActiveTab('balanceTab');
            }
            else if (navAction == 'NAV_PAYS') {
                tabPanel.setActiveTab('paysTab');
            }
            else if (navAction == 'NAV_TRANSFER') {
                tabPanel.setActiveTab('transferTab');
            }
            else if (navAction == 'NAV_HISTORY') {
                tabPanel.setActiveTab('historyTab');
            }
            else if (navAction == 'NAV_CALCULATOR') {
                tabPanel.setActiveTab('calculatorTab');
            }
        }
    }
);
