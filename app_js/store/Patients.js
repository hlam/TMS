Ext.define('WebApp.store.Patients', {
    extend: 'Ext.data.Store',
    //autoLoad: true,

    model: 'WebApp.model.Patient',
    pageSize: 50,
    remoteSort: true
});

