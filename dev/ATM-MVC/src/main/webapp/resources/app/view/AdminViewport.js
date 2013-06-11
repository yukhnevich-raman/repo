/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/19/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.view.AdminViewport', {
    extend: 'Ext.container.Viewport',
    alias: 'view.adminviewport',

    initComponent: function () {
        var me = this;
        Ext.apply(me, {
            layout: 'border',
            items: [me.createBanner(), me.createNavigation(), me.createContentView()]
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
            html: 'Панель администратора',
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
        this.navigateView = Ext.create('view.anavigate', {
            region: 'west',
            collapsible: true,
            width: 250,
            split: true,
            minWidth: 200
        });
        return this.navigateView;
    },
    createContentView: function () {
        this.contentView = Ext.create('view.admin', {
            region: 'center',
            layout: 'fit',
            minWidth: 300
        });
        return this.contentView;
    }
});
Ext.onReady(function () {
    new ATM.view.AdminViewport();
});
