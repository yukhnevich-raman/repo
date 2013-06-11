/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/17/13
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.store.TransferCardsStore', {
    extend: 'Ext.data.Store',
    model: 'ATM.model.TransferCardsModel',
    proxy: {
        type: 'ajax',
        url: 'transfercards',
        reader: {
            type: 'json',
            root: 'cards'
        }
    },
    autoLoad: true
});
