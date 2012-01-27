Ext.define('WebApp.store.comboPatients', {
    extend: 'Ext.data.Store',
    //autoLoad: true,

    model: 'WebApp.model.comboPatient',
    pageSize: 10
});
