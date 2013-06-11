/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/14/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.store.BalanceStore', {
    extend: 'Ext.data.Store',
    model: 'ATM.model.BalanceModel',
    proxy: {
        type: 'ajax',
        url: 'balance',
        reader: {
            type: 'json',
            root: 'card'
        }
    },
    autoLoad: true
});