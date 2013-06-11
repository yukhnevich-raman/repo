/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/17/13
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.store.BlockedStore', {
    extend: 'Ext.data.Store',
    model: 'ATM.model.BlockedModel',
    proxy: {
        type: 'ajax',
        url: 'admin/blocked',
        reader: {
            type: 'json',
            root: 'blocked'
        }
    },
    autoLoad: true
});
