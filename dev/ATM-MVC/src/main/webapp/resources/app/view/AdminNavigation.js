/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/4/13
 * Time: 6:56 PM
 */
Ext.define('ATM.view.Navigation', {
        extend: 'Ext.panel.Panel',
        alias: 'view.anavigate',
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
                        text: 'Создать карту',
                        leaf: true,
                        action: 'NAV_CREATE'
                    },
                    {
                        text: 'Удалить карту',
                        leaf: true,
                        action: 'NAV_DELETE'
                    },
                    {
                        text: 'Разблокировать карту',
                        leaf: true,
                        action: 'NAV_UNLOCK'
                    }
                ]});
            return me.navTree;
        },
        doNavigate: function (navAction) {
            var create = Ext.getCmp('createPanel');
            var del = Ext.getCmp('deletePanel');
            var unlock = Ext.getCmp('unlockPanel');
            if (navAction == 'NAV_CREATE') {
                create.expand();
                del.collapse();
                unlock.collapse();
            }
            else if (navAction == 'NAV_DELETE') {
                create.collapse();
                del.expand();
                unlock.collapse();
            }
            else if (navAction == 'NAV_UNLOCK') {
                create.collapse();
                del.collapse();
                unlock.expand();
            }
        }
    }
);
