Ext.define('WebApp.store.Customers', {
    extend: 'Ext.data.Store',
    //autoLoad: true,

    model: 'WebApp.model.Customer',
    pageSize: 50,
    remoteSort: true
});

