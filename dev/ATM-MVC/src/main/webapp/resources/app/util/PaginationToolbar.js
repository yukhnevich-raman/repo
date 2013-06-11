/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/15/13
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.util.PaginationToolbar', {
    extend: 'Ext.toolbar.Paging',
    xtype: 'pagination',
    initComponent: function () {
        var me = this;
        Ext.apply(me, {
            dock: 'bottom',
            displayInfo: true
        });
        me.callParent(arguments);
    }
});
