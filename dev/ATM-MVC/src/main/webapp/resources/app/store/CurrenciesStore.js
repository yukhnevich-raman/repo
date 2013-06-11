/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/17/13
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.store.CurrenciesStore', {
    extend: 'Ext.data.Store',
    model: 'ATM.model.CurrenciesModel',
    proxy: {
        type: 'ajax',
        url: 'currencies',
        reader: {
            type: 'json',
            root: 'currencies'
        }
    },
    autoLoad: true
});
