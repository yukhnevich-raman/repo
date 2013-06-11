/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/10/13
 * Time: 7:41 PM
 */
Ext.define('ATM.model.BalanceModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'string'},
        {name: 'name', type: 'string'},
        {name: 'surname', type: 'string'},
        {name: 'amount', type: 'string'},
        {name: 'currency', type: 'string'}
    ]
})