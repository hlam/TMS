Ext.define('WebApp.store.Consultations', {
    extend: 'Ext.data.Store',
    //autoLoad: true,

    model: 'WebApp.model.Consultation',
    pageSize: 50,
    remoteSort: true
});

