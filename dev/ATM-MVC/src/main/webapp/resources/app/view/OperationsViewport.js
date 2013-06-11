/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/4/13
 * Time: 5:09 PM
 */
Ext.define('ATM.view.OperationsViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'view.opviewport',

    initComponent: function () {
        var me = this;
        Ext.apply(me, {
            layout: 'border',
            items: [me.createBanner(), me.createNavigation(), me.createContentView()]
        });
        Ext.getCmp('balanceTab').on('activate', function () {
            Ext.getCmp('balanceGrid').getStore().load();
        });
        Ext.getCmp('historyTab').on('activate', function () {
            Ext.getCmp('historyGrid').getStore().load();
        });
        me.callParent(arguments);
    },
    createBanner: function () {
        return {
            xtype: 'toolbar',
            id: 'header',
            layout: {
                type: 'border'
            },
            region: 'north',
            margins: '0 0 5 0',
            html: 'National Bank Goleaf',
            items: [
                {
                    xtype: 'button',
                    region: 'east',
                    text: 'Выйти',
                    width: 80,
                    handler: function () {
                        window.location = "/ATM/logout";
                    }
                }
            ],
            height: 30,
            cls: 'x-panel-header-default banner-text'
        };
    },
    createNavigation: function () {
        this.navigateView = Ext.create('view.navigate', {
            region: 'west',
            collapsible: true,
            width: 250,
            split: true,
            minWidth: 200
        });
        return this.navigateView;
    },
    createContentView: function () {
        this.contentView = Ext.create('view.operations', {
            region: 'center',
            layout: 'fit',
            minWidth: 300
        });
        return this.contentView;
    }
});
Ext.onReady(function () {
    var main = new ATM.view.OperationsViewport();
});
