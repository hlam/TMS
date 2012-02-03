Ext.define('WebApp.store.ComboPatients', {
    extend: 'Ext.data.Store',
    //autoLoad: true,

    model: 'WebApp.model.ComboPatient',
    pageSize: 10
});
