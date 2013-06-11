/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/15/13
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.store.HistoryStore', {
    extend: 'Ext.data.Store',
    model: 'ATM.model.HistoryModel',
    pageSize: 5,
    proxy: {
        type: 'ajax',
        url: 'history',
        reader: {
            type: 'json',
            root: 'history',
            totalProperty: 'total'
        }
    },
    autoLoad: true,
    autoSync: true,
    clearOnPageLoad: true
});
