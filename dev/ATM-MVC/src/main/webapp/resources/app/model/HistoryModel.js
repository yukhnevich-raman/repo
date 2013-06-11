/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 4/15/13
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ATM.model.HistoryModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'amount', type: 'string'},
        {name: 'currency', type: 'string'},
        {name: 'from', type: 'string'},
        {name: 'to', type: 'string'},
        {name: 'date', type: 'string'}
    ]
})
