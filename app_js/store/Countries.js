Ext.define('WebApp.store.Countries', {
    extend: 'Ext.data.Store',
    autoLoad: true,
    model: 'WebApp.model.Country',
    buffered:true,
    pageSize:50
});
