/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/17/13
 * Time: 12:09 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.store.AdminCurrenciesStore', {
    extend: 'Ext.data.Store',
    model: 'ATM.model.CurrenciesModel',
    proxy: {
        type: 'ajax',
        url: 'admin/currencies',
        reader: {
            type: 'json',
            root: 'currencies'
        }
    },
    autoLoad: true
});
