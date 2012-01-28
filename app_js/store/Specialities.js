Ext.define('WebApp.store.Specialities', {
    extend: 'Ext.data.Store',
    autoLoad: true,
    model: 'WebApp.model.Speciality',
    buffered:true,
    pageSize:50
});
